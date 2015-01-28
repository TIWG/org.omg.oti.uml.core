package org.omg.oti

trait UMLDirectedRelationship[Uml <: UML] extends UMLRelationship[Uml] {
  
  def sources: Iterator[UMLElement[Uml]]
  def targets: Iterator[UMLElement[Uml]]

}