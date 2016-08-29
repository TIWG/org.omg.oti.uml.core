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
import org.omg.oti.uml.read.operations.UMLPackageImportOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A PackageImport is a Relationship that imports all the non-private members of a Package into the Namespace owning the PackageImport, so that those Elements may be referred to by their unqualified names in the importingNamespace.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageImport[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
  with UMLPackageImportOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the visibility of the imported PackageableElements within the importingNamespace, i.e., whether imported Elements will in turn be visible to other Namespaces. If the PackageImport is public, the imported Elements will be visible outside the importingNamespace, while, if the PackageImport is private, they will not.
    *
    * <!-- Start of user code doc for visibility -->
    * <!-- End of user code doc for visibility -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def visibility: Option[UMLVisibilityKind.Value]

  /**
    * <!-- Start of user code doc for metamodelReference_profile -->
    * <!-- End of user code doc for metamodelReference_profile -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProfile.metamodelReference
    */
  def metamodelReference_profile: Option[UMLProfile[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      packageImport_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLPackageImport
    *
    * <!-- Start of user code doc for packageImport_metaAttributes -->
    * <!-- End of user code doc for packageImport_metaAttributes -->
    */
  def packageImport_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    packageImport_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLPackageImport
    *
    * <!-- Start of user code doc for packageImport_compositeMetaProperties -->
    * <!-- End of user code doc for packageImport_compositeMetaProperties -->
    */
  def packageImport_compositeMetaProperties: MetaPropertyFunctions = 
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
    packageImport_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLPackageImport
    *
    * <!-- Start of user code doc for packageImport_referenceMetaProperties -->
    * <!-- End of user code doc for packageImport_referenceMetaProperties -->
    */
  def packageImport_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](PackageImport_importedPackage))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    packageImport_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLPackageImport
    *
    * <!-- Start of user code doc for packageImport_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for packageImport_forwardReferencesFromMetamodelAssociations -->
    */
  def packageImport_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    importedPackage

  // Start of user code for additional features
  // End of user code
} //UMLPackageImport
