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
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A FunctionBehavior is an OpaqueBehavior that does not access or modify any objects or other external data.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLFunctionBehaviorOps[Uml <: UML] { self: UMLFunctionBehavior[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The hasAllDataTypeAttributes query tests whether the types of the attributes of the given DataType are all DataTypes, and similarly for all those DataTypes.
    *
    * <!-- Start of user code doc for hasAllDataTypeAttributes -->
    * <!-- End of user code doc for hasAllDataTypeAttributes -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (d.ownedAttribute->forAll(a |
    *     a.type.oclIsKindOf(DataType) and
    *       hasAllDataTypeAttributes(a.type.oclAsType(DataType))))
    * }}}
    */
  def hasAllDataTypeAttributes(d: Option[UMLDataType[Uml]]): Boolean = {
    // Start of user code for "hasAllDataTypeAttributes"
    ???
    // End of user code
  }

  /**
    * A FunctionBehavior has at least one output Parameter.
    *
    * <!-- Start of user code doc for validate_one_output_parameter -->
    * <!-- End of user code doc for validate_one_output_parameter -->
    *
    * {{{
    * OCL Body self.ownedParameter->
    *   select(p | p.direction = ParameterDirectionKind::out or p.direction= ParameterDirectionKind::inout or p.direction= ParameterDirectionKind::return)->size() >= 1
    * }}}
    */
  def validate_one_output_parameter: Boolean = {
    // Start of user code for "one_output_parameter"
    ???
    // End of user code
  }

  /**
    * The types of the ownedParameters are all DataTypes, which may not nest anything but other DataTypes.
    *
    * <!-- Start of user code doc for validate_types_of_parameters -->
    * <!-- End of user code doc for validate_types_of_parameters -->
    *
    * {{{
    * OCL Body ownedParameter->forAll(p | p.type <> null and
    *   p.type.oclIsTypeOf(DataType) and hasAllDataTypeAttributes(p.type.oclAsType(DataType)))
    * }}}
    */
  def validate_types_of_parameters: Boolean = {
    // Start of user code for "types_of_parameters"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLFunctionBehaviorOps
