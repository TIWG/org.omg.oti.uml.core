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
import org.omg.oti.uml.read.operations.UMLCallBehaviorActionOps

// End of user code

/**
 * A CallBehaviorAction is a CallAction that invokes a Behavior directly. The argument values of the CallBehaviorAction are passed on the input Parameters of the invoked Behavior. If the call is synchronous, the execution of the CallBehaviorAction waits until the execution of the invoked Behavior completes and the values of output Parameters of the Behavior are placed on the result OutputPins. If the call is asynchronous, the CallBehaviorAction completes immediately and no results values can be provided.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLCallBehaviorAction[Uml <: UML]
	extends UMLCallAction[Uml]
	with UMLCallBehaviorActionOps[Uml] {
	
	import ops._

	/**
	 * The Behavior being invoked.
	 *
	 * <!-- Start of user code doc for behavior -->
   * <!-- End of user code doc for behavior -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.behavior_callBehaviorAction
	 */
	def behavior: Option[UMLBehavior[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callBehaviorAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallBehaviorAction
	 *
	 * <!-- Start of user code doc for callBehaviorAction_metaAttributes -->
   * <!-- End of user code doc for callBehaviorAction_metaAttributes -->
	 */
	def callBehaviorAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			callAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callBehaviorAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallBehaviorAction
	 *
	 * <!-- Start of user code doc for callBehaviorAction_compositeMetaProperties -->
   * <!-- End of user code doc for callBehaviorAction_compositeMetaProperties -->
	 */
	def callBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			callAction_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callBehaviorAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallBehaviorAction
	 *
	 * <!-- Start of user code doc for callBehaviorAction_referenceMetaProperties -->
   * <!-- End of user code doc for callBehaviorAction_referenceMetaProperties -->
	 */
	def callBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			callAction_referenceMetaProperties,
			Seq (CallBehaviorAction_behavior))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callBehaviorAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallBehaviorAction
	 *
	 * <!-- Start of user code doc for callBehaviorAction_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for callBehaviorAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def callBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
		callAction_forwardReferencesFromMetamodelAssociations ++
		behavior

	// Start of user code for additional features
  // End of user code
} //UMLCallBehaviorAction
