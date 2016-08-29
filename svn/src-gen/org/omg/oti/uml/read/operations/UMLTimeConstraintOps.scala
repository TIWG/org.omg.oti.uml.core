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
  * A TimeConstraint is a Constraint that refers to a TimeInterval.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeConstraintOps[Uml <: UML] { self: UMLTimeConstraint[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * TheTimeInterval constraining the duration.
    *
    * <!-- Start of user code doc for specification -->
    * <!-- End of user code doc for specification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeInterval.specification_timeConstraint
    */
  override def specification: Option[UMLTimeInterval[Uml]] = ownedElement.selectByKindOf { case x: UMLTimeInterval[Uml] => x } headOption

  /**
    * A TimeConstraint has one constrainedElement.
    *
    * <!-- Start of user code doc for validate_has_one_constrainedElement -->
    * <!-- End of user code doc for validate_has_one_constrainedElement -->
    *
    * {{{
    * OCL Body constrainedElement->size() = 1
    * }}}
    */
  def validate_has_one_constrainedElement: Boolean = {
    // Start of user code for "has_one_constrainedElement"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTimeConstraintOps
