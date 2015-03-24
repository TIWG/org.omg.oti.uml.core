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
 * An AcceptEventAction is an Action that waits for the occurrence of one or more specific Events.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLAcceptEventActionOps[Uml <: UML] { self: UMLAcceptEventAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Triggers specifying the Events of which the AcceptEventAction waits for occurrences.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLTrigger.trigger_acceptEventAction
	 */
	def trigger: Set[UMLTrigger[Uml]] = ownedElement.selectByKindOf { case x: UMLTrigger[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * If isUnmarshall=false and all the triggers are for SignalEvents, then the type of the single result OutputPin must either be null or all the signals must conform to it.
	 * <!-- end-model-doc -->
	 *
	 * @body not isUnmarshall implies 
	 * 	result->isEmpty() or
	 * 	let type: Type = result->first().type in
	 * 	type=null or 
	 * 		(trigger->forAll(event.oclIsKindOf(SignalEvent)) and 
	 * 		 trigger.event.oclAsType(SignalEvent).signal->forAll(s | s.conformsTo(type)))
	 */
	def validate_conforming_type: Boolean  = {
		// Start of user code for "conforming_type"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * AcceptEventActions may have no input pins.
	 * <!-- end-model-doc -->
	 *
	 * @body input->size() = 0
	 */
	def validate_no_input_pins: Boolean  = {
		// Start of user code for "no_input_pins"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * There are no OutputPins if the trigger events are only ChangeEvents and/or CallEvents when this action is an instance of AcceptEventAction and not an instance of a descendant of AcceptEventAction (such as AcceptCallAction).
	 * <!-- end-model-doc -->
	 *
	 * @body (self.oclIsTypeOf(AcceptEventAction) and
	 *    (trigger->forAll(event.oclIsKindOf(ChangeEvent) or  
	 *                              event.oclIsKindOf(CallEvent))))
	 * implies output->size() = 0
	 */
	def validate_no_output_pins: Boolean  = {
		// Start of user code for "no_output_pins"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If isUnmarshall=false and any of the triggers are for SignalEvents or TimeEvents, there must be exactly one result OutputPin with multiplicity 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body not isUnmarshall and trigger->exists(event.oclIsKindOf(SignalEvent) or event.oclIsKindOf(TimeEvent)) implies 
	 * 	output->size() = 1 and output->first().is(1,1)
	 */
	def validate_one_output_pin: Boolean  = {
		// Start of user code for "one_output_pin"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If isUnmarshall is true (and this is not an AcceptCallAction), there must be exactly one trigger, which is for a SignalEvent. The number of result output pins must be the same as the number of attributes of the signal. The type and ordering of each result output pin must be the same as the corresponding attribute of the signal. The multiplicity of each result output pin must be compatible with the multiplicity of the corresponding attribute.
	 * <!-- end-model-doc -->
	 *
	 * @body isUnmarshall and self.oclIsTypeOf(AcceptEventAction) implies
	 * 	trigger->size()=1 and
	 * 	trigger->asSequence()->first().event.oclIsKindOf(SignalEvent) and
	 * 	let attribute: OrderedSet(Property) = trigger->asSequence()->first().event.oclAsType(SignalEvent).signal.allAttributes() in
	 * 	attribute->size()>0 and result->size() = attribute->size() and
	 * 	Sequence{1..result->size()}->forAll(i | 
	 * 		result->at(i).type = attribute->at(i).type and 
	 * 		result->at(i).isOrdered = attribute->at(i).isOrdered and
	 * 		result->at(i).includesMultiplicity(attribute->at(i)))
	 */
	def validate_unmarshall_signal_events: Boolean  = {
		// Start of user code for "unmarshall_signal_events"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLAcceptEventAction
