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
 * A Connector specifies links that enables communication between two or more instances. In contrast to Associations, which specify links between any instance of the associated Classifiers, Connectors specify links between instances playing the connected parts only.
 * <!-- end-model-doc --> 
 */
trait UMLConnector[Uml <: UML]
	extends UMLFeature[Uml]
	with UMLConnectorOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * An optional Association that classifies links corresponding to this Connector.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAssociation.type_connector
	 */
	def _type: Option[UMLAssociation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The set of Behaviors that specify the valid interaction patterns across the Connector.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehavior.contract_connector
	 */
	def contract: Set[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A Connector has at least two ConnectorEnds, each representing the participation of instances of the Classifiers typing the ConnectableElements attached to the end. The set of ConnectorEnds is ordered.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="2..*"
	 * @opposite org.omg.oti.api.UMLConnectorEnd.end_connector
	 */
	def end: Seq[UMLConnectorEnd[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates the kind of Connector. This is derived: a Connector with one or more ends connected to a Port which is not on a Part and which is not a behavior port is a delegation; otherwise it is an assembly.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def kind: UMLConnectorKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * A Connector may be redefined when its containing Classifier is specialized. The redefining Connector may have a type that specializes the type of the redefined Connector. The types of the ConnectorEnds of the redefining Connector may specialize the types of the ConnectorEnds of the redefined Connector. The properties of the ConnectorEnds of the redefining Connector may be replaced.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector.redefinedConnector_connector
	 */
	def redefinedConnector: Set[UMLConnector[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLMessage.connector
	 */
	def connector_message: Set[UMLMessage[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredClassifier.ownedConnector
	 */
	def ownedConnector_structuredClassifier: Option[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationFlow.realizingConnector
	 */
	def realizingConnector_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector.redefinedConnector
	 */
	def redefinedConnector_connector: Set[UMLConnector[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connector_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnector
	 */
	def connector_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			feature_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connector_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnector
	 */
	def connector_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLConnector[Uml], UMLConnectorEnd[Uml]]("end", _.end)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connector_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnector
	 */
	def connector_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLConnector[Uml], UMLBehavior[Uml]]("contract", _.contract),
				MetaPropertyCollection[Uml, UMLConnector[Uml], UMLConnector[Uml]]("redefinedConnector", _.redefinedConnector),
				MetaPropertyReference[Uml, UMLConnector[Uml], UMLAssociation[Uml]]("type", _._type)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connector_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnector
	 */
	def connector_forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations ++
		contract ++
		redefinedConnector ++
		_type 

} //UMLConnector
