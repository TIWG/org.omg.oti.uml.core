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
import org.omg.oti.uml.read.operations.UMLProfileApplicationOps

import scala.Boolean
import scala.collection.immutable.Seq
// End of user code


/**
  * A profile application is used to show which profiles have been applied to a package.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProfileApplication[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
  with UMLProfileApplicationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies that the Profile filtering rules for the metaclasses of the referenced metamodel shall be strictly applied.
    *
    * <!-- Start of user code doc for isStrict -->
    * <!-- End of user code doc for isStrict -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isStrict: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      profileApplication_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLProfileApplication
    *
    * <!-- Start of user code doc for profileApplication_metaAttributes -->
    * <!-- End of user code doc for profileApplication_metaAttributes -->
    */
  def profileApplication_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     Seq[MetaAttributeFunction](ProfileApplication_isStrict))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    profileApplication_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLProfileApplication
    *
    * <!-- Start of user code doc for profileApplication_compositeMetaProperties -->
    * <!-- End of user code doc for profileApplication_compositeMetaProperties -->
    */
  def profileApplication_compositeMetaProperties: MetaPropertyFunctions = 
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
    profileApplication_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLProfileApplication
    *
    * <!-- Start of user code doc for profileApplication_referenceMetaProperties -->
    * <!-- End of user code doc for profileApplication_referenceMetaProperties -->
    */
  def profileApplication_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ProfileApplication_appliedProfile))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    profileApplication_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLProfileApplication
    *
    * <!-- Start of user code doc for profileApplication_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for profileApplication_forwardReferencesFromMetamodelAssociations -->
    */
  def profileApplication_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    appliedProfile

  // Start of user code for additional features
  // End of user code
} //UMLProfileApplication
