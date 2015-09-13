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

import org.omg.oti.uml.read.api.{UML, UMLDestroyLinkAction, UMLInputPin, UMLLinkEndDestructionData}

import scala.language.postfixOps
// End of user code

/**
 * LinkEndDestructionData is LinkEndData used to provide values for one end of a link to be destroyed by a DestroyLinkAction.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLLinkEndDestructionDataOps[Uml <: UML] { self: UMLLinkEndDestructionData[Uml] =>

	import self.ops._

	/**
	 * <!-- Start of user code doc for endData_destroyLinkAction -->
   * <!-- End of user code doc for endData_destroyLinkAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDestroyLinkAction.endData
	 */
	def endData_destroyLinkAction: Option[UMLDestroyLinkAction[Uml]] = endData_linkAction.selectByKindOf { case x: UMLDestroyLinkAction[Uml] => x }

	/**
	 * Adds the destroyAt InputPin (if any) to the set of all Pins.
	 *
	 * <!-- Start of user code doc for allPins -->
   * <!-- End of user code doc for allPins -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (self.LinkEndData::allPins()->including(destroyAt))
	 * }}}
	 */
	override def allPins: Set[UMLInputPin[Uml]] = {
		// Start of user code for "allPins"
      ???
      // End of user code
	}

	/**
	 * LinkEndDestructionData for ordered, nonunique Association ends must have a single destroyAt InputPin if isDestroyDuplicates is false, which must be of type UnlimitedNatural and have a multiplicity of 1..1. Otherwise, the action has no destroyAt input pin.
	 *
	 * <!-- Start of user code doc for validate_destroyAt_pin -->
   * <!-- End of user code doc for validate_destroyAt_pin -->
	 *
	 * {{{
	 * OCL Body if  not end.isOrdered or end.isUnique or isDestroyDuplicates
	 * }}}
	 * {{{
	 * then destroyAt = null
	 * }}}
	 * {{{
	 * else
	 * }}}
	 * {{{
	 * 	destroyAt <> null and 
	 * }}}
	 * {{{
	 * 	destroyAt->forAll(type=UnlimitedNatural and is(1,1))
	 * }}}
	 * {{{
	 * endif
	 * }}}
	 */
	def validate_destroyAt_pin: Boolean = {
		// Start of user code for "destroyAt_pin"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLLinkEndDestructionDataOps
