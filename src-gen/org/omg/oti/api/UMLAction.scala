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
 * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
 * <!-- end-model-doc --> 
 */
trait UMLAction[Uml <: UML]
	extends UMLExecutableNode[Uml]
	with UMLActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The context Classifier of the Behavior that contains this Action, or the Behavior itself if it has no context.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.context_action
	 */
	def context: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ordered set of InputPins representing the inputs to the Action.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.input_action
	 */
	def input: Seq[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * If true, the Action can begin a new, concurrent execution, even if there is already another execution of the Action ongoing. If false, the Action cannot begin a new execution until any previous execution has completed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isLocallyReentrant: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A Constraint that must be satisfied when execution of the Action is completed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.localPostcondition_action
	 */
	def localPostcondition: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A Constraint that must be satisfied when execution of the Action is started.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.localPrecondition_action
	 */
	def localPrecondition: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ordered set of OutputPins representing outputs from the Action.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.output_action
	 */
	def output: Seq[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActionExecutionSpecification.action
	 */
	def action_actionExecutionSpecification: Set[UMLActionExecutionSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteraction.action
	 */
	def action_interaction: Option[UMLInteraction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActionInputPin.fromAction
	 */
	def fromAction_actionInputPin: Option[UMLActionInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		action_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAction
	 */
	def action_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			executableNode_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLAction[Uml]](None, "isLocallyReentrant", (x) => booleanToIterable(x.isLocallyReentrant, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		action_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAction
	 */
	def action_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			executableNode_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLAction[Uml], UMLConstraint[Uml]]("localPostcondition", _.localPostcondition),
				MetaPropertyCollection[Uml, UMLAction[Uml], UMLConstraint[Uml]]("localPrecondition", _.localPrecondition)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		action_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAction
	 */
	def action_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			executableNode_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAction
	 */
	def action_forwardReferencesFromMetamodelAssociations: Elements =
		executableNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLAction
