package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A RedefinableElement is an element that, when defined in the context of a Classifier, can be redefined more specifically or differently in the context of another Classifier that specializes (directly or indirectly) the context Classifier.
 * <!-- end-user-doc --> 
 */
trait UMLRedefinableElement[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLRedefinableElementOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		redefinableElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLRedefinableElement
	 */
	def redefinableElement_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq (MetaAttributeBooleanFunction[UMLRedefinableElement[Uml]](None, "isLeaf", (x) => booleanToIterable(x.isLeaf, false))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		redefinableElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLRedefinableElement
	 */
	def redefinableElement_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		redefinableElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLRedefinableElement
	 */
	def redefinableElement_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLRedefinableElement
	 */
	def redefinableElement_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * Indicates whether it is possible to further redefine a RedefinableElement. If the value is true, then it is not possible to further redefine the RedefinableElement.
	 * <!-- end-user-doc -->
	 */
	def isLeaf: Boolean = false

	/**
	 * <!-- begin-user-doc --> 
	 * The RedefinableElement that is being redefined by this element.
	 * <!-- end-user-doc -->
	 */
	def redefinedElement: Set[UMLRedefinableElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The contexts that this element may be redefined from.
	 * <!-- end-user-doc -->
	 */
	def redefinitionContext: Iterable[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def redefinedElement_redefinableElement: Set[UMLRedefinableElement[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLRedefinableElement
