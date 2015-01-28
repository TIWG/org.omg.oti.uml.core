package org.omg.oti

trait UMLBehavioralFeature[Uml <: UML] extends UMLFeature[Uml] with UMLNamespace[Uml] {

  
  def ownedParameters: Iterator[UMLParameter[Uml]]
}