package org.omg.oti

trait UMLDependency[Uml <: UML] extends UMLPackageableElement[Uml] with UMLDirectedRelationship[Uml] {

  import ops._
  
  def clients: Iterator[UMLNamedElement[Uml]] = sources.selectByKindOf { case ne: UMLNamedElement[Uml] => ne }
  def suppliers: Iterator[UMLNamedElement[Uml]] = targets.selectByKindOf { case ne: UMLNamedElement[Uml] => ne }
}