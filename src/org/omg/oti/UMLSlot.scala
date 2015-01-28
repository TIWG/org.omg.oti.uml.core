package org.omg.oti

trait UMLSlot[Uml <: UML] extends UMLElement[Uml] {
  def values: Iterator[UMLValueSpecification[Uml]]
  def definingFeature: Option[UMLStructuralFeature[Uml]]
  def owningInstance: Option[UMLInstanceSpecification[Uml]] = owner.asInstanceOf[Option[UMLInstanceSpecification[Uml]]]
}