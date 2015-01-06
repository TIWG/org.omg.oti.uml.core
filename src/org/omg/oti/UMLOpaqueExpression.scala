package org.omg.oti

trait UMLOpaqueExpression[Uml <: UML] extends UMLValueSpecification[Uml] {
  override protected def e: Uml#OpaqueExpression
  
}