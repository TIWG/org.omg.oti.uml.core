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
import org.omg.oti.uml.read.operations.UMLLoopNodeOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A LoopNode is a StructuredActivityNode that represents an iterative loop with setup, test, and body sections.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLLoopNode[Uml <: UML]
	extends UMLStructuredActivityNode[Uml]
	with UMLLoopNodeOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * The OutputPins on Actions within the bodyPart, the values of which are moved to the loopVariable OutputPins after the completion of each execution of the bodyPart, before the next iteration of the loop begins or before the loop exits.
	 *
	 * <!-- Start of user code doc for bodyOutput -->
   * <!-- End of user code doc for bodyOutput -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.bodyOutput_loopNode
	 */
	def bodyOutput: Seq[UMLOutputPin[Uml]]

	/**
	 * The set of ExecutableNodes that perform the repetitive computations of the loop. The bodyPart is executed as long as the test section produces a true value.
	 *
	 * <!-- Start of user code doc for bodyPart -->
   * <!-- End of user code doc for bodyPart -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.bodyPart_loopNode
	 */
	def bodyPart: Set[UMLExecutableNode[Uml]]

	/**
	 * An OutputPin on an Action in the test section whose Boolean value determines whether to continue executing the loop bodyPart.
	 *
	 * <!-- Start of user code doc for decider -->
   * <!-- End of user code doc for decider -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.decider_loopNode
	 */
	def decider: Option[UMLOutputPin[Uml]]

	/**
	 * If true, the test is performed before the first execution of the bodyPart. If false, the bodyPart is executed once before the test is performed.
	 *
	 * <!-- Start of user code doc for isTestedFirst -->
   * <!-- End of user code doc for isTestedFirst -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isTestedFirst: Boolean

	/**
	 * A list of OutputPins that hold the values of the loop variables during an execution of the loop. When the test fails, the values are moved to the result OutputPins of the loop.
	 *
	 * <!-- Start of user code doc for loopVariable -->
   * <!-- End of user code doc for loopVariable -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.loopVariable_loopNode
	 */
	def loopVariable: Seq[UMLOutputPin[Uml]]

	/**
	 * A list of InputPins whose values are moved into the loopVariable Pins before the first iteration of the loop.
	 *
	 * <!-- Start of user code doc for loopVariableInput -->
   * <!-- End of user code doc for loopVariableInput -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.loopVariableInput_loopNode
	 */
	def loopVariableInput: Seq[UMLInputPin[Uml]]

	/**
	 * A list of OutputPins that receive the loopVariable values after the last iteration of the loop and constitute the output of the LoopNode.
	 *
	 * <!-- Start of user code doc for result -->
   * <!-- End of user code doc for result -->
	 *
	 * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_loopNode
	 */
	def result: Seq[UMLOutputPin[Uml]]

	/**
	 * The set of ExecutableNodes executed before the first iteration of the loop, in order to initialize values or perform other setup computations.
	 *
	 * <!-- Start of user code doc for setupPart -->
   * <!-- End of user code doc for setupPart -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.setupPart_loopNode
	 */
	def setupPart: Set[UMLExecutableNode[Uml]]

	/**
	 * The set of ExecutableNodes executed in order to provide the test result for the loop.
	 *
	 * <!-- Start of user code doc for test -->
   * <!-- End of user code doc for test -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.test_loopNode
	 */
	def test: Set[UMLExecutableNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		loopNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLoopNode
	 *
	 * <!-- Start of user code doc for loopNode_metaAttributes -->
   * <!-- End of user code doc for loopNode_metaAttributes -->
	 */
	def loopNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			structuredActivityNode_metaAttributes,
			Seq (LoopNode_isTestedFirst))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		loopNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLoopNode
	 *
	 * <!-- Start of user code doc for loopNode_compositeMetaProperties -->
   * <!-- End of user code doc for loopNode_compositeMetaProperties -->
	 */
	def loopNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_compositeMetaProperties,
			Seq (LoopNode_loopVariable,
				LoopNode_loopVariableInput,
				LoopNode_result))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		loopNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLoopNode
	 *
	 * <!-- Start of user code doc for loopNode_referenceMetaProperties -->
   * <!-- End of user code doc for loopNode_referenceMetaProperties -->
	 */
	def loopNode_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_referenceMetaProperties,
			Seq (LoopNode_bodyOutput,
				LoopNode_bodyPart,
				LoopNode_decider,
				LoopNode_setupPart,
				LoopNode_test))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		loopNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLoopNode
	 *
	 * <!-- Start of user code doc for loopNode_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for loopNode_forwardReferencesFromMetamodelAssociations -->
	 */
	def loopNode_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		bodyOutput ++
		bodyPart ++
		decider ++
		setupPart ++
		test

	// Start of user code for additional features
  // End of user code
} //UMLLoopNode
