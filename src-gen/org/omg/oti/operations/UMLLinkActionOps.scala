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
 * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLLinkActionOps[Uml <: UML] { self: UMLLinkAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The LinkEndData identifying the values on the ends of the links acting on by this LinkAction.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
	 * @opposite org.omg.oti.api.UMLLinkEndData.endData_linkAction
	 */
	def endData: Iterable[UMLLinkEndData[Uml]] = ownedElement.selectByKindOf { case x: UMLLinkEndData[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * InputPins used by the LinkEndData of the LinkAction.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLInputPin.inputValue_linkAction
	 */
	def inputValue: Set[UMLInputPin[Uml]] = input.toSet[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Returns the Association acted on by this LinkAction.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (endData->asSequence()->first().end.association)
	 */
	def association: Option[UMLAssociation[Uml]]  = {
		// Start of user code for "association"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The ends of the endData must not be static.
	 * <!-- end-model-doc -->
	 *
	 * @body endData->forAll(not end.isStatic)
	 */
	def validate_not_static: Boolean  = {
		// Start of user code for "not_static"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The ends of the endData must all be from the same Association and include all and only the memberEnds of that association.
	 * <!-- end-model-doc -->
	 *
	 * @body endData.end = self.association().memberEnd->asBag()
	 */
	def validate_same_association: Boolean  = {
		// Start of user code for "same_association"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The inputValue InputPins is the same as the union of all the InputPins referenced by the endData.
	 * <!-- end-model-doc -->
	 *
	 * @body inputValue->asBag()=endData.allPins()
	 */
	def validate_same_pins: Boolean  = {
		// Start of user code for "same_pins"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLLinkAction
