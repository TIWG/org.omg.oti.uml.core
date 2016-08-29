/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
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
