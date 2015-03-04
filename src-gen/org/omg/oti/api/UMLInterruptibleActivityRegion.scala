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
 * An InterruptibleActivityRegion is an ActivityGroup that supports the termination of tokens flowing in the portions of an activity within it.
 * <!-- end-model-doc --> 
 */
trait UMLInterruptibleActivityRegion[Uml <: UML]
	extends UMLActivityGroup[Uml]
	with UMLInterruptibleActivityRegionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The ActivityEdges leaving the InterruptibleActivityRegion on which a traversing token will result in the termination of other tokens flowing in the InterruptibleActivityRegion.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityEdge.interrupts
	 */
	def interruptingEdge: Set[UMLActivityEdge[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * ActivityNodes immediately contained in the InterruptibleActivityRegion.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityNode.inInterruptibleRegion
	 */
	def node: Set[UMLActivityNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		interruptibleActivityRegion_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			activityGroup_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		interruptibleActivityRegion_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityGroup_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		interruptibleActivityRegion_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			activityGroup_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLInterruptibleActivityRegion[Uml], UMLActivityEdge[Uml]]("interruptingEdge", _.interruptingEdge),
				MetaPropertyCollection[Uml, UMLInterruptibleActivityRegion[Uml], UMLActivityNode[Uml]]("node", _.node)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLInterruptibleActivityRegion
	 */
	def interruptibleActivityRegion_forwardReferencesFromMetamodelAssociations: Elements =
		activityGroup_forwardReferencesFromMetamodelAssociations ++
		interruptingEdge ++
		node 

} //UMLInterruptibleActivityRegion
