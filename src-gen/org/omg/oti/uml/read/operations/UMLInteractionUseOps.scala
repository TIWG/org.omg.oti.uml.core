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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referenced Interaction where the InteractionUse is. To be accurate the copying must take into account substituting parameters with arguments and connect the formal Gates with the actual ones.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInteractionUseOps[Uml <: UML] { self: UMLInteractionUse[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * The actual gates of the InteractionUse.
	 *
	 * <!-- Start of user code doc for actualGate -->
   * <!-- End of user code doc for actualGate -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLGate.actualGate_interactionUse
	 */
	def actualGate: Set[UMLGate[Uml]] = ownedElement.selectByKindOf { case x: UMLGate[Uml] => x }

	/**
	 * The InteractionUse must cover all Lifelines of the enclosing Interaction that are common with the lifelines covered by the referred Interaction. Lifelines are common if they have the same selector and represents associationEnd values.
	 *
	 * <!-- Start of user code doc for validate_all_lifelines -->
   * <!-- End of user code doc for validate_all_lifelines -->
	 *
	 * {{{
	 * OCL Body let parentInteraction : Set(Interaction) = enclosingInteraction->asSet()->
	 * union(enclosingOperand.combinedFragment->closure(enclosingOperand.combinedFragment)->
	 * collect(enclosingInteraction).oclAsType(Interaction)->asSet()) in
	 * parentInteraction->size()=1 and let refInteraction : Interaction = refersTo in
	 * parentInteraction.covered-> forAll(intLifeline : Lifeline | refInteraction.covered->
	 * forAll( refLifeline : Lifeline | refLifeline.represents = intLifeline.represents and 
	 * (
	 * ( refLifeline.selector.oclIsKindOf(LiteralString) implies
	 *   intLifeline.selector.oclIsKindOf(LiteralString) and 
	 *   refLifeline.selector.oclAsType(LiteralString).value = intLifeline.selector.oclAsType(LiteralString).value ) and
	 * ( refLifeline.selector.oclIsKindOf(LiteralInteger) implies
	 *   intLifeline.selector.oclIsKindOf(LiteralInteger) and 
	 *   refLifeline.selector.oclAsType(LiteralInteger).value = intLifeline.selector.oclAsType(LiteralInteger).value )
	 * )
	 *  implies self.covered->asSet()->includes(intLifeline)))
	 * }}}
	 */
	def validate_all_lifelines: Boolean = {
		// Start of user code for "all_lifelines"
      ???
      // End of user code
	}

	/**
	 * The arguments must only be constants, parameters of the enclosing Interaction or attributes of the classifier owning the enclosing Interaction.
	 *
	 * <!-- Start of user code doc for validate_arguments_are_constants -->
   * <!-- End of user code doc for validate_arguments_are_constants -->
	 *
	 * {{{
	 * }}}
	 */
	def validate_arguments_are_constants: Boolean = {
		// Start of user code for "arguments_are_constants"
      ???
      // End of user code
	}

	/**
	 * The arguments of the InteractionUse must correspond to parameters of the referred Interaction.
	 *
	 * <!-- Start of user code doc for validate_arguments_correspond_to_parameters -->
   * <!-- End of user code doc for validate_arguments_correspond_to_parameters -->
	 *
	 * {{{
	 * }}}
	 */
	def validate_arguments_correspond_to_parameters: Boolean = {
		// Start of user code for "arguments_correspond_to_parameters"
      ???
      // End of user code
	}

	/**
	 * Actual Gates of the InteractionUse must match Formal Gates of the referred Interaction. Gates match when their names are equal and their messages correspond.
	 *
	 * <!-- Start of user code doc for validate_gates_match -->
   * <!-- End of user code doc for validate_gates_match -->
	 *
	 * {{{
	 * OCL Body actualGate->notEmpty() implies 
	 * refersTo.formalGate->forAll( fg : Gate | self.actualGate->select(matches(fg))->size()=1) and
	 * self.actualGate->forAll(ag : Gate | refersTo.formalGate->select(matches(ag))->size()=1)
	 * }}}
	 */
	def validate_gates_match: Boolean = {
		// Start of user code for "gates_match"
      ???
      // End of user code
	}

	/**
	 * The returnValueRecipient must be a Property of a ConnectableElement that is represented by a Lifeline covered by this InteractionUse.
	 *
	 * <!-- Start of user code doc for validate_returnValueRecipient_coverage -->
   * <!-- End of user code doc for validate_returnValueRecipient_coverage -->
	 *
	 * {{{
	 * OCL Body returnValueRecipient->asSet()->notEmpty() implies
	 * let covCE : Set(ConnectableElement) = covered.represents->asSet() in 
	 * covCE->notEmpty() and let classes:Set(Classifier) = covCE.type.oclIsKindOf(Classifier).oclAsType(Classifier)->asSet() in 
	 * let allProps : Set(Property) = classes.attribute->union(classes.allParents().attribute)->asSet() in 
	 * allProps->includes(returnValueRecipient)
	 * }}}
	 */
	def validate_returnValueRecipient_coverage: Boolean = {
		// Start of user code for "returnValueRecipient_coverage"
      ???
      // End of user code
	}

	/**
	 * The type of the returnValue must correspond to the type of the returnValueRecipient.
	 *
	 * <!-- Start of user code doc for validate_returnValue_type_recipient_correspondence -->
   * <!-- End of user code doc for validate_returnValue_type_recipient_correspondence -->
	 *
	 * {{{
	 * OCL Body returnValue.type->asSequence()->notEmpty() implies returnValue.type->asSequence()->first() = returnValueRecipient.type->asSequence()->first()
	 * }}}
	 */
	def validate_returnValue_type_recipient_correspondence: Boolean = {
		// Start of user code for "returnValue_type_recipient_correspondence"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLInteractionUseOps
