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
import scala.language.postfixOps
// [/protected]

trait UMLElement[Uml <: UML] {

  // [protected ('common framework for all metaclasses')]

  implicit val ops: UMLOps[Uml]
  import ops._

  sealed abstract trait MetaAttributeAbstractFunction[U <: UMLElement[Uml], DT] {
    val attributeName: String
    val f: U => Iterable[DT]
  }

  case class MetaAttributeBooleanFunction[U <: UMLElement[Uml]]( val attributeName: String, val f: U => Iterable[Boolean] )
    extends MetaAttributeAbstractFunction[U, Boolean]

  def booleanToIterable( value: Boolean, default: Boolean ): Iterable[Boolean] =
    if (value != default) Iterable( value )
    else Iterable()
    
  case class MetaAttributeIntegerFunction[U <: UMLElement[Uml]]( val attributeName: String, val f: U => Iterable[Integer] )
    extends MetaAttributeAbstractFunction[U, Integer]

  case class MetaAttributeStringFunction[U <: UMLElement[Uml]]( val attributeName: String, val f: U => Iterable[String] )
    extends MetaAttributeAbstractFunction[U, String]

  case class MetaAttributeRealFunction[U <: UMLElement[Uml]]( val attributeName: String, val f: U => Iterable[Double] )
    extends MetaAttributeAbstractFunction[U, Double]

  type MetaAttributeFunctions = Seq[MetaAttributeAbstractFunction[_ <: UMLElement[Uml], _]]

  def metaAttributes: MetaAttributeFunctions

  case class MetaPropertyFunction[U <: UMLElement[Uml], V <: UMLElement[Uml]]( val propertyName: String, f: U => Iterable[V] )

  type MetaPropertyFunctions = Seq[MetaPropertyFunction[_ <: UMLElement[Uml], _ <: UMLElement[Uml]]]

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
      MetaAttributeStringFunction[UMLElement[Uml]]( "xmi:id", _.xmiID ),
      MetaAttributeStringFunction[UMLElement[Uml]]( "xmi:uuid", _.xmiUUID ),
      MetaAttributeStringFunction[UMLElement[Uml]]( "xmi:type", _.xmiType ) )

  // [/protected]

  /**
   * Fig 7.1 (complete)
   */

  def element_forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]] = Set()
  def element_compositeMetaProperties: MetaPropertyFunctions = Seq( MetaPropertyFunction[UMLElement[Uml], UMLElement[Uml]]( "ownedComment", _.ownedComments.toIterable ) )
  def element_referenceMetaProperties: MetaPropertyFunctions = Seq()

  def ownedComments: Seq[UMLComment[Uml]]
  def annotatedElementOfComments: Seq[UMLComment[Uml]]

  def owner: Option[UMLElement[Uml]]
  def ownedElements: Set[UMLElement[Uml]]

  def relationships: Set[UMLRelationship[Uml]]

  def directedRelationships_source: Set[UMLDirectedRelationship[Uml]]
  def directedRelationships_target: Set[UMLDirectedRelationship[Uml]]

}