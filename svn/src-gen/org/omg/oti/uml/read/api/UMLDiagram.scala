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
import org.omg.oti.uml.read.operations.UMLDiagramOps
import scala.collection.immutable.Seq
import scala.Option
// End of user code


/**
  * 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDiagram[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLDiagramOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * <!-- Start of user code doc for context -->
    * <!-- End of user code doc for context -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.context_diagram
    */
  def context: Option[UMLElement[Uml]]

  /**
    * <!-- Start of user code doc for ownedDiagram_diagramOwner -->
    * <!-- End of user code doc for ownedDiagram_diagramOwner -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.ownedDiagram
    */
  def ownedDiagram_diagramOwner: Option[UMLNamespace[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      diagram_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDiagram
    *
    * <!-- Start of user code doc for diagram_metaAttributes -->
    * <!-- End of user code doc for diagram_metaAttributes -->
    */
  def diagram_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    diagram_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDiagram
    *
    * <!-- Start of user code doc for diagram_compositeMetaProperties -->
    * <!-- End of user code doc for diagram_compositeMetaProperties -->
    */
  def diagram_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    diagram_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDiagram
    *
    * <!-- Start of user code doc for diagram_referenceMetaProperties -->
    * <!-- End of user code doc for diagram_referenceMetaProperties -->
    */
  def diagram_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Diagram_context))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    diagram_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDiagram
    *
    * <!-- Start of user code doc for diagram_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for diagram_forwardReferencesFromMetamodelAssociations -->
    */
  def diagram_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    context

  // Start of user code for additional features
  // End of user code
} //UMLDiagram
