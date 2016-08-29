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
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * An Interaction is a unit of Behavior that focuses on the observable exchange of information between connectable elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionOps[Uml <: UML] { self: UMLInteraction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Actions owned by the Interaction.
    *
    * <!-- Start of user code doc for action -->
    * <!-- End of user code doc for action -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.action_interaction
    */
  def action: Set[UMLAction[Uml]] = ownedElement.selectByKindOf { case x: UMLAction[Uml] => x }

  /**
    * Specifies the gates that form the message interface between this Interaction and any InteractionUses which reference it.
    *
    * <!-- Start of user code doc for formalGate -->
    * <!-- End of user code doc for formalGate -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGate.formalGate_interaction
    */
  def formalGate: Set[UMLGate[Uml]] = ownedMember.selectByKindOf { case x: UMLGate[Uml] => x }

  /**
    * Specifies the participants in this Interaction.
    *
    * <!-- Start of user code doc for lifeline -->
    * <!-- End of user code doc for lifeline -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLifeline.interaction
    */
  def lifeline: Set[UMLLifeline[Uml]] = ownedMember.selectByKindOf { case x: UMLLifeline[Uml] => x }

  /**
    * The Messages contained in this Interaction.
    *
    * <!-- Start of user code doc for message -->
    * <!-- End of user code doc for message -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.interaction
    */
  def message: Set[UMLMessage[Uml]] = ownedMember.selectByKindOf { case x: UMLMessage[Uml] => x }

  /**
    * An Interaction instance must not be contained within another Interaction instance.
    *
    * <!-- Start of user code doc for validate_not_contained -->
    * <!-- End of user code doc for validate_not_contained -->
    *
    * {{{
    * OCL Body enclosingInteraction->isEmpty()
    * }}}
    */
  def validate_not_contained: Boolean = {
    // Start of user code for "not_contained"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInteractionOps
