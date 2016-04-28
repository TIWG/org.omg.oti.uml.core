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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
  * A Constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an Element or set of Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConstraintOps[Uml <: UML] { self: UMLConstraint[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for condition_extend -->
    * <!-- End of user code doc for condition_extend -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtend.condition
    */
  def condition_extend: Option[UMLExtend[Uml]] = owner.selectByKindOf { case x: UMLExtend[Uml] => x }

  /**
    * <!-- Start of user code doc for condition_parameterSet -->
    * <!-- End of user code doc for condition_parameterSet -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterSet.condition
    */
  def condition_parameterSet: Option[UMLParameterSet[Uml]] = owner.selectByKindOf { case x: UMLParameterSet[Uml] => x }

  /**
    * <!-- Start of user code doc for invariant_stateInvariant -->
    * <!-- End of user code doc for invariant_stateInvariant -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStateInvariant.invariant
    */
  def invariant_stateInvariant: Option[UMLStateInvariant[Uml]] = owner.selectByKindOf { case x: UMLStateInvariant[Uml] => x }

  /**
    * <!-- Start of user code doc for preCondition_protocolTransition -->
    * <!-- End of user code doc for preCondition_protocolTransition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolTransition.preCondition
    */
  def preCondition_protocolTransition: Option[UMLProtocolTransition[Uml]] = guard_transition.selectByKindOf { case x: UMLProtocolTransition[Uml] => x }

  /**
    * The ValueSpecification for a Constraint must evaluate to a Boolean value.
    *
    * <!-- Start of user code doc for validate_boolean_value -->
    * <!-- End of user code doc for validate_boolean_value -->
    *
    * {{{
    * }}}
    */
  def validate_boolean_value: Boolean = {
    // Start of user code for "boolean_value"
    ???
    // End of user code
  }

  /**
    * Evaluating the ValueSpecification for a Constraint must not have side effects.
    *
    * <!-- Start of user code doc for validate_no_side_effects -->
    * <!-- End of user code doc for validate_no_side_effects -->
    *
    * {{{
    * }}}
    */
  def validate_no_side_effects: Boolean = {
    // Start of user code for "no_side_effects"
    ???
    // End of user code
  }

  /**
    * A Constraint cannot be applied to itself.
    *
    * <!-- Start of user code doc for validate_not_apply_to_self -->
    * <!-- End of user code doc for validate_not_apply_to_self -->
    *
    * {{{
    * OCL Body not constrainedElement->includes(self)
    * }}}
    */
  def validate_not_apply_to_self: Boolean = {
    // Start of user code for "not_apply_to_self"
    !( constrainedElement.contains(self) )
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLConstraintOps
