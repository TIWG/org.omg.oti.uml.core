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
import scala.Predef.???
// End of user code

/**
  * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLObjectFlowOps[Uml <: UML] { self: UMLObjectFlow[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * ObjectNodes connected by an ObjectFlow, with optionally intervening ControlNodes, must have compatible types. In particular, the downstream ObjectNode type must be the same or a supertype of the upstream ObjectNode type.
    *
    * <!-- Start of user code doc for validate_compatible_types -->
    * <!-- End of user code doc for validate_compatible_types -->
    *
    * {{{
    * }}}
    */
  def validate_compatible_types: Boolean = {
    // Start of user code for "compatible_types"
    ???
    // End of user code
  }

  /**
    * A selection Behavior has one input Parameter and one output Parameter. The input Parameter must have the same as or a supertype of the type of the source ObjectNode, be non-unique and have multiplicity 0..*. The output Parameter must be the same or a subtype of the type of source ObjectNode. The Behavior cannot have side effects.
    *
    * <!-- Start of user code doc for validate_input_and_output_parameter -->
    * <!-- End of user code doc for validate_input_and_output_parameter -->
    *
    * {{{
    * OCL Body selection<>null implies
    * 	selection.inputParameters()->size()=1 and
    * 	selection.inputParameters()->forAll(not isUnique and is(0,*)) and
    * 	selection.outputParameters()->size()=1
    * }}}
    */
  def validate_input_and_output_parameter: Boolean = {
    // Start of user code for "input_and_output_parameter"
    ???
    // End of user code
  }

  /**
    * isMulticast and isMultireceive cannot both be true.
    *
    * <!-- Start of user code doc for validate_is_multicast_or_is_multireceive -->
    * <!-- End of user code doc for validate_is_multicast_or_is_multireceive -->
    *
    * {{{
    * OCL Body not (isMulticast and isMultireceive)
    * }}}
    */
  def validate_is_multicast_or_is_multireceive: Boolean = {
    // Start of user code for "is_multicast_or_is_multireceive"
    ???
    // End of user code
  }

  /**
    * ObjectFlows may not have ExecutableNodes at either end.
    *
    * <!-- Start of user code doc for validate_no_executable_nodes -->
    * <!-- End of user code doc for validate_no_executable_nodes -->
    *
    * {{{
    * OCL Body not (source.oclIsKindOf(ExecutableNode) or target.oclIsKindOf(ExecutableNode))
    * }}}
    */
  def validate_no_executable_nodes: Boolean = {
    // Start of user code for "no_executable_nodes"
    ???
    // End of user code
  }

  /**
    * ObjectNodes connected by an ObjectFlow, with optionally intervening ControlNodes, must have the same upperBounds.
    *
    * <!-- Start of user code doc for validate_same_upper_bounds -->
    * <!-- End of user code doc for validate_same_upper_bounds -->
    *
    * {{{
    * }}}
    */
  def validate_same_upper_bounds: Boolean = {
    // Start of user code for "same_upper_bounds"
    ???
    // End of user code
  }

  /**
    * An ObjectFlow may have a selection Behavior only if it has an ObjectNode as its source.
    *
    * <!-- Start of user code doc for validate_selection_behavior -->
    * <!-- End of user code doc for validate_selection_behavior -->
    *
    * {{{
    * OCL Body selection<>null implies source.oclIsKindOf(ObjectNode)
    * }}}
    */
  def validate_selection_behavior: Boolean = {
    // Start of user code for "selection_behavior"
    ???
    // End of user code
  }

  /**
    * An ObjectFlow with a constant weight may not target an ObjectNode, with optionally intervening ControlNodes, that has an upper bound less than the weight.
    *
    * <!-- Start of user code doc for validate_target -->
    * <!-- End of user code doc for validate_target -->
    *
    * {{{
    * }}}
    */
  def validate_target: Boolean = {
    // Start of user code for "target"
    ???
    // End of user code
  }

  /**
    * A transformation Behavior has one input Parameter and one output Parameter. The input Parameter must be the same as or a supertype of the type of object token coming from the source end. The output Parameter must be the same or a subtype of the type of object token expected downstream. The Behavior cannot have side effects.
    *
    * <!-- Start of user code doc for validate_transformation_behavior -->
    * <!-- End of user code doc for validate_transformation_behavior -->
    *
    * {{{
    * OCL Body transformation<>null implies
    * 	transformation.inputParameters()->size()=1 and
    * 	transformation.outputParameters()->size()=1
    * }}}
    */
  def validate_transformation_behavior: Boolean = {
    // Start of user code for "transformation_behavior"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLObjectFlowOps
