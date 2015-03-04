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
 * A TestIdentityAction is an Action that tests if two values are identical objects.
 * <!-- end-model-doc --> 
 */
trait UMLTestIdentityAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLTestIdentityActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin on which the first input object is placed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.first_testIdentityAction
	 */
	def first: Option[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPin whose Boolean value indicates whether the two input objects are identical.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_testIdentityAction
	 */
	def result: Option[UMLOutputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The OutputPin on which the second input object is placed.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.second_testIdentityAction
	 */
	def second: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		testIdentityAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		testIdentityAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLInputPin[Uml]]("first", _.first),
				MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLOutputPin[Uml]]("result", _.result),
				MetaPropertyReference[Uml, UMLTestIdentityAction[Uml], UMLInputPin[Uml]]("second", _.second)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		testIdentityAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		testIdentityAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTestIdentityAction
	 */
	def testIdentityAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLTestIdentityAction
