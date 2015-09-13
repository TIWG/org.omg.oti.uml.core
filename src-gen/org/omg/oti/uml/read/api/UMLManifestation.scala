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
import org.omg.oti.uml.read.operations.UMLManifestationOps

// End of user code

/**
 * A manifestation is the concrete physical rendering of one or more model elements by an artifact.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLManifestation[Uml <: UML]
	extends UMLAbstraction[Uml]
	with UMLManifestationOps[Uml] {
	
	import ops._

	/**
	 * The model element that is utilized in the manifestation in an Artifact.
	 *
	 * <!-- Start of user code doc for utilizedElement -->
   * <!-- End of user code doc for utilizedElement -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageableElement.utilizedElement_manifestation
	 */
	def utilizedElement: Option[UMLPackageableElement[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
   * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		manifestation_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLManifestation
	 *
	 * <!-- Start of user code doc for manifestation_metaAttributes -->
   * <!-- End of user code doc for manifestation_metaAttributes -->
	 */
	def manifestation_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			abstraction_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
   * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		manifestation_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLManifestation
	 *
	 * <!-- Start of user code doc for manifestation_compositeMetaProperties -->
   * <!-- End of user code doc for manifestation_compositeMetaProperties -->
	 */
	def manifestation_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			abstraction_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
   * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		manifestation_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLManifestation
	 *
	 * <!-- Start of user code doc for manifestation_referenceMetaProperties -->
   * <!-- End of user code doc for manifestation_referenceMetaProperties -->
	 */
	def manifestation_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			abstraction_referenceMetaProperties,
			Seq (Manifestation_utilizedElement))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		manifestation_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLManifestation
	 *
	 * <!-- Start of user code doc for manifestation_forwardReferencesFromMetamodelAssociations -->
   * <!-- End of user code doc for manifestation_forwardReferencesFromMetamodelAssociations -->
	 */
	def manifestation_forwardReferencesFromMetamodelAssociations: Elements =
		abstraction_forwardReferencesFromMetamodelAssociations ++
		utilizedElement

	// Start of user code for additional features
  // End of user code
} //UMLManifestation
