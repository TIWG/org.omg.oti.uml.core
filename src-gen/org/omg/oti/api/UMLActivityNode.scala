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
 * ActivityNode is an abstract class for points in the flow of an Activity connected by ActivityEdges.
 * <!-- end-model-doc -->
 */
trait UMLActivityNode[Uml <: UML]
	extends UMLRedefinableElement[Uml]
	with UMLActivityNodeOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Activity containing the ActivityNode, if it is directly owned by an Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.node
	 */
	def activity: Option[UMLActivity[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityGroups containing the ActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityGroup.containedNode
	 */
	def inGroup: Set[UMLActivityGroup[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * InterruptibleActivityRegions containing the ActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterruptibleActivityRegion.node
	 */
	def inInterruptibleRegion: Set[UMLInterruptibleActivityRegion[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityPartitions containing the ActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.node
	 */
	def inPartition: Set[UMLActivityPartition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The StructuredActivityNode containing the ActvityNode, if it is directly owned by a StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.node
	 */
	def inStructuredNode: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityEdges that have the ActivityNode as their target.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.target
	 */
	def incoming: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityEdges that have the ActivityNode as their source.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.source
	 */
	def outgoing: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityNodes from a generalization of the Activity containining this ActivityNode that are redefined by this ActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.redefinedNode_activityNode
	 */
	def redefinedNode: Set[UMLActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.redefinedNode
	 */
	def redefinedNode_activityNode: Set[UMLActivityNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityNode
	 */
	def activityNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			redefinableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityNode
	 */
	def activityNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityNode
	 */
	def activityNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLActivityNode[Uml], UMLActivity[Uml]]("activity", _.activity),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLInterruptibleActivityRegion[Uml]]("inInterruptibleRegion", _.inInterruptibleRegion),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityPartition[Uml]]("inPartition", _.inPartition),
				MetaPropertyReference[Uml, UMLActivityNode[Uml], UMLStructuredActivityNode[Uml]]("inStructuredNode", _.inStructuredNode),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityEdge[Uml]]("incoming", _.incoming),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityEdge[Uml]]("outgoing", _.outgoing),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityNode[Uml]]("redefinedNode", _.redefinedNode)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityNode
	 */
	def activityNode_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		activity ++
		inInterruptibleRegion ++
		inPartition ++
		inStructuredNode ++
		incoming ++
		outgoing ++
		redefinedNode 

} //UMLActivityNode
