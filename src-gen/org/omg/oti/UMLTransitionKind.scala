package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * TransitionKind is an Enumeration type used to differentiate the various kinds of Transitions.
 * <!-- end-user-doc --> 
 */
object UMLTransitionKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLTransitionKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Implies that the Transition, if triggered, occurs without exiting or entering the source State (i.e., it does not cause a state change). This means that the entry or exit condition of the source State will not be invoked. An internal Transition can be taken even if the SateMachine is in one or more Regions nested within the associated State.
 	* <!-- end-user-doc --> 
 	*/
	val internal = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Implies that the Transition, if triggered, will not exit the composite (source) State, but it will exit and re-enter any state within the composite State that is in the current state configuration.
 	* <!-- end-user-doc --> 
 	*/
	val local = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Implies that the Transition, if triggered, will exit the composite (source) State.
 	* <!-- end-user-doc --> 
 	*/
	val external = Value
}
