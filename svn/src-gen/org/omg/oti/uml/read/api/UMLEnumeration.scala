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
import org.omg.oti.uml.read.operations.UMLEnumerationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Enumeration is a DataType whose values are enumerated in the model as EnumerationLiterals.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLEnumeration[Uml <: UML]
  extends UMLDataType[Uml]
  with UMLEnumerationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ordered set of literals owned by this Enumeration.
    *
    * <!-- Start of user code doc for ownedLiteral -->
    * <!-- End of user code doc for ownedLiteral -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLEnumerationLiteral.enumeration
    */
  def ownedLiteral: Seq[UMLEnumerationLiteral[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      enumeration_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLEnumeration
    *
    * <!-- Start of user code doc for enumeration_metaAttributes -->
    * <!-- End of user code doc for enumeration_metaAttributes -->
    */
  def enumeration_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     dataType_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    enumeration_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLEnumeration
    *
    * <!-- Start of user code doc for enumeration_compositeMetaProperties -->
    * <!-- End of user code doc for enumeration_compositeMetaProperties -->
    */
  def enumeration_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dataType_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Enumeration_ownedLiteral))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    enumeration_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLEnumeration
    *
    * <!-- Start of user code doc for enumeration_referenceMetaProperties -->
    * <!-- End of user code doc for enumeration_referenceMetaProperties -->
    */
  def enumeration_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dataType_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    enumeration_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLEnumeration
    *
    * <!-- Start of user code doc for enumeration_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for enumeration_forwardReferencesFromMetamodelAssociations -->
    */
  def enumeration_forwardReferencesFromMetamodelAssociations: Elements =
    dataType_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLEnumeration
