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
import org.omg.oti.uml.read.operations.UMLPackageMergeOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A package merge defines how the contents of one package are extended by the contents of another package.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageMerge[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
  with UMLPackageMergeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      packageMerge_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLPackageMerge
    *
    * <!-- Start of user code doc for packageMerge_metaAttributes -->
    * <!-- End of user code doc for packageMerge_metaAttributes -->
    */
  def packageMerge_metaAttributes: MetaAttributeFunctions = 
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
    packageMerge_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLPackageMerge
    *
    * <!-- Start of user code doc for packageMerge_compositeMetaProperties -->
    * <!-- End of user code doc for packageMerge_compositeMetaProperties -->
    */
  def packageMerge_compositeMetaProperties: MetaPropertyFunctions = 
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
    packageMerge_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLPackageMerge
    *
    * <!-- Start of user code doc for packageMerge_referenceMetaProperties -->
    * <!-- End of user code doc for packageMerge_referenceMetaProperties -->
    */
  def packageMerge_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](PackageMerge_mergedPackage))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    packageMerge_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLPackageMerge
    *
    * <!-- Start of user code doc for packageMerge_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for packageMerge_forwardReferencesFromMetamodelAssociations -->
    */
  def packageMerge_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    mergedPackage

  // Start of user code for additional features
  // End of user code
} //UMLPackageMerge
