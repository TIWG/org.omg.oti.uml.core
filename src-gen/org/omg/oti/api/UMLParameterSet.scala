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
 * A ParameterSet designates alternative sets of inputs or outputs that a Behavior may use.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLParameterSet[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLParameterSetOps[Uml] {
	
	import ops._

	/**
	 * A constraint that should be satisfied for the owner of the Parameters in an input ParameterSet to start execution using the values provided for those Parameters, or the owner of the Parameters in an output ParameterSet to end execution providing the values for those Parameters, if all preconditions and conditions on input ParameterSets were satisfied.
	 *
	 * <!-- Start of user code doc for condition -->
	 * <!-- End of user code doc for condition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLConstraint.condition_parameterSet
	 */
	def condition: Set[UMLConstraint[Uml]]

	/**
	 * Parameters in the ParameterSet.
	 *
	 * <!-- Start of user code doc for parameter -->
	 * <!-- End of user code doc for parameter -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLParameter.parameterSet
	 */
	def parameter: Set[UMLParameter[Uml]]

	/**
	 * <!-- Start of user code doc for ownedParameterSet_behavior -->
	 * <!-- End of user code doc for ownedParameterSet_behavior -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.ownedParameterSet
	 */
	def ownedParameterSet_behavior: Option[UMLBehavior[Uml]]

	/**
	 * <!-- Start of user code doc for ownedParameterSet_behavioralFeature -->
	 * <!-- End of user code doc for ownedParameterSet_behavioralFeature -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioralFeature.ownedParameterSet
	 */
	def ownedParameterSet_behavioralFeature: Option[UMLBehavioralFeature[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		parameterSet_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLParameterSet
	 *
	 * <!-- Start of user code doc for parameterSet_metaAttributes -->
	 * <!-- End of user code doc for parameterSet_metaAttributes -->
	 */
	def parameterSet_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		parameterSet_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLParameterSet
	 *
	 * <!-- Start of user code doc for parameterSet_compositeMetaProperties -->
	 * <!-- End of user code doc for parameterSet_compositeMetaProperties -->
	 */
	def parameterSet_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq (ParameterSet_condition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		parameterSet_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLParameterSet
	 *
	 * <!-- Start of user code doc for parameterSet_referenceMetaProperties -->
	 * <!-- End of user code doc for parameterSet_referenceMetaProperties -->
	 */
	def parameterSet_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (ParameterSet_parameter))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		parameterSet_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLParameterSet
	 *
	 * <!-- Start of user code doc for parameterSet_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for parameterSet_forwardReferencesFromMetamodelAssociations -->
	 */
	def parameterSet_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		parameter 

	// Start of user code for additional features
	// End of user code
} //UMLParameterSet
