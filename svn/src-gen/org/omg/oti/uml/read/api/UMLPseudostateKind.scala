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
  * PseudostateKind is an Enumeration type that is used to differentiate various kinds of Pseudostates.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLPseudostateKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLPseudostateKind = Value

  /**
    * 
    *
    * <!-- Start of user code doc for choice -->
    * <!-- End of user code doc for choice -->
    */
  val choice = Value

  /**
    * 
    *
    * <!-- Start of user code doc for deepHistory -->
    * <!-- End of user code doc for deepHistory -->
    */
  val deepHistory = Value

  /**
    * 
    *
    * <!-- Start of user code doc for entryPoint -->
    * <!-- End of user code doc for entryPoint -->
    */
  val entryPoint = Value

  /**
    * 
    *
    * <!-- Start of user code doc for exitPoint -->
    * <!-- End of user code doc for exitPoint -->
    */
  val exitPoint = Value

  /**
    * 
    *
    * <!-- Start of user code doc for fork -->
    * <!-- End of user code doc for fork -->
    */
  val fork = Value

  /**
    * 
    *
    * <!-- Start of user code doc for initial -->
    * <!-- End of user code doc for initial -->
    */
  val initial = Value

  /**
    * 
    *
    * <!-- Start of user code doc for join -->
    * <!-- End of user code doc for join -->
    */
  val join = Value

  /**
    * 
    *
    * <!-- Start of user code doc for junction -->
    * <!-- End of user code doc for junction -->
    */
  val junction = Value

  /**
    * 
    *
    * <!-- Start of user code doc for shallowHistory -->
    * <!-- End of user code doc for shallowHistory -->
    */
  val shallowHistory = Value

  /**
    * 
    *
    * <!-- Start of user code doc for terminate -->
    * <!-- End of user code doc for terminate -->
    */
  val terminate = Value
}
