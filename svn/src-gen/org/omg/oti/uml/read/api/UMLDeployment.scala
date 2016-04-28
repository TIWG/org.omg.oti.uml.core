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
import org.omg.oti.uml.read.operations.UMLDeploymentOps

import scala.collection.immutable.Set
import scala.collection.immutable.Seq
// End of user code


/**
  * A deployment is the allocation of an artifact or artifact instance to a deployment target.A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeployment[Uml <: UML]
  extends UMLDependency[Uml]
  with UMLDeploymentOps[Uml] {

  // Start of user code for class imports
  import ops._
  // End of user code

  /**
    * The Artifacts that are deployed onto a Node. This association specializes the supplier association.
    *
    * <!-- Start of user code doc for deployedArtifact -->
    * <!-- End of user code doc for deployedArtifact -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeployedArtifact.deployedArtifact_deploymentForArtifact
    */
  def deployedArtifact: Set[UMLDeployedArtifact[Uml]]

  /**
    * The XMI meta-attributes relevant to this object
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
    override def metaAttributes: MetaAttributeFunctions =
      deployment_metaAttributes

  /**
    * The XMI meta-attributes relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_metaAttributes -->
    * <!-- End of user code doc for deployment_metaAttributes -->
    */
  def deployment_metaAttributes: MetaAttributeFunctions = 
   appendUnique(
     dependency_metaAttributes,
     Seq[MetaAttributeFunction]())

  /**
    * The XMI composite meta-properties relevant to this object
    *
    * <!-- Start of user code doc for compositeMetaProperties -->
    * <!-- End of user code doc for compositeMetaProperties -->
    */
  override def compositeMetaProperties: MetaPropertyFunctions =
    deployment_compositeMetaProperties

  /**
    * The XMI composite meta-properties relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_compositeMetaProperties -->
    * <!-- End of user code doc for deployment_compositeMetaProperties -->
    */
  def deployment_compositeMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dependency_compositeMetaProperties,
      Seq[MetaPropertyEvaluator](Deployment_configuration))

  /**
    * The XMI reference meta-properties relevant to this object
    *
    * <!-- Start of user code doc for referenceMetaProperties -->
    * <!-- End of user code doc for referenceMetaProperties -->
    */
  override def referenceMetaProperties: MetaPropertyFunctions =
    deployment_referenceMetaProperties

  /**
    * The XMI reference meta-properties relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_referenceMetaProperties -->
    * <!-- End of user code doc for deployment_referenceMetaProperties -->
    */
  def deployment_referenceMetaProperties: MetaPropertyFunctions = 
    appendUnique(
      dependency_referenceMetaProperties,
      Seq[MetaPropertyEvaluator](Deployment_deployedArtifact))

  /**
    * The XMI forward references from metamodel associations relevant to this object
    *
    * <!-- Start of user code doc for forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for forwardReferencesFromMetamodelAssociations -->
    */
  override def forwardReferencesFromMetamodelAssociations: Elements =
    deployment_forwardReferencesFromMetamodelAssociations

  /**
    * The XMI forward references from metamodel associations relevant to class UMLDeployment
    *
    * <!-- Start of user code doc for deployment_forwardReferencesFromMetamodelAssociations -->
    * <!-- End of user code doc for deployment_forwardReferencesFromMetamodelAssociations -->
    */
  def deployment_forwardReferencesFromMetamodelAssociations: Elements =
    dependency_forwardReferencesFromMetamodelAssociations ++
    deployedArtifact

  // Start of user code for additional features
  // End of user code
} //UMLDeployment
