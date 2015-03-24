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
 * InformationItems represent many kinds of information that can flow from sources to targets in very abstract ways.? They represent the kinds of information that may move within a system, but do not elaborate details of the transferred information.? Details of transferred information are the province of other Classifiers that may ultimately define InformationItems.? Consequently, InformationItems cannot be instantiated and do not themselves have features, generalizations, or associations.?An important use of InformationItems is to represent information during early design stages, possibly before the detailed modeling decisions that will ultimately define them have been made. Another purpose of InformationItems is to abstract portions of complex models in less precise, but perhaps more general and communicable, ways. 
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInformationItemOps[Uml <: UML] { self: UMLInformationItem[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * An informationItem has no feature, no generalization, and no associations.
	 * <!-- end-model-doc -->
	 *
	 * @body self.generalization->isEmpty() and self.feature->isEmpty()
	 */
	def validate_has_no: Boolean  = {
		// Start of user code for "has_no"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * It is not instantiable.
	 * <!-- end-model-doc -->
	 *
	 * @body isAbstract
	 */
	def validate_not_instantiable: Boolean  = {
		// Start of user code for "not_instantiable"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The sources and targets of an information item (its related information flows) must designate subsets of the sources and targets of the representation information item, if any. The Classifiers that can realize an information item can only be of the following kind: Class, Interface, InformationItem, Signal, Component.
	 * <!-- end-model-doc -->
	 *
	 * @body (self.represented->select(oclIsKindOf(InformationItem))->forAll(p |
	 *   p.conveyingFlow.source->forAll(q | self.conveyingFlow.source->includes(q)) and
	 *     p.conveyingFlow.target->forAll(q | self.conveyingFlow.target->includes(q)))) and
	 *       (self.represented->forAll(oclIsKindOf(Class) or oclIsKindOf(Interface) or
	 *         oclIsKindOf(InformationItem) or oclIsKindOf(Signal) or oclIsKindOf(Component)))
	 */
	def validate_sources_and_targets: Boolean  = {
		// Start of user code for "sources_and_targets"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLInformationItem
