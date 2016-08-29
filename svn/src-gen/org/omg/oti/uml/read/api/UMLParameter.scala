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
import org.omg.oti.uml.read.operations.UMLParameterOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLParameter[Uml <: UML]
  extends UMLConnectableElement[Uml]
	with UMLMultiplicityElement[Uml]
  with UMLParameterOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Specifies a ValueSpecification that represents a value to be used when no argument is supplied for the Parameter.
    *
    * <!-- Start of user code doc for defaultValue -->
    * <!-- End of user code doc for defaultValue -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.defaultValue_owningParameter
    */
  def defaultValue: Option[UMLValueSpecification[Uml]]

  /**
    * Indicates whether a parameter is being sent into or out of a behavioral element.
    *
    * <!-- Start of user code doc for direction -->
    * <!-- End of user code doc for direction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def direction: Option[UMLParameterDirectionKind.Value]

  /**
    * Specifies the effect that executions of the owner of the Parameter have on objects passed in or out of the parameter.
    *
    * <!-- Start of user code doc for effect -->
    * <!-- End of user code doc for effect -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    */
  def effect: Option[UMLParameterEffectKind.Value]

  /**
    * Tells whether an output parameter may emit a value to the exclusion of the other outputs.
    *
    * <!-- Start of user code doc for isException -->
    * <!-- End of user code doc for isException -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isException: Boolean

  /**
    * Tells whether an input parameter may accept values while its behavior is executing, or whether an output parameter may post values while the behavior is executing.
    *
    * <!-- Start of user code doc for isStream -->
    * <!-- End of user code doc for isStream -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isStream: Boolean

  /**
    * The ParameterSets containing the parameter. See ParameterSet.
    *
    * <!-- Start of user code doc for parameterSet -->
    * <!-- End of user code doc for parameterSet -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameterSet.parameter
    */
  def parameterSet: Set[UMLParameterSet[Uml]]

  /**
    * <!-- Start of user code doc for parameter_activityParameterNode -->
    * <!-- End of user code doc for parameter_activityParameterNode -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivityParameterNode.parameter
    */
  def parameter_activityParameterNode: Set[UMLActivityParameterNode[Uml]]

  /**
    * <!-- Start of user code doc for result_opaqueExpression -->
    * <!-- End of user code doc for result_opaqueExpression -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOpaqueExpression.result
    */
  def result_opaqueExpression: Set[UMLOpaqueExpression[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      parameter_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLParameter
    *
    * <!-- Start of user code doc for parameter_metaAttributes -->
    * <!-- End of user code doc for parameter_metaAttributes -->
    */
  def parameter_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     connectableElement_metaAttributes,
     multiplicityElement_metaAttributes,
     Seq[MetaAttributeFunction](Parameter_isException,
     	Parameter_isStream))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    parameter_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLParameter
    *
    * <!-- Start of user code doc for parameter_compositeMetaProperties -->
    * <!-- End of user code doc for parameter_compositeMetaProperties -->
    */
  def parameter_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      connectableElement_compositeMetaProperties,
      multiplicityElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Parameter_defaultValue))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    parameter_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLParameter
    *
    * <!-- Start of user code doc for parameter_referenceMetaProperties -->
    * <!-- End of user code doc for parameter_referenceMetaProperties -->
    */
  def parameter_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      connectableElement_referenceMetaProperties,
      multiplicityElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Parameter_parameterSet))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    parameter_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLParameter
    *
    * <!-- Start of user code doc for parameter_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for parameter_forwardReferencesFromMetamodelAssociations -->
    */
  def parameter_forwardReferencesFromMetamodelAssociations: Elements =
    connectableElement_forwardReferencesFromMetamodelAssociations ++
    multiplicityElement_forwardReferencesFromMetamodelAssociations ++
    parameterSet

  // Start of user code for additional features
  // End of user code
} //UMLParameter
