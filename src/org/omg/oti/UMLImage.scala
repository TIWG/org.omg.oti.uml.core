package org.omg.oti

trait UMLImage[Uml <: UML] extends UMLElement[Uml] {  
  def location: Option[String]
}