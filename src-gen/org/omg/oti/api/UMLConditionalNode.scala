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
 * A ConditionalNode is a StructuredActivityNode that chooses one among some number of alternative collections of ExecutableNodes to execute.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLConditionalNode[Uml <: UML]
	extends UMLStructuredActivityNode[Uml]
	with UMLConditionalNodeOps[Uml] {
	
	import ops._

	/**
	 * The set of Clauses composing the ConditionalNode.
	 *
	 * <!-- Start of user code doc for clause -->
	 * <!-- End of user code doc for clause -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLClause.clause_conditionalNode
	 */
	def clause: Set[UMLClause[Uml]]

	/**
	 * If true, the modeler asserts that the test for at least one Clause of the ConditionalNode will succeed.
	 *
	 * <!-- Start of user code doc for isAssured -->
	 * <!-- End of user code doc for isAssured -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isAssured: Boolean

	/**
	 * If true, the modeler asserts that the test for at most one Clause of the ConditionalNode will succeed.
	 *
	 * <!-- Start of user code doc for isDeterminate -->
	 * <!-- End of user code doc for isDeterminate -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDeterminate: Boolean

	/**
	 * The OutputPins that onto which are moved values from the bodyOutputs of the Clause selected for execution.
	 *
	 * <!-- Start of user code doc for result -->
	 * <!-- End of user code doc for result -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_conditionalNode
	 */
	def result: Seq[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		conditionalNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLConditionalNode
	 *
	 * <!-- Start of user code doc for conditionalNode_metaAttributes -->
	 * <!-- End of user code doc for conditionalNode_metaAttributes -->
	 */
	def conditionalNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			structuredActivityNode_metaAttributes,
			Seq (ConditionalNode_isAssured,
				ConditionalNode_isDeterminate))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		conditionalNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLConditionalNode
	 *
	 * <!-- Start of user code doc for conditionalNode_compositeMetaProperties -->
	 * <!-- End of user code doc for conditionalNode_compositeMetaProperties -->
	 */
	def conditionalNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_compositeMetaProperties,
			Seq (ConditionalNode_clause,
				ConditionalNode_result))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		conditionalNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLConditionalNode
	 *
	 * <!-- Start of user code doc for conditionalNode_referenceMetaProperties -->
	 * <!-- End of user code doc for conditionalNode_referenceMetaProperties -->
	 */
	def conditionalNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		conditionalNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLConditionalNode
	 *
	 * <!-- Start of user code doc for conditionalNode_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for conditionalNode_forwardReferencesFromMetamodelAssociations -->
	 */
	def conditionalNode_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLConditionalNode
