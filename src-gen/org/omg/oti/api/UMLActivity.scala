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
 * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLActivity[Uml <: UML]
	extends UMLBehavior[Uml]
	with UMLActivityOps[Uml] {
	
	import ops._

	/**
	 * ActivityEdges expressing flow between the nodes of the Activity.
	 *
	 * <!-- Start of user code doc for edge -->
	 * <!-- End of user code doc for edge -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.activity
	 */
	def edge: Set[UMLActivityEdge[Uml]]

	/**
	 * Top-level ActivityGroups in the Activity.
	 *
	 * <!-- Start of user code doc for group -->
	 * <!-- End of user code doc for group -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityGroup.inActivity
	 */
	def group: Set[UMLActivityGroup[Uml]]

	/**
	 * If true, this Activity must not make any changes to objects. The default is false (an Activity may make nonlocal changes). (This is an assertion, not an executable property. It may be used by an execution engine to optimize model execution. If the assertion is violated by the Activity, then the model is ill-formed.) 
	 *
	 * <!-- Start of user code doc for isReadOnly -->
	 * <!-- End of user code doc for isReadOnly -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReadOnly: Boolean

	/**
	 * If true, all invocations of the Activity are handled by the same execution.
	 *
	 * <!-- Start of user code doc for isSingleExecution -->
	 * <!-- End of user code doc for isSingleExecution -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isSingleExecution: Boolean

	/**
	 * ActivityNodes coordinated by the Activity.
	 *
	 * <!-- Start of user code doc for node -->
	 * <!-- End of user code doc for node -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.activity
	 */
	def node: Set[UMLActivityNode[Uml]]

	/**
	 * Top-level ActivityPartitions in the Activity.
	 *
	 * <!-- Start of user code doc for partition -->
	 * <!-- End of user code doc for partition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityPartition.partition_activity
	 */
	def partition: Set[UMLActivityPartition[Uml]]

	/**
	 * Top-level StructuredActivityNodes in the Activity.
	 *
	 * <!-- Start of user code doc for structuredNode -->
	 * <!-- End of user code doc for structuredNode -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.activity
	 */
	def structuredNode: Set[UMLStructuredActivityNode[Uml]]

	/**
	 * Top-level Variables defined by the Activity.
	 *
	 * <!-- Start of user code doc for variable -->
	 * <!-- End of user code doc for variable -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVariable.activityScope
	 */
	def variable: Set[UMLVariable[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activity_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivity
	 *
	 * <!-- Start of user code doc for activity_metaAttributes -->
	 * <!-- End of user code doc for activity_metaAttributes -->
	 */
	def activity_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavior_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLActivity[Uml]](None, "isReadOnly", (x) => booleanToIterable(x.isReadOnly, false)),
				MetaAttributeBooleanFunction[Uml, UMLActivity[Uml]](None, "isSingleExecution", (x) => booleanToIterable(x.isSingleExecution, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activity_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivity
	 *
	 * <!-- Start of user code doc for activity_compositeMetaProperties -->
	 * <!-- End of user code doc for activity_compositeMetaProperties -->
	 */
	def activity_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityEdge[Uml]]("edge", _.edge),
				MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityGroup[Uml]]("group", _.group),
				MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityNode[Uml]]("node", _.node),
				MetaPropertyCollection[Uml, UMLActivity[Uml], UMLStructuredActivityNode[Uml]]("structuredNode", _.structuredNode),
				MetaPropertyCollection[Uml, UMLActivity[Uml], UMLVariable[Uml]]("variable", _.variable)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activity_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivity
	 *
	 * <!-- Start of user code doc for activity_referenceMetaProperties -->
	 * <!-- End of user code doc for activity_referenceMetaProperties -->
	 */
	def activity_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLActivity[Uml], UMLActivityPartition[Uml]]("partition", _.partition)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activity_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivity
	 *
	 * <!-- Start of user code doc for activity_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for activity_forwardReferencesFromMetamodelAssociations -->
	 */
	def activity_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		partition 

	// Start of user code for additional features
	// End of user code
} //UMLActivity
