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
import org.omg.oti.uml.read.operations.UMLDataTypeOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A DataType is a type whose instances are identified only by their value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDataType[Uml <: UML]
  extends UMLClassifier[Uml]
  with UMLDataTypeOps[Uml] {

  // Start of user code for class imports
	import ops._
  // End of user code

  /**
    * The attributes owned by the DataType.
    *
    * <!-- Start of user code doc for ownedAttribute -->
    * <!-- End of user code doc for ownedAttribute -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.datatype
    */
  def ownedAttribute: Seq[UMLProperty[Uml]]

  /**
    * The Operations owned by the DataType.
    *
    * <!-- Start of user code doc for ownedOperation -->
    * <!-- End of user code doc for ownedOperation -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.datatype
    */
  def ownedOperation: Seq[UMLOperation[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      dataType_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDataType
    *
    * <!-- Start of user code doc for dataType_metaAttributes -->
    * <!-- End of user code doc for dataType_metaAttributes -->
    */
  def dataType_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     classifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    dataType_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDataType
    *
    * <!-- Start of user code doc for dataType_compositeMetaProperties -->
    * <!-- End of user code doc for dataType_compositeMetaProperties -->
    */
  def dataType_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](DataType_ownedAttribute,
      	DataType_ownedOperation))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    dataType_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDataType
    *
    * <!-- Start of user code doc for dataType_referenceMetaProperties -->
    * <!-- End of user code doc for dataType_referenceMetaProperties -->
    */
  def dataType_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      classifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    dataType_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDataType
    *
    * <!-- Start of user code doc for dataType_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for dataType_forwardReferencesFromMetamodelAssociations -->
    */
  def dataType_forwardReferencesFromMetamodelAssociations: Elements =
    classifier_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLDataType
