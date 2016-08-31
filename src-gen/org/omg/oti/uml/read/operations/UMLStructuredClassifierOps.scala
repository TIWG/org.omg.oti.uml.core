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
import scala.collection.immutable.Set
// End of user code

/**
  * StructuredClassifiers may contain an internal structure of connected elements each of which plays a role in the overall Behavior modeled by the StructuredClassifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuredClassifierOps[Uml <: UML] { self: UMLStructuredClassifier[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The connectors owned by the StructuredClassifier.
    *
    * <!-- Start of user code doc for ownedConnector -->
    * <!-- End of user code doc for ownedConnector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.ownedConnector_structuredClassifier
    */
  def ownedConnector: Set[UMLConnector[Uml]] = feature.selectByKindOf { case x: UMLConnector[Uml] => x }

  /**
    * The Properties specifying instances that the StructuredClassifier owns by composition. This collection is derived, selecting those owned Properties where isComposite is true.
    *
    * <!-- Start of user code doc for part -->
    * <!-- End of user code doc for part -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.part_structuredClassifier
    * {{{
    * OCL Body result = (ownedAttribute->select(isComposite))
    * }}}
    */
  def part: Set[UMLProperty[Uml]] = {
    // Start of user code for "part"
      ownedAttribute.filter(_.isComposite).toSet
    // End of user code
  }

  /**
    * All features of type ConnectableElement, equivalent to all direct and inherited roles.
    *
    * <!-- Start of user code doc for allRoles -->
    * <!-- End of user code doc for allRoles -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (allFeatures()->select(oclIsKindOf(ConnectableElement))->collect(oclAsType(ConnectableElement))->asSet())
    * }}}
    */
  def allRoles: Set[UMLConnectableElement[Uml]] = {
    // Start of user code for "allRoles"
      allFeatures.selectByKindOf { case c: UMLConnectableElement[Uml] => c }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStructuredClassifierOps
