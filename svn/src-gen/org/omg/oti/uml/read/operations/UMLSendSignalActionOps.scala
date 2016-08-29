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
// End of user code

/**
  * A SendSignalAction is an InvocationAction that creates a Signal instance and transmits it to the target object. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instance is sent out and cannot receive reply values.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSendSignalActionOps[Uml <: UML] { self: UMLSendSignalAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The number and order of argument InputPins must be the same as the number and order of attributes of the signal.
    *
    * <!-- Start of user code doc for validate_number_order -->
    * <!-- End of user code doc for validate_number_order -->
    *
    * {{{
    * OCL Body argument->size()=signal.allAttributes()->size()
    * }}}
    */
  def validate_number_order: Boolean = {
    // Start of user code for "number_order"
    ???
    // End of user code
  }

  /**
    * The type, ordering, and multiplicity of an argument InputPin must be the same as the corresponding attribute of the signal.
    *
    * <!-- Start of user code doc for validate_type_ordering_multiplicity -->
    * <!-- End of user code doc for validate_type_ordering_multiplicity -->
    *
    * {{{
    * OCL Body let attribute: OrderedSet(Property) = signal.allAttributes() in
    * Sequence{1..argument->size()}->forAll(i | 
    * 	argument->at(i).type.conformsTo(attribute->at(i).type) and 
    * 	argument->at(i).isOrdered = attribute->at(i).isOrdered and
    * 	argument->at(i).compatibleWith(attribute->at(i)))
    * }}}
    */
  def validate_type_ordering_multiplicity: Boolean = {
    // Start of user code for "type_ordering_multiplicity"
    ???
    // End of user code
  }

  /**
    * If onPort is not empty, the Port given by onPort must be an owned or inherited feature of the type of the target InputPin.
    *
    * <!-- Start of user code doc for validate_type_target_pin -->
    * <!-- End of user code doc for validate_type_target_pin -->
    *
    * {{{
    * OCL Body not onPort->isEmpty() implies target.type.oclAsType(Classifier).allFeatures()->includes(onPort)
    * }}}
    */
  def validate_type_target_pin: Boolean = {
    // Start of user code for "type_target_pin"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLSendSignalActionOps
