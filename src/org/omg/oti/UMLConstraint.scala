package org.omg.oti

trait UMLConstraint[Uml <: UML] extends UMLPackageableElement[Uml] {
  override protected def e: Uml#Constraint
  
}