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
 * A CallOperationAction is a CallAction that transmits an Operation call request to the target object, where it may cause the invocation of associated Behavior. The argument values of the CallOperationAction are passed on the input Parameters of the Operation. If call is synchronous, the execution of the CallOperationAction waits until the execution of the invoked Operation completes and the values of output Parameters of the Operation are placed on the result OutputPins. If the call is asynchronous, the CallOperationAction completes immediately and no results values can be provided.
 * <!-- end-model-doc --> 
 */
trait UMLCallOperationAction[Uml <: UML]
	extends UMLCallAction[Uml]
	with UMLCallOperationActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Operation being invoked.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOperation.operation_callOperationAction
	 */
	def operation: Option[UMLOperation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin that provides the target object to which the Operation call request is sent.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.target_callOperationAction
	 */
	def target: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callOperationAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallOperationAction
	 */
	def callOperationAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			callAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callOperationAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallOperationAction
	 */
	def callOperationAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			callAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLCallOperationAction[Uml], UMLInputPin[Uml]]("target", _.target)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callOperationAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallOperationAction
	 */
	def callOperationAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			callAction_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLCallOperationAction[Uml], UMLOperation[Uml]]("operation", _.operation)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callOperationAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallOperationAction
	 */
	def callOperationAction_forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations ++
		operation 

} //UMLCallOperationAction
