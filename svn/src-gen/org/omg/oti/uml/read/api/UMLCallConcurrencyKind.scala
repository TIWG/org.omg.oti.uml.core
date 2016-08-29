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
  * CallConcurrencyKind is an Enumeration used to specify the semantics of concurrent calls to a BehavioralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLCallConcurrencyKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLCallConcurrencyKind = Value

  /**
    * Multiple invocations of a BehavioralFeature that overlap in time may occur to one instance and all of them may proceed concurrently.
    *
    * <!-- Start of user code doc for concurrent -->
    * <!-- End of user code doc for concurrent -->
    */
  val concurrent = Value

  /**
    * Multiple invocations of a BehavioralFeature that overlap in time may occur to one instance, but only one is allowed to commence. The others are blocked until the performance of the currently executing BehavioralFeature is complete. It is the responsibility of the system designer to ensure that deadlocks do not occur due to simultaneous blocking.
    *
    * <!-- Start of user code doc for guarded -->
    * <!-- End of user code doc for guarded -->
    */
  val guarded = Value

  /**
    * No concurrency management mechanism is associated with the BehavioralFeature and, therefore, concurrency conflicts may occur. Instances that invoke a BehavioralFeature need to coordinate so that only one invocation to a target on any BehavioralFeature occurs at once.
    *
    * <!-- Start of user code doc for sequential -->
    * <!-- End of user code doc for sequential -->
    */
  val sequential = Value
}
