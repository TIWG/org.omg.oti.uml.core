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
import org.omg.oti.uml.read.operations.UMLTestIdentityActionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A TestIdentityAction is an Action that tests if two values are identical objects.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTestIdentityAction[Uml <: UML]
  extends UMLAction[Uml]
  with UMLTestIdentityActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The InputPin on which the first input object is placed.
    *
    * <!-- Start of user code doc for first -->
    * <!-- End of user code doc for first -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.first_testIdentityAction
    */
  def first: Option[UMLInputPin[Uml]]

  /**
    * The OutputPin on which the second input object is placed.
    *
    * <!-- Start of user code doc for second -->
    * <!-- End of user code doc for second -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.second_testIdentityAction
    */
  def second: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      testIdentityAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLTestIdentityAction
    *
    * <!-- Start of user code doc for testIdentityAction_metaAttributes -->
    * <!-- End of user code doc for testIdentityAction_metaAttributes -->
    */
  def testIdentityAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     action_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    testIdentityAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLTestIdentityAction
    *
    * <!-- Start of user code doc for testIdentityAction_compositeMetaProperties -->
    * <!-- End of user code doc for testIdentityAction_compositeMetaProperties -->
    */
  def testIdentityAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](TestIdentityAction_first,
      	TestIdentityAction_result,
      	TestIdentityAction_second))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    testIdentityAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLTestIdentityAction
    *
    * <!-- Start of user code doc for testIdentityAction_referenceMetaProperties -->
    * <!-- End of user code doc for testIdentityAction_referenceMetaProperties -->
    */
  def testIdentityAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      action_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    testIdentityAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLTestIdentityAction
    *
    * <!-- Start of user code doc for testIdentityAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for testIdentityAction_forwardReferencesFromMetamodelAssociations -->
    */
  def testIdentityAction_forwardReferencesFromMetamodelAssociations: Elements =
    action_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLTestIdentityAction
