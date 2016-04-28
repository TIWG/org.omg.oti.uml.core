/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
