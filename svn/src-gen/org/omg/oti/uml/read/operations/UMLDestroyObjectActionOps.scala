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
  * A DestroyObjectAction is an Action that destroys objects.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDestroyObjectActionOps[Uml <: UML] { self: UMLDestroyObjectAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin providing the object to be destroyed.
    *
    * <!-- Start of user code doc for target -->
    * <!-- End of user code doc for target -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.target_destroyObjectAction
    */
  def target: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The multiplicity of the targe IinputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body target.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * The target InputPin has no type.
    *
    * <!-- Start of user code doc for validate_no_type -->
    * <!-- End of user code doc for validate_no_type -->
    *
    * {{{
    * OCL Body target.type= null
    * }}}
    */
  def validate_no_type: Boolean = {
    // Start of user code for "no_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLDestroyObjectActionOps
