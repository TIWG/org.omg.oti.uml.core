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

// [protected ('imports')]
import org.eclipse.emf.ecore.EStructuralFeature
import scala.language.existentials
import scala.language.higherKinds
import scala.language.postfixOps
import scala.reflect.runtime.universe._
import scala.reflect._
import scala.util.Try
import scala.util.Success
import scala.util.Failure
// [/protected]

trait UMLElement[Uml <: UML] {

  // [protected ('common framework for all metaclasses')]

  implicit val ops: UMLOps[Uml]
  import ops._

  case class IllegalMetaAttributeEvaluation( e: UMLElement[Uml], metaAttributeFunction: MetaAttributeAbstractFunction[_ <: UMLElement[Uml], _] )
    extends IllegalArgumentException( s"${metaAttributeFunction} not applicable to ${e.xmiType.head}" )

  sealed abstract trait MetaAttributeAbstractFunction[U <: UMLElement[Uml], DT] {
    implicit val UType: TypeTag[U]
    val attributePrefix: Option[String]
    val attributeName: String
    val f: Function1[U, Iterable[DT]]

    def evaluate( e: UMLElement[Uml] )( implicit etag: ClassTag[UMLElement[Uml]], utag: ClassTag[U] ): Try[Option[String]] =
      e match {
        case u: U => Success( f( u ).headOption match {
          case None      => None
          case Some( v ) => Some( v.toString )
        } )
        case _ => Failure( IllegalMetaAttributeEvaluation( e, this ) )
      }

    override def toString: String = {
      val attributeQName = attributePrefix match {
        case None       => attributeName
        case Some( ns ) => ns + ":" + attributeName
      }
      s"MetaAttribute(${attributeQName} on ${UType.getClass.getName})"
    }
  }

  case class MetaAttributeBooleanFunction[U <: UMLElement[Uml]](
    val attributePrefix: Option[String] = None,
    val attributeName: String,
    val f: Function1[U, Iterable[Boolean]] )
    extends MetaAttributeAbstractFunction[U, Boolean] {
    implicit val UType: TypeTag[U] = typeTag[U]
  }

  def booleanToIterable( value: Boolean, default: Boolean ): Iterable[Boolean] =
    if ( value != default ) Iterable( value )
    else Iterable()

  case class MetaAttributeIntegerFunction[U <: UMLElement[Uml]]( val attributePrefix: Option[String] = None, val attributeName: String, val f: Function1[U, Iterable[Integer]] )
    extends MetaAttributeAbstractFunction[U, Integer] {
    implicit val UType: TypeTag[U] = typeTag[U]
  }

  case class MetaAttributeStringFunction[U <: UMLElement[Uml]]( val attributePrefix: Option[String] = None, val attributeName: String, val f: Function1[U, Iterable[String]] )
    extends MetaAttributeAbstractFunction[U, String] {
    implicit val UType: TypeTag[U] = typeTag[U]
  }

  case class MetaAttributeRealFunction[U <: UMLElement[Uml]]( val attributePrefix: Option[String] = None, val attributeName: String, val f: Function1[U, Iterable[Double]] )
    extends MetaAttributeAbstractFunction[U, Double] {
    implicit val UType: TypeTag[U] = typeTag[U]
  }

  type MetaAttributeFunction = MetaAttributeAbstractFunction[_ <: UMLElement[Uml], _]

  type MetaAttributeFunctions = Seq[MetaAttributeFunction]

  def metaAttributes: MetaAttributeFunctions

  case class IllegalMetaPropertyEvaluation( e: UMLElement[Uml], metaPropertyFunction: MetaPropertyFunction[_ <: UMLElement[Uml], _ <: UMLElement[Uml]] )
    extends IllegalArgumentException( s"${metaPropertyFunction} not applicable to ${e.xmiType.head}" )

  sealed abstract trait MetaPropertyFunction[U <: UMLElement[Uml], V <: UMLElement[Uml]] {
    val propertyName: String
    
    def getReferenceFunction: Option[MetaPropertyReference[U, V]]
    def getCollectionFunction: Option[MetaPropertyCollection[U, V]]
  }
  
  case class MetaPropertyReference[U <: UMLElement[Uml], V <: UMLElement[Uml]](
    val propertyName: String,
    val f: U => Option[V] ) 
   extends MetaPropertyFunction[U, V] {

    implicit val utag: ClassTag[U] = classTag[U]

    def getReferenceFunction: Option[MetaPropertyReference[U, V]] = Some( this )
    def getCollectionFunction: Option[MetaPropertyCollection[U, V]] = None
    
    def evaluate( e: UMLElement[Uml] ): Try[Option[UMLElement[Uml]]] =
      e match {
        case u: U => Success( f( u ) )
        case _    => Failure( IllegalMetaPropertyEvaluation( e, this ) )
      }

    override def toString: String = s"MetaPropertyReference(${propertyName} on ${utag.getClass.getName})"
  }

