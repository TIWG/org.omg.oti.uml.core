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

import org.omg.oti.uml.read.api.{UML, UMLLinkEndCreationData, UMLCreateLinkAction, UMLInputPin}

import scala.language.postfixOps
// End of user code

/**
 * LinkEndCreationData is LinkEndData used to provide values for one end of a link to be created by a CreateLinkAction.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLLinkEndCreationDataOps[Uml <: UML] { self: UMLLinkEndCreationData[Uml] =>

	import self.ops._

	/**
	 * <!-- Start of user code doc for endData_createLinkAction -->
   * <!-- End of user code doc for endData_createLinkAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLCreateLinkAction.endData
	 */
	def endData_createLinkAction: Option[UMLCreateLinkAction[Uml]] = endData_linkAction.selectByKindOf { case x: UMLCreateLinkAction[Uml] => x }

	/**
	 * Adds the insertAt InputPin (if any) to the set of all Pins.
	 *
	 * <!-- Start of user code doc for allPins -->
   * <!-- End of user code doc for allPins -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self.LinkEndData::allPins()->including(insertAt))
	 */
	override def allPins: Set[UMLInputPin[Uml]] = {
		// Start of user code for "allPins"
      ???
      // End of user code
	}

	/**
	 * LinkEndCreationData for ordered Association ends must have a single insertAt InputPin for the insertion point with type UnlimitedNatural and multiplicity of 1..1, if isReplaceAll=false, and must have no InputPin for the insertion point when the association ends are unordered.
	 *
	 * <!-- Start of user code doc for validate_insertAt_pin -->
   * <!-- End of user code doc for validate_insertAt_pin -->
	 *
	 * @body if  not end.isOrdered
	 * then insertAt = null
	 * else
	 * 	not isReplaceAll=false implies
	 * 	insertAt <> null and insertAt->forAll(type=UnlimitedNatural and is(1,1))
	 * endif
	 */
	def validate_insertAt_pin: Boolean = {
		// Start of user code for "insertAt_pin"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLLinkEndCreationDataOps
