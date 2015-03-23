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
 * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.

 * <!-- end-model-doc -->
 */
trait UMLClass[Uml <: UML]
	extends UMLBehavioredClassifier[Uml]
	with UMLEncapsulatedClassifier[Uml]
	with UMLClassOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * This property is used when the Class is acting as a metaclass. It references the Extensions that specify additional properties of the metaclass. The property is derived from the Extensions whose memberEnds are typed by the Class.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtension.metaclass
	 */
	def extension: Set[UMLExtension[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * If true, the Class does not provide a complete declaration and cannot be instantiated. An abstract Class is typically used as a target of Associations or Generalizations.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	override def isAbstract: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * Determines whether an object specified by this Class is active or not. If true, then the owning Class is referred to as an active Class. If false, then such a Class is referred to as a passive Class.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 */
	def isActive: Boolean

	/**
	 * <!-- begin-model-doc -->
	 * The Classifiers owned by the Class that are not ownedBehaviors.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClassifier.nestedClassifier_nestingClass
	 */
	def nestedClassifier: Seq[UMLClassifier[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The attributes (i.e., the Properties) owned by the Class.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProperty._class
	 */
	override def ownedAttribute: Seq[UMLProperty[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Operations owned by the Class.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLOperation._class
	 */
	def ownedOperation: Seq[UMLOperation[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The Receptions owned by the Class.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLReception.ownedReception_class
	 */
	def ownedReception: Set[UMLReception[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The superclasses of a Class, derived from its Generalizations.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClass.superClass_class
	 */
	def superClass: Set[UMLClass[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLClass.superClass
	 */
	def superClass_class: Set[UMLClass[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		class_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLClass
	 */
	def class_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			behavioredClassifier_metaAttributes,
			encapsulatedClassifier_metaAttributes,
			Seq (MetaAttributeBooleanFunction[Uml, UMLClass[Uml]](None, "isAbstract", (x) => booleanToIterable(x.isAbstract, false)),
				MetaAttributeBooleanFunction[Uml, UMLClass[Uml]](None, "isActive", (x) => booleanToIterable(x.isActive, false))))

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		class_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLClass
	 */
	def class_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioredClassifier_compositeMetaProperties,
			encapsulatedClassifier_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLClass[Uml], UMLClassifier[Uml]]("nestedClassifier", _.nestedClassifier),
				MetaPropertyCollection[Uml, UMLClass[Uml], UMLProperty[Uml]]("ownedAttribute", _.ownedAttribute),
				MetaPropertyCollection[Uml, UMLClass[Uml], UMLOperation[Uml]]("ownedOperation", _.ownedOperation),
				MetaPropertyCollection[Uml, UMLClass[Uml], UMLReception[Uml]]("ownedReception", _.ownedReception)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		class_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLClass
	 */
	def class_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			behavioredClassifier_referenceMetaProperties,
			encapsulatedClassifier_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		class_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLClass
	 */
	def class_forwardReferencesFromMetamodelAssociations: Elements =
		behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
		encapsulatedClassifier_forwardReferencesFromMetamodelAssociations ++
		Set () 

} //UMLClass
