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
import scala.collection.immutable.Set
// End of user code

/**
  * A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTemplateableElementOps[Uml <: UML] { self: UMLTemplateableElement[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The optional TemplateSignature specifying the formal TemplateParameters for this TemplateableElement. If a TemplateableElement has a TemplateSignature, then it is a template.
    *
    * <!-- Start of user code doc for ownedTemplateSignature -->
    * <!-- End of user code doc for ownedTemplateSignature -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateSignature.template
    */
  def ownedTemplateSignature: Option[UMLTemplateSignature[Uml]] = ownedElement.selectByKindOf { case x: UMLTemplateSignature[Uml] => x } headOption

  /**
    * The optional TemplateBindings from this TemplateableElement to one or more templates.
    *
    * <!-- Start of user code doc for templateBinding -->
    * <!-- End of user code doc for templateBinding -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTemplateBinding.boundElement
    */
  def templateBinding: Set[UMLTemplateBinding[Uml]] = ownedElement.selectByKindOf { case x: UMLTemplateBinding[Uml] => x }

  /**
    * The query isTemplate() returns whether this TemplateableElement is actually a template.
    *
    * <!-- Start of user code doc for isTemplate -->
    * <!-- End of user code doc for isTemplate -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (ownedTemplateSignature <> null)
    * }}}
    */
  def isTemplate: Boolean = {
    // Start of user code for "isTemplate"
    ownedTemplateSignature.isDefined
    // End of user code
  }

  /**
    * The query parameterableElements() returns the set of ParameterableElements that may be used as the parameteredElements for a TemplateParameter of this TemplateableElement. By default, this set includes all the ownedElements. Subclasses may override this operation if they choose to restrict the set of ParameterableElements.
    *
    * <!-- Start of user code doc for parameterableElements -->
    * <!-- End of user code doc for parameterableElements -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self.allOwnedElements()->select(oclIsKindOf(ParameterableElement)).oclAsType(ParameterableElement)->asSet())
    * }}}
    */
  def parameterableElements: Set[UMLParameterableElement[Uml]] = {
    // Start of user code for "parameterableElements"
    allOwnedElements.selectByKindOf { case pe: UMLParameterableElement[Uml] => pe }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTemplateableElementOps
