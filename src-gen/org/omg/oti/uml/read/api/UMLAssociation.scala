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
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.uml.read.operations.UMLAssociationOps

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

  import ops._

  /**
   * Specifies whether the Association is derived from other model elements such as other Associations.
   *
   * <!-- Start of user code doc for isDerived -->
   * <!-- End of user code doc for isDerived -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   */
  def isDerived: Boolean

  /**
   * Each end represents participation of instances of the Classifier connected to the end in links of the Association.
   *
   * <!-- Start of user code doc for memberEnd -->
   * <!-- End of user code doc for memberEnd -->
   *
   * @property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="2..*"
   * @opposite org.omg.oti.api.UMLProperty.association
   */
  def memberEnd: Seq[UMLProperty[Uml]]

  /**
   * The navigable ends that are owned by the Association itself.
   *
   * <!-- Start of user code doc for navigableOwnedEnd -->
   * <!-- End of user code doc for navigableOwnedEnd -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLProperty.navigableOwnedEnd_association
   */
  def navigableOwnedEnd: Set[UMLProperty[Uml]]

  /**
   * The ends that are owned by the Association itself.
   *
   * <!-- Start of user code doc for ownedEnd -->
   * <!-- End of user code doc for ownedEnd -->
   *
   * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLProperty.owningAssociation
   */
  def ownedEnd: Iterable[UMLProperty[Uml]]

  /**
   * <!-- Start of user code doc for association_clearAssociationAction -->
   * <!-- End of user code doc for association_clearAssociationAction -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
   * @opposite org.omg.oti.api.UMLClearAssociationAction.association
   */
  def association_clearAssociationAction: Option[UMLClearAssociationAction[Uml]]

  /**
   * <!-- Start of user code doc for type_connector -->
   * <!-- End of user code doc for type_connector -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLConnector._type
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
      Seq (Association_isDerived))

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
      Seq (Association_ownedEnd))

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
      Seq (Association_memberEnd,
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
