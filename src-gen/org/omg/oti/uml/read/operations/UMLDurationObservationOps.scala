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
  * A DurationObservation is a reference to a duration during an execution. It points out the NamedElement(s) in the model to observe and whether the observations are when this NamedElement is entered or when it is exited.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDurationObservationOps[Uml <: UML] { self: UMLDurationObservation[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The multiplicity of firstEvent must be 2 if the multiplicity of event is 2. Otherwise the multiplicity of firstEvent is 0.
    *
    * <!-- Start of user code doc for validate_first_event_multiplicity -->
    * <!-- End of user code doc for validate_first_event_multiplicity -->
    *
    * {{{
    * OCL Body if (event->size() = 2)
    *   then (firstEvent->size() = 2) else (firstEvent->size() = 0)
    * endif
    * }}}
    */
  def validate_first_event_multiplicity: Boolean = {
    // Start of user code for "first_event_multiplicity"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLDurationObservationOps
