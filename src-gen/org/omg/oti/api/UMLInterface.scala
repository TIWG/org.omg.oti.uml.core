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
 * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLInterface[Uml <: UML]
	extends UMLClassifier[Uml]
	with UMLInterfaceOps[Uml] {
	
	import ops._

	/**
	 * References all the Classifiers that are defined (nested) within the Interface.
	 *
	 * <!-- Start of user code doc for nestedClassifier -->
	 * <!-- End of user code doc for nestedClassifier -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.nestedClassifier_interface
	 */
	def nestedClassifier: Seq[UMLClassifier[Uml]]

	/**
	 * The attributes (i.e., the Properties) owned by the Interface.
	 *
	 * <!-- Start of user code doc for ownedAttribute -->
	 * <!-- End of user code doc for ownedAttribute -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.interface
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]]

	/**
	 * The Operations owned by the Interface.
	 *
	 * <!-- Start of user code doc for ownedOperation -->
	 * <!-- End of user code doc for ownedOperation -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation.interface
	 */
	def ownedOperation: Seq[UMLOperation[Uml]]

	/**
	 * References all the Interfaces redefined by this Interface.
	 *
	 * <!-- Start of user code doc for redefinedInterface -->
	 * <!-- End of user code doc for redefinedInterface -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.redefinedInterface_interface
	 */
	def redefinedInterface: Set[UMLInterface[Uml]]

	/**
	 * <!-- Start of user code doc for contract_interfaceRealization -->
	 * <!-- End of user code doc for contract_interfaceRealization -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterfaceRealization.contract
	 */
	def contract_interfaceRealization: Set[UMLInterfaceRealization[Uml]]

	/**
	 * <!-- Start of user code doc for provided_component -->
	 * <!-- End of user code doc for provided_component -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponent.provided
	 */
	def provided_component: Set[UMLComponent[Uml]]

	/**
	 * <!-- Start of user code doc for provided_port -->
	 * <!-- End of user code doc for provided_port -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.provided
	 */
	def provided_port: Set[UMLPort[Uml]]

	/**
	 * <!-- Start of user code doc for redefinedInterface_interface -->
	 * <!-- End of user code doc for redefinedInterface_interface -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.redefinedInterface
	 */
	def redefinedInterface_interface: Set[UMLInterface[Uml]]

	/**
	 * <!-- Start of user code doc for required_component -->
	 * <!-- End of user code doc for required_component -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponent.required
	 */
	def required_component: Set[UMLComponent[Uml]]

	/**
	 * <!-- Start of user code doc for required_port -->
	 * <!-- End of user code doc for required_port -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.required
	 */
	def required_port: Set[UMLPort[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interface_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterface
	 *
	 * <!-- Start of user code doc for interface_metaAttributes -->
	 * <!-- End of user code doc for interface_metaAttributes -->
	 */
	def interface_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			classifier_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interface_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterface
	 *
	 * <!-- Start of user code doc for interface_compositeMetaProperties -->
	 * <!-- End of user code doc for interface_compositeMetaProperties -->
	 */
	def interface_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_compositeMetaProperties,
			Seq (Interface_nestedClassifier,
				Interface_ownedAttribute,
				Interface_ownedOperation,
				Interface_ownedReception,
				Interface_protocol))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interface_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterface
	 *
	 * <!-- Start of user code doc for interface_referenceMetaProperties -->
	 * <!-- End of user code doc for interface_referenceMetaProperties -->
	 */
	def interface_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_referenceMetaProperties,
			Seq (Interface_redefinedInterface))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interface_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterface
	 *
	 * <!-- Start of user code doc for interface_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for interface_forwardReferencesFromMetamodelAssociations -->
	 */
	def interface_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		redefinedInterface 

	// Start of user code for additional features
	// End of user code
} //UMLInterface
