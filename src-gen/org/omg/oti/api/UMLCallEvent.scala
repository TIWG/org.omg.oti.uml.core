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
 * A CallEvent models the receipt by an object of a message invoking a call of an Operation.
 * <!-- end-model-doc -->
 */
trait UMLCallEvent[Uml <: UML]
	extends UMLMessageEvent[Uml]
	with UMLCallEventOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Designates the Operation whose invocation raised the CalEvent.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOperation.operation_callEvent
	 */
	def operation: Option[UMLOperation[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		callEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCallEvent
	 */
	def callEvent_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			messageEvent_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		callEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCallEvent
	 */
	def callEvent_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			messageEvent_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		callEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCallEvent
	 */
	def callEvent_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			messageEvent_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLCallEvent[Uml], UMLOperation[Uml]]("operation", _.operation)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		callEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCallEvent
	 */
	def callEvent_forwardReferencesFromMetamodelAssociations: Elements =
		messageEvent_forwardReferencesFromMetamodelAssociations ++
		operation 

} //UMLCallEvent
