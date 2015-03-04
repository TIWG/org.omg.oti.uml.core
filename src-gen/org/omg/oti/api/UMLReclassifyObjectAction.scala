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
 * A ReclassifyObjectAction is an Action that changes the Classifiers that classify an object.
 * <!-- end-model-doc --> 
 */
trait UMLReclassifyObjectAction[Uml <: UML]
	extends UMLAction[Uml]
	with UMLReclassifyObjectActionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The InputPin that holds the object to be reclassified.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLInputPin.object_reclassifyObjectAction
	 */
	def _object: Option[UMLInputPin[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Specifies whether existing Classifiers should be removed before adding the new Classifiers.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isReplaceAll: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * A set of Classifiers to be added to the Classifiers of the given object.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.newClassifier_reclassifyObjectAction
	 */
	def newClassifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A set of Classifiers to be removed from the Classifiers of the given object.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.oldClassifier_reclassifyObjectAction
	 */
	def oldClassifier: Set[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		reclassifyObjectAction_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			action_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLReclassifyObjectAction[Uml]](None, "isReplaceAll", (x) => booleanToIterable(x.isReplaceAll, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		reclassifyObjectAction_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_compositeMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLReclassifyObjectAction[Uml], UMLInputPin[Uml]]("object", _._object)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		reclassifyObjectAction_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			action_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLReclassifyObjectAction[Uml], UMLClassifier[Uml]]("newClassifier", _.newClassifier),
				MetaPropertyCollection[Uml, UMLReclassifyObjectAction[Uml], UMLClassifier[Uml]]("oldClassifier", _.oldClassifier)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		reclassifyObjectAction_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLReclassifyObjectAction
	 */
	def reclassifyObjectAction_forwardReferencesFromMetamodelAssociations: Elements =
		action_forwardReferencesFromMetamodelAssociations ++
		newClassifier ++
		oldClassifier 

} //UMLReclassifyObjectAction
