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
import org.omg.oti.uml.read.operations.UMLGeneralizationOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Generalization is a taxonomic relationship between a more general Classifier and a more specific Classifier. Each instance of the specific Classifier is also an instance of the general Classifier. The specific Classifier inherits the features of the more general Classifier. A Generalization is owned by the specific Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGeneralization[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
  with UMLGeneralizationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Represents a set of instances of Generalization.  A Generalization may appear in many GeneralizationSets.
    *
    * <!-- Start of user code doc for generalizationSet -->
    * <!-- End of user code doc for generalizationSet -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralizationSet.generalization
    */
  def generalizationSet: Set[UMLGeneralizationSet[Uml]]

  /**
    * Indicates whether the specific Classifier can be used wherever the general Classifier can be used. If true, the execution traces of the specific Classifier shall be a superset of the execution traces of the general Classifier. If false, there is no such constraint on execution traces. If unset, the modeler has not stated whether there is such a constraint or not.
    *
    * <!-- Start of user code doc for isSubstitutable -->
    * <!-- End of user code doc for isSubstitutable -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def isSubstitutable: Option[Boolean]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      generalization_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLGeneralization
    *
    * <!-- Start of user code doc for generalization_metaAttributes -->
    * <!-- End of user code doc for generalization_metaAttributes -->
    */
  def generalization_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     Seq[MetaAttributeFunction](Generalization_isSubstitutable))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    generalization_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLGeneralization
    *
    * <!-- Start of user code doc for generalization_compositeMetaProperties -->
    * <!-- End of user code doc for generalization_compositeMetaProperties -->
    */
  def generalization_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    generalization_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLGeneralization
    *
    * <!-- Start of user code doc for generalization_referenceMetaProperties -->
    * <!-- End of user code doc for generalization_referenceMetaProperties -->
    */
  def generalization_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Generalization_general,
      	Generalization_generalizationSet))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    generalization_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLGeneralization
    *
    * <!-- Start of user code doc for generalization_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for generalization_forwardReferencesFromMetamodelAssociations -->
    */
  def generalization_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    general ++
    generalizationSet

  // Start of user code for additional features
  // End of user code
} //UMLGeneralization
