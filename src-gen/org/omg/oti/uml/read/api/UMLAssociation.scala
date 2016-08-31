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
import org.omg.oti.uml.read.operations.UMLAssociationOps

import scala.Boolean
import scala.Option
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A link is a tuple of values that refer to typed objects.  An Association classifies a set of links, each of which is an instance of the Association.  Each value in the link refers to an instance of the type of the corresponding end of the Association.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAssociation[Uml <: UML]
  extends UMLClassifier[Uml]
	with UMLRelationship[Uml]
  with UMLAssociationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies whether the Association is derived from other model elements such as other Associations.
    *
    * <!-- Start of user code doc for isDerived -->
    * <!-- End of user code doc for isDerived -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isDerived: Boolean

  /**
    * Each end represents participation of instances of the Classifier connected to the end in links of the Association.
    *
    * <!-- Start of user code doc for memberEnd -->
    * <!-- End of user code doc for memberEnd -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="2..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.association
    */
  def memberEnd: Seq[UMLProperty[Uml]]

  /**
    * The navigable ends that are owned by the Association itself.
    *
    * <!-- Start of user code doc for navigableOwnedEnd -->
    * <!-- End of user code doc for navigableOwnedEnd -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.navigableOwnedEnd_association
    */
  def navigableOwnedEnd: Set[UMLProperty[Uml]]

  /**
    * The ends that are owned by the Association itself.
    *
    * <!-- Start of user code doc for ownedEnd -->
    * <!-- End of user code doc for ownedEnd -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.owningAssociation
    */
  def ownedEnd: Iterable[UMLProperty[Uml]]

  /**
    * <!-- Start of user code doc for association_clearAssociationAction -->
    * <!-- End of user code doc for association_clearAssociationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClearAssociationAction.association
    */
  def association_clearAssociationAction: Option[UMLClearAssociationAction[Uml]]

  /**
    * <!-- Start of user code doc for type_connector -->
    * <!-- End of user code doc for type_connector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector._type
    */
  def type_connector: Set[UMLConnector[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      association_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAssociation
    *
    * <!-- Start of user code doc for association_metaAttributes -->
    * <!-- End of user code doc for association_metaAttributes -->
    */
  def association_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     classifier_metaAttributes,
     relationship_metaAttributes,
     Seq[MetaAttributeFunction](Association_isDerived))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    association_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAssociation
    *
    * <!-- Start of user code doc for association_compositeMetaProperties -->
    * <!-- End of user code doc for association_compositeMetaProperties -->
    */
  def association_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      relationship_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Association_ownedEnd))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    association_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAssociation
    *
    * <!-- Start of user code doc for association_referenceMetaProperties -->
    * <!-- End of user code doc for association_referenceMetaProperties -->
    */
  def association_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      relationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Association_memberEnd,
      	Association_navigableOwnedEnd))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    association_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAssociation
    *
    * <!-- Start of user code doc for association_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for association_forwardReferencesFromMetamodelAssociations -->
    */
  def association_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    relationship_forwardReferencesFromMetamodelAssociations ++
    memberEnd ++
    navigableOwnedEnd

  // Start of user code for additional features
  // End of user code
} //UMLAssociation
