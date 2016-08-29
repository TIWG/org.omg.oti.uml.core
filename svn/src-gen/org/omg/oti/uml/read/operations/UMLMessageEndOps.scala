/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * MessageEnd is an abstract specialization of NamedElement that represents what can occur at the end of a Message.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLMessageEndOps[Uml <: UML] { self: UMLMessageEnd[Uml] =>

// Start of user code for class imports
// End of user code


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
