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
 * InformationFlows describe circulation of information through a system in a general manner. They do not specify the nature of the information, mechanisms by which it is conveyed, sequences of exchange or any control conditions. During more detailed modeling, representation and realization links may be added to specify which model elements implement an InformationFlow and to show how information is conveyed.  InformationFlows require some kind of ?information channel? for unidirectional transmission of information items from sources to targets.? They specify the information channel?s realizations, if any, and identify the information that flows along them.? Information moving along the information channel may be represented by abstract InformationItems and by concrete Classifiers.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInformationFlowOps[Uml <: UML] { self: UMLInformationFlow[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * Defines from which source the conveyed InformationItems are initiated.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.informationSource_informationFlow
	 */
	def informationSource: Set[UMLNamedElement[Uml]] = source.selectByKindOf { case x: UMLNamedElement[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * Defines to which target the conveyed InformationItems are directed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLNamedElement.informationTarget_informationFlow
	 */
	def informationTarget: Set[UMLNamedElement[Uml]] = target.selectByKindOf { case x: UMLNamedElement[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * An information flow can only convey classifiers that are allowed to represent an information item.
	 * <!-- end-model-doc -->
	 *
	 * @body self.conveyed->forAll(oclIsKindOf(Class) or oclIsKindOf(Interface)
	 *   or oclIsKindOf(InformationItem) or oclIsKindOf(Signal) or oclIsKindOf(Component))
	 */
	def validate_convey_classifiers: Boolean  = {
		// Start of user code for "convey_classifiers"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The sources and targets of the information flow must conform to the sources and targets or conversely the targets and sources of the realization relationships.
	 * <!-- end-model-doc -->
	 *
	 */
	def validate_must_conform: Boolean  = {
		// Start of user code for "must_conform"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The sources and targets of the information flow can only be one of the following kind: Actor, Node, UseCase, Artifact, Class, Component, Port, Property, Interface, Package, ActivityNode, ActivityPartition,
	 Behavior and InstanceSpecification except when its classifier is a relationship (i.e. it represents a link).
	 * <!-- end-model-doc -->
	 *
	 * @body (self.informationSource->forAll( sis |
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
	 */
	def validate_sources_and_targets_kind: Boolean  = {
		// Start of user code for "sources_and_targets_kind"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLInformationFlow
