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

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A deployment target is the location for a deployed artifact.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeploymentTargetOps[Uml <: UML] { self: UMLDeploymentTarget[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The set of elements that are manifested in an Artifact that is involved in Deployment to a DeploymentTarget.
    *
    * <!-- Start of user code doc for deployedElement -->
    * <!-- End of user code doc for deployedElement -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageableElement.deployedElement_deploymentTarget
    * {{{
    * OCL Body result = (deployment.deployedArtifact->select(oclIsKindOf(Artifact))->collect(oclAsType(Artifact).manifestation)->collect(utilizedElement)->asSet())
    * }}}
    */
  def deployedElement: Set[UMLPackageableElement[Uml]] = {
    // Start of user code for "deployedElement"
    ???
    // End of user code
  }

  /**
    * The set of Deployments for a DeploymentTarget.
    *
    * <!-- Start of user code doc for deployment -->
    * <!-- End of user code doc for deployment -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeployment.location
    */
  def deployment: Set[UMLDeployment[Uml]] = ownedElement.selectByKindOf { case x: UMLDeployment[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLDeploymentTargetOps
