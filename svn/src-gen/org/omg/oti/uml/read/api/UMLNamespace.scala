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

package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLNamespaceOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Namespace is an Element in a model that owns and/or imports a set of NamedElements that can be identified by name.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLNamespace[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLNamespaceOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by importing or inheritance.
    *
    * <!-- Start of user code doc for member -->
    * <!-- End of user code doc for member -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.member_memberNamespace
    */
  def member: Set[UMLNamedElement[Uml]]

  /**
    * A collection of NamedElements owned by the Namespace.
    *
    * <!-- Start of user code doc for ownedMember -->
    * <!-- End of user code doc for ownedMember -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.namespace
    */
  def ownedMember: Set[UMLNamedElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      namespace_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLNamespace
    *
    * <!-- Start of user code doc for namespace_metaAttributes -->
    * <!-- End of user code doc for namespace_metaAttributes -->
    */
  def namespace_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    namespace_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLNamespace
    *
    * <!-- Start of user code doc for namespace_compositeMetaProperties -->
    * <!-- End of user code doc for namespace_compositeMetaProperties -->
    */
  def namespace_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Namespace_elementImport,
      	Namespace_ownedDiagram,
      	Namespace_ownedRule,
      	Namespace_packageImport))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    namespace_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLNamespace
    *
    * <!-- Start of user code doc for namespace_referenceMetaProperties -->
    * <!-- End of user code doc for namespace_referenceMetaProperties -->
    */
  def namespace_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    namespace_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLNamespace
    *
    * <!-- Start of user code doc for namespace_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for namespace_forwardReferencesFromMetamodelAssociations -->
    */
  def namespace_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLNamespace
