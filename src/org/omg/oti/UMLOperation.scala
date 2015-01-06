package org.omg.oti

trait UMLOperation[Uml <: UML] extends UMLBehavioralFeature[Uml] {
  override protected def e: Uml#Operation
  
}