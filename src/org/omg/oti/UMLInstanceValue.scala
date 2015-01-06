package org.omg.oti

trait UMLInstanceValue[Uml <: UML] extends UMLValueSpecification[Uml] {
  override protected def e: Uml#InstanceValue
  
  def instance: Option[UMLInstanceSpecification[Uml]]
}