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
