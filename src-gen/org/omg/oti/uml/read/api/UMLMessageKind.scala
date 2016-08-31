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

package org.omg.oti.uml.read.api

import scala.Enumeration

/**
  * This is an enumerated type that identifies the type of Message.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLMessageKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLMessageKind = Value

  /**
    * sendEvent and receiveEvent are present
    *
    * <!-- Start of user code doc for complete -->
    * <!-- End of user code doc for complete -->
    */
  val complete = Value

  /**
    * sendEvent absent and receiveEvent present
    *
    * <!-- Start of user code doc for found -->
    * <!-- End of user code doc for found -->
    */
  val found = Value

  /**
    * sendEvent present and receiveEvent absent
    *
    * <!-- Start of user code doc for lost -->
    * <!-- End of user code doc for lost -->
    */
  val lost = Value

  /**
    * sendEvent and receiveEvent absent (should not appear)
    *
    * <!-- Start of user code doc for unknown -->
    * <!-- End of user code doc for unknown -->
    */
  val unknown = Value
}
