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
  * A SendObjectAction is an InvocationAction that transmits an input object to the target object, which is handled as a request message by the target object. The requestor continues execution immediately after the object is sent out and cannot receive reply values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSendObjectActionOps[Uml <: UML] { self: UMLSendObjectAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The request object, which is transmitted to the target object. The object may be copied in transmission, so identity might not be preserved.
    *
    * <!-- Start of user code doc for request -->
    * <!-- End of user code doc for request -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.request_sendObjectAction
    */
  def request: Option[UMLInputPin[Uml]] = argument headOption

  /**
    * If onPort is not empty, the Port given by onPort must be an owned or inherited feature of the type of the target InputPin.
    *
    * <!-- Start of user code doc for validate_type_target_pin -->
    * <!-- End of user code doc for validate_type_target_pin -->
    *
    * {{{
    * OCL Body onPort<>null implies target.type.oclAsType(Classifier).allFeatures()->includes(onPort)
    * }}}
    */
  def validate_type_target_pin: Boolean = {
    // Start of user code for "type_target_pin"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLSendObjectActionOps
