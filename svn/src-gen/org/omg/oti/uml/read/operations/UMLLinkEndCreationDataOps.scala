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
// End of user code

/**
  * LinkEndCreationData is LinkEndData used to provide values for one end of a link to be created by a CreateLinkAction.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkEndCreationDataOps[Uml <: UML] { self: UMLLinkEndCreationData[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for endData_createLinkAction -->
    * <!-- End of user code doc for endData_createLinkAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCreateLinkAction.endData
    */
  def endData_createLinkAction: Option[UMLCreateLinkAction[Uml]] = endData_linkAction.selectByKindOf { case x: UMLCreateLinkAction[Uml] => x }

  /**
    * Adds the insertAt InputPin (if any) to the set of all Pins.
    *
    * <!-- Start of user code doc for allPins -->
    * <!-- End of user code doc for allPins -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self.LinkEndData::allPins()->including(insertAt))
    * }}}
    */
  override def allPins: Set[UMLInputPin[Uml]] = {
    // Start of user code for "allPins"
    ???
    // End of user code
  }

  /**
    * LinkEndCreationData for ordered Association ends must have a single insertAt InputPin for the insertion point with type UnlimitedNatural and multiplicity of 1..1, if isReplaceAll=false, and must have no InputPin for the insertion point when the association ends are unordered.
    *
    * <!-- Start of user code doc for validate_insertAt_pin -->
    * <!-- End of user code doc for validate_insertAt_pin -->
    *
    * {{{
    * OCL Body if  not end.isOrdered
    * then insertAt = null
    * else
    * 	not isReplaceAll=false implies
    * 	insertAt <> null and insertAt->forAll(type=UnlimitedNatural and is(1,1))
    * endif
    * }}}
    */
  def validate_insertAt_pin: Boolean = {
    // Start of user code for "insertAt_pin"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLLinkEndCreationDataOps
