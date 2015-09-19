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
import scala.{Int,Option,None,Some,Tuple2}
import scala.Predef._
import scala.collection.Iterable
import scala.collection.immutable.::
import scala.collection.immutable.Nil
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
import java.lang.Integer
// End of user code

/**
 * An AcceptEventAction is an Action that waits for the occurrence of one or more specific Events.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLAcceptEventActionOps[Uml <: UML] { self: UMLAcceptEventAction[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * The Triggers specifying the Events of which the AcceptEventAction waits for occurrences.
	 *
	 * <!-- Start of user code doc for trigger -->
   * <!-- End of user code doc for trigger -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLTrigger.trigger_acceptEventAction
	 */
	def trigger: Set[UMLTrigger[Uml]] = ownedElement.selectByKindOf { case x: UMLTrigger[Uml] => x }

	/**
	 * If isUnmarshall=false and all the triggers are for SignalEvents, then the type of the single result OutputPin must either be null or all the signals must conform to it.
	 *
	 * <!-- Start of user code doc for validate_conforming_type -->
   * <!-- End of user code doc for validate_conforming_type -->
	 *
	 * {{{
	 * OCL Body not isUnmarshall implies 
	 * }}}
	 * {{{
	 * 	result->isEmpty() or
	 * }}}
	 * {{{
	 * 	let type: Type = result->first().type in
	 * }}}
	 * {{{
	 * 	type=null or 
	 * }}}
	 * {{{
	 * 		(trigger->forAll(event.oclIsKindOf(SignalEvent)) and 
	 * }}}
	 * {{{
	 * 		 trigger.event.oclAsType(SignalEvent).signal->forAll(s | s.conformsTo(type)))
	 * }}}
	 */
	def validate_conforming_type: Boolean = {
		// Start of user code for "conforming_type"
    isUnmarshall || {

      def signalCollector
      (acc: Tuple2[Boolean, Set[UMLSignal[Uml]]], tr: UMLTrigger[Uml])
      : Tuple2[Boolean, Set[UMLSignal[Uml]]] =
        tr.event match {
          case Some(se: UMLSignalEvent[Uml]) => Tuple2(acc._1, acc._2 ++ se.signal)
          case Some(_)                       => Tuple2(false, Set())
          case None                          => acc
        }

      val (onlySignals: Boolean, allSignals: Set[UMLSignal[Uml]]) =
        (Tuple2[Boolean, Set[UMLSignal[Uml]]](true, Set()) /: trigger) { signalCollector _ }

      !onlySignals ||
        1 == result.size &&
        allSignals.forall(_.conformsTo(result.head._type))
    }
    // End of user code
	}

	/**
	 * AcceptEventActions may have no input pins.
	 *
	 * <!-- Start of user code doc for validate_no_input_pins -->
   * <!-- End of user code doc for validate_no_input_pins -->
	 *
	 * {{{
	 * OCL Body input->size() = 0
	 * }}}
	 */
	def validate_no_input_pins: Boolean = {
		// Start of user code for "no_input_pins"
    input.isEmpty
    // End of user code
	}

	/**
	 * There are no OutputPins if the trigger events are only ChangeEvents and/or CallEvents when this action is an instance of AcceptEventAction and not an instance of a descendant of AcceptEventAction (such as AcceptCallAction).
	 *
	 * <!-- Start of user code doc for validate_no_output_pins -->
   * <!-- End of user code doc for validate_no_output_pins -->
	 *
	 * {{{
	 * OCL Body (self.oclIsTypeOf(AcceptEventAction) and
	 * }}}
	 * {{{
	 *    (trigger->forAll(event.oclIsKindOf(ChangeEvent) or  
	 * }}}
	 * {{{
	 *                              event.oclIsKindOf(CallEvent))))
	 * }}}
	 * {{{
	 * implies output->size() = 0
	 * }}}
	 */
	def validate_no_output_pins: Boolean = {
		// Start of user code for "no_output_pins"
    self match {
      case _: UMLAcceptCallAction[Uml]  => true
      case _: UMLAcceptEventAction[Uml] =>
        trigger.forall { t =>
          t.event match {
            case Some(_@(_: UMLCallEvent[Uml] | _: UMLChangeEvent[Uml])) => output.size == 0
            case _                                                       => true
          }
                       }
      case _                            => true
    }
    // End of user code
	}

	/**
	 * If isUnmarshall=false and any of the triggers are for SignalEvents or TimeEvents, there must be exactly one result OutputPin with multiplicity 1..1.
	 *
	 * <!-- Start of user code doc for validate_one_output_pin -->
   * <!-- End of user code doc for validate_one_output_pin -->
	 *
	 * {{{
	 * OCL Body not isUnmarshall and trigger->exists(event.oclIsKindOf(SignalEvent) or event.oclIsKindOf(TimeEvent)) implies 
	 * }}}
	 * {{{
	 * 	output->size() = 1 and output->first().is(1,1)
	 * }}}
	 */
	def validate_one_output_pin: Boolean = {
		// Start of user code for "one_output_pin"
    isUnmarshall ||
      trigger
      .exists(_.event match {
                case Some(_@(_: UMLSignalEvent[Uml] | _: UMLTimeEvent[Uml])) => output.size == 1 && output.head.is(1, 1)
                case _                                                       => true
              })
    // End of user code
	}

	/**
	 * If isUnmarshall is true (and this is not an AcceptCallAction), there must be exactly one trigger, which is for a SignalEvent. The number of result output pins must be the same as the number of attributes of the signal. The type and ordering of each result output pin must be the same as the corresponding attribute of the signal. The multiplicity of each result output pin must be compatible with the multiplicity of the corresponding attribute.
	 *
	 * <!-- Start of user code doc for validate_unmarshall_signal_events -->
   * <!-- End of user code doc for validate_unmarshall_signal_events -->
	 *
	 * {{{
	 * OCL Body isUnmarshall and self.oclIsTypeOf(AcceptEventAction) implies
	 * }}}
	 * {{{
	 * 	trigger->size()=1 and
	 * }}}
	 * {{{
	 * 	trigger->asSequence()->first().event.oclIsKindOf(SignalEvent) and
	 * }}}
	 * {{{
	 * 	let attribute: OrderedSet(Property) = trigger->asSequence()->first().event.oclAsType(SignalEvent).signal.allAttributes() in
	 * }}}
	 * {{{
	 * 	attribute->size()>0 and result->size() = attribute->size() and
	 * }}}
	 * {{{
	 * 	Sequence{1..result->size()}->forAll(i | 
	 * }}}
	 * {{{
	 * 		result->at(i).type = attribute->at(i).type and 
	 * }}}
	 * {{{
	 * 		result->at(i).isOrdered = attribute->at(i).isOrdered and
	 * }}}
	 * {{{
	 * 		result->at(i).includesMultiplicity(attribute->at(i)))
	 * }}}
	 */
	def validate_unmarshall_signal_events: Boolean = {
		// Start of user code for "unmarshall_signal_events"
    !isUnmarshall ||
      (self match {
        case _: UMLAcceptCallAction[Uml]  => true
        case _: UMLAcceptEventAction[Uml] => trigger.toList match {
          case (t: UMLTrigger[Uml]) :: Nil => t.event match {
            case Some(sigEv: UMLSignalEvent[Uml]) =>
              sigEv.signal match {
                case Some(sig) => (result, sig.allAttributes)
                                  .zipped
                                  .forall {
                                            (r, a) =>
                                              r._type == a._type &&
                                                r.isOrdered == a.isOrdered &&
                                                r.includesMultiplicity(Some(a))
                                          }
                case None      => false
              }
            case _                                => false
          }
          case _                           => false
        }
        case _                            => true
      })
    // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLAcceptEventActionOps
