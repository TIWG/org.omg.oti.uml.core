/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * A CollaborationUse is used to specify the application of a pattern specified by a Collaboration to a specific situation.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLCollaborationUseOps[Uml <: UML] { self: UMLCollaborationUse[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * A mapping between features of the Collaboration and features of the owning Classifier. This mapping indicates which ConnectableElement of the Classifier plays which role(s) in the Collaboration. A ConnectableElement may be bound to multiple roles in the same CollaborationUse (that is, it may play multiple roles).
	 *
	 * <!-- Start of user code doc for roleBinding -->
   * <!-- End of user code doc for roleBinding -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDependency.roleBinding_collaborationUse
	 */
	def roleBinding: Set[UMLDependency[Uml]] = ownedElement.selectByKindOf { case x: UMLDependency[Uml] => x }

	/**
	 * <!-- Start of user code doc for collaborationUse_classifier -->
   * <!-- End of user code doc for collaborationUse_classifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.collaborationUse
	 */
	def collaborationUse_classifier: Option[UMLClassifier[Uml]] = owner.selectByKindOf { case x: UMLClassifier[Uml] => x }

	/**
	 * <!-- Start of user code doc for representation_classifier -->
   * <!-- End of user code doc for representation_classifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.representation
	 */
	def representation_classifier: Option[UMLClassifier[Uml]] = collaborationUse_classifier

	/**
	 * All the client elements of a roleBinding are in one Classifier and all supplier elements of a roleBinding are in one Collaboration.
	 *
	 * <!-- Start of user code doc for validate_client_elements -->
   * <!-- End of user code doc for validate_client_elements -->
	 *
	 * {{{
	 * OCL Body roleBinding->collect(client)->forAll(ne1, ne2 |
	 *   ne1.oclIsKindOf(ConnectableElement) and ne2.oclIsKindOf(ConnectableElement) and
	 *     let ce1 : ConnectableElement = ne1.oclAsType(ConnectableElement), ce2 : ConnectableElement = ne2.oclAsType(ConnectableElement) in
	 *       ce1.structuredClassifier = ce2.structuredClassifier)
	 * and
	 *   roleBinding->collect(supplier)->forAll(ne1, ne2 |
	 *   ne1.oclIsKindOf(ConnectableElement) and ne2.oclIsKindOf(ConnectableElement) and
	 *     let ce1 : ConnectableElement = ne1.oclAsType(ConnectableElement), ce2 : ConnectableElement = ne2.oclAsType(ConnectableElement) in
	 *       ce1.collaboration = ce2.collaboration)
	 * }}}
	 */
	def validate_client_elements: Boolean = {
		// Start of user code for "client_elements"
      ???
      // End of user code
	}

	/**
	 * Connectors in a Collaboration typing a CollaborationUse must have corresponding Connectors between elements bound in the context Classifier, and these corresponding Connectors must have the same or more general type than the Collaboration Connectors.
	 *
	 * <!-- Start of user code doc for validate_connectors -->
   * <!-- End of user code doc for validate_connectors -->
	 *
	 * {{{
	 * OCL Body type.ownedConnector->forAll(connector |
	 *   let rolesConnectedInCollab : Set(ConnectableElement) = connector.end.role->asSet(),
	 *         relevantBindings : Set(Dependency) = roleBinding->select(rb | rb.supplier->intersection(rolesConnectedInCollab)->notEmpty()),
	 *         boundRoles : Set(ConnectableElement) = relevantBindings->collect(client.oclAsType(ConnectableElement))->asSet(),
	 *         contextClassifier : StructuredClassifier = boundRoles->any(true).structuredClassifier->any(true) in
	 *           contextClassifier.ownedConnector->exists( correspondingConnector | 
	 *               correspondingConnector.end.role->forAll( role | boundRoles->includes(role) )
	 *               and (connector.type->notEmpty() and correspondingConnector.type->notEmpty()) implies connector.type->forAll(conformsTo(correspondingConnector.type)) )
	 * )
	 * }}}
	 */
	def validate_connectors: Boolean = {
		// Start of user code for "connectors"
      ???
      // End of user code
	}

	/**
	 * Every collaborationRole in the Collaboration is bound within the CollaborationUse.
	 *
	 * <!-- Start of user code doc for validate_every_role -->
   * <!-- End of user code doc for validate_every_role -->
	 *
	 * {{{
	 * OCL Body type.collaborationRole->forAll(role | roleBinding->exists(rb | rb.supplier->includes(role)))
	 * }}}
	 */
	def validate_every_role: Boolean = {
		// Start of user code for "every_role"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLCollaborationUseOps
