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
import org.omg.oti.uml.read.operations.UMLQualifierValueOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A QualifierValue is an Element that is used as part of LinkEndData to provide the value for a single qualifier of the end given by the LinkEndData.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLQualifierValue[Uml <: UML]
  extends UMLElement[Uml]
  with UMLQualifierValueOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The qualifier Property for which the value is to be specified.
    *
    * <!-- Start of user code doc for qualifier -->
    * <!-- End of user code doc for qualifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.qualifier_qualifierValue
    */
  def qualifier: Option[UMLProperty[Uml]]

  /**
    * The InputPin from which the specified value for the qualifier is taken.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.value_qualifierValue
    */
  def value: Option[UMLInputPin[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      qualifierValue_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLQualifierValue
    *
    * <!-- Start of user code doc for qualifierValue_metaAttributes -->
    * <!-- End of user code doc for qualifierValue_metaAttributes -->
    */
  def qualifierValue_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     element_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    qualifierValue_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLQualifierValue
    *
    * <!-- Start of user code doc for qualifierValue_compositeMetaProperties -->
    * <!-- End of user code doc for qualifierValue_compositeMetaProperties -->
    */
  def qualifierValue_compositeMetaProperties: MetaPropertyFunctions = 
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
    qualifierValue_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLQualifierValue
    *
    * <!-- Start of user code doc for qualifierValue_referenceMetaProperties -->
    * <!-- End of user code doc for qualifierValue_referenceMetaProperties -->
    */
  def qualifierValue_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      element_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](QualifierValue_qualifier,
      	QualifierValue_value))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    qualifierValue_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLQualifierValue
    *
    * <!-- Start of user code doc for qualifierValue_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for qualifierValue_forwardReferencesFromMetamodelAssociations -->
    */
  def qualifierValue_forwardReferencesFromMetamodelAssociations: Elements =
    element_forwardReferencesFromMetamodelAssociations ++
    qualifier ++
    value

  // Start of user code for additional features
  // End of user code
} //UMLQualifierValue
