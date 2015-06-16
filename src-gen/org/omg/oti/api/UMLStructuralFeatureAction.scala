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
 * StructuralFeatureAction is an abstract class for all Actions that operate on StructuralFeatures.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLStructuralFeatureAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLStructuralFeatureActionOps[Uml] {
	
	import ops._

	/**
	 * The InputPin from which the object whose StructuralFeature is to be read or written is obtained.
	 *
	 * <!-- Start of user code doc for _object -->
	 * <!-- End of user code doc for _object -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.object_structuralFeatureAction
	 */
	def _object: Option[UMLInputPin[Uml]]

	/**
	 * The StructuralFeature to be read or written.
	 *
	 * <!-- Start of user code doc for structuralFeature -->
	 * <!-- End of user code doc for structuralFeature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLStructuralFeature.structuralFeature_structuralFeatureAction
	 */
	def structuralFeature: Option[UMLStructuralFeature[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuralFeatureAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for structuralFeatureAction_metaAttributes -->
	 * <!-- End of user code doc for structuralFeatureAction_metaAttributes -->
	 */
	def structuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuralFeatureAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for structuralFeatureAction_compositeMetaProperties -->
	 * <!-- End of user code doc for structuralFeatureAction_compositeMetaProperties -->
	 */
	def structuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (StructuralFeatureAction_object))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuralFeatureAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for structuralFeatureAction_referenceMetaProperties -->
	 * <!-- End of user code doc for structuralFeatureAction_referenceMetaProperties -->
	 */
	def structuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (StructuralFeatureAction_structuralFeature))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeatureAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for structuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for structuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def structuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		structuralFeature 

	// Start of user code for additional features
	// End of user code
} //UMLStructuralFeatureAction
