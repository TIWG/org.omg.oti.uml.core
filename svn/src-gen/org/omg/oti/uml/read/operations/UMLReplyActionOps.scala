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
  * A ReplyAction is an Action that accepts a set of reply values and a value containing return information produced by a previous AcceptCallAction. The ReplyAction returns the values to the caller of the previous call, completing execution of the call.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReplyActionOps[Uml <: UML] { self: UMLReplyAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The event of the replyToCall Trigger must be a CallEvent.
    *
    * <!-- Start of user code doc for validate_event_on_reply_to_call_trigger -->
    * <!-- End of user code doc for validate_event_on_reply_to_call_trigger -->
    *
    * {{{
    * OCL Body replyToCall.event.oclIsKindOf(CallEvent)
    * }}}
    */
  def validate_event_on_reply_to_call_trigger: Boolean = {
    // Start of user code for "event_on_reply_to_call_trigger"
    ???
    // End of user code
  }

  /**
    * The replyValue InputPins must match the output (return, out, and inout) parameters of the operation of the event of the replyToCall Trigger in number, type, ordering, and multiplicity.
    *
    * <!-- Start of user code doc for validate_pins_match_parameter -->
    * <!-- End of user code doc for validate_pins_match_parameter -->
    *
    * {{{
    * OCL Body let parameter:OrderedSet(Parameter) = replyToCall.event.oclAsType(CallEvent).operation.outputParameters() in
    * replyValue->size()=parameter->size() and
    * Sequence{1..replyValue->size()}->forAll(i |
    * 	replyValue->at(i).type.conformsTo(parameter->at(i).type) and
    * 	replyValue->at(i).isOrdered=parameter->at(i).isOrdered and
    * 	replyValue->at(i).compatibleWith(parameter->at(i)))
    * }}}
    */
  def validate_pins_match_parameter: Boolean = {
    // Start of user code for "pins_match_parameter"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReplyActionOps
