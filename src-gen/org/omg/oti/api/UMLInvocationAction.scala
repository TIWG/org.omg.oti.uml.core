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
 * InvocationAction is an abstract class for the various actions that request Behavior invocation.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLInvocationAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLInvocationActionOps[Uml] {
	
	import ops._

	/**
	 * The InputPins that provide the argument values passed in the invocation request.
	 *
	 * <!-- Start of user code doc for argument -->
	 * <!-- End of user code doc for argument -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.argument_invocationAction
	 */
	def argument: Seq[UMLInputPin[Uml]]

	/**
	 * For CallOperationActions, SendSignalActions, and SendObjectActions, an optional Port of the target object through which the invocation request is sent.
	 *
	 * <!-- Start of user code doc for onPort -->
	 * <!-- End of user code doc for onPort -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLPort.onPort_invocationAction
	 */
	def onPort: Option[UMLPort[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		invocationAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInvocationAction
	 *
	 * <!-- Start of user code doc for invocationAction_metaAttributes -->
	 * <!-- End of user code doc for invocationAction_metaAttributes -->
	 */
	def invocationAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		invocationAction_compositeMetaProperties

	protected val InvocationAction_argument = MetaPropertyCollection[Uml, UMLInvocationAction[Uml], UMLInputPin[Uml]]("argument", _.argument, true)

	/**
	 * The XMI composite meta-properties relevant to class UMLInvocationAction
	 *
	 * <!-- Start of user code doc for invocationAction_compositeMetaProperties -->
	 * <!-- End of user code doc for invocationAction_compositeMetaProperties -->
	 */
	def invocationAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (InvocationAction_argument))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		invocationAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInvocationAction
	 *
	 * <!-- Start of user code doc for invocationAction_referenceMetaProperties -->
	 * <!-- End of user code doc for invocationAction_referenceMetaProperties -->
	 */
	def invocationAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLInvocationAction[Uml], UMLPort[Uml]]("onPort", _.onPort)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInvocationAction
	 *
	 * <!-- Start of user code doc for invocationAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for invocationAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def invocationAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		onPort 

	// Start of user code for additional features
	// End of user code
} //UMLInvocationAction
