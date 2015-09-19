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
import org.omg.oti.uml.read.operations.UMLExpansionNodeOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * An ExpansionNode is an ObjectNode used to indicate a collection input or output for an ExpansionRegion. A collection input of an ExpansionRegion contains a collection that is broken into its individual elements inside the region, whose content is executed once per element. A collection output of an ExpansionRegion combines individual elements produced by the execution of the region into a collection for use outside the region.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLExpansionNode[Uml <: UML]
	extends UMLObjectNode[Uml]
	with UMLExpansionNodeOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * The ExpansionRegion for which the ExpansionNode is an input.
	 *
	 * <!-- Start of user code doc for regionAsInput -->
   * <!-- End of user code doc for regionAsInput -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExpansionRegion.inputElement
	 */
	def regionAsInput: Option[UMLExpansionRegion[Uml]]

	/**
	 * The ExpansionRegion for which the ExpansionNode is an output.
	 *
	 * <!-- Start of user code doc for regionAsOutput -->
   * <!-- End of user code doc for regionAsOutput -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExpansionRegion.outputElement
	 */
	def regionAsOutput: Option[UMLExpansionRegion[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		expansionNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExpansionNode
	 *
	 * <!-- Start of user code doc for expansionNode_metaAttributes -->
   * <!-- End of user code doc for expansionNode_metaAttributes -->
	 */
	def expansionNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			objectNode_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		expansionNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExpansionNode
	 *
	 * <!-- Start of user code doc for expansionNode_compositeMetaProperties -->
   * <!-- End of user code doc for expansionNode_compositeMetaProperties -->
	 */
	def expansionNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			objectNode_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		expansionNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExpansionNode
	 *
	 * <!-- Start of user code doc for expansionNode_referenceMetaProperties -->
   * <!-- End of user code doc for expansionNode_referenceMetaProperties -->
	 */
	def expansionNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			objectNode_referenceMetaProperties,
			Seq (ExpansionNode_regionAsInput,
				ExpansionNode_regionAsOutput))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		expansionNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExpansionNode
	 *
	 * <!-- Start of user code doc for expansionNode_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for expansionNode_forwardReferencesFromMetamodelAssociations -->
	 */
	def expansionNode_forwardReferencesFromMetamodelAssociations: Elements =
		objectNode_forwardReferencesFromMetamodelAssociations ++
		regionAsInput ++
		regionAsOutput

	// Start of user code for additional features
  // End of user code
} //UMLExpansionNode
