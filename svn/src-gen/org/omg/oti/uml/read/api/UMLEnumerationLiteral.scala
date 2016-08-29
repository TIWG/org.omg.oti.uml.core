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
import org.omg.oti.uml.read.operations.UMLEnumerationLiteralOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An EnumerationLiteral is a user-defined data value for an Enumeration.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLEnumerationLiteral[Uml <: UML]
  extends UMLInstanceSpecification[Uml]
  with UMLEnumerationLiteralOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      enumerationLiteral_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLEnumerationLiteral
    *
    * <!-- Start of user code doc for enumerationLiteral_metaAttributes -->
    * <!-- End of user code doc for enumerationLiteral_metaAttributes -->
    */
  def enumerationLiteral_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     instanceSpecification_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    enumerationLiteral_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLEnumerationLiteral
    *
    * <!-- Start of user code doc for enumerationLiteral_compositeMetaProperties -->
    * <!-- End of user code doc for enumerationLiteral_compositeMetaProperties -->
    */
  def enumerationLiteral_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      instanceSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    enumerationLiteral_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLEnumerationLiteral
    *
    * <!-- Start of user code doc for enumerationLiteral_referenceMetaProperties -->
    * <!-- End of user code doc for enumerationLiteral_referenceMetaProperties -->
    */
  def enumerationLiteral_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      instanceSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    enumerationLiteral_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLEnumerationLiteral
    *
    * <!-- Start of user code doc for enumerationLiteral_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for enumerationLiteral_forwardReferencesFromMetamodelAssociations -->
    */
  def enumerationLiteral_forwardReferencesFromMetamodelAssociations: Elements =
    instanceSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLEnumerationLiteral
