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
 * A CombinedFragment defines an expression of InteractionFragments. A CombinedFragment is defined by an interaction operator and corresponding InteractionOperands. Through the use of CombinedFragments the user will be able to describe a number of traces in a compact and concise manner.
 * <!-- end-model-doc --> 
 */
trait UMLCombinedFragment[Uml <: UML]
	extends UMLInteractionFragment[Uml]
	with UMLCombinedFragmentOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the gates that form the interface between this CombinedFragment and its surroundings
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGate.cfragmentGate_combinedFragment
	 */
	def cfragmentGate: Set[UMLGate[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the operation which defines the semantics of this combination of InteractionFragments.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def interactionOperator: UMLInteractionOperatorKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * The set of operands of the combined fragment.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLInteractionOperand.operand_combinedFragment
	 */
	def operand: Seq[UMLInteractionOperand[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		combinedFragment_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCombinedFragment
	 */
	def combinedFragment_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			interactionFragment_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		combinedFragment_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCombinedFragment
	 */
	def combinedFragment_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interactionFragment_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLCombinedFragment[Uml], UMLGate[Uml]]("cfragmentGate", _.cfragmentGate),
				MetaPropertyCollection[Uml, UMLCombinedFragment[Uml], UMLInteractionOperand[Uml]]("operand", _.operand)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		combinedFragment_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCombinedFragment
	 */
	def combinedFragment_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			interactionFragment_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		combinedFragment_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCombinedFragment
	 */
	def combinedFragment_forwardReferencesFromMetamodelAssociations: Elements =
		interactionFragment_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLCombinedFragment
