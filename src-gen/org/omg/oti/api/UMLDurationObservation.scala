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
 * A DurationObservation is a reference to a duration during an execution. It points out the NamedElement(s) in the model to observe and whether the observations are when this NamedElement is entered or when it is exited.
 * <!-- end-model-doc -->
 */
trait UMLDurationObservation[Uml <: UML]
	extends UMLObservation[Uml]
	with UMLDurationObservationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The DurationObservation is determined as the duration between the entering or exiting of a single event Element during execution, or the entering/exiting of one event Element and the entering/exiting of a second.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="1..2"
	 * @opposite org.omg.oti.api.UMLNamedElement.event_durationObservation
	 */
	def event: Seq[UMLNamedElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The value of firstEvent[i] is related to event[i] (where i is 1 or 2). If firstEvent[i] is true, then the corresponding observation event is the first time instant the execution enters event[i]. If firstEvent[i] is false, then the corresponding observation event is the time instant the execution exits event[i].
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..2"
	 */
	def firstEvent: Seq[Boolean]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		durationObservation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDurationObservation
	 */
	def durationObservation_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			observation_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLDurationObservation[Uml]](None, "firstEvent", _.firstEvent)))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		durationObservation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDurationObservation
	 */
	def durationObservation_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			observation_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		durationObservation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDurationObservation
	 */
	def durationObservation_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			observation_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLDurationObservation[Uml], UMLNamedElement[Uml]]("event", _.event)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		durationObservation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDurationObservation
	 */
	def durationObservation_forwardReferencesFromMetamodelAssociations: Elements =
		observation_forwardReferencesFromMetamodelAssociations ++
		event 

} //UMLDurationObservation
