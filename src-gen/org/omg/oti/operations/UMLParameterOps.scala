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
 * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLParameterOps[Uml <: UML] { self: UMLParameter[Uml] =>	

	import self.ops._

	/**
	 * A String that represents a value to be used when no argument is supplied for the Parameter.
	 *
	 * <!-- Start of user code doc for default -->
	 * <!-- End of user code doc for default -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @body result = (if self.type = String then defaultValue.stringValue() else null endif)
	 */
	def default: Option[String] = {
		// Start of user code for "default"
	    ???
	    // End of user code
	}

	/**
	 * The Operation owning this parameter.
	 *
	 * <!-- Start of user code doc for operation -->
	 * <!-- End of user code doc for operation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOperation.ownedParameter
	 */
	def operation: Option[UMLOperation[Uml]] = ownedParameter_ownerFormalParam.selectByKindOf { case x: UMLOperation[Uml] => x }

	/**
	 * <!-- Start of user code doc for ownedParameter_behavior -->
	 * <!-- End of user code doc for ownedParameter_behavior -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.ownedParameter
	 */
	def ownedParameter_behavior: Option[UMLBehavior[Uml]] = namespace.selectByKindOf { case x: UMLBehavior[Uml] => x }

	/**
	 * <!-- Start of user code doc for ownedParameter_ownerFormalParam -->
	 * <!-- End of user code doc for ownedParameter_ownerFormalParam -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioralFeature.ownedParameter
	 */
	def ownedParameter_ownerFormalParam: Option[UMLBehavioralFeature[Uml]] = namespace.selectByKindOf { case x: UMLBehavioralFeature[Uml] => x }

	/**
	 * A Parameter may only be associated with a Connector end within the context of a Collaboration.
	 *
	 * <!-- Start of user code doc for validate_connector_end -->
	 * <!-- End of user code doc for validate_connector_end -->
	 *
	 * @body end->notEmpty() implies collaboration->notEmpty()
	 */
	def validate_connector_end: Boolean = {
		// Start of user code for "connector_end"
    	???
    	// End of user code
	}

	/**
	 * Only in and inout Parameters may have a delete effect. Only out, inout, and return Parameters may have a create effect.
	 *
	 * <!-- Start of user code doc for validate_in_and_out -->
	 * <!-- End of user code doc for validate_in_and_out -->
	 *
	 * @body (effect = ParameterEffectKind::delete implies (direction = ParameterDirectionKind::_'in' or direction = ParameterDirectionKind::inout))
	 * and
	 * (effect = ParameterEffectKind::create implies (direction = ParameterDirectionKind::out or direction = ParameterDirectionKind::inout or direction = ParameterDirectionKind::return))
	 */
	def validate_in_and_out: Boolean = {
		// Start of user code for "in_and_out"
    	???
    	// End of user code
	}

	/**
	 * An input Parameter cannot be an exception.
	 *
	 * <!-- Start of user code doc for validate_not_exception -->
	 * <!-- End of user code doc for validate_not_exception -->
	 *
	 * @body isException implies (direction <> ParameterDirectionKind::_'in' and direction <> ParameterDirectionKind::inout)
	 */
	def validate_not_exception: Boolean = {
		// Start of user code for "not_exception"
    	???
    	// End of user code
	}

	/**
	 * Parameters typed by DataTypes cannot have an effect.
	 *
	 * <!-- Start of user code doc for validate_object_effect -->
	 * <!-- End of user code doc for validate_object_effect -->
	 *
	 * @body (type.oclIsKindOf(DataType)) implies (effect = null)
	 */
	def validate_object_effect: Boolean = {
		// Start of user code for "object_effect"
    	???
    	// End of user code
	}

	/**
	 * Reentrant behaviors cannot have stream Parameters.
	 *
	 * <!-- Start of user code doc for validate_reentrant_behaviors -->
	 * <!-- End of user code doc for validate_reentrant_behaviors -->
	 *
	 * @body (isStream and behavior <> null) implies not behavior.isReentrant
	 */
	def validate_reentrant_behaviors: Boolean = {
		// Start of user code for "reentrant_behaviors"
    	???
    	// End of user code
	}

	/**
	 * A Parameter cannot be a stream and exception at the same time.
	 *
	 * <!-- Start of user code doc for validate_stream_and_exception -->
	 * <!-- End of user code doc for validate_stream_and_exception -->
	 *
	 * @body not (isException and isStream)
	 */
	def validate_stream_and_exception: Boolean = {
		// Start of user code for "stream_and_exception"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLParameterOps
