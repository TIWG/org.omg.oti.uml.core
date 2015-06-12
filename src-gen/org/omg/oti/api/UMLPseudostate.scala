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
 * A Pseudostate is an abstraction that encompasses different types of transient Vertices in the StateMachine graph. A StateMachine instance never comes to rest in a Pseudostate, instead, it will exit and enter the Pseudostate within a single run-to-completion step.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLPseudostate[Uml <: UML]
	extends UMLVertex[Uml]
	with UMLPseudostateOps[Uml] {
	
	import ops._

	/**
	 * Determines the precise type of the Pseudostate and can be one of: entryPoint, exitPoint, initial, deepHistory, shallowHistory, join, fork, junction, terminate or choice.
	 *
	 * <!-- Start of user code doc for kind -->
	 * <!-- End of user code doc for kind -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def kind: UMLPseudostateKind.Value

	/**
	 * The State that owns this Pseudostate and in which it appears.
	 *
	 * <!-- Start of user code doc for state -->
	 * <!-- End of user code doc for state -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.connectionPoint
	 */
	def state: Option[UMLState[Uml]]

	/**
	 * The StateMachine in which this Pseudostate is defined. This only applies to Pseudostates of the kind entryPoint or exitPoint.
	 *
	 * <!-- Start of user code doc for stateMachine -->
	 * <!-- End of user code doc for stateMachine -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStateMachine.connectionPoint
	 */
	def stateMachine: Option[UMLStateMachine[Uml]]

	/**
	 * <!-- Start of user code doc for entry_connectionPointReference -->
	 * <!-- End of user code doc for entry_connectionPointReference -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConnectionPointReference.entry
	 */
	def entry_connectionPointReference: Option[UMLConnectionPointReference[Uml]]

	/**
	 * <!-- Start of user code doc for exit_connectionPointReference -->
	 * <!-- End of user code doc for exit_connectionPointReference -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConnectionPointReference.exit
	 */
	def exit_connectionPointReference: Option[UMLConnectionPointReference[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		pseudostate_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLPseudostate
	 *
	 * <!-- Start of user code doc for pseudostate_metaAttributes -->
	 * <!-- End of user code doc for pseudostate_metaAttributes -->
	 */
	def pseudostate_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			vertex_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		pseudostate_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLPseudostate
	 *
	 * <!-- Start of user code doc for pseudostate_compositeMetaProperties -->
	 * <!-- End of user code doc for pseudostate_compositeMetaProperties -->
	 */
	def pseudostate_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			vertex_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		pseudostate_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLPseudostate
	 *
	 * <!-- Start of user code doc for pseudostate_referenceMetaProperties -->
	 * <!-- End of user code doc for pseudostate_referenceMetaProperties -->
	 */
	def pseudostate_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			vertex_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		pseudostate_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLPseudostate
	 *
	 * <!-- Start of user code doc for pseudostate_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for pseudostate_forwardReferencesFromMetamodelAssociations -->
	 */
	def pseudostate_forwardReferencesFromMetamodelAssociations: Elements =
		vertex_forwardReferencesFromMetamodelAssociations ++
		state ++
		stateMachine 

	// Start of user code for additional features
	// End of user code
} //UMLPseudostate
