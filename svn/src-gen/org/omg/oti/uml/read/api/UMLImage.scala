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
import org.omg.oti.uml.read.operations.UMLImageOps

import scala.Predef.String
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * Physical definition of a graphical image.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLImage[Uml <: UML]
  extends UMLElement[Uml]
  with UMLImageOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * This contains the serialization of the image according to the format. The value could represent a bitmap, image such as a GIF file, or drawing 'instructions' using a standard such as Scalable Vector Graphic (SVG) (which is XML based).
    *
    * <!-- Start of user code doc for content -->
    * <!-- End of user code doc for content -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def content: Option[String]

  /**
    * This indicates the format of the content, which is how the string content should be interpreted. The following values are reserved: SVG, GIF, PNG, JPG, WMF, EMF, BMP. In addition the prefix 'MIME: ' is also reserved. This option can be used as an alternative to express the reserved values above, for example "SVG" could instead be expressed as "MIME: image/svg+xml".
    *
    * <!-- Start of user code doc for format -->
    * <!-- End of user code doc for format -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def format: Option[String]

  /**
    * This contains a location that can be used by a tool to locate the image as an alternative to embedding it in the stereotype.
    *
    * <!-- Start of user code doc for location -->
    * <!-- End of user code doc for location -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def location: Option[String]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      image_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLImage
    *
    * <!-- Start of user code doc for image_metaAttributes -->
    * <!-- End of user code doc for image_metaAttributes -->
    */
  def image_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction](Image_content,
     	Image_format,
     	Image_location))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    image_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLImage
    *
    * <!-- Start of user code doc for image_compositeMetaProperties -->
    * <!-- End of user code doc for image_compositeMetaProperties -->
    */
  def image_compositeMetaProperties: MetaPropertyFunctions = 
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
    image_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLImage
    *
    * <!-- Start of user code doc for image_referenceMetaProperties -->
    * <!-- End of user code doc for image_referenceMetaProperties -->
    */
  def image_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    image_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLImage
    *
    * <!-- Start of user code doc for image_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for image_forwardReferencesFromMetamodelAssociations -->
    */
  def image_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLImage
