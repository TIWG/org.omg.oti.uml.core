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
import org.omg.oti.uml.read.operations.UMLStereotypeOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A stereotype defines how an existing metaclass may be extended, and enables the use of platform or domain specific terminology or notation in place of, or in addition to, the ones used for the extended metaclass.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStereotype[Uml <: UML]
  extends UMLClass[Uml]
  with UMLStereotypeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * <!-- Start of user code doc for ownedStereotype_owningPackage -->
    * <!-- End of user code doc for ownedStereotype_owningPackage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.ownedStereotype
    */
  def ownedStereotype_owningPackage: Option[UMLPackage[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      stereotype_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStereotype
    *
    * <!-- Start of user code doc for stereotype_metaAttributes -->
    * <!-- End of user code doc for stereotype_metaAttributes -->
    */
  def stereotype_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     class_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    stereotype_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStereotype
    *
    * <!-- Start of user code doc for stereotype_compositeMetaProperties -->
    * <!-- End of user code doc for stereotype_compositeMetaProperties -->
    */
  def stereotype_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      class_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Stereotype_icon))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    stereotype_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStereotype
    *
    * <!-- Start of user code doc for stereotype_referenceMetaProperties -->
    * <!-- End of user code doc for stereotype_referenceMetaProperties -->
    */
  def stereotype_referenceMetaProperties: MetaPropertyFunctions = 
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
    stereotype_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStereotype
    *
    * <!-- Start of user code doc for stereotype_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for stereotype_forwardReferencesFromMetamodelAssociations -->
    */
  def stereotype_forwardReferencesFromMetamodelAssociations: Elements =
    class_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLStereotype
