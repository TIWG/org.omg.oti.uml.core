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
 * LinkAction is an abstract class for all Actions that identify the links to be acted on using LinkEndData.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLLinkAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLLinkActionOps[Uml] {
	
	import ops._

	/**
	 * The LinkEndData identifying the values on the ends of the links acting on by this LinkAction.
	 *
	 * <!-- Start of user code doc for endData -->
	 * <!-- End of user code doc for endData -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="2..*"
	 * @opposite org.omg.oti.api.UMLLinkEndData.endData_linkAction
	 */
	def endData: Iterable[UMLLinkEndData[Uml]]

	/**
	 * InputPins used by the LinkEndData of the LinkAction.
	 *
	 * <!-- Start of user code doc for inputValue -->
	 * <!-- End of user code doc for inputValue -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLInputPin.inputValue_linkAction
	 */
	def inputValue: Set[UMLInputPin[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkAction
	 *
	 * <!-- Start of user code doc for linkAction_metaAttributes -->
	 * <!-- End of user code doc for linkAction_metaAttributes -->
	 */
	def linkAction_metaAttributes: MetaAttributeFunctions = 
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
		linkAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkAction
	 *
	 * <!-- Start of user code doc for linkAction_compositeMetaProperties -->
	 * <!-- End of user code doc for linkAction_compositeMetaProperties -->
	 */
	def linkAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (LinkAction_endData,
				LinkAction_inputValue))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkAction
	 *
	 * <!-- Start of user code doc for linkAction_referenceMetaProperties -->
	 * <!-- End of user code doc for linkAction_referenceMetaProperties -->
	 */
	def linkAction_referenceMetaProperties: MetaPropertyFunctions = 
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
		linkAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkAction
	 *
	 * <!-- Start of user code doc for linkAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for linkAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def linkAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLLinkAction
