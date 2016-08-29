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
import scala.{Option,None,Some}
// End of user code

/**
  * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateParameterOps[Uml <: UML] { self: UMLTemplateParameter[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The ParameterableElement that is owned by this TemplateParameter for the purpose of providing a default.
    *
    * <!-- Start of user code doc for ownedDefault -->
    * <!-- End of user code doc for ownedDefault -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterableElement.ownedDefault_templateParameter
    */
  def ownedDefault: Option[UMLParameterableElement[Uml]] = default

  /**
    * The TemplateSignature that owns this TemplateParameter.
    *
    * <!-- Start of user code doc for signature -->
    * <!-- End of user code doc for signature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateSignature.ownedParameter
    */
  def signature: Option[UMLTemplateSignature[Uml]] = owner.selectByKindOf { case x: UMLTemplateSignature[Uml] => x }

  /**
    * The default must be compatible with the formal TemplateParameter.
    *
    * <!-- Start of user code doc for validate_must_be_compatible -->
    * <!-- End of user code doc for validate_must_be_compatible -->
    *
    * {{{
    * OCL Body default <> null implies default.isCompatibleWith(parameteredElement)
    * }}}
    */
  def validate_must_be_compatible: Boolean = {
    // Start of user code for "must_be_compatible"
    default.fold[Boolean](true) {
      d => d.isCompatibleWith(parameteredElement)
    }
    // End of user code
  }

  // Start of user code for additional features

  /**
   * Helper for UML 2.5, 7.8 NamedElement::allNamespaces
   */
  def getTemplateSignatureNamespace: Option[UMLNamespace[Uml]] =
    signature match {
    case None => None
    case Some( sig ) =>
      sig.template.fold[Option[UMLNamespace[Uml]]](None) {
        t =>
          t match {
            case tns: UMLNamespace[Uml] => Some( tns )
            case _ => None
          }
      }
  }
  // End of user code
} //UMLTemplateParameterOps
