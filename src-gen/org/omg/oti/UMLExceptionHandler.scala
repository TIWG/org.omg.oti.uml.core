package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExceptionHandler is an Element that specifies a handlerBody ExecutableNode to execute in case the specified exception occurs during the execution of the protected ExecutableNode.
 * <!-- end-user-doc --> 
 */
trait UMLExceptionHandler[Uml <: UML]
  extends UMLElement[Uml] with operations.UMLExceptionHandlerOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		exceptionHandler_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExceptionHandler
	 */
	def exceptionHandler_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		element_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		exceptionHandler_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExceptionHandler
	 */
	def exceptionHandler_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		exceptionHandler_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExceptionHandler
	 */
	def exceptionHandler_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		element_referenceMetaProperties,
		  Seq (MetaPropertyReference[UMLExceptionHandler[Uml], UMLObjectNode[Uml]]("exceptionInput", _.exceptionInput),
		  	MetaPropertyCollection[UMLExceptionHandler[Uml], UMLClassifier[Uml]]("exceptionType", _.exceptionType),
		  	MetaPropertyReference[UMLExceptionHandler[Uml], UMLExecutableNode[Uml]]("handlerBody", _.handlerBody),
		  	MetaPropertyReference[UMLExceptionHandler[Uml], UMLExecutableNode[Uml]]("protectedNode", _.protectedNode)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		exceptionHandler_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExceptionHandler
	 */
	def exceptionHandler_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		exceptionInput ++
		exceptionType ++
		handlerBody ++
		protectedNode 

	/**
	 * <!-- begin-user-doc --> 
	 * An ObjectNode within the handlerBody. When the ExceptionHandler catches an exception, the exception token is placed on this ObjectNode, causing the handlerBody to execute.
	 * <!-- end-user-doc -->
	 */
	def exceptionInput: Option[UMLObjectNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The Classifiers whose instances the ExceptionHandler catches as exceptions. If an exception occurs whose type is any exceptionType, the ExceptionHandler catches the exception and executes the handlerBody.
	 * <!-- end-user-doc -->
	 */
	def exceptionType: Set[UMLClassifier[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * An ExecutableNode that is executed if the ExceptionHandler catches an exception.
	 * <!-- end-user-doc -->
	 */
	def handlerBody: Option[UMLExecutableNode[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * The ExecutableNode protected by the ExceptionHandler. If an exception propagates out of the protectedNode and has a type matching one of the exceptionTypes, then it is caught by this ExceptionHandler.
	 * <!-- end-user-doc -->
	 */
	def protectedNode: Option[UMLExecutableNode[Uml]] 

// Start of user code for additional featuers
// End of user code

} //UMLExceptionHandler
