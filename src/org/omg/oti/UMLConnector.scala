package org.omg.oti

trait UMLConnector[Uml <: UML] extends UMLFeature[Uml] {
  override protected def e: Uml#Connector
  
}