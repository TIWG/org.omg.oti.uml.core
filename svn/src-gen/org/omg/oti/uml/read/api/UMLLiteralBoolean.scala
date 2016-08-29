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
import org.omg.oti.uml.read.operations.UMLLiteralBooleanOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A LiteralBoolean is a specification of a Boolean value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralBoolean[Uml <: UML]
  extends UMLLiteralSpecification[Uml]
  with UMLLiteralBooleanOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The specified Boolean value.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def value: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      literalBoolean_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_metaAttributes -->
    * <!-- End of user code doc for literalBoolean_metaAttributes -->
    */
  def literalBoolean_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     literalSpecification_metaAttributes,
     Seq[MetaAttributeFunction](LiteralBoolean_value))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    literalBoolean_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_compositeMetaProperties -->
    * <!-- End of user code doc for literalBoolean_compositeMetaProperties -->
    */
  def literalBoolean_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      literalSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    literalBoolean_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_referenceMetaProperties -->
    * <!-- End of user code doc for literalBoolean_referenceMetaProperties -->
    */
  def literalBoolean_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      literalSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    literalBoolean_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for literalBoolean_forwardReferencesFromMetamodelAssociations -->
    */
  def literalBoolean_forwardReferencesFromMetamodelAssociations: Elements =
    literalSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLLiteralBoolean
