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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * An OutputPin is a Pin that holds output values produced by an Action.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLOutputPinOps[Uml <: UML] { self: UMLOutputPin[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * <!-- Start of user code doc for outputValue_opaqueAction -->
   * <!-- End of user code doc for outputValue_opaqueAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOpaqueAction.outputValue
	 */
	def outputValue_opaqueAction: Option[UMLOpaqueAction[Uml]] = output_action.selectByKindOf { case x: UMLOpaqueAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_callAction -->
   * <!-- End of user code doc for result_callAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLCallAction.result
	 */
	def result_callAction: Option[UMLCallAction[Uml]] = output_action.selectByKindOf { case x: UMLCallAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_clearStructuralFeatureAction -->
   * <!-- End of user code doc for result_clearStructuralFeatureAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClearStructuralFeatureAction.result
	 */
	def result_clearStructuralFeatureAction: Option[UMLClearStructuralFeatureAction[Uml]] = output_action.selectByKindOf { case x: UMLClearStructuralFeatureAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_conditionalNode -->
   * <!-- End of user code doc for result_conditionalNode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConditionalNode.result
	 */
	def result_conditionalNode: Option[UMLConditionalNode[Uml]] = structuredNodeOutput_structuredActivityNode.selectByKindOf { case x: UMLConditionalNode[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_createLinkObjectAction -->
   * <!-- End of user code doc for result_createLinkObjectAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLCreateLinkObjectAction.result
	 */
	def result_createLinkObjectAction: Option[UMLCreateLinkObjectAction[Uml]] = output_action.selectByKindOf { case x: UMLCreateLinkObjectAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_createObjectAction -->
   * <!-- End of user code doc for result_createObjectAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLCreateObjectAction.result
	 */
	def result_createObjectAction: Option[UMLCreateObjectAction[Uml]] = output_action.selectByKindOf { case x: UMLCreateObjectAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_loopNode -->
   * <!-- End of user code doc for result_loopNode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.result
	 */
	def result_loopNode: Option[UMLLoopNode[Uml]] = structuredNodeOutput_structuredActivityNode.selectByKindOf { case x: UMLLoopNode[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readExtentAction -->
   * <!-- End of user code doc for result_readExtentAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadExtentAction.result
	 */
	def result_readExtentAction: Option[UMLReadExtentAction[Uml]] = output_action.selectByKindOf { case x: UMLReadExtentAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readIsClassifiedObjectAction -->
   * <!-- End of user code doc for result_readIsClassifiedObjectAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadIsClassifiedObjectAction.result
	 */
	def result_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]] = output_action.selectByKindOf { case x: UMLReadIsClassifiedObjectAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readLinkAction -->
   * <!-- End of user code doc for result_readLinkAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkAction.result
	 */
	def result_readLinkAction: Option[UMLReadLinkAction[Uml]] = output_action.selectByKindOf { case x: UMLReadLinkAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readLinkObjectEndAction -->
   * <!-- End of user code doc for result_readLinkObjectEndAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkObjectEndAction.result
	 */
	def result_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]] = output_action.selectByKindOf { case x: UMLReadLinkObjectEndAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readLinkObjectEndQualifierAction -->
   * <!-- End of user code doc for result_readLinkObjectEndQualifierAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkObjectEndQualifierAction.result
	 */
	def result_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]] = output_action.selectByKindOf { case x: UMLReadLinkObjectEndQualifierAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readSelfAction -->
   * <!-- End of user code doc for result_readSelfAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadSelfAction.result
	 */
	def result_readSelfAction: Option[UMLReadSelfAction[Uml]] = output_action.selectByKindOf { case x: UMLReadSelfAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readStructuralFeatureAction -->
   * <!-- End of user code doc for result_readStructuralFeatureAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadStructuralFeatureAction.result
	 */
	def result_readStructuralFeatureAction: Option[UMLReadStructuralFeatureAction[Uml]] = output_action.selectByKindOf { case x: UMLReadStructuralFeatureAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_readVariableAction -->
   * <!-- End of user code doc for result_readVariableAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadVariableAction.result
	 */
	def result_readVariableAction: Option[UMLReadVariableAction[Uml]] = output_action.selectByKindOf { case x: UMLReadVariableAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_reduceAction -->
   * <!-- End of user code doc for result_reduceAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReduceAction.result
	 */
	def result_reduceAction: Option[UMLReduceAction[Uml]] = output_action.selectByKindOf { case x: UMLReduceAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_testIdentityAction -->
   * <!-- End of user code doc for result_testIdentityAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLTestIdentityAction.result
	 */
	def result_testIdentityAction: Option[UMLTestIdentityAction[Uml]] = output_action.selectByKindOf { case x: UMLTestIdentityAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_unmarshallAction -->
   * <!-- End of user code doc for result_unmarshallAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLUnmarshallAction.result
	 */
	def result_unmarshallAction: Option[UMLUnmarshallAction[Uml]] = output_action.selectByKindOf { case x: UMLUnmarshallAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_valueSpecificationAction -->
   * <!-- End of user code doc for result_valueSpecificationAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecificationAction.result
	 */
	def result_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]] = output_action.selectByKindOf { case x: UMLValueSpecificationAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for result_writeStructuralFeatureAction -->
   * <!-- End of user code doc for result_writeStructuralFeatureAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLWriteStructuralFeatureAction.result
	 */
	def result_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]] = output_action.selectByKindOf { case x: UMLWriteStructuralFeatureAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for returnInformation_acceptCallAction -->
   * <!-- End of user code doc for returnInformation_acceptCallAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLAcceptCallAction.returnInformation
	 */
	def returnInformation_acceptCallAction: Option[UMLAcceptCallAction[Uml]] = output_action.selectByKindOf { case x: UMLAcceptCallAction[Uml] => x }

	/**
	 * <!-- Start of user code doc for structuredNodeOutput_structuredActivityNode -->
   * <!-- End of user code doc for structuredNodeOutput_structuredActivityNode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredActivityNode.structuredNodeOutput
	 */
	def structuredNodeOutput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]] = output_action.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x }

	/**
	 * An OutputPin may have incoming ActivityEdges only when it is owned by a StructuredActivityNode, and these edges must have sources contained (directly or indirectly) in the owning StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for validate_incoming_edges_structured_only -->
   * <!-- End of user code doc for validate_incoming_edges_structured_only -->
	 *
	 * {{{
	 * OCL Body incoming->notEmpty() implies
	 * 	action<>null and
	 * 	action.oclIsKindOf(StructuredActivityNode) and
	 * 	action.oclAsType(StructuredActivityNode).allOwnedNodes()->includesAll(incoming.source)
	 * }}}
	 */
	def validate_incoming_edges_structured_only: Boolean = {
		// Start of user code for "incoming_edges_structured_only"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLOutputPinOps
