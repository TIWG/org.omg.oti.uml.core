package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * AggregationKind is an Enumeration for specifying the kind of aggregation of a Property.
 * <!-- end-user-doc --> 
 */
object UMLAggregationKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLAggregationKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that the Property has no aggregation.
 	* <!-- end-user-doc --> 
 	*/
	val none = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that the Property has shared aggregation.
 	* <!-- end-user-doc --> 
 	*/
	val shared = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that the Property is aggregated compositely, i.e., the composite object has responsibility for the existence and storage of the composed objects (parts).
 	* <!-- end-user-doc --> 
 	*/
	val composite = Value
}