  case class MetaPropertyCollection[U <: UMLElement[Uml], V <: UMLElement[Uml]](
    val propertyName: String,
    val f: U => Iterable[V] ) 
   extends MetaPropertyFunction[U, V] {

    implicit val utag: ClassTag[U] = classTag[U]

    def getReferenceFunction: Option[MetaPropertyReference[U, V]] = None
    def getCollectionFunction: Option[MetaPropertyCollection[U, V]] = Some( this )
    
    def evaluate( e: UMLElement[Uml] ): Try[List[UMLElement[Uml]]] = {
      require ( e != null)
      e match {
        case u: U => 
          val v = f( u ) 
          require( v != null )
          if ( v.isEmpty ) Success( Nil )
          else Success( v.toList )
        case _    => 
          Failure( IllegalMetaPropertyEvaluation( e, this ) )
      }
    }

    override def toString: String = s"MetaPropertyCollection(${propertyName} on ${utag.getClass.getName})"
  }

  type MetaPropertyEvaluator = MetaPropertyFunction[_ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  type MetaReferenceEvaluator = MetaPropertyReference[_ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  type MetaCollectionEvaluator = MetaPropertyCollection[_ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  
  type MetaPropertyFunctions = Seq[MetaPropertyEvaluator]

  /**
   * directed, non-derived, composite association end properties
   */
  def compositeMetaProperties: MetaPropertyFunctions

  /**
   * directed, non-derived, reference association end properties
   */
  def referenceMetaProperties: MetaPropertyFunctions

  def mofMetaclass: UMLClass[Uml]

  def tagValues: Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]]

  /**
   * Calculate the references from this element to other elements
   * due to non-composite, non-derived properties in the metamodel.
   *
   * For serializing an OTI model into an OMG Canonical XMI document,
   * the references among elements do matter; particularly, references
   * due to non-composite, non-derived properties matter because their serialization
   * depends on whether the two elements are serialized within the same document or not.
   *
   * The OMG MOF/XMI spec is incomplete in the sense that it does not mention
   * references due to values of applied stereotype tag properties.
   */
  def allForwardReferences: Set[UMLElement[Uml]] =
    forwardReferencesFromMetamodelAssociations ++
      forwardReferencesFromStereotypeTagProperties

  /**
   * The set of Elements referenced from this Element due to link instances of
   * directed, non-composite, non-derived associations defined in the UML metamodel
   *
   * This method is defined for every metaclass according to the figures from the UML spec in two idioms:
   * - concrete metaclasses:
   *
   * The override method includes up to 3 contributions:
   * - those of the metaclass itself
   *
   * - the concrete direct generalization parent metaclass (zero or one)
   * => super.forwardReferencesFromMetamodelAssociations
   *
   * - each abstract direct generalization parent metaclass (zero or more)
   * => [metaclass name]_forwardReferencesFromMetamodelAssociations
   */
  def forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]]

  def allOwnedElements: Stream[UMLElement[Uml]]

  def getContainedElement_eContainingFeature: EStructuralFeature
  def getElementContainer_eFeatureValue( f: EStructuralFeature ): Iterable[UMLElement[Uml]]

  def id: String

  def uuid: Option[String]

  def xmiID: Iterable[String] = Iterable( id )
  def xmiUUID: Iterable[String] = uuid.toIterable
  def xmiType: Iterable[String] = mofMetaclass.name.toIterable

  def hasStereotype( s: UMLStereotype[Uml] ): Boolean

  def isAncestorOf( other: UMLElement[Uml] ): Boolean

  /**
   * The set of Elements referenced from this Element due to values of applied stereotype tag properties
   */
  def forwardReferencesFromStereotypeTagProperties: Set[UMLElement[Uml]] =
    tagValues flatMap { case ( p, vs ) => vs } toSet

  def element_metaAttributes: MetaAttributeFunctions =
    Seq(
      MetaAttributeStringFunction[UMLElement[Uml]]( Some( "xmi" ), "id", _.xmiID ),
      MetaAttributeStringFunction[UMLElement[Uml]]( Some( "xmi" ), "uuid", _.xmiUUID ),
      MetaAttributeStringFunction[UMLElement[Uml]]( Some( "xmi" ), "type", _.xmiType ) )

  // [/protected]

  /**
   * Fig 7.1 (complete)
   */

  def element_forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]] = Set()
  def element_compositeMetaProperties: MetaPropertyFunctions = Seq( MetaPropertyCollection[UMLElement[Uml], UMLElement[Uml]]( "ownedComment", _.ownedComments.toIterable ) )
  def element_referenceMetaProperties: MetaPropertyFunctions = Seq()

  def ownedComments: Seq[UMLComment[Uml]]
  def annotatedElementOfComments: Seq[UMLComment[Uml]]

  def owner: Option[UMLElement[Uml]]
  def ownedElements: Set[UMLElement[Uml]]

  def relationships: Set[UMLRelationship[Uml]]

  def directedRelationships_source: Set[UMLDirectedRelationship[Uml]]
  def directedRelationships_target: Set[UMLDirectedRelationship[Uml]]

}