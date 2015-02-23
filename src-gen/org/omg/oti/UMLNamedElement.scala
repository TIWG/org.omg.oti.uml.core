package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A NamedElement is an Element in a model that may have a name. The name may be given directly and/or via the use of a StringExpression.
 * <!-- end-user-doc --> 
 */
trait UMLNamedElement[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLNamedElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		namedElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLNamedElement
	 */
	def namedElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLNamedElement[Uml]](None, "name", (x) => stringToIterable(x.name, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		namedElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLNamedElement
	 */
	def namedElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq (MetaPropertyReference[UMLNamedElement[Uml], UMLStringExpression[Uml]]("nameExpression", _.nameExpression)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		namedElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLNamedElement
	 */
	def namedElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLNamedElement
	 */
	def namedElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates the Dependencies that reference this NamedElement as a client.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (Dependency.allInstances()->select(d | d.client->includes(self)))
	 */
	def clientDependency: Set[UMLDependency[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * The name of the NamedElement.
	 * <!-- end-user-doc -->
	 */
	def name: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * The StringExpression used to define the name of this NamedElement.
	 * <!-- end-user-doc -->
	 */
	def nameExpression: Option[UMLStringExpression[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Namespace that owns the NamedElement.
	 * <!-- end-user-doc -->
	 */
	def namespace: Option[UMLNamespace[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A name that allows the NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from the names of the containing Namespaces starting at the root of the hierarchy and ending with the name of the NamedElement itself.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if self.name <> null and self.allNamespaces()->select( ns | ns.name=null )->isEmpty()
	 * then 
	 *     self.allNamespaces()->iterate( ns : Namespace; agg: String = self.name | ns.name.concat(self.separator()).concat(agg))
	 * else
	 *    null
	 * endif)
	 */
	def qualifiedName: Option[String]

	/**
	 * <!-- begin-user-doc --> 
	 * Determines whether and how the NamedElement is visible outside its owning Namespace.
	 * <!-- end-user-doc -->
	 */
	def visibility: UMLVisibilityKind.Value 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def event_durationObservation: Set[UMLDurationObservation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def event_timeObservation: Set[UMLTimeObservation[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates the dependencies that reference the supplier.
	 * <!-- end-user-doc -->
	 */
	def supplier_supplierDependency: Set[UMLDependency[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def informationSource_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def member_memberNamespace: Set[UMLNamespace[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def signature_message: Set[UMLMessage[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def informationTarget_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def message_considerIgnoreFragment: Set[UMLConsiderIgnoreFragment[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def inheritedMember_inheritingClassifier: Set[UMLClassifier[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLNamedElement
