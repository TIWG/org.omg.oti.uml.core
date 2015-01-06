package org.omg.oti

trait UMLFeature[Uml <: UML] extends UMLRedefinableElement[Uml] {
  override protected def e: Uml#Feature
  
}