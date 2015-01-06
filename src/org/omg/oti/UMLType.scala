package org.omg.oti

trait UMLType[Uml <: UML] extends UMLPackageableElement[Uml] {
  override protected def e: Uml#Type
  
  def typedElementsOfType: Iterator[UMLTypedElement[Uml]]
  
  def endTypeOfAssociation: Iterator[UMLAssociation[Uml]]
}