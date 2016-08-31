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
import scala.{None,Some}
import scala.Predef._
// End of user code

/**
  * An AddStructuralFeatureValueAction is a WriteStructuralFeatureAction for adding values to a StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAddStructuralFeatureValueActionOps[Uml <: UML] { self: UMLAddStructuralFeatureValueAction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * AddStructuralFeatureActions adding a value to ordered StructuralFeatures must have a single InputPin for the insertion point with type UnlimitedNatural and multiplicity of 1..1 if isReplaceAll=false, and must have no Input Pin for the insertion point when the StructuralFeature is unordered.
    *
    * <!-- Start of user code doc for validate_insertAt_pin -->
    * <!-- End of user code doc for validate_insertAt_pin -->
    *
    * {{{
    * OCL Body if not structuralFeature.isOrdered then insertAt = null
    * else 
    *   not isReplaceAll implies
    *   	insertAt<>null and 
    *   	insertAt->forAll(type=UnlimitedNatural and is(1,1.oclAsType(UnlimitedNatural)))
    * endif
    * }}}
    */
  def validate_insertAt_pin: Boolean = {
    // Start of user code for "insertAt_pin"
     if (!isReplaceAll)
      insertAt != null && insertAt.forall { pin =>
        pin.is(1, 1) &&
          (pin._type match {
            case Some(t) =>
              t == UML_PRIMITIVE_TYPES_UNLIMITED_NATURAL
            case None    =>
              false
          })
      }
    else true
    // End of user code
  }

  /**
    * A value InputPin is required.
    *
    * <!-- Start of user code doc for validate_required_value -->
    * <!-- End of user code doc for validate_required_value -->
    *
    * {{{
    * OCL Body value<>null
    * }}}
    */
  def validate_required_value: Boolean = {
    // Start of user code for "required_value"
    value.isDefined
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLAddStructuralFeatureValueActionOps
