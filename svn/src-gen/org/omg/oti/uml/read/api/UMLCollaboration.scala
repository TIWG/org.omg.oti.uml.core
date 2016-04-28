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
import org.omg.oti.uml.read.operations.UMLCollaborationOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A Collaboration describes a structure of collaborating elements (roles), each performing a specialized function, which collectively accomplish some desired functionality. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLCollaboration[Uml <: UML]
  extends UMLBehavioredClassifier[Uml]
	with UMLStructuredClassifier[Uml]
  with UMLCollaborationOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * Represents the participants in the Collaboration.
    *
    * <!-- Start of user code doc for collaborationRole -->
    * <!-- End of user code doc for collaborationRole -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnectableElement.collaborationRole_collaboration
    */
  def collaborationRole: Set[UMLConnectableElement[Uml]]

  /**
    * <!-- Start of user code doc for type_collaborationUse -->
    * <!-- End of user code doc for type_collaborationUse -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaborationUse._type
    */
  def type_collaborationUse: Set[UMLCollaborationUse[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      collaboration_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_metaAttributes -->
    * <!-- End of user code doc for collaboration_metaAttributes -->
    */
  def collaboration_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     behavioredClassifier_metaAttributes,
     structuredClassifier_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    collaboration_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_compositeMetaProperties -->
    * <!-- End of user code doc for collaboration_compositeMetaProperties -->
    */
  def collaboration_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_compositeMetaProperties,
      structuredClassifier_compositeMetaProperties,
      Seq[MetaPropertyEvaluator]())

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    collaboration_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_referenceMetaProperties -->
    * <!-- End of user code doc for collaboration_referenceMetaProperties -->
    */
  def collaboration_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      behavioredClassifier_referenceMetaProperties,
      structuredClassifier_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Collaboration_collaborationRole))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    collaboration_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLCollaboration
    *
    * <!-- Start of user code doc for collaboration_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for collaboration_forwardReferencesFromMetamodelAssociations -->
    */
  def collaboration_forwardReferencesFromMetamodelAssociations: Elements =
    behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
    structuredClassifier_forwardReferencesFromMetamodelAssociations ++
    collaborationRole

  // Start of user code for additional features
  // End of user code
} //UMLCollaboration