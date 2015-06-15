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
 * LinkEndDestructionData is LinkEndData used to provide values for one end of a link to be destroyed by a DestroyLinkAction.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLLinkEndDestructionData[Uml <: UML]
	extends UMLLinkEndData[Uml]
	with UMLLinkEndDestructionDataOps[Uml] {
	
	import ops._

	/**
	 * The InputPin that provides the position of an existing link to be destroyed in an ordered, nonunique Association end. The type of the destroyAt InputPin is UnlimitedNatural, but the value cannot be zero or unlimited.
	 *
	 * <!-- Start of user code doc for destroyAt -->
	 * <!-- End of user code doc for destroyAt -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLInputPin.destroyAt_linkEndDestructionData
	 */
	def destroyAt: Option[UMLInputPin[Uml]]

	/**
	 * Specifies whether to destroy duplicates of the value in nonunique Association ends.
	 *
	 * <!-- Start of user code doc for isDestroyDuplicates -->
	 * <!-- End of user code doc for isDestroyDuplicates -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDestroyDuplicates: Boolean

	/**
	 * <!-- Start of user code doc for endData_destroyLinkAction -->
	 * <!-- End of user code doc for endData_destroyLinkAction -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLDestroyLinkAction.endData
	 */
	def endData_destroyLinkAction: Option[UMLDestroyLinkAction[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkEndDestructionData_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkEndDestructionData
	 *
	 * <!-- Start of user code doc for linkEndDestructionData_metaAttributes -->
	 * <!-- End of user code doc for linkEndDestructionData_metaAttributes -->
	 */
	def linkEndDestructionData_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			linkEndData_metaAttributes,
			Seq (LinkEndDestructionData_isDestroyDuplicates))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkEndDestructionData_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkEndDestructionData
	 *
	 * <!-- Start of user code doc for linkEndDestructionData_compositeMetaProperties -->
	 * <!-- End of user code doc for linkEndDestructionData_compositeMetaProperties -->
	 */
	def linkEndDestructionData_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkEndData_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		linkEndDestructionData_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkEndDestructionData
	 *
	 * <!-- Start of user code doc for linkEndDestructionData_referenceMetaProperties -->
	 * <!-- End of user code doc for linkEndDestructionData_referenceMetaProperties -->
	 */
	def linkEndDestructionData_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkEndData_referenceMetaProperties,
			Seq (LinkEndDestructionData_destroyAt))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkEndDestructionData_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkEndDestructionData
	 *
	 * <!-- Start of user code doc for linkEndDestructionData_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for linkEndDestructionData_forwardReferencesFromMetamodelAssociations -->
	 */
	def linkEndDestructionData_forwardReferencesFromMetamodelAssociations: Elements =
		linkEndData_forwardReferencesFromMetamodelAssociations ++
		destroyAt 

	// Start of user code for additional features
	// End of user code
} //UMLLinkEndDestructionData
