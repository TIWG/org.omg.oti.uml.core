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
import org.omg.oti.uml.read.operations.UMLLiteralBooleanOps

import scala.Boolean
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A LiteralBoolean is a specification of a Boolean value.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLLiteralBoolean[Uml <: UML]
  extends UMLLiteralSpecification[Uml]
  with UMLLiteralBooleanOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The specified Boolean value.
    *
    * <!-- Start of user code doc for value -->
    * <!-- End of user code doc for value -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def value: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      literalBoolean_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_metaAttributes -->
    * <!-- End of user code doc for literalBoolean_metaAttributes -->
    */
  def literalBoolean_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     literalSpecification_metaAttributes,
     Seq[MetaAttributeFunction](LiteralBoolean_value))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    literalBoolean_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_compositeMetaProperties -->
    * <!-- End of user code doc for literalBoolean_compositeMetaProperties -->
    */
  def literalBoolean_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      literalSpecification_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    literalBoolean_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_referenceMetaProperties -->
    * <!-- End of user code doc for literalBoolean_referenceMetaProperties -->
    */
  def literalBoolean_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      literalSpecification_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    literalBoolean_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLLiteralBoolean
    *
    * <!-- Start of user code doc for literalBoolean_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for literalBoolean_forwardReferencesFromMetamodelAssociations -->
    */
  def literalBoolean_forwardReferencesFromMetamodelAssociations: Elements =
    literalSpecification_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLLiteralBoolean
