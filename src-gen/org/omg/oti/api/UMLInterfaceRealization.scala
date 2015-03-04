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
 * An InterfaceRealization is a specialized realization relationship between a BehavioredClassifier and an Interface. This relationship signifies that the realizing BehavioredClassifier conforms to the contract specified by the Interface.
 * <!-- end-model-doc --> 
 */
trait UMLInterfaceRealization[Uml <: UML]
	extends UMLRealization[Uml]
	with UMLInterfaceRealizationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * References the Interface specifying the conformance contract.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInterface.contract_interfaceRealization
	 */
	def contract: Option[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References the BehavioredClassifier that owns this InterfaceRealization, i.e., the BehavioredClassifier that realizes the Interface to which it refers.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLBehavioredClassifier.interfaceRealization
	 */
	def implementingClassifier: Option[UMLBehavioredClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interfaceRealization_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			realization_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interfaceRealization_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			realization_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interfaceRealization_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			realization_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLInterfaceRealization[Uml], UMLInterface[Uml]]("contract", _.contract),
				MetaPropertyReference[Uml, UMLInterfaceRealization[Uml], UMLBehavioredClassifier[Uml]]("implementingClassifier", _.implementingClassifier)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interfaceRealization_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterfaceRealization
	 */
	def interfaceRealization_forwardReferencesFromMetamodelAssociations: Elements =
		realization_forwardReferencesFromMetamodelAssociations ++
		contract ++
		implementingClassifier 

} //UMLInterfaceRealization
