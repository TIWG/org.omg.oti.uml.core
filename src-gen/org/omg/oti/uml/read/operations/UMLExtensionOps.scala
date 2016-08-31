/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.collection.Iterable
import scala.collection.immutable._
// End of user code

/**
  * An extension is used to indicate that the properties of a metaclass are extended through a stereotype, and gives the ability to flexibly add (and later remove) stereotypes to classes.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtensionOps[Uml <: UML] { self: UMLExtension[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Indicates whether an instance of the extending stereotype must be created when an instance of the extended class is created. The attribute value is derived from the value of the lower property of the ExtensionEnd referenced by Extension::ownedEnd; a lower value of 1 means that isRequired is true, but otherwise it is false. Since the default value of ExtensionEnd::lower is 0, the default value of isRequired is false.
    *
    * <!-- Start of user code doc for isRequired -->
    * <!-- End of user code doc for isRequired -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (ownedEnd.lower() = 1)
    * }}}
    */
  def isRequired: Boolean = {
    // Start of user code for "isRequired"
    ownedEnd.headOption match {
      case Some(p) =>
        1 == p.lower
      case _       =>
        false
    }
    // End of user code
  }

  /**
    * References the Class that is extended through an Extension. The property is derived from the type of the memberEnd that is not the ownedEnd.
    *
    * <!-- Start of user code doc for metaclass -->
    * <!-- End of user code doc for metaclass -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.extension
    * {{{
    * OCL Body result = (metaclassEnd().type.oclAsType(Class))
    * }}}
    */
  def metaclass: Option[UMLClass[Uml]] = {
    // Start of user code for "metaclass"
    for {
      p <- (memberEnd.toSet -- ownedEnd.toSet).headOption
      mc <- p._type.selectByKindOf { case c: UMLClass[Uml] => c }
    } yield mc
    // End of user code
  }

  /**
    * References the end of the extension that is typed by a Stereotype.
    *
    * <!-- Start of user code doc for ownedEnd -->
    * <!-- End of user code doc for ownedEnd -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtensionEnd.ownedEnd_extension
    */
  override def ownedEnd: Iterable[UMLExtensionEnd[Uml]] = feature.selectByKindOf { case x: UMLExtensionEnd[Uml] => x } headOption

  /**
    * The query metaclassEnd() returns the Property that is typed by a metaclass (as opposed to a stereotype).
    *
    * <!-- Start of user code doc for metaclassEnd -->
    * <!-- End of user code doc for metaclassEnd -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (memberEnd->reject(p | ownedEnd->includes(p.oclAsType(ExtensionEnd)))->any(true))
    * }}}
    */
  def metaclassEnd: Option[UMLProperty[Uml]] = {
    // Start of user code for "metaclassEnd"
    memberEnd
    .find {
            case _: UMLExtension[Uml] => false
            case p                    =>
              p._type match {
                case Some(_: UMLStereotype[Uml]) => false
                case Some(_: UMLClass[Uml])      => true
                case _                           => false
              }
          }
    // End of user code
  }

  /**
    * An Extension is binary, i.e., it has only two memberEnds.
    *
    * <!-- Start of user code doc for validate_is_binary -->
    * <!-- End of user code doc for validate_is_binary -->
    *
    * {{{
    * OCL Body memberEnd->size() = 2
    * }}}
    */
  def validate_is_binary: Boolean = {
    // Start of user code for "is_binary"
    2 == memberEnd.size
    // End of user code
  }

  /**
    * The non-owned end of an Extension is typed by a Class.
    *
    * <!-- Start of user code doc for validate_non_owned_end -->
    * <!-- End of user code doc for validate_non_owned_end -->
    *
    * {{{
    * OCL Body metaclassEnd()->notEmpty() and metaclassEnd().type.oclIsKindOf(Class)
    * }}}
    */
  def validate_non_owned_end: Boolean = {
    // Start of user code for "non_owned_end"
    metaclassEnd match {
      case Some(p) =>
        p._type match {
          case Some(_: UMLAssociationClass[Uml]) => false
          case Some(_: UMLBehavior[Uml])         => false
          case Some(_: UMLComponent[Uml])        => false
          case Some(_: UMLNode[Uml])             => false
          case Some(_: UMLStereotype[Uml])       => false
          case Some(_: UMLClass[Uml])            => true
          case _                                 => false
        }
      case None    =>
        false
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLExtensionOps
