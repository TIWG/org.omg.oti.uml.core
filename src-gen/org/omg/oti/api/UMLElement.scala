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
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLElement[Uml <: UML]
	extends UMLElementOps[Uml] {
	
	implicit val ops: UMLOps[Uml]
	import ops._

	/**
	 * The Elements owned by this Element.
	 *
	 * <!-- Start of user code doc for ownedElement -->
	 * <!-- End of user code doc for ownedElement -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLElement.owner
	 */
	def ownedElement: Set[UMLElement[Uml]]

	/**
	 * The Element that owns this Element.
	 *
	 * <!-- Start of user code doc for owner -->
	 * <!-- End of user code doc for owner -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLElement.ownedElement
	 */
	def owner: Option[UMLElement[Uml]]

	/**
	 * <!-- Start of user code doc for annotatedElement_comment -->
	 * <!-- End of user code doc for annotatedElement_comment -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComment.annotatedElement
	 */
	def annotatedElement_comment: Set[UMLComment[Uml]]

	/**
	 * <!-- Start of user code doc for constrainedElement_constraint -->
	 * <!-- End of user code doc for constrainedElement_constraint -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.constrainedElement
	 */
	def constrainedElement_constraint: Set[UMLConstraint[Uml]]

	/**
	 * <!-- Start of user code doc for relatedElement_relationship -->
	 * <!-- End of user code doc for relatedElement_relationship -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRelationship.relatedElement
	 */
	def relatedElement_relationship: Set[UMLRelationship[Uml]]

	/**
	 * <!-- Start of user code doc for represents_activityPartition -->
	 * <!-- End of user code doc for represents_activityPartition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.represents
	 */
	def represents_activityPartition: Set[UMLActivityPartition[Uml]]

	/**
	 * <!-- Start of user code doc for source_directedRelationship -->
	 * <!-- End of user code doc for source_directedRelationship -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDirectedRelationship.source
	 */
	def source_directedRelationship: Set[UMLDirectedRelationship[Uml]]

	/**
	 * <!-- Start of user code doc for target_directedRelationship -->
	 * <!-- End of user code doc for target_directedRelationship -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDirectedRelationship.target
	 */
	def target_directedRelationship: Set[UMLDirectedRelationship[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	def metaAttributes: MetaAttributeFunctions =
		element_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLElement
	 *
	 * <!-- Start of user code doc for element_metaAttributes -->
	 * <!-- End of user code doc for element_metaAttributes -->
	 */
	def element_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * The order matters; more general composite meta properties must be before more specific ones.
	 * - composite meta-properties defined in a superclass are more general than composite meta-properties defined in a subclass
	 * - subsetted/redefined composite meta-properties are more general than subsetting/redefining composite meta-properties
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	def compositeMetaProperties: MetaPropertyFunctions =
		element_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLElement
	 *
	 * <!-- Start of user code doc for element_compositeMetaProperties -->
	 * <!-- End of user code doc for element_compositeMetaProperties -->
	 */
	def element_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			Seq (Element_ownedComment))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * The order matters; more general reference meta properties must be before more specific ones.
	 * - reference meta-properties defined in a superclass are more general than reference meta-properties defined in a subclass
	 * - subsetted/redefined reference meta-properties are more general than subsetting/redefining reference meta-properties
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	def referenceMetaProperties: MetaPropertyFunctions =
		element_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLElement
	 *
	 * <!-- Start of user code doc for element_referenceMetaProperties -->
	 * <!-- End of user code doc for element_referenceMetaProperties -->
	 */
	def element_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	def forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLElement
	 *
	 * <!-- Start of user code doc for element_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for element_forwardReferencesFromMetamodelAssociations -->
	 */
	def element_forwardReferencesFromMetamodelAssociations: Elements =
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLElement
