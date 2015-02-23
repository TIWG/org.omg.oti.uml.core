package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * ExpansionKind is an enumeration type used to specify how an ExpansionRegion executes its contents.
 * <!-- end-user-doc --> 
 */
object UMLExpansionKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLExpansionKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The content of the ExpansionRegion is executed concurrently for the elements of the input collections.
 	* <!-- end-user-doc --> 
 	*/
	val parallel = Value

	/**
 	* <!-- begin-user-doc --> 
 	* The content of the ExpansionRegion is executed iteratively for the elements of the input collections, in the order of the input elements, if the collections are ordered.
 	* <!-- end-user-doc --> 
 	*/
	val iterative = Value

	/**
 	* <!-- begin-user-doc --> 
 	* A stream of input collection elements flows into a single execution of the content of the ExpansionRegion, in the order of the collection elements if the input collections are ordered.
 	* <!-- end-user-doc --> 
 	*/
	val stream = Value
}
