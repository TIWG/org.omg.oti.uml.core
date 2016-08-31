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
import scala.{Option,None,Some}
import scala.Predef._
import java.lang.Integer
// End of user code

/**
  * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A MultiplicityElement embeds this information to specify the allowable cardinalities for an instantiation of the Element.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMultiplicityElementOps[Uml <: UML] { self: UMLMultiplicityElement[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The lower bound of the multiplicity interval.
    *
    * <!-- Start of user code doc for lower -->
    * <!-- End of user code doc for lower -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (if (lowerValue=null or lowerValue.integerValue()=null) then 1 else lowerValue.integerValue() endif)
    * }}}
    */
  def lower: Integer = {
    // Start of user code for "lower"
    lowerValue match {
      case None => 1
      
      case Some(v) => v.integerValue match {
        case Some(i) => i
        case None => 1
      }
    }
    // End of user code
  }

  /**
    * The upper bound of the multiplicity interval.
    *
    * <!-- Start of user code doc for upper -->
    * <!-- End of user code doc for upper -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (if (upperValue=null or upperValue.unlimitedValue()=null) then 1 else upperValue.unlimitedValue() endif)
    * }}}
    */
  def upper: Integer = {
    // Start of user code for "upper"
    upperValue match {
      case None => 1
      
      case Some(v) => v.unlimitedValue match {
        case Some(u) => u
        case None => 1
      }
    }
    
    // End of user code
  }

  /**
    * The operation compatibleWith takes another multiplicity as input. It returns true if the other multiplicity is wider than, or the same as, self.
    *
    * <!-- Start of user code doc for compatibleWith -->
    * <!-- End of user code doc for compatibleWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = ((other.lower() <= self.lower()) and ((other.upper() = *) or (self.upper() <= other.upper())))
    * }}}
    */
  def compatibleWith(other: Option[UMLMultiplicityElement[Uml]]): Boolean = {
    // Start of user code for "compatibleWith"
    ???
    // End of user code
  }

  /**
    * The query includesMultiplicity() checks whether this multiplicity includes all the cardinalities allowed by the specified multiplicity.
    *
    * <!-- Start of user code doc for includesMultiplicity -->
    * <!-- End of user code doc for includesMultiplicity -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = ((self.lower() <= M.lower()) and (self.upper() >= M.upper()))
    * }}}
    */
  def includesMultiplicity(M: Option[UMLMultiplicityElement[Uml]]): Boolean = {
    // Start of user code for "includesMultiplicity"
    ???
    // End of user code
  }

  /**
    * The operation is determines if the upper and lower bound of the ranges are the ones given.
    *
    * <!-- Start of user code doc for is -->
    * <!-- End of user code doc for is -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (lowerbound = self.lower() and upperbound = self.upper())
    * }}}
    */
  def is(lowerbound: Integer, upperbound: Integer): Boolean = {
    // Start of user code for "is"
    ???
    // End of user code
  }

  /**
    * The query isMultivalued() checks whether this multiplicity has an upper bound greater than one.
    *
    * <!-- Start of user code doc for isMultivalued -->
    * <!-- End of user code doc for isMultivalued -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (upper() > 1)
    * }}}
    */
  def isMultivalued: Boolean = {
    // Start of user code for "isMultivalued"
    ???
    // End of user code
  }

  /**
    * The lower bound must be a non-negative integer literal.
    *
    * <!-- Start of user code doc for validate_lower_ge_0 -->
    * <!-- End of user code doc for validate_lower_ge_0 -->
    *
    * {{{
    * OCL Body lower() >= 0
    * }}}
    */
  def validate_lower_ge_0: Boolean = {
    // Start of user code for "lower_ge_0"
    ???
    // End of user code
  }

  /**
    * If it is not empty, then lowerValue must have an Integer value.
    *
    * <!-- Start of user code doc for validate_lower_is_integer -->
    * <!-- End of user code doc for validate_lower_is_integer -->
    *
    * {{{
    * OCL Body lowerValue <> null implies lowerValue.integerValue() <> null
    * }}}
    */
  def validate_lower_is_integer: Boolean = {
    // Start of user code for "lower_is_integer"
    ???
    // End of user code
  }

  /**
    * The upper bound must be greater than or equal to the lower bound.
    *
    * <!-- Start of user code doc for validate_upper_ge_lower -->
    * <!-- End of user code doc for validate_upper_ge_lower -->
    *
    * {{{
    * OCL Body upper() >= lower()
    * }}}
    */
  def validate_upper_ge_lower: Boolean = {
    // Start of user code for "upper_ge_lower"
    ???
    // End of user code
  }

  /**
    * If it is not empty, then upperValue must have an UnlimitedNatural value.
    *
    * <!-- Start of user code doc for validate_upper_is_unlimitedNatural -->
    * <!-- End of user code doc for validate_upper_is_unlimitedNatural -->
    *
    * {{{
    * OCL Body upperValue <> null implies upperValue.unlimitedValue() <> null
    * }}}
    */
  def validate_upper_is_unlimitedNatural: Boolean = {
    // Start of user code for "upper_is_unlimitedNatural"
    ???
    // End of user code
  }

  /**
    * If a non-literal ValueSpecification is used for lowerValue or upperValue, then that specification must be a constant expression.
    *
    * <!-- Start of user code doc for validate_value_specification_constant -->
    * <!-- End of user code doc for validate_value_specification_constant -->
    *
    * {{{
    * }}}
    */
  def validate_value_specification_constant: Boolean = {
    // Start of user code for "value_specification_constant"
    ???
    // End of user code
  }

  /**
    * If a non-literal ValueSpecification is used for lowerValue or upperValue, then evaluating that specification must not have side effects.
    *
    * <!-- Start of user code doc for validate_value_specification_no_side_effects -->
    * <!-- End of user code doc for validate_value_specification_no_side_effects -->
    *
    * {{{
    * }}}
    */
  def validate_value_specification_no_side_effects: Boolean = {
    // Start of user code for "value_specification_no_side_effects"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLMultiplicityElementOps
