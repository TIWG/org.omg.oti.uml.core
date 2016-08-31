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
import scala.collection.Iterable
// End of user code

/**
  * A DestroyLinkAction is a WriteLinkAction that destroys links (including link objects).
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDestroyLinkActionOps[Uml <: UML] { self: UMLDestroyLinkAction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The LinkEndData that the values of the Association ends for the links to be destroyed.
    *
    * <!-- Start of user code doc for endData -->
    * <!-- End of user code doc for endData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndDestructionData.endData_destroyLinkAction
    */
  override def endData: Iterable[UMLLinkEndDestructionData[Uml]] = ownedElement.selectByKindOf { case x: UMLLinkEndDestructionData[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLDestroyLinkActionOps
