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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLPropertyOps

// End of user code

/**
 * A Property is a StructuralFeature. A Property related by ownedAttribute to a Classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the Classifier to a value or set of values of the type of the attribute. A Property related by memberEnd to an Association represents an end of the Association. The type of the Property is the type of the end of the Association. A Property has the capability of being a DeploymentTarget in a Deployment relationship. This enables modeling the deployment to hierarchical nodes that have Properties functioning as internal parts.  Property specializes ParameterableElement to specify that a Property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLProperty[Uml <: UML]
	extends UMLConnectableElement[Uml]
	with UMLDeploymentTarget[Uml]
	with UMLStructuralFeature[Uml]
	with UMLPropertyOps[Uml] {
	
	import ops._

	/**
	 * Specifies the kind of aggregation that applies to the Property.
	 *
	 * <!-- Start of user code doc for aggregation -->
   * <!-- End of user code doc for aggregation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def aggregation: UMLAggregationKind.Value

	/**
	 * A ValueSpecification that is evaluated to give a default value for the Property when an instance of the owning Classifier is instantiated.
	 *
	 * <!-- Start of user code doc for defaultValue -->
   * <!-- End of user code doc for defaultValue -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.defaultValue_owningProperty
	 */
	def defaultValue: Option[UMLValueSpecification[Uml]]

	/**
	 * Specifies whether the Property is derived, i.e., whether its value or values can be computed from other information.
	 *
	 * <!-- Start of user code doc for isDerived -->
   * <!-- End of user code doc for isDerived -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDerived: Boolean

	/**
	 * Specifies whether the property is derived as the union of all of the Properties that are constrained to subset it.
	 *
	 * <!-- Start of user code doc for isDerivedUnion -->
   * <!-- End of user code doc for isDerivedUnion -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDerivedUnion: Boolean

	/**
	 * True indicates this property can be used to uniquely identify an instance of the containing Class.
	 *
	 * <!-- Start of user code doc for isID -->
   * <!-- End of user code doc for isID -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isID: Boolean

	/**
	 * An optional list of ordered qualifier attributes for the end.
	 *
	 * <!-- Start of user code doc for qualifier -->
   * <!-- End of user code doc for qualifier -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.associationEnd
	 */
	def qualifier: Seq[UMLProperty[Uml]]

	/**
	 * The properties of which this Property is constrained to be a subset, if any.
	 *
	 * <!-- Start of user code doc for subsettedProperty -->
   * <!-- End of user code doc for subsettedProperty -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.subsettedProperty_property
	 */
	def subsettedProperty: Set[UMLProperty[Uml]]

	/**
	 * <!-- Start of user code doc for attribute_classifier -->
   * <!-- End of user code doc for attribute_classifier -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.attribute
	 */
	def attribute_classifier: Option[UMLClassifier[Uml]]

	/**
	 * <!-- Start of user code doc for definingEnd_connectorEnd -->
   * <!-- End of user code doc for definingEnd_connectorEnd -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectorEnd.definingEnd
	 */
	def definingEnd_connectorEnd: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- Start of user code doc for end_linkEndData -->
   * <!-- End of user code doc for end_linkEndData -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLLinkEndData.end
	 */
	def end_linkEndData: Set[UMLLinkEndData[Uml]]

	/**
	 * <!-- Start of user code doc for end_readLinkObjectEndAction -->
   * <!-- End of user code doc for end_readLinkObjectEndAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkObjectEndAction.end
	 */
	def end_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]]

	/**
	 * <!-- Start of user code doc for navigableOwnedEnd_association -->
   * <!-- End of user code doc for navigableOwnedEnd_association -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.navigableOwnedEnd
	 */
	def navigableOwnedEnd_association: Option[UMLAssociation[Uml]]

	/**
	 * <!-- Start of user code doc for opposite_property -->
   * <!-- End of user code doc for opposite_property -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.opposite
	 */
	def opposite_property: Option[UMLProperty[Uml]]

	/**
	 * <!-- Start of user code doc for partWithPort_connectorEnd -->
   * <!-- End of user code doc for partWithPort_connectorEnd -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectorEnd.partWithPort
	 */
	def partWithPort_connectorEnd: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- Start of user code doc for part_structuredClassifier -->
   * <!-- End of user code doc for part_structuredClassifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredClassifier.part
	 */
	def part_structuredClassifier: Option[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- Start of user code doc for qualifier_qualifierValue -->
   * <!-- End of user code doc for qualifier_qualifierValue -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLQualifierValue.qualifier
	 */
	def qualifier_qualifierValue: Set[UMLQualifierValue[Uml]]

	/**
	 * <!-- Start of user code doc for qualifier_readLinkObjectEndQualifierAction -->
   * <!-- End of user code doc for qualifier_readLinkObjectEndQualifierAction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLReadLinkObjectEndQualifierAction.qualifier
	 */
	def qualifier_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]]

	/**
	 * <!-- Start of user code doc for returnValueRecipient_interactionUse -->
   * <!-- End of user code doc for returnValueRecipient_interactionUse -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionUse.returnValueRecipient
	 */
	def returnValueRecipient_interactionUse: Set[UMLInteractionUse[Uml]]

	/**
	 * <!-- Start of user code doc for subsettedProperty_property -->
   * <!-- End of user code doc for subsettedProperty_property -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.subsettedProperty
	 */
	def subsettedProperty_property: Set[UMLProperty[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		property_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProperty
	 *
	 * <!-- Start of user code doc for property_metaAttributes -->
   * <!-- End of user code doc for property_metaAttributes -->
	 */
	def property_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			connectableElement_metaAttributes,
			deploymentTarget_metaAttributes,
			structuralFeature_metaAttributes,
			Seq (Property_isDerived,
				Property_isDerivedUnion,
				Property_isID))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		property_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProperty
	 *
	 * <!-- Start of user code doc for property_compositeMetaProperties -->
   * <!-- End of user code doc for property_compositeMetaProperties -->
	 */
	def property_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_compositeMetaProperties,
			deploymentTarget_compositeMetaProperties,
			structuralFeature_compositeMetaProperties,
			Seq (Property_defaultValue,
				Property_qualifier))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		property_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProperty
	 *
	 * <!-- Start of user code doc for property_referenceMetaProperties -->
   * <!-- End of user code doc for property_referenceMetaProperties -->
	 */
	def property_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_referenceMetaProperties,
			deploymentTarget_referenceMetaProperties,
			structuralFeature_referenceMetaProperties,
			Seq (Property_association,
				Property_redefinedProperty,
				Property_subsettedProperty))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		property_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProperty
	 *
	 * <!-- Start of user code doc for property_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for property_forwardReferencesFromMetamodelAssociations -->
	 */
	def property_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		deploymentTarget_forwardReferencesFromMetamodelAssociations ++
		structuralFeature_forwardReferencesFromMetamodelAssociations ++
		association ++
		redefinedProperty ++
		subsettedProperty

	// Start of user code for additional features
  // End of user code
} //UMLProperty
