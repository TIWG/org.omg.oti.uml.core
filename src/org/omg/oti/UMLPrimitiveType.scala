package org.omg.oti

trait UMLPrimitiveType[Uml <: UML] extends UMLDataType[Uml] {
  override protected def e: Uml#PrimitiveType
  
}