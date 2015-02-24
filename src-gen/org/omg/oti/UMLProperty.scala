package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Property is a StructuralFeature. A Property related by ownedAttribute to a Classifier (other than an association) represents an attribute and might also represent an association end. It relates an instance of the Classifier to a value or set of values of the type of the attribute. A Property related by memberEnd to an Association represents an end of the Association. The type of the Property is the type of the end of the Association. A Property has the capability of being a DeploymentTarget in a Deployment relationship. This enables modeling the deployment to hierarchical nodes that have Properties functioning as internal parts.  Property specializes ParameterableElement to specify that a Property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-user-doc --> 
 */
trait UMLProperty[Uml <: UML]
  extends UMLConnectableElement[Uml] with UMLStructuralFeature[Uml] with UMLDeploymentTarget[Uml] with operations.UMLPropertyOps[Uml] {
	
	import ops._

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
		structuralFeature_metaAttributes,
		deploymentTarget_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLProperty[Uml]](None, "isDerived", (x) => booleanToIterable(x.isDerived, false)),
		  	MetaAttributeBooleanFunction[UMLProperty[Uml]](None, "isDerivedUnion", (x) => booleanToIterable(x.isDerivedUnion, false)),
		  	MetaAttributeBooleanFunction[UMLProperty[Uml]](None, "isID", (x) => booleanToIterable(x.isID, false))) )

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
		structuralFeature_compositeMetaProperties,
		deploymentTarget_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLProperty[Uml], UMLValueSpecification[Uml]]("defaultValue", _.defaultValue),
		  	MetaPropertyCollection[UMLProperty[Uml], UMLProperty[Uml]]("qualifier", _.qualifier)) )

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
		structuralFeature_referenceMetaProperties,
		deploymentTarget_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLProperty[Uml], UMLAssociation[Uml]]("association", _.association),
		  	MetaPropertyReference[UMLProperty[Uml], UMLProperty[Uml]]("associationEnd", _.associationEnd),
		  	MetaPropertyReference[UMLProperty[Uml], UMLClass[Uml]]("class", _._class),
		  	MetaPropertyReference[UMLProperty[Uml], UMLDataType[Uml]]("datatype", _.datatype),
		  	MetaPropertyReference[UMLProperty[Uml], UMLInterface[Uml]]("interface", _.interface),
		  	MetaPropertyReference[UMLProperty[Uml], UMLAssociation[Uml]]("owningAssociation", _.owningAssociation),
		  	MetaPropertyCollection[UMLProperty[Uml], UMLProperty[Uml]]("redefinedProperty", _.redefinedProperty),
		  	MetaPropertyCollection[UMLProperty[Uml], UMLProperty[Uml]]("subsettedProperty", _.subsettedProperty)) )

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
		structuralFeature_forwardReferencesFromMetamodelAssociations ++
		deploymentTarget_forwardReferencesFromMetamodelAssociations ++
		association ++
		associationEnd ++
		_class ++
		datatype ++
		interface ++
		owningAssociation ++
		redefinedProperty ++
		subsettedProperty 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the kind of aggregation that applies to the Property.
	 * <!-- end-user-doc -->
	 */
	def aggregation: UMLAggregationKind.Value

	/**
	 * <!-- begin-user-doc --> 
	 * The Association of which this Property is a member, if any.
	 * <!-- end-user-doc -->
	 */
	def association: Option[UMLAssociation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Designates the optional association end that owns a qualifier attribute.
	 * <!-- end-user-doc -->
	 */
	def associationEnd: Option[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Class that owns this Property, if any.
	 * <!-- end-user-doc -->
	 */
	def _class: Option[UMLClass[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The DataType that owns this Property, if any.
	 * <!-- end-user-doc -->
	 */
	def datatype: Option[UMLDataType[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A ValueSpecification that is evaluated to give a default value for the Property when an instance of the owning Classifier is instantiated.
	 * <!-- end-user-doc -->
	 */
	def defaultValue: Option[UMLValueSpecification[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Interface that owns this Property, if any.
	 * <!-- end-user-doc -->
	 */
	def interface: Option[UMLInterface[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * If isComposite is true, the object containing the attribute is a container for the object or value contained in the attribute. This is a derived value, indicating whether the aggregation of the Property is composite or not.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (aggregation = AggregationKind::composite)
	 */
	def isComposite: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the Property is derived, i.e., whether its value or values can be computed from other information.
	 * <!-- end-user-doc -->
	 */
	def isDerived: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies whether the property is derived as the union of all of the Properties that are constrained to subset it.
	 * <!-- end-user-doc -->
	 */
	def isDerivedUnion: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * True indicates this property can be used to uniquely identify an instance of the containing Class.
	 * <!-- end-user-doc -->
	 */
	def isID: Boolean

	/**
	 * <!-- begin-user-doc --> 
	 * In the case where the Property is one end of a binary association this gives the other end.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if association <> null and association.memberEnd->size() = 2
	 * then
	 *     association.memberEnd->any(e | e <> self)
	 * else
	 *     null
	 * endif)
	 */
	def opposite: Option[UMLProperty[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The owning association of this property, if any.
	 * <!-- end-user-doc -->
	 */
	def owningAssociation: Option[UMLAssociation[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An optional list of ordered qualifier attributes for the end.
	 * <!-- end-user-doc -->
	 */
	def qualifier: Seq[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The properties that are redefined by this property, if any.
	 * <!-- end-user-doc -->
	 */
	def redefinedProperty: Set[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The properties of which this Property is constrained to be a subset, if any.
	 * <!-- end-user-doc -->
	 */
	def subsettedProperty: Set[UMLProperty[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute_artifact: Option[UMLArtifact[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * BUG: Missing from Figure 17.18
	 * <!-- end-user-doc -->
	 */
	def returnValueRecipient_interactionUse: Set[UMLInteractionUse[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def qualifier_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute_owningSignal: Option[UMLSignal[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def qualifier_qualifierValue: Set[UMLQualifierValue[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * FIX: should be Option, not Iterable
	 * <!-- end-user-doc -->
	 */
	def ownedAttribute_structuredClassifier: Option[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def part_structuredClassifier: Option[UMLStructuredClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def end_linkEndData: Set[UMLLinkEndData[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def end_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def partWithPort_connectorEnd: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedProperty_property: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def definingEnd_connectorEnd: Set[UMLConnectorEnd[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def attribute_classifier: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def subsettedProperty_property: Set[UMLProperty[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def navigableOwnedEnd_association: Option[UMLAssociation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def opposite_property: Option[UMLProperty[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLProperty
