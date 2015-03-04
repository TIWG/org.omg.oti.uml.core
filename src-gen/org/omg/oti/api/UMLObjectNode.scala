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
 * An ObjectNode is an abstract ActivityNode that may hold tokens within the object flow in an Activity. ObjectNodes also support token selection, limitation on the number of tokens held, specification of the state required for tokens being held, and carrying control values.

 * <!-- end-model-doc --> 
 */
trait UMLObjectNode[Uml <: UML]
	extends UMLActivityNode[Uml]
	with UMLTypedElement[Uml]
	with UMLObjectNodeOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The States required to be associated with the values held by tokens on this ObjectNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLState.inState_objectNode
	 */
	def inState: Set[UMLState[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether the type of the ObjectNode is to be treated as representing control values that may traverse ControlFlows.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isControlType: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Indicates how the tokens held by the ObjectNode are ordered for selection to traverse ActivityEdges outgoing from the ObjectNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def ordering: UMLObjectNodeOrderingKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * A Behavior used to select tokens to be offered on outgoing ActivityEdges.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.selection_objectNode
	 */
	def selection: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The maximum number of tokens that may be held by this ObjectNode. Tokens cannot flow into the ObjectNode if the upperValue is reached. If no upperValue is specified, then there is no limit on how many tokens the ObjectNode can hold.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.upperValue_objectNode
	 */
	def upperValue: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExceptionHandler.exceptionInput
	 */
	def exceptionInput_exceptionHandler: Set[UMLExceptionHandler[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		objectNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLObjectNode
	 */
	def objectNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			activityNode_metaAttributes,
			typedElement_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLObjectNode[Uml]](None, "isControlType", (x) => booleanToIterable(x.isControlType, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		objectNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLObjectNode
	 */
	def objectNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityNode_compositeMetaProperties,
			typedElement_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLObjectNode[Uml], UMLValueSpecification[Uml]]("upperValue", _.upperValue)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		objectNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLObjectNode
	 */
	def objectNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityNode_referenceMetaProperties,
			typedElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLObjectNode[Uml], UMLState[Uml]]("inState", _.inState),
				MetaPropertyReference[Uml, UMLObjectNode[Uml], UMLBehavior[Uml]]("selection", _.selection)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLObjectNode
	 */
	def objectNode_forwardReferencesFromMetamodelAssociations: Elements =
		activityNode_forwardReferencesFromMetamodelAssociations ++
		typedElement_forwardReferencesFromMetamodelAssociations ++
		inState ++
		selection 

} //UMLObjectNode
