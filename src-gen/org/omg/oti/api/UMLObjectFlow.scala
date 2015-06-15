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
 * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLObjectFlow[Uml <: UML]
	extends UMLActivityEdge[Uml]
	with UMLObjectFlowOps[Uml] {
	
	import ops._

	/**
	 * Indicates whether the objects in the ObjectFlow are passed by multicasting.
	 *
	 * <!-- Start of user code doc for isMulticast -->
	 * <!-- End of user code doc for isMulticast -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isMulticast: Boolean

	/**
	 * Indicates whether the objects in the ObjectFlow are gathered from respondents to multicasting.
	 *
	 * <!-- Start of user code doc for isMultireceive -->
	 * <!-- End of user code doc for isMultireceive -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isMultireceive: Boolean

	/**
	 * A Behavior used to select tokens from a source ObjectNode.
	 *
	 * <!-- Start of user code doc for selection -->
	 * <!-- End of user code doc for selection -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.selection_objectFlow
	 */
	def selection: Option[UMLBehavior[Uml]]

	/**
	 * A Behavior used to change or replace object tokens flowing along the ObjectFlow.
	 *
	 * <!-- Start of user code doc for transformation -->
	 * <!-- End of user code doc for transformation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.transformation_objectFlow
	 */
	def transformation: Option[UMLBehavior[Uml]]

	/**
	 * <!-- Start of user code doc for decisionInputFlow_decisionNode -->
	 * <!-- End of user code doc for decisionInputFlow_decisionNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDecisionNode.decisionInputFlow
	 */
	def decisionInputFlow_decisionNode: Option[UMLDecisionNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		objectFlow_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLObjectFlow
	 *
	 * <!-- Start of user code doc for objectFlow_metaAttributes -->
	 * <!-- End of user code doc for objectFlow_metaAttributes -->
	 */
	def objectFlow_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			activityEdge_metaAttributes,
			Seq (ObjectFlow_isMulticast,
				ObjectFlow_isMultireceive))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		objectFlow_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLObjectFlow
	 *
	 * <!-- Start of user code doc for objectFlow_compositeMetaProperties -->
	 * <!-- End of user code doc for objectFlow_compositeMetaProperties -->
	 */
	def objectFlow_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityEdge_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		objectFlow_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLObjectFlow
	 *
	 * <!-- Start of user code doc for objectFlow_referenceMetaProperties -->
	 * <!-- End of user code doc for objectFlow_referenceMetaProperties -->
	 */
	def objectFlow_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityEdge_referenceMetaProperties,
			Seq (ObjectFlow_selection,
				ObjectFlow_transformation))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		objectFlow_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLObjectFlow
	 *
	 * <!-- Start of user code doc for objectFlow_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for objectFlow_forwardReferencesFromMetamodelAssociations -->
	 */
	def objectFlow_forwardReferencesFromMetamodelAssociations: Elements =
		activityEdge_forwardReferencesFromMetamodelAssociations ++
		selection ++
		transformation 

	// Start of user code for additional features
	// End of user code
} //UMLObjectFlow
