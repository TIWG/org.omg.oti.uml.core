package org.omg.oti

trait UMLExtension[Uml <: UML] extends UMLAssociation[Uml] {
  override protected def e: Uml#Extension
  
}