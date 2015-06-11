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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTemplateBindingOps[Uml <: UML] { self: UMLTemplateBinding[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateableElement that is bound by this TemplateBinding.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateableElement.templateBinding
	 */
	def boundElement: Option[UMLTemplateableElement[Uml]] = owner.selectByKindOf { case x: UMLTemplateableElement[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateParameterSubstitutions owned by this TemplateBinding.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTemplateParameterSubstitution.templateBinding
	 */
	def parameterSubstitution: Set[UMLTemplateParameterSubstitution[Uml]] = ownedElement.selectByKindOf { case x: UMLTemplateParameterSubstitution[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateSignature for the template that is the target of this TemplateBinding.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.signature_templateBinding
	 */
	def signature: Option[UMLTemplateSignature[Uml]] = target.selectByKindOf { case x: UMLTemplateSignature[Uml] => x } headOption

	/**
	 * <!-- begin-model-doc -->
	 * A TemplateBiinding contains at most one TemplateParameterSubstitution for each formal TemplateParameter of the target TemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @body signature.parameter->forAll(p | parameterSubstitution->select(b | b.formal = p)->size() <= 1)
	 */
	def validate_one_parameter_substitution: Boolean  = {
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
	 * <!-- begin-model-doc -->
	 * Each parameterSubstitution must refer to a formal TemplateParameter of the target TemplateSignature.
	 * <!-- end-model-doc -->
	 *
	 * @body parameterSubstitution->forAll(b | signature.parameter->includes(b.formal))
	 */
	def validate_parameter_substitution_formal: Boolean  = {
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

} //UMLTemplateBinding
