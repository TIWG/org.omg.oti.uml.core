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
  * A Template Signature bundles the set of formal TemplateParameters for a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateSignatureOps[Uml <: UML] { self: UMLTemplateSignature[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The TemplateableElement that owns this TemplateSignature.
    *
    * <!-- Start of user code doc for template -->
    * <!-- End of user code doc for template -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateableElement.ownedTemplateSignature
    */
  def template: Option[UMLTemplateableElement[Uml]] = owner.selectByKindOf { case x: UMLTemplateableElement[Uml] => x }

  /**
    * <!-- Start of user code doc for signature_templateBinding -->
    * <!-- End of user code doc for signature_templateBinding -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateBinding.signature
    */
  def signature_templateBinding: Set[UMLTemplateBinding[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLTemplateBinding[Uml] => x }

  /**
    * Parameters must own the ParameterableElements they parameter or those ParameterableElements must be owned by the TemplateableElement being templated.
    *
    * <!-- Start of user code doc for validate_own_elements -->
    * <!-- End of user code doc for validate_own_elements -->
    *
    * {{{
    * OCL Body template.ownedElement->includesAll(parameter.parameteredElement->asSet() - parameter.ownedParameteredElement->asSet())
    * }}}
    */
  def validate_own_elements: Boolean = {
    // Start of user code for "own_elements"
    ??? //difference in sets
    // End of user code
  }

  /**
    * The names of the parameters of a TemplateSignature are unique.
    *
    * <!-- Start of user code doc for validate_unique_parameters -->
    * <!-- End of user code doc for validate_unique_parameters -->
    *
    * {{{
    * OCL Body parameter->forAll( p1, p2 | (p1 <> p2 and p1.parameteredElement.oclIsKindOf(NamedElement) and p2.parameteredElement.oclIsKindOf(NamedElement) ) implies
    *    p1.parameteredElement.oclAsType(NamedElement).name <> p2.parameteredElement.oclAsType(NamedElement).name)
    * }}}
    */
  def validate_unique_parameters: Boolean = {
    // Start of user code for "unique_parameters"
    val namedParameters = parameter.selectByKindOf { case ne: UMLNamedElement[Uml] => ne }
    namedParameters.size == parameter.size &&
      namedParameters.flatMap(_.name).size == parameter.size
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTemplateSignatureOps
