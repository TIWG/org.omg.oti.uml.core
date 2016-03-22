/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import org.omg.oti.uml.read.operations.UMLReclassifyObjectActionOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
 * A ReclassifyObjectAction is an Action that changes the Classifiers that classify an object.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
*/
trait UMLReclassifyObjectAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLReclassifyObjectActionOps[Uml] {
	
  // Start of user code for class imports
	import ops._
  // End of user code

	/**
	 * Specifies whether existing Classifiers should be removed before adding the new Classifiers.
	 *
	 * <!-- Start of user code doc for isReplaceAll -->
	 * <!-- End of user code doc for isReplaceAll -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReplaceAll: Boolean

	/**
	 * A set of Classifiers to be added to the Classifiers of the given object.
	 *
	 * <!-- Start of user code doc for newClassifier -->
	 * <!-- End of user code doc for newClassifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.newClassifier_reclassifyObjectAction
	 */
	def newClassifier: Set[UMLClassifier[Uml]]

	/**
	 * A set of Classifiers to be removed from the Classifiers of the given object.
	 *
	 * <!-- Start of user code doc for oldClassifier -->
	 * <!-- End of user code doc for oldClassifier -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.oldClassifier_reclassifyObjectAction
	 */
	def oldClassifier: Set[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 *
	 * <!-- Start of user code doc for metaAttributes -->
	 * <!-- End of user code doc for metaAttributes -->
	 */
	override def metaAttributes: MetaAttributeFunctions =
		reclassifyObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReclassifyObjectAction
	 *
	 * <!-- Start of user code doc for reclassifyObjectAction_metaAttributes -->
	 * <!-- End of user code doc for reclassifyObjectAction_metaAttributes -->
	 */
	def reclassifyObjectAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq[MetaAttributeFunction](ReclassifyObjectAction_isReplaceAll))

	/**
	 * The XMI composite meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for compositeMetaProperties -->
	 * <!-- End of user code doc for compositeMetaProperties -->
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		reclassifyObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReclassifyObjectAction
	 *
	 * <!-- Start of user code doc for reclassifyObjectAction_compositeMetaProperties -->
	 * <!-- End of user code doc for reclassifyObjectAction_compositeMetaProperties -->
	 */
	def reclassifyObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq[MetaPropertyEvaluator](ReclassifyObjectAction_object))

	/**
	 * The XMI reference meta-properties relevant to this object
	 *
	 * <!-- Start of user code doc for referenceMetaProperties -->
	 * <!-- End of user code doc for referenceMetaProperties -->
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		reclassifyObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReclassifyObjectAction
	 *
	 * <!-- Start of user code doc for reclassifyObjectAction_referenceMetaProperties -->
	 * <!-- End of user code doc for reclassifyObjectAction_referenceMetaProperties -->
	 */
	def reclassifyObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq[MetaPropertyEvaluator](ReclassifyObjectAction_newClassifier,
				ReclassifyObjectAction_oldClassifier))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 *
	 * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		reclassifyObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReclassifyObjectAction
	 *
	 * <!-- Start of user code doc for reclassifyObjectAction_forwardReferencesFromMetamodelAssociations -->
	 * <!-- End of user code doc for reclassifyObjectAction_forwardReferencesFromMetamodelAssociations -->
	 */
	def reclassifyObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		newClassifier ++
		oldClassifier

	// Start of user code for additional features
	// End of user code
} //UMLReclassifyObjectAction
