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
// End of user code

/**
  * A ReadLinkObjectEndAction is an Action that retrieves an end object from a link object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReadLinkObjectEndActionOps[Uml <: UML] { self: UMLReadLinkObjectEndAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The input pin from which the link object is obtained.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_readLinkObjectEndAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The OutputPin where the result value is placed.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_readLinkObjectEndAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The association of the end must be an AssociationClass.
    *
    * <!-- Start of user code doc for validate_association_of_association -->
    * <!-- End of user code doc for validate_association_of_association -->
    *
    * {{{
    * OCL Body end.association.oclIsKindOf(AssociationClass)
    * }}}
    */
  def validate_association_of_association: Boolean = {
    // Start of user code for "association_of_association"
    ???
    // End of user code
  }

  /**
    * The ends of the association must not be static.
    *
    * <!-- Start of user code doc for validate_ends_of_association -->
    * <!-- End of user code doc for validate_ends_of_association -->
    *
    * {{{
    * OCL Body end.association.memberEnd->forAll(e | not e.isStatic)
    * }}}
    */
  def validate_ends_of_association: Boolean = {
    // Start of user code for "ends_of_association"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the object InputPin is 1..1.
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
    * The multiplicity of the result OutputPin is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_result -->
    * <!-- End of user code doc for validate_multiplicity_of_result -->
    *
    * {{{
    * OCL Body result.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_result: Boolean = {
    // Start of user code for "multiplicity_of_result"
    ???
    // End of user code
  }

  /**
    * The end Property must be an Association memberEnd.
    *
    * <!-- Start of user code doc for validate_property -->
    * <!-- End of user code doc for validate_property -->
    *
    * {{{
    * OCL Body end.association <> null
    * }}}
    */
  def validate_property: Boolean = {
    // Start of user code for "property"
    ???
    // End of user code
  }

  /**
    * The type of the object InputPin is the AssociationClass that owns the end Property.
    *
    * <!-- Start of user code doc for validate_type_of_object -->
    * <!-- End of user code doc for validate_type_of_object -->
    *
    * {{{
    * OCL Body object.type = end.association
    * }}}
    */
  def validate_type_of_object: Boolean = {
    // Start of user code for "type_of_object"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin is the same as the type of the end Property.
    *
    * <!-- Start of user code doc for validate_type_of_result -->
    * <!-- End of user code doc for validate_type_of_result -->
    *
    * {{{
    * OCL Body result.type = end.type
    * }}}
    */
  def validate_type_of_result: Boolean = {
    // Start of user code for "type_of_result"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReadLinkObjectEndActionOps
