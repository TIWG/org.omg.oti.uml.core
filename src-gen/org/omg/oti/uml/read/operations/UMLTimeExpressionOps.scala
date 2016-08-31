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
import scala.collection.immutable.Set
import scalaz._, Scalaz._

// End of user code

/**
  * A TimeExpression is a ValueSpecification that represents a time value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTimeExpressionOps[Uml <: UML] { self: UMLTimeExpression[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for max_timeInterval -->
    * <!-- End of user code doc for max_timeInterval -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeInterval.max
    */
  def max_timeInterval: Set[UMLTimeInterval[Uml]] = max_interval.selectByKindOf { case x: UMLTimeInterval[Uml] => x }

  /**
    * <!-- Start of user code doc for min_timeInterval -->
    * <!-- End of user code doc for min_timeInterval -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeInterval.min
    */
  def min_timeInterval: Set[UMLTimeInterval[Uml]] = min_interval.selectByKindOf { case x: UMLTimeInterval[Uml] => x }

  /**
    * <!-- Start of user code doc for when_timeEvent -->
    * <!-- End of user code doc for when_timeEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTimeEvent.when
    */
  def when_timeEvent: Option[UMLTimeEvent[Uml]] = owner.selectByKindOf { case x: UMLTimeEvent[Uml] => x }

  /**
    * If a TimeExpression has no expr, then it must have a single observation that is a TimeObservation.
    *
    * <!-- Start of user code doc for validate_no_expr_requires_observation -->
    * <!-- End of user code doc for validate_no_expr_requires_observation -->
    *
    * {{{
    * OCL Body expr = null implies (observation->size() = 1 and observation->forAll(oclIsKindOf(TimeObservation)))
    * }}}
    */
  def validate_no_expr_requires_observation: Boolean = {
    // Start of user code for "no_expr_requires_observation"
    ???
    // End of user code
  }

  // Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] =
    expression_asForwardReferencesToImportableOuterPackageableElements

  def expression_asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] =
		(Set[UMLPackageableElement[Uml]](this) ++ expr.toSet).right

  // End of user code
} //UMLTimeExpressionOps
