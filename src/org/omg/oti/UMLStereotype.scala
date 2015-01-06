package org.omg.oti

trait UMLStereotype[Uml <: UML] extends UMLClass[Uml] {
  override protected def e: Uml#Stereotype
  
}