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
// End of user code

/**
  * A TimeEvent is an Event that occurs at a specific point in time.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeEventOps[Uml <: UML] { self: UMLTimeEvent[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Specifies the time of the TimeEvent.
    *
    * <!-- Start of user code doc for when -->
    * <!-- End of user code doc for when -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeExpression.when_timeEvent
    */
  def when: Option[UMLTimeExpression[Uml]] = ownedElement.selectByKindOf { case x: UMLTimeExpression[Uml] => x } headOption

  /**
    * The ValueSpecification when must return a non-negative Integer.
    *
    * <!-- Start of user code doc for validate_when_non_negative -->
    * <!-- End of user code doc for validate_when_non_negative -->
    *
    * {{{
    * OCL Body when.integerValue() >= 0
    * }}}
    */
  def validate_when_non_negative: Boolean = {
    // Start of user code for "when_non_negative"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTimeEventOps
