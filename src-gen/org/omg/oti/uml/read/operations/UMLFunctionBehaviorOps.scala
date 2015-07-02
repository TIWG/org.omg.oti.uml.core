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

import org.omg.oti.uml.read.api.{UML, UMLFunctionBehavior, UMLDataType}
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A FunctionBehavior is an OpaqueBehavior that does not access or modify any objects or other external data.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLFunctionBehaviorOps[Uml <: UML] { self: UMLFunctionBehavior[Uml] =>	

	import self.ops._

	/**
	 * The hasAllDataTypeAttributes query tests whether the types of the attributes of the given DataType are all DataTypes, and similarly for all those DataTypes.
	 *
	 * <!-- Start of user code doc for hasAllDataTypeAttributes -->
	 * <!-- End of user code doc for hasAllDataTypeAttributes -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (d.ownedAttribute->forAll(a |
	 *     a.type.oclIsKindOf(DataType) and
	 *       hasAllDataTypeAttributes(a.type.oclAsType(DataType))))
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
	 * @body self.ownedParameter->
	 *   select(p | p.direction = ParameterDirectionKind::out or p.direction= ParameterDirectionKind::inout or p.direction= ParameterDirectionKind::return)->size() >= 1
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
	 * @body ownedParameter->forAll(p | p.type <> null and
	 *   p.type.oclIsTypeOf(DataType) and hasAllDataTypeAttributes(p.type.oclAsType(DataType)))
	 */
	def validate_types_of_parameters: Boolean = {
		// Start of user code for "types_of_parameters"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLFunctionBehaviorOps
