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
class InterfaceUpdater[Uml <: UML](val domain: UMLInterface[Uml]) extends AnyVal {

  def links_Interface_interface_compose_nestedClassifier_Classifier
  (range: Seq[UMLClassifier[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interface_interface_compose_nestedClassifier_Classifier(domain, range)

  def links_Interface_interface_compose_ownedAttribute_Property
  (range: Seq[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interface_interface_compose_ownedAttribute_Property(domain, range)

  def links_Interface_interface_compose_ownedOperation_Operation
  (range: Seq[UMLOperation[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interface_interface_compose_ownedOperation_Operation(domain, range)

  def links_Interface_interface_compose_ownedReception_Reception
  (range: Set[UMLReception[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interface_interface_compose_ownedReception_Reception(domain, range)

  def links_Interface_interface_compose_protocol_ProtocolStateMachine
  (range: Option[UMLProtocolStateMachine[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interface_interface_compose_protocol_ProtocolStateMachine(domain, range)

  def links_Interface_interface_reference_redefinedInterface_Interface
  (range: Set[UMLInterface[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Interface_interface_reference_redefinedInterface_Interface(domain, range)
}
