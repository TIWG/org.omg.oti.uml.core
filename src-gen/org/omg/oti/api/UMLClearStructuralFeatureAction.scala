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
 * A ClearStructuralFeatureAction is a StructuralFeatureAction that removes all values of a StructuralFeature.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLClearStructuralFeatureAction[Uml <: UML]
	extends UMLStructuralFeatureAction[Uml]
	with UMLClearStructuralFeatureActionOps[Uml] {
	
	import ops._

	/**
	 * The OutputPin on which is put the input object as modified by the ClearStructuralFeatureAction.
	 *
	 * <!-- Start of user code doc for result -->
	 * <!-- End of user code doc for result -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_clearStructuralFeatureAction
	 */
	def result: Option[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		clearStructuralFeatureAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClearStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for clearStructuralFeatureAction_metaAttributes -->
	 * <!-- End of user code doc for clearStructuralFeatureAction_metaAttributes -->
	 */
	def clearStructuralFeatureAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			structuralFeatureAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		clearStructuralFeatureAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClearStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for clearStructuralFeatureAction_compositeMetaProperties -->
	 * <!-- End of user code doc for clearStructuralFeatureAction_compositeMetaProperties -->
	 */
	def clearStructuralFeatureAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuralFeatureAction_compositeMetaProperties,
			Seq (ClearStructuralFeatureAction_result))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		clearStructuralFeatureAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClearStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for clearStructuralFeatureAction_referenceMetaProperties -->
	 * <!-- End of user code doc for clearStructuralFeatureAction_referenceMetaProperties -->
	 */
	def clearStructuralFeatureAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuralFeatureAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClearStructuralFeatureAction
	 *
	 * <!-- Start of user code doc for clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def clearStructuralFeatureAction_forwardReferencesFromMetamodelAssociations: Elements =
		structuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLClearStructuralFeatureAction
