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
  * A Reception is a declaration stating that a Classifier is prepared to react to the receipt of a Signal.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLReceptionOps[Uml <: UML] { self: UMLReception[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for ownedReception_class -->
    * <!-- End of user code doc for ownedReception_class -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.ownedReception
    */
  def ownedReception_class: Option[UMLClass[Uml]] = featuringClassifier.selectByKindOf { case x: UMLClass[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedReception_interface -->
    * <!-- End of user code doc for ownedReception_interface -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.ownedReception
    */
  def ownedReception_interface: Option[UMLInterface[Uml]] = featuringClassifier.selectByKindOf { case x: UMLInterface[Uml] => x }

  /**
    * A Reception has the same name as its signal
    *
    * <!-- Start of user code doc for validate_same_name_as_signal -->
    * <!-- End of user code doc for validate_same_name_as_signal -->
    *
    * {{{
    * OCL Body name = signal.name
    * }}}
    */
  def validate_same_name_as_signal: Boolean = {
    // Start of user code for "same_name_as_signal"
    ???
    // End of user code
  }

  /**
    * A Reception's parameters match the ownedAttributes of its signal by name, type, and multiplicity
    *
    * <!-- Start of user code doc for validate_same_structure_as_signal -->
    * <!-- End of user code doc for validate_same_structure_as_signal -->
    *
    * {{{
    * OCL Body signal.ownedAttribute->size() = ownedParameter->size() and
    * Sequence{1..signal.ownedAttribute->size()}->forAll( i | 
    *     ownedParameter->at(i).direction = ParameterDirectionKind::_'in' and 
    *     ownedParameter->at(i).name = signal.ownedAttribute->at(i).name and
    *     ownedParameter->at(i).type = signal.ownedAttribute->at(i).type and
    *     ownedParameter->at(i).lower() = signal.ownedAttribute->at(i).lower() and
    *     ownedParameter->at(i).upper() = signal.ownedAttribute->at(i).upper()
    * )
    * }}}
    */
  def validate_same_structure_as_signal: Boolean = {
    // Start of user code for "same_structure_as_signal"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLReceptionOps