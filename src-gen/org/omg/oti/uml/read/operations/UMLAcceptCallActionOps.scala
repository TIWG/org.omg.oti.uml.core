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

import org.omg.oti.uml._
import org.omg.oti.uml.read.api.{UML, UMLTrigger, UMLCallEvent, UMLAcceptCallAction}

import scala.language.postfixOps

// End of user code

/**
 * An AcceptCallAction is an AcceptEventAction that handles the receipt of a synchronous call request. In addition to the values from the Operation input parameters, the Action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller. An AcceptCallAction is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent ReplyAction will complete immediately with no effect.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLAcceptCallActionOps[Uml <: UML] { self: UMLAcceptCallAction[Uml] =>

	import self.ops._

	/**
	 * The number of result OutputPins must be the same as the number of input (in and inout) ownedParameters of the Operation specified by the trigger Event. The type, ordering and multiplicity of each result OutputPin must be consistent with the corresponding input Parameter.
	 *
	 * <!-- Start of user code doc for validate_result_pins -->
   * <!-- End of user code doc for validate_result_pins -->
	 *
	 * {{{
	 * OCL Body let parameter: OrderedSet(Parameter) = trigger.event->asSequence()->first().oclAsType(CallEvent).operation.inputParameters() in
	 * }}}
	 * {{{
	 * result->size() = parameter->size() and
	 * }}}
	 * {{{
	 * Sequence{1..result->size()}->forAll(i | 
	 * }}}
	 * {{{
	 * 	parameter->at(i).type.conformsTo(result->at(i).type) and 
	 * }}}
	 * {{{
	 * 	parameter->at(i).isOrdered = result->at(i).isOrdered and
	 * }}}
	 * {{{
	 * 	parameter->at(i).compatibleWith(result->at(i)))
	 * }}}
	 */
	def validate_result_pins: Boolean = {
		// Start of user code for "result_pins"
    1 != trigger.size ||
      (trigger.head.event match {
        case Some(ce: UMLCallEvent[Uml]) =>
          ce.operation match {
            case Some(op) =>
              result.size != op.inputParameters.size ||
                (op.inputParameters, result)
                .zipped
                .forall {
                          (p, r) =>
                            p.isOrdered == r.isOrdered &&
                              (p._type match {
                                case Some(pt) => pt.conformsTo(r._type)
                                case None     => true
                              }) &&
                              p.compatibleWith(Some(r))
                        }
            case None     => false
          }
        case _                           => true
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
	 * }}}
	 * {{{
	 * trigger->asSequence()->first().event.oclIsKindOf(CallEvent)
	 * }}}
	 */
	def validate_trigger_call_event: Boolean = {
		// Start of user code for "trigger_call_event"
    trigger.toList match {
      case (t: UMLTrigger[Uml]) :: Nil =>
        t.event match {
          case Some(_: UMLCallEvent[Uml]) => true
          case _                          => false
        }
      case _                           => false
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
