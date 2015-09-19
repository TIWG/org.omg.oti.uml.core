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
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
 * An OpaqueAction is an Action whose functionality is not specified within UML.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLOpaqueActionOps[Uml <: UML] { self: UMLOpaqueAction[Uml] =>

// Start of user code for class imports
// End of user code


	/**
	 * The InputPins providing inputs to the OpaqueAction.
	 *
	 * <!-- Start of user code doc for inputValue -->
   * <!-- End of user code doc for inputValue -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.inputValue_opaqueAction
	 */
	def inputValue: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

	/**
	 * The OutputPins on which the OpaqueAction provides outputs.
	 *
	 * <!-- Start of user code doc for outputValue -->
   * <!-- End of user code doc for outputValue -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.outputValue_opaqueAction
	 */
	def outputValue: Set[UMLOutputPin[Uml]] = output.toSet[UMLOutputPin[Uml]]

	/**
	 * If the language attribute is not empty, then the size of the body and language lists must be the same.
	 *
	 * <!-- Start of user code doc for validate_language_body_size -->
   * <!-- End of user code doc for validate_language_body_size -->
	 *
	 * {{{
	 * OCL Body language->notEmpty() implies (_'body'->size() = language->size())
	 * }}}
	 */
	def validate_language_body_size: Boolean = {
		// Start of user code for "language_body_size"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLOpaqueActionOps
