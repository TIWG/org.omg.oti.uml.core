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
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
	 * }}}
	 * {{{
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
