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
import org.omg.oti.uml.read.operations.UMLCommentOps

import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Comment is a textual annotation that can be attached to a set of Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLComment[Uml <: UML]
  extends UMLElement[Uml]
  with UMLCommentOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * References the Element(s) being commented.
    *
    * <!-- Start of user code doc for annotatedElement -->
    * <!-- End of user code doc for annotatedElement -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.annotatedElement_comment
    */
  def annotatedElement: Set[UMLElement[Uml]]

  /**
    * Specifies a string that is the comment.
    *
    * <!-- Start of user code doc for body -->
    * <!-- End of user code doc for body -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def body: Option[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      comment_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLComment
    *
    * <!-- Start of user code doc for comment_metaAttributes -->
    * <!-- End of user code doc for comment_metaAttributes -->
    */
  def comment_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction](Comment_body))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    comment_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLComment
    *
    * <!-- Start of user code doc for comment_compositeMetaProperties -->
    * <!-- End of user code doc for comment_compositeMetaProperties -->
    */
  def comment_compositeMetaProperties: MetaPropertyFunctions = 
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
    comment_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLComment
    *
    * <!-- Start of user code doc for comment_referenceMetaProperties -->
    * <!-- End of user code doc for comment_referenceMetaProperties -->
    */
  def comment_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Comment_annotatedElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    comment_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLComment
    *
    * <!-- Start of user code doc for comment_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for comment_forwardReferencesFromMetamodelAssociations -->
    */
  def comment_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    annotatedElement

  // Start of user code for additional features
  // End of user code
} //UMLComment
