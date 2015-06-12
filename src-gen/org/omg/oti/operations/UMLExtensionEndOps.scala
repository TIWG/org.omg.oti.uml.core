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
 * An extension end is used to tie an extension to a stereotype when extending a metaclass.The default multiplicity of an extension end is 0..1.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLExtensionEndOps[Uml <: UML] { self: UMLExtensionEnd[Uml] =>	

	import self.ops._

	/**
	 * This redefinition changes the default multiplicity of association ends, since model elements are usually extended by 0 or 1 instance of the extension stereotype.
	 *
	 * <!-- Start of user code doc for lower -->
	 * <!-- End of user code doc for lower -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	override def lower: Integer = {
		// Start of user code for "lower"
	    ???
	    // End of user code
	}

	/**
	 * <!-- Start of user code doc for ownedEnd_extension -->
	 * <!-- End of user code doc for ownedEnd_extension -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLExtension.ownedEnd
	 */
	def ownedEnd_extension: Option[UMLExtension[Uml]] = owningAssociation.selectByKindOf { case x: UMLExtension[Uml] => x }

	/**
	 * The query lowerBound() returns the lower bound of the multiplicity as an Integer. This is a redefinition of the default lower bound, which normally, for MultiplicityElements, evaluates to 1 if empty.
	 *
	 * <!-- Start of user code doc for lowerBound -->
	 * <!-- End of user code doc for lowerBound -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (if lowerValue=null then 0 else lowerValue.integerValue() endif)
	 */
	override def lowerBound: Option[Integer] = {
		// Start of user code for "lowerBound"
    	???
    	// End of user code
	}

	/**
	 * The aggregation of an ExtensionEnd is composite.
	 *
	 * <!-- Start of user code doc for validate_aggregation -->
	 * <!-- End of user code doc for validate_aggregation -->
	 *
	 * @body self.aggregation = AggregationKind::composite
	 */
	def validate_aggregation: Boolean = {
		// Start of user code for "aggregation"
    	???
    	// End of user code
	}

	/**
	 * The multiplicity of ExtensionEnd is 0..1 or 1.
	 *
	 * <!-- Start of user code doc for validate_multiplicity -->
	 * <!-- End of user code doc for validate_multiplicity -->
	 *
	 * @body (lowerBound() = 0 or lowerBound() = 1) and upperBound() = 1
	 */
	def validate_multiplicity: Boolean = {
		// Start of user code for "multiplicity"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code
} //UMLExtensionEndOps
