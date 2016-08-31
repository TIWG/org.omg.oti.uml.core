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

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A Type constrains the values represented by a TypedElement.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTypeOps[Uml <: UML] { self: UMLType[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for endType_association -->
    * <!-- End of user code doc for endType_association -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.endType
    */
  def endType_association: Set[UMLAssociation[Uml]] = relatedElement_relationship.selectByKindOf { case x: UMLAssociation[Uml] => x }

  /**
    * <!-- Start of user code doc for raisedException_operation -->
    * <!-- End of user code doc for raisedException_operation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.raisedException
    */
  def raisedException_operation: Set[UMLOperation[Uml]] = raisedException_behavioralFeature.selectByKindOf { case x: UMLOperation[Uml] => x }

  /**
    * The query conformsTo() gives true for a Type that conforms to another. By default, two Types do not conform to each other. This query is intended to be redefined for specific conformance situations.
    *
    * <!-- Start of user code doc for conformsTo -->
    * <!-- End of user code doc for conformsTo -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  def conformsTo(other: Option[UMLType[Uml]]): Boolean = {
    // Start of user code for "conformsTo"
    ???
    // End of user code
  }

  // Start of user code for additional features
  def endType_associationExceptRedefinedOrDerived
  : Set[UMLAssociation[Uml]] = {
    val nonDerivedEndTypeAssociations = endType_association.filter(_.isConsistentlyNonDerived)
    nonDerivedEndTypeAssociations -- nonDerivedEndTypeAssociations.flatMap(_.getRedefinedOrSpecializedAssociations)
  }
  // End of user code
} //UMLTypeOps
