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
import org.omg.oti.uml.read.operations.UMLDependencyOps

import scala.collection.immutable.Seq
// End of user code


/**
  * A Dependency is a Relationship that signifies that a single model Element or a set of model Elements requires other model Elements for their specification or implementation. This means that the complete semantics of the client Element(s) are either semantically or structurally dependent on the definition of the supplier Element(s).
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDependency[Uml <: UML]
  extends UMLDirectedRelationship[Uml]
	with UMLPackageableElement[Uml]
  with UMLDependencyOps[Uml] {

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
      dependency_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDependency
    *
    * <!-- Start of user code doc for dependency_metaAttributes -->
    * <!-- End of user code doc for dependency_metaAttributes -->
    */
  def dependency_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     directedRelationship_metaAttributes,
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    dependency_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDependency
    *
    * <!-- Start of user code doc for dependency_compositeMetaProperties -->
    * <!-- End of user code doc for dependency_compositeMetaProperties -->
    */
  def dependency_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_compositeMetaProperties,
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    dependency_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDependency
    *
    * <!-- Start of user code doc for dependency_referenceMetaProperties -->
    * <!-- End of user code doc for dependency_referenceMetaProperties -->
    */
  def dependency_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      directedRelationship_referenceMetaProperties,
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Dependency_client,
      	Dependency_supplier))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    dependency_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDependency
    *
    * <!-- Start of user code doc for dependency_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for dependency_forwardReferencesFromMetamodelAssociations -->
    */
  def dependency_forwardReferencesFromMetamodelAssociations: Elements =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    client ++
    supplier

  // Start of user code for additional features
  // End of user code
} //UMLDependency
