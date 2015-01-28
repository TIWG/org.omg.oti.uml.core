package org.omg.oti

trait UMLType[Uml <: UML] extends UMLPackageableElement[Uml] {
  
  import ops._
  
  def typedElementsOfType: Iterator[UMLTypedElement[Uml]]
  
  def endTypeOfAssociation: Iterator[UMLAssociation[Uml]]
}