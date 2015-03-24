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
 * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTemplateParameterSubstitutionOps[Uml <: UML] { self: UMLTemplateParameterSubstitution[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is owned by this TemplateParameterSubstitution as its actual parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLParameterableElement.ownedActual_owningTemplateParameterSubstitution
	 */
	def ownedActual: Option[UMLParameterableElement[Uml]] = actual

	/**
	 * <!-- begin-model-doc -->
	 * The TemplateBinding that owns this TemplateParameterSubstitution.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTemplateBinding.parameterSubstitution
	 */
	def templateBinding: Option[UMLTemplateBinding[Uml]] = owner.selectByKindOf { case x: UMLTemplateBinding[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The actual ParameterableElement must be compatible with the formal TemplateParameter, e.g., the actual ParameterableElement for a Class TemplateParameter must be a Class.
	 * <!-- end-model-doc -->
	 *
	 * @body actual->forAll(a | a.isCompatibleWith(formal.parameteredElement))
	 */
	def validate_must_be_compatible: Boolean  = {
		// Start of user code for "must_be_compatible"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLTemplateParameterSubstitution
