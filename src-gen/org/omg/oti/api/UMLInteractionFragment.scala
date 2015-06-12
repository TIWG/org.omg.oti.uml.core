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
 * InteractionFragment is an abstract notion of the most general interaction unit. An InteractionFragment is a piece of an Interaction. Each InteractionFragment is conceptually like an Interaction by itself.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLInteractionFragment[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLInteractionFragmentOps[Uml] {
	
	import ops._

	/**
	 * References the Lifelines that the InteractionFragment involves.
	 *
	 * <!-- Start of user code doc for covered -->
	 * <!-- End of user code doc for covered -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLLifeline.coveredBy
	 */
	def covered: Iterable[UMLLifeline[Uml]]

	/**
	 * The Interaction enclosing this InteractionFragment.
	 *
	 * <!-- Start of user code doc for enclosingInteraction -->
	 * <!-- End of user code doc for enclosingInteraction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteraction.fragment
	 */
	def enclosingInteraction: Option[UMLInteraction[Uml]]

	/**
	 * The operand enclosing this InteractionFragment (they may nest recursively).
	 *
	 * <!-- Start of user code doc for enclosingOperand -->
	 * <!-- End of user code doc for enclosingOperand -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInteractionOperand.fragment
	 */
	def enclosingOperand: Option[UMLInteractionOperand[Uml]]

	/**
	 * The general ordering relationships contained in this fragment.
	 *
	 * <!-- Start of user code doc for generalOrdering -->
	 * <!-- End of user code doc for generalOrdering -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralOrdering.generalOrdering_interactionFragment
	 */
	def generalOrdering: Set[UMLGeneralOrdering[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interactionFragment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInteractionFragment
	 *
	 * <!-- Start of user code doc for interactionFragment_metaAttributes -->
	 * <!-- End of user code doc for interactionFragment_metaAttributes -->
	 */
	def interactionFragment_metaAttributes: MetaAttributeFunctions = 
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
		interactionFragment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInteractionFragment
	 *
	 * <!-- Start of user code doc for interactionFragment_compositeMetaProperties -->
	 * <!-- End of user code doc for interactionFragment_compositeMetaProperties -->
	 */
	def interactionFragment_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInteractionFragment[Uml], UMLGeneralOrdering[Uml]]("generalOrdering", _.generalOrdering)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interactionFragment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInteractionFragment
	 *
	 * <!-- Start of user code doc for interactionFragment_referenceMetaProperties -->
	 * <!-- End of user code doc for interactionFragment_referenceMetaProperties -->
	 */
	def interactionFragment_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInteractionFragment[Uml], UMLLifeline[Uml]]("covered", _.covered)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInteractionFragment
	 *
	 * <!-- Start of user code doc for interactionFragment_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for interactionFragment_forwardReferencesFromMetamodelAssociations -->
	 */
	def interactionFragment_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		covered ++
		enclosingInteraction ++
		enclosingOperand 

	// Start of user code for additional features
	// End of user code
} //UMLInteractionFragment
