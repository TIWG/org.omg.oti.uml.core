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
 * A Gate is a MessageEnd which serves as a connection point for relating a Message which has a MessageEnd (sendEvent / receiveEvent) outside an InteractionFragment with another Message which has a MessageEnd (receiveEvent / sendEvent)  inside that InteractionFragment.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLGateOps[Uml <: UML] { self: UMLGate[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteractionUse.actualGate
	 */
	def actualGate_interactionUse: Option[UMLInteractionUse[Uml]] = owner.selectByKindOf { case x: UMLInteractionUse[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLCombinedFragment.cfragmentGate
	 */
	def cfragmentGate_combinedFragment: Option[UMLCombinedFragment[Uml]] = owner.selectByKindOf { case x: UMLCombinedFragment[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteraction.formalGate
	 */
	def formalGate_interaction: Option[UMLInteraction[Uml]] = namespace.selectByKindOf { case x: UMLInteraction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * This query returns the name of the gate, either the explicit name (.name) or the constructed name ('out_" or 'in_' concatenated in front of .message.name) if the explicit name is not present.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if name->notEmpty() then name->asOrderedSet()->first()
	 * else  if isActual() or isOutsideCF() 
	 *   then if isSend() 
	 *     then 'out_'.concat(self.message.name->asOrderedSet()->first())
	 *     else 'in_'.concat(self.message.name->asOrderedSet()->first())
	 *     endif
	 *   else if isSend()
	 *     then 'in_'.concat(self.message.name->asOrderedSet()->first())
	 *     else 'out_'.concat(self.message.name->asOrderedSet()->first())
	 *     endif
	 *   endif
	 * endif)
	 */
	def getName: Option[String]  = {
		// Start of user code for "getName"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If the Gate is an inside Combined Fragment Gate, this operation returns the InteractionOperand that the opposite end of this Gate is included within.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (if isInsideCF() then
	 *   let oppEnd : MessageEnd = self.oppositeEnd()->asOrderedSet()->first() in
	 *     if oppEnd.oclIsKindOf(MessageOccurrenceSpecification)
	 *     then let oppMOS : MessageOccurrenceSpecification = oppEnd.oclAsType(MessageOccurrenceSpecification)
	 *         in oppMOS.enclosingOperand->asOrderedSet()->first()
	 *     else let oppGate : Gate = oppEnd.oclAsType(Gate)
	 *         in oppGate.combinedFragment.enclosingOperand->asOrderedSet()->first()
	 *     endif
	 *   else null
	 * endif)
	 */
	def getOperand: Option[UMLInteractionOperand[Uml]]  = {
		// Start of user code for "getOperand"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * This query returns true value if this Gate is an actualGate of an InteractionUse.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (interactionUse->notEmpty())
	 */
	def isActual: Boolean  = {
		// Start of user code for "isActual"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isDistinguishableFrom() specifies that two Gates may coexist in the same Namespace, without an explicit name property. The association end formalGate subsets ownedElement, and since the Gate name attribute
	 is optional, it is allowed to have two formal gates without an explicit name, but having derived names which are distinct.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (true)
	 */
	override def isDistinguishableFrom(n: Option[UMLNamedElement[Uml]], ns: Option[UMLNamespace[Uml]]): Boolean  = {
		// Start of user code for "isDistinguishableFrom"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * This query returns true if this Gate is a formalGate of an Interaction.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (interaction->notEmpty())
	 */
	def isFormal: Boolean  = {
		// Start of user code for "isFormal"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * This query returns true if this Gate is attached to the boundary of a CombinedFragment, and its other end (if present) is inside of an InteractionOperator of the same CombinedFragment.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (self.oppositeEnd()-> notEmpty() and combinedFragment->notEmpty() implies
	 * let oppEnd : MessageEnd = self.oppositeEnd()->asOrderedSet()->first() in
	 * if oppEnd.oclIsKindOf(MessageOccurrenceSpecification)
	 * then let oppMOS : MessageOccurrenceSpecification
	 * = oppEnd.oclAsType(MessageOccurrenceSpecification)
	 * in combinedFragment = oppMOS.enclosingOperand.combinedFragment
	 * else let oppGate : Gate = oppEnd.oclAsType(Gate)
	 * in combinedFragment = oppGate.combinedFragment.enclosingOperand.combinedFragment
	 * endif)
	 */
	def isInsideCF: Boolean  = {
		// Start of user code for "isInsideCF"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * This query returns true if this Gate is attached to the boundary of a CombinedFragment, and its other end (if present)  is outside of the same CombinedFragment.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (self.oppositeEnd()-> notEmpty() and combinedFragment->notEmpty() implies
	 * let oppEnd : MessageEnd = self.oppositeEnd()->asOrderedSet()->first() in
	 * if oppEnd.oclIsKindOf(MessageOccurrenceSpecification) 
	 * then let oppMOS : MessageOccurrenceSpecification = oppEnd.oclAsType(MessageOccurrenceSpecification)
	 * in  self.combinedFragment.enclosingInteraction.oclAsType(InteractionFragment)->asSet()->
	 *      union(self.combinedFragment.enclosingOperand.oclAsType(InteractionFragment)->asSet()) =
	 *      oppMOS.enclosingInteraction.oclAsType(InteractionFragment)->asSet()->
	 *      union(oppMOS.enclosingOperand.oclAsType(InteractionFragment)->asSet())
	 * else let oppGate : Gate = oppEnd.oclAsType(Gate) 
	 * in self.combinedFragment.enclosingInteraction.oclAsType(InteractionFragment)->asSet()->
	 *      union(self.combinedFragment.enclosingOperand.oclAsType(InteractionFragment)->asSet()) =
	 *      oppGate.combinedFragment.enclosingInteraction.oclAsType(InteractionFragment)->asSet()->
	 *      union(oppGate.combinedFragment.enclosingOperand.oclAsType(InteractionFragment)->asSet())
	 * endif)
	 */
	def isOutsideCF: Boolean  = {
		// Start of user code for "isOutsideCF"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * This query returns true if the name of this Gate matches the name of the in parameter Gate, and the messages for the two Gates correspond. The Message for one Gate (say A) corresponds to the Message for another Gate (say B) if (A and B have the same name value) and (if A is a sendEvent then B is a receiveEvent) and (if A is a receiveEvent then B is a sendEvent) and (A and B have the same messageSort value) and (A and B have the same signature value).
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (self.getName() = gateToMatch.getName() and 
	 * self.message.messageSort = gateToMatch.message.messageSort and
	 * self.message.name = gateToMatch.message.name and
	 * self.message.sendEvent->includes(self) implies gateToMatch.message.receiveEvent->includes(gateToMatch)  and
	 * self.message.receiveEvent->includes(self) implies gateToMatch.message.sendEvent->includes(gateToMatch) and
	 * self.message.signature = gateToMatch.message.signature)
	 */
	def matches(gateToMatch: Option[UMLGate[Uml]]): Boolean  = {
		// Start of user code for "matches"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * isActual() implies that no other actualGate of the parent InteractionUse returns the same getName() as returned for self
	 * <!-- end-model-doc -->
	 *
	 * @body isActual() implies interactionUse.actualGate->select(getName() = self.getName())->size()=1
	 */
	def validate_actual_gate_distinguishable: Boolean  = {
		// Start of user code for "actual_gate_distinguishable"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If this Gate is an actualGate, it must have exactly one matching formalGate within the referred Interaction.
	 * <!-- end-model-doc -->
	 *
	 * @body interactionUse->notEmpty() implies interactionUse.refersTo.formalGate->select(matches(self))->size()=1
	 */
	def validate_actual_gate_matched: Boolean  = {
		// Start of user code for "actual_gate_matched"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * isFormal() implies that no other formalGate of the parent Interaction returns the same getName() as returned for self
	 * <!-- end-model-doc -->
	 *
	 * @body isFormal() implies interaction.formalGate->select(getName() = self.getName())->size()=1
	 */
	def validate_formal_gate_distinguishable: Boolean  = {
		// Start of user code for "formal_gate_distinguishable"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * isInsideCF() implies that no other inside cfragmentGate attached to a message with its other end in the same InteractionOperator as self, returns the same getName() as returned for self
	 * <!-- end-model-doc -->
	 *
	 * @body isInsideCF() implies
	 * let selfOperand : InteractionOperand = self.getOperand() in
	 *   combinedFragment.cfragmentGate->select(isInsideCF() and getName() = self.getName())->select(getOperand() = selfOperand)->size()=1
	 */
	def validate_inside_cf_gate_distinguishable: Boolean  = {
		// Start of user code for "inside_cf_gate_distinguishable"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If this Gate is inside a CombinedFragment, it must have exactly one matching Gate which is outside of that CombinedFragment.
	 * <!-- end-model-doc -->
	 *
	 * @body isInsideCF() implies combinedFragment.cfragmentGate->select(isOutsideCF() and matches(self))->size()=1
	 */
	def validate_inside_cf_matched: Boolean  = {
		// Start of user code for "inside_cf_matched"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * isOutsideCF() implies that no other outside cfragmentGate of the parent CombinedFragment returns the same getName() as returned for self
	 * <!-- end-model-doc -->
	 *
	 * @body isOutsideCF() implies combinedFragment.cfragmentGate->select(getName() = self.getName())->size()=1
	 */
	def validate_outside_cf_gate_distinguishable: Boolean  = {
		// Start of user code for "outside_cf_gate_distinguishable"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If this Gate is outside an 'alt' CombinedFragment,  for every InteractionOperator inside that CombinedFragment there must be exactly one matching Gate inside the CombindedFragment with its opposing end enclosed by that InteractionOperator. If this Gate is outside CombinedFragment with operator other than 'alt',   there must be exactly one matching Gate inside that CombinedFragment.
	 * <!-- end-model-doc -->
	 *
	 * @body isOutsideCF() implies
	 *  if self.combinedFragment.interactionOperator->asOrderedSet()->first() = InteractionOperatorKind::alt
	 *  then self.combinedFragment.operand->forAll(op : InteractionOperand |
	 *  self.combinedFragment.cfragmentGate->select(isInsideCF() and 
	 *  oppositeEnd().enclosingFragment()->includes(self.combinedFragment) and matches(self))->size()=1)
	 *  else  self.combinedFragment.cfragmentGate->select(isInsideCF() and matches(self))->size()=1
	 *  endif
	 */
	def validate_outside_cf_matched: Boolean  = {
		// Start of user code for "outside_cf_matched"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLGate
