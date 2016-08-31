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
import scala.collection.Iterable
// End of user code

/**
  * A CreateLinkAction is a WriteLinkAction for creating links.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCreateLinkActionOps[Uml <: UML] { self: UMLCreateLinkAction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The LinkEndData that specifies the values to be placed on the Association ends for the new link.
    *
    * <!-- Start of user code doc for endData -->
    * <!-- End of user code doc for endData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndCreationData.endData_createLinkAction
    */
  override def endData: Iterable[UMLLinkEndCreationData[Uml]] = ownedElement.selectByKindOf { case x: UMLLinkEndCreationData[Uml] => x }

  /**
    * The Association cannot be an abstract Classifier.
    *
    * <!-- Start of user code doc for validate_association_not_abstract -->
    * <!-- End of user code doc for validate_association_not_abstract -->
    *
    * {{{
    * OCL Body not self.association().isAbstract
    * }}}
    */
  def validate_association_not_abstract: Boolean = {
    // Start of user code for "association_not_abstract"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLCreateLinkActionOps
