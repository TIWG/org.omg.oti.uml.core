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
 * A CollaborationUse is used to specify the application of a pattern specified by a Collaboration to a specific situation.
 * <!-- end-model-doc -->
 */
trait UMLCollaborationUse[Uml <: UML]
	extends UMLNamedElement[Uml]
	with UMLCollaborationUseOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Collaboration which is used in this CollaborationUse. The Collaboration defines the cooperation between its roles which are mapped to ConnectableElements relating to the Classifier owning the CollaborationUse.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLCollaboration.type_collaborationUse
	 */
	def _type: Option[UMLCollaboration[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * A mapping between features of the Collaboration and features of the owning Classifier. This mapping indicates which ConnectableElement of the Classifier plays which role(s) in the Collaboration. A ConnectableElement may be bound to multiple roles in the same CollaborationUse (that is, it may play multiple roles).
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDependency.roleBinding_collaborationUse
	 */
	def roleBinding: Set[UMLDependency[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.collaborationUse
	 */
	def collaborationUse_classifier: Option[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.representation
	 */
	def representation_classifier: Option[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		collaborationUse_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLCollaborationUse
	 */
	def collaborationUse_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			namedElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		collaborationUse_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLCollaborationUse
	 */
	def collaborationUse_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLCollaborationUse[Uml], UMLDependency[Uml]]("roleBinding", _.roleBinding)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		collaborationUse_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLCollaborationUse
	 */
	def collaborationUse_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			namedElement_referenceMetaProperties,
			Seq (MetaPropertyReference[Uml, UMLCollaborationUse[Uml], UMLCollaboration[Uml]]("type", _._type)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		collaborationUse_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLCollaborationUse
	 */
	def collaborationUse_forwardReferencesFromMetamodelAssociations: Elements =
		namedElement_forwardReferencesFromMetamodelAssociations ++
		_type 

} //UMLCollaborationUse
