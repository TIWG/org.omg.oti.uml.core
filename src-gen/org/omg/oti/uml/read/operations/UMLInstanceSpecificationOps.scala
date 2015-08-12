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
// End of user code

/**
 * An InstanceSpecification is a model element that represents an instance in a modeled system.
 * An InstanceSpecification can act as a DeploymentTarget in a Deployment relationship,
 * in the case that it represents an instance of a Node. It can also act as a DeployedArtifact,
 * if it represents an instance of an Artifact.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLInstanceSpecificationOps[Uml <: UML] { self: UMLInstanceSpecification[Uml] =>

  import self.ops._

  /**
   * A Slot giving the value or values of a StructuralFeature of the instance.
   * An InstanceSpecification can have one Slot per StructuralFeature of its Classifiers, including inherited features.
   * It is not necessary to model a Slot for every StructuralFeature,
   * in which case the InstanceSpecification is a partial description.
   *
   * <!-- Start of user code doc for slot -->
   * <!-- End of user code doc for slot -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
   * @opposite org.omg.oti.api.UMLSlot.owningInstance
   */
  def slot: Set[UMLSlot[Uml]] =
    ownedElement
    .selectByKindOf { case x: UMLSlot[Uml] => x }

  /**
   * The definingFeature of each slot is a StructuralFeature related to a classifier of the InstanceSpecification,
   * including direct attributes, inherited attributes, private attributes in generalizations,
   * and memberEnds of Associations, but excluding redefined StructuralFeatures.
   *
   * <!-- Start of user code doc for validate_defining_feature -->
   * <!-- End of user code doc for validate_defining_feature -->
   *
   * @body slot->forAll(s | classifier->exists (c | c.allSlottableFeatures()->includes (s.definingFeature)))
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
   * @body deploymentForArtifact->notEmpty() implies classifier->exists(oclIsKindOf(Artifact))
   */
  def validate_deployment_artifact: Boolean = {
    // Start of user code for "deployment_artifact"
      ???
      // End of user code
  }

  /**
   * An InstanceSpecification can act as a DeploymentTarget if it represents an instance of
   * a Node and functions as a part in the internal structure of an encompassing Node.
   *
   * <!-- Start of user code doc for validate_deployment_target -->
   * <!-- End of user code doc for validate_deployment_target -->
   *
   * @body deployment->notEmpty() implies classifier->exists(node | node.oclIsKindOf(Node) and
   *      Node.allInstances()->exists(n | n.part->exists(p | p.type = node)))
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
   * @body classifier->forAll(c |
   *      (c.allSlottableFeatures()->forAll(f | slot->select(s | s.definingFeature = f)->size() <= 1)))
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

  override def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] =
    instanceSpecification_asForwardReferencesToImportableOuterPackageableElements

  def instanceSpecification_asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    owner match {
    case None => Set()
    case Some( p: UMLPackage[Uml] ) => Set( p )
    case Some( e ) => e.asForwardReferencesToImportableOuterPackageableElements
  }
  
  // End of user code
} //UMLInstanceSpecificationOps
