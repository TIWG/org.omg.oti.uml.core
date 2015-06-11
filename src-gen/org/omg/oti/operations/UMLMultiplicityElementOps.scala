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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A MultiplicityElement embeds this information to specify the allowable cardinalities for an instantiation of the Element.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLMultiplicityElementOps[Uml <: UML] { self: UMLMultiplicityElement[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The lower bound of the multiplicity interval.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (lowerBound())
	 */
	def lower: Integer = {
		// Start of user code for "lower"
    ???
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The upper bound of the multiplicity interval.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (upperBound())
	 */
	def upper: Integer = {
		// Start of user code for "upper"
    ???
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The operation compatibleWith takes another multiplicity as input. It returns true if the other multiplicity is wider than, or the same as, self.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = ((other.lowerBound() <= self.lowerBound()) and ((other.upperBound() = *) or (self.upperBound() <= other.upperBound())))
	 */
	def compatibleWith(other: Option[UMLMultiplicityElement[Uml]]): Boolean  = {
		// Start of user code for "compatibleWith"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query includesMultiplicity() checks whether this multiplicity includes all the cardinalities allowed by the specified multiplicity.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = ((self.lowerBound() <= M.lowerBound()) and (self.upperBound() >= M.upperBound()))
	 */
	def includesMultiplicity(M: Option[UMLMultiplicityElement[Uml]]): Boolean  = {
		// Start of user code for "includesMultiplicity"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The operation is determines if the upper and lower bound of the ranges are the ones given.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (lowerbound = self.lowerBound() and upperbound = self.upperBound())
	 */
	def is(lowerbound: Integer, upperbound: Integer): Boolean  = {
		// Start of user code for "is"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isMultivalued() checks whether this multiplicity has an upper bound greater than one.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (upperBound() > 1)
	 */
	def isMultivalued: Boolean  = {
		// Start of user code for "isMultivalued"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query lowerBound() returns the lower bound of the multiplicity as an integer, which is the integerValue of lowerValue, if this is given, and 1 otherwise.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if (lowerValue=null or lowerValue.integerValue()=null) then 1 else lowerValue.integerValue() endif)
	 */
	def lowerBound: Option[Integer]  = {
		// Start of user code for "lowerBound"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query upperBound() returns the upper bound of the multiplicity for a bounded multiplicity as an unlimited natural, which is the unlimitedNaturalValue of upperValue, if given, and 1, otherwise.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if (upperValue=null or upperValue.unlimitedValue()=null) then 1 else upperValue.unlimitedValue() endif)
	 */
	def upperBound: Integer  = {
		// Start of user code for "upperBound"
    ???
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The lower bound must be a non-negative integer literal.
	 * <!-- end-model-doc -->
	 *
	 * @body lowerBound() >= 0
	 */
	def validate_lower_ge_0: Boolean  = {
		// Start of user code for "lower_ge_0"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If it is not empty, then lowerValue must have an Integer value.
	 * <!-- end-model-doc -->
	 *
	 * @body lowerValue <> null implies lowerValue.integerValue() <> null
	 */
	def validate_lower_is_integer: Boolean  = {
		// Start of user code for "lower_is_integer"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The upper bound must be greater than or equal to the lower bound.
	 * <!-- end-model-doc -->
	 *
	 * @body upperBound() >= lowerBound()
	 */
	def validate_upper_ge_lower: Boolean  = {
		// Start of user code for "upper_ge_lower"
  	???
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If it is not empty, then upperValue must have an UnlimitedNatural value.
	 * <!-- end-model-doc -->
	 *
	 * @body upperValue <> null implies upperValue.unlimitedValue() <> null
	 */
	def validate_upper_is_unlimitedNatural: Boolean  = {
		// Start of user code for "upper_is_unlimitedNatural"
    ???
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If a non-literal ValueSpecification is used for lowerValue or upperValue, then that specification must be a constant expression.
	 * <!-- end-model-doc -->
	 *
	 */
	def validate_value_specification_constant: Boolean  = {
		// Start of user code for "value_specification_constant"
    ???
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If a non-literal ValueSpecification is used for lowerValue or upperValue, then evaluating that specification must not have side effects.
	 * <!-- end-model-doc -->
	 *
	 */
	def validate_value_specification_no_side_effects: Boolean  = {
		// Start of user code for "value_specification_no_side_effects"
    ???
    // End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLMultiplicityElement
