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
import scala.collection.Iterable
import scala.collection.immutable.Set
// End of user code

/**
  * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkActionOps[Uml <: UML] { self: UMLLinkAction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The LinkEndData identifying the values on the ends of the links acting on by this LinkAction.
    *
    * <!-- Start of user code doc for endData -->
    * <!-- End of user code doc for endData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndData.endData_linkAction
    */
  def endData: Iterable[UMLLinkEndData[Uml]] = ownedElement.selectByKindOf { case x: UMLLinkEndData[Uml] => x }

  /**
    * InputPins used by the LinkEndData of the LinkAction.
    *
    * <!-- Start of user code doc for inputValue -->
    * <!-- End of user code doc for inputValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.inputValue_linkAction
    */
  def inputValue: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

  /**
    * Returns the Association acted on by this LinkAction.
    *
    * <!-- Start of user code doc for association -->
    * <!-- End of user code doc for association -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (endData->asSequence()->first().end.association)
    * }}}
    */
  def association: Option[UMLAssociation[Uml]] = {
    // Start of user code for "association"
    ???
    // End of user code
  }

  /**
    * The ends of the endData must not be static.
    *
    * <!-- Start of user code doc for validate_not_static -->
    * <!-- End of user code doc for validate_not_static -->
    *
    * {{{
    * OCL Body endData->forAll(not end.isStatic)
    * }}}
    */
  def validate_not_static: Boolean = {
    // Start of user code for "not_static"
    ???
    // End of user code
  }

  /**
    * The ends of the endData must all be from the same Association and include all and only the memberEnds of that association.
    *
    * <!-- Start of user code doc for validate_same_association -->
    * <!-- End of user code doc for validate_same_association -->
    *
    * {{{
    * OCL Body endData.end = self.association().memberEnd->asBag()
    * }}}
    */
  def validate_same_association: Boolean = {
    // Start of user code for "same_association"
    ???
    // End of user code
  }

  /**
    * The inputValue InputPins is the same as the union of all the InputPins referenced by the endData.
    *
    * <!-- Start of user code doc for validate_same_pins -->
    * <!-- End of user code doc for validate_same_pins -->
    *
    * {{{
    * OCL Body inputValue->asBag()=endData.allPins()
    * }}}
    */
  def validate_same_pins: Boolean = {
    // Start of user code for "same_pins"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLLinkActionOps
