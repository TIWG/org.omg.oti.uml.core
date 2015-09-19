/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.Predef.{Set => _, _}
import scala.collection.Iterable
import scala.collection.immutable.::
import scala.collection.immutable.Nil
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
    if (memberEnd.exists { me => me.aggregation != UMLAggregationKind.none })
      2 == memberEnd.size &&
        memberEnd.exists { me => me.aggregation == UMLAggregationKind.none }
    else
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
	 * }}}
	 * {{{
	 * 	forAll(i | general->select(oclIsKindOf(Association)).oclAsType(Association)->
	 * }}}
	 * {{{
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
                              sub._type match {
                                case None       => true
                                case Some(subT) => subT.conformsTo(sup._type)
                              }
                          }
            }
    // End of user code
	}

	// Start of user code for additional features

  def getDirectedAssociationEnd: Option[(UMLProperty[Uml], UMLProperty[Uml])] =
    memberEnd.toList match {
      case end1 :: end2 :: Nil =>
        (end1.isLogicallyNavigable, end2.isLogicallyNavigable) match {
          case (true, false) => Some((end2, end1))
          case (false, true) => Some((end1, end2))
          case (_, _)        =>
            (end1.isSemanticallyNavigable, end2.isSemanticallyNavigable) match {
              case (true, false) => Some((end2, end1))
              case (false, true) => Some((end1, end2))
              case (_, _)        => None
            }
        }
      case _                   => None
    }

  def isConsistentlyNonDerived: Boolean =
    !isDerived & memberEnd.forall { p => !p.isDerived & !p.isDerivedUnion }

  def getRedefinedOrSpecializedAssociations: Set[UMLAssociation[Uml]] = {
    val redefined = memberEnd.flatMap(_.redefinedProperty).flatMap(_.association).toSet
    val specialized = general.selectByKindOf { case a: UMLAssociation[Uml] => a }
    redefined ++ specialized
  }

  // End of user code
} //UMLAssociationOps
