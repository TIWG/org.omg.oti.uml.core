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
  * A GeneralizationSet is a PackageableElement whose instances represent sets of Generalization relationships.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGeneralizationSetOps[Uml <: UML] { self: UMLGeneralizationSet[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * Every Generalization associated with a particular GeneralizationSet must have the same general Classifier.
    *
    * <!-- Start of user code doc for validate_generalization_same_classifier -->
    * <!-- End of user code doc for validate_generalization_same_classifier -->
    *
    * {{{
    * OCL Body generalization->collect(general)->asSet()->size() <= 1
    * }}}
    */
  def validate_generalization_same_classifier: Boolean = {
    // Start of user code for "generalization_same_classifier"
    ???
    // End of user code
  }

  /**
    * The Classifier that maps to a GeneralizationSet may neither be a specific nor a general Classifier in any of the Generalization relationships defined for that GeneralizationSet. In other words, a power type may not be an instance of itself nor may its instances be its subclasses.
    *
    * <!-- Start of user code doc for validate_maps_to_generalization_set -->
    * <!-- End of user code doc for validate_maps_to_generalization_set -->
    *
    * {{{
    * OCL Body powertype <> null implies generalization->forAll( gen | 
    *     not (gen.general = powertype) and not gen.general.allParents()->includes(powertype) and not (gen.specific = powertype) and not powertype.allParents()->includes(gen.specific)
    *   )
    * }}}
    */
  def validate_maps_to_generalization_set: Boolean = {
    // Start of user code for "maps_to_generalization_set"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLGeneralizationSetOps
