package org.omg.oti

trait UMLElementImport[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  override protected def e: Uml#ElementImport
  
}