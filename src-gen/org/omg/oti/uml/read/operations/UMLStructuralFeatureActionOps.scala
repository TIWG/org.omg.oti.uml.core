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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * StructuralFeatureAction is an abstract class for all Actions that operate on StructuralFeatures.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuralFeatureActionOps[Uml <: UML] { self: UMLStructuralFeatureAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin from which the object whose StructuralFeature is to be read or written is obtained.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_structuralFeatureAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The multiplicity of the object InputPin must be 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_object -->
    * <!-- End of user code doc for validate_multiplicity_of_object -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_object: Boolean = {
    // Start of user code for "multiplicity_of_object"
    ???
    // End of user code
  }

  /**
    * The structuralFeature must not be static.
    *
    * <!-- Start of user code doc for validate_not_static -->
    * <!-- End of user code doc for validate_not_static -->
    *
    * {{{
    * OCL Body not structuralFeature.isStatic
    * }}}
    */
  def validate_not_static: Boolean = {
    // Start of user code for "not_static"
    ???
    // End of user code
  }

  /**
    * The structuralFeature must either be an owned or inherited feature of the type of the object InputPin, or it must be an owned end of a binary Association whose opposite end had as a type to which the type of the object InputPin conforms.
    *
    * <!-- Start of user code doc for validate_object_type -->
    * <!-- End of user code doc for validate_object_type -->
    *
    * {{{
    * OCL Body object.type.oclAsType(Classifier).allFeatures()->includes(structuralFeature) or
    * 	object.type.conformsTo(structuralFeature.oclAsType(Property).opposite.type)
    * }}}
    */
  def validate_object_type: Boolean = {
    // Start of user code for "object_type"
    ???
    // End of user code
  }

  /**
    * The structuralFeature must have exactly one featuringClassifier.
    *
    * <!-- Start of user code doc for validate_one_featuring_classifier -->
    * <!-- End of user code doc for validate_one_featuring_classifier -->
    *
    * {{{
    * OCL Body structuralFeature.featuringClassifier->size() = 1
    * }}}
    */
  def validate_one_featuring_classifier: Boolean = {
    // Start of user code for "one_featuring_classifier"
    ???
    // End of user code
  }

  /**
    * The visibility of the structuralFeature must allow access from the object performing the ReadStructuralFeatureAction.
    *
    * <!-- Start of user code doc for validate_visibility -->
    * <!-- End of user code doc for validate_visibility -->
    *
    * {{{
    * OCL Body structuralFeature.visibility = VisibilityKind::public or
    * _'context'.allFeatures()->includes(structuralFeature) or
    * structuralFeature.visibility=VisibilityKind::protected and
    * _'context'.conformsTo(structuralFeature.oclAsType(Property).opposite.type.oclAsType(Classifier))
    * }}}
    */
  def validate_visibility: Boolean = {
    // Start of user code for "visibility"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStructuralFeatureActionOps
