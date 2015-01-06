package org.omg.oti

trait UMLPackage[Uml <: UML] extends UMLNamespace[Uml] with UMLPackageableElement[Uml] {
  override protected def e: Uml#Package
  
}