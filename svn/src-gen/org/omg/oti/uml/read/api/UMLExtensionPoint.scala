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
import org.omg.oti.uml.read.operations.UMLExtensionPointOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ExtensionPoint identifies a point in the behavior of a UseCase where that behavior can be extended by the behavior of some other (extending) UseCase, as specified by an Extend relationship.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtensionPoint[Uml <: UML]
  extends UMLRedefinableElement[Uml]
  with UMLExtensionPointOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for extensionLocation_extension -->
    * <!-- End of user code doc for extensionLocation_extension -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtend.extensionLocation
    */
  def extensionLocation_extension: Set[UMLExtend[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      extensionPoint_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExtensionPoint
    *
    * <!-- Start of user code doc for extensionPoint_metaAttributes -->
    * <!-- End of user code doc for extensionPoint_metaAttributes -->
    */
  def extensionPoint_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     redefinableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    extensionPoint_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExtensionPoint
    *
    * <!-- Start of user code doc for extensionPoint_compositeMetaProperties -->
    * <!-- End of user code doc for extensionPoint_compositeMetaProperties -->
    */
  def extensionPoint_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    extensionPoint_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExtensionPoint
    *
    * <!-- Start of user code doc for extensionPoint_referenceMetaProperties -->
    * <!-- End of user code doc for extensionPoint_referenceMetaProperties -->
    */
  def extensionPoint_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      redefinableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    extensionPoint_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExtensionPoint
    *
    * <!-- Start of user code doc for extensionPoint_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for extensionPoint_forwardReferencesFromMetamodelAssociations -->
    */
  def extensionPoint_forwardReferencesFromMetamodelAssociations: Elements =
    redefinableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLExtensionPoint
