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
import scala.collection.immutable.Set
import scala.Predef.???
// End of user code

/**
  * A Vertex is an abstraction of a node in a StateMachine graph. It can be the source or destination of any number of Transitions.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLVertexOps[Uml <: UML] { self: UMLVertex[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Region that contains this Vertex.
    *
    * <!-- Start of user code doc for container -->
    * <!-- End of user code doc for container -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRegion.subvertex
    */
  def container: Option[UMLRegion[Uml]] = namespace.selectByKindOf { case x: UMLRegion[Uml] => x }

  /**
    * Specifies the Transitions entering this Vertex.
    *
    * <!-- Start of user code doc for incoming -->
    * <!-- End of user code doc for incoming -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.target
    * {{{
    * OCL Body result = (Transition.allInstances()->select(target=self))
    * }}}
    */
  def incoming: Set[UMLTransition[Uml]] = {
    // Start of user code for "incoming"
    ???
    // End of user code
  }

  /**
    * Specifies the Transitions departing from this Vertex.
    *
    * <!-- Start of user code doc for outgoing -->
    * <!-- End of user code doc for outgoing -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.source
    * {{{
    * OCL Body result = (Transition.allInstances()->select(source=self))
    * }}}
    */
  def outgoing: Set[UMLTransition[Uml]] = {
    // Start of user code for "outgoing"
    ???
    // End of user code
  }

  /**
    * The operation containingStateMachine() returns the StateMachine in which this Vertex is defined.
    *
    * <!-- Start of user code doc for containingStateMachine -->
    * <!-- End of user code doc for containingStateMachine -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if container <> null
    * then
    * -- the container is a region
    *    container.containingStateMachine()
    * else 
    *    if (self.oclIsKindOf(Pseudostate)) and ((self.oclAsType(Pseudostate).kind = PseudostateKind::entryPoint) or (self.oclAsType(Pseudostate).kind = PseudostateKind::exitPoint)) then
    *       self.oclAsType(Pseudostate).stateMachine
    *    else 
    *       if (self.oclIsKindOf(ConnectionPointReference)) then
    *           self.oclAsType(ConnectionPointReference).state.containingStateMachine() -- no other valid cases possible
    *       else 
    *           null
    *       endif
    *    endif
    * endif
    * )
    * }}}
    */
  def containingStateMachine: Option[UMLStateMachine[Uml]] = {
    // Start of user code for "containingStateMachine"
    ???
    // End of user code
  }

  /**
    * This utility query returns true if the Vertex is contained in the Region r (input argument).
    *
    * <!-- Start of user code doc for isContainedInRegion -->
    * <!-- End of user code doc for isContainedInRegion -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if (container = r) then
    * 	true
    * else
    * 	if (r.state->isEmpty()) then
    * 		false
    * 	else
    * 		container.state.isContainedInRegion(r)
    * 	endif
    * endif)
    * }}}
    */
  def isContainedInRegion(r: Option[UMLRegion[Uml]]): Boolean = {
    // Start of user code for "isContainedInRegion"
    ???
    // End of user code
  }

  /**
    * This utility operation returns true if the Vertex is contained in the State s (input argument).
    *
    * <!-- Start of user code doc for isContainedInState -->
    * <!-- End of user code doc for isContainedInState -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if not s.isComposite() or container->isEmpty() then
    * 	false
    * else
    * 	if container.state = s then 
    * 		true
    * 	else
    * 		container.state.isContainedInState(s)
    * 	endif
    * endif)
    * }}}
    */
  def isContainedInState(s: Option[UMLState[Uml]]): Boolean = {
    // Start of user code for "isContainedInState"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLVertexOps
