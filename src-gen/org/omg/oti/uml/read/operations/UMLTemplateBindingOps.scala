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
import scala.{Option,None,Some}
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
    signature match {
      case Some(s) => s.parameter.forall { 
        p => parameterSubstitution.filter { 
          b => b.formal match {
            case Some(f) => f == p 
            case None => false
          } 
        }.size <= 1 
      }
      case None => false
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
