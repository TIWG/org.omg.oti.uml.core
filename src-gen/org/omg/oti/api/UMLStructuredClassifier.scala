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
 * StructuredClassifiers may contain an internal structure of connected elements each of which plays a role in the overall Behavior modeled by the StructuredClassifier.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLStructuredClassifier[Uml <: UML]
	extends UMLClassifier[Uml]
	with UMLStructuredClassifierOps[Uml] {
	
	import ops._

	/**
	 * The Properties owned by the StructuredClassifier.
	 *
	 * <!-- Start of user code doc for ownedAttribute -->
	 * <!-- End of user code doc for ownedAttribute -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.ownedAttribute_structuredClassifier
	 */
	def ownedAttribute: Seq[UMLProperty[Uml]]

	/**
	 * The roles that instances may play in this StructuredClassifier.
	 *
	 * <!-- Start of user code doc for role -->
	 * <!-- End of user code doc for role -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnectableElement.role_structuredClassifier
	 */
	def role: Set[UMLConnectableElement[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		structuredClassifier_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStructuredClassifier
	 *
	 * <!-- Start of user code doc for structuredClassifier_metaAttributes -->
	 * <!-- End of user code doc for structuredClassifier_metaAttributes -->
	 */
	def structuredClassifier_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			classifier_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		structuredClassifier_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStructuredClassifier
	 *
	 * <!-- Start of user code doc for structuredClassifier_compositeMetaProperties -->
	 * <!-- End of user code doc for structuredClassifier_compositeMetaProperties -->
	 */
	def structuredClassifier_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_compositeMetaProperties,
			Seq (StructuredClassifier_ownedAttribute,
				StructuredClassifier_ownedConnector))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		structuredClassifier_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStructuredClassifier
	 *
	 * <!-- Start of user code doc for structuredClassifier_referenceMetaProperties -->
	 * <!-- End of user code doc for structuredClassifier_referenceMetaProperties -->
	 */
	def structuredClassifier_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		structuredClassifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStructuredClassifier
	 *
	 * <!-- Start of user code doc for structuredClassifier_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for structuredClassifier_forwardReferencesFromMetamodelAssociations -->
	 */
	def structuredClassifier_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLStructuredClassifier
