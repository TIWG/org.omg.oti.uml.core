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
import scala.Option
// End of user code

/**
  * A ProtocolStateMachine can be redefined into a more specific ProtocolStateMachine or into behavioral StateMachine. ProtocolConformance declares that the specific ProtocolStateMachine specifies a protocol that conforms to the general ProtocolStateMachine or that the specific behavioral StateMachine abides by the protocol of the general ProtocolStateMachine.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProtocolConformanceOps[Uml <: UML] { self: UMLProtocolConformance[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Specifies the ProtocolStateMachine to which the specific ProtocolStateMachine conforms.
    *
    * <!-- Start of user code doc for generalMachine -->
    * <!-- End of user code doc for generalMachine -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolStateMachine.generalMachine_protocolConformance
    */
  def generalMachine: Option[UMLProtocolStateMachine[Uml]] = target.selectByKindOf { case x: UMLProtocolStateMachine[Uml] => x } headOption

  /**
    * Specifies the ProtocolStateMachine which conforms to the general ProtocolStateMachine.
    *
    * <!-- Start of user code doc for specificMachine -->
    * <!-- End of user code doc for specificMachine -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolStateMachine.conformance
    */
  def specificMachine: Option[UMLProtocolStateMachine[Uml]] = owner.selectByKindOf { case x: UMLProtocolStateMachine[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLProtocolConformanceOps
