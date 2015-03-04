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
 * <!-- begin-model-doc --> 
 * A Component represents a modular part of a system that encapsulates its contents and whose manifestation is replaceable within its environment.  
 * <!-- end-model-doc --> 
 */
trait UMLComponent[Uml <: UML]
	extends UMLClass[Uml]
	with UMLComponentOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * If true, the Component is defined at design-time, but at run-time (or execution-time) an object specified by the Component does not exist, that is, the Component is instantiated indirectly, through the instantiation of its realizing Classifiers or parts.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isIndirectlyInstantiated: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * The set of PackageableElements that a Component owns. In the namespace of a Component, all model elements that are involved in or related to its definition may be owned or imported explicitly. These may include e.g., Classes, Interfaces, Components, Packages, UseCases, Dependencies (e.g., mappings), and Artifacts.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackageableElement.packagedElement_component
	 */
	def packagedElement: Set[UMLPackageableElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Interfaces that the Component exposes to its environment. These Interfaces may be Realized by the Component or any of its realizingClassifiers, or they may be the Interfaces that are provided by its public Ports.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.provided_component
	 */
	def provided: Set[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The set of Realizations owned by the Component. Realizations reference the Classifiers of which the Component is an abstraction; i.e., that realize its behavior.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponentRealization.abstraction
	 */
	def realization: Set[UMLComponentRealization[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Interfaces that the Component requires from other Components in its environment in order to be able to offer its full set of provided functionality. These Interfaces may be used by the Component or any of its realizingClassifiers, or they may be the Interfaces that are required by its public Ports.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.required_component
	 */
	def required: Set[UMLInterface[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		component_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLComponent
	 */
	def component_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			class_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLComponent[Uml]](None, "isIndirectlyInstantiated", (x) => booleanToIterable(x.isIndirectlyInstantiated, true))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		component_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLComponent
	 */
	def component_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLComponent[Uml], UMLPackageableElement[Uml]]("packagedElement", _.packagedElement),
				MetaPropertyCollection[Uml, UMLComponent[Uml], UMLComponentRealization[Uml]]("realization", _.realization)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		component_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLComponent
	 */
	def component_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			class_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		component_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLComponent
	 */
	def component_forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLComponent
