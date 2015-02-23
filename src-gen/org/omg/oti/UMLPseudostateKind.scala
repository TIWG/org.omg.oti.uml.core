package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * PseudostateKind is an Enumeration type that is used to differentiate various kinds of Pseudostates.
 * <!-- end-user-doc --> 
 */
object UMLPseudostateKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLPseudostateKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val initial = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val deepHistory = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val shallowHistory = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val join = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val fork = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val junction = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val choice = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val entryPoint = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val exitPoint = Value

	/**
 	* <!-- begin-user-doc --> 
 	* 
 	* <!-- end-user-doc --> 
 	*/
	val terminate = Value
}
