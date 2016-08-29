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
import org.omg.oti.uml.read.operations.UMLInformationFlowOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * InformationFlows describe circulation of information through a system in a general manner. They do not specify the nature of the information, mechanisms by which it is conveyed, sequences of exchange or any control conditions. During more detailed modeling, representation and realization links may be added to specify which model elements implement an InformationFlow and to show how information is conveyed.  InformationFlows require some kind of ?information channel? for unidirectional transmission of information items from sources to targets.? They specify the information channel?s realizations, if any, and identify the information that flows along them.? Information moving along the information channel may be represented by abstract InformationItems and by concrete Classifiers.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInformationFlow[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
	with UMLPackageableElement[Uml]
  with UMLInformationFlowOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the information items that may circulate on this information flow.
    *
    * <!-- Start of user code doc for conveyed -->
    * <!-- End of user code doc for conveyed -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.conveyed_conveyingFlow
    */
  def conveyed: Set[UMLClassifier[Uml]]

  /**
    * Determines which Relationship will realize the specified flow.
    *
    * <!-- Start of user code doc for realization -->
    * <!-- End of user code doc for realization -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRelationship.realization_abstraction
    */
  def realization: Set[UMLRelationship[Uml]]

  /**
    * Determines which ActivityEdges will realize the specified flow.
    *
    * <!-- Start of user code doc for realizingActivityEdge -->
    * <!-- End of user code doc for realizingActivityEdge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.realizingActivityEdge_informationFlow
    */
  def realizingActivityEdge: Set[UMLActivityEdge[Uml]]

  /**
    * Determines which Connectors will realize the specified flow.
    *
    * <!-- Start of user code doc for realizingConnector -->
    * <!-- End of user code doc for realizingConnector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.realizingConnector_informationFlow
    */
  def realizingConnector: Set[UMLConnector[Uml]]

  /**
    * Determines which Messages will realize the specified flow.
    *
    * <!-- Start of user code doc for realizingMessage -->
    * <!-- End of user code doc for realizingMessage -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.realizingMessage_informationFlow
    */
  def realizingMessage: Set[UMLMessage[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      informationFlow_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInformationFlow
    *
    * <!-- Start of user code doc for informationFlow_metaAttributes -->
    * <!-- End of user code doc for informationFlow_metaAttributes -->
    */
  def informationFlow_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    informationFlow_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInformationFlow
    *
    * <!-- Start of user code doc for informationFlow_compositeMetaProperties -->
    * <!-- End of user code doc for informationFlow_compositeMetaProperties -->
    */
  def informationFlow_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_compositeMetaProperties,
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    informationFlow_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInformationFlow
    *
    * <!-- Start of user code doc for informationFlow_referenceMetaProperties -->
    * <!-- End of user code doc for informationFlow_referenceMetaProperties -->
    */
  def informationFlow_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](InformationFlow_conveyed,
      	InformationFlow_informationSource,
      	InformationFlow_informationTarget,
      	InformationFlow_realization,
      	InformationFlow_realizingActivityEdge,
      	InformationFlow_realizingConnector,
      	InformationFlow_realizingMessage))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    informationFlow_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInformationFlow
    *
    * <!-- Start of user code doc for informationFlow_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for informationFlow_forwardReferencesFromMetamodelAssociations -->
    */
  def informationFlow_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    conveyed ++
    informationSource ++
    informationTarget ++
    realization ++
    realizingActivityEdge ++
    realizingConnector ++
    realizingMessage

  // Start of user code for additional features
  // End of user code
} //UMLInformationFlow
