package org.omg.oti

trait UMLDataType[Uml <: UML] extends UMLClassifier[Uml] {
  override protected def e: Uml#DataType
  
}