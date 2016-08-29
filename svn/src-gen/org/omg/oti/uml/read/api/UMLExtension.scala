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
import org.omg.oti.uml.read.operations.UMLExtensionOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An extension is used to indicate that the properties of a metaclass are extended through a stereotype, and gives the ability to flexibly add (and later remove) stereotypes to classes.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtension[Uml <: UML]
  extends UMLAssociation[Uml]
  with UMLExtensionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      extension_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExtension
    *
    * <!-- Start of user code doc for extension_metaAttributes -->
    * <!-- End of user code doc for extension_metaAttributes -->
    */
  def extension_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     association_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    extension_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExtension
    *
    * <!-- Start of user code doc for extension_compositeMetaProperties -->
    * <!-- End of user code doc for extension_compositeMetaProperties -->
    */
  def extension_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      association_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Extension_ownedEnd))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    extension_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExtension
    *
    * <!-- Start of user code doc for extension_referenceMetaProperties -->
    * <!-- End of user code doc for extension_referenceMetaProperties -->
    */
  def extension_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      association_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    extension_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExtension
    *
    * <!-- Start of user code doc for extension_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for extension_forwardReferencesFromMetamodelAssociations -->
    */
  def extension_forwardReferencesFromMetamodelAssociations: Elements =
    association_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLExtension
