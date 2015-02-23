package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * InteractionOperatorKind is an enumeration designating the different kinds of operators of CombinedFragments. The InteractionOperand defines the type of operator of a CombinedFragment.
 * <!-- end-user-doc --> 
 */
object UMLInteractionOperatorKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLInteractionOperatorKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind seq designates that the CombinedFragment represents a weak sequencing between the behaviors of the operands.
 	* <!-- end-user-doc --> 
 	*/
	val seq = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind alt designates that the CombinedFragment represents a choice of behavior. At most one of the operands will be chosen. The chosen operand must have an explicit or implicit guard expression that evaluates to true at this point in the interaction. An implicit true guard is implied if the operand has no guard.
 	* <!-- end-user-doc --> 
 	*/
	val alt = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind opt designates that the CombinedFragment represents a choice of behavior where either the (sole) operand happens or nothing happens. An option is semantically equivalent to an alternative CombinedFragment where there is one operand with non-empty content and the second operand is empty.
 	* <!-- end-user-doc --> 
 	*/
	val opt = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind break designates that the CombinedFragment represents a breaking scenario in the sense that the operand is a scenario that is performed instead of the remainder of the enclosing InteractionFragment. A break operator with a guard is chosen when the guard is true and the rest of the enclosing Interaction Fragment is ignored. When the guard of the break operand is false, the break operand is ignored and the rest of the enclosing InteractionFragment is chosen. The choice between a break operand without a guard and the rest of the enclosing InteractionFragment is done non-deterministically.
 	* <!-- end-user-doc --> 
 	*/
	val break = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind par designates that the CombinedFragment represents a parallel merge between the behaviors of the operands. The OccurrenceSpecifications of the different operands can be interleaved in any way as long as the ordering imposed by each operand as such is preserved.
 	* <!-- end-user-doc --> 
 	*/
	val par = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind strict designates that the CombinedFragment represents a strict sequencing between the behaviors of the operands. The semantics of strict sequencing defines a strict ordering of the operands on the first level within the CombinedFragment with interactionOperator strict. Therefore OccurrenceSpecifications within contained CombinedFragment will not directly be compared with other OccurrenceSpecifications of the enclosing CombinedFragment.
 	* <!-- end-user-doc --> 
 	*/
	val strict = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind loop designates that the CombinedFragment represents a loop. The loop operand will be repeated a number of times.
 	* <!-- end-user-doc --> 
 	*/
	val loop = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind critical designates that the CombinedFragment represents a critical region. A critical region means that the traces of the region cannot be interleaved by other OccurrenceSpecifications (on those Lifelines covered by the region). This means that the region is treated atomically by the enclosing fragment when determining the set of valid traces. Even though enclosing CombinedFragments may imply that some OccurrenceSpecifications may interleave into the region, such as with par-operator, this is prevented by defining a region.
 	* <!-- end-user-doc --> 
 	*/
	val critical = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind neg designates that the CombinedFragment represents traces that are defined to be invalid.
 	* <!-- end-user-doc --> 
 	*/
	val neg = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind assert designates that the CombinedFragment represents an assertion. The sequences of the operand of the assertion are the only valid continuations. All other continuations result in an invalid trace.
 	* <!-- end-user-doc --> 
 	*/
	val assert = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind ignore designates that there are some message types that are not shown within this combined fragment. These message types can be considered insignificant and are implicitly ignored if they appear in a corresponding execution. Alternatively, one can understand ignore to mean that the message types that are ignored can appear anywhere in the traces.
 	* <!-- end-user-doc --> 
 	*/
	val ignore = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The InteractionOperatorKind consider designates which messages should be considered within this combined fragment. This is equivalent to defining every other message to be ignored.
 	* <!-- end-user-doc --> 
 	*/
	val consider = Value
}
