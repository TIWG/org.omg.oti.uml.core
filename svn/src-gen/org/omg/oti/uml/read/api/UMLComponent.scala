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
import org.omg.oti.uml.read.operations.UMLComponentOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Component represents a modular part of a system that encapsulates its contents and whose manifestation is replaceable within its environment.  
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLComponent[Uml <: UML]
  extends UMLClass[Uml]
  with UMLComponentOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If true, the Component is defined at design-time, but at run-time (or execution-time) an object specified by the Component does not exist, that is, the Component is instantiated indirectly, through the instantiation of its realizing Classifiers or parts.
    *
    * <!-- Start of user code doc for isIndirectlyInstantiated -->
    * <!-- End of user code doc for isIndirectlyInstantiated -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isIndirectlyInstantiated: Boolean

  /**
    * The set of PackageableElements that a Component owns. In the namespace of a Component, all model elements that are involved in or related to its definition may be owned or imported explicitly. These may include e.g., Classes, Interfaces, Components, Packages, UseCases, Dependencies (e.g., mappings), and Artifacts.
    *
    * <!-- Start of user code doc for packagedElement -->
    * <!-- End of user code doc for packagedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageableElement.packagedElement_component
    */
  def packagedElement: Set[UMLPackageableElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      component_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLComponent
    *
    * <!-- Start of user code doc for component_metaAttributes -->
    * <!-- End of user code doc for component_metaAttributes -->
    */
  def component_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     class_metaAttributes,
     Seq[MetaAttributeFunction](Component_isIndirectlyInstantiated))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    component_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLComponent
    *
    * <!-- Start of user code doc for component_compositeMetaProperties -->
    * <!-- End of user code doc for component_compositeMetaProperties -->
    */
  def component_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      class_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Component_packagedElement,
      	Component_realization))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    component_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLComponent
    *
    * <!-- Start of user code doc for component_referenceMetaProperties -->
    * <!-- End of user code doc for component_referenceMetaProperties -->
    */
  def component_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      class_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    component_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLComponent
    *
    * <!-- Start of user code doc for component_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for component_forwardReferencesFromMetamodelAssociations -->
    */
  def component_forwardReferencesFromMetamodelAssociations: Elements =
    class_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLComponent
