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
package org.omg.oti

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps
import org.omg.oti.uml.xmi.IDGenerator

import scala.language.existentials
import scala.{annotation,Boolean,Double,Int,Option,None,Some}
import scala.Predef.{???,String}
import scala.collection.immutable._
import scala.collection.Iterable

import java.lang.Integer

import scalaz._, Scalaz._

/**
 * <a href="../../../../index.html" target="_top">Top</a>
 *
 * = MOF-like Reflection about UML models =
 *
 * == Key abstractions: ==
 *
 *   - [[uml.MetaAttributeAbstractFunction]]: A functional abstraction for a UML or MOF attribute property
 *   - [[uml.MetaPropertyFunction]]: A functional abstraction for a UML property typed by a UML metaclass
 *   - [[uml.RelationTriple]]: A functional abstraction for an instance of a UML metamodel association or stereotype property value
 *
 * == Generic functionality ==
 *
 *   - Queries about stereotypes
 *   - Conversions for UML PrimitiveTypes
 *   - ownership and path queries
 */
package object uml {


  /**
   * Minimal semantics from UML 2.5:
   * for an element E, getPackageOrProfileOwner(E) is
   * determined by the first of the following rules that matches:
   *
   * 1) E if E is a Profile
   *
   * 2) a profile PF such that:
   * - PF.isAncestorOf(E)
   * - there is no profile PF' such that PF.isAncestorOf(PF') and PF'.isAncestorOf(E)
   *
   * 3) a package (or model) P such that:
   * - P.isAncestorOf(E)
   * - there is no P' such that P.isAncestorOf(P') and P'.isAncestorOf(E)
   *
   * 4) none
   * this shouldn't happen since every element must be contained in a package;
   * however, the Scala compiler doesn't know this...
   */
  def getPackageOrProfileOwner[Uml <: UML](e: UMLElement[Uml]):
  Option[UMLPackage[Uml]] =
    e.owningNamespace.fold[Option[UMLPackage[Uml]]](None) {
      case pf: UMLProfile[Uml] => Some(pf)
      case ns =>
        (
          ns.allNamespaces.collectFirst({ case pf: UMLProfile[Uml] => pf }),
          ns.allNamespaces.collectFirst({ case p: UMLPackage[Uml] => p })) match {
          case (Some(pf), _) => Some(pf)
          case (None, Some(p)) => Some(p)
          case (None, None) => None
        }
    }

  def findAllPathsTo[Uml <: UML, T <: UMLElement[Uml]]
  (source: T, targets: Set[T], next: T => Set[T])
  : Set[Seq[(T, T)]] = {

    val paths = scala.collection.mutable.HashSet[Seq[(T, T)]]()

    def growPath(candidate: Seq[(T, T)]): Set[Seq[(T, T)]] = {
      val t1 = candidate.last._2
      for {
        t2 <- next(t1)
        path = candidate :+ ((t1, t2))
        follow <- if (targets.contains(t2)) {
          paths += path
          None
        } else Some(path)
      } yield follow
    }

    @annotation.tailrec def growPaths(candidates: Set[Seq[(T, T)]]): Set[Seq[(T, T)]] = {
      val followCandidates = for {
        candidate <- candidates
        follow <- growPath(candidate)
      } yield follow
      if (followCandidates.isEmpty) paths.toSet
      else growPaths(followCandidates)
    }

    growPaths(next(source) map ((n) => Seq((source, n))))
  }

  def getGeneralStereotypes[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    import ops._
    s.general.selectByKindOf({ case s: UMLStereotype[Uml] => s })
  }

  def getGeneralStereotypesOutsideProfile[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    getGeneralStereotypes(s).filter((s1) => s1.profile != s.profile)
  }

  def getGeneralStereotypesWithinProfile[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    getGeneralStereotypes(s).filter((s1) => s1.profile == s.profile)
  }

  def getAllGeneralStereotypes[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getGeneralStereotypes(_) + s)
  }

  def getAllGeneralStereotypesWithinProfile[Uml <: UML]
  (s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]):
  Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getGeneralStereotypesWithinProfile(_) + s)
  }

  def getGeneralStereotypesFromOtherProfiles[Uml <: UML]
  (s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]):
  Set[UMLStereotype[Uml]] =
    s.profile match {
      case None => Set()
      case Some(pf) =>
        getAllGeneralStereotypesWithinProfile(s).flatMap(getGeneralStereotypesOutsideProfile(_))
    }

  def getSpecializedStereotypes[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    import ops._
    s.general_classifier.selectByKindOf({ case s: UMLStereotype[Uml] => s })
  }

  def getSpecializedStereotypesOutsideProfile[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    getSpecializedStereotypes(s).filter((s1) => s1.profile != s.profile)
  }

  def getSpecializedStereotypesWithinProfile[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    getSpecializedStereotypes(s).filter((s1) => s1.profile == s.profile)
  }

  def getAllSpecializedStereotypes[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getSpecializedStereotypes(_) + s)
  }

  def getAllSpecializedStereotypesWithinProfile[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getSpecializedStereotypesWithinProfile(_) + s)
  }

  def getSpecializedStereotypesFromOtherProfiles[Uml <: UML]
  (s: UMLStereotype[Uml])
  (implicit ops: UMLOps[Uml])
  : Set[UMLStereotype[Uml]] =
    s.profile match {
      case None => Set()
      case Some(pf) =>
        getAllSpecializedStereotypesWithinProfile(s).flatMap(getSpecializedStereotypesOutsideProfile(_))
    }

  def oclIsTypeOfPackage[Uml <: UML](e: UMLElement[Uml]): Boolean =
    e match {
      case _: UMLProfile[Uml] => false
      case _: UMLModel[Uml] => false
      case _: UMLPackage[Uml] => true
      case _ => false
    }

  def oclIsTypeOfClass[Uml <: UML](e: UMLElement[Uml]): Boolean =
    e match {
      case _: UMLClass[Uml] => true
      case _ => false
    }

  def booleanToIterable[Uml <: UML]( value: Boolean, default: Boolean )
  : NonEmptyList[java.lang.Throwable] \/ Iterable[Boolean] =
    if ( value != default )
      Iterable( value ).right
    else
      Iterable().right

  def integerToIterable[Uml <: UML]( value: Integer, default: Integer )
  : NonEmptyList[java.lang.Throwable] \/ Iterable[Integer] =
    if ( value != default )
      Iterable( value ).right
    else
      Iterable().right

  def unlimitedNaturalToIterable[Uml <: UML]( value: Integer, default: Integer )
  : NonEmptyList[java.lang.Throwable] \/ Iterable[String] =
    if ( value == default )
      Iterable().right
    else if (value == -1)
      Iterable("*").right
    else
      Iterable(value.toString).right

  def realToIterable[Uml <: UML]( value: Double, default: Double )
  : NonEmptyList[java.lang.Throwable] \/ Iterable[Double] =
    Iterable( value ).right

  def stringToIterable[Uml <: UML]( value: Option[String], default: String )
  : NonEmptyList[java.lang.Throwable] \/ Iterable[String] =
    value.toIterable.right

  def stringToIterable[Uml <: UML]( value: String, default: String )
  : NonEmptyList[java.lang.Throwable] \/ Iterable[String] =
    if ( value != default )
      Iterable( value ).right
    else
      Iterable().right

}