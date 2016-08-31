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
import scala.language.postfixOps
import scala.Boolean
import scala.{Option,None,Some}
import scala.collection.immutable.Set
// End of user code

/**
  * A BehavioredClassifier may have InterfaceRealizations, and owns a set of Behaviors one of which may specify the behavior of the BehavioredClassifier itself.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLBehavioredClassifierOps[Uml <: UML] { self: UMLBehavioredClassifier[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A Behavior that specifies the behavior of the BehavioredClassifier itself.
    *
    * <!-- Start of user code doc for classifierBehavior -->
    * <!-- End of user code doc for classifierBehavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.classifierBehavior_behavioredClassifier
    */
  def classifierBehavior: Option[UMLBehavior[Uml]] = ownedBehavior headOption

  /**
    * The set of InterfaceRealizations owned by the BehavioredClassifier. Interface realizations reference the Interfaces of which the BehavioredClassifier is an implementation.
    *
    * <!-- Start of user code doc for interfaceRealization -->
    * <!-- End of user code doc for interfaceRealization -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInterfaceRealization.implementingClassifier
    */
  def interfaceRealization: Set[UMLInterfaceRealization[Uml]] = ownedElement.selectByKindOf { case x: UMLInterfaceRealization[Uml] => x }

  /**
    * Behaviors owned by a BehavioredClassifier.
    *
    * <!-- Start of user code doc for ownedBehavior -->
    * <!-- End of user code doc for ownedBehavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.ownedBehavior_behavioredClassifier
    */
  def ownedBehavior: Set[UMLBehavior[Uml]] = ownedMember.selectByKindOf { case x: UMLBehavior[Uml] => x }

  /**
    * <!-- Start of user code doc for context_behavior -->
    * <!-- End of user code doc for context_behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.context
    */
  def context_behavior: Set[UMLBehavior[Uml]] = redefinitionContext_redefinableElement.selectByKindOf { case x: UMLBehavior[Uml] => x }

  /**
    * If a behavior is classifier behavior, it does not have a specification.
    *
    * <!-- Start of user code doc for validate_class_behavior -->
    * <!-- End of user code doc for validate_class_behavior -->
    *
    * {{{
    * OCL Body classifierBehavior->notEmpty() implies classifierBehavior.specification->isEmpty()
    * }}}
    */
  def validate_class_behavior: Boolean = {
    // Start of user code for "class_behavior"
    classifierBehavior match {
      case None     => true
      case Some(cb) => cb.specification.isEmpty
    }
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLBehavioredClassifierOps
