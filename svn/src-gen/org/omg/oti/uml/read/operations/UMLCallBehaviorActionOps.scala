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
import scala.{None,Some}
import scala.collection.immutable.Seq
// End of user code

/**
  * A CallBehaviorAction is a CallAction that invokes a Behavior directly. The argument values of the CallBehaviorAction are passed on the input Parameters of the invoked Behavior. If the call is synchronous, the execution of the CallBehaviorAction waits until the execution of the invoked Behavior completes and the values of output Parameters of the Behavior are placed on the result OutputPins. If the call is asynchronous, the CallBehaviorAction completes immediately and no results values can be provided.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCallBehaviorActionOps[Uml <: UML] { self: UMLCallBehaviorAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * Return the in and inout ownedParameters of the Behavior being called.
    *
    * <!-- Start of user code doc for inputParameters -->
    * <!-- End of user code doc for inputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (behavior.inputParameters())
    * }}}
    */
  override def inputParameters: Seq[UMLParameter[Uml]] = {
    // Start of user code for "inputParameters"
    behavior match {
      case Some(b) =>
        b.inputParameters
      case None    =>
        Seq()
    }
    // End of user code
  }

  /**
    * Return the inout, out and return ownedParameters of the Behavior being called.
    *
    * <!-- Start of user code doc for outputParameters -->
    * <!-- End of user code doc for outputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (behavior.outputParameters())
    * }}}
    */
  override def outputParameters: Seq[UMLParameter[Uml]] = {
    // Start of user code for "outputParameters"
    behavior match {
      case Some(b) =>
        b.outputParameters
      case None    =>
        Seq()
    }
    // End of user code
  }

  /**
    * A CallBehaviorAction may not specify onPort.
    *
    * <!-- Start of user code doc for validate_no_onport -->
    * <!-- End of user code doc for validate_no_onport -->
    *
    * {{{
    * OCL Body onPort=null
    * }}}
    */
  def validate_no_onport: Boolean = {
    // Start of user code for "no_onport"
    onPort.isEmpty
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLCallBehaviorActionOps
