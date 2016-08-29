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

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Predef.???
// End of user code

/**
  * A RemoveStructuralFeatureValueAction is a WriteStructuralFeatureAction that removes values from a StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRemoveStructuralFeatureValueActionOps[Uml <: UML] { self: UMLRemoveStructuralFeatureValueAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * RemoveStructuralFeatureValueActions removing a value from ordered, non-unique StructuralFeatures must have a single removeAt InputPin and no value InputPin, if isRemoveDuplicates is false. The removeAt InputPin must be of type Unlimited Natural with multiplicity 1..1. Otherwise, the Action has a value InputPin and no removeAt InputPin.
    *
    * <!-- Start of user code doc for validate_removeAt_and_value -->
    * <!-- End of user code doc for validate_removeAt_and_value -->
    *
    * {{{
    * OCL Body if structuralFeature.isOrdered and not structuralFeature.isUnique and  not isRemoveDuplicates then
    *   value = null and
    *   removeAt <> null and
    *   removeAt.type = UnlimitedNatural and
    *   removeAt.is(1,1)
    * else
    *   removeAt = null and value <> null
    * endif
    * }}}
    */
  def validate_removeAt_and_value: Boolean = {
    // Start of user code for "removeAt_and_value"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLRemoveStructuralFeatureValueActionOps
