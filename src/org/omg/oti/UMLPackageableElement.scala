package org.omg.oti

trait UMLPackageableElement[Uml <: UML] extends UMLNamedElement[Uml] {
  override protected def e: Uml#PackageableElement
  
}