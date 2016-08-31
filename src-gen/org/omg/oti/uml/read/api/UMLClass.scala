/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLClassOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClass[Uml <: UML]
  extends UMLBehavioredClassifier[Uml]
	with UMLEncapsulatedClassifier[Uml]
  with UMLClassOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If true, the Class does not provide a complete declaration and cannot be instantiated. An abstract Class is typically used as a target of Associations or Generalizations.
    *
    * <!-- Start of user code doc for isAbstract -->
    * <!-- End of user code doc for isAbstract -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  override def isAbstract: Boolean

  /**
    * Determines whether an object specified by this Class is active or not. If true, then the owning Class is referred to as an active Class. If false, then such a Class is referred to as a passive Class.
    *
    * <!-- Start of user code doc for isActive -->
    * <!-- End of user code doc for isActive -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isActive: Boolean

  /**
    * The Classifiers owned by the Class that are not ownedBehaviors.
    *
    * <!-- Start of user code doc for nestedClassifier -->
    * <!-- End of user code doc for nestedClassifier -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.nestedClassifier_nestingClass
    */
  def nestedClassifier: Seq[UMLClassifier[Uml]]

  /**
    * The attributes (i.e., the Properties) owned by the Class.
    *
    * <!-- Start of user code doc for ownedAttribute -->
    * <!-- End of user code doc for ownedAttribute -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty._class
    */
  override def ownedAttribute: Seq[UMLProperty[Uml]]

  /**
    * The Operations owned by the Class.
    *
    * <!-- Start of user code doc for ownedOperation -->
    * <!-- End of user code doc for ownedOperation -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation._class
    */
  def ownedOperation: Seq[UMLOperation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      class_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLClass
    *
    * <!-- Start of user code doc for class_metaAttributes -->
    * <!-- End of user code doc for class_metaAttributes -->
    */
  def class_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavioredClassifier_metaAttributes,
     encapsulatedClassifier_metaAttributes,
     Seq[MetaAttributeFunction](Class_isAbstract,
     	Class_isActive))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    class_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLClass
    *
    * <!-- Start of user code doc for class_compositeMetaProperties -->
    * <!-- End of user code doc for class_compositeMetaProperties -->
    */
  def class_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_compositeMetaProperties,
      encapsulatedClassifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Class_nestedClassifier,
      	Class_ownedAttribute,
      	Class_ownedOperation,
      	Class_ownedReception))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    class_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLClass
    *
    * <!-- Start of user code doc for class_referenceMetaProperties -->
    * <!-- End of user code doc for class_referenceMetaProperties -->
    */
  def class_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_referenceMetaProperties,
      encapsulatedClassifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    class_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLClass
    *
    * <!-- Start of user code doc for class_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for class_forwardReferencesFromMetamodelAssociations -->
    */
  def class_forwardReferencesFromMetamodelAssociations: Elements =
    behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
    encapsulatedClassifier_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLClass
