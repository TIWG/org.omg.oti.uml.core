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

import org.omg.oti.uml.read.api.{UMLActionInputPin, UML, UMLAction}

import scala.language.postfixOps
// End of user code

/**
 * An ActionInputPin is a kind of InputPin that executes an Action to determine the values to input to another Action.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActionInputPinOps[Uml <: UML] { self: UMLActionInputPin[Uml] =>

	import self.ops._

	/**
	 * The Action used to provide the values of the ActionInputPin.
	 *
	 * <!-- Start of user code doc for fromAction -->
   * <!-- End of user code doc for fromAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.fromAction_actionInputPin
	 */
	def fromAction: Option[UMLAction[Uml]] = ownedElement.selectByKindOf { case x: UMLAction[Uml] => x } headOption

	/**
	 * The fromAction of an ActionInputPin must only have ActionInputPins as InputPins.
	 *
	 * <!-- Start of user code doc for validate_input_pin -->
   * <!-- End of user code doc for validate_input_pin -->
	 *
	 * {{{
	 * OCL Body fromAction.input->forAll(oclIsKindOf(ActionInputPin))
	 * }}}
	 */
	def validate_input_pin: Boolean = {
		// Start of user code for "input_pin"
    fromAction match {
      case Some(action) => 
        action.input.forall { p =>
          p match {
            case (_: UMLActionInputPin[Uml]) =>
              true
            case _ =>
              false
          }
        }
      case None =>
        false
    }
    // End of user code
	}

	/**
	 * The fromAction of an ActionInputPin cannot have ActivityEdges coming into or out of it or its Pins.
	 *
	 * <!-- Start of user code doc for validate_no_control_or_object_flow -->
   * <!-- End of user code doc for validate_no_control_or_object_flow -->
	 *
	 * {{{
	 * OCL Body fromAction.incoming->union(outgoing)->isEmpty() and
	 * }}}
	 * {{{
	 * fromAction.input.incoming->isEmpty() and
	 * }}}
	 * {{{
	 * fromAction.output.outgoing->isEmpty()
	 * }}}
	 */
	def validate_no_control_or_object_flow: Boolean = {
		// Start of user code for "no_control_or_object_flow"
    fromAction match {
      case Some(action) => 
        action.incoming.union(action.outgoing).isEmpty &&
        action.input.forall ( _.incoming.isEmpty ) && 
        action.output.forall ( _.incoming.isEmpty )
      case None =>
        false
    }
    // End of user code
	}

	/**
	 * The fromAction of an ActionInputPin must have exactly one OutputPin.
	 *
	 * <!-- Start of user code doc for validate_one_output_pin -->
   * <!-- End of user code doc for validate_one_output_pin -->
	 *
	 * {{{
	 * OCL Body fromAction.output->size() = 1
	 * }}}
	 */
	def validate_one_output_pin: Boolean = {
		// Start of user code for "one_output_pin"
      fromAction match {
        case Some(action) =>
          action.output.size == 1
        case None =>
          false
      }
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLActionInputPinOps
