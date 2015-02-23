package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An OpaqueExpression is a ValueSpecification that specifies the computation of a collection of values either in terms of a UML Behavior or based on a textual statement in a language other than UML
 * <!-- end-user-doc --> 
 */
trait UMLOpaqueExpression[Uml <: UML]
  extends UMLValueSpecification[Uml] with operations.UMLOpaqueExpressionOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		opaqueExpression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOpaqueExpression
	 */
	def opaqueExpression_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		valueSpecification_metaAttributes,
		  Seq (MetaAttributeStringFunction[UMLOpaqueExpression[Uml]](None, "body", _.body),
		  	MetaAttributeStringFunction[UMLOpaqueExpression[Uml]](None, "language", _.language)) )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		opaqueExpression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOpaqueExpression
	 */
	def opaqueExpression_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		opaqueExpression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOpaqueExpression
	 */
	def opaqueExpression_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		valueSpecification_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLOpaqueExpression[Uml], UMLBehavior[Uml]]("behavior", _.behavior)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		opaqueExpression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOpaqueExpression
	 */
	def opaqueExpression_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		behavior 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the behavior of the OpaqueExpression as a UML Behavior.
	 * <!-- end-user-doc -->
	 */
	def behavior: Option[UMLBehavior[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * A textual definition of the behavior of the OpaqueExpression, possibly in multiple languages.
	 * <!-- end-user-doc -->
	 */
	def body: Seq[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the languages used to express the textual bodies of the OpaqueExpression.  Languages are matched to body Strings by order. The interpretation of the body depends on the languages. If the languages are unspecified, they may be implicit from the expression body or the context.
	 * <!-- end-user-doc -->
	 */
	def language: Seq[String] 

	/**
	 * <!-- begin-user-doc --> 
	 * If an OpaqueExpression is specified using a UML Behavior, then this refers to the single required return Parameter of that Behavior. When the Behavior completes execution, the values on this Parameter give the result of evaluating the OpaqueExpression.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (if behavior = null then
	 * 	null
	 * else
	 * 	behavior.ownedParameter->first()
	 * endif)
	 */
	def result: Option[UMLParameter[Uml]] = {
	    // Start of user code for "result"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def mapping_abstraction: Option[UMLAbstraction[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLOpaqueExpression
