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
import scala.Option
import scala.collection.immutable.Set
// End of user code

/**
  * A deployment is the allocation of an artifact or artifact instance to a deployment target.A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDeploymentOps[Uml <: UML] { self: UMLDeployment[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The specification of properties that parameterize the deployment and execution of one or more Artifacts.
    *
    * <!-- Start of user code doc for configuration -->
    * <!-- End of user code doc for configuration -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeploymentSpecification.deployment
    */
  def configuration: Set[UMLDeploymentSpecification[Uml]] = ownedElement.selectByKindOf { case x: UMLDeploymentSpecification[Uml] => x }

  /**
    * The DeployedTarget which is the target of a Deployment.
    *
    * <!-- Start of user code doc for location -->
    * <!-- End of user code doc for location -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLDeploymentTarget.deployment
    */
  def location: Option[UMLDeploymentTarget[Uml]] = owner.selectByKindOf { case x: UMLDeploymentTarget[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLDeploymentOps
