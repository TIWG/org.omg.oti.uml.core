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
import scala.Option
import scala.collection.immutable.Set
// End of user code

/**
  * An ExecutableNode is an abstract class for ActivityNodes whose execution may be controlled using ControlFlows and to which ExceptionHandlers may be attached.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExecutableNodeOps[Uml <: UML] { self: UMLExecutableNode[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A set of ExceptionHandlers that are examined if an exception propagates out of the ExceptionNode.
    *
    * <!-- Start of user code doc for handler -->
    * <!-- End of user code doc for handler -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExceptionHandler.protectedNode
    */
  def handler: Set[UMLExceptionHandler[Uml]] = ownedElement.selectByKindOf { case x: UMLExceptionHandler[Uml] => x }

  /**
    * <!-- Start of user code doc for executableNode_sequenceNode -->
    * <!-- End of user code doc for executableNode_sequenceNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSequenceNode.executableNode
    */
  def executableNode_sequenceNode: Option[UMLSequenceNode[Uml]] = inStructuredNode.selectByKindOf { case x: UMLSequenceNode[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLExecutableNodeOps
