package org.omg.oti

trait UMLMultiplicityElement[Uml <: UML] extends UMLElement[Uml] {
  def lower: Int
  def upper: Int
}