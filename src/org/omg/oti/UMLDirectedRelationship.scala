package org.omg.oti

trait UMLDirectedRelationship[Uml <: UML] extends UMLRelationship[Uml] {
  override protected def e: Uml#DirectedRelationship
  
  def sources: Iterator[UMLElement[Uml]]
  def targets: Iterator[UMLElement[Uml]]

}