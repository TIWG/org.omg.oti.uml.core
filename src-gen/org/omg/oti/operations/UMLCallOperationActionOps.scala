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
 * A CallOperationAction is a CallAction that transmits an Operation call request to the target object, where it may cause the invocation of associated Behavior. The argument values of the CallOperationAction are passed on the input Parameters of the Operation. If call is synchronous, the execution of the CallOperationAction waits until the execution of the invoked Operation completes and the values of output Parameters of the Operation are placed on the result OutputPins. If the call is asynchronous, the CallOperationAction completes immediately and no results values can be provided.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLCallOperationActionOps[Uml <: UML] { self: UMLCallOperationAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Return the in and inout ownedParameters of the Operation being called.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (operation.inputParameters())
	 */
	override def inputParameters: Seq[UMLParameter[Uml]]  = {
		// Start of user code for "inputParameters"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Return the inout, out and return ownedParameters of the Operation being called.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (operation.outputParameters())
	 */
	override def outputParameters: Seq[UMLParameter[Uml]]  = {
		// Start of user code for "outputParameters"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If onPort has no value, the operation must be an owned or inherited feature of the type of the target InputPin, otherwise the Port given by onPort must be an owned or inherited feature of the type of the target InputPin, and the Port must have a required or provided Interface with the operation as an owned or inherited feature.
	 * <!-- end-model-doc -->
	 *
	 * @body if onPort=null then  target.type.oclAsType(Classifier).allFeatures()->includes(operation)
	 * else target.type.oclAsType(Classifier).allFeatures()->includes(onPort) and onPort.provided->union(onPort.required).allFeatures()->includes(operation)
	 * endif
	 */
	def validate_type_target_pin: Boolean  = {
		// Start of user code for "type_target_pin"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLCallOperationAction
