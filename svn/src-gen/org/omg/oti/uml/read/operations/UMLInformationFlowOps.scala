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
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * InformationFlows describe circulation of information through a system in a general manner. They do not specify the nature of the information, mechanisms by which it is conveyed, sequences of exchange or any control conditions. During more detailed modeling, representation and realization links may be added to specify which model elements implement an InformationFlow and to show how information is conveyed.  InformationFlows require some kind of ?information channel? for unidirectional transmission of information items from sources to targets.? They specify the information channel?s realizations, if any, and identify the information that flows along them.? Information moving along the information channel may be represented by abstract InformationItems and by concrete Classifiers.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInformationFlowOps[Uml <: UML] { self: UMLInformationFlow[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Defines from which source the conveyed InformationItems are initiated.
    *
    * <!-- Start of user code doc for informationSource -->
    * <!-- End of user code doc for informationSource -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.informationSource_informationFlow
    */
  def informationSource: Set[UMLNamedElement[Uml]] = source.selectByKindOf { case x: UMLNamedElement[Uml] => x }

  /**
    * Defines to which target the conveyed InformationItems are directed.
    *
    * <!-- Start of user code doc for informationTarget -->
    * <!-- End of user code doc for informationTarget -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.informationTarget_informationFlow
    */
  def informationTarget: Set[UMLNamedElement[Uml]] = target.selectByKindOf { case x: UMLNamedElement[Uml] => x }

  /**
    * An information flow can only convey classifiers that are allowed to represent an information item.
    *
    * <!-- Start of user code doc for validate_convey_classifiers -->
    * <!-- End of user code doc for validate_convey_classifiers -->
    *
    * {{{
    * OCL Body self.conveyed->forAll(oclIsKindOf(Class) or oclIsKindOf(Interface)
    *   or oclIsKindOf(InformationItem) or oclIsKindOf(Signal) or oclIsKindOf(Component))
    * }}}
    */
  def validate_convey_classifiers: Boolean = {
    // Start of user code for "convey_classifiers"
    ???
    // End of user code
  }

  /**
    * The sources and targets of the information flow must conform to the sources and targets or conversely the targets and sources of the realization relationships.
    *
    * <!-- Start of user code doc for validate_must_conform -->
    * <!-- End of user code doc for validate_must_conform -->
    *
    * {{{
    * }}}
    */
  def validate_must_conform: Boolean = {
    // Start of user code for "must_conform"
    ???
    // End of user code
  }

  /**
    * The sources and targets of the information flow can only be one of the following kind: Actor, Node, UseCase, Artifact, Class, Component, Port, Property, Interface, Package, ActivityNode, ActivityPartition,
    * Behavior and InstanceSpecification except when its classifier is a relationship (i.e. it represents a link).
    *
    * <!-- Start of user code doc for validate_sources_and_targets_kind -->
    * <!-- End of user code doc for validate_sources_and_targets_kind -->
    *
    * {{{
    * OCL Body (self.informationSource->forAll( sis |
    *   oclIsKindOf(Actor) or oclIsKindOf(Node) or oclIsKindOf(UseCase) or oclIsKindOf(Artifact) or 
    *   oclIsKindOf(Class) or oclIsKindOf(Component) or oclIsKindOf(Port) or oclIsKindOf(Property) or 
    *   oclIsKindOf(Interface) or oclIsKindOf(Package) or oclIsKindOf(ActivityNode) or oclIsKindOf(ActivityPartition) or 
    *   (oclIsKindOf(InstanceSpecification) and not sis.oclAsType(InstanceSpecification).classifier->exists(oclIsKindOf(Relationship))))) 
    * and
    * (self.informationTarget->forAll( sit | 
    *   oclIsKindOf(Actor) or oclIsKindOf(Node) or oclIsKindOf(UseCase) or oclIsKindOf(Artifact) or 
    *   oclIsKindOf(Class) or oclIsKindOf(Component) or oclIsKindOf(Port) or oclIsKindOf(Property) or 
    *   oclIsKindOf(Interface) or oclIsKindOf(Package) or oclIsKindOf(ActivityNode) or oclIsKindOf(ActivityPartition) or 
    * (oclIsKindOf(InstanceSpecification) and not sit.oclAsType(InstanceSpecification).classifier->exists(oclIsKindOf(Relationship)))))
    * }}}
    */
  def validate_sources_and_targets_kind: Boolean = {
    // Start of user code for "sources_and_targets_kind"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInformationFlowOps
