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
import org.omg.oti.uml.read.operations.UMLAddStructuralFeatureValueActionOps

import scala.Boolean
import scala.Option
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * An AddStructuralFeatureValueAction is a WriteStructuralFeatureAction for adding values to a StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAddStructuralFeatureValueAction[Uml <: UML]
  extends UMLWriteStructuralFeatureAction[Uml]
  with UMLAddStructuralFeatureValueActionOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The InputPin that gives the position at which to insert the value in an ordered StructuralFeature. The type of the insertAt InputPin is UnlimitedNatural, but the value cannot be zero. It is omitted for unordered StructuralFeatures.
    *
    * <!-- Start of user code doc for insertAt -->
    * <!-- End of user code doc for insertAt -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.insertAt_addStructuralFeatureValueAction
    */
  def insertAt: Option[UMLInputPin[Uml]]

  /**
    * Specifies whether existing values of the StructuralFeature should be removed before adding the new value.
    *
    * <!-- Start of user code doc for isReplaceAll -->
    * <!-- End of user code doc for isReplaceAll -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    */
  def isReplaceAll: Boolean

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      addStructuralFeatureValueAction_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLAddStructuralFeatureValueAction
    *
    * <!-- Start of user code doc for addStructuralFeatureValueAction_metaAttributes -->
    * <!-- End of user code doc for addStructuralFeatureValueAction_metaAttributes -->
    */
  def addStructuralFeatureValueAction_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     writeStructuralFeatureAction_metaAttributes,
     Seq[MetaAttributeFunction](AddStructuralFeatureValueAction_isReplaceAll))

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    addStructuralFeatureValueAction_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLAddStructuralFeatureValueAction
    *
    * <!-- Start of user code doc for addStructuralFeatureValueAction_compositeMetaProperties -->
    * <!-- End of user code doc for addStructuralFeatureValueAction_compositeMetaProperties -->
    */
  def addStructuralFeatureValueAction_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeStructuralFeatureAction_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](AddStructuralFeatureValueAction_insertAt))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    addStructuralFeatureValueAction_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLAddStructuralFeatureValueAction
    *
    * <!-- Start of user code doc for addStructuralFeatureValueAction_referenceMetaProperties -->
    * <!-- End of user code doc for addStructuralFeatureValueAction_referenceMetaProperties -->
    */
  def addStructuralFeatureValueAction_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      writeStructuralFeatureAction_referenceMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLAddStructuralFeatureValueAction
    *
    * <!-- Start of user code doc for addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations -->
    */
  def addStructuralFeatureValueAction_forwardReferencesFromMetamodelAssociations: Elements =
    writeStructuralFeatureAction_forwardReferencesFromMetamodelAssociations ++
    Set ()

  // Start of user code for additional features
  // End of user code
} //UMLAddStructuralFeatureValueAction