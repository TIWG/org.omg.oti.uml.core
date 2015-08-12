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

import org.omg.oti.uml.read.api._

import scala.language.postfixOps
// End of user code

/**
 * ConnectableElement is an abstract metaclass representing a set of instances
 * that play roles of a StructuredClassifier. ConnectableElements may be joined by
 * attached Connectors and specify configurations of linked instances
 * to be created within an instance of the containing StructuredClassifier.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLConnectableElementOps[Uml <: UML] { self: UMLConnectableElement[Uml] =>

  import self.ops._

  /**
   * A set of ConnectorEnds that attach to this ConnectableElement.
   *
   * <!-- Start of user code doc for end -->
   * <!-- End of user code doc for end -->
   *
   * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLConnectorEnd.role
   * @body result = (ConnectorEnd.allInstances()->select(role = self))
   */
  def end: Set[UMLConnectorEnd[Uml]] = {
    // Start of user code for "end"
      ???
      // End of user code
  }

  /**
   * <!-- Start of user code doc for collaborationRole_collaboration -->
   * <!-- End of user code doc for collaborationRole_collaboration -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLCollaboration.collaborationRole
   */
  def collaborationRole_collaboration: Set[UMLCollaboration[Uml]] =
    role_structuredClassifier
    .selectByKindOf { case x: UMLCollaboration[Uml] => x }

  /**
   * <!-- Start of user code doc for role_structuredClassifier -->
   * <!-- End of user code doc for role_structuredClassifier -->
   *
   * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLStructuredClassifier.role
   */
  def role_structuredClassifier: Set[UMLStructuredClassifier[Uml]] =
    member_memberNamespace
    .selectByKindOf { case x: UMLStructuredClassifier[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLConnectableElementOps
