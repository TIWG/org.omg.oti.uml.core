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
import scala.collection.immutable.Set
// End of user code

/**
  * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInterfaceOps[Uml <: UML] { self: UMLInterface[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Receptions that objects providing this Interface are willing to accept.
    *
    * <!-- Start of user code doc for ownedReception -->
    * <!-- End of user code doc for ownedReception -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReception.ownedReception_interface
    */
  def ownedReception: Set[UMLReception[Uml]] = feature.selectByKindOf { case x: UMLReception[Uml] => x }

  /**
    * References a ProtocolStateMachine specifying the legal sequences of the invocation of the BehavioralFeatures described in the Interface.
    *
    * <!-- Start of user code doc for protocol -->
    * <!-- End of user code doc for protocol -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolStateMachine.protocol_interface
    */
  def protocol: Option[UMLProtocolStateMachine[Uml]] = ownedMember.selectByKindOf { case x: UMLProtocolStateMachine[Uml] => x } headOption

  /**
    * The visibility of all Features owned by an Interface must be public.
    *
    * <!-- Start of user code doc for validate_visibility -->
    * <!-- End of user code doc for validate_visibility -->
    *
    * {{{
    * OCL Body feature->forAll(visibility = VisibilityKind::public)
    * }}}
    */
  def validate_visibility: Boolean = {
    // Start of user code for "visibility"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInterfaceOps
