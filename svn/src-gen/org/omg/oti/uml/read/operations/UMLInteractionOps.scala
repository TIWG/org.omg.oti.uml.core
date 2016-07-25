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
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * An Interaction is a unit of Behavior that focuses on the observable exchange of information between connectable elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionOps[Uml <: UML] { self: UMLInteraction[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Actions owned by the Interaction.
    *
    * <!-- Start of user code doc for action -->
    * <!-- End of user code doc for action -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.action_interaction
    */
  def action: Set[UMLAction[Uml]] = ownedElement.selectByKindOf { case x: UMLAction[Uml] => x }

  /**
    * Specifies the gates that form the message interface between this Interaction and any InteractionUses which reference it.
    *
    * <!-- Start of user code doc for formalGate -->
    * <!-- End of user code doc for formalGate -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGate.formalGate_interaction
    */
  def formalGate: Set[UMLGate[Uml]] = ownedMember.selectByKindOf { case x: UMLGate[Uml] => x }

  /**
    * Specifies the participants in this Interaction.
    *
    * <!-- Start of user code doc for lifeline -->
    * <!-- End of user code doc for lifeline -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLifeline.interaction
    */
  def lifeline: Set[UMLLifeline[Uml]] = ownedMember.selectByKindOf { case x: UMLLifeline[Uml] => x }

  /**
    * The Messages contained in this Interaction.
    *
    * <!-- Start of user code doc for message -->
    * <!-- End of user code doc for message -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLMessage.interaction
    */
  def message: Set[UMLMessage[Uml]] = ownedMember.selectByKindOf { case x: UMLMessage[Uml] => x }

  /**
    * An Interaction instance must not be contained within another Interaction instance.
    *
    * <!-- Start of user code doc for validate_not_contained -->
    * <!-- End of user code doc for validate_not_contained -->
    *
    * {{{
    * OCL Body enclosingInteraction->isEmpty()
    * }}}
    */
  def validate_not_contained: Boolean = {
    // Start of user code for "not_contained"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInteractionOps
