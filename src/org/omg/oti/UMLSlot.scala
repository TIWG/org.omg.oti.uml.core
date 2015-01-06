package org.omg.oti

trait UMLSlot[Uml <: UML] extends UMLElement[Uml] {
  override protected def e: Uml#Slot
  
  def values: Iterator[UMLValueSpecification[Uml]]
  def definingFeature: Option[UMLStructuralFeature[Uml]]
  def owningInstance: Option[UMLInstanceSpecification[Uml]] = owner.asInstanceOf[Option[UMLInstanceSpecification[Uml]]]
}