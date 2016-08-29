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
import org.omg.oti.uml.read.operations.UMLSequenceNodeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A SequenceNode is a StructuredActivityNode that executes a sequence of ExecutableNodes in order.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSequenceNode[Uml <: UML]
  extends UMLStructuredActivityNode[Uml]
  with UMLSequenceNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ordered set of ExecutableNodes to be sequenced.
    *
    * <!-- Start of user code doc for executableNode -->
    * <!-- End of user code doc for executableNode -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.executableNode_sequenceNode
    */
  def executableNode: Seq[UMLExecutableNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      sequenceNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLSequenceNode
    *
    * <!-- Start of user code doc for sequenceNode_metaAttributes -->
    * <!-- End of user code doc for sequenceNode_metaAttributes -->
    */
  def sequenceNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     structuredActivityNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    sequenceNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLSequenceNode
    *
    * <!-- Start of user code doc for sequenceNode_compositeMetaProperties -->
    * <!-- End of user code doc for sequenceNode_compositeMetaProperties -->
    */
  def sequenceNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuredActivityNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](SequenceNode_executableNode))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    sequenceNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLSequenceNode
    *
    * <!-- Start of user code doc for sequenceNode_referenceMetaProperties -->
    * <!-- End of user code doc for sequenceNode_referenceMetaProperties -->
    */
  def sequenceNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      structuredActivityNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    sequenceNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLSequenceNode
    *
    * <!-- Start of user code doc for sequenceNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for sequenceNode_forwardReferencesFromMetamodelAssociations -->
    */
  def sequenceNode_forwardReferencesFromMetamodelAssociations: Elements =
    structuredActivityNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLSequenceNode
