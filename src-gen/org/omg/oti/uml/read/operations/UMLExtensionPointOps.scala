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
import scala.Option
import scala.Predef.???
// End of user code

/**
  * An ExtensionPoint identifies a point in the behavior of a UseCase where that behavior can be extended by the behavior of some other (extending) UseCase, as specified by an Extend relationship.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtensionPointOps[Uml <: UML] { self: UMLExtensionPoint[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The UseCase that owns this ExtensionPoint.
    *
    * <!-- Start of user code doc for useCase -->
    * <!-- End of user code doc for useCase -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.extensionPoint
    */
  def useCase: Option[UMLUseCase[Uml]] = namespace.selectByKindOf { case x: UMLUseCase[Uml] => x }

  /**
    * An ExtensionPoint must have a name.
    *
    * <!-- Start of user code doc for validate_must_have_name -->
    * <!-- End of user code doc for validate_must_have_name -->
    *
    * {{{
    * OCL Body name->notEmpty ()
    * }}}
    */
  def validate_must_have_name: Boolean = {
    // Start of user code for "must_have_name"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLExtensionPointOps
