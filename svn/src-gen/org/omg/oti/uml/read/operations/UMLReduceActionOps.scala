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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A ReduceAction is an Action that reduces a collection to a single value by repeatedly combining the elements of the collection using a reducer Behavior.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReduceActionOps[Uml <: UML] { self: UMLReduceAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that provides the collection to be reduced.
    *
    * <!-- Start of user code doc for collection -->
    * <!-- End of user code doc for collection -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.collection_reduceAction
    */
  def collection: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The output pin on which the result value is placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_reduceAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The type of the collection InputPin must be a collection.
    *
    * <!-- Start of user code doc for validate_input_type_is_collection -->
    * <!-- End of user code doc for validate_input_type_is_collection -->
    *
    * {{{
    * }}}
    */
  def validate_input_type_is_collection: Boolean = {
    // Start of user code for "input_type_is_collection"
    ???
    // End of user code
  }

  /**
    * The type of the output of the reducer Behavior must conform to the type of the result OutputPin.
    *
    * <!-- Start of user code doc for validate_output_types_are_compatible -->
    * <!-- End of user code doc for validate_output_types_are_compatible -->
    *
    * {{{
    * OCL Body reducer.outputParameters().type->forAll(conformsTo(result.type))
    * }}}
    */
  def validate_output_types_are_compatible: Boolean = {
    // Start of user code for "output_types_are_compatible"
    ???
    // End of user code
  }

  /**
    * The reducer Behavior must have two input ownedParameters and one output ownedParameter, where the type of the output Parameter and the type of elements of the input collection conform to the types of the input Parameters.
    *
    * <!-- Start of user code doc for validate_reducer_inputs_output -->
    * <!-- End of user code doc for validate_reducer_inputs_output -->
    *
    * {{{
    * OCL Body let inputs: OrderedSet(Parameter) = reducer.inputParameters() in
    * let outputs: OrderedSet(Parameter) = reducer.outputParameters() in
    * inputs->size()=2 and outputs->size()=1 and
    * inputs.type->forAll(t | 
    * 	outputs.type->forAll(conformsTo(t)) and 
    * 	-- Note that the following only checks the case when the collection is via multiple tokens.
    * 	collection.upper()>1 implies collection.type.conformsTo(t))
    * }}}
    */
  def validate_reducer_inputs_output: Boolean = {
    // Start of user code for "reducer_inputs_output"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReduceActionOps
