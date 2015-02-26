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
package org.omg.oti.operations

import org.omg.oti._
import scala.language.postfixOps
import scala.util.Try
import scala.util.Success
import scala.util.Failure

trait UMLPackageOps[Uml <: UML] { self: UMLPackage[Uml] =>

  import self.ops._

  // [protected (TIWG)]

  def nestingPackage: Option[UMLPackage[Uml]] = packagedElement_owningPackage
  def packagedElement: Set[UMLPackageableElement[Uml]] = ownedMember.selectByKindOf { case pe: UMLPackageableElement[Uml] => pe }
  def ownedType: Set[UMLType[Uml]] = packagedElement.selectByKindOf { case t: UMLType[Uml] => t }
  def ownedStereotype: Set[UMLStereotype[Uml]] = ownedType.selectByKindOf { case s: UMLStereotype[Uml] => s }
  def nestedPackage: Set[UMLPackage[Uml]] = packagedElement.selectByKindOf { case p: UMLPackage[Uml] => p }
  def packageMerge: Set[UMLPackageMerge[Uml]] = ownedElement.selectByKindOf { case pm: UMLPackageMerge[Uml] => pm }
  def profileApplication: Set[UMLProfileApplication[Uml]] = source_directedRelationship.selectByKindOf { case pa: UMLProfileApplication[Uml] => pa }

  def nonImportedNestedPackages: Set[UMLPackage[Uml]] = nestedPackage -- importedPackages

  def allNestedPackages: Set[UMLPackage[Uml]] = closure( self, ( ( p: UMLPackage[Uml] ) => p.nestedPackage ) )

  /**
   * The reflexive transitive closure of the owning package of a package.
   */
  def allNestingPackagesTransitively: Set[UMLPackage[Uml]] =
    Set( self ) ++ closure[UMLPackage[Uml], UMLPackage[Uml]]( self, ( _.packagedElement_owningPackage ) )

  /**
   * The direclty imported packages from the reflexive transitive closure of the owning package of a package.
   */
  def allDirectlyImportedPackagesIncludingNestingPackagesTransitively: Set[UMLPackage[Uml]] =
    allNestingPackagesTransitively.flatMap( _.importedPackages )

  /**
   * The URI for the package, if any; subject to being overriden by the OTI::SpecificationRoot stereotype, if applied.
   *
   * @return In decreasing order of priority:
   * - the value of the tag property OTI::SpecificationRoot::packageURI, if any and the OTI::SpecificationRoot stereotype is applied
   * - the value of the Package::URI, if any
   * - none, otherwise
   */
  def getEffectiveURI: Option[String] =
    if ( OTI_SPECIFICATION_ROOT_S.isDefined && OTI_SPECIFICATION_ROOT_packageURI.isDefined )
      self.tagValues.get( OTI_SPECIFICATION_ROOT_packageURI.get ) match {
        case Some( Seq( uri: UMLLiteralString[_] ) ) if ( uri.value.isDefined ) =>
          uri.value
        case _ =>
          URI
      }
    else URI

  /**
   * @see UML2.5, 12.4, Package, Operations:
   *
   * allApplicableStereotypes() : Stereotype [0..*]
   * The query allApplicableStereotypes() returns all the directly or indirectly owned stereotypes, including stereotypes contained in sub-profiles.
   *
   * body: let ownedPackages : Bag(Package) = ownedMember->select(oclIsKindOf(Package))- >collect(oclAsType(Package)) in
   *  ownedStereotype->union(ownedPackages.allApplicableStereotypes())->flatten()->asSet()
   */
  def allApplicableStereotypes: Set[UMLStereotype[Uml]] = allOwnedElements.selectByKindOf { case s: UMLStereotype[Uml] => s } toSet

  /**
   * @see UML2.5, 12.4, Package, Operations:
   *
   * containingProfile() : Profile [0..1]
   * The query containingProfile() returns the closest profile directly or indirectly containing this package (or this package itself, if it is a profile).
   *
   * body: if self.oclIsKindOf(Profile) then
   *   self.oclAsType(Profile)
   * else
   *   self.namespace.oclAsType(Package).containingProfile()
   * endif
   */
  def containingProfile: Option[UMLProfile[Uml]] = self match {
    case pf: UMLProfile[Uml] =>
      Some( pf )

    case _ =>
      for {
        parent <- nestingPackage
        pf <- parent.containingProfile
      } yield pf
  }

  /**
   * @issue UML 2.5, 12.3.3 ProfileApplication, Semantics is incomplete:
   * @clarification: Applying a profile PF to a package P implies applying
   * PF to all nested packages of P. That is, for a given package P, the
   * set of all profile applications is the union of the profile applications
   * of P and of all of its nesting packages recursively.
   */
  def allDirectProfileApplicationsIncludingNestingPackagesTransitively: Set[UMLProfileApplication[Uml]] =
    allNestingPackagesTransitively.flatMap( _.profileApplication )

  def allDirectlyAppliedProfilesExceptNestingPackages: Set[UMLProfile[Uml]] =
    profileApplication.flatMap( _.appliedProfile )

  def allDirectlyAppliedProfilesIncludingNestingPackagesTransitively: Set[UMLProfile[Uml]] =
    allDirectProfileApplicationsIncludingNestingPackagesTransitively.flatMap( _.appliedProfile )

  def allDirectlyVisibleMembersTransitivelyAccessibleExceptNestingPackagesAndAppliedProfiles: Set[UMLPackageableElement[Uml]] =
    allVisibleMembersAccessibleTransitively ++
      allDirectlyAppliedProfilesExceptNestingPackages.flatMap( _.allVisibleMembersTransitively )

