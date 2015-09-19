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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLActivityPartitionOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * An ActivityPartition is a kind of ActivityGroup for identifying ActivityNodes that have some characteristic in common.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLActivityPartition[Uml <: UML]
	extends UMLActivityGroup[Uml]
	with UMLActivityPartitionOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Indicates whether the ActivityPartition groups other ActivityPartitions along a dimension.
	 *
	 * <!-- Start of user code doc for isDimension -->
   * <!-- End of user code doc for isDimension -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDimension: Boolean

	/**
	 * Indicates whether the ActivityPartition represents an entity to which the partitioning structure does not apply.
	 *
	 * <!-- Start of user code doc for isExternal -->
   * <!-- End of user code doc for isExternal -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isExternal: Boolean

	/**
	 * An Element represented by the functionality modeled within the ActivityPartition.
	 *
	 * <!-- Start of user code doc for represents -->
   * <!-- End of user code doc for represents -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.represents_activityPartition
	 */
	def represents: Option[UMLElement[Uml]]

	/**
	 * <!-- Start of user code doc for partition_activity -->
   * <!-- End of user code doc for partition_activity -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLActivity.partition
	 */
	def partition_activity: Option[UMLActivity[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityPartition_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityPartition
	 *
	 * <!-- Start of user code doc for activityPartition_metaAttributes -->
   * <!-- End of user code doc for activityPartition_metaAttributes -->
	 */
	def activityPartition_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			activityGroup_metaAttributes,
			Seq[MetaAttributeFunction](ActivityPartition_isDimension,
				ActivityPartition_isExternal))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityPartition_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityPartition
	 *
	 * <!-- Start of user code doc for activityPartition_compositeMetaProperties -->
   * <!-- End of user code doc for activityPartition_compositeMetaProperties -->
	 */
	def activityPartition_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityGroup_compositeMetaProperties,
			Seq[MetaPropertyEvaluator](ActivityPartition_subpartition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityPartition_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityPartition
	 *
	 * <!-- Start of user code doc for activityPartition_referenceMetaProperties -->
   * <!-- End of user code doc for activityPartition_referenceMetaProperties -->
	 */
	def activityPartition_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityGroup_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](ActivityPartition_edge,
				ActivityPartition_node,
				ActivityPartition_represents))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityPartition_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityPartition
	 *
	 * <!-- Start of user code doc for activityPartition_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for activityPartition_forwardReferencesFromMetamodelAssociations -->
	 */
	def activityPartition_forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations ++
		edge ++
		node ++
		represents

	// Start of user code for additional features
  // End of user code
} //UMLActivityPartition
