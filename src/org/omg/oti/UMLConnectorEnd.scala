package org.omg.oti

trait UMLConnectorEnd[Uml <: UML] extends UMLMultiplicityElement[Uml] {
  override protected def e: Uml#ConnectorEnd
  
}