package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * ConnectorKind is an enumeration that defines whether a Connector is an assembly or a delegation.
 * <!-- end-user-doc --> 
 */
object UMLConnectorKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLConnectorKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that the Connector is an assembly Connector.
 	* <!-- end-user-doc --> 
 	*/
	val assembly = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that the Connector is a delegation Connector.
 	* <!-- end-user-doc --> 
 	*/
	val delegation = Value
}
