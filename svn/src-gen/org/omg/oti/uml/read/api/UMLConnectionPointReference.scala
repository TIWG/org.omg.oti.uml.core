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
import org.omg.oti.uml.read.operations.UMLConnectionPointReferenceOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectionPointReference[Uml <: UML]
  extends UMLVertex[Uml]
  with UMLConnectionPointReferenceOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The entryPoint Pseudostates corresponding to this connection point.
    *
    * <!-- Start of user code doc for entry -->
    * <!-- End of user code doc for entry -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPseudostate.entry_connectionPointReference
    */
  def entry: Set[UMLPseudostate[Uml]]

  /**
    * The exitPoints kind Pseudostates corresponding to this connection point.
    *
    * <!-- Start of user code doc for exit -->
    * <!-- End of user code doc for exit -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPseudostate.exit_connectionPointReference
    */
  def exit: Set[UMLPseudostate[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      connectionPointReference_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConnectionPointReference
    *
    * <!-- Start of user code doc for connectionPointReference_metaAttributes -->
    * <!-- End of user code doc for connectionPointReference_metaAttributes -->
    */
  def connectionPointReference_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     vertex_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    connectionPointReference_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConnectionPointReference
    *
    * <!-- Start of user code doc for connectionPointReference_compositeMetaProperties -->
    * <!-- End of user code doc for connectionPointReference_compositeMetaProperties -->
    */
  def connectionPointReference_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      vertex_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    connectionPointReference_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConnectionPointReference
    *
    * <!-- Start of user code doc for connectionPointReference_referenceMetaProperties -->
    * <!-- End of user code doc for connectionPointReference_referenceMetaProperties -->
    */
  def connectionPointReference_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      vertex_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](ConnectionPointReference_entry,
      	ConnectionPointReference_exit))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    connectionPointReference_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConnectionPointReference
    *
    * <!-- Start of user code doc for connectionPointReference_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for connectionPointReference_forwardReferencesFromMetamodelAssociations -->
    */
  def connectionPointReference_forwardReferencesFromMetamodelAssociations: Elements =
    vertex_forwardReferencesFromMetamodelAssociations ++
    entry ++
    exit

  // Start of user code for additional features
  // End of user code
} //UMLConnectionPointReference
