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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A relationship from an extending UseCase to an extended UseCase that specifies how and when the behavior defined in the extending UseCase can be inserted into the behavior defined in the extended UseCase.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtendOps[Uml <: UML] { self: UMLExtend[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * References the condition that must hold when the first ExtensionPoint is reached for the extension to take place. If no constraint is associated with the Extend relationship, the extension is unconditional.
    *
    * <!-- Start of user code doc for condition -->
    * <!-- End of user code doc for condition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.condition_extend
    */
  def condition: Option[UMLConstraint[Uml]] = ownedElement.selectByKindOf { case x: UMLConstraint[Uml] => x } headOption

  /**
    * The UseCase that is being extended.
    *
    * <!-- Start of user code doc for extendedCase -->
    * <!-- End of user code doc for extendedCase -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.extendedCase_extend
    */
  def extendedCase: Option[UMLUseCase[Uml]] = target.selectByKindOf { case x: UMLUseCase[Uml] => x } headOption

  /**
    * The UseCase that represents the extension and owns the Extend relationship.
    *
    * <!-- Start of user code doc for extension -->
    * <!-- End of user code doc for extension -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.extend
    */
  def extension: Option[UMLUseCase[Uml]] = namespace.selectByKindOf { case x: UMLUseCase[Uml] => x }

  /**
    * The ExtensionPoints referenced by the Extend relationship must belong to the UseCase that is being extended.
    *
    * <!-- Start of user code doc for validate_extension_points -->
    * <!-- End of user code doc for validate_extension_points -->
    *
    * {{{
    * OCL Body extensionLocation->forAll (xp | extendedCase.extensionPoint->includes(xp))
    * }}}
    */
  def validate_extension_points: Boolean = {
    // Start of user code for "extension_points"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLExtendOps
