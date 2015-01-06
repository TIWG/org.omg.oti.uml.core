package org.omg.oti

trait UMLPackageImport[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  override protected def e: Uml#PackageImport
  
}