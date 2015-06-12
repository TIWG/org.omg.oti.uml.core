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
 * A TemplateParameter exposes a ParameterableElement as a formal parameter of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTemplateParameterOps[Uml <: UML] { self: UMLTemplateParameter[Uml] =>	

	import self.ops._

	/**
	 * The ParameterableElement that is owned by this TemplateParameter for the purpose of providing a default.
	 *
	 * <!-- Start of user code doc for ownedDefault -->
	 * <!-- End of user code doc for ownedDefault -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.ownedDefault_templateParameter
	 */
	def ownedDefault: Option[UMLParameterableElement[Uml]] = default

	/**
	 * The TemplateSignature that owns this TemplateParameter.
	 *
	 * <!-- Start of user code doc for signature -->
	 * <!-- End of user code doc for signature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateSignature.ownedParameter
	 */
	def signature: Option[UMLTemplateSignature[Uml]] = owner.selectByKindOf { case x: UMLTemplateSignature[Uml] => x }

	/**
	 * <!-- Start of user code doc for inheritedParameter_redefinableTemplateSignature -->
	 * <!-- End of user code doc for inheritedParameter_redefinableTemplateSignature -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRedefinableTemplateSignature.inheritedParameter
	 */
	def inheritedParameter_redefinableTemplateSignature: Set[UMLRedefinableTemplateSignature[Uml]] = {
		// Start of user code for "redefinableTemplateSignature"
		???
		// End of user code
	}

	/**
	 * The default must be compatible with the formal TemplateParameter.
	 *
	 * <!-- Start of user code doc for validate_must_be_compatible -->
	 * <!-- End of user code doc for validate_must_be_compatible -->
	 *
	 * @body default <> null implies default.isCompatibleWith(parameteredElement)
	 */
	def validate_must_be_compatible: Boolean = {
		// Start of user code for "must_be_compatible"
  	default match {
      case Some(d) => d.isCompatibleWith(parameteredElement)
      case None => true
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
      sig.template match {
        case None => None
        case Some( t ) =>
          t match {
            case tns: UMLNamespace[Uml] => Some( tns )
            case _ => None
          }
      }
  }
  // End of user code
} //UMLTemplateParameterOps
