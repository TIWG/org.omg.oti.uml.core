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
 * An AddStructuralFeatureValueAction is a WriteStructuralFeatureAction for adding values to a StructuralFeature.
 * <!-- end-model-doc --> 
 */
trait UMLAddStructuralFeatureValueAction[Uml <: UML]
	extends UMLWriteStructuralFeatureAction[Uml]
	with UMLAddStructuralFeatureValueActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin that gives the position at which to insert the value in an ordered StructuralFeature. The type of the insertAt InputPin is UnlimitedNatural, but the value cannot be zero. It is omitted for unordered StructuralFeatures.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInputPin.insertAt_addStructuralFeatureValueAction
	 */
	def insertAt: Option[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether existing values of the StructuralFeature should be removed before adding the new value.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReplaceAll: Boolean

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		addStructuralFeatureValueAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			writeStructuralFeatureAction_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLAddStructuralFeatureValueAction[Uml]](None, "isReplaceAll", (x) => booleanToIterable(x.isReplaceAll, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		addStructuralFeatureValueAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			writeStructuralFeatureAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLAddStructuralFeatureValueAction[Uml], UMLInputPin[Uml]]("insertAt", _.insertAt)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		addStructuralFeatureValueAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			writeStructuralFeatureAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAddStructuralFeatureValueAction
	 */
	def addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations: Elements =
		writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLAddStructuralFeatureValueAction
