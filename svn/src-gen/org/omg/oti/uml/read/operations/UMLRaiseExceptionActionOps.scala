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
  * A RaiseExceptionAction is an Action that causes an exception to occur. The input value becomes the exception object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRaiseExceptionActionOps[Uml <: UML] { self: UMLRaiseExceptionAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * An InputPin whose value becomes the exception object.
    *
    * <!-- Start of user code doc for exception -->
    * <!-- End of user code doc for exception -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.exception_raiseExceptionAction
    */
  def exception: Option[UMLInputPin[Uml]] = input headOption

  // Start of user code for additional features
  // End of user code
} //UMLRaiseExceptionActionOps
