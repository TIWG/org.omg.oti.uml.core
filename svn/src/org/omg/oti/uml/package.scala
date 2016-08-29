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

package org.omg.oti

import java.lang.Integer
import java.util.concurrent.TimeUnit

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{annotation,Boolean,Double,Option,None,Some}
import scala.concurrent.duration.Duration
import scala.concurrent.duration.FiniteDuration
import scala.Long
import scala.Predef.String
import scala.collection.immutable._
import scala.collection.Iterable

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

  def prettyDuration(d: Duration)
  : String = {

    val (hours, minutes, seconds, millis) =
      (d.toHours, d.toMinutes, d.toSeconds, d.toMillis)

    def countOf
    (n: Long, unit: String)
    : String
    = if (1==n)
        n.toString + " " + unit
    else
      n.toString + " " + unit + "s"

    val adjMinutes = minutes - hours * 60
    val adjSeconds = seconds - minutes * 60
    val adjMillis = millis - seconds * 1000

    val r1 = if (hours > 0) countOf(hours,"hour") else ""
    val r2 = if (adjMinutes > 0) (if (!r1.isEmpty) r1+", " else "") + countOf(adjMinutes, "minute") else r1
    val r3 = if (adjSeconds > 0) (if (!r2.isEmpty) r2+", " else "") + countOf(adjSeconds, "second") else r2
    val r4 = if (adjMillis > 0) (if (!r3.isEmpty) r3+", " else "") + countOf(adjMillis,"millisecond") else r3
    val r5 = if (r4.isEmpty) "<1 ms" else r4
    r5
  }
  
  def prettyFiniteDuration(length: Long, unit: TimeUnit)
  : String 
  = prettyDuration(FiniteDuration.apply(length, unit)) 
  
  implicit def setSemigroup[A]
  : Semigroup[Set[A]]
  = Semigroup.instance( _ ++ _ )

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
      if (targets.contains(t1)) {
        paths += candidate
        Set[Seq[(T, T)]]()
      } else {
        for {
          t2 <- next(t1)
          path = candidate :+ ((t1, t2))
          follow <- if (targets.contains(t2)) {
            paths += path
            None
          } else Some(path)
        } yield follow
      }
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
  : Set[java.lang.Throwable] \/ Iterable[Boolean] =
    if ( value != default )
      Iterable( value ).right
    else
      Iterable().right

  def integerToIterable[Uml <: UML]( value: Integer, default: Integer )
  : Set[java.lang.Throwable] \/ Iterable[Integer] =
    if ( value != default )
      Iterable( value ).right
    else
      Iterable().right

  def unlimitedNaturalToIterable[Uml <: UML]( value: Integer, default: Integer )
  : Set[java.lang.Throwable] \/ Iterable[String] =
    if ( value == default )
      Iterable().right
    else if (value == -1)
      Iterable("*").right
    else
      Iterable(value.toString).right

  def realToIterable[Uml <: UML]( value: Double, default: Double )
  : Set[java.lang.Throwable] \/ Iterable[Double] =
    Iterable( value ).right

  def stringToIterable[Uml <: UML]( value: Option[String], default: String )
  : Set[java.lang.Throwable] \/ Iterable[String] =
    value.toIterable.right

  def stringToIterable[Uml <: UML]( value: String, default: String )
  : Set[java.lang.Throwable] \/ Iterable[String] =
    if ( value != default )
      Iterable( value ).right
    else
      Iterable().right

}