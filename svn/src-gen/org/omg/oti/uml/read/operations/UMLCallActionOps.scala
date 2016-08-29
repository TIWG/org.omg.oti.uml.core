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
import scala.Some
import scala.Predef.{Set => _, _}
import scala.collection.immutable.Seq
// End of user code

/**
  * CallAction is an abstract class for Actions that invoke a Behavior with given argument values and (if the invocation is synchronous) receive reply values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCallActionOps[Uml <: UML] { self: UMLCallAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * Return the in and inout ownedParameters of the Behavior or Operation being called. (This operation is abstract and should be overridden by subclasses of CallAction.)
    *
    * <!-- Start of user code doc for inputParameters -->
    * <!-- End of user code doc for inputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    */
  def inputParameters: Seq[UMLParameter[Uml]]

  /**
    * Return the inout, out and return ownedParameters of the Behavior or Operation being called. (This operation is abstract and should be overridden by subclasses of CallAction.)
    *
    * <!-- Start of user code doc for outputParameters -->
    * <!-- End of user code doc for outputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    */
  def outputParameters: Seq[UMLParameter[Uml]]

  /**
    * The number of argument InputPins must be the same as the number of input (in and inout) ownedParameters of the called Behavior or Operation. The type, ordering and multiplicity of each argument InputPin must be consistent with the corresponding input Parameter.
    *
    * <!-- Start of user code doc for validate_argument_pins -->
    * <!-- End of user code doc for validate_argument_pins -->
    *
    * {{{
    * OCL Body let parameter: OrderedSet(Parameter) = self.inputParameters() in
    * argument->size() = parameter->size() and
    * Sequence{1..argument->size()}->forAll(i | 
    * 	argument->at(i).type.conformsTo(parameter->at(i).type) and 
    * 	argument->at(i).isOrdered = parameter->at(i).isOrdered and
    * 	argument->at(i).compatibleWith(parameter->at(i)))
    * }}}
    */
  def validate_argument_pins: Boolean = {
    // Start of user code for "argument_pins"
    argument.size == inputParameters.size &&
      (argument, inputParameters)
      .zipped
      .forall {
                (a, p) =>
                  a.isOrdered == p.isOrdered &&
                    a.compatibleWith(Some(p)) &&
                    (a._type match {
                      case Some(at) => at.conformsTo(p._type)
                      case _        => true
                    })
              }
    // End of user code
  }

  /**
    * The number of result OutputPins must be the same as the number of output (inout, out and return) ownedParameters of the called Behavior or Operation. The type, ordering and multiplicity of each result OutputPin must be consistent with the corresponding input Parameter.
    *
    * <!-- Start of user code doc for validate_result_pins -->
    * <!-- End of user code doc for validate_result_pins -->
    *
    * {{{
    * OCL Body let parameter: OrderedSet(Parameter) = self.outputParameters() in
    * result->size() = parameter->size() and
    * Sequence{1..result->size()}->forAll(i | 
    * 	parameter->at(i).type.conformsTo(result->at(i).type) and 
    * 	parameter->at(i).isOrdered = result->at(i).isOrdered and
    * 	parameter->at(i).compatibleWith(result->at(i)))
    * }}}
    */
  def validate_result_pins: Boolean = {
    // Start of user code for "result_pins"
    result.size == outputParameters.size &&
      (result, outputParameters)
      .zipped
      .forall {
                (r, p) =>
                  r.isOrdered == p.isOrdered &&
                    r.compatibleWith(Some(p)) &&
                    (r._type match {
                      case Some(rt) => rt.conformsTo(p._type)
                      case _        => true
                    })
              }
    // End of user code
  }

  /**
    * Only synchronous CallActions can have result OutputPins.
    *
    * <!-- Start of user code doc for validate_synchronous_call -->
    * <!-- End of user code doc for validate_synchronous_call -->
    *
    * {{{
    * OCL Body result->notEmpty() implies isSynchronous
    * }}}
    */
  def validate_synchronous_call: Boolean = {
    // Start of user code for "synchronous_call"
    result.isEmpty || isSynchronous
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLCallActionOps
