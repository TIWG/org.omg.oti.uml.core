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
