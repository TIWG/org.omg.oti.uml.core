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
  * ExpansionKind is an enumeration type used to specify how an ExpansionRegion executes its contents.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLExpansionKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLExpansionKind = Value

  /**
    * The content of the ExpansionRegion is executed iteratively for the elements of the input collections, in the order of the input elements, if the collections are ordered.
    *
    * <!-- Start of user code doc for iterative -->
    * <!-- End of user code doc for iterative -->
    */
  val iterative = Value

  /**
    * The content of the ExpansionRegion is executed concurrently for the elements of the input collections.
    *
    * <!-- Start of user code doc for parallel -->
    * <!-- End of user code doc for parallel -->
    */
  val parallel = Value

  /**
    * A stream of input collection elements flows into a single execution of the content of the ExpansionRegion, in the order of the collection elements if the input collections are ordered.
    *
    * <!-- Start of user code doc for stream -->
    * <!-- End of user code doc for stream -->
    */
  val stream = Value
}
