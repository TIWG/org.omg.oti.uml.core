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
package org.omg

import org.omg.oti.api._
import scala.language.existentials
import scala.reflect.runtime.universe._
import scala.reflect.{ classTag, ClassTag }
import scala.util.Try
import scala.util.Success
import scala.util.Failure

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
    metaAttributeFunction: MetaAttributeAbstractFunction[Uml, _ <: UMLElement[Uml], _] )
    extends IllegalArgumentException( s"${metaAttributeFunction} not applicable to ${e.xmiType.head}" )

  sealed abstract trait MetaAttributeAbstractFunction[Uml <: UML, U <: UMLElement[Uml], DT] {
    implicit val UType: TypeTag[U]
    val attributePrefix: Option[String]
    val attributeName: String
    val f: Function1[U, Iterable[DT]]

    def evaluate( e: UMLElement[Uml] )( implicit etag: ClassTag[UMLElement[Uml]], utag: ClassTag[U] ): Try[Iterable[String]] =
      e match {
        case u: U => Success( f( u ).map( _.toString ) )
        case _    => Failure( IllegalMetaAttributeEvaluation( e, this ) )
      }

    override def toString: String = {
      val attributeQName = attributePrefix match {
        case None       => attributeName
        case Some( ns ) => ns + ":" + attributeName
      }
      s"MetaAttribute(${attributeQName} on ${UType.getClass.getName})"
    }

  }

  case class MetaAttributeBooleanFunction[Uml <: UML, U <: UMLElement[Uml]](
    val attributePrefix: Option[String] = None,
    val attributeName: String,
    val f: Function1[U, Iterable[Boolean]] )
    extends MetaAttributeAbstractFunction[Uml, U, Boolean] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals( other: Any ): Boolean =
      other match {
        case that: MetaAttributeBooleanFunction[Uml, _] =>
          ( that canEqual this ) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual( other: Any ): Boolean =
      other.isInstanceOf[MetaAttributeBooleanFunction[Uml, _]]

    override def hashCode: Int =
      41 * ( 41 + attributePrefix.hashCode() )
    +attributeName.hashCode()
  }

  case class MetaAttributeIntegerFunction[Uml <: UML, U <: UMLElement[Uml]](
    val attributePrefix: Option[String] = None,
    val attributeName: String, val f: Function1[U, Iterable[Integer]] )
    extends MetaAttributeAbstractFunction[Uml, U, Integer] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals( other: Any ): Boolean =
      other match {
        case that: MetaAttributeIntegerFunction[Uml, _] =>
          ( that canEqual this ) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual( other: Any ): Boolean =
      other.isInstanceOf[MetaAttributeIntegerFunction[Uml, _]]

    override def hashCode: Int =
      41 * ( 41 + attributePrefix.hashCode() )
    +attributeName.hashCode()
  }

  case class MetaAttributeStringFunction[Uml <: UML, U <: UMLElement[Uml]](
    val attributePrefix: Option[String] = None,
    val attributeName: String, val f: Function1[U, Iterable[String]] )
    extends MetaAttributeAbstractFunction[Uml, U, String] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals( other: Any ): Boolean =
      other match {
        case that: MetaAttributeStringFunction[Uml, _] =>
          ( that canEqual this ) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual( other: Any ): Boolean =
      other.isInstanceOf[MetaAttributeStringFunction[Uml, _]]

    override def hashCode: Int =
      41 * ( 41 + attributePrefix.hashCode() )
    +attributeName.hashCode()
  }

  case class MetaAttributeRealFunction[Uml <: UML, U <: UMLElement[Uml]](
    val attributePrefix: Option[String] = None,
    val attributeName: String, val f: Function1[U, Iterable[Double]] )
    extends MetaAttributeAbstractFunction[Uml, U, Double] {
    implicit val UType: TypeTag[U] = typeTag[U]

    override def equals( other: Any ): Boolean =
      other match {
        case that: MetaAttributeRealFunction[Uml, _] =>
          ( that canEqual this ) &&
            attributePrefix == that.attributePrefix &&
            attributeName == that.attributeName
        case _ =>
          false
      }

    def canEqual( other: Any ): Boolean =
      other.isInstanceOf[MetaAttributeRealFunction[Uml, _]]

    override def hashCode: Int =
      41 * ( 41 + attributePrefix.hashCode() )
    +attributeName.hashCode()
  }

  /**
   * Error type: IllegalMetaPropertyEvaluation
   */
  case class IllegalMetaPropertyEvaluation[Uml <: UML](
    e: UMLElement[Uml],
    metaPropertyFunction: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]] )
    extends IllegalArgumentException( s"${metaPropertyFunction} not applicable to ${e.xmiType.head}" )

  sealed abstract trait MetaPropertyFunction[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]] {
    val propertyName: String

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]]
    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]]
  }

  case class MetaPropertyReference[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]](
    val propertyName: String,
    val f: U => Option[V] )( implicit val u: ClassTag[U] )
    extends MetaPropertyFunction[Uml, U, V] {

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = Some( this )
    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = None

    def evaluate( e: UMLElement[Uml] ): Try[Option[UMLElement[Uml]]] =
      e match {
        case u: U => Success( f( u ) )
        case _    => Failure( IllegalMetaPropertyEvaluation( e, this ) )
      }

    override def toString: String = s"MetaPropertyReference(${propertyName} on ${u.getClass.getName})"

    override def equals( other: Any ): Boolean =
      other match {
        case that: MetaPropertyReference[Uml, _, _] =>
          ( that canEqual this ) &&
            propertyName == that.propertyName
        case _ =>
          false
      }

    def canEqual( other: Any ): Boolean =
      other.isInstanceOf[MetaPropertyReference[Uml, _, _]]

    override def hashCode: Int = propertyName.hashCode()
  }

  case class MetaPropertyCollection[Uml <: UML, U <: UMLElement[Uml], V <: UMLElement[Uml]](
    val propertyName: String,
    val f: U => Iterable[V] )( implicit val u: ClassTag[U] )
    extends MetaPropertyFunction[Uml, U, V] {

    def getReferenceFunction: Option[MetaPropertyReference[Uml, U, V]] = None
    def getCollectionFunction: Option[MetaPropertyCollection[Uml, U, V]] = Some( this )

    def evaluate( e: UMLElement[Uml] ): Try[List[UMLElement[Uml]]] = {
      require( e != null )
      e match {
        case u: U =>
          val v = f( u )
          require( v != null )
          if ( v.isEmpty ) Success( Nil )
          else Success( v.toList )
        case _ =>
          Failure( IllegalMetaPropertyEvaluation( e, this ) )
      }
    }

    override def toString: String = s"MetaPropertyCollection(${propertyName} on ${u.getClass.getName})"

    override def equals( other: Any ): Boolean =
      other match {
        case that: MetaPropertyCollection[Uml, _, _] =>
          ( that canEqual this ) &&
            propertyName == that.propertyName
        case _ =>
          false
      }

    def canEqual( other: Any ): Boolean =
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
    val relf: MetaPropertyFunction[Uml, U, V],
    override val obj: UMLElement[Uml] )
    extends RelationTriple[Uml]

  case class StereotypePropertyTriple[Uml <: UML](
    override val sub: UMLElement[Uml],
    val rels: UMLStereotype[Uml],
    val relp: UMLProperty[Uml],
    override val obj: UMLElement[Uml] )
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
  def getPackageOrProfileOwner[Uml <: UML]( e: UMLElement[Uml] ): Option[UMLPackage[Uml]] =
    e.owningNamespace match {
      case None                        => None
      case Some( pf: UMLProfile[Uml] ) => Some( pf )
      case Some( ns ) =>
        (
          ns.allNamespaces.collectFirst( { case pf: UMLProfile[Uml] => pf } ),
          ns.allNamespaces.collectFirst( { case p: UMLPackage[Uml] => p } ) ) match {
            case ( Some( pf ), _ )   => Some( pf )
            case ( None, Some( p ) ) => Some( p )
            case ( None, None )      => None
          }
    }
}

