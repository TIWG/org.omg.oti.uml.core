package org.omg.oti

trait UMLProfileApplication[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  override protected def e: Uml#ProfileApplication
  
}