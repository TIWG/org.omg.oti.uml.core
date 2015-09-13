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
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLLinkEndCreationDataOps

// End of user code

/**
 * LinkEndCreationData is LinkEndData used to provide values for one end of a link to be created by a CreateLinkAction.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLLinkEndCreationData[Uml <: UML]
	extends UMLLinkEndData[Uml]
	with UMLLinkEndCreationDataOps[Uml] {
	
	import ops._

	/**
	 * For ordered Association ends, the InputPin that provides the position where the new link should be inserted or where an existing link should be moved to. The type of the insertAt InputPin is UnlimitedNatural, but the input cannot be zero. It is omitted for Association ends that are not ordered.
	 *
	 * <!-- Start of user code doc for insertAt -->
   * <!-- End of user code doc for insertAt -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.insertAt_linkEndCreationData
	 */
	def insertAt: Option[UMLInputPin[Uml]]

	/**
	 * Specifies whether the existing links emanating from the object on this end should be destroyed before creating a new link.
	 *
	 * <!-- Start of user code doc for isReplaceAll -->
   * <!-- End of user code doc for isReplaceAll -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReplaceAll: Boolean

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		linkEndCreationData_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLLinkEndCreationData
	 *
	 * <!-- Start of user code doc for linkEndCreationData_metaAttributes -->
   * <!-- End of user code doc for linkEndCreationData_metaAttributes -->
	 */
	def linkEndCreationData_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			linkEndData_metaAttributes,
			Seq (LinkEndCreationData_isReplaceAll))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		linkEndCreationData_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLLinkEndCreationData
	 *
	 * <!-- Start of user code doc for linkEndCreationData_compositeMetaProperties -->
   * <!-- End of user code doc for linkEndCreationData_compositeMetaProperties -->
	 */
	def linkEndCreationData_compositeMetaProperties: MetaPropertyFunctions = 
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
		linkEndCreationData_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLLinkEndCreationData
	 *
	 * <!-- Start of user code doc for linkEndCreationData_referenceMetaProperties -->
   * <!-- End of user code doc for linkEndCreationData_referenceMetaProperties -->
	 */
	def linkEndCreationData_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			linkEndData_referenceMetaProperties,
			Seq (LinkEndCreationData_insertAt))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		linkEndCreationData_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLLinkEndCreationData
	 *
	 * <!-- Start of user code doc for linkEndCreationData_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for linkEndCreationData_forwardReferencesFromMetamodelAssociations -->
	 */
	def linkEndCreationData_forwardReferencesFromMetamodelAssociations: Elements =
		linkEndData_forwardReferencesFromMetamodelAssociations ++
		insertAt

	// Start of user code for additional features
  // End of user code
} //UMLLinkEndCreationData
