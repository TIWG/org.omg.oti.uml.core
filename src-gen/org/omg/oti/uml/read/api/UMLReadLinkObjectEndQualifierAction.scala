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
import org.omg.oti.uml.read.operations.UMLReadLinkObjectEndQualifierActionOps

// End of user code

/**
 * A ReadLinkObjectEndQualifierAction is an Action that retrieves a qualifier end value from a link object.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLReadLinkObjectEndQualifierAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLReadLinkObjectEndQualifierActionOps[Uml] {
	
	import ops._

	/**
	 * The qualifier Property to be read.
	 *
	 * <!-- Start of user code doc for qualifier -->
   * <!-- End of user code doc for qualifier -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.uml.read.api.UMLProperty.qualifier_readLinkObjectEndQualifierAction
	 */
	def qualifier: Option[UMLProperty[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		readLinkObjectEndQualifierAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReadLinkObjectEndQualifierAction
	 *
	 * <!-- Start of user code doc for readLinkObjectEndQualifierAction_metaAttributes -->
   * <!-- End of user code doc for readLinkObjectEndQualifierAction_metaAttributes -->
	 */
	def readLinkObjectEndQualifierAction_metaAttributes: MetaAttributeFunctions = 
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
		readLinkObjectEndQualifierAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReadLinkObjectEndQualifierAction
	 *
	 * <!-- Start of user code doc for readLinkObjectEndQualifierAction_compositeMetaProperties -->
   * <!-- End of user code doc for readLinkObjectEndQualifierAction_compositeMetaProperties -->
	 */
	def readLinkObjectEndQualifierAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (ReadLinkObjectEndQualifierAction_object,
				ReadLinkObjectEndQualifierAction_result))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		readLinkObjectEndQualifierAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReadLinkObjectEndQualifierAction
	 *
	 * <!-- Start of user code doc for readLinkObjectEndQualifierAction_referenceMetaProperties -->
   * <!-- End of user code doc for readLinkObjectEndQualifierAction_referenceMetaProperties -->
	 */
	def readLinkObjectEndQualifierAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (ReadLinkObjectEndQualifierAction_qualifier))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		readLinkObjectEndQualifierAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReadLinkObjectEndQualifierAction
	 *
	 * <!-- Start of user code doc for readLinkObjectEndQualifierAction_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for readLinkObjectEndQualifierAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def readLinkObjectEndQualifierAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		qualifier

	// Start of user code for additional features
  // End of user code
} //UMLReadLinkObjectEndQualifierAction
