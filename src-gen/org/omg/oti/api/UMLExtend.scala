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
 * A relationship from an extending UseCase to an extended UseCase that specifies how and when the behavior defined in the extending UseCase can be inserted into the behavior defined in the extended UseCase.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLExtend[Uml <: UML]
	extends UMLDirectedRelationship[Uml]
	with UMLNamedElement[Uml]
	with UMLExtendOps[Uml] {
	
	import ops._

	/**
	 * References the condition that must hold when the first ExtensionPoint is reached for the extension to take place. If no constraint is associated with the Extend relationship, the extension is unconditional.
	 *
	 * <!-- Start of user code doc for condition -->
	 * <!-- End of user code doc for condition -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLConstraint.condition_extend
	 */
	def condition: Option[UMLConstraint[Uml]]

	/**
	 * The UseCase that is being extended.
	 *
	 * <!-- Start of user code doc for extendedCase -->
	 * <!-- End of user code doc for extendedCase -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLUseCase.extendedCase_extend
	 */
	def extendedCase: Option[UMLUseCase[Uml]]

	/**
	 * The UseCase that represents the extension and owns the Extend relationship.
	 *
	 * <!-- Start of user code doc for extension -->
	 * <!-- End of user code doc for extension -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLUseCase.extend
	 */
	def extension: Option[UMLUseCase[Uml]]

	/**
	 * An ordered list of ExtensionPoints belonging to the extended UseCase, specifying where the respective behavioral fragments of the extending UseCase are to be inserted. The first fragment in the extending UseCase is associated with the first extension point in the list, the second fragment with the second point, and so on. Note that, in most practical cases, the extending UseCase has just a single behavior fragment, so that the list of ExtensionPoints is trivial.
	 *
	 * <!-- Start of user code doc for extensionLocation -->
	 * <!-- End of user code doc for extensionLocation -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="1..*"
	 * @opposite org.omg.oti.api.UMLExtensionPoint.extensionLocation_extension
	 */
	def extensionLocation: Seq[UMLExtensionPoint[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		extend_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLExtend
	 *
	 * <!-- Start of user code doc for extend_metaAttributes -->
	 * <!-- End of user code doc for extend_metaAttributes -->
	 */
	def extend_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			directedRelationship_metaAttributes,
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		extend_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLExtend
	 *
	 * <!-- Start of user code doc for extend_compositeMetaProperties -->
	 * <!-- End of user code doc for extend_compositeMetaProperties -->
	 */
	def extend_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_compositeMetaProperties,
			namedElement_compositeMetaProperties,
			Seq (Extend_condition))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		extend_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLExtend
	 *
	 * <!-- Start of user code doc for extend_referenceMetaProperties -->
	 * <!-- End of user code doc for extend_referenceMetaProperties -->
	 */
	def extend_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			directedRelationship_referenceMetaProperties,
			namedElement_referenceMetaProperties,
			Seq (Extend_extendedCase,
				Extend_extensionLocation))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		extend_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLExtend
	 *
	 * <!-- Start of user code doc for extend_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for extend_forwardReferencesFromMetamodelAssociations -->
	 */
	def extend_forwardReferencesFromMetamodelAssociations: Elements =
		directedRelationship_forwardReferencesFromMetamodelAssociations ++
		namedElement_forwardReferencesFromMetamodelAssociations ++
		extendedCase ++
		extension ++
		extensionLocation 

	// Start of user code for additional features
	// End of user code
} //UMLExtend
