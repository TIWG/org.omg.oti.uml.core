/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
import scala.collection.Iterable
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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
