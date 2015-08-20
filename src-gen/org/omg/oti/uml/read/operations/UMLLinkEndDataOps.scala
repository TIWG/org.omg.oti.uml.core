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
 * LinkEndData is an Element that identifies on end of a link to be read or written by a LinkAction. As a link (that is not a link object) cannot be passed as a runtime value to or from an Action, it is instead identified by its end objects and qualifier values, if any. A LinkEndData instance provides these values for a single Association end.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLLinkEndDataOps[Uml <: UML] { self: UMLLinkEndData[Uml] =>

	import self.ops._

	/**
	 * A set of QualifierValues used to provide values for the qualifiers of the end.
	 *
	 * <!-- Start of user code doc for qualifier -->
   * <!-- End of user code doc for qualifier -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLQualifierValue.qualifier_linkEndData
	 */
	def qualifier: Set[UMLQualifierValue[Uml]] = ownedElement.selectByKindOf { case x: UMLQualifierValue[Uml] => x }

	/**
	 * <!-- Start of user code doc for endData_linkAction -->
   * <!-- End of user code doc for endData_linkAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLLinkAction.endData
	 */
	def endData_linkAction: Option[UMLLinkAction[Uml]] = owner.selectByKindOf { case x: UMLLinkAction[Uml] => x }

	/**
	 * Returns all the InputPins referenced by this LinkEndData. By default this includes the value and qualifier InputPins, but subclasses may override the operation to add other InputPins.
	 *
	 * <!-- Start of user code doc for allPins -->
   * <!-- End of user code doc for allPins -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (value->asBag()->union(qualifier.value))
	 */
	def allPins: Set[UMLInputPin[Uml]] = {
		// Start of user code for "allPins"
      ???
      // End of user code
	}

	/**
	 * The value InputPin is not also the qualifier value InputPin.
	 *
	 * <!-- Start of user code doc for validate_end_object_input_pin -->
   * <!-- End of user code doc for validate_end_object_input_pin -->
	 *
	 * @body value->excludesAll(qualifier.value)
	 */
	def validate_end_object_input_pin: Boolean = {
		// Start of user code for "end_object_input_pin"
      ???
      // End of user code
	}

	/**
	 * The multiplicity of the value InputPin must be 1..1.
	 *
	 * <!-- Start of user code doc for validate_multiplicity -->
   * <!-- End of user code doc for validate_multiplicity -->
	 *
	 * @body value<>null implies value.is(1,1)
	 */
	def validate_multiplicity: Boolean = {
		// Start of user code for "multiplicity"
      ???
      // End of user code
	}

	/**
	 * The Property must be an Association memberEnd.
	 *
	 * <!-- Start of user code doc for validate_property_is_association_end -->
   * <!-- End of user code doc for validate_property_is_association_end -->
	 *
	 * @body end.association <> null
	 */
	def validate_property_is_association_end: Boolean = {
		// Start of user code for "property_is_association_end"
      ???
      // End of user code
	}

	/**
	 * The qualifiers must be qualifiers of the Association end.
	 *
	 * <!-- Start of user code doc for validate_qualifiers -->
   * <!-- End of user code doc for validate_qualifiers -->
	 *
	 * @body end.qualifier->includesAll(qualifier.qualifier)
	 */
	def validate_qualifiers: Boolean = {
		// Start of user code for "qualifiers"
      ???
      // End of user code
	}

	/**
	 * The type of the value InputPin conforms to the type of the Association end.
	 *
	 * <!-- Start of user code doc for validate_same_type -->
   * <!-- End of user code doc for validate_same_type -->
	 *
	 * @body value<>null implies value.type.conformsTo(end.type)
	 */
	def validate_same_type: Boolean = {
		// Start of user code for "same_type"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLLinkEndDataOps
