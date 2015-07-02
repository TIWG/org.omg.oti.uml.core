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

import org.omg.oti.uml.read.api.{UML, UMLInteractionFragment, UMLActionExecutionSpecification}
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * An ActionExecutionSpecification is a kind of ExecutionSpecification representing the execution of an Action.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActionExecutionSpecificationOps[Uml <: UML] { self: UMLActionExecutionSpecification[Uml] =>	

	import self.ops._

	/**
	 * The Action referenced by the ActionExecutionSpecification must be owned by the Interaction owning that ActionExecutionSpecification.
	 *
	 * <!-- Start of user code doc for validate_action_referenced -->
	 * <!-- End of user code doc for validate_action_referenced -->
	 *
	 * @body (enclosingInteraction->notEmpty() or enclosingOperand.combinedFragment->notEmpty()) and
	 * let parentInteraction : Set(Interaction) = enclosingInteraction.oclAsType(Interaction)->asSet()->union(
	 * enclosingOperand.combinedFragment->closure(enclosingOperand.combinedFragment)->
	 * collect(enclosingInteraction).oclAsType(Interaction)->asSet()) in
	 * (parentInteraction->size() = 1) and self.action.interaction->asSet() = parentInteraction
	 */
	def validate_action_referenced: Boolean = {
		// Start of user code for "action_referenced"
      self.action match {
        case Some(a) => 
          val parentInteraction: Set[UMLInteractionFragment[Uml]] =
						closure[UMLInteractionFragment[Uml], UMLInteractionFragment[Uml]](
							self, combinedFragmentFromEnclosingOperand(_).toSet + self).flatMap( _.enclosingInteraction )

					if (parentInteraction.size != 1) false
					else a.action_interaction == parentInteraction.headOption

				case None => true
      }
      // End of user code
	}

	// Start of user code for additional features
	def combinedFragmentFromEnclosingOperand(interactionFragment: UMLInteractionFragment[Uml]): Option[UMLInteractionFragment[Uml]] = {
		for {
	    	eo <- interactionFragment.enclosingOperand
	    	cf <- eo.operand_combinedFragment
		} yield cf
	}
	// End of user code
} //UMLActionExecutionSpecificationOps
