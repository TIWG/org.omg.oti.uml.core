package org.omg.oti

trait UMLPackage[Uml <: UML] extends UMLNamespace[Uml] with UMLPackageableElement[Uml] {
  
  import ops._
  
  def nestingPackage: Option[UMLPackage[Uml]] = owningPackage
  def packagedElement: Set[UMLPackageableElement[Uml]] = ownedMembers.selectByKindOf { case pe: UMLPackageableElement[Uml] => pe }
  def ownedType: Set[UMLType[Uml]] = packagedElement.selectByKindOf { case t: UMLType[Uml] => t }
  def ownedStereotype: Set[UMLStereotype[Uml]] = ownedType.selectByKindOf { case s: UMLStereotype[Uml] => s}
  def nestedPackages: Set[UMLPackage[Uml]] = packagedElement.selectByKindOf { case p: UMLPackage[Uml] => p }

  def applyingPackageOfProfileApplications: Set[UMLProfileApplication[Uml]] = sourceOfDirectedRelationships.selectByKindOf { case pa: UMLProfileApplication[Uml] => pa }
}