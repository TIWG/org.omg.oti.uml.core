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
  * ConnectorKind is an enumeration that defines whether a Connector is an assembly or a delegation.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLConnectorKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLConnectorKind = Value

  /**
    * Indicates that the Connector is an assembly Connector.
    *
    * <!-- Start of user code doc for assembly -->
    * <!-- End of user code doc for assembly -->
    */
  val assembly = Value

  /**
    * Indicates that the Connector is a delegation Connector.
    *
    * <!-- Start of user code doc for delegation -->
    * <!-- End of user code doc for delegation -->
    */
  val delegation = Value
}
