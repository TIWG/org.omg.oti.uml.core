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
 * Interfaces declare coherent services that are implemented by BehavioredClassifiers that implement the Interfaces via InterfaceRealizations.
 * <!-- end-model-doc --> 
 */
trait UMLInterface[Uml <: UML]
	extends UMLClassifier[Uml]
	with UMLInterfaceOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * References all the Classifiers that are defined (nested) within the Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.nestedClassifier_interface
	 */
	def nestedClassifier: Seq[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The attributes (i.e., the Properties) owned by the Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.interface
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Operations owned by the Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation.interface
	 */
	def ownedOperation: Seq[UMLOperation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Receptions that objects providing this Interface are willing to accept.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReception.ownedReception_interface
	 */
	def ownedReception: Set[UMLReception[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References a ProtocolStateMachine specifying the legal sequences of the invocation of the BehavioralFeatures described in the Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProtocolStateMachine.protocol_interface
	 */
	def protocol: Option[UMLProtocolStateMachine[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * References all the Interfaces redefined by this Interface.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.redefinedInterface_interface
	 */
	def redefinedInterface: Set[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterfaceRealization.contract
	 */
	def contract_interfaceRealization: Set[UMLInterfaceRealization[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponent.provided
	 */
	def provided_component: Set[UMLComponent[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.provided
	 */
	def provided_port: Set[UMLPort[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterface.redefinedInterface
	 */
	def redefinedInterface_interface: Set[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComponent.required
	 */
	def required_component: Set[UMLComponent[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPort.required
	 */
	def required_port: Set[UMLPort[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interface_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterface
	 */
	def interface_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			classifier_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interface_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterface
	 */
	def interface_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInterface[Uml], UMLClassifier[Uml]]("nestedClassifier", _.nestedClassifier),
				MetaPropertyCollection[Uml, UMLInterface[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
				MetaPropertyCollection[Uml, UMLInterface[Uml], UMLOperation[Uml]]("ownedOperation", _.ownedOperation),
				MetaPropertyCollection[Uml, UMLInterface[Uml], UMLReception[Uml]]("ownedReception", _.ownedReception),
				MetaPropertyReference[Uml, UMLInterface[Uml], UMLProtocolStateMachine[Uml]]("protocol", _.protocol)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interface_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterface
	 */
	def interface_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInterface[Uml], UMLInterface[Uml]]("redefinedInterface", _.redefinedInterface)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interface_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterface
	 */
	def interface_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		redefinedInterface 

} //UMLInterface
