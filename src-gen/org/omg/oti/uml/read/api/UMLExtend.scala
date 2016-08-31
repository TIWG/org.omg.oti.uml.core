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
import org.omg.oti.uml.read.operations.UMLExtendOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A relationship from an extending UseCase to an extended UseCase that specifies how and when the behavior defined in the extending UseCase can be inserted into the behavior defined in the extended UseCase.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtend[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
	with UMLNamedElement[Uml]
  with UMLExtendOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * An ordered list of ExtensionPoints belonging to the extended UseCase, specifying where the respective behavioral fragments of the extending UseCase are to be inserted. The first fragment in the extending UseCase is associated with the first extension point in the list, the second fragment with the second point, and so on. Note that, in most practical cases, the extending UseCase has just a single behavior fragment, so that the list of ExtensionPoints is trivial.
    *
    * <!-- Start of user code doc for extensionLocation -->
    * <!-- End of user code doc for extensionLocation -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtensionPoint.extensionLocation_extension
    */
  def extensionLocation: Seq[UMLExtensionPoint[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      extend_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExtend
    *
    * <!-- Start of user code doc for extend_metaAttributes -->
    * <!-- End of user code doc for extend_metaAttributes -->
    */
  def extend_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    extend_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExtend
    *
    * <!-- Start of user code doc for extend_compositeMetaProperties -->
    * <!-- End of user code doc for extend_compositeMetaProperties -->
    */
  def extend_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_compositeMetaProperties,
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Extend_condition))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    extend_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExtend
    *
    * <!-- Start of user code doc for extend_referenceMetaProperties -->
    * <!-- End of user code doc for extend_referenceMetaProperties -->
    */
  def extend_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Extend_extendedCase,
      	Extend_extensionLocation))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    extend_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExtend
    *
    * <!-- Start of user code doc for extend_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for extend_forwardReferencesFromMetamodelAssociations -->
    */
  def extend_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    namedElement_forwardReferencesFromMetamodelAssociations ++
    extendedCase ++
    extensionLocation

  // Start of user code for additional features
  // End of user code
} //UMLExtend
