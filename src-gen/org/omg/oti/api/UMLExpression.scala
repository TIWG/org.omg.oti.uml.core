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
 * An Expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol, and has a possibly empty sequence of operands that are ValueSpecifications. It denotes a (possibly empty) set of values when evaluated in a context.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLExpression[Uml <: UML]
	extends UMLValueSpecification[Uml]
	with UMLExpressionOps[Uml] {
	
	import ops._

	/**
	 * Specifies a sequence of operand ValueSpecifications.
	 *
	 * <!-- Start of user code doc for operand -->
	 * <!-- End of user code doc for operand -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLValueSpecification.operand_expression
	 */
	def operand: Seq[UMLValueSpecification[Uml]]

	/**
	 * The symbol associated with this node in the expression tree.
	 *
	 * <!-- Start of user code doc for symbol -->
	 * <!-- End of user code doc for symbol -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def symbol: Option[String]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		expression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExpression
	 *
	 * <!-- Start of user code doc for expression_metaAttributes -->
	 * <!-- End of user code doc for expression_metaAttributes -->
	 */
	def expression_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			valueSpecification_metaAttributes,
			Seq (Expression_symbol))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		expression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExpression
	 *
	 * <!-- Start of user code doc for expression_compositeMetaProperties -->
	 * <!-- End of user code doc for expression_compositeMetaProperties -->
	 */
	def expression_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			valueSpecification_compositeMetaProperties,
			Seq (Expression_operand))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		expression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExpression
	 *
	 * <!-- Start of user code doc for expression_referenceMetaProperties -->
	 * <!-- End of user code doc for expression_referenceMetaProperties -->
	 */
	def expression_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			valueSpecification_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		expression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExpression
	 *
	 * <!-- Start of user code doc for expression_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for expression_forwardReferencesFromMetamodelAssociations -->
	 */
	def expression_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLExpression
