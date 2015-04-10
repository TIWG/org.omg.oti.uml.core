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

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
import scala.util.Try
import scala.util.Success
import scala.util.Failure
// End of user code

/**
 * <!-- begin-model-doc -->
 * A package can have one or more profile applications to indicate which profiles have been applied. Because a profile is a package, it is possible to apply a profile not only to packages, but also to profiles.
Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.
A package is used to group elements, and provides a namespace for the grouped elements.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLPackageOps[Uml <: UML] { self: UMLPackage[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * References the packaged elements that are Packages.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackage.nestingPackage
	 * @body result = (packagedElement->select(oclIsKindOf(Package))->collect(oclAsType(Package))->asSet())
	 */
	def nestedPackage: Set[UMLPackage[Uml]] = packagedElement.selectByKindOf { case x: UMLPackage[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * References the Package that owns this Package.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLPackage.nestedPackage
	 */
	def nestingPackage: Option[UMLPackage[Uml]] = packagedElement_owningPackage

	/**
	 * <!-- begin-model-doc -->
	 * References the Stereotypes that are owned by the Package.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStereotype.ownedStereotype_owningPackage
	 * @body result = (packagedElement->select(oclIsKindOf(Stereotype))->collect(oclAsType(Stereotype))->asSet())
	 */
	def ownedStereotype: Set[UMLStereotype[Uml]] = ownedType.selectByKindOf { case x: UMLStereotype[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * References the packaged elements that are Types.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLType._package
	 * @body result = (packagedElement->select(oclIsKindOf(Type))->collect(oclAsType(Type))->asSet())
	 */
	def ownedType: Set[UMLType[Uml]] = packagedElement.selectByKindOf { case x: UMLType[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * References the PackageMerges that are owned by this Package.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackageMerge.receivingPackage
	 */
	def packageMerge: Set[UMLPackageMerge[Uml]] = ownedElement.selectByKindOf { case x: UMLPackageMerge[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * References the ProfileApplications that indicate which profiles have been applied to the Package.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLProfileApplication.applyingPackage
	 */
	def profileApplication: Set[UMLProfileApplication[Uml]] = ownedElement.selectByKindOf { case x: UMLProfileApplication[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackageImport.importedPackage
	 */
	def importedPackage_packageImport: Set[UMLPackageImport[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLPackageImport[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLPackageMerge.mergedPackage
	 */
	def mergedPackage_packageMerge: Set[UMLPackageMerge[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLPackageMerge[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query allApplicableStereotypes() returns all the directly or indirectly owned stereotypes, including stereotypes contained in sub-profiles.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (let ownedPackages : Bag(Package) = ownedMember->select(oclIsKindOf(Package))->collect(oclAsType(Package)) in
	 *  ownedStereotype->union(ownedPackages.allApplicableStereotypes())->flatten()->asSet()
	 * )
	 */
	def allApplicableStereotypes: Set[UMLStereotype[Uml]]  = {
		// Start of user code for "allApplicableStereotypes"
      allOwnedElements.selectByKindOf { case s: UMLStereotype[Uml] => s } toSet
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query containingProfile() returns the closest profile directly or indirectly containing this package (or this package itself, if it is a profile).
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..1"
	 * @body result = (if self.oclIsKindOf(Profile) then 
	 * 	self.oclAsType(Profile)
	 * else
	 * 	self.namespace.oclAsType(Package).containingProfile()
	 * endif)
	 */
	def containingProfile: Option[UMLProfile[Uml]]  = {
		// Start of user code for "containingProfile"
      self match {
        case pf: UMLProfile[Uml] =>
          Some( pf )
    
        case _ =>
          for {
            parent <- nestingPackage
            pf <- parent.containingProfile
          } yield pf
      }
      // End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query mustBeOwned() indicates whether elements of this type must have an owner.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (false)
	 */
	override def mustBeOwned: Boolean  = {
		// Start of user code for "mustBeOwned"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * If an element that is owned by a package has visibility, it is public or private.
	 * <!-- end-model-doc -->
	 *
	 * @body packagedElement->forAll(e | e.visibility<> null implies e.visibility = VisibilityKind::public or e.visibility = VisibilityKind::private)
	 */
	def validate_elements_public_or_private: Boolean  = {
		// Start of user code for "elements_public_or_private"
    	???
    	// End of user code
	}

	// Start of user code for additional features

  def nonImportedNestedPackages: Set[UMLPackage[Uml]] = nestedPackage -- importedPackages

  def allNestedPackages: Set[UMLPackage[Uml]] = closure( self, ( ( p: UMLPackage[Uml] ) => p.nestedPackage ) )

  /**
   * All packages that are owned within the reflexive transitive closure of ownership from this package
   * 
   * Note: allNestedPackages should always be a proper subset of allPackagesWithinScope.
   * The difference, allPackagesWithinScope - allNestedPackages, is precisely:
   * - the package itself
   * - all packages directly or indireclty owned by any component in the ownership scope of the package itself
   */
  def allPackagesWithinScope: Set[UMLPackage[Uml]] =
    (allOwnedElements selectByKindOf { case p: UMLPackage[Uml] => p } toSet) + self
    
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
   * The OTI::SpecificationRoot::documentURL stereotype property, if applied.
   */
  def getDocumentURL: Option[String] =
    if ( OTI_SPECIFICATION_ROOT_S.isDefined && OTI_SPECIFICATION_ROOT_documentURL.isDefined )
      self.tagValues.get( OTI_SPECIFICATION_ROOT_documentURL.get ) match {
        case Some( Seq( url: UMLLiteralString[_] ) ) if ( url.value.isDefined ) =>
          url.value            
        case _ =>
          URI match {
            case Some(x) => Option.apply(x+".xmi")
            case None => None
          }
      }
    else
      URI match {
        case Some(x) => Option.apply(x+".xmi")
        case None => None
      }

    
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

    val pkgContents = ( allOwnedElements + self )
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

  /**
    * The RelationTriples characterizing the package boundary.
    * The subject of each relation triple is an element inside the ownership scope of the package.
    * The object of each relation triple is an element outside the ownership scope of the package.
    * The property of each relation triple is either a metamodel association or a stereotype property.
    */
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

  // End of user code

} //UMLPackage
