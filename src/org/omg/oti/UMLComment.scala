package org.omg.oti

trait UMLComment[Uml <: UML] extends UMLElement[Uml] {
  
  def owningElement: Option[UMLElement[Uml]] = owner
  
  def annotatedElements: Iterator[UMLElement[Uml]]
  def getCommentOwnerIndex: Int
}