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
 * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLRegion[Uml <: UML]
	extends UMLNamespace[Uml]
	with UMLRedefinableElement[Uml]
	with UMLRegionOps[Uml] {
	
	import ops._

	/**
	 * The region of which this region is an extension.
	 *
	 * <!-- Start of user code doc for extendedRegion -->
	 * <!-- End of user code doc for extendedRegion -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLRegion.extendedRegion_region
	 */
	def extendedRegion: Option[UMLRegion[Uml]]

	/**
	 * References the Classifier in which context this element may be redefined.
	 *
	 * <!-- Start of user code doc for redefinitionContext -->
	 * <!-- End of user code doc for redefinitionContext -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.redefinitionContext_region
	 * @body result = (let sm : StateMachine = containingStateMachine() in
	 * if sm._'context' = null or sm.general->notEmpty() then
	 *   sm
	 * else
	 *   sm._'context'
	 * endif)
	 */
	override def redefinitionContext: Iterable[UMLClassifier[Uml]]

	/**
	 * The State that owns the Region. If a Region is owned by a State, then it cannot also be owned by a StateMachine.
	 *
	 * <!-- Start of user code doc for state -->
	 * <!-- End of user code doc for state -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLState.region
	 */
	def state: Option[UMLState[Uml]]

	/**
	 * The StateMachine that owns the Region. If a Region is owned by a StateMachine, then it cannot also be owned by a State.
	 *
	 * <!-- Start of user code doc for stateMachine -->
	 * <!-- End of user code doc for stateMachine -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStateMachine.region
	 */
	def stateMachine: Option[UMLStateMachine[Uml]]

	/**
	 * The set of Vertices that are owned by this Region.
	 *
	 * <!-- Start of user code doc for subvertex -->
	 * <!-- End of user code doc for subvertex -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVertex.container
	 */
	def subvertex: Set[UMLVertex[Uml]]

	/**
	 * The set of Transitions owned by the Region.
	 *
	 * <!-- Start of user code doc for transition -->
	 * <!-- End of user code doc for transition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLTransition.container
	 */
	def transition: Set[UMLTransition[Uml]]

	/**
	 * <!-- Start of user code doc for extendedRegion_region -->
	 * <!-- End of user code doc for extendedRegion_region -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRegion.extendedRegion
	 */
	def extendedRegion_region: Set[UMLRegion[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		region_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRegion
	 *
	 * <!-- Start of user code doc for region_metaAttributes -->
	 * <!-- End of user code doc for region_metaAttributes -->
	 */
	def region_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namespace_metaAttributes,
			redefinableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		region_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRegion
	 *
	 * <!-- Start of user code doc for region_compositeMetaProperties -->
	 * <!-- End of user code doc for region_compositeMetaProperties -->
	 */
	def region_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_compositeMetaProperties,
			redefinableElement_compositeMetaProperties,
			Seq (Region_subvertex,
				Region_transition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		region_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRegion
	 *
	 * <!-- Start of user code doc for region_referenceMetaProperties -->
	 * <!-- End of user code doc for region_referenceMetaProperties -->
	 */
	def region_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namespace_referenceMetaProperties,
			redefinableElement_referenceMetaProperties,
			Seq (Region_extendedRegion))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		region_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRegion
	 *
	 * <!-- Start of user code doc for region_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for region_forwardReferencesFromMetamodelAssociations -->
	 */
	def region_forwardReferencesFromMetamodelAssociations: Elements =
		namespace_forwardReferencesFromMetamodelAssociations ++
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		extendedRegion ++
		state ++
		stateMachine 

	// Start of user code for additional features
	// End of user code
} //UMLRegion
