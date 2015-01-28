package org.omg.oti

trait UMLInstanceSpecification[Uml <: UML] extends UMLPackageableElement[Uml] {
  
  def specification: Option[UMLValueSpecification[Uml]]
  def slots: Iterator[UMLSlot[Uml]]
  def classifiers: Iterator[UMLClassifier[Uml]]
  def instanceOfInstanceValues: Iterator[UMLInstanceValue[Uml]]
}