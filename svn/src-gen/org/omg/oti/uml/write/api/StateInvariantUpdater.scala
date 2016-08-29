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

package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.collection.immutable.Set
import scala.{AnyVal,Option,Unit}
import scala.collection.Iterable
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class StateInvariantUpdater[Uml <: UML](val domain: UMLStateInvariant[Uml]) extends AnyVal {

  def links_StateInvariant_stateInvariant_reference_covered_Lifeline
  (range: Iterable[UMLLifeline[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StateInvariant_stateInvariant_reference_covered_Lifeline(domain, range)

  def links_StateInvariant_stateInvariant_compose_invariant_Constraint
  (range: Option[UMLConstraint[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_StateInvariant_stateInvariant_compose_invariant_Constraint(domain, range)
}
