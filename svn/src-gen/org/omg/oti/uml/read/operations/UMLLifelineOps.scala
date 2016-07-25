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
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A Lifeline represents an individual participant in the Interaction. While parts and structural features may have multiplicity greater than 1, Lifelines represent only one interacting entity.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLifelineOps[Uml <: UML] { self: UMLLifeline[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * References the Interaction enclosing this Lifeline.
    *
    * <!-- Start of user code doc for interaction -->
    * <!-- End of user code doc for interaction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteraction.lifeline
    */
  def interaction: Option[UMLInteraction[Uml]] = namespace.selectByKindOf { case x: UMLInteraction[Uml] => x }

  /**
    * <!-- Start of user code doc for covered_stateInvariant -->
    * <!-- End of user code doc for covered_stateInvariant -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStateInvariant.covered
    */
  def covered_stateInvariant: Set[UMLStateInvariant[Uml]] = coveredBy.selectByKindOf { case x: UMLStateInvariant[Uml] => x }

  /**
    * If a lifeline is in an Interaction referred to by an InteractionUse in an enclosing Interaction,  and that lifeline is common with another lifeline in an Interaction referred to by another InteractonUse within that same enclosing Interaction, it must be common to a lifeline within that enclosing Interaction. By common Lifelines we mean Lifelines with the same selector and represents associations.
    *
    * <!-- Start of user code doc for validate_interaction_uses_share_lifeline -->
    * <!-- End of user code doc for validate_interaction_uses_share_lifeline -->
    *
    * {{{
    * OCL Body let intUses : Set(InteractionUse) = interaction.interactionUse  in 
    * intUses->forAll
    * ( iuse : InteractionUse | 
    * let usingInteraction : Set(Interaction)  = iuse.enclosingInteraction->asSet()
    * ->union(
    * iuse.enclosingOperand.combinedFragment->asSet()->closure(enclosingOperand.combinedFragment).enclosingInteraction->asSet()
    *                ) 
    * in
    * let peerUses : Set(InteractionUse) = usingInteraction.fragment->select(oclIsKindOf(InteractionUse)).oclAsType(InteractionUse)->asSet()
    * ->union(
    * usingInteraction.fragment->select(oclIsKindOf(CombinedFragment)).oclAsType(CombinedFragment)->asSet()
    * ->closure(operand.fragment->select(oclIsKindOf(CombinedFragment)).oclAsType(CombinedFragment)).operand.fragment->
    * select(oclIsKindOf(InteractionUse)).oclAsType(InteractionUse)->asSet()
    *                )->excluding(iuse)
    *  in
    * peerUses->forAll( peerUse : InteractionUse |
    *  peerUse.refersTo.lifeline->forAll( l : Lifeline | (l.represents = self.represents and 
    *  ( self.selector.oclIsKindOf(LiteralString) implies
    *   l.selector.oclIsKindOf(LiteralString) and 
    *   self.selector.oclAsType(LiteralString).value = l.selector.oclAsType(LiteralString).value )
    *   and 
    * ( self.selector.oclIsKindOf(LiteralInteger) implies
    *   l.selector.oclIsKindOf(LiteralInteger) and 
    *   self.selector.oclAsType(LiteralInteger).value = l.selector.oclAsType(LiteralInteger).value )
    * )  
    * implies
    *  usingInteraction.lifeline->select(represents = self.represents and
    *  ( self.selector.oclIsKindOf(LiteralString) implies
    *   l.selector.oclIsKindOf(LiteralString) and 
    *   self.selector.oclAsType(LiteralString).value = l.selector.oclAsType(LiteralString).value )
    * and 
    * ( self.selector.oclIsKindOf(LiteralInteger) implies
    *   l.selector.oclIsKindOf(LiteralInteger) and 
    *   self.selector.oclAsType(LiteralInteger).value = l.selector.oclAsType(LiteralInteger).value )
    * )
    *                                                 )
    *                     )
    * )
    * }}}
    */
  def validate_interaction_uses_share_lifeline: Boolean = {
    // Start of user code for "interaction_uses_share_lifeline"
    ???
    // End of user code
  }

  /**
    * The classifier containing the referenced ConnectableElement must be the same classifier, or an ancestor, of the classifier that contains the interaction enclosing this lifeline.
    *
    * <!-- Start of user code doc for validate_same_classifier -->
    * <!-- End of user code doc for validate_same_classifier -->
    *
    * {{{
    * OCL Body represents.namespace->closure(namespace)->includes(interaction._'context')
    * }}}
    */
  def validate_same_classifier: Boolean = {
    // Start of user code for "same_classifier"
    ???
    // End of user code
  }

  /**
    * The selector value, if present, must be a LiteralString or a LiteralInteger 
    *
    * <!-- Start of user code doc for validate_selector_int_or_string -->
    * <!-- End of user code doc for validate_selector_int_or_string -->
    *
    * {{{
    * OCL Body self.selector->notEmpty() implies 
    * self.selector.oclIsKindOf(LiteralInteger) or 
    * self.selector.oclIsKindOf(LiteralString)
    * }}}
    */
  def validate_selector_int_or_string: Boolean = {
    // Start of user code for "selector_int_or_string"
    ???
    // End of user code
  }

  /**
    * The selector for a Lifeline must only be specified if the referenced Part is multivalued.
    *
    * <!-- Start of user code doc for validate_selector_specified -->
    * <!-- End of user code doc for validate_selector_specified -->
    *
    * {{{
    * OCL Body  self.selector->notEmpty() = (self.represents.oclIsKindOf(MultiplicityElement) and self.represents.oclAsType(MultiplicityElement).isMultivalued())
    * }}}
    */
  def validate_selector_specified: Boolean = {
    // Start of user code for "selector_specified"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLLifelineOps
