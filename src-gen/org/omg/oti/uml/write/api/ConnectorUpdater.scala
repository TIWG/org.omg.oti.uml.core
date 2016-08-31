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

package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._

import scala.{AnyVal,Option,Unit}
import scala.collection.immutable.{Seq,Set}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ConnectorUpdater[Uml <: UML](val domain: UMLConnector[Uml]) extends AnyVal {

  def links_Connector_connector_reference_contract_Behavior
  (range: Set[UMLBehavior[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Connector_connector_reference_contract_Behavior(domain, range)

  def links_Connector_connector_compose_end_ConnectorEnd
  (range: Seq[UMLConnectorEnd[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Connector_connector_compose_end_ConnectorEnd(domain, range)

  def links_Connector_connector_reference_redefinedConnector_Connector
  (range: Set[UMLConnector[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Connector_connector_reference_redefinedConnector_Connector(domain, range)

  def links_Connector_connector_reference_type_Association
  (range: Option[UMLAssociation[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Connector_connector_reference_type_Association(domain, range)
}
