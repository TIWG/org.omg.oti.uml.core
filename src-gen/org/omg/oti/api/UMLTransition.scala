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
 * A Transition represents an arc between exactly one source Vertex and exactly one Target vertex (the source and targets may be the same Vertex). It may form part of a compound transition, which takes the StateMachine from one steady State configuration to another, representing the full response of the StateMachine to an occurrence of an Event that triggered it.
 * <!-- end-model-doc --> 
 */
trait UMLTransition[Uml <: UML]
	extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
	with UMLTransitionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Designates the Region that owns this Transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLRegion.transition
	 */
	def container: Option[UMLRegion[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies an optional behavior to be performed when the Transition fires.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.effect_transition
	 */
	def effect: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A guard is a Constraint that provides a fine-grained control over the firing of the Transition. The guard is evaluated when an Event occurrence is dispatched by the StateMachine. If the guard is true at that time, the Transition may be enabled, otherwise, it is disabled. Guards should be pure expressions without side effects. Guard expressions with side effects are ill formed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.guard_transition
	 */
	def guard: Option[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates the precise type of the Transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def kind: UMLTransitionKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * The Transition that is redefined by this Transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTransition.redefinedTransition_transition
	 */
	def redefinedTransition: Option[UMLTransition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References the Classifier in which context this element may be redefined.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinitionContext_transition
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Designates the originating Vertex (State or Pseudostate) of the Transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLVertex.outgoing
	 */
	def source: Option[UMLVertex[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Designates the target Vertex that is reached when the Transition is taken.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLVertex.incoming
	 */
	def target: Option[UMLVertex[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the Triggers that may fire the transition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTrigger.trigger_transition
	 */
	def trigger: Set[UMLTrigger[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.redefinedTransition
	 */
	def redefinedTransition_transition: Set[UMLTransition[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		transition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTransition
	 */
	def transition_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namespace_metaAttributes,
			redefinableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		transition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTransition
	 */
	def transition_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_compositeMetaProperties,
			redefinableElement_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTransition[Uml], UMLBehavior[Uml]]("effect", _.effect),
				MetaPropertyReference[Uml, UMLTransition[Uml], UMLConstraint[Uml]]("guard", _.guard),
				MetaPropertyCollection[Uml, UMLTransition[Uml], UMLTrigger[Uml]]("trigger", _.trigger)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		transition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTransition
	 */
	def transition_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_referenceMetaProperties,
			redefinableElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTransition[Uml], UMLRegion[Uml]]("container", _.container),
				MetaPropertyReference[Uml, UMLTransition[Uml], UMLTransition[Uml]]("redefinedTransition", _.redefinedTransition),
				MetaPropertyReference[Uml, UMLTransition[Uml], UMLVertex[Uml]]("source", _.source),
				MetaPropertyReference[Uml, UMLTransition[Uml], UMLVertex[Uml]]("target", _.target)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		transition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTransition
	 */
	def transition_forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations ++
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		container ++
		redefinedTransition ++
		source ++
		target 

} //UMLTransition
