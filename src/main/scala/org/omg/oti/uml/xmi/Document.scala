/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.xmi

import org.omg.oti.json.common.OTISpecificationRootCharacteristics
import org.omg.oti.uml.RelationTriple
import org.omg.oti.uml.read.api.{UML, UMLElement, UMLPackage}
import org.omg.oti.uml.read.operations.UMLOps

import scala.collection.immutable._
import scala.{Boolean,Enumeration}

object DocumentKind extends Enumeration {
  type DocumentKind = Value
  val BuiltInImmutable, BuiltInMutable, SerializableImmutable, SerializableMutable, LoadingMutable = Value
  
  def isImmutable(kind: DocumentKind): Boolean =
    BuiltInImmutable == kind || SerializableImmutable == kind
      
  def isSerializable(kind: DocumentKind): Boolean =
    SerializableImmutable == kind || SerializableMutable == kind
    
  def isLoading(kind: DocumentKind): Boolean =
    LoadingMutable == kind
}

import DocumentKind._

/**
  * An OTI Document corresponds to an OMG MOF 2.5.1 Extent and provides support OTI Document services.
  *
  * OTI Document-related services include, but are not limited to:
  * - serialization/export/save & deserialization/import/load, 
  * - inter-document cross-reference analysis for managing graphs of documents (acyclic or circular)
  * - preventing update operations on elements in immutable documents
  * 
  * The topology of cross-references amongst OTI Documents (mutable or not) is an important
  * consideration for the safety of loading/saving OTI Documents in general.
  * 
  * These operations are simpler when the topology is acyclic because the OTI Documents
  * can be ordered to ensure that loading or saving an OTI Document happens
  * after loading or saving the other cross-referenced OTI Documents.
  * In contrast, loading/saving OTI Documents with circular cross-references requires special handling
  * for the case where a cross-reference refers to an OTI Document that has not yet been loaded/saved.
  *
  * These operations are more complex when the topology is circular or when OTI Documents are mutable.
  * Although the OMG XMI specification defines the mapping between MOF models and XMI Documents,
  * the specification does not address several important practical considerations, such as:
  * - no abstract syntax for the information necessary for the serialization of OMG MOF Extents
  *   (e.g., xmi:id, xmi:uuid)
  * - no abstract syntax for the information necessary for the identification of serialized XMI Documents
  *   (e.g., document URL, namespace prefix)
  * - unclear relationship between OMG MOF Extent and the scope of export (serialization) in OMG XMI 2.5.1
  * - no process for importing (deserializing) an XMI Document into an OMG MOF Extent
  *   (the OMG XMI specification defines the export (serialization) of an OMG MOF Extent to an XMI Document)
  *
  * Notes:
  * - OMG XMI 2.5.1, formal/15-06-07 lacks a definition of XMI Document and of XMI Schema
  * - OMG XMI 2.5, ptc/14-09-21, Section 4 defines the following:
  *
  *      > [XMIDocument] A document produced by the XMI production rules defined in this International Standard.
  *      > [XMISchema] A schema produced by the XMI production rules defined in this International Standard.
  *
  * - OMG XMI 2.5.1 Section 9.1 states:
  *      > This clause specifies the XMI production of an XML document from a model based on the MOF 2 Core. 
  *   
  *      Unfortunately, it is unclear what "a model based on the MOF 2 Core" actually is.
  *      Is an model element that is an instance of any concrete MOF metaclass a legitimate "model"?
  *  
  * OTI reflects a deliberate choice to restrict the use of OMG specifications in the following way:
  * - an OTI Document is scoped by a UML Package
  *   That is, OMG XMI 2.5.1 section 9 is effectively restricted to serializing the scope of a UML Package
  *   as the root of the XML Document produced. This choice reflects the fact that the UML Package::URI
  *   plays an important role for the identification of elements across documents.
  * - an OTI Document Package Scope corresponds to an OMG MOF 2.5.1 Extent, which is the basis
  *   for identifying elements within it.
  *
  * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
  */
abstract trait Document[Uml <: UML] {
  implicit val ops: UMLOps[Uml]

  type DocumentRelationTriple = RelationTriple[Uml]
  type DocumentEdgeTriples = Set[DocumentRelationTriple]

  val info: OTISpecificationRootCharacteristics

  def kind: DocumentKind
  
  /**
   * The location where this document is published as
   * a loadable resource that can be referenced by other documents
   * and whose contents can be referenced starting from this URI
   *
   * This location also includes support for specifying
   * the tool-specific location of the document
   * after it has been imported via the tool-specific
   * OTI load adater.
   */
  val documentURL: Uml#LoadURL

  /**
   * The root element defining the containment scope of this document
   */
  val scope: UMLPackage[Uml]

  /**
    * @param e a UML Element
    * @return True if `e` is within the extent of this Document
    */
  def includes(e: UMLElement[Uml]): Boolean
  
  def extent: scala.collection.Iterable[UMLElement[Uml]]
}

/**
  * A MutableDocument corresponds to an OMG MOF 2.5.1 Extent that is subject to change.
  * 
  * It is currently outside the scope of the OTI to ensure that load/save operations
  * involving OTI MutableDocuments are serialized with respect to OTI model update operations.
  *
  * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
  */
abstract trait MutableDocument[Uml <: UML] 
extends Document[Uml] {
  
  override def includes(e: UMLElement[Uml]): Boolean = {
    val ee = extent.find(_ == e)
    ee.isDefined
  }
}

/**
  * An ImmutableDocument corresponds to an OMG MOF 2.5.1 Extent that cannot change.
  *
  * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
  */
abstract trait ImmutableDocument[Uml <: UML] 
extends Document[Uml] {
  
  override def includes(e: UMLElement[Uml]): Boolean = {
    val included = extent.contains(e)
    included
  }
    
  /**
   * The set of all elements directly or indirectly owned by `scope`, including `scope`
   *
   * @return The reflexive, transitive closure of containment from `scope`
   */
  override val extent: Set[UMLElement[Uml]]
}

/**
 * A kind of Document corresponding to a tool-specific implementation of an OMG-published XMI Document
 * and whose extent may be partially represented. Typically, a BuiltInDocument is a tool-specific
 * representation of a published Document (e.g., from the OMG).
 *
 * (e.g., [[http://www.omg.org/spec/UML/20131001/PrimitiveTypes.xmi OMG UML 2.5's PrimitiveTypes library]])
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
abstract trait BuiltInDocument

/**
 * A kind of Document whose extent is completely represented.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
abstract trait SerializableDocument

trait BuiltInImmutableDocument[Uml <: UML]
extends ImmutableDocument[Uml]
with BuiltInDocument {
   
  override val kind: DocumentKind = BuiltInImmutable

}

trait BuiltInMutableDocument[Uml <: UML]
extends MutableDocument[Uml]
with BuiltInDocument {
   
  override val kind: DocumentKind = BuiltInMutable

}

trait SerializableImmutableDocument[Uml <: UML] 
extends ImmutableDocument[Uml]
with SerializableDocument {
   
  override val kind: DocumentKind = SerializableImmutable

}

trait SerializableMutableDocument[Uml <: UML] 
extends MutableDocument[Uml]
with SerializableDocument {
   
  override val kind: DocumentKind = SerializableMutable

}

trait LoadingMutableDocument[Uml <: UML] 
extends MutableDocument[Uml] {
   
  override val kind: DocumentKind = LoadingMutable

}