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
import org.omg.oti.uml.read.operations.UMLTypeOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Type constrains the values represented by a TypedElement.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLType[Uml <: UML]
  extends UMLPackageableElement[Uml]
  with UMLTypeOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * Specifies the owning Package of this Type, if any.
    *
    * <!-- Start of user code doc for _package -->
    * <!-- End of user code doc for _package -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.ownedType
    */
  def _package: Option[UMLPackage[Uml]]

  /**
    * <!-- Start of user code doc for raisedException_behavioralFeature -->
    * <!-- End of user code doc for raisedException_behavioralFeature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioralFeature.raisedException
    */
  def raisedException_behavioralFeature: Set[UMLBehavioralFeature[Uml]]

  /**
    * <!-- Start of user code doc for type_operation -->
    * <!-- End of user code doc for type_operation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation._type
    */
  def type_operation: Set[UMLOperation[Uml]]

  /**
    * <!-- Start of user code doc for type_typedElement -->
    * <!-- End of user code doc for type_typedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTypedElement._type
    */
  def type_typedElement: Set[UMLTypedElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      type_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLType
    *
    * <!-- Start of user code doc for type_metaAttributes -->
    * <!-- End of user code doc for type_metaAttributes -->
    */
  def type_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    type_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLType
    *
    * <!-- Start of user code doc for type_compositeMetaProperties -->
    * <!-- End of user code doc for type_compositeMetaProperties -->
    */
  def type_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    type_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLType
    *
    * <!-- Start of user code doc for type_referenceMetaProperties -->
    * <!-- End of user code doc for type_referenceMetaProperties -->
    */
  def type_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    type_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLType
    *
    * <!-- Start of user code doc for type_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for type_forwardReferencesFromMetamodelAssociations -->
    */
  def type_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLType
