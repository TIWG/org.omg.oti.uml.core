package org.omg.oti

trait UMLTypedElement[Uml <: UML] extends UMLNamedElement[Uml] {

  def getType: Option[UMLType[Uml]]
}