package org.omg.oti

/**
 * <!-- begin-user-doc --> 
 * VisibilityKind is an enumeration type that defines literals to determine the visibility of Elements in a model.
 * <!-- end-user-doc --> 
 */
object UMLVisibilityKind extends Enumeration {
	
	/**
	 * The enumeration type
	 */
	type UMLVisibilityKind = Value

	/**
 	* <!-- begin-user-doc --> 
 	* A Named Element with public visibility is visible to all elements that can access the contents of the Namespace that owns it.
 	* <!-- end-user-doc --> 
 	*/
	val public = Value

	/**
 	* <!-- begin-user-doc --> 
 	* A NamedElement with private visibility is only visible inside the Namespace that owns it.
 	* <!-- end-user-doc --> 
 	*/
	val _private = Value

	/**
 	* <!-- begin-user-doc --> 
 	* A NamedElement with protected visibility is visible to Elements that have a generalization relationship to the Namespace that owns it.
 	* <!-- end-user-doc --> 
 	*/
	val _protected = Value

	/**
 	* <!-- begin-user-doc --> 
 	* A NamedElement with package visibility is visible to all Elements within the nearest enclosing Package (given that other owning Elements have proper visibility). Outside the nearest enclosing Package, a NamedElement marked as having package visibility is not visible.  Only NamedElements that are not owned by Packages can be marked as having package visibility. 
 	* <!-- end-user-doc --> 
 	*/
	val _package = Value
}
