package org.omg.oti

trait UMLStructuredClassifier[Uml <: UML] extends UMLClassifier[Uml] {
  override protected def e: Uml#StructuredClassifier
  
}