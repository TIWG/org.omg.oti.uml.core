/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import scala.{Boolean,Double,Option,None}
import scala.Predef.String
import java.lang.Integer
// End of user code

/**
  * A ValueSpecification is the specification of a (possibly empty) set of values. A ValueSpecification is a ParameterableElement that may be exposed as a formal TemplateParameter and provided as the actual parameter in the binding of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLValueSpecificationOps[Uml <: UML] { self: UMLValueSpecification[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for argument_message -->
    * <!-- End of user code doc for argument_message -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.argument
    */
  def argument_message: Option[UMLMessage[Uml]] = owner.selectByKindOf { case x: UMLMessage[Uml] => x }

  /**
    * <!-- Start of user code doc for changeExpression_changeEvent -->
    * <!-- End of user code doc for changeExpression_changeEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLChangeEvent.changeExpression
    */
  def changeExpression_changeEvent: Option[UMLChangeEvent[Uml]] = owner.selectByKindOf { case x: UMLChangeEvent[Uml] => x }

  /**
    * <!-- Start of user code doc for defaultValue_owningParameter -->
    * <!-- End of user code doc for defaultValue_owningParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.defaultValue
    */
  def defaultValue_owningParameter: Option[UMLParameter[Uml]] = owner.selectByKindOf { case x: UMLParameter[Uml] => x }

  /**
    * <!-- Start of user code doc for defaultValue_owningProperty -->
    * <!-- End of user code doc for defaultValue_owningProperty -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.defaultValue
    */
  def defaultValue_owningProperty: Option[UMLProperty[Uml]] = owner.selectByKindOf { case x: UMLProperty[Uml] => x }

  /**
    * <!-- Start of user code doc for expr_duration -->
    * <!-- End of user code doc for expr_duration -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDuration.expr
    */
  def expr_duration: Option[UMLDuration[Uml]] = owner.selectByKindOf { case x: UMLDuration[Uml] => x }

  /**
    * <!-- Start of user code doc for expr_timeExpression -->
    * <!-- End of user code doc for expr_timeExpression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeExpression.expr
    */
  def expr_timeExpression: Option[UMLTimeExpression[Uml]] = owner.selectByKindOf { case x: UMLTimeExpression[Uml] => x }

  /**
    * <!-- Start of user code doc for joinSpec_joinNode -->
    * <!-- End of user code doc for joinSpec_joinNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLJoinNode.joinSpec
    */
  def joinSpec_joinNode: Option[UMLJoinNode[Uml]] = owner.selectByKindOf { case x: UMLJoinNode[Uml] => x }

  /**
    * <!-- Start of user code doc for operand_expression -->
    * <!-- End of user code doc for operand_expression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExpression.operand
    */
  def operand_expression: Option[UMLExpression[Uml]] = owner.selectByKindOf { case x: UMLExpression[Uml] => x }

  /**
    * <!-- Start of user code doc for selector_lifeline -->
    * <!-- End of user code doc for selector_lifeline -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLifeline.selector
    */
  def selector_lifeline: Option[UMLLifeline[Uml]] = owner.selectByKindOf { case x: UMLLifeline[Uml] => x }

  /**
    * <!-- Start of user code doc for specification_owningInstanceSpec -->
    * <!-- End of user code doc for specification_owningInstanceSpec -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInstanceSpecification.specification
    */
  def specification_owningInstanceSpec: Option[UMLInstanceSpecification[Uml]] = owner.selectByKindOf { case x: UMLInstanceSpecification[Uml] => x }

  /**
    * <!-- Start of user code doc for value_owningSlot -->
    * <!-- End of user code doc for value_owningSlot -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSlot.value
    */
  def value_owningSlot: Option[UMLSlot[Uml]] = owner.selectByKindOf { case x: UMLSlot[Uml] => x }

  /**
    * <!-- Start of user code doc for value_valuePin -->
    * <!-- End of user code doc for value_valuePin -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValuePin.value
    */
  def value_valuePin: Option[UMLValuePin[Uml]] = owner.selectByKindOf { case x: UMLValuePin[Uml] => x }

  /**
    * <!-- Start of user code doc for value_valueSpecificationAction -->
    * <!-- End of user code doc for value_valueSpecificationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecificationAction.value
    */
  def value_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]] = owner.selectByKindOf { case x: UMLValueSpecificationAction[Uml] => x }

  /**
    * The query booleanValue() gives a single Boolean value when one can be computed.
    *
    * <!-- Start of user code doc for booleanValue -->
    * <!-- End of user code doc for booleanValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (null)
    * }}}
    */
  def booleanValue: Option[Boolean] = {
    // Start of user code for "booleanValue"
    None
    // End of user code
  }

  /**
    * The query integerValue() gives a single Integer value when one can be computed.
    *
    * <!-- Start of user code doc for integerValue -->
    * <!-- End of user code doc for integerValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (null)
    * }}}
    */
  def integerValue: Option[Integer] = {
    // Start of user code for "integerValue"
    None
    // End of user code
  }

  /**
    * The query isCompatibleWith() determines if this ValueSpecification is compatible with the specified ParameterableElement. This ValueSpecification is compatible with ParameterableElement p if the kind of this ValueSpecification is the same as or a subtype of the kind of p. Further, if p is a TypedElement, then the type of this ValueSpecification must be conformant with the type of p.
    *
    * <!-- Start of user code doc for isCompatibleWith -->
    * <!-- End of user code doc for isCompatibleWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (self.oclIsKindOf(p.oclType()) and (p.oclIsKindOf(TypedElement) implies 
    * self.type.conformsTo(p.oclAsType(TypedElement).type)))
    * }}}
    */
  override def isCompatibleWith(p: Option[UMLParameterableElement[Uml]]): Boolean = {
    // Start of user code for "isCompatibleWith"
    false
    // End of user code
  }

  /**
    * The query isComputable() determines whether a value specification can be computed in a model. This operation cannot be fully defined in OCL. A conforming implementation is expected to deliver true for this operation for all ValueSpecifications that it can compute, and to compute all of those for which the operation is true. A conforming implementation is expected to be able to compute at least the value of all LiteralSpecifications.
    *
    * <!-- Start of user code doc for isComputable -->
    * <!-- End of user code doc for isComputable -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  def isComputable: Boolean = {
    // Start of user code for "isComputable"
    false
    // End of user code
  }

  /**
    * The query isNull() returns true when it can be computed that the value is null.
    *
    * <!-- Start of user code doc for isNull -->
    * <!-- End of user code doc for isNull -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  def isNull: Boolean = {
    // Start of user code for "isNull"
    false
    // End of user code
  }

  /**
    * The query realValue() gives a single Real value when one can be computed.
    *
    * <!-- Start of user code doc for realValue -->
    * <!-- End of user code doc for realValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (null)
    * }}}
    */
  def realValue: Option[Double] = {
    // Start of user code for "realValue"
    None
    // End of user code
  }

  /**
    * The query stringValue() gives a single String value when one can be computed.
    *
    * <!-- Start of user code doc for stringValue -->
    * <!-- End of user code doc for stringValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (null)
    * }}}
    */
  def stringValue: Option[String] = {
    // Start of user code for "stringValue"
    None
    // End of user code
  }

  /**
    * The query unlimitedValue() gives a single UnlimitedNatural value when one can be computed.
    *
    * <!-- Start of user code doc for unlimitedValue -->
    * <!-- End of user code doc for unlimitedValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (null)
    * }}}
    */
  def unlimitedValue: Option[Integer] = {
    // Start of user code for "unlimitedValue"
    None
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLValueSpecificationOps
