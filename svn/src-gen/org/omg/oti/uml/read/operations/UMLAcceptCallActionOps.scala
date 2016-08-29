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
import scala.Some
import scala.Predef._
import scala.collection.immutable.::
import scala.collection.immutable.Nil

// End of user code

/**
  * An AcceptCallAction is an AcceptEventAction that handles the receipt of a synchronous call request. In addition to the values from the Operation input parameters, the Action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller. An AcceptCallAction is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent ReplyAction will complete immediately with no effect.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAcceptCallActionOps[Uml <: UML] { self: UMLAcceptCallAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The number of result OutputPins must be the same as the number of input (in and inout) ownedParameters of the Operation specified by the trigger Event. The type, ordering and multiplicity of each result OutputPin must be consistent with the corresponding input Parameter.
    *
    * <!-- Start of user code doc for validate_result_pins -->
    * <!-- End of user code doc for validate_result_pins -->
    *
    * {{{
    * OCL Body let parameter: OrderedSet(Parameter) = trigger.event->asSequence()->first().oclAsType(CallEvent).operation.inputParameters() in
    * result->size() = parameter->size() and
    * Sequence{1..result->size()}->forAll(i | 
    * 	parameter->at(i).type.conformsTo(result->at(i).type) and 
    * 	parameter->at(i).isOrdered = result->at(i).isOrdered and
    * 	parameter->at(i).compatibleWith(result->at(i)))
    * }}}
    */
  def validate_result_pins: Boolean = {
    // Start of user code for "result_pins"
    1 != trigger.size ||
    (trigger.head.event.fold[Boolean](true) {
        case ce: UMLCallEvent[Uml] =>
          ce
          .operation
          .fold[Boolean](false) {
            op =>
              result.size != op.inputParameters.size ||
                (op.inputParameters, result)
                .zipped
                .forall {
                          (p, r) =>
                            p.isOrdered == r.isOrdered &&
                              p._type.fold[Boolean](true) {
                                pt => pt.conformsTo(r._type)
                              } &&
                              p.compatibleWith(Some(r))
                        }
          }
        case _ => true
      })
    // End of user code
  }

  /**
    * The action must have exactly one trigger, which must be for a CallEvent.
    *
    * <!-- Start of user code doc for validate_trigger_call_event -->
    * <!-- End of user code doc for validate_trigger_call_event -->
    *
    * {{{
    * OCL Body trigger->size()=1 and
    * trigger->asSequence()->first().event.oclIsKindOf(CallEvent)
    * }}}
    */
  def validate_trigger_call_event: Boolean = {
    // Start of user code for "trigger_call_event"
    trigger.toList match {
      case (t: UMLTrigger[Uml]) :: Nil =>
        t.event.fold[Boolean](false) {
          case _: UMLCallEvent[Uml] => true
          case _ => false
        }
      case _ => false
    }
    // End of user code
  }

  /**
    * isUnmrashall must be true for an AcceptCallAction.
    *
    * <!-- Start of user code doc for validate_unmarshall -->
    * <!-- End of user code doc for validate_unmarshall -->
    *
    * {{{
    * OCL Body isUnmarshall = true
    * }}}
    */
  def validate_unmarshall: Boolean = {
    // Start of user code for "unmarshall"
    isUnmarshall
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLAcceptCallActionOps
