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
import scala.Option
// End of user code

/**
  * An Include relationship specifies that a UseCase contains the behavior defined in another UseCase.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLIncludeOps[Uml <: UML] { self: UMLInclude[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The UseCase that is to be included.
    *
    * <!-- Start of user code doc for addition -->
    * <!-- End of user code doc for addition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.addition_include
    */
  def addition: Option[UMLUseCase[Uml]] = target.selectByKindOf { case x: UMLUseCase[Uml] => x } headOption

  /**
    * The UseCase which includes the addition and owns the Include relationship.
    *
    * <!-- Start of user code doc for includingCase -->
    * <!-- End of user code doc for includingCase -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.include
    */
  def includingCase: Option[UMLUseCase[Uml]] = namespace.selectByKindOf { case x: UMLUseCase[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLIncludeOps
