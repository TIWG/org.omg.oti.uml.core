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
package org.omg.oti.api

/**
 * <!-- begin-model-doc --> 
 * InteractionOperatorKind is an enumeration designating the different kinds of operators of CombinedFragments. The InteractionOperand defines the type of operator of a CombinedFragment.
 * <!-- end-model-doc --> 
 */
object UMLInteractionOperatorKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLInteractionOperatorKind = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind alt designates that the CombinedFragment represents a choice of behavior. At most one of the operands will be chosen. The chosen operand must have an explicit or implicit guard expression that evaluates to true at this point in the interaction. An implicit true guard is implied if the operand has no guard.
 	* <!-- end-model-doc --> 
 	*/
	val alt = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind assert designates that the CombinedFragment represents an assertion. The sequences of the operand of the assertion are the only valid continuations. All other continuations result in an invalid trace.
 	* <!-- end-model-doc --> 
 	*/
	val assert = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind break designates that the CombinedFragment represents a breaking scenario in the sense that the operand is a scenario that is performed instead of the remainder of the enclosing InteractionFragment. A break operator with a guard is chosen when the guard is true and the rest of the enclosing Interaction Fragment is ignored. When the guard of the break operand is false, the break operand is ignored and the rest of the enclosing InteractionFragment is chosen. The choice between a break operand without a guard and the rest of the enclosing InteractionFragment is done non-deterministically.
 	* <!-- end-model-doc --> 
 	*/
	val break = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind consider designates which messages should be considered within this combined fragment. This is equivalent to defining every other message to be ignored.
 	* <!-- end-model-doc --> 
 	*/
	val consider = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind critical designates that the CombinedFragment represents a critical region. A critical region means that the traces of the region cannot be interleaved by other OccurrenceSpecifications (on those Lifelines covered by the region). This means that the region is treated atomically by the enclosing fragment when determining the set of valid traces. Even though enclosing CombinedFragments may imply that some OccurrenceSpecifications may interleave into the region, such as with par-operator, this is prevented by defining a region.
 	* <!-- end-model-doc --> 
 	*/
	val critical = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind ignore designates that there are some message types that are not shown within this combined fragment. These message types can be considered insignificant and are implicitly ignored if they appear in a corresponding execution. Alternatively, one can understand ignore to mean that the message types that are ignored can appear anywhere in the traces.
 	* <!-- end-model-doc --> 
 	*/
	val ignore = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind loop designates that the CombinedFragment represents a loop. The loop operand will be repeated a number of times.
 	* <!-- end-model-doc --> 
 	*/
	val loop = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind neg designates that the CombinedFragment represents traces that are defined to be invalid.
 	* <!-- end-model-doc --> 
 	*/
	val neg = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind opt designates that the CombinedFragment represents a choice of behavior where either the (sole) operand happens or nothing happens. An option is semantically equivalent to an alternative CombinedFragment where there is one operand with non-empty content and the second operand is empty.
 	* <!-- end-model-doc --> 
 	*/
	val opt = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind par designates that the CombinedFragment represents a parallel merge between the behaviors of the operands. The OccurrenceSpecifications of the different operands can be interleaved in any way as long as the ordering imposed by each operand as such is preserved.
 	* <!-- end-model-doc --> 
 	*/
	val par = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind seq designates that the CombinedFragment represents a weak sequencing between the behaviors of the operands.
 	* <!-- end-model-doc --> 
 	*/
	val seq = Value

	/**
 	* <!-- begin-model-doc --> 
 	* The InteractionOperatorKind strict designates that the CombinedFragment represents a strict sequencing between the behaviors of the operands. The semantics of strict sequencing defines a strict ordering of the operands on the first level within the CombinedFragment with interactionOperator strict. Therefore OccurrenceSpecifications within contained CombinedFragment will not directly be compared with other OccurrenceSpecifications of the enclosing CombinedFragment.
 	* <!-- end-model-doc --> 
 	*/
	val strict = Value
}
