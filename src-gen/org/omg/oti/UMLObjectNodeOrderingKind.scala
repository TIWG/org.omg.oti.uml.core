package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * ObjectNodeOrderingKind is an enumeration indicating queuing order for offering the tokens held by an ObjectNode.
 * <!-- end-user-doc --> 
 */
object UMLObjectNodeOrderingKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLObjectNodeOrderingKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that tokens are unordered.
 	* <!-- end-user-doc --> 
 	*/
	val unordered = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that tokens are ordered.
 	* <!-- end-user-doc --> 
 	*/
	val ordered = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that tokens are queued in a last in, first out manner.
 	* <!-- end-user-doc --> 
 	*/
	val LIFO = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that tokens are queued in a first in, first out manner.
 	* <!-- end-user-doc --> 
 	*/
	val FIFO = Value
}
