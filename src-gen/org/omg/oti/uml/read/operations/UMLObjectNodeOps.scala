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

import org.omg.oti.uml.read.api.{UML, UMLObjectNode}

import scala.language.postfixOps
// End of user code

/**
 * An ObjectNode is an abstract ActivityNode that may hold tokens within the object flow in an Activity. ObjectNodes also support token selection, limitation on the number of tokens held, specification of the state required for tokens being held, and carrying control values.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLObjectNodeOps[Uml <: UML] { self: UMLObjectNode[Uml] =>

	import self.ops._

	/**
	 * A selection Behavior has one input Parameter and one output Parameter. The input Parameter must have the same type as  or a supertype of the type of ObjectNode, be non-unique, and have multiplicity 0..*. The output Parameter must be the same or a subtype of the type of ObjectNode. The Behavior cannot have side effects.
	 *
	 * <!-- Start of user code doc for validate_input_output_parameter -->
   * <!-- End of user code doc for validate_input_output_parameter -->
	 *
	 * @body selection<>null implies
	 * 	selection.inputParameters()->size()=1 and
	 * 	selection.inputParameters()->forAll(p | not p.isUnique and p.is(0,*) and self.type.conformsTo(p.type)) and
	 * 	selection.outputParameters()->size()=1 and
	 * 		selection.inputParameters()->forAll(p | self.type.conformsTo(p.type))
	 * 	
	 */
	def validate_input_output_parameter: Boolean = {
		// Start of user code for "input_output_parameter"
      ???
      // End of user code
	}

	/**
	 * If isControlType=false, the ActivityEdges incoming to or outgoing from an ObjectNode must all be ObjectFlows.
	 *
	 * <!-- Start of user code doc for validate_object_flow_edges -->
   * <!-- End of user code doc for validate_object_flow_edges -->
	 *
	 * @body (not isControlType) implies incoming->union(outgoing)->forAll(oclIsKindOf(ObjectFlow))
	 */
	def validate_object_flow_edges: Boolean = {
		// Start of user code for "object_flow_edges"
      ???
      // End of user code
	}

	/**
	 * If an ObjectNode has a selection Behavior, then the ordering of the object node is ordered, and vice versa.
	 *
	 * <!-- Start of user code doc for validate_selection_behavior -->
   * <!-- End of user code doc for validate_selection_behavior -->
	 *
	 * @body (selection<>null) = (ordering=ObjectNodeOrderingKind::ordered)
	 */
	def validate_selection_behavior: Boolean = {
		// Start of user code for "selection_behavior"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLObjectNodeOps
