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
// End of user code

/**
  * An ExceptionHandler is an Element that specifies a handlerBody ExecutableNode to execute in case the specified exception occurs during the execution of the protected ExecutableNode.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExceptionHandlerOps[Uml <: UML] { self: UMLExceptionHandler[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The ExecutableNode protected by the ExceptionHandler. If an exception propagates out of the protectedNode and has a type matching one of the exceptionTypes, then it is caught by this ExceptionHandler.
    *
    * <!-- Start of user code doc for protectedNode -->
    * <!-- End of user code doc for protectedNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.handler
    */
  def protectedNode: Option[UMLExecutableNode[Uml]] = owner.selectByKindOf { case x: UMLExecutableNode[Uml] => x }

  /**
    * An ActivityEdge that has a source within the handlerBody of an ExceptionHandler must have its target in the handlerBody also, and vice versa.
    *
    * <!-- Start of user code doc for validate_edge_source_target -->
    * <!-- End of user code doc for validate_edge_source_target -->
    *
    * {{{
    * OCL Body let nodes:Set(ActivityNode) = handlerBody.oclAsType(Action).allOwnedNodes() in
    * nodes.outgoing->forAll(nodes->includes(target)) and
    * nodes.incoming->forAll(nodes->includes(source))
    * }}}
    */
  def validate_edge_source_target: Boolean = {
    // Start of user code for "edge_source_target"
    ???
    // End of user code
  }

  /**
    * The exceptionInput must either have no type or every exceptionType must conform to the exceptionInput type.
    *
    * <!-- Start of user code doc for validate_exception_input_type -->
    * <!-- End of user code doc for validate_exception_input_type -->
    *
    * {{{
    * OCL Body exceptionInput.type=null or 
    * exceptionType->forAll(conformsTo(exceptionInput.type.oclAsType(Classifier)))
    * }}}
    */
  def validate_exception_input_type: Boolean = {
    // Start of user code for "exception_input_type"
    ???
    // End of user code
  }

  /**
    * The handlerBody has no incoming or outgoing ActivityEdges and the exceptionInput has no incoming ActivityEdges.
    *
    * <!-- Start of user code doc for validate_handler_body_edges -->
    * <!-- End of user code doc for validate_handler_body_edges -->
    *
    * {{{
    * OCL Body handlerBody.incoming->isEmpty() and handlerBody.outgoing->isEmpty() and exceptionInput.incoming->isEmpty()
    * }}}
    */
  def validate_handler_body_edges: Boolean = {
    // Start of user code for "handler_body_edges"
    ???
    // End of user code
  }

  /**
    * The handlerBody must have the same owner as the protectedNode.
    *
    * <!-- Start of user code doc for validate_handler_body_owner -->
    * <!-- End of user code doc for validate_handler_body_owner -->
    *
    * {{{
    * OCL Body handlerBody.owner=protectedNode.owner
    * }}}
    */
  def validate_handler_body_owner: Boolean = {
    // Start of user code for "handler_body_owner"
    ???
    // End of user code
  }

  /**
    * The handlerBody is an Action with one InputPin, and that InputPin is the same as the exceptionInput.
    *
    * <!-- Start of user code doc for validate_one_input -->
    * <!-- End of user code doc for validate_one_input -->
    *
    * {{{
    * OCL Body handlerBody.oclIsKindOf(Action) and
    * let inputs: OrderedSet(InputPin) = handlerBody.oclAsType(Action).input in
    * inputs->size()=1 and inputs->first()=exceptionInput
    * }}}
    */
  def validate_one_input: Boolean = {
    // Start of user code for "one_input"
    ???
    // End of user code
  }

  /**
    * If the protectedNode is an Action with OutputPins, then the handlerBody must also be an Action with the same number of OutputPins, which are compatible in type, ordering, and multiplicity to those of the protectedNode.
    *
    * <!-- Start of user code doc for validate_output_pins -->
    * <!-- End of user code doc for validate_output_pins -->
    *
    * {{{
    * OCL Body (protectedNode.oclIsKindOf(Action) and protectedNode.oclAsType(Action).output->notEmpty()) implies
    * (
    *   handlerBody.oclIsKindOf(Action) and 
    *   let protectedNodeOutput : OrderedSet(OutputPin) = protectedNode.oclAsType(Action).output,
    *         handlerBodyOutput : OrderedSet(OutputPin) =  handlerBody.oclAsType(Action).output in
    *     protectedNodeOutput->size() = handlerBodyOutput->size() and
    *     Sequence{1..protectedNodeOutput->size()}->forAll(i |
    *     	handlerBodyOutput->at(i).type.conformsTo(protectedNodeOutput->at(i).type) and
    *     	handlerBodyOutput->at(i).isOrdered=protectedNodeOutput->at(i).isOrdered and
    *     	handlerBodyOutput->at(i).compatibleWith(protectedNodeOutput->at(i)))
    * )
    * }}}
    */
  def validate_output_pins: Boolean = {
    // Start of user code for "output_pins"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLExceptionHandlerOps
