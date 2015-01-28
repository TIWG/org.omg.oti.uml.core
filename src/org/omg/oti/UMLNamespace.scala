package org.omg.oti

trait UMLNamespace[Uml <: UML] extends UMLNamedElement[Uml] {
  
  import ops._
  
  def members: Set[UMLNamedElement[Uml]]
  def ownedMembers: Set[UMLNamedElement[Uml]] = members & (ownedElements.selectByKindOf { case ne: UMLNamedElement[Uml] => ne })

  def elementImports: Set[UMLElementImport[Uml]] = sourceOfDirectedRelationships.selectByKindOf { case ei: UMLElementImport[Uml] => ei }
  
  def packageImports: Set[UMLPackageImport[Uml]] = sourceOfDirectedRelationships.selectByKindOf { case pi: UMLPackageImport[Uml] => pi }
  
  def ownedRules: Set[UMLConstraint[Uml]] = ownedMembers.selectByKindOf { case c: UMLConstraint[Uml] => c }
}