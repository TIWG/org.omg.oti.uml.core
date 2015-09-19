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
import org.omg.oti.uml.read.api._
import scala.Boolean
// End of user code

/**
 * A ForkNode is a ControlNode that splits a flow into multiple concurrent flows.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLForkNodeOps[Uml <: UML] { self: UMLForkNode[Uml] =>

// Start of user code for class imports
// End of user code


	/**
	 * The ActivityEdges incoming to and outgoing from a ForkNode must be either all ObjectFlows or all ControlFlows.
	 *
	 * <!-- Start of user code doc for validate_edges -->
   * <!-- End of user code doc for validate_edges -->
	 *
	 * {{{
	 * OCL Body let allEdges : Set(ActivityEdge) = incoming->union(outgoing) in
	 * }}}
	 * {{{
	 * allEdges->forAll(oclIsKindOf(ControlFlow)) or allEdges->forAll(oclIsKindOf(ObjectFlow))
	 * }}}
	 */
	def validate_edges: Boolean = {
		// Start of user code for "edges"
    (incoming ++ outgoing).forall {
                                    case _: UMLControlFlow[Uml] => true
                                    case _: UMLObjectFlow[Uml]  => true
                                    case _                      => false
                                  }
    // End of user code
	}

	/**
	 * A ForkNode has one incoming ActivityEdge.
	 *
	 * <!-- Start of user code doc for validate_one_incoming_edge -->
   * <!-- End of user code doc for validate_one_incoming_edge -->
	 *
	 * {{{
	 * OCL Body incoming->size()=1
	 * }}}
	 */
	def validate_one_incoming_edge: Boolean = {
		// Start of user code for "one_incoming_edge"
    1 == incoming.size
    // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLForkNodeOps
