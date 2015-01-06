package org.omg.oti

trait UMLEncapsulatedClassifier[Uml <: UML] extends UMLStructuredClassifier[Uml] {
  override protected def e: Uml#EncapsulatedClassifier
  
}