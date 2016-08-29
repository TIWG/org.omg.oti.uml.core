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

package org.omg.oti.uml

import org.omg.oti.uml.read.api.{UMLProperty, UMLStereotype, UMLElement, UML}

/**
 * RDF-like triple involving a relation of some kind (metamodel association or stereotype property)
 * between a pair of elements (subject to object)
 */
sealed abstract class RelationTriple[Uml <: UML] {
  val sub: UMLElement[Uml]
  val obj: UMLElement[Uml]
}

case class AssociationTriple[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]]
(override val sub: UMLElement[Uml],
 relf: MetaPropertyFunction[Uml, U, V],
 override val obj: UMLElement[Uml])
  extends RelationTriple[Uml]

case class StereotypePropertyTriple[Uml <: UML]
(override val sub: UMLElement[Uml],
 rels: UMLStereotype[Uml],
 relp: UMLProperty[Uml],
 override val obj: UMLElement[Uml])
  extends RelationTriple[Uml]