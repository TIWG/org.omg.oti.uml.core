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
 * An AcceptCallAction is an AcceptEventAction that handles the receipt of a synchronous call request. In addition to the values from the Operation input parameters, the Action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller. An AcceptCallAction is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent ReplyAction will complete immediately with no effect.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLAcceptCallAction[Uml <: UML]
	extends UMLAcceptEventAction[Uml]
	with UMLAcceptCallActionOps[Uml] {
	
	import ops._

	/**
	 * An OutputPin where a value is placed containing sufficient information to perform a subsequent ReplyAction and return control to the caller. The contents of this value are opaque. It can be passed and copied but it cannot be manipulated by the model.
	 *
	 * <!-- Start of user code doc for returnInformation -->
	 * <!-- End of user code doc for returnInformation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.returnInformation_acceptCallAction
	 */
	def returnInformation: Option[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		acceptCallAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAcceptCallAction
	 *
	 * <!-- Start of user code doc for acceptCallAction_metaAttributes -->
	 * <!-- End of user code doc for acceptCallAction_metaAttributes -->
	 */
	def acceptCallAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			acceptEventAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		acceptCallAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAcceptCallAction
	 *
	 * <!-- Start of user code doc for acceptCallAction_compositeMetaProperties -->
	 * <!-- End of user code doc for acceptCallAction_compositeMetaProperties -->
	 */
	def acceptCallAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			acceptEventAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLAcceptCallAction[Uml], UMLOutputPin[Uml]]("returnInformation", _.returnInformation)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		acceptCallAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAcceptCallAction
	 *
	 * <!-- Start of user code doc for acceptCallAction_referenceMetaProperties -->
	 * <!-- End of user code doc for acceptCallAction_referenceMetaProperties -->
	 */
	def acceptCallAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			acceptEventAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		acceptCallAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAcceptCallAction
	 *
	 * <!-- Start of user code doc for acceptCallAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for acceptCallAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def acceptCallAction_forwardReferencesFromMetamodelAssociations: Elements =
		acceptEventAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLAcceptCallAction
