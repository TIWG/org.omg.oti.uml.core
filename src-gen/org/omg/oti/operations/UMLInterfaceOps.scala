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
 * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInterfaceOps[Uml <: UML] { self: UMLInterface[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Receptions that objects providing this Interface are willing to accept.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReception.ownedReception_interface
	 */
	def ownedReception: Set[UMLReception[Uml]] = feature.selectByKindOf { case x: UMLReception[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * References a ProtocolStateMachine specifying the legal sequences of the invocation of the BehavioralFeatures described in the Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProtocolStateMachine.protocol_interface
	 */
	def protocol: Option[UMLProtocolStateMachine[Uml]] = ownedMember.selectByKindOf { case x: UMLProtocolStateMachine[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * References all the Interfaces redefined by this Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.redefinedInterface_interface
	 */
	def redefinedInterface: Set[UMLInterface[Uml]] = redefinedClassifier.selectByKindOf { case x: UMLInterface[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterfaceRealization.contract
	 */
	def contract_interfaceRealization: Set[UMLInterfaceRealization[Uml]] = supplier_supplierDependency.selectByKindOf { case x: UMLInterfaceRealization[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponent.provided
	 */
	def provided_component: Set[UMLComponent[Uml]] = {
		// Start of user code for "component"
		???
		// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.provided
	 */
	def provided_port: Set[UMLPort[Uml]] = {
		// Start of user code for "port"
		???
		// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.redefinedInterface
	 */
	def redefinedInterface_interface: Set[UMLInterface[Uml]] = redefinedClassifier_classifier.selectByKindOf { case x: UMLInterface[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponent.required
	 */
	def required_component: Set[UMLComponent[Uml]] = {
		// Start of user code for "component"
		???
		// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.required
	 */
	def required_port: Set[UMLPort[Uml]] = {
		// Start of user code for "port"
		???
		// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The visibility of all Features owned by an Interface must be public.
	 * <!-- end-model-doc -->
	 *
	 * @body feature->forAll(visibility = VisibilityKind::public)
	 */
	def validate_visibility: Boolean  = {
		// Start of user code for "visibility"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLInterface
