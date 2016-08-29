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
  * ParameterEffectKind is an Enumeration that indicates the effect of a Behavior on values passed in or out of its parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLParameterEffectKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLParameterEffectKind = Value

  /**
    * Indicates that the behavior creates values.
    *
    * <!-- Start of user code doc for create -->
    * <!-- End of user code doc for create -->
    */
  val create = Value

  /**
    * Indicates objects that are values of the parameter do not exist after executions of the behavior are finished.
    *
    * <!-- Start of user code doc for delete -->
    * <!-- End of user code doc for delete -->
    */
  val delete = Value

  /**
    * Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classifiers retrieved during executions of the behavior.
    *
    * <!-- Start of user code doc for read -->
    * <!-- End of user code doc for read -->
    */
  val read = Value

  /**
    * Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classification changed during executions of the behavior.
    *
    * <!-- Start of user code doc for update -->
    * <!-- End of user code doc for update -->
    */
  val update = Value
}
