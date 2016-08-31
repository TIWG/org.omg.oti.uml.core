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
// End of user code

/**
  * An Actor specifies a role played by a user or any other system that interacts with the subject.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActorOps[Uml <: UML] { self: UMLActor[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * An Actor can only have Associations to UseCases, Components, and Classes. Furthermore these Associations must be binary.
    *
    * <!-- Start of user code doc for validate_associations -->
    * <!-- End of user code doc for validate_associations -->
    *
    * {{{
    * OCL Body Association.allInstances()->forAll( a |
    *   a.memberEnd->collect(type)->includes(self) implies
    *   (
    *     a.memberEnd->size() = 2 and
    *     let actorEnd : Property = a.memberEnd->any(type = self) in
    *       actorEnd.opposite.class.oclIsKindOf(UseCase) or
    *       ( actorEnd.opposite.class.oclIsKindOf(Class) and not
    *          actorEnd.opposite.class.oclIsKindOf(Behavior))
    *       )
    *   )
    * }}}
    */
  def validate_associations: Boolean = {
    // Start of user code for "associations"
    ???
    // End of user code
  }

  /**
    * An Actor must have a name.
    *
    * <!-- Start of user code doc for validate_must_have_name -->
    * <!-- End of user code doc for validate_must_have_name -->
    *
    * {{{
    * OCL Body name->notEmpty()
    * }}}
    */
  def validate_must_have_name: Boolean = {
    // Start of user code for "must_have_name"
    name.nonEmpty
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLActorOps
