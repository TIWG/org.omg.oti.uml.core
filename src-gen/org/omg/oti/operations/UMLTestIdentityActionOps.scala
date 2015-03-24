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
 * A TestIdentityAction is an Action that tests if two values are identical objects.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTestIdentityActionOps[Uml <: UML] { self: UMLTestIdentityAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPin whose Boolean value indicates whether the two input objects are identical.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_testIdentityAction
	 */
	def result: Option[UMLOutputPin[Uml]] = output headOption

	/**
	 * <!-- begin-model-doc -->
	 * The multiplicity of the InputPins is 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body first.is(1,1) and second.is(1,1)
	 */
	def validate_multiplicity: Boolean  = {
		// Start of user code for "multiplicity"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The InputPins have no type.
	 * <!-- end-model-doc -->
	 *
	 * @body first.type= null and second.type = null
	 */
	def validate_no_type: Boolean  = {
		// Start of user code for "no_type"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type of the result OutputPin is Boolean. 
	 * <!-- end-model-doc -->
	 *
	 * @body result.type=Boolean
	 */
	def validate_result_is_boolean: Boolean  = {
		// Start of user code for "result_is_boolean"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLTestIdentityAction
