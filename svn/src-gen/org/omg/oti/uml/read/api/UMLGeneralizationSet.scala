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
import org.omg.oti.uml.read.operations.UMLGeneralizationSetOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A GeneralizationSet is a PackageableElement whose instances represent sets of Generalization relationships.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGeneralizationSet[Uml <: UML]
  extends UMLPackageableElement[Uml]
  with UMLGeneralizationSetOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Designates the instances of Generalization that are members of this GeneralizationSet.
    *
    * <!-- Start of user code doc for generalization -->
    * <!-- End of user code doc for generalization -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLGeneralization.generalizationSet
    */
  def generalization: Set[UMLGeneralization[Uml]]

  /**
    * Indicates (via the associated Generalizations) whether or not the set of specific Classifiers are covering for a particular general classifier. When isCovering is true, every instance of a particular general Classifier is also an instance of at least one of its specific Classifiers for the GeneralizationSet. When isCovering is false, there are one or more instances of the particular general Classifier that are not instances of at least one of its specific Classifiers defined for the GeneralizationSet.
    *
    * <!-- Start of user code doc for isCovering -->
    * <!-- End of user code doc for isCovering -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isCovering: Boolean

  /**
    * Indicates whether or not the set of specific Classifiers in a Generalization relationship have instance in common. If isDisjoint is true, the specific Classifiers for a particular GeneralizationSet have no members in common; that is, their intersection is empty. If isDisjoint is false, the specific Classifiers in a particular GeneralizationSet have one or more members in common; that is, their intersection is not empty.
    *
    * <!-- Start of user code doc for isDisjoint -->
    * <!-- End of user code doc for isDisjoint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDisjoint: Boolean

  /**
    * Designates the Classifier that is defined as the power type for the associated GeneralizationSet, if there is one.
    *
    * <!-- Start of user code doc for powertype -->
    * <!-- End of user code doc for powertype -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.powertypeExtent
    */
  def powertype: Option[UMLClassifier[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      generalizationSet_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLGeneralizationSet
    *
    * <!-- Start of user code doc for generalizationSet_metaAttributes -->
    * <!-- End of user code doc for generalizationSet_metaAttributes -->
    */
  def generalizationSet_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction](GeneralizationSet_isCovering,
     	GeneralizationSet_isDisjoint))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    generalizationSet_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLGeneralizationSet
    *
    * <!-- Start of user code doc for generalizationSet_compositeMetaProperties -->
    * <!-- End of user code doc for generalizationSet_compositeMetaProperties -->
    */
  def generalizationSet_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    generalizationSet_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLGeneralizationSet
    *
    * <!-- Start of user code doc for generalizationSet_referenceMetaProperties -->
    * <!-- End of user code doc for generalizationSet_referenceMetaProperties -->
    */
  def generalizationSet_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](GeneralizationSet_generalization,
      	GeneralizationSet_powertype))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    generalizationSet_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLGeneralizationSet
    *
    * <!-- Start of user code doc for generalizationSet_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for generalizationSet_forwardReferencesFromMetamodelAssociations -->
    */
  def generalizationSet_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    generalization ++
    powertype

  // Start of user code for additional features
  // End of user code
} //UMLGeneralizationSet
