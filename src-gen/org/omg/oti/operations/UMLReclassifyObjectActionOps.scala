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
 * A ReclassifyObjectAction is an Action that changes the Classifiers that classify an object.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReclassifyObjectActionOps[Uml <: UML] { self: UMLReclassifyObjectAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin that holds the object to be reclassified.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.object_reclassifyObjectAction
	 */
	def _object: Option[UMLInputPin[Uml]] = input headOption

	/**
	 * <!-- begin-model-doc -->
	 * None of the newClassifiers may be abstract.
	 * <!-- end-model-doc -->
	 *
	 * @body not newClassifier->exists(isAbstract)
	 */
	def validate_classifier_not_abstract: Boolean  = {
    	// Start of user code for "classifier_not_abstract"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The object InputPin has no type.
	 * <!-- end-model-doc -->
	 *
	 * @body object.type = null
	 */
	def validate_input_pin: Boolean  = {
    	// Start of user code for "input_pin"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The multiplicity of the object InputPin is 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body object.is(1,1)
	 */
	def validate_multiplicity: Boolean  = {
    	// Start of user code for "multiplicity"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLReclassifyObjectAction
