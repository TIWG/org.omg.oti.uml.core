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

import org.omg.oti.uml.read.api.{UMLProperty, UML, UMLReadLinkAction, UMLOutputPin}

import scala.language.postfixOps
// End of user code

/**
 * A ReadLinkAction is a LinkAction that navigates across an Association to retrieve the objects on one end.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReadLinkActionOps[Uml <: UML] { self: UMLReadLinkAction[Uml] =>

  import self.ops._

  /**
   * The OutputPin on which the objects retrieved from the "open" end of
   * those links whose values on other ends are given by the endData.
   *
   * <!-- Start of user code doc for result -->
   * <!-- End of user code doc for result -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
   * @opposite org.omg.oti.api.UMLOutputPin.result_readLinkAction
   */
  def result: Option[UMLOutputPin[Uml]] =
    output
    .headOption

  /**
   * Returns the ends corresponding to endData with no value InputPin.
   * (A well-formed ReadLinkAction is constrained to have only one of these.)
   *
   * <!-- Start of user code doc for openEnd -->
   * <!-- End of user code doc for openEnd -->
   *
   * @operation ordered="true" unique="true" multiplicity="0..*"
   * @body result = (endData->select(value=null).end->asOrderedSet())
   */
  def openEnd: Seq[UMLProperty[Uml]] = {
    // Start of user code for "openEnd"
      ???
      // End of user code
  }

  /**
   * The multiplicity of the open Association end must be compatible with
   * the multiplicity of the result OutputPin.
   *
   * <!-- Start of user code doc for validate_compatible_multiplicity -->
   * <!-- End of user code doc for validate_compatible_multiplicity -->
   *
   * @body self.openEnd()->first().compatibleWith(result)
   */
  def validate_compatible_multiplicity: Boolean = {
    // Start of user code for "compatible_multiplicity"
      ???
      // End of user code
  }

  /**
   * The open end must be navigable.
   *
   * <!-- Start of user code doc for validate_navigable_open_end -->
   * <!-- End of user code doc for validate_navigable_open_end -->
   *
   * @body self.openEnd()->first().isNavigable()
   */
  def validate_navigable_open_end: Boolean = {
    // Start of user code for "navigable_open_end"
      ???
      // End of user code
  }

  /**
   * Exactly one linkEndData specification (corresponding to the "open" end) must not have an value InputPin.
   *
   * <!-- Start of user code doc for validate_one_open_end -->
   * <!-- End of user code doc for validate_one_open_end -->
   *
   * @body self.openEnd()->size() = 1
   */
  def validate_one_open_end: Boolean = {
    // Start of user code for "one_open_end"
      ???
      // End of user code
  }

  /**
   * The type and ordering of the result OutputPin are same as the type and ordering of the open Association end.
   *
   * <!-- Start of user code doc for validate_type_and_ordering -->
   * <!-- End of user code doc for validate_type_and_ordering -->
   *
   * @body self.openEnd()->forAll(type=result.type and isOrdered=result.isOrdered)
   */
  def validate_type_and_ordering: Boolean = {
    // Start of user code for "type_and_ordering"
      ???
      // End of user code
  }

  /**
   * Visibility of the open end must allow access from the object performing the action.
   *
   * <!-- Start of user code doc for validate_visibility -->
   * <!-- End of user code doc for validate_visibility -->
   *
   * @body let openEnd : Property = self.openEnd()->first() in
   *   openEnd.visibility = VisibilityKind::public or
   *   endData->exists(oed |
   *     oed.end<>openEnd and
   *     (_'context' = oed.end.type or
   *       (openEnd.visibility = VisibilityKind::protected and
   *         _'context'.conformsTo(oed.end.type.oclAsType(Classifier)))))
   */
  def validate_visibility: Boolean = {
    // Start of user code for "visibility"
      ???
      // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadLinkActionOps
