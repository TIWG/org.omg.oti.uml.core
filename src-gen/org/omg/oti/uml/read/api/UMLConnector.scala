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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLConnectorOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A Connector specifies links that enables communication between two or more instances. In contrast to Associations, which specify links between any instance of the associated Classifiers, Connectors specify links between instances playing the connected parts only.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLConnector[Uml <: UML]
	extends UMLFeature[Uml]
	with UMLConnectorOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * An optional Association that classifies links corresponding to this Connector.
	 *
	 * <!-- Start of user code doc for _type -->
   * <!-- End of user code doc for _type -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.type_connector
	 */
	def _type: Option[UMLAssociation[Uml]]

	/**
	 * The set of Behaviors that specify the valid interaction patterns across the Connector.
	 *
	 * <!-- Start of user code doc for contract -->
   * <!-- End of user code doc for contract -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.contract_connector
	 */
	def contract: Set[UMLBehavior[Uml]]

	/**
	 * A Connector has at least two ConnectorEnds, each representing the participation of instances of the Classifiers typing the ConnectableElements attached to the end. The set of ConnectorEnds is ordered.
	 *
	 * <!-- Start of user code doc for end -->
   * <!-- End of user code doc for end -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="2..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectorEnd.end_connector
	 */
	def end: Seq[UMLConnectorEnd[Uml]]

	/**
	 * <!-- Start of user code doc for connector_message -->
   * <!-- End of user code doc for connector_message -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.connector
	 */
	def connector_message: Set[UMLMessage[Uml]]

	/**
	 * <!-- Start of user code doc for realizingConnector_informationFlow -->
   * <!-- End of user code doc for realizingConnector_informationFlow -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInformationFlow.realizingConnector
	 */
	def realizingConnector_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connector_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnector
	 *
	 * <!-- Start of user code doc for connector_metaAttributes -->
   * <!-- End of user code doc for connector_metaAttributes -->
	 */
	def connector_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			feature_metaAttributes,
			Seq[MetaAttributeFunction]())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connector_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnector
	 *
	 * <!-- Start of user code doc for connector_compositeMetaProperties -->
   * <!-- End of user code doc for connector_compositeMetaProperties -->
	 */
	def connector_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_compositeMetaProperties,
			Seq[MetaPropertyEvaluator](Connector_end))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connector_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnector
	 *
	 * <!-- Start of user code doc for connector_referenceMetaProperties -->
   * <!-- End of user code doc for connector_referenceMetaProperties -->
	 */
	def connector_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](Connector_contract,
				Connector_redefinedConnector,
				Connector_type))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connector_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnector
	 *
	 * <!-- Start of user code doc for connector_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for connector_forwardReferencesFromMetamodelAssociations -->
	 */
	def connector_forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations ++
		contract ++
		redefinedConnector ++
		_type

	// Start of user code for additional features
  // End of user code
} //UMLConnector
