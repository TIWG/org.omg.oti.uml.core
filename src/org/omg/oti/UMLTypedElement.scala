package org.omg.oti

trait UMLTypedElement[Uml <: UML] extends UMLNamedElement[Uml] {
  override protected def e: Uml#TypedElement
  
  def getType: Option[UMLType[Uml]]
}