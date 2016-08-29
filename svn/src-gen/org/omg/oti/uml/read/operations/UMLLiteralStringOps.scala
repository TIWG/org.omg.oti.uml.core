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
import scala.Predef.String
// End of user code

/**
  * A LiteralString is a specification of a String value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralStringOps[Uml <: UML] { self: UMLLiteralString[Uml] =>

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
    * The query stringValue() gives the value.
    *
    * <!-- Start of user code doc for stringValue -->
    * <!-- End of user code doc for stringValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (value)
    * }}}
    */
  override def stringValue: Option[String] = {
    // Start of user code for "stringValue"
      self.value
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLLiteralStringOps
