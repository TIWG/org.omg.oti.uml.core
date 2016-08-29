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
import scala.{Option,Some}
// End of user code

/**
  * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateParameterSubstitutionOps[Uml <: UML] { self: UMLTemplateParameterSubstitution[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The ParameterableElement that is owned by this TemplateParameterSubstitution as its actual parameter.
    *
    * <!-- Start of user code doc for ownedActual -->
    * <!-- End of user code doc for ownedActual -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterableElement.ownedActual_owningTemplateParameterSubstitution
    */
  def ownedActual: Option[UMLParameterableElement[Uml]] = actual

  /**
    * The TemplateBinding that owns this TemplateParameterSubstitution.
    *
    * <!-- Start of user code doc for templateBinding -->
    * <!-- End of user code doc for templateBinding -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateBinding.parameterSubstitution
    */
  def templateBinding: Option[UMLTemplateBinding[Uml]] = owner.selectByKindOf { case x: UMLTemplateBinding[Uml] => x }

  /**
    * The actual ParameterableElement must be compatible with the formal TemplateParameter, e.g., the actual ParameterableElement for a Class TemplateParameter must be a Class.
    *
    * <!-- Start of user code doc for validate_must_be_compatible -->
    * <!-- End of user code doc for validate_must_be_compatible -->
    *
    * {{{
    * OCL Body actual->forAll(a | a.isCompatibleWith(formal.parameteredElement))
    * }}}
    */
  def validate_must_be_compatible: Boolean = {
    // Start of user code for "must_be_compatible"
    ( actual, formal ) match {
      case ( Some(a), Some(f) ) => a.isCompatibleWith(f.parameteredElement)
      case _ => false
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTemplateParameterSubstitutionOps
