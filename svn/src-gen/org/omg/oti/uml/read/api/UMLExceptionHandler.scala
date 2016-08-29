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
import org.omg.oti.uml.read.operations.UMLExceptionHandlerOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An ExceptionHandler is an Element that specifies a handlerBody ExecutableNode to execute in case the specified exception occurs during the execution of the protected ExecutableNode.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLExceptionHandler[Uml <: UML]
  extends UMLElement[Uml]
  with UMLExceptionHandlerOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * An ObjectNode within the handlerBody. When the ExceptionHandler catches an exception, the exception token is placed on this ObjectNode, causing the handlerBody to execute.
    *
    * <!-- Start of user code doc for exceptionInput -->
    * <!-- End of user code doc for exceptionInput -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLObjectNode.exceptionInput_exceptionHandler
    */
  def exceptionInput: Option[UMLObjectNode[Uml]]

  /**
    * The Classifiers whose instances the ExceptionHandler catches as exceptions. If an exception occurs whose type is any exceptionType, the ExceptionHandler catches the exception and executes the handlerBody.
    *
    * <!-- Start of user code doc for exceptionType -->
    * <!-- End of user code doc for exceptionType -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.exceptionType_exceptionHandler
    */
  def exceptionType: Set[UMLClassifier[Uml]]

  /**
    * An ExecutableNode that is executed if the ExceptionHandler catches an exception.
    *
    * <!-- Start of user code doc for handlerBody -->
    * <!-- End of user code doc for handlerBody -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExecutableNode.handlerBody_exceptionHandler
    */
  def handlerBody: Option[UMLExecutableNode[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      exceptionHandler_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLExceptionHandler
    *
    * <!-- Start of user code doc for exceptionHandler_metaAttributes -->
    * <!-- End of user code doc for exceptionHandler_metaAttributes -->
    */
  def exceptionHandler_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    exceptionHandler_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLExceptionHandler
    *
    * <!-- Start of user code doc for exceptionHandler_compositeMetaProperties -->
    * <!-- End of user code doc for exceptionHandler_compositeMetaProperties -->
    */
  def exceptionHandler_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    exceptionHandler_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLExceptionHandler
    *
    * <!-- Start of user code doc for exceptionHandler_referenceMetaProperties -->
    * <!-- End of user code doc for exceptionHandler_referenceMetaProperties -->
    */
  def exceptionHandler_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ExceptionHandler_exceptionInput,
      	ExceptionHandler_exceptionType,
      	ExceptionHandler_handlerBody))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    exceptionHandler_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLExceptionHandler
    *
    * <!-- Start of user code doc for exceptionHandler_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for exceptionHandler_forwardReferencesFromMetamodelAssociations -->
    */
  def exceptionHandler_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    exceptionInput ++
    exceptionType ++
    handlerBody

  // Start of user code for additional features
  // End of user code
} //UMLExceptionHandler
