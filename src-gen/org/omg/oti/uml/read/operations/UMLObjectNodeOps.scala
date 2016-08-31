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
  * An ObjectNode is an abstract ActivityNode that may hold tokens within the object flow in an Activity. ObjectNodes also support token selection, limitation on the number of tokens held, specification of the state required for tokens being held, and carrying control values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLObjectNodeOps[Uml <: UML] { self: UMLObjectNode[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * A selection Behavior has one input Parameter and one output Parameter. The input Parameter must have the same type as  or a supertype of the type of ObjectNode, be non-unique, and have multiplicity 0..*. The output Parameter must be the same or a subtype of the type of ObjectNode. The Behavior cannot have side effects.
    *
    * <!-- Start of user code doc for validate_input_output_parameter -->
    * <!-- End of user code doc for validate_input_output_parameter -->
    *
    * {{{
    * OCL Body selection<>null implies
    * 	selection.inputParameters()->size()=1 and
    * 	selection.inputParameters()->forAll(p | not p.isUnique and p.is(0,*) and self.type.conformsTo(p.type)) and
    * 	selection.outputParameters()->size()=1 and
    * 		selection.inputParameters()->forAll(p | self.type.conformsTo(p.type))
    * 	
    * }}}
    */
  def validate_input_output_parameter: Boolean = {
    // Start of user code for "input_output_parameter"
    ???
    // End of user code
  }

  /**
    * If isControlType=false, the ActivityEdges incoming to or outgoing from an ObjectNode must all be ObjectFlows.
    *
    * <!-- Start of user code doc for validate_object_flow_edges -->
    * <!-- End of user code doc for validate_object_flow_edges -->
    *
    * {{{
    * OCL Body (not isControlType) implies incoming->union(outgoing)->forAll(oclIsKindOf(ObjectFlow))
    * }}}
    */
  def validate_object_flow_edges: Boolean = {
    // Start of user code for "object_flow_edges"
    ???
    // End of user code
  }

  /**
    * If an ObjectNode has a selection Behavior, then the ordering of the object node is ordered, and vice versa.
    *
    * <!-- Start of user code doc for validate_selection_behavior -->
    * <!-- End of user code doc for validate_selection_behavior -->
    *
    * {{{
    * OCL Body (selection<>null) = (ordering=ObjectNodeOrderingKind::ordered)
    * }}}
    */
  def validate_selection_behavior: Boolean = {
    // Start of user code for "selection_behavior"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLObjectNodeOps
