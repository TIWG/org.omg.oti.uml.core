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
import scala.{Option,None,Some}
import scala.Predef.{???,require,String}
import scala.collection.Iterable
import scala.collection.immutable.::
import scala.collection.immutable.Nil
import scala.collection.immutable.Set
import scalaz._, Scalaz._

// End of user code

/**
  * An InstanceSpecification is a model element that represents an instance in a modeled system. An InstanceSpecification can act as a DeploymentTarget in a Deployment relationship, in the case that it represents an instance of a Node. It can also act as a DeployedArtifact, if it represents an instance of an Artifact.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInstanceSpecificationOps[Uml <: UML] { self: UMLInstanceSpecification[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A Slot giving the value or values of a StructuralFeature of the instance. An InstanceSpecification can have one Slot per StructuralFeature of its Classifiers, including inherited features. It is not necessary to model a Slot for every StructuralFeature, in which case the InstanceSpecification is a partial description.
    *
    * <!-- Start of user code doc for slot -->
    * <!-- End of user code doc for slot -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLSlot.owningInstance
    */
  def slot: Set[UMLSlot[Uml]] = ownedElement.selectByKindOf { case x: UMLSlot[Uml] => x }

  /**
    * The definingFeature of each slot is a StructuralFeature related to a classifier of the InstanceSpecification, including direct attributes, inherited attributes, private attributes in generalizations, and memberEnds of Associations, but excluding redefined StructuralFeatures.
    *
    * <!-- Start of user code doc for validate_defining_feature -->
    * <!-- End of user code doc for validate_defining_feature -->
    *
    * {{{
    * OCL Body slot->forAll(s | classifier->exists (c | c.allSlottableFeatures()->includes (s.definingFeature)))
    * }}}
    */
  def validate_defining_feature: Boolean = {
    // Start of user code for "defining_feature"
    ???
    // End of user code
  }

  /**
    * An InstanceSpecification can act as a DeployedArtifact if it represents an instance of an Artifact.
    *
    * <!-- Start of user code doc for validate_deployment_artifact -->
    * <!-- End of user code doc for validate_deployment_artifact -->
    *
    * {{{
    * OCL Body deploymentForArtifact->notEmpty() implies classifier->exists(oclIsKindOf(Artifact))
    * }}}
    */
  def validate_deployment_artifact: Boolean = {
    // Start of user code for "deployment_artifact"
    ???
    // End of user code
  }

  /**
    * An InstanceSpecification can act as a DeploymentTarget if it represents an instance of a Node and functions as a part in the internal structure of an encompassing Node.
    *
    * <!-- Start of user code doc for validate_deployment_target -->
    * <!-- End of user code doc for validate_deployment_target -->
    *
    * {{{
    * OCL Body deployment->notEmpty() implies classifier->exists(node | node.oclIsKindOf(Node) and Node.allInstances()->exists(n | n.part->exists(p | p.type = node)))
    * }}}
    */
  def validate_deployment_target: Boolean = {
    // Start of user code for "deployment_target"
    ???
    // End of user code
  }

  /**
    * No more than one slot in an InstanceSpecification may have the same definingFeature.
    *
    * <!-- Start of user code doc for validate_structural_feature -->
    * <!-- End of user code doc for validate_structural_feature -->
    *
    * {{{
    * OCL Body classifier->forAll(c | (c.allSlottableFeatures()->forAll(f | slot->select(s | s.definingFeature = f)->size() <= 1)))
    * }}}
    */
  def validate_structural_feature: Boolean = {
    // Start of user code for "structural_feature"
    ???
    // End of user code
  }

  // Start of user code for additional features

  /**
   * @return Either:
   * None if there is no slot whose defining has the featureName
   * Some( vs ) where vs is the iterable of values for the slot whose defining feature is named featureName
   */
  def getValuesOfFeatureSlot( featureName: String ): Option[Iterable[UMLValueSpecification[Uml]]] = {
    ( for {
      slot <- self.slot
      f <- slot.definingFeature
      fName <- f.name
      if fName == featureName
    } yield slot ).toList match {
      case Nil =>
        None
      case s :: sx =>
        require( sx == Nil )
        Some( s.value )
    }
  }

  override def asForwardReferencesToImportableOuterPackageableElements
	: Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] =
    instanceSpecification_asForwardReferencesToImportableOuterPackageableElements

  def instanceSpecification_asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] =
    owner
    .fold[Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]]](Set().right) {
      case p: UMLPackage[Uml] =>
        Set[UMLPackageableElement[Uml]]( p ).right
      case e =>
        e.asForwardReferencesToImportableOuterPackageableElements
    }
  
  // End of user code
} //UMLInstanceSpecificationOps
