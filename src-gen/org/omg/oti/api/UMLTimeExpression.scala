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
 * A TimeExpression is a ValueSpecification that represents a time value.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTimeExpression[Uml <: UML]
	extends UMLValueSpecification[Uml]
	with UMLTimeExpressionOps[Uml] {
	
	import ops._

	/**
	 * A ValueSpecification that evaluates to the value of the TimeExpression.
	 *
	 * <!-- Start of user code doc for expr -->
	 * <!-- End of user code doc for expr -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.expr_timeExpression
	 */
	def expr: Option[UMLValueSpecification[Uml]]

	/**
	 * Refers to the Observations that are involved in the computation of the TimeExpression value.
	 *
	 * <!-- Start of user code doc for observation -->
	 * <!-- End of user code doc for observation -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLObservation.observation_timeExpression
	 */
	def observation: Set[UMLObservation[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		timeExpression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTimeExpression
	 *
	 * <!-- Start of user code doc for timeExpression_metaAttributes -->
	 * <!-- End of user code doc for timeExpression_metaAttributes -->
	 */
	def timeExpression_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			valueSpecification_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		timeExpression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTimeExpression
	 *
	 * <!-- Start of user code doc for timeExpression_compositeMetaProperties -->
	 * <!-- End of user code doc for timeExpression_compositeMetaProperties -->
	 */
	def timeExpression_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			valueSpecification_compositeMetaProperties,
			Seq (TimeExpression_expr))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		timeExpression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTimeExpression
	 *
	 * <!-- Start of user code doc for timeExpression_referenceMetaProperties -->
	 * <!-- End of user code doc for timeExpression_referenceMetaProperties -->
	 */
	def timeExpression_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			valueSpecification_referenceMetaProperties,
			Seq (TimeExpression_observation))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		timeExpression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTimeExpression
	 *
	 * <!-- Start of user code doc for timeExpression_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for timeExpression_forwardReferencesFromMetamodelAssociations -->
	 */
	def timeExpression_forwardReferencesFromMetamodelAssociations: Elements =
		valueSpecification_forwardReferencesFromMetamodelAssociations ++
		observation 

	// Start of user code for additional features
	// End of user code
} //UMLTimeExpression
