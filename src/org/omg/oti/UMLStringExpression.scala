package org.omg.oti

trait UMLStringExpression[Uml <: UML] extends UMLExpression[Uml] {
  override protected def e: Uml#StringExpression
  
}