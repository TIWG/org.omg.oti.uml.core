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
 * A ReadLinkObjectEndQualifierAction is an Action that retrieves a qualifier end value from a link object.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLReadLinkObjectEndQualifierActionOps[Uml <: UML] { self: UMLReadLinkObjectEndQualifierAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin from which the link object is obtained.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.object_readLinkObjectEndQualifierAction
	 */
	def _object: Option[UMLInputPin[Uml]] = input headOption

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPin where the result value is placed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_readLinkObjectEndQualifierAction
	 */
	def result: Option[UMLOutputPin[Uml]] = output headOption

	/**
	 * <!-- begin-model-doc -->
	 * The association of the Association end of the qualifier Property must be an AssociationClass.
	 * <!-- end-model-doc -->
	 *
	 * @body qualifier.associationEnd.association.oclIsKindOf(AssociationClass)
	 */
	def validate_association_of_association: Boolean  = {
    	// Start of user code for "association_of_association"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The ends of the Association must not be static.
	 * <!-- end-model-doc -->
	 *
	 * @body qualifier.associationEnd.association.memberEnd->forAll(e | not e.isStatic)
	 */
	def validate_ends_of_association: Boolean  = {
    	// Start of user code for "ends_of_association"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The multiplicity of the object InputPin is 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body object.is(1,1)
	 */
	def validate_multiplicity_of_object: Boolean  = {
    	// Start of user code for "multiplicity_of_object"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The multiplicity of the qualifier Property is 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body qualifier.is(1,1)
	 */
	def validate_multiplicity_of_qualifier: Boolean  = {
    	// Start of user code for "multiplicity_of_qualifier"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The multiplicity of the result OutputPin is 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body result.is(1,1)
	 */
	def validate_multiplicity_of_result: Boolean  = {
    	// Start of user code for "multiplicity_of_result"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The qualifier Property must be a qualifier of an Association end.
	 * <!-- end-model-doc -->
	 *
	 * @body qualifier.associationEnd <> null
	 */
	def validate_qualifier_attribute: Boolean  = {
    	// Start of user code for "qualifier_attribute"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type of the result OutputPin is the same as the type of the qualifier Property.
	 * <!-- end-model-doc -->
	 *
	 * @body result.type = qualifier.type
	 */
	def validate_same_type: Boolean  = {
    	// Start of user code for "same_type"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type of the object InputPin is the AssociationClass that owns the Association end that has the given qualifier Property.
	 * <!-- end-model-doc -->
	 *
	 * @body object.type = qualifier.associationEnd.association
	 */
	def validate_type_of_object: Boolean  = {
    	// Start of user code for "type_of_object"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLReadLinkObjectEndQualifierAction
