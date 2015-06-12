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
 * A ReduceAction is an Action that reduces a collection to a single value by repeatedly combining the elements of the collection using a reducer Behavior.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReduceActionOps[Uml <: UML] { self: UMLReduceAction[Uml] =>	

	import self.ops._

	/**
	 * The InputPin that provides the collection to be reduced.
	 *
	 * <!-- Start of user code doc for collection -->
	 * <!-- End of user code doc for collection -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.collection_reduceAction
	 */
	def collection: Option[UMLInputPin[Uml]] = input headOption

	/**
	 * The output pin on which the result value is placed.
	 *
	 * <!-- Start of user code doc for result -->
	 * <!-- End of user code doc for result -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_reduceAction
	 */
	def result: Option[UMLOutputPin[Uml]] = output headOption

	/**
	 * The type of the collection InputPin must be a collection.
	 *
	 * <!-- Start of user code doc for validate_input_type_is_collection -->
	 * <!-- End of user code doc for validate_input_type_is_collection -->
	 *
	 */
	def validate_input_type_is_collection: Boolean = {
		// Start of user code for "input_type_is_collection"
    	???
    	// End of user code
	}

	/**
	 * The type of the output of the reducer Behavior must conform to the type of the result OutputPin.
	 *
	 * <!-- Start of user code doc for validate_output_types_are_compatible -->
	 * <!-- End of user code doc for validate_output_types_are_compatible -->
	 *
	 * @body reducer.outputParameters().type->forAll(conformsTo(result.type))
	 */
	def validate_output_types_are_compatible: Boolean = {
		// Start of user code for "output_types_are_compatible"
    	???
    	// End of user code
	}

	/**
	 * The reducer Behavior must have two input ownedParameters and one output ownedParameter, where the type of the output Parameter and the type of elements of the input collection conform to the types of the input Parameters.
	 *
	 * <!-- Start of user code doc for validate_reducer_inputs_output -->
	 * <!-- End of user code doc for validate_reducer_inputs_output -->
	 *
	 */
	def validate_reducer_inputs_output: Boolean = {
		// Start of user code for "reducer_inputs_output"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLReduceActionOps
