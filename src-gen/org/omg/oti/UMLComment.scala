package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Comment is a textual annotation that can be attached to a set of Elements.
 * <!-- end-user-doc --> 
 */
trait UMLComment[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLCommentOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		comment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLComment
	 */
	def comment_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq (MetaAttributeStringFunction[Uml, UMLComment[Uml]](None, "body", (x) => stringToIterable(x.body, null))) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		comment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLComment
	 */
	def comment_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		comment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLComment
	 */
	def comment_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyCollection[Uml, UMLComment[Uml], UMLElement[Uml]]("annotatedElement", _.annotatedElement)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		comment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLComment
	 */
	def comment_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		annotatedElement 

	/**
	 * <!-- begin-user-doc --> 
	 * References the Element(s) being commented.
	 * <!-- end-user-doc -->
	 */
	def annotatedElement: Set[UMLElement[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies a string that is the comment.
	 * <!-- end-user-doc -->
	 */
	def body: Option[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def ownedComment_owningElement: Option[UMLElement[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLComment
