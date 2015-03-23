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
 * A TimeConstraint is a Constraint that refers to a TimeInterval.
 * <!-- end-model-doc -->
 */
trait UMLTimeConstraint[Uml <: UML]
	extends UMLIntervalConstraint[Uml]
	with UMLTimeConstraintOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The value of firstEvent is related to the constrainedElement. If firstEvent is true, then the corresponding observation event is the first time instant the execution enters the constrainedElement. If firstEvent is false, then the corresponding observation event is the last time instant the execution is within the constrainedElement.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def firstEvent: Option[Boolean]

	/**
	 * <!-- begin-model-doc -->
	 * TheTimeInterval constraining the duration.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTimeInterval.specification_timeConstraint
	 */
	override def specification: Option[UMLTimeInterval[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeConstraint_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeConstraint
	 */
	def timeConstraint_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			intervalConstraint_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLTimeConstraint[Uml]](None, "firstEvent", _.firstEvent)))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeConstraint_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeConstraint
	 */
	def timeConstraint_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			intervalConstraint_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTimeConstraint[Uml], UMLTimeInterval[Uml]]("specification", _.specification)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeConstraint_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeConstraint
	 */
	def timeConstraint_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			intervalConstraint_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeConstraint_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeConstraint
	 */
	def timeConstraint_forwardReferencesFromMetamodelAssociations: Elements =
		intervalConstraint_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLTimeConstraint
