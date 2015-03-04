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
 * An ActivityPartition is a kind of ActivityGroup for identifying ActivityNodes that have some characteristic in common.
 * <!-- end-model-doc --> 
 */
trait UMLActivityPartition[Uml <: UML]
	extends UMLActivityGroup[Uml]
	with UMLActivityPartitionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * ActivityEdges immediately contained in the ActivityPartition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.inPartition
	 */
	def edge: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether the ActivityPartition groups other ActivityPartitions along a dimension.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDimension: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether the ActivityPartition represents an entity to which the partitioning structure does not apply.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isExternal: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * ActivityNodes immediately contained in the ActivityPartition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.inPartition
	 */
	def node: Set[UMLActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An Element represented by the functionality modeled within the ActivityPartition.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLElement.represents_activityPartition
	 */
	def represents: Option[UMLElement[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Other ActivityPartitions immediately contained in this ActivityPartition (as its subgroups).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.superPartition
	 */
	def subpartition: Set[UMLActivityPartition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Other ActivityPartitions immediately containing this ActivityPartition (as its superGroups).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivityPartition.subpartition
	 */
	def superPartition: Option[UMLActivityPartition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.partition
	 */
	def partition_activity: Option[UMLActivity[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityPartition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityPartition
	 */
	def activityPartition_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			activityGroup_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLActivityPartition[Uml]](None, "isDimension", (x) => booleanToIterable(x.isDimension, false)),
				MetaAttributeBooleanFunction[Uml, UMLActivityPartition[Uml]](None, "isExternal", (x) => booleanToIterable(x.isExternal, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityPartition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityPartition
	 */
	def activityPartition_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityGroup_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityPartition[Uml]]("subpartition", _.subpartition)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityPartition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityPartition
	 */
	def activityPartition_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityGroup_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityEdge[Uml]]("edge", _.edge),
				MetaPropertyCollection[Uml, UMLActivityPartition[Uml], UMLActivityNode[Uml]]("node", _.node),
				MetaPropertyReference[Uml, UMLActivityPartition[Uml], UMLElement[Uml]]("represents", _.represents),
				MetaPropertyReference[Uml, UMLActivityPartition[Uml], UMLActivityPartition[Uml]]("superPartition", _.superPartition)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityPartition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityPartition
	 */
	def activityPartition_forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations ++
		edge ++
		node ++
		represents ++
		superPartition 

} //UMLActivityPartition
