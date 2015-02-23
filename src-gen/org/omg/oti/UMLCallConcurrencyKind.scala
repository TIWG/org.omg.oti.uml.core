package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * CallConcurrencyKind is an Enumeration used to specify the semantics of concurrent calls to a BehavioralFeature.
 * <!-- end-user-doc --> 
 */
object UMLCallConcurrencyKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLCallConcurrencyKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* No concurrency management mechanism is associated with the BehavioralFeature and, therefore, concurrency conflicts may occur. Instances that invoke a BehavioralFeature need to coordinate so that only one invocation to a target on any BehavioralFeature occurs at once.
 	* <!-- end-user-doc --> 
 	*/
	val sequential = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Multiple invocations of a BehavioralFeature that overlap in time may occur to one instance, but only one is allowed to commence. The others are blocked until the performance of the currently executing BehavioralFeature is complete. It is the responsibility of the system designer to ensure that deadlocks do not occur due to simultaneous blocking.
 	* <!-- end-user-doc --> 
 	*/
	val guarded = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Multiple invocations of a BehavioralFeature that overlap in time may occur to one instance and all of them may proceed concurrently.
 	* <!-- end-user-doc --> 
 	*/
	val concurrent = Value
}
