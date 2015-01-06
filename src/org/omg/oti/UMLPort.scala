package org.omg.oti

trait UMLPort[Uml <: UML] extends UMLProperty[Uml] {
  override protected def e: Uml#Port
  
}