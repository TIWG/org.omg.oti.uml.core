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
  * A ConsiderIgnoreFragment is a kind of CombinedFragment that is used for the consider and ignore cases, which require lists of pertinent Messages to be specified.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConsiderIgnoreFragmentOps[Uml <: UML] { self: UMLConsiderIgnoreFragment[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The interaction operator of a ConsiderIgnoreFragment must be either 'consider' or 'ignore'.
    *
    * <!-- Start of user code doc for validate_consider_or_ignore -->
    * <!-- End of user code doc for validate_consider_or_ignore -->
    *
    * {{{
    * OCL Body (interactionOperator =  InteractionOperatorKind::consider) or (interactionOperator =  InteractionOperatorKind::ignore)
    * }}}
    */
  def validate_consider_or_ignore: Boolean = {
    // Start of user code for "consider_or_ignore"
    ???
    // End of user code
  }

  /**
    * The NamedElements must be of a type of element that can be a signature for a message (i.e.., an Operation, or a Signal).
    *
    * <!-- Start of user code doc for validate__type -->
    * <!-- End of user code doc for validate__type -->
    *
    * {{{
    * OCL Body message->forAll(m | m.oclIsKindOf(Operation) or m.oclIsKindOf(Signal))
    * }}}
    */
  def validate__type: Boolean = {
    // Start of user code for "_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLConsiderIgnoreFragmentOps
