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
 * ActivityNode is an abstract class for points in the flow of an Activity connected by ActivityEdges.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLActivityNode[Uml <: UML]
	extends UMLRedefinableElement[Uml]
	with UMLActivityNodeOps[Uml] {
	
	import ops._

	/**
	 * The Activity containing the ActivityNode, if it is directly owned by an Activity.
	 *
	 * <!-- Start of user code doc for activity -->
	 * <!-- End of user code doc for activity -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.node
	 */
	def activity: Option[UMLActivity[Uml]]

	/**
	 * ActivityGroups containing the ActivityNode.
	 *
	 * <!-- Start of user code doc for inGroup -->
	 * <!-- End of user code doc for inGroup -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityGroup.containedNode
	 */
	def inGroup: Set[UMLActivityGroup[Uml]]

	/**
	 * InterruptibleActivityRegions containing the ActivityNode.
	 *
	 * <!-- Start of user code doc for inInterruptibleRegion -->
	 * <!-- End of user code doc for inInterruptibleRegion -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInterruptibleActivityRegion.node
	 */
	def inInterruptibleRegion: Set[UMLInterruptibleActivityRegion[Uml]]

	/**
	 * ActivityPartitions containing the ActivityNode.
	 *
	 * <!-- Start of user code doc for inPartition -->
	 * <!-- End of user code doc for inPartition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.node
	 */
	def inPartition: Set[UMLActivityPartition[Uml]]

	/**
	 * The StructuredActivityNode containing the ActvityNode, if it is directly owned by a StructuredActivityNode.
	 *
	 * <!-- Start of user code doc for inStructuredNode -->
	 * <!-- End of user code doc for inStructuredNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.node
	 */
	def inStructuredNode: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * ActivityEdges that have the ActivityNode as their target.
	 *
	 * <!-- Start of user code doc for incoming -->
	 * <!-- End of user code doc for incoming -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.target
	 */
	def incoming: Set[UMLActivityEdge[Uml]]

	/**
	 * ActivityEdges that have the ActivityNode as their source.
	 *
	 * <!-- Start of user code doc for outgoing -->
	 * <!-- End of user code doc for outgoing -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.source
	 */
	def outgoing: Set[UMLActivityEdge[Uml]]

	/**
	 * ActivityNodes from a generalization of the Activity containining this ActivityNode that are redefined by this ActivityNode.
	 *
	 * <!-- Start of user code doc for redefinedNode -->
	 * <!-- End of user code doc for redefinedNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.redefinedNode_activityNode
	 */
	def redefinedNode: Set[UMLActivityNode[Uml]]

	/**
	 * <!-- Start of user code doc for redefinedNode_activityNode -->
	 * <!-- End of user code doc for redefinedNode_activityNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.redefinedNode
	 */
	def redefinedNode_activityNode: Set[UMLActivityNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityNode
	 *
	 * <!-- Start of user code doc for activityNode_metaAttributes -->
	 * <!-- End of user code doc for activityNode_metaAttributes -->
	 */
	def activityNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			redefinableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityNode
	 *
	 * <!-- Start of user code doc for activityNode_compositeMetaProperties -->
	 * <!-- End of user code doc for activityNode_compositeMetaProperties -->
	 */
	def activityNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityNode
	 *
	 * <!-- Start of user code doc for activityNode_referenceMetaProperties -->
	 * <!-- End of user code doc for activityNode_referenceMetaProperties -->
	 */
	def activityNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLInterruptibleActivityRegion[Uml]]("inInterruptibleRegion", _.inInterruptibleRegion),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityPartition[Uml]]("inPartition", _.inPartition),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityEdge[Uml]]("incoming", _.incoming),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityEdge[Uml]]("outgoing", _.outgoing),
				MetaPropertyCollection[Uml, UMLActivityNode[Uml], UMLActivityNode[Uml]]("redefinedNode", _.redefinedNode)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityNode
	 *
	 * <!-- Start of user code doc for activityNode_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for activityNode_forwardReferencesFromMetamodelAssociations -->
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

	// Start of user code for additional features
	// End of user code
} //UMLActivityNode
