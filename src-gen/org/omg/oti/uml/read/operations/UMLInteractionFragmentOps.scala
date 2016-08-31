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
import scala.Option
import scala.collection.immutable.Set
// End of user code

/**
  * InteractionFragment is an abstract notion of the most general interaction unit. An InteractionFragment is a piece of an Interaction. Each InteractionFragment is conceptually like an Interaction by itself.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionFragmentOps[Uml <: UML] { self: UMLInteractionFragment[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Interaction enclosing this InteractionFragment.
    *
    * <!-- Start of user code doc for enclosingInteraction -->
    * <!-- End of user code doc for enclosingInteraction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteraction.fragment
    */
  def enclosingInteraction: Option[UMLInteraction[Uml]] = namespace.selectByKindOf { case x: UMLInteraction[Uml] => x }

  /**
    * The operand enclosing this InteractionFragment (they may nest recursively).
    *
    * <!-- Start of user code doc for enclosingOperand -->
    * <!-- End of user code doc for enclosingOperand -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionOperand.fragment
    */
  def enclosingOperand: Option[UMLInteractionOperand[Uml]] = namespace.selectByKindOf { case x: UMLInteractionOperand[Uml] => x }

  /**
    * The general ordering relationships contained in this fragment.
    *
    * <!-- Start of user code doc for generalOrdering -->
    * <!-- End of user code doc for generalOrdering -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralOrdering.generalOrdering_interactionFragment
    */
  def generalOrdering: Set[UMLGeneralOrdering[Uml]] = ownedElement.selectByKindOf { case x: UMLGeneralOrdering[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLInteractionFragmentOps
