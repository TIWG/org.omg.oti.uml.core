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
import org.omg.oti.uml.read.operations.UMLExpansionRegionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * An ExpansionRegion is a StructuredActivityNode that executes its content multiple times corresponding to elements of input collection(s).
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLExpansionRegion[Uml <: UML]
	extends UMLStructuredActivityNode[Uml]
	with UMLExpansionRegionOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * The ExpansionNodes that hold the input collections for the ExpansionRegion.
	 *
	 * <!-- Start of user code doc for inputElement -->
   * <!-- End of user code doc for inputElement -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExpansionNode.regionAsInput
	 */
	def inputElement: Set[UMLExpansionNode[Uml]]

	/**
	 * The mode in which the ExpansionRegion executes its contents. If parallel, executions are concurrent. If iterative, executions are sequential. If stream, a stream of values flows into a single execution.
	 *
	 * <!-- Start of user code doc for mode -->
   * <!-- End of user code doc for mode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def mode: Option[UMLExpansionKind.Value]

	/**
	 * The ExpansionNodes that form the output collections of the ExpansionRegion.
	 *
	 * <!-- Start of user code doc for outputElement -->
   * <!-- End of user code doc for outputElement -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExpansionNode.regionAsOutput
	 */
	def outputElement: Set[UMLExpansionNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		expansionRegion_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExpansionRegion
	 *
	 * <!-- Start of user code doc for expansionRegion_metaAttributes -->
   * <!-- End of user code doc for expansionRegion_metaAttributes -->
	 */
	def expansionRegion_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			structuredActivityNode_metaAttributes,
			Seq[MetaAttributeFunction]())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		expansionRegion_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExpansionRegion
	 *
	 * <!-- Start of user code doc for expansionRegion_compositeMetaProperties -->
   * <!-- End of user code doc for expansionRegion_compositeMetaProperties -->
	 */
	def expansionRegion_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_compositeMetaProperties,
			Seq[MetaPropertyEvaluator]())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		expansionRegion_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExpansionRegion
	 *
	 * <!-- Start of user code doc for expansionRegion_referenceMetaProperties -->
   * <!-- End of user code doc for expansionRegion_referenceMetaProperties -->
	 */
	def expansionRegion_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](ExpansionRegion_inputElement,
				ExpansionRegion_outputElement))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		expansionRegion_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExpansionRegion
	 *
	 * <!-- Start of user code doc for expansionRegion_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for expansionRegion_forwardReferencesFromMetamodelAssociations -->
	 */
	def expansionRegion_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		inputElement ++
		outputElement

	// Start of user code for additional features
  // End of user code
} //UMLExpansionRegion
