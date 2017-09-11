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

import scala.{AnyVal,Boolean,Option,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ParameterUpdater[Uml <: UML](val domain: UMLParameter[Uml]) extends AnyVal {

  def links_Parameter_owningParameter_compose_defaultValue_ValueSpecification
  (range: Option[UMLValueSpecification[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Parameter_owningParameter_compose_defaultValue_ValueSpecification(domain, range)

  def links_Parameter_parameter_reference_parameterSet_ParameterSet
  (range: Set[UMLParameterSet[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Parameter_parameter_reference_parameterSet_ParameterSet(domain, range)

  def setDirection
  (direction: Option[UMLParameterDirectionKind.Value])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Parameter_direction(domain, direction)

  def setEffect
  (effect: Option[UMLParameterEffectKind.Value])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Parameter_effect(domain, effect)

  def setIsException
  (isException: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Parameter_isException(domain, isException)

  def setIsStream
  (isStream: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Parameter_isStream(domain, isStream)
}