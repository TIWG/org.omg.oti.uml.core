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
 * A ValueSpecification is the specification of a (possibly empty) set of values. A ValueSpecification is a ParameterableElement that may be exposed as a formal TemplateParameter and provided as the actual parameter in the binding of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLValueSpecification[Uml <: UML]
	extends UMLPackageableElement[Uml]
	with UMLTypedElement[Uml]
	with UMLValueSpecificationOps[Uml] {
	
	import ops._

	/**
	 * <!-- Start of user code doc for argument_interactionUse -->
	 * <!-- End of user code doc for argument_interactionUse -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteractionUse.argument
	 */
	def argument_interactionUse: Option[UMLInteractionUse[Uml]]

	/**
	 * <!-- Start of user code doc for argument_message -->
	 * <!-- End of user code doc for argument_message -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessage.argument
	 */
	def argument_message: Option[UMLMessage[Uml]]

	/**
	 * <!-- Start of user code doc for changeExpression_changeEvent -->
	 * <!-- End of user code doc for changeExpression_changeEvent -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLChangeEvent.changeExpression
	 */
	def changeExpression_changeEvent: Option[UMLChangeEvent[Uml]]

	/**
	 * <!-- Start of user code doc for defaultValue_owningParameter -->
	 * <!-- End of user code doc for defaultValue_owningParameter -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameter.defaultValue
	 */
	def defaultValue_owningParameter: Option[UMLParameter[Uml]]

	/**
	 * <!-- Start of user code doc for defaultValue_owningProperty -->
	 * <!-- End of user code doc for defaultValue_owningProperty -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.defaultValue
	 */
	def defaultValue_owningProperty: Option[UMLProperty[Uml]]

	/**
	 * <!-- Start of user code doc for expr_duration -->
	 * <!-- End of user code doc for expr_duration -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDuration.expr
	 */
	def expr_duration: Option[UMLDuration[Uml]]

	/**
	 * <!-- Start of user code doc for expr_timeExpression -->
	 * <!-- End of user code doc for expr_timeExpression -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTimeExpression.expr
	 */
	def expr_timeExpression: Option[UMLTimeExpression[Uml]]

	/**
	 * <!-- Start of user code doc for guard_activityEdge -->
	 * <!-- End of user code doc for guard_activityEdge -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivityEdge.guard
	 */
	def guard_activityEdge: Option[UMLActivityEdge[Uml]]

	/**
	 * <!-- Start of user code doc for joinSpec_joinNode -->
	 * <!-- End of user code doc for joinSpec_joinNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLJoinNode.joinSpec
	 */
	def joinSpec_joinNode: Option[UMLJoinNode[Uml]]

	/**
	 * <!-- Start of user code doc for lowerValue_owningLower -->
	 * <!-- End of user code doc for lowerValue_owningLower -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMultiplicityElement.lowerValue
	 */
	def lowerValue_owningLower: Option[UMLMultiplicityElement[Uml]]

	/**
	 * <!-- Start of user code doc for max_interval -->
	 * <!-- End of user code doc for max_interval -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterval.max
	 */
	def max_interval: Set[UMLInterval[Uml]]

	/**
	 * <!-- Start of user code doc for maxint_interactionConstraint -->
	 * <!-- End of user code doc for maxint_interactionConstraint -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteractionConstraint.maxint
	 */
	def maxint_interactionConstraint: Option[UMLInteractionConstraint[Uml]]

	/**
	 * <!-- Start of user code doc for min_interval -->
	 * <!-- End of user code doc for min_interval -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterval.min
	 */
	def min_interval: Set[UMLInterval[Uml]]

	/**
	 * <!-- Start of user code doc for minint_interactionConstraint -->
	 * <!-- End of user code doc for minint_interactionConstraint -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteractionConstraint.minint
	 */
	def minint_interactionConstraint: Option[UMLInteractionConstraint[Uml]]

	/**
	 * <!-- Start of user code doc for operand_expression -->
	 * <!-- End of user code doc for operand_expression -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLExpression.operand
	 */
	def operand_expression: Option[UMLExpression[Uml]]

	/**
	 * <!-- Start of user code doc for returnValue_interactionUse -->
	 * <!-- End of user code doc for returnValue_interactionUse -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteractionUse.returnValue
	 */
	def returnValue_interactionUse: Option[UMLInteractionUse[Uml]]

	/**
	 * <!-- Start of user code doc for selector_lifeline -->
	 * <!-- End of user code doc for selector_lifeline -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLifeline.selector
	 */
	def selector_lifeline: Option[UMLLifeline[Uml]]

	/**
	 * <!-- Start of user code doc for specification_owningConstraint -->
	 * <!-- End of user code doc for specification_owningConstraint -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.specification
	 */
	def specification_owningConstraint: Option[UMLConstraint[Uml]]

	/**
	 * <!-- Start of user code doc for specification_owningInstanceSpec -->
	 * <!-- End of user code doc for specification_owningInstanceSpec -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInstanceSpecification.specification
	 */
	def specification_owningInstanceSpec: Option[UMLInstanceSpecification[Uml]]

	/**
	 * <!-- Start of user code doc for upperBound_objectNode -->
	 * <!-- End of user code doc for upperBound_objectNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLObjectNode.upperBound
	 */
	def upperBound_objectNode: Option[UMLObjectNode[Uml]]

	/**
	 * <!-- Start of user code doc for upperValue_owningUpper -->
	 * <!-- End of user code doc for upperValue_owningUpper -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMultiplicityElement.upperValue
	 */
	def upperValue_owningUpper: Option[UMLMultiplicityElement[Uml]]

	/**
	 * <!-- Start of user code doc for value_owningSlot -->
	 * <!-- End of user code doc for value_owningSlot -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLSlot.value
	 */
	def value_owningSlot: Option[UMLSlot[Uml]]

	/**
	 * <!-- Start of user code doc for value_valuePin -->
	 * <!-- End of user code doc for value_valuePin -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValuePin.value
	 */
	def value_valuePin: Option[UMLValuePin[Uml]]

	/**
	 * <!-- Start of user code doc for value_valueSpecificationAction -->
	 * <!-- End of user code doc for value_valueSpecificationAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecificationAction.value
	 */
	def value_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]]

	/**
	 * <!-- Start of user code doc for weight_activityEdge -->
	 * <!-- End of user code doc for weight_activityEdge -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivityEdge.weight
	 */
	def weight_activityEdge: Option[UMLActivityEdge[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		valueSpecification_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLValueSpecification
	 *
	 * <!-- Start of user code doc for valueSpecification_metaAttributes -->
	 * <!-- End of user code doc for valueSpecification_metaAttributes -->
	 */
	def valueSpecification_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			packageableElement_metaAttributes,
			typedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		valueSpecification_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLValueSpecification
	 *
	 * <!-- Start of user code doc for valueSpecification_compositeMetaProperties -->
	 * <!-- End of user code doc for valueSpecification_compositeMetaProperties -->
	 */
	def valueSpecification_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			packageableElement_compositeMetaProperties,
			typedElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		valueSpecification_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLValueSpecification
	 *
	 * <!-- Start of user code doc for valueSpecification_referenceMetaProperties -->
	 * <!-- End of user code doc for valueSpecification_referenceMetaProperties -->
	 */
	def valueSpecification_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			packageableElement_referenceMetaProperties,
			typedElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLValueSpecification
	 *
	 * <!-- Start of user code doc for valueSpecification_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for valueSpecification_forwardReferencesFromMetamodelAssociations -->
	 */
	def valueSpecification_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		typedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLValueSpecification
