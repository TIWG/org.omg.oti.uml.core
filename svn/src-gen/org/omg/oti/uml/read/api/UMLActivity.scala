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
import org.omg.oti.uml.read.operations.UMLActivityOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Activity is the specification of parameterized Behavior as the coordinated sequencing of subordinate units.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLActivity[Uml <: UML]
  extends UMLBehavior[Uml]
  with UMLActivityOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * If true, this Activity must not make any changes to objects. The default is false (an Activity may make nonlocal changes). (This is an assertion, not an executable property. It may be used by an execution engine to optimize model execution. If the assertion is violated by the Activity, then the model is ill-formed.) 
    *
    * <!-- Start of user code doc for isReadOnly -->
    * <!-- End of user code doc for isReadOnly -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isReadOnly: Boolean

  /**
    * If true, all invocations of the Activity are handled by the same execution.
    *
    * <!-- Start of user code doc for isSingleExecution -->
    * <!-- End of user code doc for isSingleExecution -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isSingleExecution: Boolean

  /**
    * Top-level ActivityPartitions in the Activity.
    *
    * <!-- Start of user code doc for partition -->
    * <!-- End of user code doc for partition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityPartition.partition_activity
    */
  def partition: Set[UMLActivityPartition[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      activity_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLActivity
    *
    * <!-- Start of user code doc for activity_metaAttributes -->
    * <!-- End of user code doc for activity_metaAttributes -->
    */
  def activity_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavior_metaAttributes,
     Seq[MetaAttributeFunction](Activity_isReadOnly,
     	Activity_isSingleExecution))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    activity_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLActivity
    *
    * <!-- Start of user code doc for activity_compositeMetaProperties -->
    * <!-- End of user code doc for activity_compositeMetaProperties -->
    */
  def activity_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Activity_edge,
      	Activity_group,
      	Activity_node,
      	Activity_structuredNode,
      	Activity_variable))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    activity_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLActivity
    *
    * <!-- Start of user code doc for activity_referenceMetaProperties -->
    * <!-- End of user code doc for activity_referenceMetaProperties -->
    */
  def activity_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavior_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Activity_partition))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    activity_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLActivity
    *
    * <!-- Start of user code doc for activity_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for activity_forwardReferencesFromMetamodelAssociations -->
    */
  def activity_forwardReferencesFromMetamodelAssociations: Elements =
    behavior_forwardReferencesFromMetamodelAssociations ++
    partition

  // Start of user code for additional features
  // End of user code
} //UMLActivity
