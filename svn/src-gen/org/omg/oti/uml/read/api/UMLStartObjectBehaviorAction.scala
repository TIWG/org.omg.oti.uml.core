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
import org.omg.oti.uml.read.operations.UMLStartObjectBehaviorActionOps

import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A StartObjectBehaviorAction is an InvocationAction that starts the execution either of a directly instantiated Behavior or of the classifierBehavior of an object. Argument values may be supplied for the input Parameters of the Behavior. If the Behavior is invoked synchronously, then output values may be obtained for output Parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStartObjectBehaviorAction[Uml <: UML]
  extends UMLCallAction[Uml]
  with UMLStartObjectBehaviorActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * An InputPin that holds the object that is either a Behavior to be started or has a classifierBehavior to be started.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_startObjectBehaviorAction
    */
  def _object: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      startObjectBehaviorAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLStartObjectBehaviorAction
    *
    * <!-- Start of user code doc for startObjectBehaviorAction_metaAttributes -->
    * <!-- End of user code doc for startObjectBehaviorAction_metaAttributes -->
    */
  def startObjectBehaviorAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     callAction_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    startObjectBehaviorAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLStartObjectBehaviorAction
    *
    * <!-- Start of user code doc for startObjectBehaviorAction_compositeMetaProperties -->
    * <!-- End of user code doc for startObjectBehaviorAction_compositeMetaProperties -->
    */
  def startObjectBehaviorAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      callAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](StartObjectBehaviorAction_object))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    startObjectBehaviorAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLStartObjectBehaviorAction
    *
    * <!-- Start of user code doc for startObjectBehaviorAction_referenceMetaProperties -->
    * <!-- End of user code doc for startObjectBehaviorAction_referenceMetaProperties -->
    */
  def startObjectBehaviorAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      callAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLStartObjectBehaviorAction
    *
    * <!-- Start of user code doc for startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations -->
    */
  def startObjectBehaviorAction_forwardReferencesFromMetamodelAssociations: Elements =
    callAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLStartObjectBehaviorAction
