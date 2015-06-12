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
 * A Lifeline represents an individual participant in the Interaction. While parts and structural features may have multiplicity greater than 1, Lifelines represent only one interacting entity.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLLifeline[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLLifelineOps[Uml] {
	
	import ops._

	/**
	 * References the InteractionFragments in which this Lifeline takes part.
	 *
	 * <!-- Start of user code doc for coveredBy -->
	 * <!-- End of user code doc for coveredBy -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInteractionFragment.covered
	 */
	def coveredBy: Set[UMLInteractionFragment[Uml]]

	/**
	 * References the Interaction that represents the decomposition.
	 *
	 * <!-- Start of user code doc for decomposedAs -->
	 * <!-- End of user code doc for decomposedAs -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLPartDecomposition.decomposedAs_lifeline
	 */
	def decomposedAs: Option[UMLPartDecomposition[Uml]]

	/**
	 * References the Interaction enclosing this Lifeline.
	 *
	 * <!-- Start of user code doc for interaction -->
	 * <!-- End of user code doc for interaction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInteraction.lifeline
	 */
	def interaction: Option[UMLInteraction[Uml]]

	/**
	 * References the ConnectableElement within the classifier that contains the enclosing interaction.
	 *
	 * <!-- Start of user code doc for represents -->
	 * <!-- End of user code doc for represents -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConnectableElement.represents_lifeline
	 */
	def represents: Option[UMLConnectableElement[Uml]]

	/**
	 * If the referenced ConnectableElement is multivalued, then this specifies the specific individual part within that set.
	 *
	 * <!-- Start of user code doc for selector -->
	 * <!-- End of user code doc for selector -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.selector_lifeline
	 */
	def selector: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- Start of user code doc for covered_events -->
	 * <!-- End of user code doc for covered_events -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOccurrenceSpecification.covered
	 */
	def covered_events: Seq[UMLOccurrenceSpecification[Uml]]

	/**
	 * <!-- Start of user code doc for covered_stateInvariant -->
	 * <!-- End of user code doc for covered_stateInvariant -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStateInvariant.covered
	 */
	def covered_stateInvariant: Set[UMLStateInvariant[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		lifeline_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLifeline
	 *
	 * <!-- Start of user code doc for lifeline_metaAttributes -->
	 * <!-- End of user code doc for lifeline_metaAttributes -->
	 */
	def lifeline_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		lifeline_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLifeline
	 *
	 * <!-- Start of user code doc for lifeline_compositeMetaProperties -->
	 * <!-- End of user code doc for lifeline_compositeMetaProperties -->
	 */
	def lifeline_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLLifeline[Uml], UMLValueSpecification[Uml]]("selector", _.selector)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		lifeline_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLifeline
	 *
	 * <!-- Start of user code doc for lifeline_referenceMetaProperties -->
	 * <!-- End of user code doc for lifeline_referenceMetaProperties -->
	 */
	def lifeline_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLLifeline[Uml], UMLInteractionFragment[Uml]]("coveredBy", _.coveredBy),
				MetaPropertyReference[Uml, UMLLifeline[Uml], UMLPartDecomposition[Uml]]("decomposedAs", _.decomposedAs),
				MetaPropertyReference[Uml, UMLLifeline[Uml], UMLConnectableElement[Uml]]("represents", _.represents)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		lifeline_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLifeline
	 *
	 * <!-- Start of user code doc for lifeline_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for lifeline_forwardReferencesFromMetamodelAssociations -->
	 */
	def lifeline_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		coveredBy ++
		decomposedAs ++
		interaction ++
		represents 

	// Start of user code for additional features
	// End of user code
} //UMLLifeline
