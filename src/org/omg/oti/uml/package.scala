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

import scala.reflect._
import scala.language.existentials
import scala.reflect.runtime.universe._
import scala.util.{Failure, Success, Try}

/**
 * <a href="../../../../index.html" target="_top">Top</a>
 *
 * = MOF-like Reflection about UML models =
 *
 * == Key abstractions: ==
 *
 *   - [[uml.MetaAttributeAbstractFunction]]: A functional abstraction for a UML or MOF attribute property
 *   - [[uml.IllegalMetaPropertyEvaluation]]: An exception type for attribute property evaluation errors
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

  case class IllegalMetaAttributeEvaluation[Uml <: UML]
  (e: UMLElement[Uml],
   metaAttributeFunction: MetaAttributeAbstractFunction[Uml, _ <: UMLElement[Uml], _])
    extends IllegalArgumentException(s"$metaAttributeFunction not applicable to ${e.xmiType.head}")

  /**
   * A functional wrapper for a UML Property typed by a PrimitiveType
   *
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   * @tparam DT A value type corresponding to a UML PrimitiveType
   */
  sealed trait MetaAttributeAbstractFunction[Uml <: UML, U <: UMLElement[Uml], DT] {
    implicit val UType: TypeTag[U]
    val attributePrefix: Option[String]
    val attributeName: String
    val f: Option[U => Iterable[DT]]
    val df: Option[(U, IDGenerator[Uml]) => Iterable[DT]]

    def evaluate
    (e: UMLElement[Uml], idg: IDGenerator[Uml])
    (implicit etag: ClassTag[UMLElement[Uml]], utag: ClassTag[U])
    : Try[Iterable[String]] =
      e match {
        case u: U => 
          (f, df) match {
            case (Some(_f), _) =>
              Success(_f(u).map(_.toString))
            case (None, Some(_df)) =>
              Success(_df(u, idg).map(_.toString))
            case _ =>
              Failure(IllegalMetaAttributeEvaluation(e, this))
          }
        case _ => 
          Failure(IllegalMetaAttributeEvaluation(e, this))
      }

    override def toString: String = {
      val attributeQName = attributePrefix match {
        case None => attributeName
        case Some(ns) => ns + ":" + attributeName
      }
      s"MetaAttribute($attributeQName on ${UType.getClass.getName})"
    }

  }

  /**
   * A functional wrapper for a UML Property typed by a Boolean PrimitiveType
   *
   * @param attributePrefix optionally, a namespace prefix for the attribute property
   * @param attributeName the name of the attribute property
   * @param f1 the query operation corresponding to the attribute property
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   */
  case class MetaAttributeBooleanFunction[Uml <: UML, U <: UMLElement[Uml]]
  (attributePrefix: Option[String] = None,
   attributeName: String,
   f1: Function1[U, Iterable[Boolean]])
    extends MetaAttributeAbstractFunction[Uml, U, Boolean] {
    implicit val UType: TypeTag[U] = typeTag[U]
    override val f = Some(f1)
    override val df = None
    
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
      41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
  }

  /**
   * A functional wrapper for a UML or MOF Property typed by an Integer PrimitiveType
   *
   * @param attributePrefix optionally, a namespace prefix for the UML or MOF attribute property
   * @param attributeName the name of the UML or MOF attribute property
   * @param f1 the query operation corresponding to the UML or MOF attribute property
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   */
  case class MetaAttributeIntegerFunction[Uml <: UML, U <: UMLElement[Uml]]
  (attributePrefix: Option[String] = None,
   attributeName: String,
   f1: Function1[U, Iterable[Integer]])
    extends MetaAttributeAbstractFunction[Uml, U, Integer] {
    implicit val UType: TypeTag[U] = typeTag[U]
    override val f = Some(f1)
    override val df = None

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
      41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
  }

  /**
   * A functional wrapper for a UML Property typed by an UnlimitedNatural PrimitiveType
   *
   * @param attributePrefix optionally, a namespace prefix for the UML attribute property
   * @param attributeName the name of the UML attribute property
   * @param f1 the query operation corresponding to the UML attribute property
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   */
  case class MetaAttributeUnlimitedNaturalFunction[Uml <: UML, U <: UMLElement[Uml]]
  (attributePrefix: Option[String] = None,
   attributeName: String,
   f1: Function1[U, Iterable[String]])
    extends MetaAttributeAbstractFunction[Uml, U, String] {
    implicit val UType: TypeTag[U] = typeTag[U]
    override val f = Some(f1)
    override val df = None

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
      41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
  }

  /**
   * A functional wrapper for a UML Property typed by a String PrimitiveType
   *
   * @param attributePrefix optionally, a namespace prefix for the UML attribute property
   * @param attributeName the name of the UML attribute property
   * @param f1 the query operation corresponding to the UML attribute property
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   */
  case class MetaAttributeStringFunction[Uml <: UML, U <: UMLElement[Uml]]
  (attributePrefix: Option[String] = None,
   attributeName: String,
   f1: Function1[U, Iterable[String]])
    extends MetaAttributeAbstractFunction[Uml, U, String] {
    implicit val UType: TypeTag[U] = typeTag[U]
    override val f = Some(f1)
    override val df = None

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
      41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
  }

  /**
   * A functional wrapper for a UML Property typed by a Real PrimitiveType
   *
   * @param attributePrefix optionally, a namespace prefix for the UML attribute property
   * @param attributeName the name of the UML attribute property
   * @param f1 the query operation corresponding to the UML attribute property
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   */
  case class MetaAttributeRealFunction[Uml <: UML, U <: UMLElement[Uml]]
  (attributePrefix: Option[String] = None,
   attributeName: String,
   f1: Function1[U, Iterable[Double]])
    extends MetaAttributeAbstractFunction[Uml, U, Double] {
    implicit val UType: TypeTag[U] = typeTag[U]
    override val f = Some(f1)
    override val df = None

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
      41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
  }

  /**
   * A functional wrapper for a MOF attribute property typed by a String PrimitiveType
   *
   * @param attributePrefix optionally, a namespace prefix for the MOF attribute property
   * @param attributeName the name of the MOF attribute property
   * @param f1 the query operation corresponding to the MOF attribute property
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U An OTI UML metaclass
   */
  case class MetaDocumentAttributeStringFunction[Uml <: UML, U <: UMLElement[Uml]]
  (attributePrefix: Option[String] = None,
   attributeName: String,
   df1: Function2[U, IDGenerator[Uml], Iterable[String]])
    extends MetaAttributeAbstractFunction[Uml, U, String] {
    implicit val UType: TypeTag[U] = typeTag[U]
    override val f = None
    override val df = Some(df1)

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaDocumentAttributeStringFunction[Uml, _] =>
          (that canEqual this) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaDocumentAttributeStringFunction[Uml, _]]

    override def hashCode: Int =
      41 * (41 + attributePrefix.hashCode())+attributeName.hashCode()
  }
  
  /**
   * Error type: IllegalMetaPropertyEvaluation
   */
  case class IllegalMetaPropertyEvaluation[Uml <: UML]
  (e: UMLElement[Uml],
   metaPropertyFunction: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]])
    extends IllegalArgumentException(s"$metaPropertyFunction not applicable to ${e.xmiType.head}")

  /**
   * A MetaPropertyFunction provides information about properties defined on an element's metaclass
   * like MOF Reflection would.
   *
   * With MOF Reflection, given an Element E, its metaclass, MC, is: MC = E.metaclass (see MOF 9.2)
   *
   * MOF is difficult to understand because reflection is described using UML without explicitly
   * distinguishing the use of UML for semantically distinct levels of modeling.
   * Semantically, MOF requires, at minimum, distinguishing between two levels of modeling.
   * That is, the MOF architecture is fundamentally a pattern relating two levels of modeling.
   * This pattern can be stacked to yield an architecture involving multiple levels of modeling (3, 4, ...)
   *
   * The problem is that the 2-level pattern is described by reference to a single modeling language, a subset of UML.
   * For example, MOF 9.2 Reflection defines:
   *
   * Element::/metaclass: Class
   *
   * Here, Element and Class are metaclasses defined in UML; however, they belong to distinct levels of modeling.
   * An explicit distinction would be:
   *
   * [M1]Element::/metaclass: [M2]Class
   *
   * where [L]C denotes the modeling level L that a class C belongs to.
   *
   * For XMI serialization, it necessary to obtain M2-level information about M1-level elements.
   * This M2-level information involves reflective access to an element's metaclass (I.e., M2) as shown above
   * but also to the properties of M2-level metaclasses.
   *
   * See XMI2.5, ptc/14-09-21, 7.8.5 Class-typed Property Representation
   * See MOF5.2, ptc/14-09-18, 15.9 Additional Operations
   *
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam U The metaclass on which the property is defined
   * @tparam V The metaclass that is the type of the property
   */
  sealed trait MetaPropertyFunction[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]] {
    val domainType: ClassTag[U]
    val rangeType: ClassTag[V]
     
    val propertyName: String

    /**
     * Ordering matters for serialization per Canonical XMI ptc/2013-08-31:
     *
     * B5.3 Property Content for Class-typed Properties
     * For ordering of elements within the serialization of a class-typed property value
     * (usually an association end) where the property does not have isOrdered='true'
     * in the metamodel, the ordering is as follows:
     * - All nested elements precede all link elements (those referencing another element)
     *   Within the set of nested elements the order is alphabetically ordered by
     *   the value of the xmi:uuid.
     * - Within the set of link elements all links using xmi:idref preceded elements using href.
     *   The set of xmi:idref elements is alphabetically ordered by the value of the xmi:idref,
     *   and the set of href elements is alphabetically ordered by the value of the href.
     * B5.4 Property Content for DataType-typed Properties
     * For ordering of elements within the serialization of a data-typed property value,
     * where the property does not have isOrdered='true' in the metamodel,
     * there will be no links nor xmi:uuids and the ordering is as follows.
     * Note that for structured Datatypes the properties will be ordered as per B5.1.
     * - For structured datatypes the nested elements are alphabetically ordered by
     *   the values of their properties, taken in order
     *   (if the values of the first properties are identical the second is compared and so on)
     * - For simple datatypes the nested elements are sorted alphabetically by their values.
     * Note that alphabetic ordering is used so that, even if the property is of type Integer,
     * 10 will precede 9.
     */
    val isOrdered: Boolean

    /**
     * Canonical XMI ID generation depends on whether a property is a collection or not.
     *
     * B.6
     * 4) If the object has no identifier, or the base name (after character replacement)
     * is a duplicate of an earlier (by export order) sibling base name, then:
     * a. append underscore '_' if the last character is not already underscore '_';
     * b. append a sequence number, starting with 1 when the object has no name, and 2 if it does.
     * It is possible that an earlier sibling name contains a '_n' suffix that creates a name
     * collision. In this case increment the sequence number until no collision exists.
     */
    val isCollection: Boolean

    /**
     * Redefined properties matters for serialization per XMI 2.5 ptc/14-09-21:
     *
     * 9.4.2 CMOF Package
     * The following additional rules are defined to suppress redundant information.
     * They can be overriden using XMI tags:
     * In the case where a Property redefines another Property, only the redefining Property is serialized.
     * (Note that when serializing an instance of a concrete supertype whose
     *  Property has been redefined the supertype is unaware of the redefinition, and
     *  the Property as defined on the supertype is serialized.)
     */
    val redefinedMetaProperties: Set[
      _ <: MetaPropertyFunction[Uml,
      _ <: UMLElement[Uml],
      _ <: UMLElement[Uml]]]

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]]

    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]]
  }



  case class MetaPropertyReference[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]]
  (propertyName: String,
   f: U => Option[V],
   isOrdered: Boolean = false,
   redefinedMetaProperties:
   Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]] =
   Set())
  (implicit val uType: ClassTag[U], vType: ClassTag[V])
    extends MetaPropertyFunction[Uml, U, V] {

    override val domainType = uType
    override val rangeType = vType
    
    val isCollection: Boolean = false

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = Some(this)

    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = None

    def evaluate(e: UMLElement[Uml]): Try[Option[UMLElement[Uml]]] =
      e match {
        case u: U => Success(f(u))
        case _ => Failure(IllegalMetaPropertyEvaluation(e, this))
      }

    override def toString: String =
      s"MetaPropertyReference($propertyName on $uType${if (isOrdered) " {ordered}" else ""})"

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaPropertyReference[Uml, _, _] =>
          (that canEqual this) &&
            propertyName == that.propertyName &&
            domainType.runtimeClass.getName == that.domainType.runtimeClass.getName &&
            rangeType.runtimeClass.getName == that.rangeType.runtimeClass.getName
        case _ =>
          false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[MetaPropertyReference[Uml, _, _]]

    override def hashCode: Int = propertyName.hashCode()
  }

  case class MetaPropertyCollection[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]]
  (propertyName: String,
   f: U => Iterable[V],
   isOrdered: Boolean = false,
   redefinedMetaProperties:
   Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]] =
   Set())
  (implicit val uType: ClassTag[U], vType: ClassTag[V])
    extends MetaPropertyFunction[Uml, U, V] {

    override val domainType = uType
    override val rangeType = vType
    
    val isCollection: Boolean = true

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = None

    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = Some(this)

    def evaluate(e: UMLElement[Uml]): Try[List[UMLElement[Uml]]] = {
      require(e != null)
      e match {
        case u: U =>
          val v = f(u)
          require(v != null)
          if (v.isEmpty)
            Success(Nil)
          else if (isOrdered)
            Success(v.toList)
          else
            Success(v.toList)
        case _ =>
          Failure(IllegalMetaPropertyEvaluation(e, this))
      }
    }

    override def toString: String =
      s"MetaPropertyCollection($propertyName on $uType${if (isOrdered) " {ordered}" else ""})"

    override def equals(other: Any): Boolean =
      other match {
        case that: MetaPropertyCollection[Uml, _, _] =>
          (that canEqual this) &&
            propertyName == that.propertyName &&
            domainType.runtimeClass.getName == that.domainType.runtimeClass.getName &&
            rangeType.runtimeClass.getName == that.rangeType.runtimeClass.getName
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

  def findAllPathsTo[Uml <: UML, T <: UMLElement[Uml]]
  (source: T, targets: Set[T], next: T => Set[T])
  : Set[Seq[(T, T)]] = {

    val paths = scala.collection.mutable.HashSet[Seq[(T, T)]]()

    def growPath(candidate: Seq[(T, T)]): Set[Seq[(T, T)]] = {
      val t1 = candidate.last._2
      for {
        t2 <- next(t1)
        path = candidate :+(t1, t2)
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

  def booleanToIterable( value: Boolean, default: Boolean ): Iterable[Boolean] =
    if ( value != default ) Iterable( value )
    else Iterable()

  def integerToIterable( value: Integer, default: Integer ): Iterable[Integer] =
    if ( value != default ) Iterable( value )
    else Iterable()

  def unlimitedNaturalToIterable( value: Integer, default: Integer ): Iterable[String] =
    if ( value == default ) Iterable()
    else if (value == -1) Iterable("*") else Iterable(value.toString)

  def realToIterable( value: Double, default: Double ): Iterable[Double] =
    Iterable( value )

  def stringToIterable( value: Option[String], default: String ): Iterable[String] =
    value.toIterable

  def stringToIterable( value: String, default: String ): Iterable[String] =
    if ( value != default ) Iterable( value )
    else Iterable()

}