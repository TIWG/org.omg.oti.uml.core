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
 * A StructuralFeature is a typed feature of a Classifier that specifies the structure of instances of the Classifier.
 * <!-- end-model-doc --> 
 */
trait UMLStructuralFeature[Uml <: UML]
	extends UMLFeature[Uml]
	with UMLMultiplicityElement[Uml]
	with UMLTypedElement[Uml]
	with UMLStructuralFeatureOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * If isReadOnly is true, the StructuralFeature may not be written to after initialization.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReadOnly: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLSlot.definingFeature
	 */
	def definingFeature_slot: Set[UMLSlot[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStructuralFeatureAction.structuralFeature
	 */
	def structuralFeature_structuralFeatureAction: Set[UMLStructuralFeatureAction[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuralFeature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuralFeature
	 */
	def structuralFeature_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			feature_metaAttributes,
			multiplicityElement_metaAttributes,
			typedElement_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLStructuralFeature[Uml]](None, "isReadOnly", (x) => booleanToIterable(x.isReadOnly, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuralFeature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuralFeature
	 */
	def structuralFeature_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_compositeMetaProperties,
			multiplicityElement_compositeMetaProperties,
			typedElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuralFeature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuralFeature
	 */
	def structuralFeature_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_referenceMetaProperties,
			multiplicityElement_referenceMetaProperties,
			typedElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuralFeature
	 */
	def structuralFeature_forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		typedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLStructuralFeature
