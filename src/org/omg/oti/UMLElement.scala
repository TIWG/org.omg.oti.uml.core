package org.omg.oti

import org.eclipse.emf.ecore.EStructuralFeature

trait UMLElement[Uml <: UML] {

  implicit val ops: UMLOps[Uml]
  import ops._

  def ownedComments: Seq[UMLComment[Uml]]
  def annotatedElementOfComments: Seq[UMLComment[Uml]]

  def owner: Option[UMLElement[Uml]]
  def ownedElements: Set[UMLElement[Uml]]
  def allOwnedElements: Stream[UMLElement[Uml]]

  def getContainedElement_eContainingFeature: EStructuralFeature
  def getElementContainer_eFeatureValue( f: EStructuralFeature ): Iterator[UMLElement[Uml]]

  def relatedElementOfRelationships: Set[UMLRelationship[Uml]]

  def sourceOfDirectedRelationships: Set[UMLDirectedRelationship[Uml]]
  def targetOfDirectedRelationships: Set[UMLDirectedRelationship[Uml]]

  def id: String

  def hasStereotype( s: UMLStereotype[Uml] ): Boolean

  def isAncestorOf( other: UMLElement[Uml] ): Boolean

}