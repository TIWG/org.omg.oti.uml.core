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
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A UseCase specifies a set of actions performed by its subjects, which yields an observable result that is of value for one or more Actors or other stakeholders of each subject.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLUseCaseOps[Uml <: UML] { self: UMLUseCase[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Extend relationships owned by this UseCase.
    *
    * <!-- Start of user code doc for extend -->
    * <!-- End of user code doc for extend -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtend.extension
    */
  def extend: Set[UMLExtend[Uml]] = ownedMember.selectByKindOf { case x: UMLExtend[Uml] => x }

  /**
    * The ExtensionPoints owned by this UseCase.
    *
    * <!-- Start of user code doc for extensionPoint -->
    * <!-- End of user code doc for extensionPoint -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtensionPoint.useCase
    */
  def extensionPoint: Set[UMLExtensionPoint[Uml]] = ownedMember.selectByKindOf { case x: UMLExtensionPoint[Uml] => x }

  /**
    * The Include relationships owned by this UseCase.
    *
    * <!-- Start of user code doc for include -->
    * <!-- End of user code doc for include -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInclude.includingCase
    */
  def include: Set[UMLInclude[Uml]] = ownedMember.selectByKindOf { case x: UMLInclude[Uml] => x }

  /**
    * <!-- Start of user code doc for addition_include -->
    * <!-- End of user code doc for addition_include -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInclude.addition
    */
  def addition_include: Set[UMLInclude[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLInclude[Uml] => x }

  /**
    * <!-- Start of user code doc for extendedCase_extend -->
    * <!-- End of user code doc for extendedCase_extend -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtend.extendedCase
    */
  def extendedCase_extend: Set[UMLExtend[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLExtend[Uml] => x }

  /**
    * The query allIncludedUseCases() returns the transitive closure of all UseCases (directly or indirectly) included by this UseCase.
    *
    * <!-- Start of user code doc for allIncludedUseCases -->
    * <!-- End of user code doc for allIncludedUseCases -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self.include.addition->union(self.include.addition->collect(uc | uc.allIncludedUseCases()))->asSet())
    * }}}
    */
  def allIncludedUseCases: Set[UMLUseCase[Uml]] = {
    // Start of user code for "allIncludedUseCases"
    ???
    // End of user code
  }

  /**
    * UseCases can only be involved in binary Associations.
    *
    * <!-- Start of user code doc for validate_binary_associations -->
    * <!-- End of user code doc for validate_binary_associations -->
    *
    * {{{
    * OCL Body Association.allInstances()->forAll(a | a.memberEnd.type->includes(self) implies a.memberEnd->size() = 2)
    * }}}
    */
  def validate_binary_associations: Boolean = {
    // Start of user code for "binary_associations"
    ???
    // End of user code
  }

  /**
    * A UseCase cannot include UseCases that directly or indirectly include it.
    *
    * <!-- Start of user code doc for validate_cannot_include_self -->
    * <!-- End of user code doc for validate_cannot_include_self -->
    *
    * {{{
    * OCL Body not allIncludedUseCases()->includes(self)
    * }}}
    */
  def validate_cannot_include_self: Boolean = {
    // Start of user code for "cannot_include_self"
    ???
    // End of user code
  }

  /**
    * A UseCase must have a name.
    *
    * <!-- Start of user code doc for validate_must_have_name -->
    * <!-- End of user code doc for validate_must_have_name -->
    *
    * {{{
    * OCL Body name -> notEmpty ()
    * }}}
    */
  def validate_must_have_name: Boolean = {
    // Start of user code for "must_have_name"
    ???
    // End of user code
  }

  /**
    * UseCases cannot have Associations to UseCases specifying the same subject.
    *
    * <!-- Start of user code doc for validate_no_association_to_use_case -->
    * <!-- End of user code doc for validate_no_association_to_use_case -->
    *
    * {{{
    * OCL Body Association.allInstances()->forAll(a | a.memberEnd.type->includes(self) implies 
    *    (
    *    let usecases: Set(UseCase) = a.memberEnd.type->select(oclIsKindOf(UseCase))->collect(oclAsType(UseCase))->asSet() in
    *    usecases->size() > 1 implies usecases->collect(subject)->size() > 1
    *    )
    * )
    * }}}
    */
  def validate_no_association_to_use_case: Boolean = {
    // Start of user code for "no_association_to_use_case"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLUseCaseOps
