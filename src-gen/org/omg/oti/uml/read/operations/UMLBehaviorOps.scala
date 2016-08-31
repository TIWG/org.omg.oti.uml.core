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
import scala.{Option,None,Some}
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code

/**
  * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLBehaviorOps[Uml <: UML] { self: UMLBehavior[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The BehavioredClassifier that is the context for the execution of the Behavior. A Behavior that is directly owned as a nestedClassifier does not have a context. Otherwise, to determine the context of a Behavior, find the first BehavioredClassifier reached by following the chain of owner relationships from the Behavior, if any. If there is such a BehavioredClassifier, then it is the context, unless it is itself a Behavior with a non-empty context, in which case that is also the context for the original Behavior. For example, following this algorithm, the context of an entry Behavior in a StateMachine is the BehavioredClassifier that owns the StateMachine. The features of the context BehavioredClassifier as well as the Elements visible to the context Classifier are visible to the Behavior.
    *
    * <!-- Start of user code doc for context -->
    * <!-- End of user code doc for context -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioredClassifier.context_behavior
    * {{{
    * OCL Body result = (if nestingClass <> null then
    *     null
    * else
    *     let b:BehavioredClassifier = self.behavioredClassifier(self.owner) in
    *     if b.oclIsKindOf(Behavior) and b.oclAsType(Behavior)._'context' <> null then 
    *         b.oclAsType(Behavior)._'context'
    *     else 
    *         b 
    *     endif
    * endif
    *         )
    * }}}
    */
  def context: Option[UMLBehavioredClassifier[Uml]] = {
    // Start of user code for "context"
    if (nestedClassifier_nestingClass.isEmpty) {
      self.behavioredClassifier(self.owner) match {
        case Some(b: UMLBehavior[Uml]) => b.context.orElse(Some(b))
        case _                         => None
      }
    } else
      None
    // End of user code
  }

  /**
    * The ParameterSets owned by this Behavior.
    *
    * <!-- Start of user code doc for ownedParameterSet -->
    * <!-- End of user code doc for ownedParameterSet -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterSet.ownedParameterSet_behavior
    */
  def ownedParameterSet: Set[UMLParameterSet[Uml]] = ownedMember.selectByKindOf { case x: UMLParameterSet[Uml] => x }

  /**
    * <!-- Start of user code doc for classifierBehavior_behavioredClassifier -->
    * <!-- End of user code doc for classifierBehavior_behavioredClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavioredClassifier.classifierBehavior
    */
  def classifierBehavior_behavioredClassifier: Option[UMLBehavioredClassifier[Uml]] = ownedBehavior_behavioredClassifier

  /**
    * <!-- Start of user code doc for effect_transition -->
    * <!-- End of user code doc for effect_transition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.effect
    */
  def effect_transition: Option[UMLTransition[Uml]] = owner.selectByKindOf { case x: UMLTransition[Uml] => x }

  /**
    * The first BehavioredClassifier reached by following the chain of owner relationships from the Behavior, if any.
    *
    * <!-- Start of user code doc for behavioredClassifier -->
    * <!-- End of user code doc for behavioredClassifier -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body if from.oclIsKindOf(BehavioredClassifier) then
    *     from.oclAsType(BehavioredClassifier)
    * else if from.owner = null then
    *     null
    * else
    *     self.behavioredClassifier(from.owner)
    * endif
    * endif
    *     
    * }}}
    */
  def behavioredClassifier(from: Option[UMLElement[Uml]]): Option[UMLBehavioredClassifier[Uml]] = {
    // Start of user code for "behavioredClassifier"
    from match {
      case Some(bc: UMLBehavioredClassifier[Uml]) => Some(bc)
      case Some(f)                                =>
        if (f.owner.isDefined)
          self.behavioredClassifier(f.owner)
        else
          None
      case _                                      => None
    }
    // End of user code
  }

  /**
    * The in and inout ownedParameters of the Behavior.
    *
    * <!-- Start of user code doc for inputParameters -->
    * <!-- End of user code doc for inputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (ownedParameter->select(direction=ParameterDirectionKind::_'in' or direction=ParameterDirectionKind::inout))
    * }}}
    */
  def inputParameters: Seq[UMLParameter[Uml]] = {
    // Start of user code for "inputParameters"
    ownedParameter
    .filter(_.direction match {
              case _@(UMLParameterDirectionKind.in | UMLParameterDirectionKind.inout) => true
              case _                                                                  => false
            })
    // End of user code
  }

  /**
    * The out, inout and return ownedParameters.
    *
    * <!-- Start of user code doc for outputParameters -->
    * <!-- End of user code doc for outputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (ownedParameter->select(direction=ParameterDirectionKind::out or direction=ParameterDirectionKind::inout or direction=ParameterDirectionKind::return))
    * }}}
    */
  def outputParameters: Seq[UMLParameter[Uml]] = {
    // Start of user code for "outputParameters"
    ownedParameter
    .filter(_.direction match {
              case UMLParameterDirectionKind.in => false
              case _                            => true
            })
    // End of user code
  }

  /**
    * The specification BehavioralFeature must be a feature (possibly inherited) of the context BehavioredClassifier of the Behavior.
    *
    * <!-- Start of user code doc for validate_feature_of_context_classifier -->
    * <!-- End of user code doc for validate_feature_of_context_classifier -->
    *
    * {{{
    * OCL Body _'context'.feature->includes(specification)
    * }}}
    */
  def validate_feature_of_context_classifier: Boolean = {
    // Start of user code for "feature_of_context_classifier"
    (context, specification) match {
      case (Some(c), Some(s)) => c.feature.contains(s)
      case _                  => false
    }
    // End of user code
  }

  /**
    * There may be at most one Behavior for a given pairing of BehavioredClassifier (as owner of the Behavior) and BehavioralFeature (as specification of the Behavior).
    *
    * <!-- Start of user code doc for validate_most_one_behavior -->
    * <!-- End of user code doc for validate_most_one_behavior -->
    *
    * {{{
    * OCL Body specification <> null implies _'context'.ownedBehavior->select(specification=self.specification)->size() = 1
    * }}}
    */
  def validate_most_one_behavior: Boolean = {
    // Start of user code for "most_one_behavior"
    (specification, context) match {
      case (Some(_), Some(c)) => c.ownedBehavior.count { ob => ob.specification == self.specification } == 1
      case (Some(_), None)    => false
      case _                  => true
    }
    // End of user code
  }

  /**
    * If a Behavior has a specification BehavioralFeature, then it must have the same number of ownedParameters as its specification. The Behavior Parameters must also "match" the BehavioralParameter Parameters, but the exact requirements for this matching are not formalized.
    *
    * <!-- Start of user code doc for validate_parameters_match -->
    * <!-- End of user code doc for validate_parameters_match -->
    *
    * {{{
    * OCL Body specification <> null implies ownedParameter->size() = specification.ownedParameter->size()
    * }}}
    */
  def validate_parameters_match: Boolean = {
    // Start of user code for "parameters_match"
    specification match {
      case Some(s) => ownedParameter.size == s.ownedParameter.size
      case None    => true
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLBehaviorOps
