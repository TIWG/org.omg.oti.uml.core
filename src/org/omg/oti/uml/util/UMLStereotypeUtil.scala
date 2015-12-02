package org.omg.oti.uml.util

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations._
import scala.collection.immutable._
/**
 * An abstraction for managing stereotype application.
 *
 * The UML specification avoids defining an abstract syntax for
 * instances of stereotypes and values of stereotype "tag properties".
 * The motivation is to avoid over-committing the specification and provide
 * flexibility for implementing the UML specification.
*/

trait UMLStereotypeUtil [Uml <: UML] {

  implicit val ops: UMLOps[Uml]
 
  /**
   * The the set of all the elements on which on which the stereotype is applied.
   */
  def getExtendedElements(stereotype: UMLStereotype[Uml]): Set[UMLElement[Uml]]
 
   /**
   * Find stereotype property by name 
   */
  def getProperty(stereotype: UMLStereotype[Uml], propertyName: String): Option[UMLProperty[Uml]]
  
  /**
   * Find stereotype by name inside a profile 
   */
  def getStereotype(stereotypeName: String, profile: UMLProfile[Uml]): Option[UMLStereotype[Uml]]
  
  /**
   * get the value of a stereotype property according to its name.
   */
  def getValue (element: UMLElement[Uml], stereotype: UMLStereotype[Uml], propertyName: String): Seq[UMLValueSpecification[Uml]]

  /**
   * get the value of a stereotype property.
   */
  def getValue (element: UMLElement[Uml], stereotype: UMLStereotype[Uml], property: UMLProperty[Uml]): Seq[UMLValueSpecification[Uml]]

  /**
   * Check whether stereotype is applied to element
   */
  def hasStereotype(element: UMLElement[Uml], stereotype: UMLStereotype[Uml]) : Boolean
   
}