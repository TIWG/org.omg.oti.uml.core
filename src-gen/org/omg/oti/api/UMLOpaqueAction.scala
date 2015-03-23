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
 * An OpaqueAction is an Action whose functionality is not specified within UML.
 * <!-- end-model-doc -->
 */
trait UMLOpaqueAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLOpaqueActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Provides a textual specification of the functionality of the Action, in one or more languages other than UML.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 */
	def body: Seq[String]

	/**
	 * <!-- begin-model-doc -->
	 * The InputPins providing inputs to the OpaqueAction.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.inputValue_opaqueAction
	 */
	def inputValue: Set[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * If provided, a specification of the language used for each of the body Strings.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 */
	def language: Seq[String]

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPins on which the OpaqueAction provides outputs.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.outputValue_opaqueAction
	 */
	def outputValue: Set[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		opaqueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOpaqueAction
	 */
	def opaqueAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq (MetaAttributeStringFunction[Uml, UMLOpaqueAction[Uml]](None, "body", _.body),
				MetaAttributeStringFunction[Uml, UMLOpaqueAction[Uml]](None, "language", _.language)))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		opaqueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOpaqueAction
	 */
	def opaqueAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLOpaqueAction[Uml], UMLInputPin[Uml]]("inputValue", _.inputValue),
				MetaPropertyCollection[Uml, UMLOpaqueAction[Uml], UMLOutputPin[Uml]]("outputValue", _.outputValue)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		opaqueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOpaqueAction
	 */
	def opaqueAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		opaqueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOpaqueAction
	 */
	def opaqueAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLOpaqueAction
