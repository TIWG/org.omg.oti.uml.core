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
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
  * An UnmarshallAction is an Action that retrieves the values of the StructuralFeatures of an object and places them on OutputPins. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLUnmarshallActionOps[Uml <: UML] { self: UMLUnmarshallAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that gives the object to be unmarshalled.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_unmarshallAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The multiplicity of the object InputPin is 1..1
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
    * The number of result outputPins must be the same as the number of attributes of the unmarshallType.
    *
    * <!-- Start of user code doc for validate_number_of_result -->
    * <!-- End of user code doc for validate_number_of_result -->
    *
    * {{{
    * OCL Body unmarshallType.allAttributes()->size() = result->size()
    * }}}
    */
  def validate_number_of_result: Boolean = {
    // Start of user code for "number_of_result"
    ???
    // End of user code
  }

  /**
    * The type of the object InputPin conform to the unmarshallType.
    *
    * <!-- Start of user code doc for validate_object_type -->
    * <!-- End of user code doc for validate_object_type -->
    *
    * {{{
    * OCL Body object.type.conformsTo(unmarshallType)
    * }}}
    */
  def validate_object_type: Boolean = {
    // Start of user code for "object_type"
    ???
    // End of user code
  }

  /**
    * The unmarshallType must have at least one StructuralFeature.
    *
    * <!-- Start of user code doc for validate_structural_feature -->
    * <!-- End of user code doc for validate_structural_feature -->
    *
    * {{{
    * OCL Body unmarshallType.allAttributes()->size() >= 1
    * }}}
    */
  def validate_structural_feature: Boolean = {
    // Start of user code for "structural_feature"
    ???
    // End of user code
  }

  /**
    * The type, ordering and multiplicity of each attribute of the unmarshallType must be compatible with the type, ordering and multiplicity of the corresponding result OutputPin.
    *
    * <!-- Start of user code doc for validate_type_ordering_and_multiplicity -->
    * <!-- End of user code doc for validate_type_ordering_and_multiplicity -->
    *
    * {{{
    * OCL Body let attribute:OrderedSet(Property) = unmarshallType.allAttributes() in
    * Sequence{1..result->size()}->forAll(i | 
    * 	attribute->at(i).type.conformsTo(result->at(i).type) and
    * 	attribute->at(i).isOrdered=result->at(i).isOrdered and
    * 	attribute->at(i).compatibleWith(result->at(i)))
    * }}}
    */
  def validate_type_ordering_and_multiplicity: Boolean = {
    // Start of user code for "type_ordering_and_multiplicity"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLUnmarshallActionOps