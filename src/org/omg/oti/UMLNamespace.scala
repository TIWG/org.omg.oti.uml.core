package org.omg.oti

trait UMLNamespace[Uml <: UML] extends UMLNamedElement[Uml] {
  override protected def e: Uml#Namespace
  
  implicit val ops: UMLOps[Uml]
  import ops._
  
  def members: Set[UMLNamedElement[Uml]]
  def ownedMembers: Set[UMLNamedElement[Uml]] = members & (ownedElements.selectByKindOf { case ne: UMLNamedElement[Uml] => ne })

}