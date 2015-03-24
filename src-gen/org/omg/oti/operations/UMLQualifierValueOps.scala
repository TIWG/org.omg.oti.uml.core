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
 * A QualifierValue is an Element that is used as part of LinkEndData to provide the value for a single qualifier of the end given by the LinkEndData.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLQualifierValueOps[Uml <: UML] { self: UMLQualifierValue[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLLinkEndData.qualifier
	 */
	def qualifier_linkEndData: Option[UMLLinkEndData[Uml]] = owner.selectByKindOf { case x: UMLLinkEndData[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The multiplicity of the value InputPin is 1..1.
	 * <!-- end-model-doc -->
	 *
	 * @body value.is(1,1)
	 */
	def validate_multiplicity_of_qualifier: Boolean  = {
		// Start of user code for "multiplicity_of_qualifier"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The qualifier must be a qualifier of the Association end of the linkEndData that owns this QualifierValue.
	 * <!-- end-model-doc -->
	 *
	 * @body linkEndData.end.qualifier->includes(qualifier)
	 */
	def validate_qualifier_attribute: Boolean  = {
		// Start of user code for "qualifier_attribute"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type of the value InputPin conforms to the type of the qualifier Property.
	 * <!-- end-model-doc -->
	 *
	 * @body value.type.conformsTo(qualifier.type)
	 */
	def validate_type_of_qualifier: Boolean  = {
		// Start of user code for "type_of_qualifier"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLQualifierValue
