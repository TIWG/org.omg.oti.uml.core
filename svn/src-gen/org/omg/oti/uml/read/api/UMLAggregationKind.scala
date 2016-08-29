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
  * AggregationKind is an Enumeration for specifying the kind of aggregation of a Property.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLAggregationKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLAggregationKind = Value

  /**
    * Indicates that the Property is aggregated compositely, i.e., the composite object has responsibility for the existence and storage of the composed objects (parts).
    *
    * <!-- Start of user code doc for composite -->
    * <!-- End of user code doc for composite -->
    */
  val composite = Value

  /**
    * Indicates that the Property has no aggregation.
    *
    * <!-- Start of user code doc for none -->
    * <!-- End of user code doc for none -->
    */
  val none = Value

  /**
    * Indicates that the Property has shared aggregation.
    *
    * <!-- Start of user code doc for shared -->
    * <!-- End of user code doc for shared -->
    */
  val shared = Value
}
