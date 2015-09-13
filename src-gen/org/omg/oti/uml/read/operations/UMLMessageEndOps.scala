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

import org.omg.oti.uml.read.api.{UML, UMLInteractionFragment, UMLMessageEnd}

import scala.language.postfixOps
// End of user code

/**
 * MessageEnd is an abstract specialization of NamedElement that represents what can occur at the end of a Message.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLMessageEndOps[Uml <: UML] { self: UMLMessageEnd[Uml] =>

	import self.ops._

	/**
	 * This query returns a set including the enclosing InteractionFragment this MessageEnd is enclosed within.
	 *
	 * <!-- Start of user code doc for enclosingFragment -->
   * <!-- End of user code doc for enclosingFragment -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (if self->select(oclIsKindOf(Gate))->notEmpty() 
	 * then -- it is a Gate
	 * let endGate : Gate = 
	 *   self->select(oclIsKindOf(Gate)).oclAsType(Gate)->asOrderedSet()->first()
	 *   in
	 *   if endGate.isOutsideCF() 
	 *   then endGate.combinedFragment.enclosingInteraction.oclAsType(InteractionFragment)->asSet()->
	 *      union(endGate.combinedFragment.enclosingOperand.oclAsType(InteractionFragment)->asSet())
	 *   else if endGate.isInsideCF() 
	 *     then endGate.combinedFragment.oclAsType(InteractionFragment)->asSet()
	 *     else if endGate.isFormal() 
	 *       then endGate.interaction.oclAsType(InteractionFragment)->asSet()
	 *       else if endGate.isActual() 
	 *         then endGate.interactionUse.enclosingInteraction.oclAsType(InteractionFragment)->asSet()->
	 *      union(endGate.interactionUse.enclosingOperand.oclAsType(InteractionFragment)->asSet())
	 *         else null
	 *         endif
	 *       endif
	 *     endif
	 *   endif
	 * else -- it is a MessageOccurrenceSpecification
	 * let endMOS : MessageOccurrenceSpecification  = 
	 *   self->select(oclIsKindOf(MessageOccurrenceSpecification)).oclAsType(MessageOccurrenceSpecification)->asOrderedSet()->first() 
	 *   in
	 *   if endMOS.enclosingInteraction->notEmpty() 
	 *   then endMOS.enclosingInteraction.oclAsType(InteractionFragment)->asSet()
	 *   else endMOS.enclosingOperand.oclAsType(InteractionFragment)->asSet()
	 *   endif
	 * endif)
	 * }}}
	 */
	def enclosingFragment: Set[UMLInteractionFragment[Uml]] = {
		// Start of user code for "enclosingFragment"
      ???
      // End of user code
	}

	/**
	 * This query returns value true if this MessageEnd is a receiveEvent.
	 *
	 * <!-- Start of user code doc for isReceive -->
   * <!-- End of user code doc for isReceive -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (message.receiveEvent->asSet()->includes(self))
	 * }}}
	 */
	def isReceive: Boolean = {
		// Start of user code for "isReceive"
      ???
      // End of user code
	}

	/**
	 * This query returns value true if this MessageEnd is a sendEvent.
	 *
	 * <!-- Start of user code doc for isSend -->
   * <!-- End of user code doc for isSend -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (message.sendEvent->asSet()->includes(self))
	 * }}}
	 */
	def isSend: Boolean = {
		// Start of user code for "isSend"
      ???
      // End of user code
	}

	/**
	 * This query returns a set including the MessageEnd (if exists) at the opposite end of the Message for this MessageEnd.
	 *
	 * <!-- Start of user code doc for oppositeEnd -->
   * <!-- End of user code doc for oppositeEnd -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (message->asSet().messageEnd->asSet()->excluding(self))
	 * }}}
	 */
	def oppositeEnd: Set[UMLMessageEnd[Uml]] = {
		// Start of user code for "oppositeEnd"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLMessageEndOps
