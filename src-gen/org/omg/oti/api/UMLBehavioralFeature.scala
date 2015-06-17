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
 * A BehavioralFeature is a feature of a Classifier that specifies an aspect of the behavior of its instances.  A BehavioralFeature is implemented (realized) by a Behavior. A BehavioralFeature specifies that a Classifier will respond to a designated request by invoking its implementing method.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLBehavioralFeature[Uml <: UML]
	extends UMLFeature[Uml]
	with UMLNamespace[Uml]
	with UMLBehavioralFeatureOps[Uml] {
	
	import ops._

	/**
	 * Specifies the semantics of concurrent calls to the same passive instance (i.e., an instance originating from a Class with isActive being false). Active instances control access to their own BehavioralFeatures.
	 *
	 * <!-- Start of user code doc for concurrency -->
	 * <!-- End of user code doc for concurrency -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def concurrency: UMLCallConcurrencyKind.Value

	/**
	 * If true, then the BehavioralFeature does not have an implementation, and one must be supplied by a more specific Classifier. If false, the BehavioralFeature must have an implementation in the Classifier or one must be inherited.
	 *
	 * <!-- Start of user code doc for isAbstract -->
	 * <!-- End of user code doc for isAbstract -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isAbstract: Boolean

	/**
	 * A Behavior that implements the BehavioralFeature. There may be at most one Behavior for a particular pairing of a Classifier (as owner of the Behavior) and a BehavioralFeature (as specification of the Behavior).
	 *
	 * <!-- Start of user code doc for method -->
	 * <!-- End of user code doc for method -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLBehavior.specification
	 */
	def method: Set[UMLBehavior[Uml]]

	/**
	 * The ordered set of formal Parameters of this BehavioralFeature.
	 *
	 * <!-- Start of user code doc for ownedParameter -->
	 * <!-- End of user code doc for ownedParameter -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameter.ownedParameter_ownerFormalParam
	 */
	def ownedParameter: Seq[UMLParameter[Uml]]

	/**
	 * The Types representing exceptions that may be raised during an invocation of this BehavioralFeature.
	 *
	 * <!-- Start of user code doc for raisedException -->
	 * <!-- End of user code doc for raisedException -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLType.raisedException_behavioralFeature
	 */
	def raisedException: Set[UMLType[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		behavioralFeature_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLBehavioralFeature
	 *
	 * <!-- Start of user code doc for behavioralFeature_metaAttributes -->
	 * <!-- End of user code doc for behavioralFeature_metaAttributes -->
	 */
	def behavioralFeature_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			feature_metaAttributes,
			namespace_metaAttributes,
			Seq (BehavioralFeature_isAbstract))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		behavioralFeature_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLBehavioralFeature
	 *
	 * <!-- Start of user code doc for behavioralFeature_compositeMetaProperties -->
	 * <!-- End of user code doc for behavioralFeature_compositeMetaProperties -->
	 */
	def behavioralFeature_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_compositeMetaProperties,
			namespace_compositeMetaProperties,
			Seq (BehavioralFeature_ownedParameter,
				BehavioralFeature_ownedParameterSet))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		behavioralFeature_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLBehavioralFeature
	 *
	 * <!-- Start of user code doc for behavioralFeature_referenceMetaProperties -->
	 * <!-- End of user code doc for behavioralFeature_referenceMetaProperties -->
	 */
	def behavioralFeature_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			feature_referenceMetaProperties,
			namespace_referenceMetaProperties,
			Seq (BehavioralFeature_method,
				BehavioralFeature_raisedException))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		behavioralFeature_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLBehavioralFeature
	 *
	 * <!-- Start of user code doc for behavioralFeature_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for behavioralFeature_forwardReferencesFromMetamodelAssociations -->
	 */
	def behavioralFeature_forwardReferencesFromMetamodelAssociations: Elements =
		feature_forwardReferencesFromMetamodelAssociations ++
		namespace_forwardReferencesFromMetamodelAssociations ++
		method ++
		raisedException 

	// Start of user code for additional features
	// End of user code
} //UMLBehavioralFeature
