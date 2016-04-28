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
import org.omg.oti.uml.read.operations.UMLInteractionOperandOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An InteractionOperand is contained in a CombinedFragment. An InteractionOperand represents one operand of the expression given by the enclosing CombinedFragment.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInteractionOperand[Uml <: UML]
  extends UMLInteractionFragment[Uml]
	with UMLNamespace[Uml]
  with UMLInteractionOperandOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The fragments of the operand.
    *
    * <!-- Start of user code doc for fragment -->
    * <!-- End of user code doc for fragment -->
    *
    * UML Property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInteractionFragment.enclosingOperand
    */
  def fragment: Seq[UMLInteractionFragment[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      interactionOperand_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLInteractionOperand
    *
    * <!-- Start of user code doc for interactionOperand_metaAttributes -->
    * <!-- End of user code doc for interactionOperand_metaAttributes -->
    */
  def interactionOperand_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     interactionFragment_metaAttributes,
     namespace_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    interactionOperand_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLInteractionOperand
    *
    * <!-- Start of user code doc for interactionOperand_compositeMetaProperties -->
    * <!-- End of user code doc for interactionOperand_compositeMetaProperties -->
    */
  def interactionOperand_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_compositeMetaProperties,
      namespace_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](InteractionOperand_fragment,
      	InteractionOperand_guard))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    interactionOperand_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLInteractionOperand
    *
    * <!-- Start of user code doc for interactionOperand_referenceMetaProperties -->
    * <!-- End of user code doc for interactionOperand_referenceMetaProperties -->
    */
  def interactionOperand_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      interactionFragment_referenceMetaProperties,
      namespace_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    interactionOperand_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLInteractionOperand
    *
    * <!-- Start of user code doc for interactionOperand_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for interactionOperand_forwardReferencesFromMetamodelAssociations -->
    */
  def interactionOperand_forwardReferencesFromMetamodelAssociations: Elements =
    interactionFragment_forwardReferencesFromMetamodelAssociations ++
    namespace_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLInteractionOperand