package org.omg.oti

trait UMLGeneralization[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  override protected def e: Uml#Generalization
  
}