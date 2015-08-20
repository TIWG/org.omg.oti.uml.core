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
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLActionOps

// End of user code

/**
 * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLAction[Uml <: UML]
	extends UMLExecutableNode[Uml]
	with UMLActionOps[Uml] {
	
	import ops._

	/**
	 * The ordered set of InputPins representing the inputs to the Action.
	 *
	 * <!-- Start of user code doc for input -->
   * <!-- End of user code doc for input -->
	 *
	 * @property derived="true" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLInputPin.input_action
	 */
	def input: Seq[UMLInputPin[Uml]]

	/**
	 * If true, the Action can begin a new, concurrent execution, even if there is already another execution of the Action ongoing. If false, the Action cannot begin a new execution until any previous execution has completed.
	 *
	 * <!-- Start of user code doc for isLocallyReentrant -->
   * <!-- End of user code doc for isLocallyReentrant -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isLocallyReentrant: Boolean

	/**
	 * A Constraint that must be satisfied when execution of the Action is completed.
	 *
	 * <!-- Start of user code doc for localPostcondition -->
   * <!-- End of user code doc for localPostcondition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLConstraint.localPostcondition_action
	 */
	def localPostcondition: Set[UMLConstraint[Uml]]

	/**
	 * A Constraint that must be satisfied when execution of the Action is started.
	 *
	 * <!-- Start of user code doc for localPrecondition -->
   * <!-- End of user code doc for localPrecondition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLConstraint.localPrecondition_action
	 */
	def localPrecondition: Set[UMLConstraint[Uml]]

	/**
	 * The ordered set of OutputPins representing outputs from the Action.
	 *
	 * <!-- Start of user code doc for output -->
   * <!-- End of user code doc for output -->
	 *
	 * @property derived="true" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLOutputPin.output_action
	 */
	def output: Seq[UMLOutputPin[Uml]]

	/**
	 * <!-- Start of user code doc for action_actionExecutionSpecification -->
   * <!-- End of user code doc for action_actionExecutionSpecification -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLActionExecutionSpecification.action
	 */
	def action_actionExecutionSpecification: Set[UMLActionExecutionSpecification[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		action_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAction
	 *
	 * <!-- Start of user code doc for action_metaAttributes -->
   * <!-- End of user code doc for action_metaAttributes -->
	 */
	def action_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			executableNode_metaAttributes,
			Seq (Action_isLocallyReentrant))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		action_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAction
	 *
	 * <!-- Start of user code doc for action_compositeMetaProperties -->
   * <!-- End of user code doc for action_compositeMetaProperties -->
	 */
	def action_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			executableNode_compositeMetaProperties,
			Seq (Action_localPostcondition,
				Action_localPrecondition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		action_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAction
	 *
	 * <!-- Start of user code doc for action_referenceMetaProperties -->
   * <!-- End of user code doc for action_referenceMetaProperties -->
	 */
	def action_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			executableNode_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAction
	 *
	 * <!-- Start of user code doc for action_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for action_forwardReferencesFromMetamodelAssociations -->
	 */
	def action_forwardReferencesFromMetamodelAssociations: Elements =
		executableNode_forwardReferencesFromMetamodelAssociations ++
		Set ()

	// Start of user code for additional features
  // End of user code
} //UMLAction
