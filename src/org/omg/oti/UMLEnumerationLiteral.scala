package org.omg.oti

trait UMLEnumerationLiteral[Uml <: UML] extends UMLInstanceSpecification[Uml] {
  override protected def e: Uml#EnumerationLiteral
  
}