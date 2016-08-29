/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Seq
// End of user code

/**
  * A ReadLinkAction is a LinkAction that navigates across an Association to retrieve the objects on one end.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadLinkActionOps[Uml <: UML] { self: UMLReadLinkAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin on which the objects retrieved from the "open" end of those links whose values on other ends are given by the endData.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readLinkAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * Returns the ends corresponding to endData with no value InputPin. (A well-formed ReadLinkAction is constrained to have only one of these.)
    *
    * <!-- Start of user code doc for openEnd -->
    * <!-- End of user code doc for openEnd -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (endData->select(value=null).end->asOrderedSet())
    * }}}
    */
  def openEnd: Seq[UMLProperty[Uml]] = {
    // Start of user code for "openEnd"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the open Association end must be compatible with the multiplicity of the result OutputPin.
    *
    * <!-- Start of user code doc for validate_compatible_multiplicity -->
    * <!-- End of user code doc for validate_compatible_multiplicity -->
    *
    * {{{
    * OCL Body self.openEnd()->first().compatibleWith(result)
    * }}}
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
    * {{{
    * OCL Body self.openEnd()->first().isNavigable()
    * }}}
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
    * {{{
    * OCL Body self.openEnd()->size() = 1
    * }}}
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
    * {{{
    * OCL Body self.openEnd()->forAll(type=result.type and isOrdered=result.isOrdered)
    * }}}
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
    * {{{
    * OCL Body let openEnd : Property = self.openEnd()->first() in
    *   openEnd.visibility = VisibilityKind::public or 
    *   endData->exists(oed | 
    *     oed.end<>openEnd and 
    *     (_'context' = oed.end.type or 
    *       (openEnd.visibility = VisibilityKind::protected and 
    *         _'context'.conformsTo(oed.end.type.oclAsType(Classifier)))))
    * }}}
    */
  def validate_visibility: Boolean = {
    // Start of user code for "visibility"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadLinkActionOps
