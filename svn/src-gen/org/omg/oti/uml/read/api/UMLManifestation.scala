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
import org.omg.oti.uml.read.operations.UMLManifestationOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A manifestation is the concrete physical rendering of one or more model elements by an artifact.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLManifestation[Uml <: UML]
  extends UMLAbstraction[Uml]
  with UMLManifestationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The model element that is utilized in the manifestation in an Artifact.
    *
    * <!-- Start of user code doc for utilizedElement -->
    * <!-- End of user code doc for utilizedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageableElement.utilizedElement_manifestation
    */
  def utilizedElement: Option[UMLPackageableElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      manifestation_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLManifestation
    *
    * <!-- Start of user code doc for manifestation_metaAttributes -->
    * <!-- End of user code doc for manifestation_metaAttributes -->
    */
  def manifestation_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     abstraction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    manifestation_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLManifestation
    *
    * <!-- Start of user code doc for manifestation_compositeMetaProperties -->
    * <!-- End of user code doc for manifestation_compositeMetaProperties -->
    */
  def manifestation_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      abstraction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    manifestation_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLManifestation
    *
    * <!-- Start of user code doc for manifestation_referenceMetaProperties -->
    * <!-- End of user code doc for manifestation_referenceMetaProperties -->
    */
  def manifestation_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      abstraction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Manifestation_utilizedElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    manifestation_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLManifestation
    *
    * <!-- Start of user code doc for manifestation_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for manifestation_forwardReferencesFromMetamodelAssociations -->
    */
  def manifestation_forwardReferencesFromMetamodelAssociations: Elements =
    abstraction_forwardReferencesFromMetamodelAssociations ++
    utilizedElement

  // Start of user code for additional features
  // End of user code
} //UMLManifestation
