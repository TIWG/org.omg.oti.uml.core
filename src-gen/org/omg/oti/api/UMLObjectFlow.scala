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
 * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
 * <!-- end-model-doc --> 
 */
trait UMLObjectFlow[Uml <: UML]
	extends UMLActivityEdge[Uml]
	with UMLObjectFlowOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether the objects in the ObjectFlow are passed by multicasting.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isMulticast: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether the objects in the ObjectFlow are gathered from respondents to multicasting.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isMultireceive: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A Behavior used to select tokens from a source ObjectNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.selection_objectFlow
	 */
	def selection: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A Behavior used to change or replace object tokens flowing along the ObjectFlow.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.transformation_objectFlow
	 */
	def transformation: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDecisionNode.decisionInputFlow
	 */
	def decisionInputFlow_decisionNode: Option[UMLDecisionNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		objectFlow_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLObjectFlow
	 */
	def objectFlow_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			activityEdge_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLObjectFlow[Uml]](None, "isMulticast", (x) => booleanToIterable(x.isMulticast, false)),
				MetaAttributeBooleanFunction[Uml, UMLObjectFlow[Uml]](None, "isMultireceive", (x) => booleanToIterable(x.isMultireceive, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		objectFlow_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLObjectFlow
	 */
	def objectFlow_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityEdge_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		objectFlow_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLObjectFlow
	 */
	def objectFlow_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityEdge_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLObjectFlow[Uml], UMLBehavior[Uml]]("selection", _.selection),
				MetaPropertyReference[Uml, UMLObjectFlow[Uml], UMLBehavior[Uml]]("transformation", _.transformation)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		objectFlow_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLObjectFlow
	 */
	def objectFlow_forwardReferencesFromMetamodelAssociations: Elements =
		activityEdge_forwardReferencesFromMetamodelAssociations ++
		selection ++
		transformation 

} //UMLObjectFlow
