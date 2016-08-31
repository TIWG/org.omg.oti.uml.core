/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Option
import scala.Predef.???
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
