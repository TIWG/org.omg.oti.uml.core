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
 * A DurationInterval defines the range between two Durations.
 * <!-- end-model-doc -->
 */
trait UMLDurationInterval[Uml <: UML]
	extends UMLInterval[Uml]
	with UMLDurationIntervalOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Refers to the Duration denoting the maximum value of the range.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLDuration.max_durationInterval
	 */
	override def max: Option[UMLDuration[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Refers to the Duration denoting the minimum value of the range.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLDuration.min_durationInterval
	 */
	override def min: Option[UMLDuration[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDurationConstraint.specification
	 */
	def specification_durationConstraint: Option[UMLDurationConstraint[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		durationInterval_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLDurationInterval
	 */
	def durationInterval_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			interval_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		durationInterval_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLDurationInterval
	 */
	def durationInterval_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interval_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		durationInterval_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLDurationInterval
	 */
	def durationInterval_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interval_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLDurationInterval[Uml], UMLDuration[Uml]]("max", _.max),
				MetaPropertyReference[Uml, UMLDurationInterval[Uml], UMLDuration[Uml]]("min", _.min)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		durationInterval_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLDurationInterval
	 */
	def durationInterval_forwardReferencesFromMetamodelAssociations: Elements =
		interval_forwardReferencesFromMetamodelAssociations ++
		max ++
		min 

} //UMLDurationInterval
