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
 * A LoopNode is a StructuredActivityNode that represents an iterative loop with setup, test, and body sections.
 * <!-- end-model-doc -->
 */
trait UMLLoopNode[Uml <: UML]
	extends UMLStructuredActivityNode[Uml]
	with UMLLoopNodeOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPins on Actions within the bodyPart, the values of which are moved to the loopVariable OutputPins after the completion of each execution of the bodyPart, before the next iteration of the loop begins or before the loop exits.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.bodyOutput_loopNode
	 */
	def bodyOutput: Seq[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The set of ExecutableNodes that perform the repetitive computations of the loop. The bodyPart is executed as long as the test section produces a true value.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.bodyPart_loopNode
	 */
	def bodyPart: Set[UMLExecutableNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * An OutputPin on an Action in the test section whose Boolean value determines whether to continue executing the loop bodyPart.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.decider_loopNode
	 */
	def decider: Option[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * If true, the test is performed before the first execution of the bodyPart. If false, the bodyPart is executed once before the test is performed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isTestedFirst: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A list of OutputPins that hold the values of the loop variables during an execution of the loop. When the test fails, the values are moved to the result OutputPins of the loop.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.loopVariable_loopNode
	 */
	def loopVariable: Seq[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A list of InputPins whose values are moved into the loopVariable Pins before the first iteration of the loop.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInputPin.loopVariableInput_loopNode
	 */
	def loopVariableInput: Seq[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A list of OutputPins that receive the loopVariable values after the last iteration of the loop and constitute the output of the LoopNode.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_loopNode
	 */
	def result: Seq[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The set of ExecutableNodes executed before the first iteration of the loop, in order to initialize values or perform other setup computations.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.setupPart_loopNode
	 */
	def setupPart: Set[UMLExecutableNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The set of ExecutableNodes executed in order to provide the test result for the loop.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLExecutableNode.test_loopNode
	 */
	def test: Set[UMLExecutableNode[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		loopNode_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLoopNode
	 */
	def loopNode_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			structuredActivityNode_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLLoopNode[Uml]](None, "isTestedFirst", (x) => booleanToIterable(x.isTestedFirst, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		loopNode_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLoopNode
	 */
	def loopNode_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			structuredActivityNode_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]]("loopVariable", _.loopVariable, true),
				MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLInputPin[Uml]]("loopVariableInput", _.loopVariableInput, true, Set(StructuredActivityNode_structuredNodeInput)),
				MetaPropertyCollection[Uml, UMLLoopNode[Uml], UMLOutputPin[Uml]]("result", _.result, true, Set(StructuredActivityNode_structuredNodeOutput))))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		loopNode_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLoopNode
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
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		loopNode_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLoopNode
	 */
	def loopNode_forwardReferencesFromMetamodelAssociations: Elements =
		structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
		bodyOutput ++
		bodyPart ++
		decider ++
		setupPart ++
		test 

} //UMLLoopNode
