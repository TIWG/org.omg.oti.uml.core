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
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * LinkEndData is an Element that identifies on end of a link to be read or written by a LinkAction. As a link (that is not a link object) cannot be passed as a runtime value to or from an Action, it is instead identified by its end objects and qualifier values, if any. A LinkEndData instance provides these values for a single Association end.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLinkEndDataOps[Uml <: UML] { self: UMLLinkEndData[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A set of QualifierValues used to provide values for the qualifiers of the end.
    *
    * <!-- Start of user code doc for qualifier -->
    * <!-- End of user code doc for qualifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLQualifierValue.qualifier_linkEndData
    */
  def qualifier: Set[UMLQualifierValue[Uml]] = ownedElement.selectByKindOf { case x: UMLQualifierValue[Uml] => x }

  /**
    * <!-- Start of user code doc for endData_linkAction -->
    * <!-- End of user code doc for endData_linkAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkAction.endData
    */
  def endData_linkAction: Option[UMLLinkAction[Uml]] = owner.selectByKindOf { case x: UMLLinkAction[Uml] => x }

  /**
    * Returns all the InputPins referenced by this LinkEndData. By default this includes the value and qualifier InputPins, but subclasses may override the operation to add other InputPins.
    *
    * <!-- Start of user code doc for allPins -->
    * <!-- End of user code doc for allPins -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (value->asBag()->union(qualifier.value))
    * }}}
    */
  def allPins: Set[UMLInputPin[Uml]] = {
    // Start of user code for "allPins"
    ???
    // End of user code
  }

  /**
    * The value InputPin is not also the qualifier value InputPin.
    *
    * <!-- Start of user code doc for validate_end_object_input_pin -->
    * <!-- End of user code doc for validate_end_object_input_pin -->
    *
    * {{{
    * OCL Body value->excludesAll(qualifier.value)
    * }}}
    */
  def validate_end_object_input_pin: Boolean = {
    // Start of user code for "end_object_input_pin"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the value InputPin must be 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body value<>null implies value.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * The Property must be an Association memberEnd.
    *
    * <!-- Start of user code doc for validate_property_is_association_end -->
    * <!-- End of user code doc for validate_property_is_association_end -->
    *
    * {{{
    * OCL Body end.association <> null
    * }}}
    */
  def validate_property_is_association_end: Boolean = {
    // Start of user code for "property_is_association_end"
    ???
    // End of user code
  }

  /**
    * The qualifiers must be qualifiers of the Association end.
    *
    * <!-- Start of user code doc for validate_qualifiers -->
    * <!-- End of user code doc for validate_qualifiers -->
    *
    * {{{
    * OCL Body end.qualifier->includesAll(qualifier.qualifier)
    * }}}
    */
  def validate_qualifiers: Boolean = {
    // Start of user code for "qualifiers"
    ???
    // End of user code
  }

  /**
    * The type of the value InputPin conforms to the type of the Association end.
    *
    * <!-- Start of user code doc for validate_same_type -->
    * <!-- End of user code doc for validate_same_type -->
    *
    * {{{
    * OCL Body value<>null implies value.type.conformsTo(end.type)
    * }}}
    */
  def validate_same_type: Boolean = {
    // Start of user code for "same_type"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLLinkEndDataOps
