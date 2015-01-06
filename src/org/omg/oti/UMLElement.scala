package org.omg.oti

import org.eclipse.emf.ecore.EStructuralFeature

trait UMLElement[Uml <: UML] {

  implicit val ops: UMLOps[Uml]
  import ops._

  protected def e: Uml#Element

  def ownedComments: Seq[UMLComment[Uml]]
  def annotatedElementOfComments: Seq[UMLComment[Uml]]

  def owner: Option[UMLElement[Uml]]
  def ownedElements: Set[UMLElement[Uml]]
  def allOwnedElements: Stream[UMLElement[Uml]]

  def getContainedElement_eContainingFeature: EStructuralFeature
  def getElementContainer_eFeatureValue( f: EStructuralFeature ): Iterator[UMLElement[Uml]]

  def relatedElementOfRelationships: Seq[UMLRelationship[Uml]]

  def sourceOfDirectedRelationships: Seq[UMLDirectedRelationship[Uml]]
  def targetOfDirectedRelationships: Seq[UMLDirectedRelationship[Uml]]

  def id: String

  def hasStereotype( s: UMLStereotype[Uml] ): Boolean

  def isAncestorOf( other: UMLElement[Uml] ): Boolean

}