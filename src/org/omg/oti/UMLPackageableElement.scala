package org.omg.oti

trait UMLPackageableElement[Uml <: UML] extends UMLNamedElement[Uml] {
  import ops._
  def owningPackage: Option[UMLPackage[Uml]] = ownedMemberOfNamespace.selectByKindOf { case p: UMLPackage[Uml] => p }  
  
}