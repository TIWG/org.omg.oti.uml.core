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
import org.omg.oti.uml.read.operations.UMLArtifactOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An artifact is the specification of a physical piece of information that is used or produced by a software development process, or by deployment and operation of a system. Examples of artifacts include model files, source files, scripts, and binary executable files, a table in a database system, a development deliverable, or a word-processing document, a mail message.An artifact is the source of a deployment to a node.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLArtifact[Uml <: UML]
  extends UMLClassifier[Uml]
	with UMLDeployedArtifact[Uml]
  with UMLArtifactOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * A concrete name that is used to refer to the Artifact in a physical context. Example: file system name, universal resource locator.
    *
    * <!-- Start of user code doc for fileName -->
    * <!-- End of user code doc for fileName -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def fileName: Option[String]

  /**
    * The attributes or association ends defined for the Artifact. The association is a specialization of the ownedMember association.
    *
    * <!-- Start of user code doc for ownedAttribute -->
    * <!-- End of user code doc for ownedAttribute -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.ownedAttribute_artifact
    */
  def ownedAttribute: Seq[UMLProperty[Uml]]

  /**
    * The Operations defined for the Artifact. The association is a specialization of the ownedMember association.
    *
    * <!-- Start of user code doc for ownedOperation -->
    * <!-- End of user code doc for ownedOperation -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.ownedOperation_artifact
    */
  def ownedOperation: Seq[UMLOperation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      artifact_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLArtifact
    *
    * <!-- Start of user code doc for artifact_metaAttributes -->
    * <!-- End of user code doc for artifact_metaAttributes -->
    */
  def artifact_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     classifier_metaAttributes,
     deployedArtifact_metaAttributes,
     Seq[MetaAttributeFunction](Artifact_fileName))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    artifact_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLArtifact
    *
    * <!-- Start of user code doc for artifact_compositeMetaProperties -->
    * <!-- End of user code doc for artifact_compositeMetaProperties -->
    */
  def artifact_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      deployedArtifact_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Artifact_manifestation,
      	Artifact_nestedArtifact,
      	Artifact_ownedAttribute,
      	Artifact_ownedOperation))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    artifact_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLArtifact
    *
    * <!-- Start of user code doc for artifact_referenceMetaProperties -->
    * <!-- End of user code doc for artifact_referenceMetaProperties -->
    */
  def artifact_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      deployedArtifact_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    artifact_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLArtifact
    *
    * <!-- Start of user code doc for artifact_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for artifact_forwardReferencesFromMetamodelAssociations -->
    */
  def artifact_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    deployedArtifact_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLArtifact
