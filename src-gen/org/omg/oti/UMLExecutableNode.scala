package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * An ExecutableNode is an abstract class for ActivityNodes whose execution may be controlled using ControlFlows and to which ExceptionHandlers may be attached.
 * <!-- end-user-doc --> 
 */
trait UMLExecutableNode[Uml <: UML]
  extends UMLActivityNode[Uml] with operations.UMLExecutableNodeOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		executableNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExecutableNode
	 */
	def executableNode_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		activityNode_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		executableNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExecutableNode
	 */
	def executableNode_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityNode_compositeMetaProperties,
		  Seq (MetaPropertyCollection[UMLExecutableNode[Uml], UMLExceptionHandler[Uml]]("handler", _.handler)) )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		executableNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExecutableNode
	 */
	def executableNode_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		activityNode_referenceMetaProperties,
		  Seq () )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		executableNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExecutableNode
	 */
	def executableNode_forwardReferencesFromMetamodelAssociations: Elements =
		activityNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	/**
	 * <!-- begin-user-doc --> 
	 * A set of ExceptionHandlers that are examined if an exception propagates out of the ExceptionNode.
	 * <!-- end-user-doc -->
	 */
	def handler: Set[UMLExceptionHandler[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def test_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def bodyPart_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def test_clause: Option[UMLClause[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def executableNode_sequenceNode: Option[UMLSequenceNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def setupPart_loopNode: Option[UMLLoopNode[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def handlerBody_exceptionHandler: Set[UMLExceptionHandler[Uml]]

	/**
	 * <!-- begin-user-doc --> 
	 * 
	 * <!-- end-user-doc -->
	 */
	def body_clause: Option[UMLClause[Uml]]

// Start of user code for additional featuers
// End of user code

} //UMLExecutableNode
