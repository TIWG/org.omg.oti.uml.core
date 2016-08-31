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
import scala.Int
import scala.Option

// End of user code

/**
  * A Comment is a textual annotation that can be attached to a set of Elements.
  *
  * <!-- Start of user code documentation --> 
  * <!-- End of user code documentation -->
  */
trait UMLCommentOps[Uml <: UML] { self: UMLComment[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * <!-- Start of user code doc for ownedComment_owningElement -->
    * <!-- End of user code doc for ownedComment_owningElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.ownedComment
    */
  def ownedComment_owningElement: Option[UMLElement[Uml]] = owner

  // Start of user code for additional features

  def getCommentOwnerIndex: Int


  // End of user code
} //UMLCommentOps
