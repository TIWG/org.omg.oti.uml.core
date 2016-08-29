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
import org.omg.oti.uml.read.operations.UMLPackageableElementOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A PackageableElement is a NamedElement that may be owned directly by a Package. A PackageableElement is also able to serve as the parameteredElement of a TemplateParameter.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageableElement[Uml <: UML]
  extends UMLNamedElement[Uml]
	with UMLParameterableElement[Uml]
  with UMLPackageableElementOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * A PackageableElement must have a visibility specified if it is owned by a Namespace. The default visibility is public.
    *
    * <!-- Start of user code doc for visibility -->
    * <!-- End of user code doc for visibility -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  override def visibility: Option[UMLVisibilityKind.Value]

  /**
    * <!-- Start of user code doc for deployedElement_deploymentTarget -->
    * <!-- End of user code doc for deployedElement_deploymentTarget -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeploymentTarget.deployedElement
    */
  def deployedElement_deploymentTarget: Set[UMLDeploymentTarget[Uml]]

  /**
    * <!-- Start of user code doc for importedMember_namespace -->
    * <!-- End of user code doc for importedMember_namespace -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.importedMember
    */
  def importedMember_namespace: Set[UMLNamespace[Uml]]

  /**
    * <!-- Start of user code doc for utilizedElement_manifestation -->
    * <!-- End of user code doc for utilizedElement_manifestation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLManifestation.utilizedElement
    */
  def utilizedElement_manifestation: Set[UMLManifestation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      packageableElement_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLPackageableElement
    *
    * <!-- Start of user code doc for packageableElement_metaAttributes -->
    * <!-- End of user code doc for packageableElement_metaAttributes -->
    */
  def packageableElement_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     parameterableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    packageableElement_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLPackageableElement
    *
    * <!-- Start of user code doc for packageableElement_compositeMetaProperties -->
    * <!-- End of user code doc for packageableElement_compositeMetaProperties -->
    */
  def packageableElement_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      parameterableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    packageableElement_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLPackageableElement
    *
    * <!-- Start of user code doc for packageableElement_referenceMetaProperties -->
    * <!-- End of user code doc for packageableElement_referenceMetaProperties -->
    */
  def packageableElement_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      parameterableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLPackageableElement
    *
    * <!-- Start of user code doc for packageableElement_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for packageableElement_forwardReferencesFromMetamodelAssociations -->
    */
  def packageableElement_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    parameterableElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLPackageableElement
