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

import org.omg.oti.uml.read.api.{UML, UMLReadSelfAction, UMLOutputPin}

import scala.language.postfixOps
// End of user code

/**
 * A ReadSelfAction is an Action that retrieves the context object of the Behavior execution within which the ReadSelfAction execution is taking place.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReadSelfActionOps[Uml <: UML] { self: UMLReadSelfAction[Uml] =>

	import self.ops._

	/**
	 * The OutputPin on which the context object is placed.
	 *
	 * <!-- Start of user code doc for result -->
   * <!-- End of user code doc for result -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readSelfAction
	 */
	def result: Option[UMLOutputPin[Uml]] = output headOption

	/**
	 * A ReadSelfAction must have a context Classifier.
	 *
	 * <!-- Start of user code doc for validate_contained -->
   * <!-- End of user code doc for validate_contained -->
	 *
	 * {{{
	 * OCL Body _'context' <> null
	 * }}}
	 */
	def validate_contained: Boolean = {
		// Start of user code for "contained"
      ???
      // End of user code
	}

	/**
	 * The multiplicity of the result OutputPin is 1..1.
	 *
	 * <!-- Start of user code doc for validate_multiplicity -->
   * <!-- End of user code doc for validate_multiplicity -->
	 *
	 * {{{
	 * OCL Body result.is(1,1)
	 * }}}
	 */
	def validate_multiplicity: Boolean = {
		// Start of user code for "multiplicity"
      ???
      // End of user code
	}

	/**
	 * If the ReadSelfAction is contained in an Behavior that is acting as a method, then the Operation of the method must not be static.
	 *
	 * <!-- Start of user code doc for validate_not_static -->
   * <!-- End of user code doc for validate_not_static -->
	 *
	 * {{{
	 * OCL Body let behavior: Behavior = self.containingBehavior() in
	 * }}}
	 * {{{
	 * behavior.specification<>null implies not behavior.specification.isStatic
	 * }}}
	 */
	def validate_not_static: Boolean = {
		// Start of user code for "not_static"
      ???
      // End of user code
	}

	/**
	 * The type of the result OutputPin is the context Classifier.
	 *
	 * <!-- Start of user code doc for validate__type -->
   * <!-- End of user code doc for validate__type -->
	 *
	 * {{{
	 * OCL Body result.type = _'context'
	 * }}}
	 */
	def validate__type: Boolean = {
		// Start of user code for "_type"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLReadSelfActionOps
