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
class InteractionUseUpdater[Uml <: UML](val domain: UMLInteractionUse[Uml]) extends AnyVal {

  def links_InteractionUse_interactionUse_compose_actualGate_Gate
  (range: Set[UMLGate[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InteractionUse_interactionUse_compose_actualGate_Gate(domain, range)

  def links_InteractionUse_interactionUse_compose_argument_ValueSpecification
  (range: Seq[UMLValueSpecification[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InteractionUse_interactionUse_compose_argument_ValueSpecification(domain, range)

  def links_InteractionUse_interactionUse_reference_refersTo_Interaction
  (range: Option[UMLInteraction[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InteractionUse_interactionUse_reference_refersTo_Interaction(domain, range)

  def links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification
  (range: Option[UMLValueSpecification[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InteractionUse_interactionUse_compose_returnValue_ValueSpecification(domain, range)

  def links_InteractionUse_interactionUse_reference_returnValueRecipient_Property
  (range: Option[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_InteractionUse_interactionUse_reference_returnValueRecipient_Property(domain, range)
}
