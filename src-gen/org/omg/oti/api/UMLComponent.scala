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
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * A Component represents a modular part of a system that encapsulates its contents and whose manifestation is replaceable within its environment.  
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLComponent[Uml <: UML]
	extends UMLClass[Uml]
	with UMLComponentOps[Uml] {
	
	import ops._

	/**
	 * If true, the Component is defined at design-time, but at run-time (or execution-time) an object specified by the Component does not exist, that is, the Component is instantiated indirectly, through the instantiation of its realizing Classifiers or parts.
	 *
	 * <!-- Start of user code doc for isIndirectlyInstantiated -->
	 * <!-- End of user code doc for isIndirectlyInstantiated -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isIndirectlyInstantiated: Boolean

	/**
	 * The set of PackageableElements that a Component owns. In the namespace of a Component, all model elements that are involved in or related to its definition may be owned or imported explicitly. These may include e.g., Classes, Interfaces, Components, Packages, UseCases, Dependencies (e.g., mappings), and Artifacts.
	 *
	 * <!-- Start of user code doc for packagedElement -->
	 * <!-- End of user code doc for packagedElement -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackageableElement.packagedElement_component
	 */
	def packagedElement: Set[UMLPackageableElement[Uml]]

	/**
	 * The Interfaces that the Component exposes to its environment. These Interfaces may be Realized by the Component or any of its realizingClassifiers, or they may be the Interfaces that are provided by its public Ports.
	 *
	 * <!-- Start of user code doc for provided -->
	 * <!-- End of user code doc for provided -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.provided_component
	 * @body result = (let 	ris : Set(Interface) = allRealizedInterfaces(),
	 *         realizingClassifiers : Set(Classifier) =  self.realization.realizingClassifier->union(self.allParents()->collect(realization.realizingClassifier))->asSet(),
	 *         allRealizingClassifiers : Set(Classifier) = realizingClassifiers->union(realizingClassifiers.allParents())->asSet(),
	 *         realizingClassifierInterfaces : Set(Interface) = allRealizingClassifiers->iterate(c; rci : Set(Interface) = Set{} | rci->union(c.allRealizedInterfaces())),
	 *         ports : Set(Port) = self.ownedPort->union(allParents()->collect(ownedPort))->asSet(),
	 *         providedByPorts : Set(Interface) = ports.provided->asSet()
	 * in     ris->union(realizingClassifierInterfaces) ->union(providedByPorts)->asSet())
	 */
	def provided: Set[UMLInterface[Uml]]

	/**
	 * The set of Realizations owned by the Component. Realizations reference the Classifiers of which the Component is an abstraction; i.e., that realize its behavior.
	 *
	 * <!-- Start of user code doc for realization -->
	 * <!-- End of user code doc for realization -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponentRealization.abstraction
	 */
	def realization: Set[UMLComponentRealization[Uml]]

	/**
	 * The Interfaces that the Component requires from other Components in its environment in order to be able to offer its full set of provided functionality. These Interfaces may be used by the Component or any of its realizingClassifiers, or they may be the Interfaces that are required by its public Ports.
	 *
	 * <!-- Start of user code doc for required -->
	 * <!-- End of user code doc for required -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.required_component
	 * @body result = (let 	uis : Set(Interface) = allUsedInterfaces(),
	 *         realizingClassifiers : Set(Classifier) = self.realization.realizingClassifier->union(self.allParents()->collect(realization.realizingClassifier))->asSet(),
	 *         allRealizingClassifiers : Set(Classifier) = realizingClassifiers->union(realizingClassifiers.allParents())->asSet(),
	 *         realizingClassifierInterfaces : Set(Interface) = allRealizingClassifiers->iterate(c; rci : Set(Interface) = Set{} | rci->union(c.allUsedInterfaces())),
	 *         ports : Set(Port) = self.ownedPort->union(allParents()->collect(ownedPort))->asSet(),
	 *         usedByPorts : Set(Interface) = ports.required->asSet()
	 * in	    uis->union(realizingClassifierInterfaces)->union(usedByPorts)->asSet()
	 * )
	 */
	def required: Set[UMLInterface[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		component_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLComponent
	 *
	 * <!-- Start of user code doc for component_metaAttributes -->
	 * <!-- End of user code doc for component_metaAttributes -->
	 */
	def component_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			class_metaAttributes,
			Seq (Component_isIndirectlyInstantiated))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		component_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLComponent
	 *
	 * <!-- Start of user code doc for component_compositeMetaProperties -->
	 * <!-- End of user code doc for component_compositeMetaProperties -->
	 */
	def component_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_compositeMetaProperties,
			Seq (Component_packagedElement,
				Component_realization))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		component_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLComponent
	 *
	 * <!-- Start of user code doc for component_referenceMetaProperties -->
	 * <!-- End of user code doc for component_referenceMetaProperties -->
	 */
	def component_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		component_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLComponent
	 *
	 * <!-- Start of user code doc for component_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for component_forwardReferencesFromMetamodelAssociations -->
	 */
	def component_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLComponent
