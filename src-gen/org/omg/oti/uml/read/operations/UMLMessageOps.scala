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
 * A Message defines a particular communication between Lifelines of an Interaction.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLMessageOps[Uml <: UML] { self: UMLMessage[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * The enclosing Interaction owning the Message.
	 *
	 * <!-- Start of user code doc for interaction -->
   * <!-- End of user code doc for interaction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInteraction.message
	 */
	def interaction: Option[UMLInteraction[Uml]] = namespace.selectByKindOf { case x: UMLInteraction[Uml] => x }

	/**
	 * The derived kind of the Message (complete, lost, found, or unknown).
	 *
	 * <!-- Start of user code doc for messageKind -->
   * <!-- End of user code doc for messageKind -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (messageKind)
	 * }}}
	 */
	def messageKind: UMLMessageKind.Value = {
		// Start of user code for "messageKind"
      ???
      // End of user code
	}

	/**
	 * The query isDistinguishableFrom() specifies that any two Messages may coexist in the same Namespace, regardless of their names.
	 *
	 * <!-- Start of user code doc for isDistinguishableFrom -->
   * <!-- End of user code doc for isDistinguishableFrom -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (true)
	 * }}}
	 */
	override def isDistinguishableFrom(n: Option[UMLNamedElement[Uml]], ns: Option[UMLNamespace[Uml]]): Boolean = {
		// Start of user code for "isDistinguishableFrom"
      ???
      // End of user code
	}

	/**
	 * Arguments of a Message must only be: i) attributes of the sending lifeline, ii) constants, iii) symbolic values (which are wildcard values representing any legal value), iv) explicit parameters of the enclosing Interaction, v) attributes of the class owning the Interaction.
	 *
	 * <!-- Start of user code doc for validate_arguments -->
   * <!-- End of user code doc for validate_arguments -->
	 *
	 * {{{
	 * }}}
	 */
	def validate_arguments: Boolean = {
		// Start of user code for "arguments"
      ???
      // End of user code
	}

	/**
	 * Messages cannot cross boundaries of CombinedFragments or their operands.  This is true if and only if both MessageEnds are enclosed within the same InteractionFragment (i.e., an InteractionOperand or an Interaction).
	 *
	 * <!-- Start of user code doc for validate_cannot_cross_boundaries -->
   * <!-- End of user code doc for validate_cannot_cross_boundaries -->
	 *
	 * {{{
	 * OCL Body sendEvent->notEmpty() and receiveEvent->notEmpty() implies
	 * let sendEnclosingFrag : Set(InteractionFragment) = 
	 * sendEvent->asOrderedSet()->first().enclosingFragment()
	 * in 
	 * let receiveEnclosingFrag : Set(InteractionFragment) = 
	 * receiveEvent->asOrderedSet()->first().enclosingFragment()
	 * in  sendEnclosingFrag = receiveEnclosingFrag
	 * }}}
	 */
	def validate_cannot_cross_boundaries: Boolean = {
		// Start of user code for "cannot_cross_boundaries"
      ???
      // End of user code
	}

	/**
	 * If the MessageEnds are both OccurrenceSpecifications, then the connector must go between the Parts represented by the Lifelines of the two MessageEnds.
	 *
	 * <!-- Start of user code doc for validate_occurrence_specifications -->
   * <!-- End of user code doc for validate_occurrence_specifications -->
	 *
	 * {{{
	 * }}}
	 */
	def validate_occurrence_specifications: Boolean = {
		// Start of user code for "occurrence_specifications"
      ???
      // End of user code
	}

	/**
	 * If the sendEvent and the receiveEvent of the same Message are on the same Lifeline, the sendEvent must be ordered before the receiveEvent.
	 *
	 * <!-- Start of user code doc for validate_sending_receiving_message_event -->
   * <!-- End of user code doc for validate_sending_receiving_message_event -->
	 *
	 * {{{
	 * OCL Body receiveEvent.oclIsKindOf(MessageOccurrenceSpecification)
	 * implies
	 * let f :  Lifeline = sendEvent->select(oclIsKindOf(MessageOccurrenceSpecification)).oclAsType(MessageOccurrenceSpecification)->asOrderedSet()->first().covered in
	 * f = receiveEvent->select(oclIsKindOf(MessageOccurrenceSpecification)).oclAsType(MessageOccurrenceSpecification)->asOrderedSet()->first().covered  implies
	 * f.events->indexOf(sendEvent.oclAsType(MessageOccurrenceSpecification)->asOrderedSet()->first() ) < 
	 * f.events->indexOf(receiveEvent.oclAsType(MessageOccurrenceSpecification)->asOrderedSet()->first() )
	 * }}}
	 */
	def validate_sending_receiving_message_event: Boolean = {
		// Start of user code for "sending_receiving_message_event"
      ???
      // End of user code
	}

	/**
	 * In the case when a Message with messageSort reply has a non empty Operation signature, the arguments of the Message must correspond to the out, inout, and return parameters of the Operation. A Parameter corresponds to an Argument if the Argument is of the same Class or a specialization of that of the Parameter.
	 *
	 * <!-- Start of user code doc for validate_signature_is_operation_reply -->
   * <!-- End of user code doc for validate_signature_is_operation_reply -->
	 *
	 * {{{
	 * OCL Body (messageSort = MessageSort::reply) and signature.oclIsKindOf(Operation) implies 
	 *  let replyParms : OrderedSet(Parameter) = signature.oclAsType(Operation).ownedParameter->
	 * select(direction = ParameterDirectionKind::inout or direction = ParameterDirectionKind::out or direction = ParameterDirectionKind::return)
	 * in replyParms->size() = self.argument->size() and
	 * self.argument->forAll( o: ValueSpecification | o.oclIsKindOf(Expression) and let e : Expression = o.oclAsType(Expression) in
	 * e.operand->notEmpty()  implies 
	 * let p : Parameter = replyParms->at(self.argument->indexOf(o)) in
	 * e.operand->asSequence()->first().type.oclAsType(Classifier).conformsTo(p.type.oclAsType(Classifier))
	 * )
	 * }}}
	 */
	def validate_signature_is_operation_reply: Boolean = {
		// Start of user code for "signature_is_operation_reply"
      ???
      // End of user code
	}

	/**
	 * In the case when a Message with messageSort synchCall or asynchCall has a non empty Operation signature, the arguments of the Message must correspond to the in and inout parameters of the Operation. A Parameter corresponds to an Argument if the Argument is of the same Class or a specialization of that of the Parameter.
	 *
	 * <!-- Start of user code doc for validate_signature_is_operation_request -->
   * <!-- End of user code doc for validate_signature_is_operation_request -->
	 *
	 * {{{
	 * OCL Body (messageSort = MessageSort::asynchCall or messageSort = MessageSort::synchCall) and signature.oclIsKindOf(Operation)  implies 
	 *  let requestParms : OrderedSet(Parameter) = signature.oclAsType(Operation).ownedParameter->
	 *  select(direction = ParameterDirectionKind::inout or direction = ParameterDirectionKind::_'in'  )
	 * in requestParms->size() = self.argument->size() and
	 * self.argument->forAll( o: ValueSpecification | 
	 * not (o.oclIsKindOf(Expression) and o.oclAsType(Expression).symbol->size()=0 and o.oclAsType(Expression).operand->isEmpty() ) implies 
	 * let p : Parameter = requestParms->at(self.argument->indexOf(o)) in
	 * o.type.oclAsType(Classifier).conformsTo(p.type.oclAsType(Classifier))
	 * )
	 * }}}
	 */
	def validate_signature_is_operation_request: Boolean = {
		// Start of user code for "signature_is_operation_request"
      ???
      // End of user code
	}

	/**
	 * In the case when the Message signature is a Signal, the arguments of the Message must correspond to the attributes of the Signal. A Message Argument corresponds to a Signal Attribute if the Argument is of the same Class or a specialization of that of the Attribute.
	 *
	 * <!-- Start of user code doc for validate_signature_is_signal -->
   * <!-- End of user code doc for validate_signature_is_signal -->
	 *
	 * {{{
	 * OCL Body (messageSort = MessageSort::asynchSignal ) and signature.oclIsKindOf(Signal) implies
	 *    let signalAttributes : OrderedSet(Property) = signature.oclAsType(Signal).inheritedMember()->
	 *              select(n:NamedElement | n.oclIsTypeOf(Property))->collect(oclAsType(Property))->asOrderedSet()
	 *    in signalAttributes->size() = self.argument->size()
	 *    and self.argument->forAll( o: ValueSpecification |
	 *           not (o.oclIsKindOf(Expression)
	 *           and o.oclAsType(Expression).symbol->size()=0
	 *           and o.oclAsType(Expression).operand->isEmpty() ) implies
	 *               let p : Property = signalAttributes->at(self.argument->indexOf(o))
	 *               in o.type.oclAsType(Classifier).conformsTo(p.type.oclAsType(Classifier)))
	 * }}}
	 */
	def validate_signature_is_signal: Boolean = {
		// Start of user code for "signature_is_signal"
      ???
      // End of user code
	}

	/**
	 * The signature must either refer an Operation (in which case messageSort is either synchCall or asynchCall or reply) or a Signal (in which case messageSort is asynchSignal). The name of the NamedElement referenced by signature must be the same as that of the Message.
	 *
	 * <!-- Start of user code doc for validate_signature_refer_to -->
   * <!-- End of user code doc for validate_signature_refer_to -->
	 *
	 * {{{
	 * OCL Body signature->notEmpty() implies 
	 * ((signature.oclIsKindOf(Operation) and 
	 * (messageSort = MessageSort::asynchCall or messageSort = MessageSort::synchCall or messageSort = MessageSort::reply) 
	 * ) or (signature.oclIsKindOf(Signal)  and messageSort = MessageSort::asynchSignal )
	 *  ) and name = signature.name
	 * }}}
	 */
	def validate_signature_refer_to: Boolean = {
		// Start of user code for "signature_refer_to"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLMessageOps
