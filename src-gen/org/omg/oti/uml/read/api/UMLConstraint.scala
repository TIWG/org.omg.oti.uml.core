/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.read.api

// Start of user code for imports
import org.omg.oti.uml.read.operations.UMLConstraintOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A Constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an Element or set of Elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConstraint[Uml <: UML]
  extends UMLPackageableElement[Uml]
  with UMLConstraintOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The ordered set of Elements referenced by this Constraint.
    *
    * <!-- Start of user code doc for constrainedElement -->
    * <!-- End of user code doc for constrainedElement -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.constrainedElement_constraint
    */
  def constrainedElement: Seq[UMLElement[Uml]]

  /**
    * Specifies the Namespace that owns the Constraint.
    *
    * <!-- Start of user code doc for context -->
    * <!-- End of user code doc for context -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamespace.ownedRule
    */
  def context: Option[UMLNamespace[Uml]]

  /**
    * A condition that must be true when evaluated in order for the Constraint to be satisfied.
    *
    * <!-- Start of user code doc for specification -->
    * <!-- End of user code doc for specification -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLValueSpecification.specification_owningConstraint
    */
  def specification: Option[UMLValueSpecification[Uml]]

  /**
    * <!-- Start of user code doc for bodyCondition_bodyContext -->
    * <!-- End of user code doc for bodyCondition_bodyContext -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.bodyCondition
    */
  def bodyCondition_bodyContext: Option[UMLOperation[Uml]]

  /**
    * <!-- Start of user code doc for guard_transition -->
    * <!-- End of user code doc for guard_transition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLTransition.guard
    */
  def guard_transition: Option[UMLTransition[Uml]]

  /**
    * <!-- Start of user code doc for localPostcondition_action -->
    * <!-- End of user code doc for localPostcondition_action -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.localPostcondition
    */
  def localPostcondition_action: Option[UMLAction[Uml]]

  /**
    * <!-- Start of user code doc for localPrecondition_action -->
    * <!-- End of user code doc for localPrecondition_action -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLAction.localPrecondition
    */
  def localPrecondition_action: Option[UMLAction[Uml]]

  /**
    * <!-- Start of user code doc for postCondition_owningTransition -->
    * <!-- End of user code doc for postCondition_owningTransition -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProtocolTransition.postCondition
    */
  def postCondition_owningTransition: Option[UMLProtocolTransition[Uml]]

  /**
    * <!-- Start of user code doc for postcondition_behavior -->
    * <!-- End of user code doc for postcondition_behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.postcondition
    */
  def postcondition_behavior: Option[UMLBehavior[Uml]]

  /**
    * <!-- Start of user code doc for postcondition_postContext -->
    * <!-- End of user code doc for postcondition_postContext -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.postcondition
    */
  def postcondition_postContext: Option[UMLOperation[Uml]]

  /**
    * <!-- Start of user code doc for precondition_behavior -->
    * <!-- End of user code doc for precondition_behavior -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLBehavior.precondition
    */
  def precondition_behavior: Option[UMLBehavior[Uml]]

  /**
    * <!-- Start of user code doc for precondition_preContext -->
    * <!-- End of user code doc for precondition_preContext -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.precondition
    */
  def precondition_preContext: Option[UMLOperation[Uml]]

  /**
    * <!-- Start of user code doc for stateInvariant_owningState -->
    * <!-- End of user code doc for stateInvariant_owningState -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLState.stateInvariant
    */
  def stateInvariant_owningState: Option[UMLState[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      constraint_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLConstraint
    *
    * <!-- Start of user code doc for constraint_metaAttributes -->
    * <!-- End of user code doc for constraint_metaAttributes -->
    */
  def constraint_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     packageableElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    constraint_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLConstraint
    *
    * <!-- Start of user code doc for constraint_compositeMetaProperties -->
    * <!-- End of user code doc for constraint_compositeMetaProperties -->
    */
  def constraint_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Constraint_specification))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    constraint_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLConstraint
    *
    * <!-- Start of user code doc for constraint_referenceMetaProperties -->
    * <!-- End of user code doc for constraint_referenceMetaProperties -->
    */
  def constraint_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      packageableElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Constraint_constrainedElement))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    constraint_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLConstraint
    *
    * <!-- Start of user code doc for constraint_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for constraint_forwardReferencesFromMetamodelAssociations -->
    */
  def constraint_forwardReferencesFromMetamodelAssociations: Elements =
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    constrainedElement

  // Start of user code for additional features
  // End of user code
} //UMLConstraint
