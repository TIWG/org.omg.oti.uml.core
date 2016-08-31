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
import org.omg.oti.uml.read.operations.UMLElementImportOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Seq
// End of user code


/**
  * An ElementImport identifies a NamedElement in a Namespace other than the one that owns that NamedElement and allows the NamedElement to be referenced using an unqualified name in the Namespace owning the ElementImport.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLElementImport[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
  with UMLElementImportOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies the name that should be added to the importing Namespace in lieu of the name of the imported PackagableElement. The alias must not clash with any other member in the importing Namespace. By default, no alias is used.
    *
    * <!-- Start of user code doc for alias -->
    * <!-- End of user code doc for alias -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def alias: Option[String]

  /**
    * Specifies the visibility of the imported PackageableElement within the importingNamespace, i.e., whether the  importedElement will in turn be visible to other Namespaces. If the ElementImport is public, the importedElement will be visible outside the importingNamespace while, if the ElementImport is private, it will not.
    *
    * <!-- Start of user code doc for visibility -->
    * <!-- End of user code doc for visibility -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def visibility: Option[UMLVisibilityKind.Value]

  /**
    * <!-- Start of user code doc for metaclassReference_profile -->
    * <!-- End of user code doc for metaclassReference_profile -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProfile.metaclassReference
    */
  def metaclassReference_profile: Option[UMLProfile[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      elementImport_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLElementImport
    *
    * <!-- Start of user code doc for elementImport_metaAttributes -->
    * <!-- End of user code doc for elementImport_metaAttributes -->
    */
  def elementImport_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     Seq[MetaAttributeFunction](ElementImport_alias))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    elementImport_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLElementImport
    *
    * <!-- Start of user code doc for elementImport_compositeMetaProperties -->
    * <!-- End of user code doc for elementImport_compositeMetaProperties -->
    */
  def elementImport_compositeMetaProperties: MetaPropertyFunctions = 
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
    elementImport_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLElementImport
    *
    * <!-- Start of user code doc for elementImport_referenceMetaProperties -->
    * <!-- End of user code doc for elementImport_referenceMetaProperties -->
    */
  def elementImport_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ElementImport_importedElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    elementImport_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLElementImport
    *
    * <!-- Start of user code doc for elementImport_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for elementImport_forwardReferencesFromMetamodelAssociations -->
    */
  def elementImport_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    importedElement

  // Start of user code for additional features
  // End of user code
} //UMLElementImport
