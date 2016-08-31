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
import scala.collection.immutable.Set
import scala.{AnyVal,Boolean,Option,Unit}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ReadIsClassifiedObjectActionUpdater[Uml <: UML](val domain: UMLReadIsClassifiedObjectAction[Uml]) extends AnyVal {

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier
  (range: Option[UMLClassifier[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_reference_classifier_Classifier(domain, range)

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin
  (range: Option[UMLInputPin[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_object_InputPin(domain, range)

  def links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin
  (range: Option[UMLOutputPin[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_ReadIsClassifiedObjectAction_readIsClassifiedObjectAction_compose_result_OutputPin(domain, range)

  def setIsDirect
  (isDirect: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_ReadIsClassifiedObjectAction_isDirect(domain, isDirect)
}
