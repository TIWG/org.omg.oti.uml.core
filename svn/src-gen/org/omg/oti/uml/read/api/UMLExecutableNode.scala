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
import org.omg.oti.uml.read.operations.UMLExecutableNodeOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ExecutableNode is an abstract class for ActivityNodes whose execution may be controlled using ControlFlows and to which ExceptionHandlers may be attached.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExecutableNode[Uml <: UML]
  extends UMLActivityNode[Uml]
  with UMLExecutableNodeOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * <!-- Start of user code doc for bodyPart_loopNode -->
    * <!-- End of user code doc for bodyPart_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.bodyPart
    */
  def bodyPart_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for body_clause -->
    * <!-- End of user code doc for body_clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.body
    */
  def body_clause: Option[UMLClause[Uml]]

  /**
    * <!-- Start of user code doc for handlerBody_exceptionHandler -->
    * <!-- End of user code doc for handlerBody_exceptionHandler -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExceptionHandler.handlerBody
    */
  def handlerBody_exceptionHandler: Set[UMLExceptionHandler[Uml]]

  /**
    * <!-- Start of user code doc for setupPart_loopNode -->
    * <!-- End of user code doc for setupPart_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.setupPart
    */
  def setupPart_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * <!-- Start of user code doc for test_clause -->
    * <!-- End of user code doc for test_clause -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClause.test
    */
  def test_clause: Option[UMLClause[Uml]]

  /**
    * <!-- Start of user code doc for test_loopNode -->
    * <!-- End of user code doc for test_loopNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLLoopNode.test
    */
  def test_loopNode: Option[UMLLoopNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      executableNode_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_metaAttributes -->
    * <!-- End of user code doc for executableNode_metaAttributes -->
    */
  def executableNode_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     activityNode_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    executableNode_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_compositeMetaProperties -->
    * <!-- End of user code doc for executableNode_compositeMetaProperties -->
    */
  def executableNode_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityNode_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](ExecutableNode_handler))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    executableNode_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_referenceMetaProperties -->
    * <!-- End of user code doc for executableNode_referenceMetaProperties -->
    */
  def executableNode_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      activityNode_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    executableNode_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExecutableNode
    *
    * <!-- Start of user code doc for executableNode_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for executableNode_forwardReferencesFromMetamodelAssociations -->
    */
  def executableNode_forwardReferencesFromMetamodelAssociations: Elements =
    activityNode_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLExecutableNode
