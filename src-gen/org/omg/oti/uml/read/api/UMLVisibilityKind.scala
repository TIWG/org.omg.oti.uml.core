/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.api

import scala.Enumeration

/**
 * VisibilityKind is an enumeration type that defines literals to determine the visibility of Elements in a model.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
object UMLVisibilityKind extends Enumeration {
	
	/**
	 * The enumeration type
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	type UMLVisibilityKind = Value

	/**
 	 * A NamedElement with package visibility is visible to all Elements within the nearest enclosing Package (given that other owning Elements have proper visibility). Outside the nearest enclosing Package, a NamedElement marked as having package visibility is not visible.  Only NamedElements that are not owned by Packages can be marked as having package visibility. 
	 *
	 * <!-- Start of user code doc for _package -->
   * <!-- End of user code doc for _package -->
 	 */
	val _package = Value

	/**
 	 * A NamedElement with private visibility is only visible inside the Namespace that owns it.
	 *
	 * <!-- Start of user code doc for _private -->
   * <!-- End of user code doc for _private -->
 	 */
	val _private = Value

	/**
 	 * A NamedElement with protected visibility is visible to Elements that have a generalization relationship to the Namespace that owns it.
	 *
	 * <!-- Start of user code doc for _protected -->
   * <!-- End of user code doc for _protected -->
 	 */
	val _protected = Value

	/**
 	 * A Named Element with public visibility is visible to all elements that can access the contents of the Namespace that owns it.
	 *
	 * <!-- Start of user code doc for public -->
   * <!-- End of user code doc for public -->
 	 */
	val public = Value
}
