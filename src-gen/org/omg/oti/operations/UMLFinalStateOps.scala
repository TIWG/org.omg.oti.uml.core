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
 * A special kind of State, which, when entered, signifies that the enclosing Region has completed. If the enclosing Region is directly contained in a StateMachine and all other Regions in that StateMachine also are completed, then it means that the entire StateMachine behavior is completed.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLFinalStateOps[Uml <: UML] { self: UMLFinalState[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * A FinalState cannot reference a submachine.
	 * <!-- end-model-doc -->
	 *
	 * @body submachine->isEmpty()
	 */
	def validate_cannot_reference_submachine: Boolean  = {
		// Start of user code for "cannot_reference_submachine"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A FinalState has no entry Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @body entry->isEmpty()
	 */
	def validate_no_entry_behavior: Boolean  = {
		// Start of user code for "no_entry_behavior"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A FinalState has no exit Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @body exit->isEmpty()
	 */
	def validate_no_exit_behavior: Boolean  = {
		// Start of user code for "no_exit_behavior"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A FinalState cannot have any outgoing Transitions.
	 * <!-- end-model-doc -->
	 *
	 * @body outgoing->size() = 0
	 */
	def validate_no_outgoing_transitions: Boolean  = {
		// Start of user code for "no_outgoing_transitions"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A FinalState cannot have Regions.
	 * <!-- end-model-doc -->
	 *
	 * @body region->size() = 0
	 */
	def validate_no_regions: Boolean  = {
		// Start of user code for "no_regions"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A FinalState has no state (doActivity) Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @body doActivity->isEmpty()
	 */
	def validate_no_state_behavior: Boolean  = {
		// Start of user code for "no_state_behavior"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLFinalState
