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
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A Vertex is an abstraction of a node in a StateMachine graph. It can be the source or destination of any number of Transitions.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLVertexOps[Uml <: UML] { self: UMLVertex[Uml] =>	

	import self.ops._

	/**
	 * The Region that contains this Vertex.
	 *
	 * <!-- Start of user code doc for container -->
	 * <!-- End of user code doc for container -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRegion.subvertex
	 */
	def container: Option[UMLRegion[Uml]] = namespace.selectByKindOf { case x: UMLRegion[Uml] => x }

	/**
	 * Specifies the Transitions entering this Vertex.
	 *
	 * <!-- Start of user code doc for incoming -->
	 * <!-- End of user code doc for incoming -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.target
	 * @body result = (Transition.allInstances()->select(target=self))
	 */
	def incoming: Set[UMLTransition[Uml]] = {
		// Start of user code for "incoming"
	    ???
	    // End of user code
	}

	/**
	 * Specifies the Transitions departing from this Vertex.
	 *
	 * <!-- Start of user code doc for outgoing -->
	 * <!-- End of user code doc for outgoing -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.source
	 * @body result = (Transition.allInstances()->select(source=self))
	 */
	def outgoing: Set[UMLTransition[Uml]] = {
		// Start of user code for "outgoing"
	    ???
	    // End of user code
	}

	/**
	 * The operation containingStateMachine() returns the StateMachine in which this Vertex is defined.
	 *
	 * <!-- Start of user code doc for containingStateMachine -->
	 * <!-- End of user code doc for containingStateMachine -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if container <> null
	 * then
	 * -- the container is a region
	 *    container.containingStateMachine()
	 * else 
	 *    if (self.oclIsKindOf(Pseudostate)) and ((self.oclAsType(Pseudostate).kind = PseudostateKind::entryPoint) or (self.oclAsType(Pseudostate).kind = PseudostateKind::exitPoint)) then
	 *       self.oclAsType(Pseudostate).stateMachine
	 *    else 
	 *       if (self.oclIsKindOf(ConnectionPointReference)) then
	 *           self.oclAsType(ConnectionPointReference).state.containingStateMachine() -- no other valid cases possible
	 *       else 
	 *           null
	 *       endif
	 *    endif
	 * endif
	 * )
	 */
	def containingStateMachine: Option[UMLStateMachine[Uml]] = {
		// Start of user code for "containingStateMachine"
    	???
    	// End of user code
	}

	/**
	 * This utility query returns true if the Vertex is contained in the Region r (input argument).
	 *
	 * <!-- Start of user code doc for isContainedInRegion -->
	 * <!-- End of user code doc for isContainedInRegion -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if (container = r) then
	 * 	true
	 * else
	 * 	if (r.state->isEmpty()) then
	 * 		false
	 * 	else
	 * 		container.state.isContainedInRegion(r)
	 * 	endif
	 * endif)
	 */
	def isContainedInRegion(r: Option[UMLRegion[Uml]]): Boolean = {
		// Start of user code for "isContainedInRegion"
    	???
    	// End of user code
	}

	/**
	 * This utility operation returns true if the Vertex is contained in the State s (input argument).
	 *
	 * <!-- Start of user code doc for isContainedInState -->
	 * <!-- End of user code doc for isContainedInState -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if not s.isComposite() or container->isEmpty() then
	 * 	false
	 * else
	 * 	if container.state = s then 
	 * 		true
	 * 	else
	 * 		container.state.isContainedInState(s)
	 * 	endif
	 * endif)
	 */
	def isContainedInState(s: Option[UMLState[Uml]]): Boolean = {
		// Start of user code for "isContainedInState"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLVertexOps
