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
  * ObjectNodeOrderingKind is an enumeration indicating queuing order for offering the tokens held by an ObjectNode.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLObjectNodeOrderingKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLObjectNodeOrderingKind = Value

  /**
    * Indicates that tokens are queued in a first in, first out manner.
    *
    * <!-- Start of user code doc for FIFO -->
    * <!-- End of user code doc for FIFO -->
    */
  val FIFO = Value

  /**
    * Indicates that tokens are queued in a last in, first out manner.
    *
    * <!-- Start of user code doc for LIFO -->
    * <!-- End of user code doc for LIFO -->
    */
  val LIFO = Value

  /**
    * Indicates that tokens are ordered.
    *
    * <!-- Start of user code doc for ordered -->
    * <!-- End of user code doc for ordered -->
    */
  val ordered = Value

  /**
    * Indicates that tokens are unordered.
    *
    * <!-- Start of user code doc for unordered -->
    * <!-- End of user code doc for unordered -->
    */
  val unordered = Value
}
