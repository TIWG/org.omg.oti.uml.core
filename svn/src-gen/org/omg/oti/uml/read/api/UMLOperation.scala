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
import org.omg.oti.uml.read.operations.UMLOperationOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOperation[Uml <: UML]
  extends UMLBehavioralFeature[Uml]
	with UMLParameterableElement[Uml]
	with UMLTemplateableElement[Uml]
  with UMLOperationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * An optional Constraint on the result values of an invocation of this Operation.
    *
    * <!-- Start of user code doc for bodyCondition -->
    * <!-- End of user code doc for bodyCondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.bodyCondition_bodyContext
    */
  def bodyCondition: Option[UMLConstraint[Uml]]

  /**
    * Specifies whether an execution of the BehavioralFeature leaves the state of the system unchanged (isQuery=true) or whether side effects may occur (isQuery=false).
    *
    * <!-- Start of user code doc for isQuery -->
    * <!-- End of user code doc for isQuery -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isQuery: Boolean

  /**
    * The parameters owned by this Operation.
    *
    * <!-- Start of user code doc for ownedParameter -->
    * <!-- End of user code doc for ownedParameter -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLParameter.operation
    */
  override def ownedParameter: Seq[UMLParameter[Uml]]

  /**
    * An optional set of Constraints specifying the state of the system when the Operation is completed.
    *
    * <!-- Start of user code doc for postcondition -->
    * <!-- End of user code doc for postcondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.postcondition_postContext
    */
  def postcondition: Set[UMLConstraint[Uml]]

  /**
    * An optional set of Constraints on the state of the system when the Operation is invoked.
    *
    * <!-- Start of user code doc for precondition -->
    * <!-- End of user code doc for precondition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.precondition_preContext
    */
  def precondition: Set[UMLConstraint[Uml]]

  /**
    * The Types representing exceptions that may be raised during an invocation of this operation.
    *
    * <!-- Start of user code doc for raisedException -->
    * <!-- End of user code doc for raisedException -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLType.raisedException_operation
    */
  override def raisedException: Set[UMLType[Uml]]

  /**
    * The OperationTemplateParameter that exposes this element as a formal parameter.
    *
    * <!-- Start of user code doc for templateParameter -->
    * <!-- End of user code doc for templateParameter -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperationTemplateParameter.parameteredElement
    */
  override def templateParameter: Option[UMLOperationTemplateParameter[Uml]]

  /**
    * <!-- Start of user code doc for operation_callEvent -->
    * <!-- End of user code doc for operation_callEvent -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCallEvent.operation
    */
  def operation_callEvent: Set[UMLCallEvent[Uml]]

  /**
    * <!-- Start of user code doc for operation_callOperationAction -->
    * <!-- End of user code doc for operation_callOperationAction -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCallOperationAction.operation
    */
  def operation_callOperationAction: Set[UMLCallOperationAction[Uml]]

  /**
    * <!-- Start of user code doc for referred_protocolTransition -->
    * <!-- End of user code doc for referred_protocolTransition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolTransition.referred
    */
  def referred_protocolTransition: Set[UMLProtocolTransition[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      operation_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLOperation
    *
    * <!-- Start of user code doc for operation_metaAttributes -->
    * <!-- End of user code doc for operation_metaAttributes -->
    */
  def operation_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavioralFeature_metaAttributes,
     parameterableElement_metaAttributes,
     templateableElement_metaAttributes,
     Seq[MetaAttributeFunction](Operation_isQuery))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    operation_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLOperation
    *
    * <!-- Start of user code doc for operation_compositeMetaProperties -->
    * <!-- End of user code doc for operation_compositeMetaProperties -->
    */
  def operation_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioralFeature_compositeMetaProperties,
      parameterableElement_compositeMetaProperties,
      templateableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Operation_bodyCondition,
      	Operation_ownedParameter,
      	Operation_postcondition,
      	Operation_precondition))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    operation_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLOperation
    *
    * <!-- Start of user code doc for operation_referenceMetaProperties -->
    * <!-- End of user code doc for operation_referenceMetaProperties -->
    */
  def operation_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioralFeature_referenceMetaProperties,
      parameterableElement_referenceMetaProperties,
      templateableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Operation_raisedException,
      	Operation_redefinedOperation,
      	Operation_templateParameter))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    operation_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLOperation
    *
    * <!-- Start of user code doc for operation_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for operation_forwardReferencesFromMetamodelAssociations -->
    */
  def operation_forwardReferencesFromMetamodelAssociations: Elements =
    behavioralFeature_forwardReferencesFromMetamodelAssociations ++
    parameterableElement_forwardReferencesFromMetamodelAssociations ++
    templateableElement_forwardReferencesFromMetamodelAssociations ++
    raisedException ++
    redefinedOperation ++
    templateParameter

  // Start of user code for additional features
  // End of user code
} //UMLOperation
