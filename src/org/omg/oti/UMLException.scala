package org.omg.oti

trait UMLException[Uml <: UML] extends Exception

case class IllegalElementException[Uml <: UML](message: String, val element: Uml#Element with Any) extends Exception(message) with UMLException[Uml]
