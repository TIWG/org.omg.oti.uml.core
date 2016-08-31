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
// End of user code

/**
  * A QualifierValue is an Element that is used as part of LinkEndData to provide the value for a single qualifier of the end given by the LinkEndData.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLQualifierValueOps[Uml <: UML] { self: UMLQualifierValue[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for qualifier_linkEndData -->
    * <!-- End of user code doc for qualifier_linkEndData -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndData.qualifier
    */
  def qualifier_linkEndData: Option[UMLLinkEndData[Uml]] = owner.selectByKindOf { case x: UMLLinkEndData[Uml] => x }

  /**
    * The multiplicity of the value InputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_qualifier -->
    * <!-- End of user code doc for validate_multiplicity_of_qualifier -->
    *
    * {{{
    * OCL Body value.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_qualifier: Boolean = {
    // Start of user code for "multiplicity_of_qualifier"
    ???
    // End of user code
  }

  /**
    * The qualifier must be a qualifier of the Association end of the linkEndData that owns this QualifierValue.
    *
    * <!-- Start of user code doc for validate_qualifier_attribute -->
    * <!-- End of user code doc for validate_qualifier_attribute -->
    *
    * {{{
    * OCL Body linkEndData.end.qualifier->includes(qualifier)
    * }}}
    */
  def validate_qualifier_attribute: Boolean = {
    // Start of user code for "qualifier_attribute"
    ???
    // End of user code
  }

  /**
    * The type of the value InputPin conforms to the type of the qualifier Property.
    *
    * <!-- Start of user code doc for validate_type_of_qualifier -->
    * <!-- End of user code doc for validate_type_of_qualifier -->
    *
    * {{{
    * OCL Body value.type.conformsTo(qualifier.type)
    * }}}
    */
  def validate_type_of_qualifier: Boolean = {
    // Start of user code for "type_of_qualifier"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLQualifierValueOps
