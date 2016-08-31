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
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * ConnectableElement is an abstract metaclass representing a set of instances that play roles of a StructuredClassifier. ConnectableElements may be joined by attached Connectors and specify configurations of linked instances to be created within an instance of the containing StructuredClassifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectableElementOps[Uml <: UML] { self: UMLConnectableElement[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A set of ConnectorEnds that attach to this ConnectableElement.
    *
    * <!-- Start of user code doc for end -->
    * <!-- End of user code doc for end -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectorEnd.role
    * {{{
    * OCL Body result = (ConnectorEnd.allInstances()->select(role = self))
    * }}}
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
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaboration.collaborationRole
    */
  def collaborationRole_collaboration: Set[UMLCollaboration[Uml]] = role_structuredClassifier.selectByKindOf { case x: UMLCollaboration[Uml] => x }

  /**
    * <!-- Start of user code doc for role_structuredClassifier -->
    * <!-- End of user code doc for role_structuredClassifier -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredClassifier.role
    */
  def role_structuredClassifier: Set[UMLStructuredClassifier[Uml]] = member_memberNamespace.selectByKindOf { case x: UMLStructuredClassifier[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLConnectableElementOps
