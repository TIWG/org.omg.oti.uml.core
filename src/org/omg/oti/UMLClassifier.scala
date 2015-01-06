package org.omg.oti

trait UMLClassifier[Uml <: UML] extends UMLNamespace[Uml] with UMLType[Uml] {
  override protected def e: Uml#Classifier
  
  def classifierOfInstanceSpecifications: Set[UMLInstanceSpecification[Uml]]
}