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
 * ConnectableElement is an abstract metaclass representing a set of instances that play roles of a StructuredClassifier. ConnectableElements may be joined by attached Connectors and specify configurations of linked instances to be created within an instance of the containing StructuredClassifier.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLConnectableElement[Uml <: UML]
	extends UMLParameterableElement[Uml]
	with UMLTypedElement[Uml]
	with UMLConnectableElementOps[Uml] {
	
	import ops._

	/**
	 * A set of ConnectorEnds that attach to this ConnectableElement.
	 *
	 * <!-- Start of user code doc for end -->
	 * <!-- End of user code doc for end -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnectorEnd.role
	 * @body result = (ConnectorEnd.allInstances()->select(role = self))
	 */
	def end: Set[UMLConnectorEnd[Uml]]

	/**
	 * The ConnectableElementTemplateParameter for this ConnectableElement parameter.
	 *
	 * <!-- Start of user code doc for templateParameter -->
	 * <!-- End of user code doc for templateParameter -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConnectableElementTemplateParameter.parameteredElement
	 */
	override def templateParameter: Option[UMLConnectableElementTemplateParameter[Uml]]

	/**
	 * <!-- Start of user code doc for collaborationRole_collaboration -->
	 * <!-- End of user code doc for collaborationRole_collaboration -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLCollaboration.collaborationRole
	 */
	def collaborationRole_collaboration: Set[UMLCollaboration[Uml]]

	/**
	 * <!-- Start of user code doc for represents_lifeline -->
	 * <!-- End of user code doc for represents_lifeline -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLLifeline.represents
	 */
	def represents_lifeline: Set[UMLLifeline[Uml]]

	/**
	 * <!-- Start of user code doc for role_structuredClassifier -->
	 * <!-- End of user code doc for role_structuredClassifier -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStructuredClassifier.role
	 */
	def role_structuredClassifier: Set[UMLStructuredClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		connectableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConnectableElement
	 *
	 * <!-- Start of user code doc for connectableElement_metaAttributes -->
	 * <!-- End of user code doc for connectableElement_metaAttributes -->
	 */
	def connectableElement_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			parameterableElement_metaAttributes,
			typedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		connectableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConnectableElement
	 *
	 * <!-- Start of user code doc for connectableElement_compositeMetaProperties -->
	 * <!-- End of user code doc for connectableElement_compositeMetaProperties -->
	 */
	def connectableElement_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			parameterableElement_compositeMetaProperties,
			typedElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		connectableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConnectableElement
	 *
	 * <!-- Start of user code doc for connectableElement_referenceMetaProperties -->
	 * <!-- End of user code doc for connectableElement_referenceMetaProperties -->
	 */
	def connectableElement_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			parameterableElement_referenceMetaProperties,
			typedElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLConnectableElement[Uml], UMLConnectableElementTemplateParameter[Uml]]("templateParameter", _.templateParameter)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConnectableElement
	 *
	 * <!-- Start of user code doc for connectableElement_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for connectableElement_forwardReferencesFromMetamodelAssociations -->
	 */
	def connectableElement_forwardReferencesFromMetamodelAssociations: Elements =
		parameterableElement_forwardReferencesFromMetamodelAssociations ++
		typedElement_forwardReferencesFromMetamodelAssociations ++
		templateParameter 

	// Start of user code for additional features
	// End of user code
} //UMLConnectableElement
