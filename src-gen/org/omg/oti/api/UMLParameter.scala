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
 * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
 * <!-- end-model-doc --> 
 */
trait UMLParameter[Uml <: UML]
	extends UMLConnectableElement[Uml]
	with UMLMultiplicityElement[Uml]
	with UMLParameterOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * A String that represents a value to be used when no argument is supplied for the Parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def default: Option[String]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies a ValueSpecification that represents a value to be used when no argument is supplied for the Parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLValueSpecification.defaultValue_owningParameter
	 */
	def defaultValue: Option[UMLValueSpecification[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether a parameter is being sent into or out of a behavioral element.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def direction: UMLParameterDirectionKind.Value

	/**
	 * <!-- begin-model-doc -->
	 * Specifies the effect that executions of the owner of the Parameter have on objects passed in or out of the parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 */
	def effect: Option[UMLParameterEffectKind.Value]

	/**
	 * <!-- begin-model-doc -->
	 * Tells whether an output parameter may emit a value to the exclusion of the other outputs.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isException: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Tells whether an input parameter may accept values while its behavior is executing, or whether an output parameter may post values while the behavior is executing.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isStream: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * The Operation owning this parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLOperation.ownedParameter
	 */
	def operation: Option[UMLOperation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterSets containing the parameter. See ParameterSet.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameterSet.parameter
	 */
	def parameterSet: Set[UMLParameterSet[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavior.ownedParameter
	 */
	def ownedParameter_behavior: Option[UMLBehavior[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLBehavioralFeature.ownedParameter
	 */
	def ownedParameter_ownerFormalParam: Option[UMLBehavioralFeature[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLActivityParameterNode.parameter
	 */
	def parameter_activityParameterNode: Set[UMLActivityParameterNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOpaqueExpression.result
	 */
	def result_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		parameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLParameter
	 */
	def parameter_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			connectableElement_metaAttributes,
			multiplicityElement_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLParameter[Uml]](None, "isException", (x) => booleanToIterable(x.isException, false)),
				MetaAttributeBooleanFunction[Uml, UMLParameter[Uml]](None, "isStream", (x) => booleanToIterable(x.isStream, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		parameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLParameter
	 */
	def parameter_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_compositeMetaProperties,
			multiplicityElement_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLParameter[Uml], UMLValueSpecification[Uml]]("defaultValue", _.defaultValue)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		parameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLParameter
	 */
	def parameter_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_referenceMetaProperties,
			multiplicityElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLParameter[Uml], UMLOperation[Uml]]("operation", _.operation),
				MetaPropertyCollection[Uml, UMLParameter[Uml], UMLParameterSet[Uml]]("parameterSet", _.parameterSet)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		parameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLParameter
	 */
	def parameter_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		operation ++
		parameterSet 

} //UMLParameter
