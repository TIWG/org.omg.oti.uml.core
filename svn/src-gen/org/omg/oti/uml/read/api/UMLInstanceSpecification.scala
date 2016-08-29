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
import org.omg.oti.uml.read.operations.UMLInstanceSpecificationOps

import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An InstanceSpecification is a model element that represents an instance in a modeled system. An InstanceSpecification can act as a DeploymentTarget in a Deployment relationship, in the case that it represents an instance of a Node. It can also act as a DeployedArtifact, if it represents an instance of an Artifact.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInstanceSpecification[Uml <: UML]
  extends UMLDeployedArtifact[Uml]
	with UMLDeploymentTarget[Uml]
	with UMLPackageableElement[Uml]
  with UMLInstanceSpecificationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Classifier or Classifiers of the represented instance. If multiple Classifiers are specified, the instance is classified by all of them.
    *
    * <!-- Start of user code doc for classifier -->
    * <!-- End of user code doc for classifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.classifier_instanceSpecification
    */
  def classifier: Iterable[UMLClassifier[Uml]]

  /**
    * A specification of how to compute, derive, or construct the instance.
    *
    * <!-- Start of user code doc for specification -->
    * <!-- End of user code doc for specification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.specification_owningInstanceSpec
    */
  def specification: Option[UMLValueSpecification[Uml]]

  /**
    * <!-- Start of user code doc for instance_instanceValue -->
    * <!-- End of user code doc for instance_instanceValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInstanceValue.instance
    */
  def instance_instanceValue: Set[UMLInstanceValue[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      instanceSpecification_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInstanceSpecification
    *
    * <!-- Start of user code doc for instanceSpecification_metaAttributes -->
    * <!-- End of user code doc for instanceSpecification_metaAttributes -->
    */
  def instanceSpecification_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     deployedArtifact_metaAttributes,
     deploymentTarget_metaAttributes,
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    instanceSpecification_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInstanceSpecification
    *
    * <!-- Start of user code doc for instanceSpecification_compositeMetaProperties -->
    * <!-- End of user code doc for instanceSpecification_compositeMetaProperties -->
    */
  def instanceSpecification_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      deployedArtifact_compositeMetaProperties,
      deploymentTarget_compositeMetaProperties,
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](InstanceSpecification_slot,
      	InstanceSpecification_specification))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    instanceSpecification_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInstanceSpecification
    *
    * <!-- Start of user code doc for instanceSpecification_referenceMetaProperties -->
    * <!-- End of user code doc for instanceSpecification_referenceMetaProperties -->
    */
  def instanceSpecification_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      deployedArtifact_referenceMetaProperties,
      deploymentTarget_referenceMetaProperties,
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InstanceSpecification_classifier))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    instanceSpecification_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInstanceSpecification
    *
    * <!-- Start of user code doc for instanceSpecification_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for instanceSpecification_forwardReferencesFromMetamodelAssociations -->
    */
  def instanceSpecification_forwardReferencesFromMetamodelAssociations: Elements =
    deployedArtifact_forwardReferencesFromMetamodelAssociations ++
    deploymentTarget_forwardReferencesFromMetamodelAssociations ++
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    classifier

  // Start of user code for additional features
  // End of user code
} //UMLInstanceSpecification
