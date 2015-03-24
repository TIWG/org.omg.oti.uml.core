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
 * An OutputPin is a Pin that holds output values produced by an Action.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLOutputPinOps[Uml <: UML] { self: UMLOutputPin[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOpaqueAction.outputValue
	 */
	def outputValue_opaqueAction: Option[UMLOpaqueAction[Uml]] = output_action.selectByKindOf { case x: UMLOpaqueAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCallAction.result
	 */
	def result_callAction: Option[UMLCallAction[Uml]] = output_action.selectByKindOf { case x: UMLCallAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClearStructuralFeatureAction.result
	 */
	def result_clearStructuralFeatureAction: Option[UMLClearStructuralFeatureAction[Uml]] = output_action.selectByKindOf { case x: UMLClearStructuralFeatureAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCreateLinkObjectAction.result
	 */
	def result_createLinkObjectAction: Option[UMLCreateLinkObjectAction[Uml]] = output_action.selectByKindOf { case x: UMLCreateLinkObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCreateObjectAction.result
	 */
	def result_createObjectAction: Option[UMLCreateObjectAction[Uml]] = output_action.selectByKindOf { case x: UMLCreateObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadExtentAction.result
	 */
	def result_readExtentAction: Option[UMLReadExtentAction[Uml]] = output_action.selectByKindOf { case x: UMLReadExtentAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadIsClassifiedObjectAction.result
	 */
	def result_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]] = output_action.selectByKindOf { case x: UMLReadIsClassifiedObjectAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkAction.result
	 */
	def result_readLinkAction: Option[UMLReadLinkAction[Uml]] = output_action.selectByKindOf { case x: UMLReadLinkAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndAction.result
	 */
	def result_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]] = output_action.selectByKindOf { case x: UMLReadLinkObjectEndAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndQualifierAction.result
	 */
	def result_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]] = output_action.selectByKindOf { case x: UMLReadLinkObjectEndQualifierAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadSelfAction.result
	 */
	def result_readSelfAction: Option[UMLReadSelfAction[Uml]] = output_action.selectByKindOf { case x: UMLReadSelfAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadStructuralFeatureAction.result
	 */
	def result_readStructuralFeatureAction: Option[UMLReadStructuralFeatureAction[Uml]] = output_action.selectByKindOf { case x: UMLReadStructuralFeatureAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadVariableAction.result
	 */
	def result_readVariableAction: Option[UMLReadVariableAction[Uml]] = output_action.selectByKindOf { case x: UMLReadVariableAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReduceAction.result
	 */
	def result_reduceAction: Option[UMLReduceAction[Uml]] = output_action.selectByKindOf { case x: UMLReduceAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTestIdentityAction.result
	 */
	def result_testIdentityAction: Option[UMLTestIdentityAction[Uml]] = output_action.selectByKindOf { case x: UMLTestIdentityAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLUnmarshallAction.result
	 */
	def result_unmarshallAction: Option[UMLUnmarshallAction[Uml]] = output_action.selectByKindOf { case x: UMLUnmarshallAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecificationAction.result
	 */
	def result_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]] = output_action.selectByKindOf { case x: UMLValueSpecificationAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLWriteStructuralFeatureAction.result
	 */
	def result_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]] = output_action.selectByKindOf { case x: UMLWriteStructuralFeatureAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAcceptCallAction.returnInformation
	 */
	def returnInformation_acceptCallAction: Option[UMLAcceptCallAction[Uml]] = output_action.selectByKindOf { case x: UMLAcceptCallAction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.structuredNodeOutput
	 */
	def structuredNodeOutput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]] = output_action.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * An OutputPin may have incoming ActivityEdges only when it is owned by a StructuredActivityNode, and these edges must have sources contained (directly or indirectly) in the owning StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @body incoming->notEmpty() implies
	 * 	action<>null and
	 * 	action.oclIsKindOf(StructuredActivityNode) and
	 * 	action.oclAsType(StructuredActivityNode).allOwnedNodes()->includesAll(incoming.source)
	 */
	def validate_incoming_edges_structured_only: Boolean  = {
		// Start of user code for "incoming_edges_structured_only"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLOutputPin
