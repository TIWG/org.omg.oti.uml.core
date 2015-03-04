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
 * A Connector specifies links that enables communication between two or more instances. In contrast to Associations, which specify links between any instance of the associated Classifiers, Connectors specify links between instances playing the connected parts only.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLConnectorOps[Uml <: UML] { self: UMLConnector[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Indicates the kind of Connector. This is derived: a Connector with one or more ends connected to a Port which is not on a Part and which is not a behavior port is a delegation; otherwise it is an assembly.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (if end->exists(
	 * 		role.oclIsKindOf(Port) 
	 * 		and partWithPort->isEmpty()
	 * 		and not role.oclAsType(Port).isBehavior)
	 * then ConnectorKind::delegation 
	 * else ConnectorKind::assembly 
	 * endif)
	 */
	def kind: UMLConnectorKind.Value = {
	    // Start of user code for "kind"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A Connector may be redefined when its containing Classifier is specialized. The redefining Connector may have a type that specializes the type of the redefined Connector. The types of the ConnectorEnds of the redefining Connector may specialize the types of the ConnectorEnds of the redefined Connector. The properties of the ConnectorEnds of the redefining Connector may be replaced.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector.redefinedConnector_connector
	 */
	def redefinedConnector: Set[UMLConnector[Uml]] = redefinedElement.selectByKindOf { case x: UMLConnector[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredClassifier.ownedConnector
	 */
	def ownedConnector_structuredClassifier: Option[UMLStructuredClassifier[Uml]] = featuringClassifier.selectByKindOf { case x: UMLStructuredClassifier[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector.redefinedConnector
	 */
	def redefinedConnector_connector: Set[UMLConnector[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLConnector[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The ConnectableElements attached as roles to each ConnectorEnd owned by a Connector must be owned or inherited roles of the Classifier that owned the Connector, or they must be Ports of such roles.
	 * <!-- end-model-doc -->
	 *
	 * @body structuredClassifier <> null
	 * and
	 *   end->forAll( e | structuredClassifier.allRoles()->includes(e.role)
	 * or
	 *   e.role.oclIsKindOf(Port) and structuredClassifier.allRoles()->includes(e.partWithPort))
	 */
	def validate_roles: Boolean  = {
    	// Start of user code for "roles"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The types of the ConnectableElements that the ends of a Connector are attached to must conform to the types of the ends of the Association that types the Connector, if any.
	 * <!-- end-model-doc -->
	 *
	 * @body type<>null implies 
	 *   let noOfEnds : Integer = end->size() in 
	 *   (type.memberEnd->size() = noOfEnds) and Sequence{1..noOfEnds}->forAll(i | end->at(i).role.type.conformsTo(type.memberEnd->at(i).type))
	 */
	def validate_types: Boolean  = {
    	// Start of user code for "types"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLConnector
