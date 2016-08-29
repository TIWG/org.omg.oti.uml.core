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
import org.omg.oti.uml.read.operations.UMLMultiplicityElementOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A MultiplicityElement embeds this information to specify the allowable cardinalities for an instantiation of the Element.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMultiplicityElement[Uml <: UML]
  extends UMLElement[Uml]
  with UMLMultiplicityElementOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this MultiplicityElement are sequentially ordered.
    *
    * <!-- Start of user code doc for isOrdered -->
    * <!-- End of user code doc for isOrdered -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isOrdered: Boolean

  /**
    * For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this MultiplicityElement are unique.
    *
    * <!-- Start of user code doc for isUnique -->
    * <!-- End of user code doc for isUnique -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isUnique: Boolean

  /**
    * The specification of the lower bound for this multiplicity.
    *
    * <!-- Start of user code doc for lowerValue -->
    * <!-- End of user code doc for lowerValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.lowerValue_owningLower
    */
  def lowerValue: Option[UMLValueSpecification[Uml]]

  /**
    * The specification of the upper bound for this multiplicity.
    *
    * <!-- Start of user code doc for upperValue -->
    * <!-- End of user code doc for upperValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.upperValue_owningUpper
    */
  def upperValue: Option[UMLValueSpecification[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      multiplicityElement_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLMultiplicityElement
    *
    * <!-- Start of user code doc for multiplicityElement_metaAttributes -->
    * <!-- End of user code doc for multiplicityElement_metaAttributes -->
    */
  def multiplicityElement_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction](MultiplicityElement_isOrdered,
     	MultiplicityElement_isUnique))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    multiplicityElement_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLMultiplicityElement
    *
    * <!-- Start of user code doc for multiplicityElement_compositeMetaProperties -->
    * <!-- End of user code doc for multiplicityElement_compositeMetaProperties -->
    */
  def multiplicityElement_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](MultiplicityElement_lowerValue,
      	MultiplicityElement_upperValue))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    multiplicityElement_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLMultiplicityElement
    *
    * <!-- Start of user code doc for multiplicityElement_referenceMetaProperties -->
    * <!-- End of user code doc for multiplicityElement_referenceMetaProperties -->
    */
  def multiplicityElement_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    multiplicityElement_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLMultiplicityElement
    *
    * <!-- Start of user code doc for multiplicityElement_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for multiplicityElement_forwardReferencesFromMetamodelAssociations -->
    */
  def multiplicityElement_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLMultiplicityElement
