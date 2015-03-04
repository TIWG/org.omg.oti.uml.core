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
 * A TimeEvent is an Event that occurs at a specific point in time.
 * <!-- end-model-doc --> 
 */
trait UMLTimeEvent[Uml <: UML]
	extends UMLEvent[Uml]
	with UMLTimeEventOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether the TimeEvent is specified as an absolute or relative time.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isRelative: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the time of the TimeEvent.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLTimeExpression.when_timeEvent
	 */
	def when: Option[UMLTimeExpression[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeEvent_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeEvent
	 */
	def timeEvent_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			event_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLTimeEvent[Uml]](None, "isRelative", (x) => booleanToIterable(x.isRelative, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeEvent_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeEvent
	 */
	def timeEvent_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			event_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTimeEvent[Uml], UMLTimeExpression[Uml]]("when", _.when)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeEvent_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeEvent
	 */
	def timeEvent_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			event_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeEvent_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeEvent
	 */
	def timeEvent_forwardReferencesFromMetamodelAssociations: Elements =
		event_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLTimeEvent
