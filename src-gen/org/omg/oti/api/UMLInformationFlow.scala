/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * <!-- begin-model-doc --> 
 * InformationFlows describe circulation of information through a system in a general manner. They do not specify the nature of the information, mechanisms by which it is conveyed, sequences of exchange or any control conditions. During more detailed modeling, representation and realization links may be added to specify which model elements implement an InformationFlow and to show how information is conveyed.  InformationFlows require some kind of ?information channel? for unidirectional transmission of information items from sources to targets.? They specify the information channel?s realizations, if any, and identify the information that flows along them.? Information moving along the information channel may be represented by abstract InformationItems and by concrete Classifiers.
 * <!-- end-model-doc --> 
 */
trait UMLInformationFlow[Uml <: UML]
	extends UMLDirectedRelationship[Uml]
	with UMLPackageableElement[Uml]
	with UMLInformationFlowOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the information items that may circulate on this information flow.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLClassifier.conveyed_conveyingFlow
	 */
	def conveyed: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Defines from which source the conveyed InformationItems are initiated.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.informationSource_informationFlow
	 */
	def informationSource: Set[UMLNamedElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Defines to which target the conveyed InformationItems are directed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.informationTarget_informationFlow
	 */
	def informationTarget: Set[UMLNamedElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Determines which Relationship will realize the specified flow.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRelationship.realization_abstraction
	 */
	def realization: Set[UMLRelationship[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Determines which ActivityEdges will realize the specified flow.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.realizingActivityEdge_informationFlow
	 */
	def realizingActivityEdge: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Determines which Connectors will realize the specified flow.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector.realizingConnector_informationFlow
	 */
	def realizingConnector: Set[UMLConnector[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Determines which Messages will realize the specified flow.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLMessage.realizingMessage_informationFlow
	 */
	def realizingMessage: Set[UMLMessage[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		informationFlow_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInformationFlow
	 */
	def informationFlow_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			directedRelationship_metaAttributes,
			packageableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		informationFlow_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInformationFlow
	 */
	def informationFlow_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_compositeMetaProperties,
			packageableElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		informationFlow_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInformationFlow
	 */
	def informationFlow_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_referenceMetaProperties,
			packageableElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLClassifier[Uml]]("conveyed", _.conveyed),
				MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLNamedElement[Uml]]("informationSource", _.informationSource),
				MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLNamedElement[Uml]]("informationTarget", _.informationTarget),
				MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLRelationship[Uml]]("realization", _.realization),
				MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLActivityEdge[Uml]]("realizingActivityEdge", _.realizingActivityEdge),
				MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLConnector[Uml]]("realizingConnector", _.realizingConnector),
				MetaPropertyCollection[Uml, UMLInformationFlow[Uml], UMLMessage[Uml]]("realizingMessage", _.realizingMessage)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		informationFlow_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInformationFlow
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

} //UMLInformationFlow
