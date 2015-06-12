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
 * A ParameterableElement is an Element that can be exposed as a formal TemplateParameter for a template, or specified as an actual parameter in a binding of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLParameterableElementOps[Uml <: UML] { self: UMLParameterableElement[Uml] =>	

	import self.ops._

	/**
	 * <!-- Start of user code doc for ownedActual_owningTemplateParameterSubstitution -->
	 * <!-- End of user code doc for ownedActual_owningTemplateParameterSubstitution -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTemplateParameterSubstitution.ownedActual
	 */
	def ownedActual_owningTemplateParameterSubstitution: Option[UMLTemplateParameterSubstitution[Uml]] = owner.selectByKindOf { case x: UMLTemplateParameterSubstitution[Uml] => x }

	/**
	 * <!-- Start of user code doc for ownedDefault_templateParameter -->
	 * <!-- End of user code doc for ownedDefault_templateParameter -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTemplateParameter.ownedDefault
	 */
	def ownedDefault_templateParameter: Option[UMLTemplateParameter[Uml]] = default_templateParameter headOption

	/**
	 * The query isCompatibleWith() determines if this ParameterableElement is compatible with the specified ParameterableElement. By default, this ParameterableElement is compatible with another ParameterableElement p if the kind of this ParameterableElement is the same as or a subtype of the kind of p. Subclasses of ParameterableElement should override this operation to specify different compatibility constraints.
	 *
	 * <!-- Start of user code doc for isCompatibleWith -->
	 * <!-- End of user code doc for isCompatibleWith -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (self.oclIsKindOf(p.oclType()))
	 */
	def isCompatibleWith(p: Option[UMLParameterableElement[Uml]]): Boolean = {
		// Start of user code for "isCompatibleWith"
  	??? // TODO: this depends on the OTI equivalent of OCL's "oclType()"
    // End of user code
	}

	/**
	 * The query isTemplateParameter() determines if this ParameterableElement is exposed as a formal TemplateParameter.
	 *
	 * <!-- Start of user code doc for isTemplateParameter -->
	 * <!-- End of user code doc for isTemplateParameter -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (templateParameter->notEmpty())
	 */
	def isTemplateParameter: Boolean = {
		// Start of user code for "isTemplateParameter"
  	templateParameter.isDefined
  	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLParameterableElementOps
