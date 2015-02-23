package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * This is an enumerated type that identifies the type of Message.
 * <!-- end-user-doc --> 
 */
object UMLMessageKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLMessageKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* sendEvent and receiveEvent are present
 	* <!-- end-user-doc --> 
 	*/
	val complete = Value

	/**
 	* <!-- begin-user-doc --> 
 	* sendEvent present and receiveEvent absent
 	* <!-- end-user-doc --> 
 	*/
	val lost = Value

	/**
 	* <!-- begin-user-doc --> 
 	* sendEvent absent and receiveEvent present
 	* <!-- end-user-doc --> 
 	*/
	val found = Value

	/**
 	* <!-- begin-user-doc --> 
 	* sendEvent and receiveEvent absent (should not appear)
 	* <!-- end-user-doc --> 
 	*/
	val unknown = Value
}
