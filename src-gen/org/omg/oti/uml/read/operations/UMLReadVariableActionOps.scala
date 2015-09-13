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

import org.omg.oti.uml.read.api.{UMLReadVariableAction, UML, UMLOutputPin}

import scala.language.postfixOps
// End of user code

/**
 * A ReadVariableAction is a VariableAction that retrieves the values of a Variable.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReadVariableActionOps[Uml <: UML] { self: UMLReadVariableAction[Uml] =>

	import self.ops._

	/**
	 * The OutputPin on which the result values are placed.
	 *
	 * <!-- Start of user code doc for result -->
   * <!-- End of user code doc for result -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readVariableAction
	 */
	def result: Option[UMLOutputPin[Uml]] = output headOption

	/**
	 * The multiplicity of the variable must be compatible with the multiplicity of the output pin.
	 *
	 * <!-- Start of user code doc for validate_compatible_multiplicity -->
   * <!-- End of user code doc for validate_compatible_multiplicity -->
	 *
	 * {{{
	 * OCL Body variable.compatibleWith(result)
	 * }}}
	 */
	def validate_compatible_multiplicity: Boolean = {
		// Start of user code for "compatible_multiplicity"
      ???
      // End of user code
	}

	/**
	 * The type and ordering of the result OutputPin are the same as the type and ordering of the variable.
	 *
	 * <!-- Start of user code doc for validate_type_and_ordering -->
   * <!-- End of user code doc for validate_type_and_ordering -->
	 *
	 * {{{
	 * OCL Body result.type =variable.type and 
	 * }}}
	 * {{{
	 * result.isOrdered = variable.isOrdered
	 * }}}
	 */
	def validate_type_and_ordering: Boolean = {
		// Start of user code for "type_and_ordering"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLReadVariableActionOps
