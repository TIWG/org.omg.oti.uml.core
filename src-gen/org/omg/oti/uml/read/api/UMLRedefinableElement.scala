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
import org.omg.oti.uml.read.operations.UMLRedefinableElementOps

import scala.Boolean
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A RedefinableElement is an element that, when defined in the context of a Classifier, can be redefined more specifically or differently in the context of another Classifier that specializes (directly or indirectly) the context Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLRedefinableElement[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLRedefinableElementOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Indicates whether it is possible to further redefine a RedefinableElement. If the value is true, then it is not possible to further redefine the RedefinableElement.
    *
    * <!-- Start of user code doc for isLeaf -->
    * <!-- End of user code doc for isLeaf -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isLeaf: Boolean

  /**
    * The RedefinableElement that is being redefined by this element.
    *
    * <!-- Start of user code doc for redefinedElement -->
    * <!-- End of user code doc for redefinedElement -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRedefinableElement.redefinedElement_redefinableElement
    */
  def redefinedElement: Set[UMLRedefinableElement[Uml]]

  /**
    * The contexts that this element may be redefined from.
    *
    * <!-- Start of user code doc for redefinitionContext -->
    * <!-- End of user code doc for redefinitionContext -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.redefinitionContext_redefinableElement
    */
  def redefinitionContext: Iterable[UMLClassifier[Uml]]

  /**
    * <!-- Start of user code doc for redefinedElement_redefinableElement -->
    * <!-- End of user code doc for redefinedElement_redefinableElement -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLRedefinableElement.redefinedElement
    */
  def redefinedElement_redefinableElement: Set[UMLRedefinableElement[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      redefinableElement_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLRedefinableElement
    *
    * <!-- Start of user code doc for redefinableElement_metaAttributes -->
    * <!-- End of user code doc for redefinableElement_metaAttributes -->
    */
  def redefinableElement_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction](RedefinableElement_isLeaf))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    redefinableElement_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLRedefinableElement
    *
    * <!-- Start of user code doc for redefinableElement_compositeMetaProperties -->
    * <!-- End of user code doc for redefinableElement_compositeMetaProperties -->
    */
  def redefinableElement_compositeMetaProperties: MetaPropertyFunctions = 
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
    redefinableElement_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLRedefinableElement
    *
    * <!-- Start of user code doc for redefinableElement_referenceMetaProperties -->
    * <!-- End of user code doc for redefinableElement_referenceMetaProperties -->
    */
  def redefinableElement_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    redefinableElement_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLRedefinableElement
    *
    * <!-- Start of user code doc for redefinableElement_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for redefinableElement_forwardReferencesFromMetamodelAssociations -->
    */
  def redefinableElement_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLRedefinableElement
