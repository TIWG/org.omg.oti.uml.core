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

import scala.language.postfixOps
// End of user code

/**
 * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLLinkActionOps[Uml <: UML] { self: UMLLinkAction[Uml] =>

	import self.ops._

	/**
	 * The LinkEndData identifying the values on the ends of the links acting on by this LinkAction.
	 *
	 * <!-- Start of user code doc for endData -->
   * <!-- End of user code doc for endData -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndData.endData_linkAction
	 */
	def endData: Iterable[UMLLinkEndData[Uml]] = ownedElement.selectByKindOf { case x: UMLLinkEndData[Uml] => x }

	/**
	 * InputPins used by the LinkEndData of the LinkAction.
	 *
	 * <!-- Start of user code doc for inputValue -->
   * <!-- End of user code doc for inputValue -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.inputValue_linkAction
	 */
	def inputValue: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

	/**
	 * Returns the Association acted on by this LinkAction.
	 *
	 * <!-- Start of user code doc for association -->
   * <!-- End of user code doc for association -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (endData->asSequence()->first().end.association)
	 * }}}
	 */
	def association: Option[UMLAssociation[Uml]] = {
		// Start of user code for "association"
      ???
      // End of user code
	}

	/**
	 * The ends of the endData must not be static.
	 *
	 * <!-- Start of user code doc for validate_not_static -->
   * <!-- End of user code doc for validate_not_static -->
	 *
	 * {{{
	 * OCL Body endData->forAll(not end.isStatic)
	 * }}}
	 */
	def validate_not_static: Boolean = {
		// Start of user code for "not_static"
      ???
      // End of user code
	}

	/**
	 * The ends of the endData must all be from the same Association and include all and only the memberEnds of that association.
	 *
	 * <!-- Start of user code doc for validate_same_association -->
   * <!-- End of user code doc for validate_same_association -->
	 *
	 * {{{
	 * OCL Body endData.end = self.association().memberEnd->asBag()
	 * }}}
	 */
	def validate_same_association: Boolean = {
		// Start of user code for "same_association"
      ???
      // End of user code
	}

	/**
	 * The inputValue InputPins is the same as the union of all the InputPins referenced by the endData.
	 *
	 * <!-- Start of user code doc for validate_same_pins -->
   * <!-- End of user code doc for validate_same_pins -->
	 *
	 * {{{
	 * OCL Body inputValue->asBag()=endData.allPins()
	 * }}}
	 */
	def validate_same_pins: Boolean = {
		// Start of user code for "same_pins"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLLinkActionOps
