package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * ParameterDirectionKind is an Enumeration that defines literals used to specify direction of parameters.
 * <!-- end-user-doc --> 
 */
object UMLParameterDirectionKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLParameterDirectionKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that Parameter values are passed in by the caller. 
 	* <!-- end-user-doc --> 
 	*/
	val in = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that Parameter values are passed in by the caller and (possibly different) values passed out to the caller.
 	* <!-- end-user-doc --> 
 	*/
	val inout = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that Parameter values are passed out to the caller.
 	* <!-- end-user-doc --> 
 	*/
	val out = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that Parameter values are passed as return values back to the caller.
 	* <!-- end-user-doc --> 
 	*/
	val _return = Value
}
