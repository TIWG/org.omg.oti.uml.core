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
import org.omg.oti.uml.read.operations.UMLVariableOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Variable is a ConnectableElement that may store values during the execution of an Activity. Reading and writing the values of a Variable provides an alternative means for passing data than the use of ObjectFlows. A Variable may be owned directly by an Activity, in which case it is accessible from anywhere within that activity, or it may be owned by a StructuredActivityNode, in which case it is only accessible within that node.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLVariable[Uml <: UML]
  extends UMLConnectableElement[Uml]
	with UMLMultiplicityElement[Uml]
  with UMLVariableOps[Uml] {

  // Start of user code for class imports
  // End of user code

  /**
    * <!-- Start of user code doc for variable_variableAction -->
    * <!-- End of user code doc for variable_variableAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLVariableAction.variable
    */
  def variable_variableAction: Set[UMLVariableAction[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      variable_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLVariable
    *
    * <!-- Start of user code doc for variable_metaAttributes -->
    * <!-- End of user code doc for variable_metaAttributes -->
    */
  def variable_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     connectableElement_metaAttributes,
     multiplicityElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    variable_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLVariable
    *
    * <!-- Start of user code doc for variable_compositeMetaProperties -->
    * <!-- End of user code doc for variable_compositeMetaProperties -->
    */
  def variable_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      connectableElement_compositeMetaProperties,
      multiplicityElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    variable_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLVariable
    *
    * <!-- Start of user code doc for variable_referenceMetaProperties -->
    * <!-- End of user code doc for variable_referenceMetaProperties -->
    */
  def variable_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      connectableElement_referenceMetaProperties,
      multiplicityElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    variable_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLVariable
    *
    * <!-- Start of user code doc for variable_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for variable_forwardReferencesFromMetamodelAssociations -->
    */
  def variable_forwardReferencesFromMetamodelAssociations: Elements =
    connectableElement_forwardReferencesFromMetamodelAssociations ++
    multiplicityElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLVariable
