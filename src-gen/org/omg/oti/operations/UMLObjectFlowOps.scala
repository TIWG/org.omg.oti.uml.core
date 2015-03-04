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
 * An ObjectFlow is an ActivityEdge that is traversed by object tokens that may hold values. Object flows also support multicast/receive, token selection from object nodes, and transformation of tokens.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLObjectFlowOps[Uml <: UML] { self: UMLObjectFlow[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * ObjectNodes connected by an ObjectFlow, with optionally intervening ControlNodes, must have compatible types. In particular, the downstream ObjectNode type must be the same or a supertype of the upstream ObjectNode type.
	 * <!-- end-model-doc -->
	 *
	 */
	def validate_compatible_types: Boolean  = {
    	// Start of user code for "compatible_types"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A selection Behavior has one input Parameter and one output Parameter. The input Parameter must have the same as or a supertype of the type of the source ObjectNode, be non-unique and have multiplicity 0..*. The output Parameter must be the same or a subtype of the type of source ObjectNode. The Behavior cannot have side effects.
	 * <!-- end-model-doc -->
	 *
	 * @body selection<>null implies
	 * 	selection.inputParameters()->size()=1 and
	 * 	selection.inputParameters()->forAll(not isUnique and is(0,*)) and
	 * 	selection.outputParameters()->size()=1
	 */
	def validate_input_and_output_parameter: Boolean  = {
    	// Start of user code for "input_and_output_parameter"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * isMulticast and isMultireceive cannot both be true.
	 * <!-- end-model-doc -->
	 *
	 * @body not (isMulticast and isMultireceive)
	 */
	def validate_is_multicast_or_is_multireceive: Boolean  = {
    	// Start of user code for "is_multicast_or_is_multireceive"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * ObjectFlows may not have ExecutableNodes at either end.
	 * <!-- end-model-doc -->
	 *
	 * @body not (source.oclIsKindOf(ExecutableNode) or target.oclIsKindOf(ExecutableNode))
	 */
	def validate_no_executable_nodes: Boolean  = {
    	// Start of user code for "no_executable_nodes"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * ObjectNodes connected by an ObjectFlow, with optionally intervening ControlNodes, must have the same upperValues.
	 * <!-- end-model-doc -->
	 *
	 */
	def validate_same_upper_values: Boolean  = {
    	// Start of user code for "same_upper_values"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An ObjectFlow may have a selection Behavior only if it has an ObjectNode as its source.
	 * <!-- end-model-doc -->
	 *
	 * @body selection<>null implies source.oclIsKindOf(ObjectNode)
	 */
	def validate_selection_behavior: Boolean  = {
    	// Start of user code for "selection_behavior"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An ObjectFlow with a constant weight may not target an ObjectNode, with optionally intervening ControlNodes, that has an upper bound less than the weight.
	 * <!-- end-model-doc -->
	 *
	 */
	def validate_target: Boolean  = {
    	// Start of user code for "target"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A transformation Behavior has one input Parameter and one output Parameter. The input Parameter must be the same as or a supertype of the type of object token coming from the source end. The output Parameter must be the same or a subtype of the type of object token expected downstream. The Behavior cannot have side effects.
	 * <!-- end-model-doc -->
	 *
	 * @body transformation<>null implies
	 * 	transformation.inputParameters()->size()=1 and
	 * 	transformation.outputParameters()->size()=1
	 */
	def validate_transformation_behavior: Boolean  = {
    	// Start of user code for "transformation_behavior"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLObjectFlow
