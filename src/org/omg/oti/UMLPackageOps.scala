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
package org.omg.oti

import scala.language.postfixOps

trait UMLPackageOps[Uml <: UML] { self: UMLPackage[Uml] =>

  import self.ops._

  // [protected (TIWG)]

  def nonImportedNestedPackages: Set[UMLPackage[Uml]] = nestedPackages -- importedPackages
  
  def allNestedPackages: Set[UMLPackage[Uml]] = closure( self, ((p:UMLPackage[Uml]) => p.nestedPackages))
  
  /**
   * The reflexive transitive closure of the owning package of a package.
   */
  def allNestingPackagesTransitively: Set[UMLPackage[Uml]] =
    Set( self ) ++ closure[UMLPackage[Uml], UMLPackage[Uml]]( self, ( _.owningPackage ) )

  /**
   * The direclty imported packages from the reflexive transitive closure of the owning package of a package.
   */
  def allDirectlyImportedPackagesIncludingNestingPackagesTransitively: Set[UMLPackage[Uml]] = 
    allNestingPackagesTransitively.flatMap (_.importedPackages)
  
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
    allNestingPackagesTransitively.flatMap( _.profileApplications )

  def allDirectlyAppliedProfilesExceptNestingPackages: Set[UMLProfile[Uml]] =
    profileApplications.flatMap(_.appliedProfile)
    
  def allDirectlyAppliedProfilesIncludingNestingPackagesTransitively: Set[UMLProfile[Uml]] =
    allDirectProfileApplicationsIncludingNestingPackagesTransitively.flatMap(_.appliedProfile)
    
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
    allDirectlyAppliedProfilesIncludingNestingPackagesTransitively.flatMap(_.allVisibleProfilesTransitively)
    
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
      (Stream(this) ++ allOwnedElements) flatMap
      ((e) => Set(e) ++ e.compositeReferencesFromStereotypeTagPropertyValues) flatMap
      ((e) => Set(e) ++ e.allForwardReferencesToElements) flatMap
      (_.allForwardReferencesToImportablePackageableElements) filter(!this.isAncestorOf(_)) toSet
  
  /**
   * @see UML 2.5 12.4, Package
   * visibleMembers() : PackageableElement [0..*]
   * The query visibleMembers() defines which members of a Package can be accessed outside it.
   * body: member->select( m | m.oclIsKindOf(PackageableElement) and self.makesVisible(m))- >collect(oclAsType(PackageableElement))->asSet()
   *
   * @see UMLNamespace
   */

  // [/protected]
}