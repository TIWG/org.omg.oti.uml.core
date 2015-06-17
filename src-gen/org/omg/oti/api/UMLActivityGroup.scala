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
 * ActivityGroup is an abstract class for defining sets of ActivityNodes and ActivityEdges in an Activity.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLActivityGroup[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLActivityGroupOps[Uml] {
	
	import ops._

	/**
	 * ActivityEdges immediately contained in the ActivityGroup.
	 *
	 * <!-- Start of user code doc for containedEdge -->
	 * <!-- End of user code doc for containedEdge -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.inGroup
	 */
	def containedEdge: Set[UMLActivityEdge[Uml]]

	/**
	 * ActivityNodes immediately contained in the ActivityGroup.
	 *
	 * <!-- Start of user code doc for containedNode -->
	 * <!-- End of user code doc for containedNode -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.inGroup
	 */
	def containedNode: Set[UMLActivityNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		activityGroup_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLActivityGroup
	 *
	 * <!-- Start of user code doc for activityGroup_metaAttributes -->
	 * <!-- End of user code doc for activityGroup_metaAttributes -->
	 */
	def activityGroup_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		activityGroup_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLActivityGroup
	 *
	 * <!-- Start of user code doc for activityGroup_compositeMetaProperties -->
	 * <!-- End of user code doc for activityGroup_compositeMetaProperties -->
	 */
	def activityGroup_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		activityGroup_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLActivityGroup
	 *
	 * <!-- Start of user code doc for activityGroup_referenceMetaProperties -->
	 * <!-- End of user code doc for activityGroup_referenceMetaProperties -->
	 */
	def activityGroup_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLActivityGroup
	 *
	 * <!-- Start of user code doc for activityGroup_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for activityGroup_forwardReferencesFromMetamodelAssociations -->
	 */
	def activityGroup_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLActivityGroup
