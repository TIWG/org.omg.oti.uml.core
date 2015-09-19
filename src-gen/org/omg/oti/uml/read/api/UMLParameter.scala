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
import org.omg.oti.uml.read.operations.UMLParameterOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLParameter[Uml <: UML]
	extends UMLConnectableElement[Uml]
	with UMLMultiplicityElement[Uml]
	with UMLParameterOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Specifies a ValueSpecification that represents a value to be used when no argument is supplied for the Parameter.
	 *
	 * <!-- Start of user code doc for defaultValue -->
   * <!-- End of user code doc for defaultValue -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.defaultValue_owningParameter
	 */
	def defaultValue: Option[UMLValueSpecification[Uml]]

	/**
	 * Indicates whether a parameter is being sent into or out of a behavioral element.
	 *
	 * <!-- Start of user code doc for direction -->
   * <!-- End of user code doc for direction -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def direction: UMLParameterDirectionKind.Value

	/**
	 * Specifies the effect that executions of the owner of the Parameter have on objects passed in or out of the parameter.
	 *
	 * <!-- Start of user code doc for effect -->
   * <!-- End of user code doc for effect -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def effect: Option[UMLParameterEffectKind.Value]

	/**
	 * Tells whether an output parameter may emit a value to the exclusion of the other outputs.
	 *
	 * <!-- Start of user code doc for isException -->
   * <!-- End of user code doc for isException -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isException: Boolean

	/**
	 * Tells whether an input parameter may accept values while its behavior is executing, or whether an output parameter may post values while the behavior is executing.
	 *
	 * <!-- Start of user code doc for isStream -->
   * <!-- End of user code doc for isStream -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isStream: Boolean

	/**
	 * The ParameterSets containing the parameter. See ParameterSet.
	 *
	 * <!-- Start of user code doc for parameterSet -->
   * <!-- End of user code doc for parameterSet -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterSet.parameter
	 */
	def parameterSet: Set[UMLParameterSet[Uml]]

	/**
	 * <!-- Start of user code doc for parameter_activityParameterNode -->
   * <!-- End of user code doc for parameter_activityParameterNode -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityParameterNode.parameter
	 */
	def parameter_activityParameterNode: Set[UMLActivityParameterNode[Uml]]

	/**
	 * <!-- Start of user code doc for result_opaqueExpression -->
   * <!-- End of user code doc for result_opaqueExpression -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOpaqueExpression.result
	 */
	def result_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		parameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLParameter
	 *
	 * <!-- Start of user code doc for parameter_metaAttributes -->
   * <!-- End of user code doc for parameter_metaAttributes -->
	 */
	def parameter_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			connectableElement_metaAttributes,
			multiplicityElement_metaAttributes,
			Seq[MetaAttributeFunction](Parameter_isException,
				Parameter_isStream))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		parameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLParameter
	 *
	 * <!-- Start of user code doc for parameter_compositeMetaProperties -->
   * <!-- End of user code doc for parameter_compositeMetaProperties -->
	 */
	def parameter_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_compositeMetaProperties,
			multiplicityElement_compositeMetaProperties,
			Seq[MetaPropertyEvaluator](Parameter_defaultValue))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		parameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLParameter
	 *
	 * <!-- Start of user code doc for parameter_referenceMetaProperties -->
   * <!-- End of user code doc for parameter_referenceMetaProperties -->
	 */
	def parameter_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_referenceMetaProperties,
			multiplicityElement_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](Parameter_parameterSet))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		parameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLParameter
	 *
	 * <!-- Start of user code doc for parameter_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for parameter_forwardReferencesFromMetamodelAssociations -->
	 */
	def parameter_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		parameterSet

	// Start of user code for additional features
  // End of user code
} //UMLParameter
