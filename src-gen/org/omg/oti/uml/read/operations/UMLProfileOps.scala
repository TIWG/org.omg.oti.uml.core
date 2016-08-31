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
  * A profile defines limited extensions to a reference metamodel with the purpose of adapting the metamodel to a specific platform or domain.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLProfileOps[Uml <: UML] { self: UMLProfile[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * <!-- Start of user code doc for appliedProfile_profileApplication -->
    * <!-- End of user code doc for appliedProfile_profileApplication -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProfileApplication.appliedProfile
    */
  def appliedProfile_profileApplication: Set[UMLProfileApplication[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLProfileApplication[Uml] => x }

  /**
    * An element imported as a metaclassReference is not specialized or generalized in a Profile.
    *
    * <!-- Start of user code doc for validate_metaclass_reference_not_specialized -->
    * <!-- End of user code doc for validate_metaclass_reference_not_specialized -->
    *
    * {{{
    * OCL Body metaclassReference.importedElement->
    * 	select(c | c.oclIsKindOf(Classifier) and
    * 		(c.oclAsType(Classifier).allParents()->collect(namespace)->includes(self)))->isEmpty()
    * and 
    * packagedElement->
    *     select(oclIsKindOf(Classifier))->collect(oclAsType(Classifier).allParents())->
    *        intersection(metaclassReference.importedElement->select(oclIsKindOf(Classifier))->collect(oclAsType(Classifier)))->isEmpty()
    * }}}
    */
  def validate_metaclass_reference_not_specialized: Boolean = {
    // Start of user code for "metaclass_reference_not_specialized"
    ???
    // End of user code
  }

  /**
    * All elements imported either as metaclassReferences or through metamodelReferences are members of the same base reference metamodel.
    *
    * <!-- Start of user code doc for validate_references_same_metamodel -->
    * <!-- End of user code doc for validate_references_same_metamodel -->
    *
    * {{{
    * OCL Body metamodelReference.importedPackage.elementImport.importedElement.allOwningPackages()->
    *   union(metaclassReference.importedElement.allOwningPackages() )->notEmpty()
    * }}}
    */
  def validate_references_same_metamodel: Boolean = {
    // Start of user code for "references_same_metamodel"
    ???
    // End of user code
  }

  // Start of user code for additional features

  def allImportedProfilesTransitively
  : Set[UMLProfile[Uml]] =
    allImportedPackagesTransitively
    .selectByKindOf { case pf: UMLProfile[Uml] => pf }

  def allNestedProfilesTransitively
  : Set[UMLProfile[Uml]] =
    Set(this) ++ allOwnedElements.selectByKindOf { case pf: UMLProfile[Uml] => pf }

  /**
   * @see UML 2.5, 12.3.3 Profiles, Semantics, ProfileApplication
   *      Applying a Profile means recursively applying all its nested and imported Profiles.
   */
  def allVisibleProfilesTransitively
  : Set[UMLProfile[Uml]] =
    allNestedProfilesTransitively ++ allNestedProfilesTransitively.flatMap(_.allImportedProfilesTransitively)

  // End of user code
} //UMLProfileOps