  /**
   * Calculates the set of all profiles directly or indirectly applied to the package.
   *
   * @see UML 2.5, section 12.3.3, ProfileApplication, 2nd paragraph:
   * Applying a Profile means recursively applying all its nested and imported Profiles.
   *
   * @see UML 2.5, section 12.3.3, Profile, Integrating & Extending Profiles, 3rd paragraph:
   * Normal rules apply as to whether a referenced Stereotype is visible to users of the extending Profile:
   * a public import is needed to ensure that Stereotypes from other profiles are visible after applying the extending one.
   */
  def allIndirectlyAppliedProfilesIncludingNestingPackagesTransitively: Set[UMLProfile[Uml]] =
    allDirectlyAppliedProfilesIncludingNestingPackagesTransitively ++
      allDirectlyAppliedProfilesIncludingNestingPackagesTransitively.flatMap( _.allVisibleProfilesTransitively )

  /**
   * For a Package, allIndirectlyVisibleMembersTransitivelyAccessibleFromNestingPackagesAndAppliedProfiles is the union of
   * all visible members that are transitively accessible from outer namespaces or from applied profiles.
   */
  def allIndirectlyVisibleMembersTransitivelyAccessibleFromNestingPackagesAndAppliedProfiles: Set[UMLPackageableElement[Uml]] =
    allVisibleMembersAccessibleTransitively ++
      allIndirectlyAppliedProfilesIncludingNestingPackagesTransitively.flatMap( _.allVisibleMembersTransitively )

  /**
   * For the package and owned elements, calculates the map of
   * applied stereotypes to elements grouped by profile.
   * That is, aggregate the results of querying `e.getAppliedStereotypes`
   * for all elements `e` in scope of the package, including the package itself.
   * The aggregation is a maps a profile to a map associating pairs of
   * stereotypes / metaclass properties defined in that profile to
   * the set of elements on which the stereotype is applied.
   */
  def allAppliedStereotypesByProfile: Map[Option[UMLProfile[Uml]], Map[( UMLStereotype[Uml], UMLProperty[Uml] ), Set[UMLElement[Uml]]]] = {

    val pkgContents = ( self +: allOwnedElements ).toSet[UMLElement[Uml]]
    val tuples = pkgContents flatMap { e =>
      val pf2spMap = e.getAppliedStereotypes groupBy ( _._1.profile )
      pf2spMap flatMap { case ( pf, sps ) => sps map { case ( s, p ) => ( pf, s, p, e ) } }
    }

    val appliedStereotypesByProfile = tuples.groupBy( _._1 ).map {
      case ( pf, v ) =>
        val speTuples = v.map { case ( _, s, p, e ) => ( ( s, p ), e ) }
        val sp2speMap = speTuples.groupBy( _._1 )
        val sp2es = sp2speMap.map { case ( sp, speSet ) => ( sp, speSet.map( _._2 ) ) }
        ( pf -> sp2es )
    }

    appliedStereotypesByProfile
  }

  def allForwardReferencesToImportablePackageableElementsFromAllOwnedElementsTransitively: Set[UMLPackageableElement[Uml]] =
    ( Stream( this ) ++ allOwnedElements ) flatMap
      ( ( e ) => Set( e ) ++ e.compositeReferencesFromStereotypeTagPropertyValues ) flatMap
      ( ( e ) => Set( e ) ++ e.allForwardReferencesToElements ) flatMap
      ( _.allForwardReferencesToImportablePackageableElements ) filter ( !this.isAncestorOf( _ ) ) toSet

  /**
   * Find the packages or profiles that own the elements referenced from the packaged elements of this package.
   * This does not include references from elements in nested packages.
   */
  def forwardReferencesToPackagesOrProfiles: Try[Set[UMLPackage[Uml]]] =
    forwardReferencesBeyondPackageScope match {
    case Failure( t ) => Failure( t )
    case Success( triples ) =>
      val ps = triples map 
      (_.obj) flatMap
      (getPackageOrProfileOwner(_))
      Success( ps )
  }

  def forwardReferencesBeyondPackageScope: Try[Set[RelationTriple[Uml]]] = {

    val scope = self.allOwnedElementsWithinPackageScope
    
    val visited = scala.collection.mutable.HashSet[UMLElement[Uml]]( self )

    @annotation.tailrec def followReferencesUntilPackageScopeBoundary(
      acc: Set[RelationTriple[Uml]],
      triples: Try[Set[RelationTriple[Uml]]] ): Try[Set[RelationTriple[Uml]]] =
      triples match {
        case Failure( t ) => Failure( t )
        case Success( ts ) =>
          if ( ts.isEmpty ) Success( acc )
          else {
            val ( th, tr: Set[RelationTriple[Uml]] ) = ( ts.head, ts.tail )
            if ( visited.contains( th.obj ) )
              followReferencesUntilPackageScopeBoundary(
                acc,
                Success( tr ) )
            else {
              visited += th.sub
              if ( scope.contains( th.obj ) )
                th.obj.forwardRelationTriples match {
                  case Failure( t ) => Failure( t )
                  case Success( nextTriples: Set[RelationTriple[Uml]] ) =>
                    followReferencesUntilPackageScopeBoundary(
                      acc,
                      Success( nextTriples ++ tr ) )
                }
              else
                followReferencesUntilPackageScopeBoundary(
                  acc + th,
                  Success( tr ) )
            }
          }
      }

    val triples0: Try[Set[RelationTriple[Uml]]] = Success( Set() )
    val triplesN: Try[Set[RelationTriple[Uml]]] = ( triples0 /: scope ) {
      case ( Failure( t ), _ )   => Failure( t )
      case ( Success( acc ), e ) => followReferencesUntilPackageScopeBoundary( acc, e.forwardRelationTriples )
    }
    triplesN
  }

  // [/protected]
}
