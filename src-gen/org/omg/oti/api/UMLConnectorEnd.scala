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
 * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
 * <!-- end-model-doc -->
 */
trait UMLConnectorEnd[Uml <: UML]
	extends UMLMultiplicityElement[Uml]
	with UMLConnectorEndOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * A derived property referencing the corresponding end on the Association which types the Connector owing this ConnectorEnd, if any. It is derived by selecting the end at the same place in the ordering of Association ends as this ConnectorEnd.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.definingEnd_connectorEnd
	 */
	def definingEnd: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates the role of the internal structure of a Classifier with the Port to which the ConnectorEnd is attached.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.partWithPort_connectorEnd
	 */
	def partWithPort: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ConnectableElement attached at this ConnectorEnd. When an instance of the containing Classifier is created, a link may (depending on the multiplicities) be created to an instance of the Classifier that types this ConnectableElement.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLConnectableElement.end
	 */
	def role: Option[UMLConnectableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLConnector.end
	 */
	def end_connector: Option[UMLConnector[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectorEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectorEnd
	 */
	def connectorEnd_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			multiplicityElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectorEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectorEnd
	 */
	def connectorEnd_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			multiplicityElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectorEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectorEnd
	 */
	def connectorEnd_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			multiplicityElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLConnectorEnd[Uml], UMLProperty[Uml]]("partWithPort", _.partWithPort),
				MetaPropertyReference[Uml, UMLConnectorEnd[Uml], UMLConnectableElement[Uml]]("role", _.role)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectorEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectorEnd
	 */
	def connectorEnd_forwardReferencesFromMetamodelAssociations: Elements =
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		partWithPort ++
		role 

} //UMLConnectorEnd
