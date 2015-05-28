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
// End of user code

/**
 * <!-- begin-model-doc -->
 * An Action is the fundamental unit of executable functionality. The execution of an Action represents some transformation or processing in the modeled system. Actions provide the ExecutableNodes within Activities and may also be used within Interactions.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActionOps[Uml <: UML] { self: UMLAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The context Classifier of the Behavior that contains this Action, or the Behavior itself if it has no context.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.context_action
	 * @body result = (let behavior: Behavior = self.containingBehavior() in
	 * if behavior=null then null
	 * else if behavior._'context' = null then behavior
	 * else behavior._'context'
	 * endif
	 * endif)
	 */
	def context: Option[UMLClassifier[Uml]] = {
		// Start of user code for "context"
    self.containingBehavior match {
      case None => None
      case Some(behavior) => behavior.context match {
        case None => Some( behavior )
        case Some(_) => behavior.context
      }
    }
    // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteraction.action
	 */
	def action_interaction: Option[UMLInteraction[Uml]] = owner.selectByKindOf { case x: UMLInteraction[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActionInputPin.fromAction
	 */
	def fromAction_actionInputPin: Option[UMLActionInputPin[Uml]] = owner.selectByKindOf { case x: UMLActionInputPin[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Return this Action and all Actions contained directly or indirectly in it. By default only the Action itself is returned, but the operation is overridden for StructuredActivityNodes.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self->asSet())
	 */
	def allActions: Set[UMLAction[Uml]]  = {
		// Start of user code for "allActions"
    Set(self)
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * Returns all the ActivityNodes directly or indirectly owned by this Action. This includes at least all the Pins of the Action.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (input.oclAsType(Pin)->asSet()->union(output->asSet()))
	 */
	def allOwnedNodes: Set[UMLActivityNode[Uml]]  = {
		// Start of user code for "allOwnedNodes"
    input.toSet.union(output.toSet)
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (if inStructuredNode<>null then inStructuredNode.containingBehavior() 
	 * else if activity<>null then activity
	 * else interaction 
	 * endif
	 * endif
	 * )
	 */
	def containingBehavior: Option[UMLBehavior[Uml]]  = {
		// Start of user code for "containingBehavior"
  	if (inStructuredNode.isDefined)
      inStructuredNode.get.containingBehavior
    else if (activity.isDefined) 
      activity
    else action_interaction
  	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLAction
