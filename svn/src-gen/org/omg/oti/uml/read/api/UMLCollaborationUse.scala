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
import org.omg.oti.uml.read.operations.UMLCollaborationUseOps

import scala.Option
import scala.collection.immutable.Seq
// End of user code


/**
  * A CollaborationUse is used to specify the application of a pattern specified by a Collaboration to a specific situation.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCollaborationUse[Uml <: UML]
  extends UMLNamedElement[Uml]
  with UMLCollaborationUseOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Collaboration which is used in this CollaborationUse. The Collaboration defines the cooperation between its roles which are mapped to ConnectableElements relating to the Classifier owning the CollaborationUse.
    *
    * <!-- Start of user code doc for _type -->
    * <!-- End of user code doc for _type -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaboration.type_collaborationUse
    */
  def _type: Option[UMLCollaboration[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      collaborationUse_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_metaAttributes -->
    * <!-- End of user code doc for collaborationUse_metaAttributes -->
    */
  def collaborationUse_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     namedElement_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    collaborationUse_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_compositeMetaProperties -->
    * <!-- End of user code doc for collaborationUse_compositeMetaProperties -->
    */
  def collaborationUse_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](CollaborationUse_roleBinding))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    collaborationUse_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_referenceMetaProperties -->
    * <!-- End of user code doc for collaborationUse_referenceMetaProperties -->
    */
  def collaborationUse_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      namedElement_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](CollaborationUse_type))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    collaborationUse_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCollaborationUse
    *
    * <!-- Start of user code doc for collaborationUse_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for collaborationUse_forwardReferencesFromMetamodelAssociations -->
    */
  def collaborationUse_forwardReferencesFromMetamodelAssociations: Elements =
    namedElement_forwardReferencesFromMetamodelAssociations ++
    _type

  // Start of user code for additional features
  // End of user code
} //UMLCollaborationUse
