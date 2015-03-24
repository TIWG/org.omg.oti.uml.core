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
 * A SendSignalAction is an InvocationAction that creates a Signal instance and transmits it to the target object. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instance is sent out and cannot receive reply values.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLSendSignalActionOps[Uml <: UML] { self: UMLSendSignalAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The number and order of argument InputPins must be the same as the number and order of attributes of the signal.
	 * <!-- end-model-doc -->
	 *
	 * @body argument->size()=signal.allAttributes()->size()
	 */
	def validate_number_order: Boolean  = {
		// Start of user code for "number_order"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type, ordering, and multiplicity of an argument InputPin must be the same as the corresponding attribute of the signal.
	 * <!-- end-model-doc -->
	 *
	 * @body let attribute: OrderedSet(Property) = signal.allAttributes() in
	 * Sequence{1..argument->size()}->forAll(i | 
	 * 	argument->at(i).type.conformsTo(attribute->at(i).type) and 
	 * 	argument->at(i).isOrdered = attribute->at(i).isOrdered and
	 * 	argument->at(i).compatibleWith(attribute->at(i)))
	 */
	def validate_type_ordering_multiplicity: Boolean  = {
		// Start of user code for "type_ordering_multiplicity"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If onPort is not empty, the Port given by onPort must be an owned or inherited feature of the type of the target InputPin.
	 * <!-- end-model-doc -->
	 *
	 * @body not onPort->isEmpty() implies target.type.oclAsType(Classifier).allFeatures()->includes(onPort)
	 */
	def validate_type_target_pin: Boolean  = {
		// Start of user code for "type_target_pin"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLSendSignalAction
