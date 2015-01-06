package org.omg.oti

trait UMLEnumeration[Uml <: UML] extends UMLDataType[Uml] {
  override protected def e: Uml#Enumeration
  
}