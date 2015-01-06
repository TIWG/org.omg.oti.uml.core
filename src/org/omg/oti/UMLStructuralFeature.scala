package org.omg.oti

trait UMLStructuralFeature[Uml <: UML] extends UMLFeature[Uml] with UMLTypedElement[Uml] with UMLMultiplicityElement[Uml] {
  override protected def e: Uml#StructuralFeature
  
}