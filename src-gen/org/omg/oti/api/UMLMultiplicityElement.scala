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
 * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A MultiplicityElement embeds this information to specify the allowable cardinalities for an instantiation of the Element.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLMultiplicityElement[Uml <: UML]
	extends UMLElement[Uml]
	with UMLMultiplicityElementOps[Uml] {
	
	import ops._

	/**
	 * For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this MultiplicityElement are sequentially ordered.
	 *
	 * <!-- Start of user code doc for isOrdered -->
	 * <!-- End of user code doc for isOrdered -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isOrdered: Boolean

	/**
	 * For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this MultiplicityElement are unique.
	 *
	 * <!-- Start of user code doc for isUnique -->
	 * <!-- End of user code doc for isUnique -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isUnique: Boolean

	/**
	 * The lower bound of the multiplicity interval.
	 *
	 * <!-- Start of user code doc for lower -->
	 * <!-- End of user code doc for lower -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (lowerBound())
	 */
	def lower: Integer

	/**
	 * The specification of the lower bound for this multiplicity.
	 *
	 * <!-- Start of user code doc for lowerValue -->
	 * <!-- End of user code doc for lowerValue -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.lowerValue_owningLower
	 */
	def lowerValue: Option[UMLValueSpecification[Uml]]

	/**
	 * The upper bound of the multiplicity interval.
	 *
	 * <!-- Start of user code doc for upper -->
	 * <!-- End of user code doc for upper -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @body result = (upperBound())
	 */
	def upper: Integer

	/**
	 * The specification of the upper bound for this multiplicity.
	 *
	 * <!-- Start of user code doc for upperValue -->
	 * <!-- End of user code doc for upperValue -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.upperValue_owningUpper
	 */
	def upperValue: Option[UMLValueSpecification[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		multiplicityElement_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLMultiplicityElement
	 *
	 * <!-- Start of user code doc for multiplicityElement_metaAttributes -->
	 * <!-- End of user code doc for multiplicityElement_metaAttributes -->
	 */
	def multiplicityElement_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			element_metaAttributes,
			Seq (MultiplicityElement_isOrdered,
				MultiplicityElement_isUnique))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		multiplicityElement_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLMultiplicityElement
	 *
	 * <!-- Start of user code doc for multiplicityElement_compositeMetaProperties -->
	 * <!-- End of user code doc for multiplicityElement_compositeMetaProperties -->
	 */
	def multiplicityElement_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_compositeMetaProperties,
			Seq (MultiplicityElement_lowerValue,
				MultiplicityElement_upperValue))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		multiplicityElement_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLMultiplicityElement
	 *
	 * <!-- Start of user code doc for multiplicityElement_referenceMetaProperties -->
	 * <!-- End of user code doc for multiplicityElement_referenceMetaProperties -->
	 */
	def multiplicityElement_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			element_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		multiplicityElement_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLMultiplicityElement
	 *
	 * <!-- Start of user code doc for multiplicityElement_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for multiplicityElement_forwardReferencesFromMetamodelAssociations -->
	 */
	def multiplicityElement_forwardReferencesFromMetamodelAssociations: Elements =
		element_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLMultiplicityElement
