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
// End of user code

/**
  * A LiteralNull specifies the lack of a value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralNullOps[Uml <: UML] { self: UMLLiteralNull[Uml] =>

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
    * The query isNull() returns true.
    *
    * <!-- Start of user code doc for isNull -->
    * <!-- End of user code doc for isNull -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (true)
    * }}}
    */
  override def isNull: Boolean = {
    // Start of user code for "isNull"
      true
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLLiteralNullOps
