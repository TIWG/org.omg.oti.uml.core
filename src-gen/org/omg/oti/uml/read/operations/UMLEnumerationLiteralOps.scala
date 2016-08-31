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
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable._
// End of user code

/**
  * An EnumerationLiteral is a user-defined data value for an Enumeration.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLEnumerationLiteralOps[Uml <: UML] { self: UMLEnumerationLiteral[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The classifier of this EnumerationLiteral derived to be equal to its Enumeration.
    *
    * <!-- Start of user code doc for classifier -->
    * <!-- End of user code doc for classifier -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLEnumeration.classifier_enumerationLiteral
    * {{{
    * OCL Body result = (enumeration)
    * }}}
    */
  override def classifier: Iterable[UMLEnumeration[Uml]] = {
    // Start of user code for "classifier"
    enumeration
    // End of user code
  }

  /**
    * The Enumeration that this EnumerationLiteral is a member of.
    *
    * <!-- Start of user code doc for enumeration -->
    * <!-- End of user code doc for enumeration -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLEnumeration.ownedLiteral
    */
  def enumeration: Option[UMLEnumeration[Uml]] = namespace.selectByKindOf { case x: UMLEnumeration[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLEnumerationLiteralOps
