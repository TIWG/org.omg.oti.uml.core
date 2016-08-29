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
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A GeneralOrdering represents a binary relation between two OccurrenceSpecifications, to describe that one OccurrenceSpecification must occur before the other in a valid trace. This mechanism provides the ability to define partial orders of OccurrenceSpecifications that may otherwise not have a specified order.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGeneralOrderingOps[Uml <: UML] { self: UMLGeneralOrdering[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for generalOrdering_interactionFragment -->
    * <!-- End of user code doc for generalOrdering_interactionFragment -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionFragment.generalOrdering
    */
  def generalOrdering_interactionFragment: Option[UMLInteractionFragment[Uml]] = owner.selectByKindOf { case x: UMLInteractionFragment[Uml] => x }

  /**
    * An occurrence specification must not be ordered relative to itself through a series of general orderings. (In other words, the transitive closure of the general orderings is irreflexive.)
    *
    * <!-- Start of user code doc for validate_irreflexive_transitive_closure -->
    * <!-- End of user code doc for validate_irreflexive_transitive_closure -->
    *
    * {{{
    * OCL Body after->closure(toAfter.after)->excludes(before)
    * }}}
    */
  def validate_irreflexive_transitive_closure: Boolean = {
    // Start of user code for "irreflexive_transitive_closure"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLGeneralOrderingOps
