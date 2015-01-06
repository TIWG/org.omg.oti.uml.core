package org.omg.oti

trait UMLException[Uml <: UML] extends Exception

case class IllegalElementException[Uml <: UML, E <: UMLElement[Uml]](message: String, val element: E) extends Exception(message) with UMLException[Uml]

