package org.omg.oti

trait UMLConnectableElement[Uml <: UML] extends UMLTypedElement[Uml] {
  override protected def e: Uml#ConnectableElement
  
}