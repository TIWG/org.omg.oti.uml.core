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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLBroadcastSignalActionOps

// End of user code

/**
 * A BroadcastSignalAction is an InvocationAction that transmits a Signal instance to all the potential target objects in the system. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instances are sent out and cannot receive reply values.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLBroadcastSignalAction[Uml <: UML]
	extends UMLInvocationAction[Uml]
	with UMLBroadcastSignalActionOps[Uml] {
	
	import ops._

	/**
	 * The Signal whose instances are to be sent.
	 *
	 * <!-- Start of user code doc for signal -->
   * <!-- End of user code doc for signal -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLSignal.signal_broadcastSignalAction
	 */
	def signal: Option[UMLSignal[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		broadcastSignalAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBroadcastSignalAction
	 *
	 * <!-- Start of user code doc for broadcastSignalAction_metaAttributes -->
   * <!-- End of user code doc for broadcastSignalAction_metaAttributes -->
	 */
	def broadcastSignalAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			invocationAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		broadcastSignalAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBroadcastSignalAction
	 *
	 * <!-- Start of user code doc for broadcastSignalAction_compositeMetaProperties -->
   * <!-- End of user code doc for broadcastSignalAction_compositeMetaProperties -->
	 */
	def broadcastSignalAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			invocationAction_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		broadcastSignalAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBroadcastSignalAction
	 *
	 * <!-- Start of user code doc for broadcastSignalAction_referenceMetaProperties -->
   * <!-- End of user code doc for broadcastSignalAction_referenceMetaProperties -->
	 */
	def broadcastSignalAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			invocationAction_referenceMetaProperties,
			Seq (BroadcastSignalAction_signal))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		broadcastSignalAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBroadcastSignalAction
	 *
	 * <!-- Start of user code doc for broadcastSignalAction_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for broadcastSignalAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def broadcastSignalAction_forwardReferencesFromMetamodelAssociations: Elements =
		invocationAction_forwardReferencesFromMetamodelAssociations ++
		signal

	// Start of user code for additional features
  // End of user code
} //UMLBroadcastSignalAction
