package org.omg.oti

trait UMLInstanceSpecification[Uml <: UML] extends UMLPackageableElement[Uml] {
  override protected def e: Uml#InstanceSpecification
  
  def specification: Option[UMLValueSpecification[Uml]]
  def slots: Iterator[UMLSlot[Uml]]
  def classifiers: Iterator[UMLClassifier[Uml]]
  def instanceOfInstanceValues: Iterator[UMLInstanceValue[Uml]]
}