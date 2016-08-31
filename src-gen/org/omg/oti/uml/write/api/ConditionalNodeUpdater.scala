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

import scala.{AnyVal,Boolean,Unit}
import scala.collection.immutable.{Seq,Set}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ConditionalNodeUpdater[Uml <: UML](val domain: UMLConditionalNode[Uml]) extends AnyVal {

  def links_ConditionalNode_conditionalNode_compose_clause_Clause
  (range: Set[UMLClause[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ConditionalNode_conditionalNode_compose_clause_Clause(domain, range)

  def links_ConditionalNode_conditionalNode_compose_result_OutputPin
  (range: Seq[UMLOutputPin[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ConditionalNode_conditionalNode_compose_result_OutputPin(domain, range)

  def setIsAssured
  (isAssured: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_ConditionalNode_isAssured(domain, isAssured)

  def setIsDeterminate
  (isDeterminate: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_ConditionalNode_isDeterminate(domain, isDeterminate)
}
