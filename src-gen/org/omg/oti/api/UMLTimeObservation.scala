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
 * A TimeObservation is a reference to a time instant during an execution. It points out the NamedElement in the model to observe and whether the observation is when this NamedElement is entered or when it is exited.
 * <!-- end-model-doc -->
 */
trait UMLTimeObservation[Uml <: UML]
	extends UMLObservation[Uml]
	with UMLTimeObservationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The TimeObservation is determined by the entering or exiting of the event Element during execution.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLNamedElement.event_timeObservation
	 */
	def event: Option[UMLNamedElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The value of firstEvent is related to the event. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the event Element. If firstEvent is false, then the corresponding observation event is the time instant the execution exits the event Element.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def firstEvent: Boolean

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeObservation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeObservation
	 */
	def timeObservation_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			observation_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLTimeObservation[Uml]](None, "firstEvent", (x) => booleanToIterable(x.firstEvent, true))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeObservation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeObservation
	 */
	def timeObservation_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			observation_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeObservation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeObservation
	 */
	def timeObservation_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			observation_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTimeObservation[Uml], UMLNamedElement[Uml]]("event", _.event, true)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeObservation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeObservation
	 */
	def timeObservation_forwardReferencesFromMetamodelAssociations: Elements =
		observation_forwardReferencesFromMetamodelAssociations ++
		event 

} //UMLTimeObservation
