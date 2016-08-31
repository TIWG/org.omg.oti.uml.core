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
  * A ParameterableElement is an Element that can be exposed as a formal TemplateParameter for a template, or specified as an actual parameter in a binding of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLParameterableElementOps[Uml <: UML] { self: UMLParameterableElement[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for ownedActual_owningTemplateParameterSubstitution -->
    * <!-- End of user code doc for ownedActual_owningTemplateParameterSubstitution -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameterSubstitution.ownedActual
    */
  def ownedActual_owningTemplateParameterSubstitution: Option[UMLTemplateParameterSubstitution[Uml]] = owner.selectByKindOf { case x: UMLTemplateParameterSubstitution[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedDefault_templateParameter -->
    * <!-- End of user code doc for ownedDefault_templateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateParameter.ownedDefault
    */
  def ownedDefault_templateParameter: Option[UMLTemplateParameter[Uml]] = default_templateParameter headOption

  /**
    * The query isCompatibleWith() determines if this ParameterableElement is compatible with the specified ParameterableElement. By default, this ParameterableElement is compatible with another ParameterableElement p if the kind of this ParameterableElement is the same as or a subtype of the kind of p. Subclasses of ParameterableElement should override this operation to specify different compatibility constraints.
    *
    * <!-- Start of user code doc for isCompatibleWith -->
    * <!-- End of user code doc for isCompatibleWith -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (self.oclIsKindOf(p.oclType()))
    * }}}
    */
  def isCompatibleWith(p: Option[UMLParameterableElement[Uml]]): Boolean = {
    // Start of user code for "isCompatibleWith"
    ???
    // End of user code
  }

  /**
    * The query isTemplateParameter() determines if this ParameterableElement is exposed as a formal TemplateParameter.
    *
    * <!-- Start of user code doc for isTemplateParameter -->
    * <!-- End of user code doc for isTemplateParameter -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (templateParameter->notEmpty())
    * }}}
    */
  def isTemplateParameter: Boolean = {
    // Start of user code for "isTemplateParameter"
    templateParameter.isDefined
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLParameterableElementOps
