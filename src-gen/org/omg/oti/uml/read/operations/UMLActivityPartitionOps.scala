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
import scala.collection.Iterable
import scala.collection.immutable.::
import scala.collection.immutable.Nil
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
 * An ActivityPartition is a kind of ActivityGroup for identifying ActivityNodes that have some characteristic in common.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActivityPartitionOps[Uml <: UML] { self: UMLActivityPartition[Uml] =>

// Start of user code for class imports
	import self.ops._
// End of user code


	/**
	 * ActivityEdges immediately contained in the ActivityPartition.
	 *
	 * <!-- Start of user code doc for edge -->
   * <!-- End of user code doc for edge -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityEdge.inPartition
	 */
	def edge: Set[UMLActivityEdge[Uml]] = containedEdge

	/**
	 * ActivityNodes immediately contained in the ActivityPartition.
	 *
	 * <!-- Start of user code doc for node -->
   * <!-- End of user code doc for node -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityNode.inPartition
	 */
	def node: Set[UMLActivityNode[Uml]] = containedNode

	/**
	 * Other ActivityPartitions immediately contained in this ActivityPartition (as its subgroups).
	 *
	 * <!-- Start of user code doc for subpartition -->
   * <!-- End of user code doc for subpartition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityPartition.superPartition
	 */
	def subpartition: Set[UMLActivityPartition[Uml]] = subgroup.selectByKindOf { case x: UMLActivityPartition[Uml] => x }

	/**
	 * Other ActivityPartitions immediately containing this ActivityPartition (as its superGroups).
	 *
	 * <!-- Start of user code doc for superPartition -->
   * <!-- End of user code doc for superPartition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityPartition.subpartition
	 */
	def superPartition: Option[UMLActivityPartition[Uml]] = superGroup.selectByKindOf { case x: UMLActivityPartition[Uml] => x }

	/**
	 * An ActvivityPartition with isDimension = true may not be contained by another ActivityPartition.
	 *
	 * <!-- Start of user code doc for validate_dimension_not_contained -->
   * <!-- End of user code doc for validate_dimension_not_contained -->
	 *
	 * {{{
	 * OCL Body isDimension implies superPartition->isEmpty()
	 * }}}
	 */
	def validate_dimension_not_contained: Boolean = {
		// Start of user code for "dimension_not_contained"
    if (isDimension)
      superPartition.isEmpty
    else true
    // End of user code
	}

	/**
	 * If a non-external ActivityPartition represents a Classifier and has a superPartition, then the superPartition must represent a Classifier, and the Classifier of the subpartition must be nested (nestedClassifier or ownedBehavior) in the Classifier represented by the superPartition, or be at the contained end of a composition Association with the Classifier represented by the superPartition.
	 *
	 * <!-- Start of user code doc for validate_represents_classifier -->
   * [A] the superPartition must represent a Classifier,
   * and
   * ([B1] the Classifier of the subpartition must be nested (nestedClassifier or ownedBehavior) in the Classifier represented by the superPartition,
   * or
   * [B2] be at the contained end of a composition Association with the Classifier represented by the superPartition.)
   * <!-- End of user code doc for validate_represents_classifier -->
	 *
	 * {{{
	 * OCL Body (not isExternal and represents.oclIsKindOf(Classifier) and superPartition->notEmpty()) implies
	 * (
	 *    let representedClassifier : Classifier = represents.oclAsType(Classifier) in
	 *      superPartition.represents.oclIsKindOf(Classifier) and
	 *       let representedSuperClassifier : Classifier = superPartition.represents.oclAsType(Classifier) in
	 *        (representedSuperClassifier.oclIsKindOf(BehavioredClassifier) and representedClassifier.oclIsKindOf(Behavior) and 
	 *         representedSuperClassifier.oclAsType(BehavioredClassifier).ownedBehavior->includes(representedClassifier.oclAsType(Behavior))) 
	 *        or
	 *        (representedSuperClassifier.oclIsKindOf(Class) and  representedSuperClassifier.oclAsType(Class).nestedClassifier->includes(representedClassifier))
	 *        or
	 *        (Association.allInstances()->exists(a | a.memberEnd->exists(end1 | end1.isComposite and end1.type = representedClassifier and 
	 *                                                                       a.memberEnd->exists(end2 | end1<>end2 and end2.type = representedSuperClassifier))))
	 * )
	 * }}}
	 */
	def validate_represents_classifier: Boolean = {
		// Start of user code for "represents_classifier"
    (isExternal, represents, superPartition) match {
      case (false, Some(classifier: UMLClassifier[Uml]), Some(sp: UMLClassifier[Uml])) =>
        sp.represents match {
          case Some(superClassifier: UMLClassifier[Uml]) =>
            ((superClassifier, classifier) match {
              case (rsc: UMLBehavioredClassifier[Uml], rc: UMLBehavior[Uml]) => rsc.ownedBehavior.contains(rc)
              case _                                                         => false
            }
              ) ||
              (superClassifier match {
                case rsc: UMLClass[Uml] => rsc.nestedClassifier.contains(classifier)
                case _                  => false
              }
                ) ||
              ((classifier.endType_association flatMap {
                _.memberEnd.toList match {
                  case (end1 :: end2 :: Nil) =>
                    (end1.isComposite, end1._type, end2.isComposite, end2._type) match {
                      case (true, Some(representedClassifier), false, Some(representedSuperClassifier)) => Some(true)
                      case (false, Some(representedSuperClassifier), true, Some(representedClassifier)) => Some(true)
                      case _                                                                            => None
                    }
                  case _                     => None
                }
              }).nonEmpty
                )
          case _                                         => false
        }
      case _                                                                           => true
    }
    // End of user code
	}

	/**
	 * If an ActivityPartition represents a Property and has a superPartition representing a Classifier, then all the other non-external subpartitions of the superPartition must represent Properties directly owned by the same Classifier.
	 *
	 * <!-- Start of user code doc for validate_represents_property -->
   * <!-- End of user code doc for validate_represents_property -->
	 *
	 * {{{
	 * OCL Body (represents.oclIsKindOf(Property) and superPartition->notEmpty() and superPartition.represents.oclIsKindOf(Classifier)) implies
	 * (
	 *   let representedClassifier : Classifier = superPartition.represents.oclAsType(Classifier)
	 *   in
	 *     superPartition.subpartition->reject(isExternal)->forAll(p | 
	 *        p.represents.oclIsKindOf(Property) and p.owner=representedClassifier)
	 * )
	 * }}}
	 */
	def validate_represents_property: Boolean = {
		// Start of user code for "represents_property"
    represents match {
      case Some(_: UMLProperty[Uml]) => superPartition match {
        case Some(sp) => sp.represents match {
          case Some(representedClassifier: UMLClassifier[Uml]) =>
            sp.subpartition
            .filterNot { sub => sub.isExternal }
            .forall {
                      p => (p.owner, p.represents) match {
                        case (Some(o), Some(_: UMLProperty[Uml])) => o == representedClassifier
                        case _                                    => false
                      }
                    }
          case _                                               => true
        }
        case None     => true
      }
      case _                         => true
    }
    // End of user code
	}

	/**
	 * If an ActivityPartition represents a Property and has a superPartition, then the Property must be of a Classifier represented by the superPartition, or of a Classifier that is the type of a Property represented by the superPartition.
	 *
	 * <!-- Start of user code doc for validate_represents_property_and_is_contained -->
   * <!-- End of user code doc for validate_represents_property_and_is_contained -->
	 *
	 * {{{
	 * OCL Body (represents.oclIsKindOf(Property) and superPartition->notEmpty()) implies
	 * (
	 *   (superPartition.represents.oclIsKindOf(Classifier) and represents.owner = superPartition.represents) or 
	 *   (superPartition.represents.oclIsKindOf(Property) and represents.owner = superPartition.represents.oclAsType(Property).type)
	 * )
	 * }}}
	 */
	def validate_represents_property_and_is_contained: Boolean = {
		// Start of user code for "represents_property_and_is_contained"
		represents.fold[Boolean](false) {
		  case p: UMLProperty[Uml] => 
		    superPartition.fold[Boolean](false) {
		      case sup: UMLActivityPartition[Uml] =>
		        sup.represents.fold[Boolean](false) {
		          case supRepresentsClassifier: UMLClassifier[Uml] =>
		            p.owner.contains(supRepresentsClassifier)
		          case supRepresentsProperty: UMLProperty[Uml] =>
		            (p.owner.toSet & supRepresentsProperty._type.toSet).nonEmpty
		          case _ =>
		            false
		        }
		    }
		  case _ =>
		    false
		}
    // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLActivityPartitionOps
