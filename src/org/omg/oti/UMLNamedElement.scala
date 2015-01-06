package org.omg.oti

trait UMLNamedElement[Uml <: UML] extends UMLElement[Uml] {
  override protected def e: Uml#NamedElement
  
  def name: Option[String]
  def setName( name: String ): Unit
  
  def qualifiedName: Option[String]
  
  def memberOfMemberNamespaces: Iterator[UMLNamespace[Uml]]
  def ownedMemberOfNamespaces: Option[UMLNamespace[Uml]]

}