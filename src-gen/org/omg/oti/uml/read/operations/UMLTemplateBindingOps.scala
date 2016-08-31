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
import scala.collection.immutable.Set
// End of user code

/**
  * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateBindingOps[Uml <: UML] { self: UMLTemplateBinding[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The TemplateableElement that is bound by this TemplateBinding.
    *
    * <!-- Start of user code doc for boundElement -->
    * <!-- End of user code doc for boundElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateableElement.templateBinding
    */
  def boundElement: Option[UMLTemplateableElement[Uml]] = owner.selectByKindOf { case x: UMLTemplateableElement[Uml] => x }

  /**
    * The TemplateParameterSubstitutions owned by this TemplateBinding.
    *
    * <!-- Start of user code doc for parameterSubstitution -->
    * <!-- End of user code doc for parameterSubstitution -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameterSubstitution.templateBinding
    */
  def parameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]] = ownedElement.selectByKindOf { case x: UMLTemplateParameterSubstitution[Uml] => x }

  /**
    * The TemplateSignature for the template that is the target of this TemplateBinding.
    *
    * <!-- Start of user code doc for signature -->
    * <!-- End of user code doc for signature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateSignature.signature_templateBinding
    */
  def signature: Option[UMLTemplateSignature[Uml]] = target.selectByKindOf { case x: UMLTemplateSignature[Uml] => x } headOption

  /**
    * A TemplateBiinding contains at most one TemplateParameterSubstitution for each formal TemplateParameter of the target TemplateSignature.
    *
    * <!-- Start of user code doc for validate_one_parameter_substitution -->
    * <!-- End of user code doc for validate_one_parameter_substitution -->
    *
    * {{{
    * OCL Body signature.parameter->forAll(p | parameterSubstitution->select(b | b.formal = p)->size() <= 1)
    * }}}
    */
  def validate_one_parameter_substitution: Boolean = {
    // Start of user code for "one_parameter_substitution"
    signature.fold[Boolean](false) {
      s => s.parameter.forall {
        p => parameterSubstitution.filter { 
          b => b.formal.fold[Boolean](false) {
            f =>
              f == p
          } 
        }.size <= 1 
      }
    }
    // End of user code
  }

  /**
    * Each parameterSubstitution must refer to a formal TemplateParameter of the target TemplateSignature.
    *
    * <!-- Start of user code doc for validate_parameter_substitution_formal -->
    * <!-- End of user code doc for validate_parameter_substitution_formal -->
    *
    * {{{
    * OCL Body parameterSubstitution->forAll(b | signature.parameter->includes(b.formal))
    * }}}
    */
  def validate_parameter_substitution_formal: Boolean = {
    // Start of user code for "parameter_substitution_formal"
    signature match {
      case Some(s) => 
        parameterSubstitution.forall { b => 
          b.formal match {
            case Some(f) => s.parameter.contains(f)
            case None => false
          }
        }
      case None => false
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTemplateBindingOps
