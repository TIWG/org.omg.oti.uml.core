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
  * A communication path is an association between two deployment targets, through which they are able to exchange signals and messages.
  *
  * <!-- Start of user code documentation --> 
  * <!-- End of user code documentation -->
  */
trait UMLCommunicationPathOps[Uml <: UML] { self: UMLCommunicationPath[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The association ends of a CommunicationPath are typed by DeploymentTargets.
    *
    * <!-- Start of user code doc for validate_communication_path_ends -->
    * <!-- End of user code doc for validate_communication_path_ends -->
    *
    * {{{
    * OCL Body endType->forAll (oclIsKindOf(DeploymentTarget))
    * }}}
    */
  def validate_communication_path_ends: Boolean = {
    // Start of user code for "communication_path_ends"
      ???
      // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLCommunicationPathOps
