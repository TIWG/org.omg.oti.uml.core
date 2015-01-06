package org.omg.oti

trait UMLParameter[Uml <: UML] extends UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] {
  override protected def e: Uml#Parameter
  
}