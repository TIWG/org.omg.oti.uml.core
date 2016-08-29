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
import java.lang.Integer
// End of user code

/**
  * An extension end is used to tie an extension to a stereotype when extending a metaclass.The default multiplicity of an extension end is 0..1.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExtensionEndOps[Uml <: UML] { self: UMLExtensionEnd[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * This redefinition changes the default multiplicity of association ends, since model elements are usually extended by 0 or 1 instance of the extension stereotype.
    *
    * <!-- Start of user code doc for lower -->
    * <!-- End of user code doc for lower -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (if lowerValue=null then 0 else lowerValue.integerValue() endif)
    * }}}
    */
  override def lower: Integer = {
    // Start of user code for "lower"
    ???
    // End of user code
  }

  /**
    * <!-- Start of user code doc for ownedEnd_extension -->
    * <!-- End of user code doc for ownedEnd_extension -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtension.ownedEnd
    */
  def ownedEnd_extension: Option[UMLExtension[Uml]] = owningAssociation.selectByKindOf { case x: UMLExtension[Uml] => x }

  /**
    * The aggregation of an ExtensionEnd is composite.
    *
    * <!-- Start of user code doc for validate_aggregation -->
    * <!-- End of user code doc for validate_aggregation -->
    *
    * {{{
    * OCL Body self.aggregation = AggregationKind::composite
    * }}}
    */
  def validate_aggregation: Boolean = {
    // Start of user code for "aggregation"
    ???
    // End of user code
  }

  /**
    * The multiplicity of ExtensionEnd is 0..1 or 1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body (lower() = 0 or lower() = 1) and upper() = 1
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLExtensionEndOps
