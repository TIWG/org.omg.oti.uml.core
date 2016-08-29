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
import java.lang.Integer
import org.omg.oti.uml.read.api._
import scala.{Boolean,Option}
import scala.Predef.String
// End of user code

/**
  * A LiteralUnlimitedNatural is a specification of an UnlimitedNatural number.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralUnlimitedNaturalOps[Uml <: UML] { self: UMLLiteralUnlimitedNatural[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The query isComputable() is redefined to be true.
    *
    * <!-- Start of user code doc for isComputable -->
    * <!-- End of user code doc for isComputable -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (true)
    * }}}
    */
  override def isComputable: Boolean = {
    // Start of user code for "isComputable"
      true
    // End of user code
  }

  /**
    * The query unlimitedValue() gives the value.
    *
    * <!-- Start of user code doc for unlimitedValue -->
    * <!-- End of user code doc for unlimitedValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (value)
    * }}}
    */
  override def unlimitedValue: Option[Integer] = {
    // Start of user code for "unlimitedValue"
      Option.apply(value)
    // End of user code
  }

  // Start of user code for additional features
  override def stringValue: Option[String] = {
    if (value.intValue() < 0)
      Option.apply("*")
    else
      Option.apply(value.toString)
  }
  // End of user code
} //UMLLiteralUnlimitedNaturalOps
