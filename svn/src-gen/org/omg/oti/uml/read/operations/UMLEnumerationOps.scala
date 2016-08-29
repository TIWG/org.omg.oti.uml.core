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
import scala.collection.immutable.Set
// End of user code

/**
  * An Enumeration is a DataType whose values are enumerated in the model as EnumerationLiterals.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLEnumerationOps[Uml <: UML] { self: UMLEnumeration[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for classifier_enumerationLiteral -->
    * <!-- End of user code doc for classifier_enumerationLiteral -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLEnumerationLiteral.classifier
    */
  def classifier_enumerationLiteral: Set[UMLEnumerationLiteral[Uml]] = classifier_instanceSpecification.selectByKindOf { case x: UMLEnumerationLiteral[Uml] => x }

  /**
    * <!-- Start of user code doc for validate_immutable -->
    * <!-- End of user code doc for validate_immutable -->
    *
    * {{{
    * OCL Body ownedAttribute->forAll(isReadOnly)
    * }}}
    */
  def validate_immutable: Boolean = {
    // Start of user code for "immutable"
      ownedAttribute.forall(_.isReadOnly)
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLEnumerationOps
