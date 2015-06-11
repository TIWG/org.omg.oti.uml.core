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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
import javax.lang.model.element.NestingKind
// End of user code

/**
 * <!-- begin-model-doc -->
 * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLBehaviorOps[Uml <: UML] { self: UMLBehavior[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The BehavioredClassifier that is the context for the execution of the Behavior. A Behavior that is directly owned as a nestedClassifier does not have a context. Otherwise, to determine the context of a Behavior, find the first BehavioredClassifier reached by following the chain of owner relationships from the Behavior, if any. If there is such a BehavioredClassifier, then it is the context, unless it is itself a Behavior with a non-empty context, in which case that is also the context for the original Behavior. For example, following this algorithm, the context of an entry Behavior in a StateMachine is the BehavioredClassifier that owns the StateMachine. The features of the context BehavioredClassifier as well as the Elements visible to the context Classifier are visible to the Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioredClassifier.context_behavior
	 * @body result = (if nestingClass <> null then
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
	 */
	def context: Option[UMLBehavioredClassifier[Uml]] = {
		// Start of user code for "context"
	  if (nestedClassifier_nestingClass.isEmpty) {
      self.behavioredClassifier(self.owner) match {
        case Some(b: UMLBehavior[Uml]) => 
          if (b.context.isDefined) {
            b.context
          } else Some(b)
      }
    } else None
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterSets owned by this Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameterSet.ownedParameterSet_behavior
	 */
	def ownedParameterSet: Set[UMLParameterSet[Uml]] = ownedMember.selectByKindOf { case x: UMLParameterSet[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLTransition.effect
	 */
	def effect_transition: Option[UMLTransition[Uml]] = owner.selectByKindOf { case x: UMLTransition[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The first BehavioredClassifier reached by following the chain of owner relationships from the Behavior, if any.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body if from.oclIsKindOf(BehavioredClassifier) then
	 *     from.oclAsType(BehavioredClassifier)
	 * else if from.owner = null then
	 *     null
	 * else
	 *     self.behavioredClassifier(from.owner)
	 * endif
	 * endif
	 *     
	 */
	def behavioredClassifier(from: Option[UMLElement[Uml]]): Option[UMLBehavioredClassifier[Uml]]  = {
		// Start of user code for "behavioredClassifier"
    from match {
      case Some(bc: UMLBehavioredClassifier[Uml]) => Some(bc)
      case Some(f) => 
        if (f.owner.isDefined) {
          self.behavioredClassifier(f.owner)
        } else None
      case _ => None
    }
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The in and inout ownedParameters of the Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (ownedParameter->select(direction=ParameterDirectionKind::_'in' or direction=ParameterDirectionKind::inout))
	 */
	def inputParameters: Seq[UMLParameter[Uml]]  = {
		// Start of user code for "inputParameters"
    	ownedParameter.filter { op => 
        op.direction == UMLParameterDirectionKind.in || 
        op.direction == UMLParameterDirectionKind.inout
      }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The out, inout and return ownedParameters.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (ownedParameter->select(direction=ParameterDirectionKind::out or direction=ParameterDirectionKind::inout or direction=ParameterDirectionKind::return))
	 */
	def outputParameters: Seq[UMLParameter[Uml]]  = {
		// Start of user code for "outputParameters"
    	ownedParameter.filter { op => 
        op.direction == UMLParameterDirectionKind.out ||
        op.direction == UMLParameterDirectionKind.inout ||
        op.direction == UMLParameterDirectionKind._return }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The specification BehavioralFeature must be a feature (possibly inherited) of the context BehavioredClassifier of the Behavior.
	 * <!-- end-model-doc -->
	 *
	 * @body _'context'.feature->includes(specification)
	 */
	def validate_feature_of_context_classifier: Boolean  = {
		// Start of user code for "feature_of_context_classifier"
    (context, specification) match {
      case ( Some(c), Some(s) ) => c.feature.contains(s)
      case _ => false
    }
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * There may be at most one Behavior for a given pairing of BehavioredClassifier (as owner of the Behavior) and BehavioralFeature (as specification of the Behavior).
	 * <!-- end-model-doc -->
	 *
	 * @body specification <> null implies _'context'.ownedBehavior->select(specification=self.specification)->size() = 1
	 */
	def validate_most_one_behavior: Boolean  = {
		// Start of user code for "most_one_behavior"
    (specification, context) match {
      case ( Some(s), Some(c) ) => c.ownedBehavior.filter { ob => ob.specification == s }.size == 1
      case ( Some(_), None ) => false
      case _ => true
    }
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If a Behavior has a specification BehavioralFeature, then it must have the same number of ownedParameters as its specification. The Behavior Parameters must also "match" the BehavioralParameter Parameters, but the exact requirements for this matching are not formalized.
	 * <!-- end-model-doc -->
	 *
	 * @body specification <> null implies ownedParameter->size() = specification.ownedParameter->size()
	 */
	def validate_parameters_match: Boolean  = {
		// Start of user code for "parameters_match"
    specification match {
      case Some(s) => ownedParameter.size == s.ownedParameter.size
      case None => true
    }	
  	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLBehavior
