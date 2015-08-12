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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api.{UML, UMLStructuralFeatureAction, UMLInputPin}

import scala.language.postfixOps
// End of user code

/**
 * StructuralFeatureAction is an abstract class for all Actions that operate on StructuralFeatures.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLStructuralFeatureActionOps[Uml <: UML] { self: UMLStructuralFeatureAction[Uml] =>

  import self.ops._

  /**
   * The InputPin from which the object whose StructuralFeature is to be read or written is obtained.
   *
   * <!-- Start of user code doc for _object -->
   * <!-- End of user code doc for _object -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
   * @opposite org.omg.oti.api.UMLInputPin.object_structuralFeatureAction
   */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
   * The multiplicity of the object InputPin must be 1..1.
   *
   * <!-- Start of user code doc for validate_multiplicity_of_object -->
   * <!-- End of user code doc for validate_multiplicity_of_object -->
   *
   * @body object.is(1,1)
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
   * @body not structuralFeature.isStatic
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
   * @body object.type.oclAsType(Classifier).allFeatures()->includes(structuralFeature) or
   *   object.type.conformsTo(structuralFeature.oclAsType(Property).opposite.type)
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
   * @body structuralFeature.featuringClassifier->size() = 1
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
   * @body structuralFeature.visibility = VisibilityKind::public or
   * _'context'.allFeatures()->includes(structuralFeature) or
   * structuralFeature.visibility=VisibilityKind::protected and
   * _'context'.conformsTo(structuralFeature.oclAsType(Property).opposite.type.oclAsType(Classifier))
   */
  def validate_visibility: Boolean = {
    // Start of user code for "visibility"
      ???
      // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStructuralFeatureActionOps
