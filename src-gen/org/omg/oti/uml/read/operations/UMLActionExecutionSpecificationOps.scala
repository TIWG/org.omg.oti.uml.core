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
import scala.{Option,None,Some}
import scala.collection.immutable.Set
// End of user code

/**
  * An ActionExecutionSpecification is a kind of ExecutionSpecification representing the execution of an Action.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActionExecutionSpecificationOps[Uml <: UML] { self: UMLActionExecutionSpecification[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Action referenced by the ActionExecutionSpecification must be owned by the Interaction owning that ActionExecutionSpecification.
    *
    * <!-- Start of user code doc for validate_action_referenced -->
    * <!-- End of user code doc for validate_action_referenced -->
    *
    * {{{
    * OCL Body (enclosingInteraction->notEmpty() or enclosingOperand.combinedFragment->notEmpty()) and
    * let parentInteraction : Set(Interaction) = enclosingInteraction.oclAsType(Interaction)->asSet()->union(
    * enclosingOperand.combinedFragment->closure(enclosingOperand.combinedFragment)->
    * collect(enclosingInteraction).oclAsType(Interaction)->asSet()) in
    * (parentInteraction->size() = 1) and self.action.interaction->asSet() = parentInteraction
    * }}}
    */
  def validate_action_referenced: Boolean = {
    // Start of user code for "action_referenced"
    self.action match {
      case Some(a) =>
        val parentInteraction: Set[UMLInteractionFragment[Uml]] =
          closure[UMLInteractionFragment[Uml], UMLInteractionFragment[Uml]](
              self, combinedFragmentFromEnclosingOperand(_).toSet + self).flatMap(_.enclosingInteraction)

        if (parentInteraction.size != 1)
          false
        else
          a.action_interaction == parentInteraction.headOption

      case None =>
        true
    }
    // End of user code
  }

  // Start of user code for additional features
  def combinedFragmentFromEnclosingOperand
  (interactionFragment: UMLInteractionFragment[Uml])
  : Option[UMLInteractionFragment[Uml]] =
    for {
      eo <- interactionFragment.enclosingOperand
      cf <- eo.operand_combinedFragment
    } yield cf
  // End of user code
} //UMLActionExecutionSpecificationOps
