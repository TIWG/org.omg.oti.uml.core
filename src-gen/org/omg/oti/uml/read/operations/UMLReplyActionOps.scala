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

import org.omg.oti.uml.read.api.{UML, UMLReplyAction}

import scala.language.postfixOps
// End of user code

/**
 * A ReplyAction is an Action that accepts a set of reply values and a value containing return information produced by a previous AcceptCallAction. The ReplyAction returns the values to the caller of the previous call, completing execution of the call.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReplyActionOps[Uml <: UML] { self: UMLReplyAction[Uml] =>

	import self.ops._

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
	 * }}}
	 * {{{
	 * replyValue->size()=parameter->size() and
	 * }}}
	 * {{{
	 * Sequence{1..replyValue->size()}->forAll(i |
	 * }}}
	 * {{{
	 * 	replyValue->at(i).type.conformsTo(parameter->at(i).type) and
	 * }}}
	 * {{{
	 * 	replyValue->at(i).isOrdered=parameter->at(i).isOrdered and
	 * }}}
	 * {{{
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
