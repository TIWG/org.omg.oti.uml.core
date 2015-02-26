package org.omg.oti

// Start of user code for imports
// End of user code

/**
 * <!-- begin-user-doc --> 
 * A Vertex is an abstraction of a node in a StateMachine graph. It can be the source or destination of any number of Transitions.
 * <!-- end-user-doc --> 
 */
trait UMLVertex[Uml <: UML]
  extends UMLNamedElement[Uml] with operations.UMLVertexOps[Uml] {
	
	import ops._

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		vertex_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLVertex
	 */
	def vertex_metaAttributes: MetaAttributeFunctions = 
	   appendUnique(
		namedElement_metaAttributes,
		  Seq () )

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		vertex_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLVertex
	 */
	def vertex_compositeMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_compositeMetaProperties,
		  Seq () )

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		vertex_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLVertex
	 */
	def vertex_referenceMetaProperties: MetaPropertyFunctions = 
	  appendUnique(
		namedElement_referenceMetaProperties,
		  Seq (MetaPropertyReference[Uml, UMLVertex[Uml], UMLRegion[Uml]]("container", _.container)) )

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		vertex_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLVertex
	 */
	def vertex_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		container 

	/**
	 * <!-- begin-user-doc --> 
	 * The Region that contains this Vertex.
	 * <!-- end-user-doc -->
	 */
	def container: Option[UMLRegion[Uml]] 

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Transitions entering this Vertex.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (Transition.allInstances()->select(target=self))
	 */
	def incoming: Set[UMLTransition[Uml]] = {
	    // Start of user code for "incoming"
	    ???
	    // End of user code
	}

	/**
	 * <!-- begin-user-doc --> 
	 * Specifies the Transitions departing from this Vertex.
	 * <!-- end-user-doc -->
	 *
	 * OCL: result = (Transition.allInstances()->select(source=self))
	 */
	def outgoing: Set[UMLTransition[Uml]] = {
	    // Start of user code for "outgoing"
	    ???
	    // End of user code
	}

// Start of user code for additional featuers
// End of user code

} //UMLVertex
