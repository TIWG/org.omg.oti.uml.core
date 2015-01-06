package org.omg.oti

trait UMLLiteralSpecification[Uml <: UML] extends UMLValueSpecification[Uml] {
  override protected def e: Uml#LiteralSpecification
  
}