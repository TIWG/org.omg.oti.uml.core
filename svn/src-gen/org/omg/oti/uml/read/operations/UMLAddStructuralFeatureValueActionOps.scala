/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
