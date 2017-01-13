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
import scala.{Option,None,Some}
import scala.Predef.{Set => _, _}
import scala.collection.immutable.::
import scala.collection.immutable.Nil
import scala.collection.immutable.Set
// End of user code

/**
  * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAssociationOps[Uml <: UML] { self: UMLAssociation[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Classifiers that are used as types of the ends of the Association.
    *
    * <!-- Start of user code doc for endType -->
    * <!-- End of user code doc for endType -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLType.endType_association
    * {{{
    * OCL Body result = (memberEnd->collect(type)->asSet())
    * }}}
    */
  def endType: Set[UMLType[Uml]] = relatedElement.selectByKindOf { case x: UMLType[Uml] => x }

  /**
    * Ends of Associations with more than two ends must be owned by the Association itself.
    *
    * <!-- Start of user code doc for validate_association_ends -->
    * <!-- End of user code doc for validate_association_ends -->
    *
    * {{{
    * OCL Body memberEnd->size() > 2 implies ownedEnd->includesAll(memberEnd)
    * }}}
    */
  def validate_association_ends: Boolean = {
    // Start of user code for "association_ends"
    if (memberEnd.size > 2)
      memberEnd.toSet.subsetOf(ownedEnd.toSet)
    else
      true
    // End of user code
  }

  /**
    * Only binary Associations can be aggregations.
    *
    * <!-- Start of user code doc for validate_binary_associations -->
    * <!-- End of user code doc for validate_binary_associations -->
    *
    * {{{
    * OCL Body memberEnd->exists(aggregation <> AggregationKind::none) implies (memberEnd->size() = 2 and memberEnd->exists(aggregation = AggregationKind::none))
    * }}}
    */
  def validate_binary_associations: Boolean = {
    // Start of user code for "binary_associations"
    if (memberEnd.size > 2) {
      memberEnd
        .forall { me =>
          val x: Boolean = me.aggregation.fold[Boolean](true) { agg =>
            agg == UMLAggregationKind.none
          }
          x
        }
    } else
      true
    // End of user code
  }

  /**
    * <!-- Start of user code doc for validate_ends_must_be_typed -->
    * <!-- End of user code doc for validate_ends_must_be_typed -->
    *
    * {{{
    * OCL Body memberEnd->forAll(type->notEmpty())
    * }}}
    */
  def validate_ends_must_be_typed: Boolean = {
    // Start of user code for "ends_must_be_typed"
    memberEnd.forall(_._type.isDefined)
    // End of user code
  }

  /**
    * An Association specializing another Association has the same number of ends as the other Association.
    *
    * <!-- Start of user code doc for validate_specialized_end_number -->
    * <!-- End of user code doc for validate_specialized_end_number -->
    *
    * {{{
    * OCL Body parents()->select(oclIsKindOf(Association)).oclAsType(Association)->forAll(p | p.memberEnd->size() = self.memberEnd->size())
    * }}}
    */
  def validate_specialized_end_number: Boolean = {
    // Start of user code for "specialized_end_number"
    parents
    .selectByKindOf { case a: UMLAssociation[Uml] => a }
    .forall(_.memberEnd.size == self.memberEnd.size)
    // End of user code
  }

  /**
    * When an Association specializes another Association, every end of the specific Association corresponds to an end of the general Association, and the specific end reaches the same type or a subtype of the corresponding general end.
    *
    * <!-- Start of user code doc for validate_specialized_end_types -->
    * <!-- End of user code doc for validate_specialized_end_types -->
    *
    * {{{
    * OCL Body Sequence{1..memberEnd->size()}->
    * 	forAll(i | general->select(oclIsKindOf(Association)).oclAsType(Association)->
    * 		forAll(ga | self.memberEnd->at(i).type.conformsTo(ga.memberEnd->at(i).type)))
    * }}}
    */
  def validate_specialized_end_types: Boolean = {
    // Start of user code for "specialized_end_types"
    general
    .selectByKindOf { case a: UMLAssociation[Uml] => a }
    .forall {
              a =>
                a.memberEnd.size == self.memberEnd.size &&
                  (a.memberEnd, self.memberEnd)
                  .zipped
                  .forall {
                            (sup, sub) =>
                              sub._type.fold[Boolean](true) {
                                subT => subT.conformsTo(sup._type)
                              }
                          }
            }
    // End of user code
  }

  // Start of user code for additional features

  def getDirectedAssociationEnd
  : Option[(UMLProperty[Uml], UMLProperty[Uml])]
  = memberEnd.toList match {
    case end1 :: end2 :: Nil =>
      (end1.isLogicallyNavigable, end2.isLogicallyNavigable) match {
        case (true, false) =>
          Some((end1, end2))
        case (false, true) =>
          Some((end2, end1))
        case (_, _) =>
          (end1.isSemanticallyNavigable, end2.isSemanticallyNavigable) match {
            case (true, false) =>
              Some((end1, end2))
            case (false, true) =>
              Some((end2, end1))
            case (_, _) =>
              Some((end1, end2))
          }
      }
    case _ =>
      None
  }

  def isConsistentlyNonDerived
  : Boolean
  = !isDerived & memberEnd.forall { p => !p.isDerived & !p.isDerivedUnion }

  def getRedefinedOrSpecializedAssociations
  : Set[UMLAssociation[Uml]]
  = {
    val redefined = memberEnd.flatMap(_.redefinedProperty).flatMap(_.association).toSet
    val specialized = general.selectByKindOf { case a: UMLAssociation[Uml] => a }
    redefined ++ specialized
  }

  // End of user code
} //UMLAssociationOps
