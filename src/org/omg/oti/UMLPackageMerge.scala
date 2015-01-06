package org.omg.oti

trait UMLPackageMerge[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  override protected def e: Uml#PackageMerge
  
}