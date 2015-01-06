package org.omg.oti

trait UMLRedefinableElement[Uml <: UML] extends UMLNamedElement[Uml] {
  override protected def e: Uml#RedefinableElement
  
}