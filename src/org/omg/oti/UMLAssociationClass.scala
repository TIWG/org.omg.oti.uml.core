package org.omg.oti

trait UMLAssociationClass[Uml <: UML] extends UMLClass[Uml] with UMLAssociation[Uml] {
  override protected def e: Uml#AssociationClass
  
}