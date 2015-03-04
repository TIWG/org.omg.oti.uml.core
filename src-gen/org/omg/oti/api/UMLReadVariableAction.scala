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
 * A ReadVariableAction is a VariableAction that retrieves the values of a Variable.
 * <!-- end-model-doc --> 
 */
trait UMLReadVariableAction[Uml <: UML]
	extends UMLVariableAction[Uml]
	with UMLReadVariableActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPin on which the result values are placed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_readVariableAction
	 */
	def result: Option[UMLOutputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readVariableAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadVariableAction
	 */
	def readVariableAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			variableAction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		readVariableAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadVariableAction
	 */
	def readVariableAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			variableAction_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLReadVariableAction[Uml], UMLOutputPin[Uml]]("result", _.result)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readVariableAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadVariableAction
	 */
	def readVariableAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			variableAction_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readVariableAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadVariableAction
	 */
	def readVariableAction_forwardReferencesFromMetamodelAssociations: Elements =
		variableAction_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLReadVariableAction
