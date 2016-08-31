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

import scala.{AnyVal,Boolean,Unit}
import scala.collection.immutable._
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class AssociationUpdater[Uml <: UML](val domain: UMLAssociation[Uml]) extends AnyVal {

  def links_Association_association_reference_memberEnd_Property
  (range: Seq[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Association_association_reference_memberEnd_Property(domain, range)

  def links_Association_association_reference_navigableOwnedEnd_Property
  (range: Set[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Association_association_reference_navigableOwnedEnd_Property(domain, range)

  def links_Association_owningAssociation_compose_ownedEnd_Property
  (range: Iterable[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Association_owningAssociation_compose_ownedEnd_Property(domain, range)

  def setIsDerived
  (isDerived: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Association_isDerived(domain, isDerived)
}
