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

import org.omg.oti.uml.read.api.{UMLConnectionPointReference, UML, UMLState}
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLConnectionPointReferenceOps[Uml <: UML] { self: UMLConnectionPointReference[Uml] =>	

	import self.ops._

	/**
	 * The State in which the ConnectionPointReference is defined.
	 *
	 * <!-- Start of user code doc for state -->
	 * <!-- End of user code doc for state -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.connection
	 */
	def state: Option[UMLState[Uml]] = namespace.selectByKindOf { case x: UMLState[Uml] => x }

	/**
	 * The entry Pseudostates must be Pseudostates with kind entryPoint.
	 *
	 * <!-- Start of user code doc for validate_entry_pseudostates -->
	 * <!-- End of user code doc for validate_entry_pseudostates -->
	 *
	 * @body entry->forAll(kind = PseudostateKind::entryPoint)
	 */
	def validate_entry_pseudostates: Boolean = {
		// Start of user code for "entry_pseudostates"
    	???
    	// End of user code
	}

	/**
	 * The exit Pseudostates must be Pseudostates with kind exitPoint.
	 *
	 * <!-- Start of user code doc for validate_exit_pseudostates -->
	 * <!-- End of user code doc for validate_exit_pseudostates -->
	 *
	 * @body exit->forAll(kind = PseudostateKind::exitPoint)
	 */
	def validate_exit_pseudostates: Boolean = {
		// Start of user code for "exit_pseudostates"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLConnectionPointReferenceOps
