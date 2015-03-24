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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * An InputPin is a Pin that holds input values to be consumed by an Action.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInputPinOps[Uml <: UML] { self: UMLInputPin[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReduceAction.collection
	 */
	def collection_reduceAction: Option[UMLReduceAction[Uml]] = input_action.selectByKindOf { case x: UMLReduceAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRaiseExceptionAction.exception
	 */
	def exception_raiseExceptionAction: Option[UMLRaiseExceptionAction[Uml]] = input_action.selectByKindOf { case x: UMLRaiseExceptionAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLinkAction.inputValue
	 */
	def inputValue_linkAction: Option[UMLLinkAction[Uml]] = input_action.selectByKindOf { case x: UMLLinkAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOpaqueAction.inputValue
	 */
	def inputValue_opaqueAction: Option[UMLOpaqueAction[Uml]] = input_action.selectByKindOf { case x: UMLOpaqueAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAddStructuralFeatureValueAction.insertAt
	 */
	def insertAt_addStructuralFeatureValueAction: Option[UMLAddStructuralFeatureValueAction[Uml]] = input_action.selectByKindOf { case x: UMLAddStructuralFeatureValueAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAddVariableValueAction.insertAt
	 */
	def insertAt_addVariableValueAction: Option[UMLAddVariableValueAction[Uml]] = input_action.selectByKindOf { case x: UMLAddVariableValueAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLoopNode.loopVariableInput
	 */
	def loopVariableInput_loopNode: Option[UMLLoopNode[Uml]] = structuredNodeInput_structuredActivityNode.selectByKindOf { case x: UMLLoopNode[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClearAssociationAction._object
	 */
	def object_clearAssociationAction: Option[UMLClearAssociationAction[Uml]] = input_action.selectByKindOf { case x: UMLClearAssociationAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadIsClassifiedObjectAction._object
	 */
	def object_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]] = input_action.selectByKindOf { case x: UMLReadIsClassifiedObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndAction._object
	 */
	def object_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]] = input_action.selectByKindOf { case x: UMLReadLinkObjectEndAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndQualifierAction._object
	 */
	def object_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]] = input_action.selectByKindOf { case x: UMLReadLinkObjectEndQualifierAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReclassifyObjectAction._object
	 */
	def object_reclassifyObjectAction: Option[UMLReclassifyObjectAction[Uml]] = input_action.selectByKindOf { case x: UMLReclassifyObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStartClassifierBehaviorAction._object
	 */
	def object_startClassifierBehaviorAction: Option[UMLStartClassifierBehaviorAction[Uml]] = input_action.selectByKindOf { case x: UMLStartClassifierBehaviorAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStartObjectBehaviorAction._object
	 */
	def object_startObjectBehaviorAction: Option[UMLStartObjectBehaviorAction[Uml]] = input_action.selectByKindOf { case x: UMLStartObjectBehaviorAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLUnmarshallAction._object
	 */
	def object_unmarshallAction: Option[UMLUnmarshallAction[Uml]] = input_action.selectByKindOf { case x: UMLUnmarshallAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRemoveStructuralFeatureValueAction.removeAt
	 */
	def removeAt_removeStructuralFeatureValueAction: Option[UMLRemoveStructuralFeatureValueAction[Uml]] = input_action.selectByKindOf { case x: UMLRemoveStructuralFeatureValueAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRemoveVariableValueAction.removeAt
	 */
	def removeAt_removeVariableValueAction: Option[UMLRemoveVariableValueAction[Uml]] = input_action.selectByKindOf { case x: UMLRemoveVariableValueAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLSendObjectAction.request
	 */
	def request_sendObjectAction: Option[UMLSendObjectAction[Uml]] = argument_invocationAction.selectByKindOf { case x: UMLSendObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.structuredNodeInput
	 */
	def structuredNodeInput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]] = input_action.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCallOperationAction.target
	 */
	def target_callOperationAction: Option[UMLCallOperationAction[Uml]] = input_action.selectByKindOf { case x: UMLCallOperationAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDestroyObjectAction.target
	 */
	def target_destroyObjectAction: Option[UMLDestroyObjectAction[Uml]] = input_action.selectByKindOf { case x: UMLDestroyObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLSendSignalAction.target
	 */
	def target_sendSignalAction: Option[UMLSendSignalAction[Uml]] = input_action.selectByKindOf { case x: UMLSendSignalAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * An InputPin may have outgoing ActivityEdges only when it is owned by a StructuredActivityNode, and these edges must target a node contained (directly or indirectly) in the owning StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @body outgoing->notEmpty() implies
	 * 	action<>null and
	 * 	action.oclIsKindOf(StructuredActivityNode) and
	 * 	action.oclAsType(StructuredActivityNode).allOwnedNodes()->includesAll(outgoing.target)
	 */
	def validate_outgoing_edges_structured_only: Boolean  = {
		// Start of user code for "outgoing_edges_structured_only"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLInputPin
