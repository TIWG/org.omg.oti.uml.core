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
import org.omg.oti.uml.read.operations.UMLLiteralRealOps

import scala.Double
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A LiteralReal is a specification of a Real value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralReal[Uml <: UML]
  extends UMLLiteralSpecification[Uml]
  with UMLLiteralRealOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The specified Real value.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def value: Double

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      literalReal_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLiteralReal
    *
    * <!-- Start of user code doc for literalReal_metaAttributes -->
    * <!-- End of user code doc for literalReal_metaAttributes -->
    */
  def literalReal_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     literalSpecification_metaAttributes,
     Seq[MetaAttributeFunction](LiteralReal_value))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    literalReal_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLiteralReal
    *
    * <!-- Start of user code doc for literalReal_compositeMetaProperties -->
    * <!-- End of user code doc for literalReal_compositeMetaProperties -->
    */
  def literalReal_compositeMetaProperties: MetaPropertyFunctions = 
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
    literalReal_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLiteralReal
    *
    * <!-- Start of user code doc for literalReal_referenceMetaProperties -->
    * <!-- End of user code doc for literalReal_referenceMetaProperties -->
    */
  def literalReal_referenceMetaProperties: MetaPropertyFunctions = 
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
    literalReal_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLiteralReal
    *
    * <!-- Start of user code doc for literalReal_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for literalReal_forwardReferencesFromMetamodelAssociations -->
    */
  def literalReal_forwardReferencesFromMetamodelAssociations: Elements =
    literalSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLLiteralReal
