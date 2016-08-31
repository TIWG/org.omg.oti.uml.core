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
import org.omg.oti.uml.read.operations.UMLBehavioralFeatureOps

import scala.{Boolean,Option}
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A BehavioralFeature is a feature of a Classifier that specifies an aspect of the behavior of its instances.  A BehavioralFeature is implemented (realized) by a Behavior. A BehavioralFeature specifies that a Classifier will respond to a designated request by invoking its implementing method.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLBehavioralFeature[Uml <: UML]
  extends UMLFeature[Uml]
	with UMLNamespace[Uml]
  with UMLBehavioralFeatureOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the semantics of concurrent calls to the same passive instance (i.e., an instance originating from a Class with isActive being false). Active instances control access to their own BehavioralFeatures.
    *
    * <!-- Start of user code doc for concurrency -->
    * <!-- End of user code doc for concurrency -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def concurrency: Option[UMLCallConcurrencyKind.Value]

  /**
    * If true, then the BehavioralFeature does not have an implementation, and one must be supplied by a more specific Classifier. If false, the BehavioralFeature must have an implementation in the Classifier or one must be inherited.
    *
    * <!-- Start of user code doc for isAbstract -->
    * <!-- End of user code doc for isAbstract -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isAbstract: Boolean

  /**
    * A Behavior that implements the BehavioralFeature. There may be at most one Behavior for a particular pairing of a Classifier (as owner of the Behavior) and a BehavioralFeature (as specification of the Behavior).
    *
    * <!-- Start of user code doc for method -->
    * <!-- End of user code doc for method -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.specification
    */
  def method: Set[UMLBehavior[Uml]]

  /**
    * The ordered set of formal Parameters of this BehavioralFeature.
    *
    * <!-- Start of user code doc for ownedParameter -->
    * <!-- End of user code doc for ownedParameter -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.ownedParameter_ownerFormalParam
    */
  def ownedParameter: Seq[UMLParameter[Uml]]

  /**
    * The Types representing exceptions that may be raised during an invocation of this BehavioralFeature.
    *
    * <!-- Start of user code doc for raisedException -->
    * <!-- End of user code doc for raisedException -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLType.raisedException_behavioralFeature
    */
  def raisedException: Set[UMLType[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      behavioralFeature_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLBehavioralFeature
    *
    * <!-- Start of user code doc for behavioralFeature_metaAttributes -->
    * <!-- End of user code doc for behavioralFeature_metaAttributes -->
    */
  def behavioralFeature_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     feature_metaAttributes,
     namespace_metaAttributes,
     Seq[MetaAttributeFunction](BehavioralFeature_isAbstract))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    behavioralFeature_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLBehavioralFeature
    *
    * <!-- Start of user code doc for behavioralFeature_compositeMetaProperties -->
    * <!-- End of user code doc for behavioralFeature_compositeMetaProperties -->
    */
  def behavioralFeature_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      feature_compositeMetaProperties,
      namespace_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](BehavioralFeature_ownedParameter,
      	BehavioralFeature_ownedParameterSet))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    behavioralFeature_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLBehavioralFeature
    *
    * <!-- Start of user code doc for behavioralFeature_referenceMetaProperties -->
    * <!-- End of user code doc for behavioralFeature_referenceMetaProperties -->
    */
  def behavioralFeature_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      feature_referenceMetaProperties,
      namespace_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](BehavioralFeature_method,
      	BehavioralFeature_raisedException))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    behavioralFeature_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLBehavioralFeature
    *
    * <!-- Start of user code doc for behavioralFeature_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for behavioralFeature_forwardReferencesFromMetamodelAssociations -->
    */
  def behavioralFeature_forwardReferencesFromMetamodelAssociations: Elements =
    feature_forwardReferencesFromMetamodelAssociations ++
    namespace_forwardReferencesFromMetamodelAssociations ++
    method ++
    raisedException

  // Start of user code for additional features
  // End of user code
} //UMLBehavioralFeature
