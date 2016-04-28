/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
import org.omg.oti.uml.read.operations.UMLStructuredActivityNodeOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A StructuredActivityNode is an Action that is also an ActivityGroup and whose behavior is specified by the ActivityNodes and ActivityEdges it so contains. Unlike other kinds of ActivityGroup, a StructuredActivityNode owns the ActivityNodes and ActivityEdges it contains, and so a node or edge can only be directly contained in one StructuredActivityNode, though StructuredActivityNodes may be nested.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStructuredActivityNode[Uml <: UML]
  extends UMLAction[Uml]
	with UMLActivityGroup[Uml]
	with UMLNamespace[Uml]
  with UMLStructuredActivityNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If true, then any object used by an Action within the StructuredActivityNode cannot be accessed by any Action outside the node until the StructuredActivityNode as a whole completes. Any concurrent Actions that would result in accessing such objects are required to have their execution deferred until the completion of the StructuredActivityNode.
    *
    * <!-- Start of user code doc for mustIsolate -->
    * <!-- End of user code doc for mustIsolate -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def mustIsolate: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      structuredActivityNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStructuredActivityNode
    *
    * <!-- Start of user code doc for structuredActivityNode_metaAttributes -->
    * <!-- End of user code doc for structuredActivityNode_metaAttributes -->
    */
  def structuredActivityNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     activityGroup_metaAttributes,
     namespace_metaAttributes,
     Seq[MetaAttributeFunction](StructuredActivityNode_mustIsolate))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    structuredActivityNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStructuredActivityNode
    *
    * <!-- Start of user code doc for structuredActivityNode_compositeMetaProperties -->
    * <!-- End of user code doc for structuredActivityNode_compositeMetaProperties -->
    */
  def structuredActivityNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      activityGroup_compositeMetaProperties,
      namespace_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](StructuredActivityNode_edge,
      	StructuredActivityNode_node,
      	StructuredActivityNode_structuredNodeInput,
      	StructuredActivityNode_structuredNodeOutput,
      	StructuredActivityNode_variable))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    structuredActivityNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStructuredActivityNode
    *
    * <!-- Start of user code doc for structuredActivityNode_referenceMetaProperties -->
    * <!-- End of user code doc for structuredActivityNode_referenceMetaProperties -->
    */
  def structuredActivityNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      activityGroup_referenceMetaProperties,
      namespace_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    structuredActivityNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStructuredActivityNode
    *
    * <!-- Start of user code doc for structuredActivityNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for structuredActivityNode_forwardReferencesFromMetamodelAssociations -->
    */
  def structuredActivityNode_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    activityGroup_forwardReferencesFromMetamodelAssociations ++
    namespace_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLStructuredActivityNode