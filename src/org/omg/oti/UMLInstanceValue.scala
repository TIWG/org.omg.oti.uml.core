package org.omg.oti

trait UMLInstanceValue[Uml <: UML] extends UMLValueSpecification[Uml] {
  
  def instance: Option[UMLInstanceSpecification[Uml]]
}