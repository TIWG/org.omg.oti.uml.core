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
import org.omg.oti.uml.read.operations.UMLSubstitutionOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A substitution is a relationship between two classifiers signifying that the substituting classifier complies with the contract specified by the contract classifier. This implies that instances of the substituting classifier are runtime substitutable where instances of the contract classifier are expected.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSubstitution[Uml <: UML]
  extends UMLRealization[Uml]
  with UMLSubstitutionOps[Uml] {

  // Start of user code for class imports
	import ops._
  // End of user code

  /**
    * The contract with which the substituting classifier complies.
    *
    * <!-- Start of user code doc for contract -->
    * <!-- End of user code doc for contract -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.contract_substitution
    */
  def contract: Option[UMLClassifier[Uml]]

  /**
    * Instances of the substituting classifier are runtime substitutable where instances of the contract classifier are expected.
    *
    * <!-- Start of user code doc for substitutingClassifier -->
    * <!-- End of user code doc for substitutingClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.substitution
    */
  def substitutingClassifier: Option[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      substitution_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLSubstitution
    *
    * <!-- Start of user code doc for substitution_metaAttributes -->
    * <!-- End of user code doc for substitution_metaAttributes -->
    */
  def substitution_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     realization_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    substitution_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLSubstitution
    *
    * <!-- Start of user code doc for substitution_compositeMetaProperties -->
    * <!-- End of user code doc for substitution_compositeMetaProperties -->
    */
  def substitution_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      realization_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    substitution_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLSubstitution
    *
    * <!-- Start of user code doc for substitution_referenceMetaProperties -->
    * <!-- End of user code doc for substitution_referenceMetaProperties -->
    */
  def substitution_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      realization_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Substitution_contract))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    substitution_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLSubstitution
    *
    * <!-- Start of user code doc for substitution_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for substitution_forwardReferencesFromMetamodelAssociations -->
    */
  def substitution_forwardReferencesFromMetamodelAssociations: Elements =
    realization_forwardReferencesFromMetamodelAssociations ++
    contract

  // Start of user code for additional features
  // End of user code
} //UMLSubstitution
