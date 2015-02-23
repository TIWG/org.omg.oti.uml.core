package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * ParameterEffectKind is an Enumeration that indicates the effect of a Behavior on values passed in or out of its parameters.
 * <!-- end-user-doc --> 
 */
object UMLParameterEffectKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLParameterEffectKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates that the behavior creates values.
 	* <!-- end-user-doc --> 
 	*/
	val create = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classifiers retrieved during executions of the behavior.
 	* <!-- end-user-doc --> 
 	*/
	val read = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates objects that are values of the parameter have values of their properties, or links in which they participate, or their classification changed during executions of the behavior.
 	* <!-- end-user-doc --> 
 	*/
	val update = Value

	/**
 	* <!-- begin-user-doc --> 
 	* Indicates objects that are values of the parameter do not exist after executions of the behavior are finished.
 	* <!-- end-user-doc --> 
 	*/
	val delete = Value
}
