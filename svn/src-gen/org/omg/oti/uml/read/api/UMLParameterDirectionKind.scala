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
  * ParameterDirectionKind is an Enumeration that defines literals used to specify direction of parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLParameterDirectionKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLParameterDirectionKind = Value

  /**
    * Indicates that Parameter values are passed as return values back to the caller.
    *
    * <!-- Start of user code doc for _return -->
    * <!-- End of user code doc for _return -->
    */
  val _return = Value

  /**
    * Indicates that Parameter values are passed in by the caller. 
    *
    * <!-- Start of user code doc for in -->
    * <!-- End of user code doc for in -->
    */
  val in = Value

  /**
    * Indicates that Parameter values are passed in by the caller and (possibly different) values passed out to the caller.
    *
    * <!-- Start of user code doc for inout -->
    * <!-- End of user code doc for inout -->
    */
  val inout = Value

  /**
    * Indicates that Parameter values are passed out to the caller.
    *
    * <!-- Start of user code doc for out -->
    * <!-- End of user code doc for out -->
    */
  val out = Value
}
