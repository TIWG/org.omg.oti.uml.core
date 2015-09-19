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
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * A DurationConstraint is a Constraint that refers to a DurationInterval.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLDurationConstraintOps[Uml <: UML] { self: UMLDurationConstraint[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * The DurationInterval constraining the duration.
	 *
	 * <!-- Start of user code doc for specification -->
   * <!-- End of user code doc for specification -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDurationInterval.specification_durationConstraint
	 */
	override def specification: Option[UMLDurationInterval[Uml]] = ownedElement.selectByKindOf { case x: UMLDurationInterval[Uml] => x } headOption

	/**
	 * The multiplicity of firstEvent must be 2 if the multiplicity of constrainedElement is 2. Otherwise the multiplicity of firstEvent is 0.
	 *
	 * <!-- Start of user code doc for validate_first_event_multiplicity -->
   * <!-- End of user code doc for validate_first_event_multiplicity -->
	 *
	 * {{{
	 * OCL Body if (constrainedElement->size() = 2)
	 *   then (firstEvent->size() = 2) else (firstEvent->size() = 0) 
	 * endif
	 * }}}
	 */
	def validate_first_event_multiplicity: Boolean = {
		// Start of user code for "first_event_multiplicity"
      ???
      // End of user code
	}

	/**
	 * A DurationConstraint has either one or two constrainedElements.
	 *
	 * <!-- Start of user code doc for validate_has_one_or_two_constrainedElements -->
   * <!-- End of user code doc for validate_has_one_or_two_constrainedElements -->
	 *
	 * {{{
	 * OCL Body constrainedElement->size() = 1 or constrainedElement->size()=2
	 * }}}
	 */
	def validate_has_one_or_two_constrainedElements: Boolean = {
		// Start of user code for "has_one_or_two_constrainedElements"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLDurationConstraintOps
