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
import java.lang.Integer
// End of user code

/**
  * A LiteralInteger is a specification of an Integer value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralIntegerOps[Uml <: UML] { self: UMLLiteralInteger[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The query integerValue() gives the value.
    *
    * <!-- Start of user code doc for integerValue -->
    * <!-- End of user code doc for integerValue -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (value)
    * }}}
    */
  override def integerValue: Option[Integer] = {
    // Start of user code for "integerValue"
      Option.apply(value)
    // End of user code
  }

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

  // Start of user code for additional features
  override def stringValue: Option[String]  = Option.apply(value.toString)  
  // End of user code
} //UMLLiteralIntegerOps
