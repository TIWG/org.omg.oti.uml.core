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
 * A BehavioredClassifier may have InterfaceRealizations, and owns a set of Behaviors one of which may specify the behavior of the BehavioredClassifier itself.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLBehavioredClassifier[Uml <: UML]
	extends UMLClassifier[Uml]
	with UMLBehavioredClassifierOps[Uml] {
	
	import ops._

	/**
	 * A Behavior that specifies the behavior of the BehavioredClassifier itself.
	 *
	 * <!-- Start of user code doc for classifierBehavior -->
	 * <!-- End of user code doc for classifierBehavior -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.classifierBehavior_behavioredClassifier
	 */
	def classifierBehavior: Option[UMLBehavior[Uml]]

	/**
	 * The set of InterfaceRealizations owned by the BehavioredClassifier. Interface realizations reference the Interfaces of which the BehavioredClassifier is an implementation.
	 *
	 * <!-- Start of user code doc for interfaceRealization -->
	 * <!-- End of user code doc for interfaceRealization -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterfaceRealization.implementingClassifier
	 */
	def interfaceRealization: Set[UMLInterfaceRealization[Uml]]

	/**
	 * Behaviors owned by a BehavioredClassifier.
	 *
	 * <!-- Start of user code doc for ownedBehavior -->
	 * <!-- End of user code doc for ownedBehavior -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehavior.ownedBehavior_behavioredClassifier
	 */
	def ownedBehavior: Set[UMLBehavior[Uml]]

	/**
	 * <!-- Start of user code doc for context_behavior -->
	 * <!-- End of user code doc for context_behavior -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehavior.context
	 */
	def context_behavior: Set[UMLBehavior[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavioredClassifier_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavioredClassifier
	 *
	 * <!-- Start of user code doc for behavioredClassifier_metaAttributes -->
	 * <!-- End of user code doc for behavioredClassifier_metaAttributes -->
	 */
	def behavioredClassifier_metaAttributes: MetaAttributeFunctions = 
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
		behavioredClassifier_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavioredClassifier
	 *
	 * <!-- Start of user code doc for behavioredClassifier_compositeMetaProperties -->
	 * <!-- End of user code doc for behavioredClassifier_compositeMetaProperties -->
	 */
	def behavioredClassifier_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_compositeMetaProperties,
			Seq (BehavioredClassifier_interfaceRealization,
				BehavioredClassifier_ownedBehavior))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavioredClassifier_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavioredClassifier
	 *
	 * <!-- Start of user code doc for behavioredClassifier_referenceMetaProperties -->
	 * <!-- End of user code doc for behavioredClassifier_referenceMetaProperties -->
	 */
	def behavioredClassifier_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_referenceMetaProperties,
			Seq (BehavioredClassifier_classifierBehavior))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavioredClassifier
	 *
	 * <!-- Start of user code doc for behavioredClassifier_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for behavioredClassifier_forwardReferencesFromMetamodelAssociations -->
	 */
	def behavioredClassifier_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		classifierBehavior 

	// Start of user code for additional features
	// End of user code
} //UMLBehavioredClassifier
