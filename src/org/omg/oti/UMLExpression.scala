package org.omg.oti

trait UMLExpression[Uml <: UML] extends UMLValueSpecification[Uml] {
  override protected def e: Uml#Expression
  
}