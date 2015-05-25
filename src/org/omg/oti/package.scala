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
 *   *   Neither the name of Caltech nor itsclo operating division, the Jet
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
package org.omg

import org.omg.oti.api._

import scala.language.existentials
import scala.reflect.ClassTag
import scala.reflect.runtime.universe._
import scala.util.{Failure, Success, Try}

/**
 * The UML trait type has type members for every UML metaclass.
 * The enumeration types in UML itself are not parameterized.
 *
 * Limitations:
 *
 * For PackageMerges, recommend computing the merges first
 * and then operate on the resulting merged packages.
 * (OTI could be used to implement package merge but this is not (yet) done).
 */
package object oti {

  case class IllegalMetaAttributeEvaluation[Uml <: UML](
                                                         e: UMLElement[Uml],
                                                         metaAttributeFunction: MetaAttributeAbstractFunction[Uml, _ <: UMLElement[Uml], _])
    extends IllegalArgumentException(s"$metaAttributeFunction not applicable to ${e.xmiType.head}")

  sealed trait MetaAttributeAbstractFunction[Uml <: UML, U <: UMLElement[Uml], DT] {
    implicit val UType: TypeTag[U]
    val attributePrefix: Option[String]
    val attributeName: String
    val f: Function1[U, Iterable[DT]]

    def evaluate(e: UMLElement[Uml])(implicit etag: ClassTag[UMLElement[Uml]], utag: ClassTag[U]): Try[Iterable[String]] =
      e match {
        case u: U => Success(f(u).map(_.toString))
        case _ => Failure(IllegalMetaAttributeEvaluation(e, this))
      }

    override def toString: String = {
      val attributeQName = attributePrefix match {
        case None => attributeName
        case Some(ns) => ns + ":" + attributeName
      }
      s"MetaAttribute($attributeQName on ${UType.getClass.getName})"
    }

  }

  case class MetaAttributeBooleanFunction[Uml <: UML, U <: UMLElement[Uml]](
                                                                             attributePrefix: Option[String] = None,
                                                                             attributeName: String,
                                                                             f: Function1[U, Iterable[Boolean]])
    extends MetaAttributeAbstractFunction[Uml, U, Boolean] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaAttributeBooleanFunction[Uml, _] =>
          (that canEqual this) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaAttributeBooleanFunction[Uml, _]]

    override def hashCode: Int =
      41 * (41 + attributePrefix.hashCode())

    +attributeName.hashCode()
  }

  case class MetaAttributeIntegerFunction[Uml <: UML, U <: UMLElement[Uml]](
                                                                             attributePrefix: Option[String] = None,
                                                                             attributeName: String,
                                                                             f: Function1[U, Iterable[Integer]])
    extends MetaAttributeAbstractFunction[Uml, U, Integer] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaAttributeIntegerFunction[Uml, _] =>
          (that canEqual this) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaAttributeIntegerFunction[Uml, _]]

    override def hashCode: Int =
      41 * (41 + attributePrefix.hashCode())

    +attributeName.hashCode()
  }

  case class MetaAttributeStringFunction[Uml <: UML, U <: UMLElement[Uml]](
                                                                            attributePrefix: Option[String] = None,
                                                                            attributeName: String,
                                                                            f: Function1[U, Iterable[String]])
    extends MetaAttributeAbstractFunction[Uml, U, String] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaAttributeStringFunction[Uml, _] =>
          (that canEqual this) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaAttributeStringFunction[Uml, _]]

    override def hashCode: Int =
      41 * (41 + attributePrefix.hashCode())

    +attributeName.hashCode()
  }

  case class MetaAttributeRealFunction[Uml <: UML, U <: UMLElement[Uml]](
                                                                          attributePrefix: Option[String] = None,
                                                                          attributeName: String,
                                                                          f: Function1[U, Iterable[Double]])
    extends MetaAttributeAbstractFunction[Uml, U, Double] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaAttributeRealFunction[Uml, _] =>
          (that canEqual this) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaAttributeRealFunction[Uml, _]]

    override def hashCode: Int =
      41 * (41 + attributePrefix.hashCode())

    +attributeName.hashCode()
  }

  /**
   * Error type: IllegalMetaPropertyEvaluation
   */
  case class IllegalMetaPropertyEvaluation[Uml <: UML](
                                                        e: UMLElement[Uml],
                                                        metaPropertyFunction: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]])
    extends IllegalArgumentException(s"$metaPropertyFunction not applicable to ${e.xmiType.head}")

  sealed trait MetaPropertyFunction[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]] {
    val propertyName: String

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]]

    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]]
  }

  case class MetaPropertyReference[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]](
                                                                                            propertyName: String,
                                                                                            f: U => Option[V])(implicit val u: ClassTag[U])
    extends MetaPropertyFunction[Uml, U, V] {

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = Some(this)

    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = None

    def evaluate(e: UMLElement[Uml]): Try[Option[UMLElement[Uml]]] =
      e match {
        case u: U => Success(f(u))
        case _ => Failure(IllegalMetaPropertyEvaluation(e, this))
      }

    override def toString: String = s"MetaPropertyReference($propertyName on ${u.getClass.getName})"

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaPropertyReference[Uml, _, _] =>
          (that canEqual this) &&
            propertyName == that.propertyName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaPropertyReference[Uml, _, _]]

    override def hashCode: Int = propertyName.hashCode()
  }

  case class MetaPropertyCollection[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]](
                                                                                             propertyName: String,
                                                                                             f: U => Iterable[V])(implicit val u: ClassTag[U])
    extends MetaPropertyFunction[Uml, U, V] {

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = None

    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = Some(this)

    def evaluate(e: UMLElement[Uml]): Try[List[UMLElement[Uml]]] = {
      require(e != null)
      e match {
        case u: U =>
          val v = f(u)
          require(v != null)
          if (v.isEmpty) Success(Nil)
          else Success(v.toList)
        case _ =>
          Failure(IllegalMetaPropertyEvaluation(e, this))
      }
    }

    override def toString: String = s"MetaPropertyCollection($propertyName on ${u.getClass.getName})"

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaPropertyCollection[Uml, _, _] =>
          (that canEqual this) &&
            propertyName == that.propertyName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaPropertyCollection[Uml, _, _]]

    override def hashCode: Int = propertyName.hashCode()
  }

  /**
   * RDF-like triple involving a relation of some kind (metamodel association or stereotype property)
   * between a pair of elements (subject to object)
   */
  sealed abstract class RelationTriple[Uml <: UML] {
    val sub: UMLElement[Uml]
    val obj: UMLElement[Uml]
  }

  case class AssociationTriple[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]](
                                                                                        override val sub: UMLElement[Uml],
                                                                                        relf: MetaPropertyFunction[Uml, U, V],
                                                                                        override val obj: UMLElement[Uml])
    extends RelationTriple[Uml]

  case class StereotypePropertyTriple[Uml <: UML](
                                                   override val sub: UMLElement[Uml],
                                                   rels: UMLStereotype[Uml],
                                                   relp: UMLProperty[Uml],
                                                   override val obj: UMLElement[Uml])
    extends RelationTriple[Uml]

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
  def getPackageOrProfileOwner[Uml <: UML](e: UMLElement[Uml]): Option[UMLPackage[Uml]] =
    e.owningNamespace match {
      case None => None
      case Some(pf: UMLProfile[Uml]) => Some(pf)
      case Some(ns) =>
        (
          ns.allNamespaces.collectFirst({ case pf: UMLProfile[Uml] => pf }),
          ns.allNamespaces.collectFirst({ case p: UMLPackage[Uml] => p })) match {
          case (Some(pf), _) => Some(pf)
          case (None, Some(p)) => Some(p)
          case (None, None) => None
        }
    }

  import operations._

  def findAllPathsTo[Uml <: UML, T <: UMLElement[Uml]](source: T, targets: Set[T], next: Function1[T, Set[T]]): Set[Seq[(T, T)]] = {

    val paths = scala.collection.mutable.HashSet[Seq[(T, T)]]()

    def growPath(candidate: Seq[(T, T)]): Set[Seq[(T, T)]] = {
      val t1 = candidate.last._2
      for {
        t2 <- next(t1)
        path = candidate :+(t1, t2)
        follow <- if (targets.contains(t2)) {
          paths += path;
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

  def getGeneralStereotypes[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    import ops._
    s.general.selectByKindOf({ case s: UMLStereotype[Uml] => s })
  }

  def getGeneralStereotypesOutsideProfile[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    getGeneralStereotypes(s).filter((s1) => s1.profile != s.profile)
  }

  def getGeneralStereotypesWithinProfile[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    getGeneralStereotypes(s).filter((s1) => s1.profile == s.profile)
  }

  def getAllGeneralStereotypes[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getGeneralStereotypes(_) + s)
  }

  def getAllGeneralStereotypesWithinProfile[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getGeneralStereotypesWithinProfile(_) + s)
  }

  def getGeneralStereotypesFromOtherProfiles[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] =
    s.profile match {
      case None => Set()
      case Some(pf) =>
        getAllGeneralStereotypesWithinProfile(s).flatMap(getGeneralStereotypesOutsideProfile(_))
    }

  def getSpecializedStereotypes[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    import ops._
    s.general_classifier.selectByKindOf({ case s: UMLStereotype[Uml] => s })
  }

  def getSpecializedStereotypesOutsideProfile[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    getSpecializedStereotypes(s).filter((s1) => s1.profile != s.profile)
  }

  def getSpecializedStereotypesWithinProfile[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    getSpecializedStereotypes(s).filter((s1) => s1.profile == s.profile)
  }

  def getAllSpecializedStereotypes[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getSpecializedStereotypes(_) + s)
  }

  def getAllSpecializedStereotypesWithinProfile[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] = {
    import ops._
    closure[UMLStereotype[Uml], UMLStereotype[Uml]](s, getSpecializedStereotypesWithinProfile(_) + s)
  }

  def getSpecializedStereotypesFromOtherProfiles[Uml <: UML](s: UMLStereotype[Uml])(implicit ops: UMLOps[Uml]): Set[UMLStereotype[Uml]] =
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

}

