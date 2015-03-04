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
 * A UseCase specifies a set of actions performed by its subjects, which yields an observable result that is of value for one or more Actors or other stakeholders of each subject.
 * <!-- end-model-doc --> 
 */
trait UMLUseCase[Uml <: UML]
	extends UMLBehavioredClassifier[Uml]
	with UMLUseCaseOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Extend relationships owned by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtend.extension
	 */
	def extend: Set[UMLExtend[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The ExtensionPoints owned by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtensionPoint.useCase
	 */
	def extensionPoint: Set[UMLExtensionPoint[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Include relationships owned by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInclude.includingCase
	 */
	def include: Set[UMLInclude[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The subjects to which this UseCase applies. Each subject or its parts realize all the UseCases that apply to it.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.useCase
	 */
	def subject: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInclude.addition
	 */
	def addition_include: Set[UMLInclude[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtend.extendedCase
	 */
	def extendedCase_extend: Set[UMLExtend[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.ownedUseCase
	 */
	def ownedUseCase_classifier: Option[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		useCase_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLUseCase
	 */
	def useCase_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavioredClassifier_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		useCase_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLUseCase
	 */
	def useCase_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioredClassifier_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLExtend[Uml]]("extend", _.extend),
				MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLExtensionPoint[Uml]]("extensionPoint", _.extensionPoint),
				MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLInclude[Uml]]("include", _.include)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		useCase_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLUseCase
	 */
	def useCase_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioredClassifier_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLUseCase[Uml], UMLClassifier[Uml]]("subject", _.subject)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		useCase_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLUseCase
	 */
	def useCase_forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		subject 

} //UMLUseCase
