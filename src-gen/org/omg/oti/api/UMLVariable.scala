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
 * A Variable is a ConnectableElement that may store values during the execution of an Activity. Reading and writing the values of a Variable provides an alternative means for passing data than the use of ObjectFlows. A Variable may be owned directly by an Activity, in which case it is accessible from anywhere within that activity, or it may be owned by a StructuredActivityNode, in which case it is only accessible within that node.
 * <!-- end-model-doc --> 
 */
trait UMLVariable[Uml <: UML]
	extends UMLConnectableElement[Uml]
	with UMLMultiplicityElement[Uml]
	with UMLVariableOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * An Activity that owns the Variable.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLActivity.variable
	 */
	def activityScope: Option[UMLActivity[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A StructuredActivityNode that owns the Variable.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStructuredActivityNode.variable
	 */
	def scope: Option[UMLStructuredActivityNode[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLVariableAction.variable
	 */
	def variable_variableAction: Set[UMLVariableAction[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		variable_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLVariable
	 */
	def variable_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			connectableElement_metaAttributes,
			multiplicityElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		variable_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLVariable
	 */
	def variable_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_compositeMetaProperties,
			multiplicityElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		variable_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLVariable
	 */
	def variable_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			connectableElement_referenceMetaProperties,
			multiplicityElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLVariable[Uml], UMLActivity[Uml]]("activityScope", _.activityScope),
				MetaPropertyReference[Uml, UMLVariable[Uml], UMLStructuredActivityNode[Uml]]("scope", _.scope)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		variable_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLVariable
	 */
	def variable_forwardReferencesFromMetamodelAssociations: Elements =
		connectableElement_forwardReferencesFromMetamodelAssociations ++
		multiplicityElement_forwardReferencesFromMetamodelAssociations ++
		activityScope ++
		scope 

} //UMLVariable
