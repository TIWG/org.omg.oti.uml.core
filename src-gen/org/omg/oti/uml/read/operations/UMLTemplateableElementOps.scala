/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api._

import scala.language.postfixOps
// End of user code

/**
 * A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTemplateableElementOps[Uml <: UML] { self: UMLTemplateableElement[Uml] =>

  import self.ops._

  /**
   * The optional TemplateSignature specifying the formal TemplateParameters for this TemplateableElement.
   * If a TemplateableElement has a TemplateSignature, then it is a template.
   *
   * <!-- Start of user code doc for ownedTemplateSignature -->
   * <!-- End of user code doc for ownedTemplateSignature -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLTemplateSignature.template
   */
  def ownedTemplateSignature: Option[UMLTemplateSignature[Uml]] =
    ownedElement
    .selectByKindOf { case x: UMLTemplateSignature[Uml] => x } headOption

  /**
   * The optional TemplateBindings from this TemplateableElement to one or more templates.
   *
   * <!-- Start of user code doc for templateBinding -->
   * <!-- End of user code doc for templateBinding -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLTemplateBinding.boundElement
   */
  def templateBinding: Set[UMLTemplateBinding[Uml]] =
    ownedElement
    .selectByKindOf { case x: UMLTemplateBinding[Uml] => x }

  /**
   * The query isTemplate() returns whether this TemplateableElement is actually a template.
   *
   * <!-- Start of user code doc for isTemplate -->
   * <!-- End of user code doc for isTemplate -->
   *
   * @operation ordered="false" unique="true" multiplicity="1..1"
   * @body result = (ownedTemplateSignature <> null)
   */
  def isTemplate: Boolean = {
    // Start of user code for "isTemplate"
    ownedTemplateSignature.isDefined
    // End of user code
  }

  /**
   * The query parameterableElements() returns the set of ParameterableElements that
   * may be used as the parameteredElements for a TemplateParameter of this TemplateableElement.
   * By default, this set includes all the ownedElements. Subclasses may override this operation
   * if they choose to restrict the set of ParameterableElements.
   *
   * <!-- Start of user code doc for parameterableElements -->
   * <!-- End of user code doc for parameterableElements -->
   *
   * @operation ordered="false" unique="true" multiplicity="0..*"
   * @body result = (self.allOwnedElements()
   *      ->select(oclIsKindOf(ParameterableElement)).oclAsType(ParameterableElement)->asSet())
   */
  def parameterableElements: Set[UMLParameterableElement[Uml]] = {
    // Start of user code for "parameterableElements"
    allOwnedElements.selectByKindOf { case pe: UMLParameterableElement[Uml] => pe }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTemplateableElementOps
