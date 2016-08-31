/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A Port is a property of an EncapsulatedClassifier that specifies a distinct interaction point between that EncapsulatedClassifier and its environment or between the (behavior of the) EncapsulatedClassifier and its internal parts. Ports are connected to Properties of the EncapsulatedClassifier by Connectors through which requests can be made to invoke BehavioralFeatures. A Port may specify the services an EncapsulatedClassifier provides (offers) to its environment as well as the services that an EncapsulatedClassifier expects (requires) of its environment.  A Port may have an associated ProtocolStateMachine.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPortOps[Uml <: UML] { self: UMLPort[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The Interfaces specifying the set of Operations and Receptions that the EncapsulatedCclassifier offers to its environment via this Port, and which it will handle either directly or by forwarding it to a part of its internal structure. This association is derived according to the value of isConjugated. If isConjugated is false, provided is derived as the union of the sets of Interfaces realized by the type of the port and its supertypes, or directly from the type of the Port if the Port is typed by an Interface. If isConjugated is true, it is derived as the union of the sets of Interfaces used by the type of the Port and its supertypes.
    *
    * <!-- Start of user code doc for provided -->
    * <!-- End of user code doc for provided -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.provided_port
    * {{{
    * OCL Body result = (if isConjugated then basicRequired() else basicProvided() endif)
    * }}}
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
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.required_port
    * {{{
    * OCL Body result = (if isConjugated then basicProvided() else basicRequired() endif)
    * }}}
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
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (if type.oclIsKindOf(Interface) 
    * then type.oclAsType(Interface)->asSet() 
    * else type.oclAsType(Classifier).allRealizedInterfaces() 
    * endif)
    * }}}
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
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = ( type.oclAsType(Classifier).allUsedInterfaces() )
    * }}}
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
    * {{{
    * OCL Body type.oclIsKindOf(Interface) implies defaultValue->isEmpty()
    * }}}
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
    * {{{
    * OCL Body owner = encapsulatedClassifier
    * }}}
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
    * {{{
    * OCL Body aggregation = AggregationKind::composite
    * }}}
    */
  def validate_port_aggregation: Boolean = {
    // Start of user code for "port_aggregation"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLPortOps
