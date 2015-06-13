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
 * A LoopNode is a StructuredActivityNode that represents an iterative loop with setup, test, and body sections.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLLoopNode[Uml <: UML]
	extends UMLStructuredActivityNode[Uml]
	with UMLLoopNodeOps[Uml] {
	
	import ops._

	/**
	 * The OutputPins on Actions within the bodyPart, the values of which are moved to the loopVariable OutputPins after the completion of each execution of the bodyPart, before the next iteration of the loop begins or before the loop exits.
	 *
	 * <!-- Start of user code doc for bodyOutput -->
	 * <!-- End of user code doc for bodyOutput -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.bodyOutput_loopNode
	 */
	def bodyOutput: Seq[UMLOutputPin[Uml]]

	/**
	 * The set of ExecutableNodes that perform the repetitive computations of the loop. The bodyPart is executed as long as the test section produces a true value.
	 *
	 * <!-- Start of user code doc for bodyPart -->
	 * <!-- End of user code doc for bodyPart -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.bodyPart_loopNode
	 */
	def bodyPart: Set[UMLExecutableNode[Uml]]

	/**
	 * An OutputPin on an Action in the test section whose Boolean value determines whether to continue executing the loop bodyPart.
	 *
	 * <!-- Start of user code doc for decider -->
	 * <!-- End of user code doc for decider -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.decider_loopNode
	 */
	def decider: Option[UMLOutputPin[Uml]]

	/**
	 * If true, the test is performed before the first execution of the bodyPart. If false, the bodyPart is executed once before the test is performed.
	 *
	 * <!-- Start of user code doc for isTestedFirst -->
	 * <!-- End of user code doc for isTestedFirst -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isTestedFirst: Boolean

	/**
	 * A list of OutputPins that hold the values of the loop variables during an execution of the loop. When the test fails, the values are moved to the result OutputPins of the loop.
	 *
	 * <!-- Start of user code doc for loopVariable -->
	 * <!-- End of user code doc for loopVariable -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.loopVariable_loopNode
	 */
	def loopVariable: Seq[UMLOutputPin[Uml]]

	/**
	 * A list of InputPins whose values are moved into the loopVariable Pins before the first iteration of the loop.
	 *
	 * <!-- Start of user code doc for loopVariableInput -->
	 * <!-- End of user code doc for loopVariableInput -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.loopVariableInput_loopNode
	 */
	def loopVariableInput: Seq[UMLInputPin[Uml]]

	/**
	 * A list of OutputPins that receive the loopVariable values after the last iteration of the loop and constitute the output of the LoopNode.
	 *
	 * <!-- Start of user code doc for result -->
	 * <!-- End of user code doc for result -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_loopNode
	 */
	def result: Seq[UMLOutputPin[Uml]]

	/**
	 * The set of ExecutableNodes executed before the first iteration of the loop, in order to initialize values or perform other setup computations.
	 *
	 * <!-- Start of user code doc for setupPart -->
	 * <!-- End of user code doc for setupPart -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.setupPart_loopNode
	 */
	def setupPart: Set[UMLExecutableNode[Uml]]

	/**
	 * The set of ExecutableNodes executed in order to provide the test result for the loop.
	 *
	 * <!-- Start of user code doc for test -->
	 * <!-- End of user code doc for test -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.test_loopNode
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
			Seq (MetaAttributeBooleanFunction[Uml, UMLLoopNode[Uml]](None, "isTestedFirst", (x) => booleanToIterable(x.isTestedFirst, false))))

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
			Seq (LoopNode_loopVariable, LoopNode_loopVariableInput, LoopNode_result))

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
			Seq (MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]]("bodyOutput", _.bodyOutput, true),
				MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLExecutableNode[Uml]]("bodyPart", _.bodyPart),
				MetaPropertyReference[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]]("decider", _.decider),
				MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLExecutableNode[Uml]]("setupPart", _.setupPart),
				MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLExecutableNode[Uml]]("test", _.test)))

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
