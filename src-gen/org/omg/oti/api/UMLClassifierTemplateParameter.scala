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
 * A ClassifierTemplateParameter exposes a Classifier as a formal template parameter.
 * <!-- end-model-doc -->
 */
trait UMLClassifierTemplateParameter[Uml <: UML]
	extends UMLTemplateParameter[Uml]
	with UMLClassifierTemplateParameterOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Constrains the required relationship between an actual parameter and the parameteredElement for this formal parameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def allowSubstitutable: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * The classifiers that constrain the argument that can be used for the parameter. If the allowSubstitutable attribute is true, then any Classifier that is compatible with this constraining Classifier can be substituted; otherwise, it must be either this Classifier or one of its specializations. If this property is empty, there are no constraints on the Classifier that can be used as an argument.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.constrainingClassifier_classifierTemplateParameter
	 */
	def constrainingClassifier: Set[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Classifier exposed by this ClassifierTemplateParameter.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLClassifier.templateParameter
	 */
	override def parameteredElement: Option[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		classifierTemplateParameter_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			templateParameter_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLClassifierTemplateParameter[Uml]](None, "allowSubstitutable", (x) => booleanToIterable(x.allowSubstitutable, true))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		classifierTemplateParameter_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			templateParameter_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		classifierTemplateParameter_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			templateParameter_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLClassifierTemplateParameter[Uml], UMLClassifier[Uml]]("constrainingClassifier", _.constrainingClassifier),
				MetaPropertyReference[Uml, UMLClassifierTemplateParameter[Uml], UMLClassifier[Uml]]("parameteredElement", _.parameteredElement)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		classifierTemplateParameter_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClassifierTemplateParameter
	 */
	def classifierTemplateParameter_forwardReferencesFromMetamodelAssociations: Elements =
		templateParameter_forwardReferencesFromMetamodelAssociations ++
		constrainingClassifier ++
		parameteredElement 

} //UMLClassifierTemplateParameter
