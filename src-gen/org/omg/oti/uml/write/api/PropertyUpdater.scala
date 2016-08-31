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
import scala.collection.immutable.{Seq,Set}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class PropertyUpdater[Uml <: UML](val domain: UMLProperty[Uml]) extends AnyVal {

  def links_Property_memberEnd_reference_association_Association
  (range: Option[UMLAssociation[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Property_memberEnd_reference_association_Association(domain, range)

  def links_Property_owningProperty_compose_defaultValue_ValueSpecification
  (range: Option[UMLValueSpecification[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Property_owningProperty_compose_defaultValue_ValueSpecification(domain, range)

  def links_Property_associationEnd_compose_qualifier_Property
  (range: Seq[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Property_associationEnd_compose_qualifier_Property(domain, range)

  def links_Property_property_reference_redefinedProperty_Property
  (range: Set[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Property_property_reference_redefinedProperty_Property(domain, range)

  def links_Property_property_reference_subsettedProperty_Property
  (range: Set[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Property_property_reference_subsettedProperty_Property(domain, range)

  def setAggregation
  (aggregation: Option[UMLAggregationKind.Value])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Property_aggregation(domain, aggregation)

  def setIsDerived
  (isDerived: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Property_isDerived(domain, isDerived)

  def setIsDerivedUnion
  (isDerivedUnion: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Property_isDerivedUnion(domain, isDerivedUnion)

  def setIsID
  (isID: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Property_isID(domain, isID)
}
