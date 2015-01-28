package org.omg.oti

trait UMLRelationship[Uml <: UML] extends UMLElement[Uml] {
  def relatedElements: Iterator[UMLElement[Uml]]
}