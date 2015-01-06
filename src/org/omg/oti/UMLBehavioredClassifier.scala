package org.omg.oti

trait UMLBehavioredClassifier[Uml <: UML] extends UMLClassifier[Uml] {
  override protected def e: Uml#BehavioredClassifier
  
}