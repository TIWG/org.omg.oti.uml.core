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
 * A Clause is an Element that represents a single branch of a ConditionalNode, including a test and a body section. The body section is executed only if (but not necessarily if) the test section evaluates to true.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLClause[Uml <: UML]
	extends UMLElement[Uml]
	with UMLClauseOps[Uml] {
	
	import ops._

	/**
	 * The set of ExecutableNodes that are executed if the test evaluates to true and the Clause is chosen over other Clauses within the ConditionalNode that also have tests that evaluate to true.
	 *
	 * <!-- Start of user code doc for body -->
	 * <!-- End of user code doc for body -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.body_clause
	 */
	def body: Set[UMLExecutableNode[Uml]]

	/**
	 * The OutputPins on Actions within the body section whose values are moved to the result OutputPins of the containing ConditionalNode after execution of the body.
	 *
	 * <!-- Start of user code doc for bodyOutput -->
	 * <!-- End of user code doc for bodyOutput -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.bodyOutput_clause
	 */
	def bodyOutput: Seq[UMLOutputPin[Uml]]

	/**
	 * An OutputPin on an Action in the test section whose Boolean value determines the result of the test.
	 *
	 * <!-- Start of user code doc for decider -->
	 * <!-- End of user code doc for decider -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.decider_clause
	 */
	def decider: Option[UMLOutputPin[Uml]]

	/**
	 * A set of Clauses whose tests must all evaluate to false before this Clause can evaluate its test.
	 *
	 * <!-- Start of user code doc for predecessorClause -->
	 * <!-- End of user code doc for predecessorClause -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClause.successorClause
	 */
	def predecessorClause: Set[UMLClause[Uml]]

	/**
	 * A set of Clauses that may not evaluate their tests unless the test for this Clause evaluates to false.
	 *
	 * <!-- Start of user code doc for successorClause -->
	 * <!-- End of user code doc for successorClause -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClause.predecessorClause
	 */
	def successorClause: Set[UMLClause[Uml]]

	/**
	 * The set of ExecutableNodes that are executed in order to provide a test result for the Clause.
	 *
	 * <!-- Start of user code doc for test -->
	 * <!-- End of user code doc for test -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.test_clause
	 */
	def test: Set[UMLExecutableNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		clause_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClause
	 *
	 * <!-- Start of user code doc for clause_metaAttributes -->
	 * <!-- End of user code doc for clause_metaAttributes -->
	 */
	def clause_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			element_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		clause_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClause
	 *
	 * <!-- Start of user code doc for clause_compositeMetaProperties -->
	 * <!-- End of user code doc for clause_compositeMetaProperties -->
	 */
	def clause_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		clause_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClause
	 *
	 * <!-- Start of user code doc for clause_referenceMetaProperties -->
	 * <!-- End of user code doc for clause_referenceMetaProperties -->
	 */
	def clause_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq (Clause_body,
				Clause_bodyOutput,
				Clause_decider,
				Clause_predecessorClause,
				Clause_successorClause,
				Clause_test))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		clause_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClause
	 *
	 * <!-- Start of user code doc for clause_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for clause_forwardReferencesFromMetamodelAssociations -->
	 */
	def clause_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		body ++
		bodyOutput ++
		decider ++
		predecessorClause ++
		successorClause ++
		test 

	// Start of user code for additional features
	// End of user code
} //UMLClause
