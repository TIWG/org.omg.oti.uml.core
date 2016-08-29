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
import scala.Option
// End of user code

/**
  * A StateInvariant is a runtime constraint on the participants of the Interaction. It may be used to specify a variety of different kinds of Constraints, such as values of Attributes or Variables, internal or external States, and so on. A StateInvariant is an InteractionFragment and it is placed on a Lifeline.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStateInvariantOps[Uml <: UML] { self: UMLStateInvariant[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A Constraint that should hold at runtime for this StateInvariant.
    *
    * <!-- Start of user code doc for invariant -->
    * <!-- End of user code doc for invariant -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.invariant_stateInvariant
    */
  def invariant: Option[UMLConstraint[Uml]] = ownedElement.selectByKindOf { case x: UMLConstraint[Uml] => x } headOption

  // Start of user code for additional features
  // End of user code
} //UMLStateInvariantOps
