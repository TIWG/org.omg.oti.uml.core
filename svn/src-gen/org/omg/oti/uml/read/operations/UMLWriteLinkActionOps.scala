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
import scala.Predef.???
// End of user code

/**
  * WriteLinkAction is an abstract class for LinkActions that create and destroy links.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLWriteLinkActionOps[Uml <: UML] { self: UMLWriteLinkAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The visibility of at least one end must allow access from the context Classifier of the WriteLinkAction.
    *
    * <!-- Start of user code doc for validate_allow_access -->
    * <!-- End of user code doc for validate_allow_access -->
    *
    * {{{
    * OCL Body endData.end->exists(end |
    *   end.type=_'context' or
    *   end.visibility=VisibilityKind::public or 
    *   end.visibility=VisibilityKind::protected and
    *   endData.end->exists(other | 
    *     other<>end and _'context'.conformsTo(other.type.oclAsType(Classifier))))
    * }}}
    */
  def validate_allow_access: Boolean = {
    // Start of user code for "allow_access"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLWriteLinkActionOps
