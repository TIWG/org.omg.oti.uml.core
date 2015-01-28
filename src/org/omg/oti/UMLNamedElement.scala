package org.omg.oti

trait UMLNamedElement[Uml <: UML] extends UMLElement[Uml] {

  import ops._
  
  def name: Option[String]
  def setName( name: String ): Unit
  
  def qualifiedName: Option[String]
  
  def memberOfMemberNamespaces: Iterator[UMLNamespace[Uml]]
  def ownedMemberOfNamespace: Option[UMLNamespace[Uml]] = owner.selectByKindOf { case ns: UMLNamespace[Uml] => ns }

  def supplierTargetOfSupplierDependency: Iterator[UMLDependency[Uml]]
  def clientSourceOfClientDependency: Iterator[UMLDependency[Uml]]
}