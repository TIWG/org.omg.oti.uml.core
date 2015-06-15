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
 * A TestIdentityAction is an Action that tests if two values are identical objects.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLTestIdentityAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLTestIdentityActionOps[Uml] {
	
	import ops._

	/**
	 * The InputPin on which the first input object is placed.
	 *
	 * <!-- Start of user code doc for first -->
	 * <!-- End of user code doc for first -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.first_testIdentityAction
	 */
	def first: Option[UMLInputPin[Uml]]

	/**
	 * The OutputPin whose Boolean value indicates whether the two input objects are identical.
	 *
	 * <!-- Start of user code doc for result -->
	 * <!-- End of user code doc for result -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLOutputPin.result_testIdentityAction
	 */
	def result: Option[UMLOutputPin[Uml]]

	/**
	 * The OutputPin on which the second input object is placed.
	 *
	 * <!-- Start of user code doc for second -->
	 * <!-- End of user code doc for second -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.second_testIdentityAction
	 */
	def second: Option[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		testIdentityAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLTestIdentityAction
	 *
	 * <!-- Start of user code doc for testIdentityAction_metaAttributes -->
	 * <!-- End of user code doc for testIdentityAction_metaAttributes -->
	 */
	def testIdentityAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		testIdentityAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLTestIdentityAction
	 *
	 * <!-- Start of user code doc for testIdentityAction_compositeMetaProperties -->
	 * <!-- End of user code doc for testIdentityAction_compositeMetaProperties -->
	 */
	def testIdentityAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (TestIdentityAction_first,
				TestIdentityAction_result,
				TestIdentityAction_second))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		testIdentityAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLTestIdentityAction
	 *
	 * <!-- Start of user code doc for testIdentityAction_referenceMetaProperties -->
	 * <!-- End of user code doc for testIdentityAction_referenceMetaProperties -->
	 */
	def testIdentityAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		testIdentityAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLTestIdentityAction
	 *
	 * <!-- Start of user code doc for testIdentityAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for testIdentityAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def testIdentityAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLTestIdentityAction
