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
 * A Property is a StructuralFeature. A Property related by ownedAttribute to a Classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the Classifier to a value or set of values of the type of the attribute. A Property related by memberEnd to an Association represents an end of the Association. The type of the Property is the type of the end of the Association. A Property has the capability of being a DeploymentTarget in a Deployment relationship. This enables modeling the deployment to hierarchical nodes that have Properties functioning as internal parts.  Property specializes ParameterableElement to specify that a Property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 */
trait UMLProperty[Uml <: UML]
	extends UMLConnectableElement[Uml]
	with UMLDeploymentTarget[Uml]
	with UMLStructuralFeature[Uml]
	with UMLPropertyOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Class that owns this Property, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClass.ownedAttribute
	 */
	def _class: Option[UMLClass[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the kind of aggregation that applies to the Property.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def aggregation: UMLAggregationKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * The Association of which this Property is a member, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAssociation.memberEnd
	 */
	def association: Option[UMLAssociation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Designates the optional association end that owns a qualifier attribute.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.qualifier
	 */
	def associationEnd: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The DataType that owns this Property, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLDataType.ownedAttribute
	 */
	def datatype: Option[UMLDataType[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A ValueSpecification that is evaluated to give a default value for the Property when an instance of the owning Classifier is instantiated.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.defaultValue_owningProperty
	 */
	def defaultValue: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Interface that owns this Property, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterface.ownedAttribute
	 */
	def interface: Option[UMLInterface[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * If isComposite is true, the object containing the attribute is a container for the object or value contained in the attribute. This is a derived value, indicating whether the aggregation of the Property is composite or not.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isComposite: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether the Property is derived, i.e., whether its value or values can be computed from other information.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDerived: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether the property is derived as the union of all of the Properties that are constrained to subset it.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDerivedUnion: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * True indicates this property can be used to uniquely identify an instance of the containing Class.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isID: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * In the case where the Property is one end of a binary association this gives the other end.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.opposite_property
	 */
	def opposite: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The owning association of this property, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAssociation.ownedEnd
	 */
	def owningAssociation: Option[UMLAssociation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An optional list of ordered qualifier attributes for the end.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.associationEnd
	 */
	def qualifier: Seq[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The properties that are redefined by this property, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.redefinedProperty_property
	 */
	def redefinedProperty: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The properties of which this Property is constrained to be a subset, if any.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.subsettedProperty_property
	 */
	def subsettedProperty: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.attribute
	 */
	def attribute_classifier: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnectorEnd.definingEnd
	 */
	def definingEnd_connectorEnd: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLLinkEndData.end
	 */
	def end_linkEndData: Set[UMLLinkEndData[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndAction.end
	 */
	def end_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLAssociation.navigableOwnedEnd
	 */
	def navigableOwnedEnd_association: Option[UMLAssociation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.opposite
	 */
	def opposite_property: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLArtifact.ownedAttribute
	 */
	def ownedAttribute_artifact: Option[UMLArtifact[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLSignal.ownedAttribute
	 */
	def ownedAttribute_owningSignal: Option[UMLSignal[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredClassifier.ownedAttribute
	 */
	def ownedAttribute_structuredClassifier: Iterable[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConnectorEnd.partWithPort
	 */
	def partWithPort_connectorEnd: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredClassifier.part
	 */
	def part_structuredClassifier: Option[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLQualifierValue.qualifier
	 */
	def qualifier_qualifierValue: Set[UMLQualifierValue[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLReadLinkObjectEndQualifierAction.qualifier
	 */
	def qualifier_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.redefinedProperty
	 */
	def redefinedProperty_property: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInteractionUse.returnValueRecipient
	 */
	def returnValueRecipient_interactionUse: Set[UMLInteractionUse[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty.subsettedProperty
	 */
	def subsettedProperty_property: Set[UMLProperty[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		property_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLProperty
	 */
	def property_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			connectableElement_metaAttributes,
			deploymentTarget_metaAttributes,
			structuralFeature_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLProperty[Uml]](None, "isDerived", (x) => booleanToIterable(x.isDerived, false)),
				MetaAttributeBooleanFunction[Uml, UMLProperty[Uml]](None, "isDerivedUnion", (x) => booleanToIterable(x.isDerivedUnion, false)),
				MetaAttributeBooleanFunction[Uml, UMLProperty[Uml]](None, "isID", (x) => booleanToIterable(x.isID, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		property_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLProperty
	 */
	def property_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_compositeMetaProperties,
			deploymentTarget_compositeMetaProperties,
			structuralFeature_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLProperty[Uml], UMLValueSpecification[Uml]]("defaultValue", _.defaultValue),
				MetaPropertyCollection[Uml, UMLProperty[Uml], UMLProperty[Uml]]("qualifier", _.qualifier)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		property_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLProperty
	 */
	def property_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_referenceMetaProperties,
			deploymentTarget_referenceMetaProperties,
			structuralFeature_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLProperty[Uml], UMLAssociation[Uml]]("association", _.association),
				MetaPropertyReference[Uml, UMLProperty[Uml], UMLProperty[Uml]]("associationEnd", _.associationEnd),
				MetaPropertyReference[Uml, UMLProperty[Uml], UMLClass[Uml]]("class", _._class),
				MetaPropertyReference[Uml, UMLProperty[Uml], UMLDataType[Uml]]("datatype", _.datatype),
				MetaPropertyReference[Uml, UMLProperty[Uml], UMLInterface[Uml]]("interface", _.interface),
				MetaPropertyReference[Uml, UMLProperty[Uml], UMLAssociation[Uml]]("owningAssociation", _.owningAssociation),
				MetaPropertyCollection[Uml, UMLProperty[Uml], UMLProperty[Uml]]("redefinedProperty", _.redefinedProperty),
				MetaPropertyCollection[Uml, UMLProperty[Uml], UMLProperty[Uml]]("subsettedProperty", _.subsettedProperty)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		property_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLProperty
	 */
	def property_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		deploymentTarget_forwardReferencesFromMetamodelAssociations ++
		structuralFeature_forwardReferencesFromMetamodelAssociations ++
		association ++
		associationEnd ++
		_class ++
		datatype ++
		interface ++
		owningAssociation ++
		redefinedProperty ++
		subsettedProperty 

} //UMLProperty
