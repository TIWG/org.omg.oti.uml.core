package org.omg.oti

trait UMLImage[Uml <: UML] extends UMLElement[Uml] {
  override protected def e: Uml#Image
  
  def location: Option[String]
}