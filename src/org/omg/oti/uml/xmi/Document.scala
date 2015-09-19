/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.xmi

import java.net.URI
import org.omg.oti.uml.read.api.{UML, UMLElement}
import org.omg.oti.uml.read.operations.UMLOps

import scala.Predef.String
import scala.collection.immutable.Set

/**
 * Corresponds to OMG XMI 2.5.1 Document combined with OMG MOF 2.5 Extent.
 *
 * The OMG XMI specification defines the mapping of MOF models to XMI Documents.
 *
 * Although the OMG XMI specification refers to several important characteristics of XMI Documents;
 * there is surprisingly no abstract syntax specification for what an XMI Document is.
 *
 * Although the OMG XMI specification defines the mapping between MOF models and XMI Documents,
 * the specification does not address the practical aspects of managing such mappings.
 * In principle, the OMG XMI specification allows multiple mappings from the same MOF model to multiple XMI Documents.
 * In practice, most implementations of OMG UML 2.5 assume a 1-1 mapping between a MOF model and an XMI Document.
 *
 * The OTI concept of XMI Document reflects a 1-1 mapping between a MOF model and an XMI Document.
 * The MOF model associated to an XMI Document is specified in terms of the root element `scope`.
 * To simplify matters of inter-document linking (see OMG XMI 2.5.1, section 7.10), an OTI XMI Document
 * includes a `documentURL` to specify the external URI where the document is published and the `uri` of the root element.
 *
 * Notes:
 *   - OMG XMI 2.5.1, formal/15-06-07 lacks a definition of XMI Document and of XMI Schema
 *   - OMG XMI 2.5, ptc/14-09-21, Section 4 defines the following:
 *
 *      > [XMIDocument] A document produced by the XMI production rules defined in this International Standard.
 *      > [XMISchema] A schema produced by the XMI production rules defined in this International Standard.
 *
 * @todo Consider restricting the type of `scope` from UMLElement to UMLPackage.
 *       In principle, the OMG XMI specification allows an arbitrary element to be the root of an XMI Document.
 *       However, it is unclear how this works... In practice, the OTI effectively requires the root to be a UMLPackage.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
abstract trait Document[Uml <: UML] {
  implicit val ops: UMLOps[Uml]
  val uri: URI
  val nsPrefix: String
  val uuidPrefix: String

  /**
   * The official URI where this document is published as a resource that can be referenced by other documents
   * and whose contents can be referenced starting from this URI
   */
  val documentURL: URI

  /**
   * The root element defining the containment scope of this document
   */
  val scope: UMLElement[Uml]

  /**
   * The set of all elements directly or indirectly owned by `scope`, including `scope`
   *
   * @return The reflexive, transitive closure of containment from `scope`
   */
  def extent: Set[UMLElement[Uml]]
}

/**
 * A kind of Document corresponding to a tool-specific implementation of an OMG-published XMI Document
 * and whose extent may be partially represented.
 *
 * (e.g., [[http://www.omg.org/spec/UML/20131001/PrimitiveTypes.xmi OMG UML 2.5's PrimitiveTypes library]])
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
trait BuiltInDocument[Uml <: UML] extends Document[Uml] {
  /**
   * The extent of a built-in document, which is a tool-specific representation of a published document.
   * This extent may be a partial representation of the full extent of the published document.
   */
  val builtInExtent: Set[UMLElement[Uml]]

  override def extent = builtInExtent
}

/**
 * A kind of Document whose extent is completely represented.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
trait SerializableDocument[Uml <: UML] extends Document[Uml] {
   
  override lazy val extent: Set[UMLElement[Uml]] = 
    Set(scope) ++ scope.allOwnedElements

 }