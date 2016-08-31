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
  * An EncapsulatedClassifier may own Ports to specify typed interaction points.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLEncapsulatedClassifierOps[Uml <: UML] { self: UMLEncapsulatedClassifier[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Ports owned by the EncapsulatedClassifier.
    *
    * <!-- Start of user code doc for ownedPort -->
    * <!-- End of user code doc for ownedPort -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPort.ownedPort_encapsulatedClassifier
    * {{{
    * OCL Body result = (ownedAttribute->select(oclIsKindOf(Port))->collect(oclAsType(Port))->asOrderedSet())
    * }}}
    */
  def ownedPort: Set[UMLPort[Uml]] = {
    // Start of user code for "ownedPort"
    ownedAttribute
    .selectByKindOf { case x: UMLPort[Uml] => x }.toSet[UMLPort[Uml]]
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLEncapsulatedClassifierOps
