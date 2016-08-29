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
import org.omg.oti.uml.read.operations.UMLProfileOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A profile defines limited extensions to a reference metamodel with the purpose of adapting the metamodel to a specific platform or domain.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProfile[Uml <: UML]
  extends UMLPackage[Uml]
  with UMLProfileOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References a metaclass that may be extended.
    *
    * <!-- Start of user code doc for metaclassReference -->
    * <!-- End of user code doc for metaclassReference -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElementImport.metaclassReference_profile
    */
  def metaclassReference: Set[UMLElementImport[Uml]]

  /**
    * References a package containing (directly or indirectly) metaclasses that may be extended.
    *
    * <!-- Start of user code doc for metamodelReference -->
    * <!-- End of user code doc for metamodelReference -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageImport.metamodelReference_profile
    */
  def metamodelReference: Set[UMLPackageImport[Uml]]

  /**
    * <!-- Start of user code doc for profile_stereotype -->
    * <!-- End of user code doc for profile_stereotype -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStereotype.profile
    */
  def profile_stereotype: Set[UMLStereotype[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      profile_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLProfile
    *
    * <!-- Start of user code doc for profile_metaAttributes -->
    * <!-- End of user code doc for profile_metaAttributes -->
    */
  def profile_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     package_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    profile_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLProfile
    *
    * <!-- Start of user code doc for profile_compositeMetaProperties -->
    * <!-- End of user code doc for profile_compositeMetaProperties -->
    */
  def profile_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      package_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Profile_metaclassReference,
      	Profile_metamodelReference))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    profile_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLProfile
    *
    * <!-- Start of user code doc for profile_referenceMetaProperties -->
    * <!-- End of user code doc for profile_referenceMetaProperties -->
    */
  def profile_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      package_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    profile_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLProfile
    *
    * <!-- Start of user code doc for profile_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for profile_forwardReferencesFromMetamodelAssociations -->
    */
  def profile_forwardReferencesFromMetamodelAssociations: Elements =
    package_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLProfile
