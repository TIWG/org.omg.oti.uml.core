package org.omg.oti

trait UMLComment[Uml <: UML] extends UMLElement[Uml] {
  override protected def e: Uml#Comment
  
  def owningElement: Option[UMLElement[Uml]] = owner
  
  def annotatedElements: Iterator[UMLElement[Uml]]
  def getCommentOwnerIndex: Int
}