/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
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

import org.omg.oti.uml.read.api.{UML, UMLMultiplicityElement}

import scala.language.postfixOps

// End of user code

/**
 * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with
 * a lower bound and ending with a (possibly infinite) upper bound.
 * A MultiplicityElement embeds this information to specify the allowable cardinalities
 * for an instantiation of the Element.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLMultiplicityElementOps[Uml <: UML] {
  self: UMLMultiplicityElement[Uml] =>

  import self.ops._

  /**
   * The lower bound of the multiplicity interval.
   *
   * <!-- Start of user code doc for lower -->
   * <!-- End of user code doc for lower -->
   *
   * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   * @body result = (if (lowerValue=null or lowerValue.integerValue()=null)
   *       then 1 else lowerValue.integerValue() endif)
   */
  def lower: Integer = {
    // Start of user code for "lower"
    ???
    // End of user code
  }

  /**
   * The upper bound of the multiplicity interval.
   *
   * <!-- Start of user code doc for upper -->
   * <!-- End of user code doc for upper -->
   *
   * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   * @body result = (if (upperValue=null or upperValue.unlimitedValue()=null)
   *       then 1 else upperValue.unlimitedValue() endif)
   */
  def upper: Integer = {
    // Start of user code for "upper"
    ???
    // End of user code
  }

  /**
   * The operation compatibleWith takes another multiplicity as input.
   * It returns true if the other multiplicity is wider than, or the same as, self.
   *
   * <!-- Start of user code doc for compatibleWith -->
   * <!-- End of user code doc for compatibleWith -->
   *
   * @operation ordered="false" unique="true" multiplicity="1..1"
   * @body result = ((other.lower() <= self.lower()) and ((other.upper() = *) or (self.upper() <= other.upper())))
   */
  def compatibleWith(other: Option[UMLMultiplicityElement[Uml]]): Boolean = {
    // Start of user code for "compatibleWith"
    ???
    // End of user code
  }

  /**
   * The query includesMultiplicity() checks whether this multiplicity includes all
   * the cardinalities allowed by the specified multiplicity.
   *
   * <!-- Start of user code doc for includesMultiplicity -->
   * <!-- End of user code doc for includesMultiplicity -->
   *
   * @operation ordered="false" unique="true" multiplicity="1..1"
   * @body result = ((self.lower() <= M.lower()) and (self.upper() >= M.upper()))
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
   * @operation ordered="false" unique="true" multiplicity="1..1"
   * @body result = (lowerbound = self.lower() and upperbound = self.upper())
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
   * @operation ordered="false" unique="true" multiplicity="1..1"
   * @body result = (upper() > 1)
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
   * @body lower() >= 0
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
   * @body lowerValue <> null implies lowerValue.integerValue() <> null
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
   * @body upper() >= lower()
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
   * @body upperValue <> null implies upperValue.unlimitedValue() <> null
   */
  def validate_upper_is_unlimitedNatural: Boolean = {
    // Start of user code for "upper_is_unlimitedNatural"
    ???
    // End of user code
  }

  /**
   * If a non-literal ValueSpecification is used for lowerValue or upperValue, then
   * that specification must be a constant expression.
   *
   * <!-- Start of user code doc for validate_value_specification_constant -->
   * <!-- End of user code doc for validate_value_specification_constant -->
   *
   */
  def validate_value_specification_constant: Boolean = {
    // Start of user code for "value_specification_constant"
    ???
    // End of user code
  }

  /**
   * If a non-literal ValueSpecification is used for lowerValue or upperValue, then
   * evaluating that specification must not have side effects.
   *
   * <!-- Start of user code doc for validate_value_specification_no_side_effects -->
   * <!-- End of user code doc for validate_value_specification_no_side_effects -->
   *
   */
  def validate_value_specification_no_side_effects: Boolean = {
    // Start of user code for "value_specification_no_side_effects"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
}

//UMLMultiplicityElementOps
