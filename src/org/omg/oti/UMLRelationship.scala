package org.omg.oti

trait UMLRelationship[Uml <: UML] extends UMLElement[Uml] {
  override protected def e: Uml#Relationship 

  def relatedElements: Iterator[UMLElement[Uml]]
}