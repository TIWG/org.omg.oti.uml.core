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
import org.omg.oti.uml.read.operations.UMLOpaqueBehaviorOps

// End of user code

/**
 * An OpaqueBehavior is a Behavior whose specification is given in a textual language other than UML.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
*/
trait UMLOpaqueBehavior[Uml <: UML]
	extends UMLBehavior[Uml]
	with UMLOpaqueBehaviorOps[Uml] {
	
	import ops._

	/**
	 * Specifies the behavior in one or more languages.
	 *
	 * <!-- Start of user code doc for body -->
	 * <!-- End of user code doc for body -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 */
	def body: Seq[String]

	/**
	 * Languages the body strings use in the same order as the body strings.
	 *
	 * <!-- Start of user code doc for language -->
	 * <!-- End of user code doc for language -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
	 */
	def language: Seq[String]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		opaqueBehavior_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLOpaqueBehavior
	 *
	 * <!-- Start of user code doc for opaqueBehavior_metaAttributes -->
	 * <!-- End of user code doc for opaqueBehavior_metaAttributes -->
	 */
	def opaqueBehavior_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavior_metaAttributes,
			Seq (OpaqueBehavior_body,
				OpaqueBehavior_language))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		opaqueBehavior_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLOpaqueBehavior
	 *
	 * <!-- Start of user code doc for opaqueBehavior_compositeMetaProperties -->
	 * <!-- End of user code doc for opaqueBehavior_compositeMetaProperties -->
	 */
	def opaqueBehavior_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		opaqueBehavior_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLOpaqueBehavior
	 *
	 * <!-- Start of user code doc for opaqueBehavior_referenceMetaProperties -->
	 * <!-- End of user code doc for opaqueBehavior_referenceMetaProperties -->
	 */
	def opaqueBehavior_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavior_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		opaqueBehavior_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLOpaqueBehavior
	 *
	 * <!-- Start of user code doc for opaqueBehavior_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for opaqueBehavior_forwardReferencesFromMetamodelAssociations -->
	 */
	def opaqueBehavior_forwardReferencesFromMetamodelAssociations: Elements =
		behavior_forwardReferencesFromMetamodelAssociations ++
		Set () 

	// Start of user code for additional features
	// End of user code
} //UMLOpaqueBehavior
