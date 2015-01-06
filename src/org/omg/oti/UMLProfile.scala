package org.omg.oti

trait UMLProfile[Uml <: UML] extends UMLPackage[Uml] {
  override protected def e: Uml#Profile
  
}