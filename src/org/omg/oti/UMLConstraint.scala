package org.omg.oti

trait UMLConstraint[Uml <: UML] extends UMLPackageableElement[Uml] {
  
  import ops._
  
  def context: Option[UMLNamespace[Uml]] = ownedMemberOfNamespace.selectByKindOf { case ns: UMLNamespace[Uml] => ns }
}