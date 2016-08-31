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
  * A ReadSelfAction is an Action that retrieves the context object of the Behavior execution within which the ReadSelfAction execution is taking place.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadSelfActionOps[Uml <: UML] { self: UMLReadSelfAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin on which the context object is placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readSelfAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * A ReadSelfAction must have a context Classifier.
    *
    * <!-- Start of user code doc for validate_contained -->
    * <!-- End of user code doc for validate_contained -->
    *
    * {{{
    * OCL Body _'context' <> null
    * }}}
    */
  def validate_contained: Boolean = {
    // Start of user code for "contained"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the result OutputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body result.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * If the ReadSelfAction is contained in an Behavior that is acting as a method, then the Operation of the method must not be static.
    *
    * <!-- Start of user code doc for validate_not_static -->
    * <!-- End of user code doc for validate_not_static -->
    *
    * {{{
    * OCL Body let behavior: Behavior = self.containingBehavior() in
    * behavior.specification<>null implies not behavior.specification.isStatic
    * }}}
    */
  def validate_not_static: Boolean = {
    // Start of user code for "not_static"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin is the context Classifier.
    *
    * <!-- Start of user code doc for validate__type -->
    * <!-- End of user code doc for validate__type -->
    *
    * {{{
    * OCL Body result.type = _'context'
    * }}}
    */
  def validate__type: Boolean = {
    // Start of user code for "_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadSelfActionOps
