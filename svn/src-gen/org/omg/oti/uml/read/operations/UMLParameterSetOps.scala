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
import scala.collection.immutable.Set
// End of user code

/**
  * A ParameterSet designates alternative sets of inputs or outputs that a Behavior may use.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLParameterSetOps[Uml <: UML] { self: UMLParameterSet[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A constraint that should be satisfied for the owner of the Parameters in an input ParameterSet to start execution using the values provided for those Parameters, or the owner of the Parameters in an output ParameterSet to end execution providing the values for those Parameters, if all preconditions and conditions on input ParameterSets were satisfied.
    *
    * <!-- Start of user code doc for condition -->
    * <!-- End of user code doc for condition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.condition_parameterSet
    */
  def condition: Set[UMLConstraint[Uml]] = ownedElement.selectByKindOf { case x: UMLConstraint[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedParameterSet_behavior -->
    * <!-- End of user code doc for ownedParameterSet_behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.ownedParameterSet
    */
  def ownedParameterSet_behavior: Option[UMLBehavior[Uml]] = namespace.selectByKindOf { case x: UMLBehavior[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedParameterSet_behavioralFeature -->
    * <!-- End of user code doc for ownedParameterSet_behavioralFeature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioralFeature.ownedParameterSet
    */
  def ownedParameterSet_behavioralFeature: Option[UMLBehavioralFeature[Uml]] = namespace.selectByKindOf { case x: UMLBehavioralFeature[Uml] => x }

  /**
    * If a parameterized entity has input Parameters that are in a ParameterSet, then any inputs that are not in a ParameterSet must be streaming. Same for output Parameters.
    *
    * <!-- Start of user code doc for validate_input -->
    * <!-- End of user code doc for validate_input -->
    *
    * {{{
    * OCL Body ((parameter->exists(direction = ParameterDirectionKind::_'in')) implies 
    *     behavioralFeature.ownedParameter->select(p | p.direction = ParameterDirectionKind::_'in' and p.parameterSet->isEmpty())->forAll(isStream))
    *     and
    * ((parameter->exists(direction = ParameterDirectionKind::out)) implies 
    *     behavioralFeature.ownedParameter->select(p | p.direction = ParameterDirectionKind::out and p.parameterSet->isEmpty())->forAll(isStream))  
    * }}}
    */
  def validate_input: Boolean = {
    // Start of user code for "input"
    ???
    // End of user code
  }

  /**
    * The Parameters in a ParameterSet must all be inputs or all be outputs of the same parameterized entity, and the ParameterSet is owned by that entity.
    *
    * <!-- Start of user code doc for validate_same_parameterized_entity -->
    * <!-- End of user code doc for validate_same_parameterized_entity -->
    *
    * {{{
    * OCL Body parameter->forAll(p1, p2 | self.owner = p1.owner and self.owner = p2.owner and p1.direction = p2.direction)
    * }}}
    */
  def validate_same_parameterized_entity: Boolean = {
    // Start of user code for "same_parameterized_entity"
    ???
    // End of user code
  }

  /**
    * Two ParameterSets cannot have exactly the same set of Parameters.
    *
    * <!-- Start of user code doc for validate_two_parameter_sets -->
    * <!-- End of user code doc for validate_two_parameter_sets -->
    *
    * {{{
    * OCL Body parameter->forAll(parameterSet->forAll(s1, s2 | s1->size() = s2->size() implies s1.parameter->exists(p | not s2.parameter->includes(p))))
    * }}}
    */
  def validate_two_parameter_sets: Boolean = {
    // Start of user code for "two_parameter_sets"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLParameterSetOps
