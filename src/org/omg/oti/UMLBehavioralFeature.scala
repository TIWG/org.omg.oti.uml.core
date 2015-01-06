package org.omg.oti

trait UMLBehavioralFeature[Uml <: UML] extends UMLFeature[Uml] with UMLNamespace[Uml] {
  override protected def e: Uml#BehavioralFeature
  
  def ownedParameters: Iterator[UMLParameter[Uml]]
}