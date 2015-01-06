package org.omg.oti

trait UMLInterval[Uml <: UML] extends UMLValueSpecification[Uml] {
  override protected def e: Uml#Interval
  
}