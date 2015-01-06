package org.omg.oti

trait UMLMultiplicityElement[Uml <: UML] extends UMLElement[Uml] {
  override protected def e: Uml#MultiplicityElement
  
  def lower: Int
  def upper: Int
}