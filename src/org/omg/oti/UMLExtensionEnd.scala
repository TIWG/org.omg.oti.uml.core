package org.omg.oti

trait UMLExtensionEnd[Uml <: UML] extends UMLProperty[Uml] {
  override protected def e: Uml#ExtensionEnd
  
}