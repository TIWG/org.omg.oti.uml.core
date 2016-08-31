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
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeploymentSpecificationOps[Uml <: UML] { self: UMLDeploymentSpecification[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The deployment with which the DeploymentSpecification is associated.
    *
    * <!-- Start of user code doc for deployment -->
    * <!-- End of user code doc for deployment -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeployment.configuration
    */
  def deployment: Option[UMLDeployment[Uml]] = owner.selectByKindOf { case x: UMLDeployment[Uml] => x }

  /**
    * The deployedElements of a DeploymentTarget that are involved in a Deployment that has an associated Deployment-Specification is a kind of Component (i.e., the configured components).
    *
    * <!-- Start of user code doc for validate_deployed_elements -->
    * <!-- End of user code doc for validate_deployed_elements -->
    *
    * {{{
    * OCL Body deployment->forAll (location.deployedElement->forAll (oclIsKindOf(Component)))
    * }}}
    */
  def validate_deployed_elements: Boolean = {
    // Start of user code for "deployed_elements"
    ???
    // End of user code
  }

  /**
    * The DeploymentTarget of a DeploymentSpecification is a kind of ExecutionEnvironment.
    *
    * <!-- Start of user code doc for validate_deployment_target -->
    * <!-- End of user code doc for validate_deployment_target -->
    *
    * {{{
    * OCL Body deployment->forAll (location.oclIsKindOf(ExecutionEnvironment))
    * }}}
    */
  def validate_deployment_target: Boolean = {
    // Start of user code for "deployment_target"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLDeploymentSpecificationOps
