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
 * An ActivityEdge is an abstract class for directed connections between two ActivityNodes.
 * <!-- end-model-doc --> 
 */
trait UMLActivityEdge[Uml <: UML]
	extends UMLRedefinableElement[Uml]
	with UMLActivityEdgeOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Activity containing the ActivityEdge, if it is directly owned by an Activity.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.edge
	 */
	def activity: Option[UMLActivity[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A ValueSpecification that is evaluated to determine if a token can traverse the ActivityEdge. If an ActivityEdge has no guard, then there is no restriction on tokens traversing the edge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.guard_activityEdge
	 */
	def guard: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityGroups containing the ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityGroup.containedEdge
	 */
	def inGroup: Set[UMLActivityGroup[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityPartitions containing the ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.edge
	 */
	def inPartition: Set[UMLActivityPartition[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The StructuredActivityNode containing the ActivityEdge, if it is owned by a StructuredActivityNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.edge
	 */
	def inStructuredNode: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The InterruptibleActivityRegion for which this ActivityEdge is an interruptingEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInterruptibleActivityRegion.interruptingEdge
	 */
	def interrupts: Option[UMLInterruptibleActivityRegion[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityEdges from a generalization of the Activity containing this ActivityEdge that are redefined by this ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.redefinedEdge_activityEdge
	 */
	def redefinedEdge: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ActivityNode from which tokens are taken when they traverse the ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLActivityNode.outgoing
	 */
	def source: Option[UMLActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ActivityNode to which tokens are put when they traverse the ActivityEdge.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLActivityNode.incoming
	 */
	def target: Option[UMLActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The minimum number of tokens that must traverse the ActivityEdge at the same time. If no weight is specified, this is equivalent to specifying a constant value of 1.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.weight_activityEdge
	 */
	def weight: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInformationFlow.realizingActivityEdge
	 */
	def realizingActivityEdge_informationFlow: Set[UMLInformationFlow[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.redefinedEdge
	 */
	def redefinedEdge_activityEdge: Set[UMLActivityEdge[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityEdge_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityEdge
	 */
	def activityEdge_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			redefinableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityEdge_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityEdge
	 */
	def activityEdge_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLValueSpecification[Uml]]("guard", _.guard),
				MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLValueSpecification[Uml]]("weight", _.weight)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityEdge_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityEdge
	 */
	def activityEdge_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			redefinableElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivity[Uml]]("activity", _.activity),
				MetaPropertyCollection[Uml, UMLActivityEdge[Uml], UMLActivityPartition[Uml]]("inPartition", _.inPartition),
				MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLStructuredActivityNode[Uml]]("inStructuredNode", _.inStructuredNode),
				MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLInterruptibleActivityRegion[Uml]]("interrupts", _.interrupts),
				MetaPropertyCollection[Uml, UMLActivityEdge[Uml], UMLActivityEdge[Uml]]("redefinedEdge", _.redefinedEdge),
				MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivityNode[Uml]]("source", _.source),
				MetaPropertyReference[Uml, UMLActivityEdge[Uml], UMLActivityNode[Uml]]("target", _.target)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityEdge_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityEdge
	 */
	def activityEdge_forwardReferencesFromMetamodelAssociations: Elements =
		redefinableElement_forwardReferencesFromMetamodelAssociations ++
		activity ++
		inPartition ++
		inStructuredNode ++
		interrupts ++
		redefinedEdge ++
		source ++
		target 

} //UMLActivityEdge
