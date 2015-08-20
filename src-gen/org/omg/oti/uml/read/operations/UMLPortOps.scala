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

import org.omg.oti.uml.read.api.{UML, UMLPort, UMLInterface}

import scala.language.postfixOps
// End of user code

/**
 * A Port is a property of an EncapsulatedClassifier that specifies a distinct interaction point between that EncapsulatedClassifier and its environment or between the (behavior of the) EncapsulatedClassifier and its internal parts. Ports are connected to Properties of the EncapsulatedClassifier by Connectors through which requests can be made to invoke BehavioralFeatures. A Port may specify the services an EncapsulatedClassifier provides (offers) to its environment as well as the services that an EncapsulatedClassifier expects (requires) of its environment.  A Port may have an associated ProtocolStateMachine.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLPortOps[Uml <: UML] { self: UMLPort[Uml] =>

	import self.ops._

	/**
	 * The Interfaces specifying the set of Operations and Receptions that the EncapsulatedCclassifier offers to its environment via this Port, and which it will handle either directly or by forwarding it to a part of its internal structure. This association is derived according to the value of isConjugated. If isConjugated is false, provided is derived as the union of the sets of Interfaces realized by the type of the port and its supertypes, or directly from the type of the Port if the Port is typed by an Interface. If isConjugated is true, it is derived as the union of the sets of Interfaces used by the type of the Port and its supertypes.
	 *
	 * <!-- Start of user code doc for provided -->
   * <!-- End of user code doc for provided -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLInterface.provided_port
	 * @body result = (if isConjugated then basicRequired() else basicProvided() endif)
	 */
	def provided: Set[UMLInterface[Uml]] = {
		// Start of user code for "provided"
      ???
      // End of user code
	}

	/**
	 * The Interfaces specifying the set of Operations and Receptions that the EncapsulatedCassifier expects its environment to handle via this port. This association is derived according to the value of isConjugated. If isConjugated is false, required is derived as the union of the sets of Interfaces used by the type of the Port and its supertypes. If isConjugated is true, it is derived as the union of the sets of Interfaces realized by the type of the Port and its supertypes, or directly from the type of the Port if the Port is typed by an Interface.
	 *
	 * <!-- Start of user code doc for required -->
   * <!-- End of user code doc for required -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.uml.read.api.UMLInterface.required_port
	 * @body result = (if isConjugated then basicProvided() else basicRequired() endif)
	 */
	def required: Set[UMLInterface[Uml]] = {
		// Start of user code for "required"
      ???
      // End of user code
	}

	/**
	 * The union of the sets of Interfaces realized by the type of the Port and its supertypes, or directly the type of the Port if the Port is typed by an Interface.
	 *
	 * <!-- Start of user code doc for basicProvided -->
   * <!-- End of user code doc for basicProvided -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (if type.oclIsKindOf(Interface) 
	 * then type.oclAsType(Interface)->asSet() 
	 * else type.oclAsType(Classifier).allRealizedInterfaces() 
	 * endif)
	 */
	def basicProvided: Set[UMLInterface[Uml]] = {
		// Start of user code for "basicProvided"
      ???
      // End of user code
	}

	/**
	 * The union of the sets of Interfaces used by the type of the Port and its supertypes.
	 *
	 * <!-- Start of user code doc for basicRequired -->
   * <!-- End of user code doc for basicRequired -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = ( type.oclAsType(Classifier).allUsedInterfaces() )
	 */
	def basicRequired: Set[UMLInterface[Uml]] = {
		// Start of user code for "basicRequired"
      ???
      // End of user code
	}

	/**
	 * A defaultValue for port cannot be specified when the type of the Port is an Interface.
	 *
	 * <!-- Start of user code doc for validate_default_value -->
   * <!-- End of user code doc for validate_default_value -->
	 *
	 * @body type.oclIsKindOf(Interface) implies defaultValue->isEmpty()
	 */
	def validate_default_value: Boolean = {
		// Start of user code for "default_value"
      ???
      // End of user code
	}

	/**
	 * All Ports are owned by an EncapsulatedClassifier.
	 *
	 * <!-- Start of user code doc for validate_encapsulated_owner -->
   * <!-- End of user code doc for validate_encapsulated_owner -->
	 *
	 * @body owner = encapsulatedClassifier
	 */
	def validate_encapsulated_owner: Boolean = {
		// Start of user code for "encapsulated_owner"
      ???
      // End of user code
	}

	/**
	 * Port.aggregation must be composite.
	 *
	 * <!-- Start of user code doc for validate_port_aggregation -->
   * <!-- End of user code doc for validate_port_aggregation -->
	 *
	 * @body aggregation = AggregationKind::composite
	 */
	def validate_port_aggregation: Boolean = {
		// Start of user code for "port_aggregation"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLPortOps
