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

import scala.{AnyVal,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class InformationFlowUpdater[Uml <: UML](val domain: UMLInformationFlow[Uml]) extends AnyVal {

  def links_InformationFlow_conveyingFlow_reference_conveyed_Classifier
  (range: Set[UMLClassifier[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_conveyingFlow_reference_conveyed_Classifier(domain, range)

  def links_InformationFlow_informationFlow_reference_informationSource_NamedElement
  (range: Set[UMLNamedElement[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_informationFlow_reference_informationSource_NamedElement(domain, range)

  def links_InformationFlow_informationFlow_reference_informationTarget_NamedElement
  (range: Set[UMLNamedElement[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_informationFlow_reference_informationTarget_NamedElement(domain, range)

  def links_InformationFlow_abstraction_reference_realization_Relationship
  (range: Set[UMLRelationship[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_abstraction_reference_realization_Relationship(domain, range)

  def links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge
  (range: Set[UMLActivityEdge[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_informationFlow_reference_realizingActivityEdge_ActivityEdge(domain, range)

  def links_InformationFlow_informationFlow_reference_realizingConnector_Connector
  (range: Set[UMLConnector[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_informationFlow_reference_realizingConnector_Connector(domain, range)

  def links_InformationFlow_informationFlow_reference_realizingMessage_Message
  (range: Set[UMLMessage[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InformationFlow_informationFlow_reference_realizingMessage_Message(domain, range)
}
