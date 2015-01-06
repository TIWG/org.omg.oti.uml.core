package org.omg.oti

trait UMLLiteralString[Uml <: UML] extends UMLLiteralSpecification[Uml] {
  override protected def e: Uml#LiteralString
  
}