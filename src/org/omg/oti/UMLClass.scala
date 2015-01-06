package org.omg.oti

trait UMLClass[Uml <: UML] extends UMLEncapsulatedClassifier[Uml] with UMLBehavioredClassifier[Uml] {
  override protected def e: Uml#Class
  
}