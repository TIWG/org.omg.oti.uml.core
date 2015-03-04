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
 * A GeneralizationSet is a PackageableElement whose instances represent sets of Generalization relationships.
 * <!-- end-model-doc --> 
 */
trait UMLGeneralizationSet[Uml <: UML]
	extends UMLPackageableElement[Uml]
	with UMLGeneralizationSetOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * Designates the instances of Generalization that are members of this GeneralizationSet.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLGeneralization.generalizationSet
	 */
	def generalization: Set[UMLGeneralization[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * Indicates (via the associated Generalizations) whether or not the set of specific Classifiers are covering for a particular general classifier. When isCovering is true, every instance of a particular general Classifier is also an instance of at least one of its specific Classifiers for the GeneralizationSet. When isCovering is false, there are one or more instances of the particular general Classifier that are not instances of at least one of its specific Classifiers defined for the GeneralizationSet.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isCovering: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Indicates whether or not the set of specific Classifiers in a Generalization relationship have instance in common. If isDisjoint is true, the specific Classifiers for a particular GeneralizationSet have no members in common; that is, their intersection is empty. If isDisjoint is false, the specific Classifiers in a particular GeneralizationSet have one or more members in common; that is, their intersection is not empty.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isDisjoint: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Designates the Classifier that is defined as the power type for the associated GeneralizationSet, if there is one.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLClassifier.powertypeExtent
	 */
	def powertype: Option[UMLClassifier[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		generalizationSet_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			packageableElement_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLGeneralizationSet[Uml]](None, "isCovering", (x) => booleanToIterable(x.isCovering, false)),
				MetaAttributeBooleanFunction[Uml, UMLGeneralizationSet[Uml]](None, "isDisjoint", (x) => booleanToIterable(x.isDisjoint, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		generalizationSet_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			packageableElement_compositeMetaProperties,
			Seq ())

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		generalizationSet_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			packageableElement_referenceMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLGeneralizationSet[Uml], UMLGeneralization[Uml]]("generalization", _.generalization),
				MetaPropertyReference[Uml, UMLGeneralizationSet[Uml], UMLClassifier[Uml]]("powertype", _.powertype)))

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		generalizationSet_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLGeneralizationSet
	 */
	def generalizationSet_forwardReferencesFromMetamodelAssociations: Elements =
		packageableElement_forwardReferencesFromMetamodelAssociations ++
		generalization ++
		powertype 

} //UMLGeneralizationSet
