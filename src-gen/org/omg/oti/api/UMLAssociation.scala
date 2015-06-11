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
 * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.

 * <!-- end-model-doc -->
 */
trait UMLAssociation[Uml <: UML]
	extends UMLClassifier[Uml]
	with UMLRelationship[Uml]
	with UMLAssociationOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Classifiers that are used as types of the ends of the Association.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLType.endType_association
	 */
	def endType: Set[UMLType[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether the Association is derived from other model elements such as other Associations.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDerived: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Each end represents participation of instances of the Classifier connected to the end in links of the Association.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="2..*"
	 * @opposite org.omg.oti.api.UMLProperty.association
	 */
	def memberEnd: Seq[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The navigable ends that are owned by the Association itself.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.navigableOwnedEnd_association
	 */
	def navigableOwnedEnd: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ends that are owned by the Association itself.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.owningAssociation
	 */
	def ownedEnd: Iterable[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClearAssociationAction.association
	 */
	def association_clearAssociationAction: Option[UMLClearAssociationAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnector._type
	 */
	def type_connector: Set[UMLConnector[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		association_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLAssociation
	 */
	def association_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			classifier_metaAttributes,
			relationship_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLAssociation[Uml]](None, "isDerived", (x) => booleanToIterable(x.isDerived, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		association_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLAssociation
	 */
	def association_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_compositeMetaProperties,
			relationship_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]]("ownedEnd", _.ownedEnd, true)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		association_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLAssociation
	 */
	def association_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			classifier_referenceMetaProperties,
			relationship_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]]("memberEnd", _.memberEnd, true),
				MetaPropertyCollection[Uml, UMLAssociation[Uml], UMLProperty[Uml]]("navigableOwnedEnd", _.navigableOwnedEnd)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		association_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLAssociation
	 */
	def association_forwardReferencesFromMetamodelAssociations: Elements =
		classifier_forwardReferencesFromMetamodelAssociations ++
		relationship_forwardReferencesFromMetamodelAssociations ++
		memberEnd ++
		navigableOwnedEnd 

} //UMLAssociation
