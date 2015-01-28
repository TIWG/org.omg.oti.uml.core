package org.omg.oti

trait UMLClassifier[Uml <: UML] extends UMLNamespace[Uml] with UMLType[Uml] {
 
  def classifierOfInstanceSpecifications: Set[UMLInstanceSpecification[Uml]]
}