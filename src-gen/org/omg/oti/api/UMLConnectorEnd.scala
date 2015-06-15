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
 * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLConnectorEnd[Uml <: UML]
	extends UMLMultiplicityElement[Uml]
	with UMLConnectorEndOps[Uml] {
	
	import ops._

	/**
	 * A derived property referencing the corresponding end on the Association which types the Connector owing this ConnectorEnd, if any. It is derived by selecting the end at the same place in the ordering of Association ends as this ConnectorEnd.
	 *
	 * <!-- Start of user code doc for definingEnd -->
	 * <!-- End of user code doc for definingEnd -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.definingEnd_connectorEnd
	 * @body result = (if connector.type = null 
	 * then
	 *   null 
	 * else
	 *   let index : Integer = connector.end->indexOf(self) in
	 *     connector.type.memberEnd->at(index)
	 * endif)
	 */
	def definingEnd: Option[UMLProperty[Uml]]

	/**
	 * Indicates the role of the internal structure of a Classifier with the Port to which the ConnectorEnd is attached.
	 *
	 * <!-- Start of user code doc for partWithPort -->
	 * <!-- End of user code doc for partWithPort -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.partWithPort_connectorEnd
	 */
	def partWithPort: Option[UMLProperty[Uml]]

	/**
	 * The ConnectableElement attached at this ConnectorEnd. When an instance of the containing Classifier is created, a link may (depending on the multiplicities) be created to an instance of the Classifier that types this ConnectableElement.
	 *
	 * <!-- Start of user code doc for role -->
	 * <!-- End of user code doc for role -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLConnectableElement.end
	 */
	def role: Option[UMLConnectableElement[Uml]]

	/**
	 * <!-- Start of user code doc for end_connector -->
	 * <!-- End of user code doc for end_connector -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLConnector.end
	 */
	def end_connector: Option[UMLConnector[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectorEnd_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectorEnd
	 *
	 * <!-- Start of user code doc for connectorEnd_metaAttributes -->
	 * <!-- End of user code doc for connectorEnd_metaAttributes -->
	 */
	def connectorEnd_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			multiplicityElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectorEnd_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectorEnd
	 *
	 * <!-- Start of user code doc for connectorEnd_compositeMetaProperties -->
	 * <!-- End of user code doc for connectorEnd_compositeMetaProperties -->
	 */
	def connectorEnd_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			multiplicityElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectorEnd_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectorEnd
	 *
	 * <!-- Start of user code doc for connectorEnd_referenceMetaProperties -->
	 * <!-- End of user code doc for connectorEnd_referenceMetaProperties -->
	 */
	def connectorEnd_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			multiplicityElement_referenceMetaProperties,
			Seq (ConnectorEnd_partWithPort,
				ConnectorEnd_role))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectorEnd_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectorEnd
	 *
	 * <!-- Start of user code doc for connectorEnd_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for connectorEnd_forwardReferencesFromMetamodelAssociations -->
	 */
	def connectorEnd_forwardReferencesFromMetamodelAssociations: Elements =
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		partWithPort ++
		role 

	// Start of user code for additional features
	// End of user code
} //UMLConnectorEnd
