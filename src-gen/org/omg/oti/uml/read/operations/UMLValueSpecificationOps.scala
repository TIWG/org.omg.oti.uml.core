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
import scala.collection.JavaConversions._
import scala.language.postfixOps
import scala.util.Try
import scala.util.Failure
import scala.util.Success

// End of user code

/**
 * A ValueSpecification is the specification of a (possibly empty) set of values. A ValueSpecification is a ParameterableElement that may be exposed as a formal TemplateParameter and provided as the actual parameter in the binding of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLValueSpecificationOps[Uml <: UML] { self: UMLValueSpecification[Uml] =>	

	import self.ops._

	/**
	 * <!-- Start of user code doc for argument_message -->
	 * <!-- End of user code doc for argument_message -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLMessage.argument
	 */
	def argument_message: Option[UMLMessage[Uml]] = owner.selectByKindOf { case x: UMLMessage[Uml] => x }

	/**
	 * <!-- Start of user code doc for changeExpression_changeEvent -->
	 * <!-- End of user code doc for changeExpression_changeEvent -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLChangeEvent.changeExpression
	 */
	def changeExpression_changeEvent: Option[UMLChangeEvent[Uml]] = owner.selectByKindOf { case x: UMLChangeEvent[Uml] => x }

	/**
	 * <!-- Start of user code doc for defaultValue_owningParameter -->
	 * <!-- End of user code doc for defaultValue_owningParameter -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameter.defaultValue
	 */
	def defaultValue_owningParameter: Option[UMLParameter[Uml]] = owner.selectByKindOf { case x: UMLParameter[Uml] => x }

	/**
	 * <!-- Start of user code doc for defaultValue_owningProperty -->
	 * <!-- End of user code doc for defaultValue_owningProperty -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.defaultValue
	 */
	def defaultValue_owningProperty: Option[UMLProperty[Uml]] = owner.selectByKindOf { case x: UMLProperty[Uml] => x }

	/**
	 * <!-- Start of user code doc for expr_duration -->
	 * <!-- End of user code doc for expr_duration -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDuration.expr
	 */
	def expr_duration: Option[UMLDuration[Uml]] = owner.selectByKindOf { case x: UMLDuration[Uml] => x }

	/**
	 * <!-- Start of user code doc for expr_timeExpression -->
	 * <!-- End of user code doc for expr_timeExpression -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTimeExpression.expr
	 */
	def expr_timeExpression: Option[UMLTimeExpression[Uml]] = owner.selectByKindOf { case x: UMLTimeExpression[Uml] => x }

	/**
	 * <!-- Start of user code doc for joinSpec_joinNode -->
	 * <!-- End of user code doc for joinSpec_joinNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLJoinNode.joinSpec
	 */
	def joinSpec_joinNode: Option[UMLJoinNode[Uml]] = owner.selectByKindOf { case x: UMLJoinNode[Uml] => x }

	/**
	 * <!-- Start of user code doc for operand_expression -->
	 * <!-- End of user code doc for operand_expression -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLExpression.operand
	 */
	def operand_expression: Option[UMLExpression[Uml]] = owner.selectByKindOf { case x: UMLExpression[Uml] => x }

	/**
	 * <!-- Start of user code doc for selector_lifeline -->
	 * <!-- End of user code doc for selector_lifeline -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLLifeline.selector
	 */
	def selector_lifeline: Option[UMLLifeline[Uml]] = owner.selectByKindOf { case x: UMLLifeline[Uml] => x }

	/**
	 * <!-- Start of user code doc for specification_owningInstanceSpec -->
	 * <!-- End of user code doc for specification_owningInstanceSpec -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInstanceSpecification.specification
	 */
	def specification_owningInstanceSpec: Option[UMLInstanceSpecification[Uml]] = owner.selectByKindOf { case x: UMLInstanceSpecification[Uml] => x }

	/**
	 * <!-- Start of user code doc for value_owningSlot -->
	 * <!-- End of user code doc for value_owningSlot -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLSlot.value
	 */
	def value_owningSlot: Option[UMLSlot[Uml]] = owner.selectByKindOf { case x: UMLSlot[Uml] => x }

	/**
	 * <!-- Start of user code doc for value_valuePin -->
	 * <!-- End of user code doc for value_valuePin -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValuePin.value
	 */
	def value_valuePin: Option[UMLValuePin[Uml]] = owner.selectByKindOf { case x: UMLValuePin[Uml] => x }

	/**
	 * <!-- Start of user code doc for value_valueSpecificationAction -->
	 * <!-- End of user code doc for value_valueSpecificationAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecificationAction.value
	 */
	def value_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]] = owner.selectByKindOf { case x: UMLValueSpecificationAction[Uml] => x }

	/**
	 * The query booleanValue() gives a single Boolean value when one can be computed.
	 *
	 * <!-- Start of user code doc for booleanValue -->
	 * <!-- End of user code doc for booleanValue -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (null)
	 */
	def booleanValue: Option[Boolean] = {
		// Start of user code for "booleanValue"
    	???
    	// End of user code
	}

	/**
	 * The query integerValue() gives a single Integer value when one can be computed.
	 *
	 * <!-- Start of user code doc for integerValue -->
	 * <!-- End of user code doc for integerValue -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (null)
	 */
	def integerValue: Option[Integer] = {
		// Start of user code for "integerValue"
    	???
    	// End of user code
	}

	/**
	 * The query isCompatibleWith() determines if this ValueSpecification is compatible with the specified ParameterableElement. This ValueSpecification is compatible with ParameterableElement p if the kind of this ValueSpecification is the same as or a subtype of the kind of p. Further, if p is a TypedElement, then the type of this ValueSpecification must be conformant with the type of p.
	 *
	 * <!-- Start of user code doc for isCompatibleWith -->
	 * <!-- End of user code doc for isCompatibleWith -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (self.oclIsKindOf(p.oclType()) and (p.oclIsKindOf(TypedElement) implies 
	 * self.type.conformsTo(p.oclAsType(TypedElement).type)))
	 */
	override def isCompatibleWith(p: Option[UMLParameterableElement[Uml]]): Boolean = {
		// Start of user code for "isCompatibleWith"
    	???
    	// End of user code
	}

	/**
	 * The query isComputable() determines whether a value specification can be computed in a model. This operation cannot be fully defined in OCL. A conforming implementation is expected to deliver true for this operation for all ValueSpecifications that it can compute, and to compute all of those for which the operation is true. A conforming implementation is expected to be able to compute at least the value of all LiteralSpecifications.
	 *
	 * <!-- Start of user code doc for isComputable -->
	 * <!-- End of user code doc for isComputable -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (false)
	 */
	def isComputable: Boolean = {
		// Start of user code for "isComputable"
    	???
    	// End of user code
	}

	/**
	 * The query isNull() returns true when it can be computed that the value is null.
	 *
	 * <!-- Start of user code doc for isNull -->
	 * <!-- End of user code doc for isNull -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (false)
	 */
	def isNull: Boolean = {
		// Start of user code for "isNull"
    	???
    	// End of user code
	}

	/**
	 * The query realValue() gives a single Real value when one can be computed.
	 *
	 * <!-- Start of user code doc for realValue -->
	 * <!-- End of user code doc for realValue -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (null)
	 */
	def realValue: Option[Double] = {
		// Start of user code for "realValue"
    	???
    	// End of user code
	}

	/**
	 * The query stringValue() gives a single String value when one can be computed.
	 *
	 * <!-- Start of user code doc for stringValue -->
	 * <!-- End of user code doc for stringValue -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (null)
	 */
	def stringValue: Option[String] = {
		// Start of user code for "stringValue"
    	???
    	// End of user code
	}

	/**
	 * The query unlimitedValue() gives a single UnlimitedNatural value when one can be computed.
	 *
	 * <!-- Start of user code doc for unlimitedValue -->
	 * <!-- End of user code doc for unlimitedValue -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (null)
	 */
	def unlimitedValue: Option[Integer] = {
		// Start of user code for "unlimitedValue"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLValueSpecificationOps
