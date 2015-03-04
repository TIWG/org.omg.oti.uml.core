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
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 * <!-- end-model-doc --> 
 */
trait UMLElement[Uml <: UML]
	extends UMLElementOps[Uml] { 
	
	implicit val ops: UMLOps[Uml]
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Comments owned by this Element.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComment.ownedComment_owningElement
	 */
	def ownedComment: Set[UMLComment[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Elements owned by this Element.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLElement.owner
	 */
	def ownedElement: Set[UMLElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Element that owns this Element.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLElement.ownedElement
	 */
	def owner: Option[UMLElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComment.annotatedElement
	 */
	def annotatedElement_comment: Set[UMLComment[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.constrainedElement
	 */
	def constrainedElement_constraint: Set[UMLConstraint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLRelationship.relatedElement
	 */
	def relatedElement_relationship: Set[UMLRelationship[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.represents
	 */
	def represents_activityPartition: Set[UMLActivityPartition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDirectedRelationship.source
	 */
	def source_directedRelationship: Set[UMLDirectedRelationship[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDirectedRelationship.target
	 */
	def target_directedRelationship: Set[UMLDirectedRelationship[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	def metaAttributes: MetaAttributeFunctions =
		element_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLElement
	 */
	def element_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	def compositeMetaProperties: MetaPropertyFunctions =
		element_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLElement
	 */
	def element_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			Seq (MetaPropertyCollection[Uml, UMLElement[Uml], UMLComment[Uml]]("ownedComment", _.ownedComment)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	def referenceMetaProperties: MetaPropertyFunctions =
		element_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLElement
	 */
	def element_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	def forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLElement
	 */
	def element_forwardReferencesFromMetamodelAssociations: Elements =
		Set () 

} //UMLElement
