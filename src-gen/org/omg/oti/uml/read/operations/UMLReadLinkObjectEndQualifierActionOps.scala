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
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A ReadLinkObjectEndQualifierAction is an Action that retrieves a qualifier end value from a link object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadLinkObjectEndQualifierActionOps[Uml <: UML] { self: UMLReadLinkObjectEndQualifierAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin from which the link object is obtained.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_readLinkObjectEndQualifierAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The OutputPin where the result value is placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readLinkObjectEndQualifierAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The association of the Association end of the qualifier Property must be an AssociationClass.
    *
    * <!-- Start of user code doc for validate_association_of_association -->
    * <!-- End of user code doc for validate_association_of_association -->
    *
    * {{{
    * OCL Body qualifier.associationEnd.association.oclIsKindOf(AssociationClass)
    * }}}
    */
  def validate_association_of_association: Boolean = {
    // Start of user code for "association_of_association"
    ???
    // End of user code
  }

  /**
    * The ends of the Association must not be static.
    *
    * <!-- Start of user code doc for validate_ends_of_association -->
    * <!-- End of user code doc for validate_ends_of_association -->
    *
    * {{{
    * OCL Body qualifier.associationEnd.association.memberEnd->forAll(e | not e.isStatic)
    * }}}
    */
  def validate_ends_of_association: Boolean = {
    // Start of user code for "ends_of_association"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the object InputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_object -->
    * <!-- End of user code doc for validate_multiplicity_of_object -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_object: Boolean = {
    // Start of user code for "multiplicity_of_object"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the qualifier Property is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_qualifier -->
    * <!-- End of user code doc for validate_multiplicity_of_qualifier -->
    *
    * {{{
    * OCL Body qualifier.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_qualifier: Boolean = {
    // Start of user code for "multiplicity_of_qualifier"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the result OutputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_result -->
    * <!-- End of user code doc for validate_multiplicity_of_result -->
    *
    * {{{
    * OCL Body result.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_result: Boolean = {
    // Start of user code for "multiplicity_of_result"
    ???
    // End of user code
  }

  /**
    * The qualifier Property must be a qualifier of an Association end.
    *
    * <!-- Start of user code doc for validate_qualifier_attribute -->
    * <!-- End of user code doc for validate_qualifier_attribute -->
    *
    * {{{
    * OCL Body qualifier.associationEnd <> null
    * }}}
    */
  def validate_qualifier_attribute: Boolean = {
    // Start of user code for "qualifier_attribute"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin is the same as the type of the qualifier Property.
    *
    * <!-- Start of user code doc for validate_same_type -->
    * <!-- End of user code doc for validate_same_type -->
    *
    * {{{
    * OCL Body result.type = qualifier.type
    * }}}
    */
  def validate_same_type: Boolean = {
    // Start of user code for "same_type"
    ???
    // End of user code
  }

  /**
    * The type of the object InputPin is the AssociationClass that owns the Association end that has the given qualifier Property.
    *
    * <!-- Start of user code doc for validate_type_of_object -->
    * <!-- End of user code doc for validate_type_of_object -->
    *
    * {{{
    * OCL Body object.type = qualifier.associationEnd.association
    * }}}
    */
  def validate_type_of_object: Boolean = {
    // Start of user code for "type_of_object"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadLinkObjectEndQualifierActionOps
