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
import org.omg.oti.uml.read.operations.UMLExtensionEndOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * An extension end is used to tie an extension to a stereotype when extending a metaclass.The default multiplicity of an extension end is 0..1.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtensionEnd[Uml <: UML]
  extends UMLProperty[Uml]
  with UMLExtensionEndOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the type of the ExtensionEnd. Note that this association restricts the possible types of an ExtensionEnd to only be Stereotypes.
    *
    * <!-- Start of user code doc for _type -->
    * <!-- End of user code doc for _type -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStereotype.type_extensionEnd
    */
  override def _type: Option[UMLStereotype[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      extensionEnd_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExtensionEnd
    *
    * <!-- Start of user code doc for extensionEnd_metaAttributes -->
    * <!-- End of user code doc for extensionEnd_metaAttributes -->
    */
  def extensionEnd_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     property_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    extensionEnd_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExtensionEnd
    *
    * <!-- Start of user code doc for extensionEnd_compositeMetaProperties -->
    * <!-- End of user code doc for extensionEnd_compositeMetaProperties -->
    */
  def extensionEnd_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      property_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    extensionEnd_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExtensionEnd
    *
    * <!-- Start of user code doc for extensionEnd_referenceMetaProperties -->
    * <!-- End of user code doc for extensionEnd_referenceMetaProperties -->
    */
  def extensionEnd_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      property_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ExtensionEnd_type))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    extensionEnd_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExtensionEnd
    *
    * <!-- Start of user code doc for extensionEnd_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for extensionEnd_forwardReferencesFromMetamodelAssociations -->
    */
  def extensionEnd_forwardReferencesFromMetamodelAssociations: Elements =
    property_forwardReferencesFromMetamodelAssociations ++
    _type

  // Start of user code for additional features
  // End of user code
} //UMLExtensionEnd
