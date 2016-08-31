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

import org.omg.oti.json.common.OTIPrimitiveTypes._
import org.omg.oti.json.common.{OTIArtifactKind, OTISpecificationRootCharacteristics}
import org.omg.oti.uml._
import org.omg.oti.uml.characteristics._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator

import scala.language.postfixOps
import scala.{Boolean, None, Option, Some}
import scala.Predef.{Map => _, Set => _, _}
import scala.collection.immutable._
import scala.collection.Iterable
import scalaz._
import Scalaz._

// End of user code

/**
  * A package can have one or more profile applications to indicate which profiles have been applied. Because a profile is a package, it is possible to apply a profile not only to packages, but also to profiles.Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.A package is used to group elements, and provides a namespace for the grouped elements.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLPackageOps[Uml <: UML] { self: UMLPackage[Uml] =>

// Start of user code for class imports

  import self.ops._
  import Option._
  import Iterable._
  import Traversable._

  // End of user code


  /**
    * References the packaged elements that are Packages.
    *
    * <!-- Start of user code doc for nestedPackage -->
    * <!-- End of user code doc for nestedPackage -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackage.nestingPackage
    * {{{
    * OCL Body result = (packagedElement->select(oclIsKindOf(Package))->collect(oclAsType(Package))->asSet())
    * }}}
    */
  def nestedPackage: Set[UMLPackage[Uml]] = {
    // Start of user code for "nestedPackage"
    packagedElement
    .selectByKindOf { case x: UMLPackage[Uml] => x }
    // End of user code
  }

  /**
    * References the Stereotypes that are owned by the Package.
    *
    * <!-- Start of user code doc for ownedStereotype -->
    * <!-- End of user code doc for ownedStereotype -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStereotype.ownedStereotype_owningPackage
    * {{{
    * OCL Body result = (packagedElement->select(oclIsKindOf(Stereotype))->collect(oclAsType(Stereotype))->asSet())
    * }}}
    */
  def ownedStereotype: Set[UMLStereotype[Uml]] = packagedElement.selectByKindOf { case x: UMLStereotype[Uml] => x }

  /**
    * References the packaged elements that are Types.
    *
    * <!-- Start of user code doc for ownedType -->
    * <!-- End of user code doc for ownedType -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLType._package
    * {{{
    * OCL Body result = (packagedElement->select(oclIsKindOf(Type))->collect(oclAsType(Type))->asSet())
    * }}}
    */
  def ownedType: Set[UMLType[Uml]] = {
    // Start of user code for "ownedType"
    packagedElement
    .selectByKindOf { case x: UMLType[Uml] => x }
    // End of user code
  }

  /**
    * References the PackageMerges that are owned by this Package.
    *
    * <!-- Start of user code doc for packageMerge -->
    * <!-- End of user code doc for packageMerge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageMerge.receivingPackage
    */
  def packageMerge: Set[UMLPackageMerge[Uml]] = ownedElement.selectByKindOf { case x: UMLPackageMerge[Uml] => x }

  /**
    * References the ProfileApplications that indicate which profiles have been applied to the Package.
    *
    * <!-- Start of user code doc for profileApplication -->
    * <!-- End of user code doc for profileApplication -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProfileApplication.applyingPackage
    */
  def profileApplication: Set[UMLProfileApplication[Uml]] = ownedElement.selectByKindOf { case x: UMLProfileApplication[Uml] => x }

  /**
    * <!-- Start of user code doc for importedPackage_packageImport -->
    * <!-- End of user code doc for importedPackage_packageImport -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageImport.importedPackage
    */
  def importedPackage_packageImport: Set[UMLPackageImport[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLPackageImport[Uml] => x }

  /**
    * <!-- Start of user code doc for mergedPackage_packageMerge -->
    * <!-- End of user code doc for mergedPackage_packageMerge -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLPackageMerge.mergedPackage
    */
  def mergedPackage_packageMerge: Set[UMLPackageMerge[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLPackageMerge[Uml] => x }

  /**
    * The query allApplicableStereotypes() returns all the directly or indirectly owned stereotypes, including stereotypes contained in sub-profiles.
    *
    * <!-- Start of user code doc for allApplicableStereotypes -->
    * <!-- End of user code doc for allApplicableStereotypes -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (let ownedPackages : Bag(Package) = ownedMember->select(oclIsKindOf(Package))->collect(oclAsType(Package)) in
    *  ownedStereotype->union(ownedPackages.allApplicableStereotypes())->flatten()->asSet()
    * )
    * }}}
    */
  def allApplicableStereotypes: Set[UMLStereotype[Uml]] = {
    // Start of user code for "allApplicableStereotypes"
    allOwnedElements
    .selectByKindOf { case s: UMLStereotype[Uml] => s } toSet
    // End of user code
  }

  /**
    * The query containingProfile() returns the closest profile directly or indirectly containing this package (or this package itself, if it is a profile).
    *
    * <!-- Start of user code doc for containingProfile -->
    * <!-- End of user code doc for containingProfile -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (if self.oclIsKindOf(Profile) then 
    * 	self.oclAsType(Profile)
    * else
    * 	self.namespace.oclAsType(Package).containingProfile()
    * endif)
    * }}}
    */
  def containingProfile: Option[UMLProfile[Uml]] = {
    // Start of user code for "containingProfile"
    self match {
      case pf: UMLProfile[Uml] =>
        Some(pf)

      case _ =>
        for {
          parent <- nestingPackage
          pf <- parent.containingProfile
        } yield pf
    }
    // End of user code
  }

  /**
    * The query mustBeOwned() indicates whether elements of this type must have an owner.
    *
    * <!-- Start of user code doc for mustBeOwned -->
    * <!-- End of user code doc for mustBeOwned -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (false)
    * }}}
    */
  override def mustBeOwned: Boolean = {
    // Start of user code for "mustBeOwned"
    false
    // End of user code
  }

  /**
    * If an element that is owned by a package has visibility, it is public or private.
    *
    * <!-- Start of user code doc for validate_elements_public_or_private -->
    * <!-- End of user code doc for validate_elements_public_or_private -->
    *
    * {{{
    * OCL Body packagedElement->forAll(e | e.visibility<> null implies e.visibility = VisibilityKind::public or e.visibility = VisibilityKind::private)
    * }}}
    */
  def validate_elements_public_or_private: Boolean = {
    // Start of user code for "elements_public_or_private"
    packagedElement
    .forall {
      pe =>
        pe.visibility match {
          case None => true
          case Some(UMLVisibilityKind.public) => true
          case Some(UMLVisibilityKind._private) => true
          case _ => false
        }

    }
    // End of user code
  }

  // Start of user code for additional features

  /**
    * ignoring errors, is this package representing the root of an OTI document artifact?
    *
    * @return True iff the <<OTI::SpecificationRoot>> stereotype is applied
    */
  def hasSpecificationRootCharacteristics
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Boolean =
    getSpecificationRootCharacteristics
    .getOrElse(Option.empty[OTISpecificationRootCharacteristics])
    .isDefined

  def getSpecificationRootCharacteristics
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[OTISpecificationRootCharacteristics] =
    otiCharacteristicsProvider.getSpecificationRootCharacteristics(self)

  def oti_packageURI
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URI] =
    otiCharacteristicsProvider.packageURI(self)

  def oti_documentURL
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URL] =
    otiCharacteristicsProvider.documentURL(self)

  def oti_nsPrefix
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_NS_PREFIX] =
    otiCharacteristicsProvider.nsPrefix(self)

  def oti_uuidPrefix
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_UUID_PREFIX] =
    otiCharacteristicsProvider.uuidPrefix(self)

  def oti_artifactKind
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[OTIArtifactKind] =
    otiCharacteristicsProvider.artifactKind(self)

  def nonImportedNestedPackages: Set[UMLPackage[Uml]] = nestedPackage -- importedPackages

  def allNestedPackages: Set[UMLPackage[Uml]] = closure(self, (p: UMLPackage[Uml]) => p.nestedPackage)

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
    Set(self) ++ closure[UMLPackage[Uml], UMLPackage[Uml]]( self, _.packagedElement_owningPackage )

  /**
   * The direclty imported packages from the reflexive transitive closure of the owning package of a package.
   */
  def allDirectlyImportedPackagesIncludingNestingPackagesTransitively: Set[UMLPackage[Uml]] =
    allNestingPackagesTransitively.flatMap(_.importedPackages)

  /**
    * The OTI::SpecificationRoot::documentURL stereotype property, if applied;
    * otherwise, ".xmi" appended to the effective URI, if any;
    * otherwise, none
    */
  def getDocumentURL
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URL] =
    oti_documentURL
    .flatMap { ourl: Option[String @@ OTI_URL] =>
      ourl
      .fold[Set[java.lang.Throwable] \/ Option[String @@ OTI_URL]](
        getEffectiveURI
        .flatMap { ouri: Option[String @@ OTI_URI] =>
          ouri
          .fold[Set[java.lang.Throwable] \/ Option[String @@ OTI_URL]](
            Option.empty[String @@ OTI_URL].right
          ) { uri: String @@ OTI_URI =>
            val _uri = OTI_URI.unwrap(uri)
            if (_uri.endsWith(".xmi"))
              OTI_URL(_uri).some.right
            else
              OTI_URL(_uri + ".xmi").some.right
          }
        }
      ) { url: String @@ OTI_URL =>
        url.some.right
      }
    }

  /**
    * The URI for the package, if any; subject to being overriden by the OTI::SpecificationRoot stereotype, if applied.
    *
    * @return In decreasing order of priority:
    *         - the value of the tag property OTI::SpecificationRoot::packageURI,
    *         if any and the OTI::SpecificationRoot stereotype is applied
    *         - the value of the Package::URI, if any
    *         - none, otherwise
    */
  def getEffectiveURI
  ()
  (implicit otiCharacteristicsProvider: OTICharacteristicsProvider[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URI] =
    oti_packageURI
    .map {
      ouri =>
      ouri.orElse {
        self.URI.map(_.trim).map(OTI_URI.apply)
      }
    }

  /**
    * OMG Issue UML 2.5, 12.3.3 ProfileApplication, Semantics is incomplete.
    * OTI uses the following semantics:
    * Applying a profile PF to a package P implies applying PF to all nested packages of P. 
    * For a given package P, the set of all profile applications is the union of the profile applications
    * of P and of all of its nesting packages recursively.
    */
  def allDirectProfileApplicationsIncludingNestingPackagesTransitively
  : Set[UMLProfileApplication[Uml]] =
    allNestingPackagesTransitively.flatMap(_.profileApplication)

  def allDirectlyAppliedProfilesExceptNestingPackages
  : Set[UMLProfile[Uml]] =
    profileApplication.flatMap(_.appliedProfile)

  def allDirectlyAppliedProfilesIncludingNestingPackagesTransitively
  : Set[UMLProfile[Uml]] =
    allDirectProfileApplicationsIncludingNestingPackagesTransitively.flatMap(_.appliedProfile)

  def allDirectlyVisibleMembersTransitivelyAccessibleExceptNestingPackagesAndAppliedProfiles
  : Set[UMLPackageableElement[Uml]] =
    allVisibleMembersAccessibleTransitively ++
    allDirectlyAppliedProfilesExceptNestingPackages.flatMap(_.allVisibleMembersTransitively)

  /**
    * Calculates the set of all profiles directly or indirectly applied to the package.
    *
    * @see UML 2.5, section 12.3.3, ProfileApplication, 2nd paragraph:
    *      Applying a Profile means recursively applying all its nested and imported Profiles.
    *
    * @see UML 2.5, section 12.3.3, Profile, Integrating & Extending Profiles, 3rd paragraph:
    *      Normal rules apply as to whether a referenced Stereotype is visible to users of the extending Profile:
    *      a public import is needed to ensure that Stereotypes from other profiles are
    *      visible after applying the extending one.
    */
  def allIndirectlyAppliedProfilesIncludingNestingPackagesTransitively
  : Set[UMLProfile[Uml]] =
    allDirectlyAppliedProfilesIncludingNestingPackagesTransitively ++
    allDirectlyAppliedProfilesIncludingNestingPackagesTransitively.flatMap(_.allVisibleProfilesTransitively)

  /**
    * For a Package, allIndirectlyVisibleMembersTransitivelyAccessibleFromNestingPackagesAndAppliedProfiles is
    * the union of all visible members that are transitively accessible from outer namespaces or from applied profiles.
    */
  def allIndirectlyVisibleMembersTransitivelyAccessibleFromNestingPackagesAndAppliedProfiles
  : Set[UMLPackageableElement[Uml]] =
    allVisibleMembersAccessibleTransitively ++
    allIndirectlyAppliedProfilesIncludingNestingPackagesTransitively.flatMap(_.allVisibleMembersTransitively)

  type UMLStereotypeBaseProperty = (UMLStereotype[Uml], UMLProperty[Uml])
  type UMLExtendedElementsByAppliedStereotypes = Map[UMLStereotypeBaseProperty, Set[UMLElement[Uml]]]
  type UMLStereotypedElementsByAppliedProfile = Map[Option[UMLProfile[Uml]], UMLExtendedElementsByAppliedStereotypes]

  /**
    * For the package and owned elements, calculates the map of
    * applied stereotypes to elements grouped by profile.
    * That is, aggregate the results of querying `e.getAppliedStereotypes`
    * for all elements `e` in scope of the package, including the package itself.
    * The aggregation is a maps a profile to a map associating pairs of
    * stereotypes / metaclass properties defined in that profile to
    * the set of elements on which the stereotype is applied.
    */
  def allAppliedStereotypesByProfile
  : Set[java.lang.Throwable] \/ UMLStereotypedElementsByAppliedProfile = {

    type PF_S_P_E = (Option[UMLProfile[Uml]], UMLStereotype[Uml], UMLProperty[Uml], UMLElement[Uml])

    val pkgContents: Set[UMLElement[Uml]] = allOwnedElements + self
    val t0: Set[java.lang.Throwable] \/ Set[PF_S_P_E] = Set().right
    val tn: Set[java.lang.Throwable] \/ Set[PF_S_P_E] = ( t0 /: pkgContents ) { ( ti, e) =>
      (ti |@| e.getAppliedStereotypes) { (_ti, _appliedStereotypes) =>
        val pf2spMap = _appliedStereotypes groupBy (_._1.profile)
        val tuples = pf2spMap flatMap { case (pf, sps) => sps map { case (s, p) => (pf, s, p, e) } }
        _ti ++ tuples.to[Set]
      }
    }

    val appliedStereotypesByProfile = for {
      tuples <- tn
    } yield tuples.groupBy(_._1).map {
        case (pf, v) =>
          val speTuples = v.map {
            case (_, s, p, e) =>
              ((s, p), e)
          }
          val sp2speMap = speTuples.groupBy(_._1)
          val sp2es =
            sp2speMap.map {
              case (sp, speSet) =>
                (sp, speSet.map(_._2))
            }
          (pf -> sp2es)
      }

    appliedStereotypesByProfile
  }

  /**
    * @todo simplify this scalaz code!
    *
    *       The non-validation version was concise:
    *       (Stream(this) ++ allOwnedElements) flatMap
    *       ((e) => Set(e) ++ e.allForwardReferencesFromStereotypeTagProperties) flatMap
    *       ((e) => Set(e) ++ e.allForwardReferencesToElements) flatMap
    *       (_.allForwardReferencesToImportablePackageableElements) filter (!this.isAncestorOf(_)) toSet
    *
    * @return all forward references from the contents of this package to outside importable packageable elements
    */
  def allForwardReferencesToImportablePackageableElementsFromAllOwnedElementsTransitively
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] = {
    val pkgContents: Set[UMLElement[Uml]] = allOwnedElements + self

    val a0: Set[java.lang.Throwable] \/ Set[UMLElement[Uml]] = Set().right
    val aN: Set[java.lang.Throwable] \/ Set[UMLElement[Uml]] = (a0 /: pkgContents) {
      (ai, e) =>
        (ai |@| e.allForwardReferencesFromStereotypeTagProperties) { (_ai, eRefs) =>
          _ai ++ Set(e) ++ eRefs
        }
      }

    val result =
      aN.flatMap { refs =>

      val b0: Set[java.lang.Throwable] \/ Set[UMLElement[Uml]] = Set().right
      val bN: Set[java.lang.Throwable] \/ Set[UMLElement[Uml]] = (b0 /: refs) {
        (bi, e) =>
          (bi |@| e.allForwardReferencesToElements) { (_bi, eRefs) =>
            _bi ++ Set(e) ++ eRefs
          }
      }

      bN.flatMap { refs =>

        val c0: Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] = Set().right
        val cN: Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] = (c0 /: refs) {
          (ci, e) =>
            e.allForwardReferencesToImportablePackageableElements.flatMap { peRefs =>
              val r0: Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] = ci
              val rN: Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]] = (r0 /: peRefs) {
                (ri, peRef) =>
                  ri +++ (this.isAncestorOf(peRef).map(within => if (within) Set() else Set(peRef)))
              }
              rN
            }
        }
        cN
      }
    }

    result
  }


  /**
    * Find the packages or profiles that own the elements referenced from the packaged elements of this package.
    * This does not include references from elements in nested packages.
    */
  def forwardReferencesToPackagesOrProfiles
  ()
  (implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ Set[UMLPackage[Uml]] =
    forwardReferencesBeyondPackageScope.map { triples =>
      triples.map(_.obj).flatMap(getPackageOrProfileOwner(_))
    }

  /**
    * The RelationTriples characterizing the package boundary.
    * The subject of each relation triple is an element inside the ownership scope of the package.
    * The object of each relation triple is an element outside the ownership scope of the package.
    * The property of each relation triple is either a metamodel association or a stereotype property.
    */
  def forwardReferencesBeyondPackageScope
  ()
  (implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]] = {

    val scope = self.allOwnedElements

    val visited = scala.collection.mutable.HashSet[UMLElement[Uml]]( self )

    /* @annotation.tailrec */ def followReferencesUntilPackageScopeBoundary
    ( acc: Set[RelationTriple[Uml]],
      triples: Set[RelationTriple[Uml]])
    : Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]] =
      if (triples.isEmpty)
        acc.right
      else {
        val (th, tr: Set[RelationTriple[Uml]]) = (triples.head, triples.tail)
        val ref = th.obj
        if (visited.contains(ref))
          followReferencesUntilPackageScopeBoundary(acc, tr)
        else {
          visited += ref
          if (scope.contains(ref))
            ref.forwardRelationTriples.flatMap {
              nextTriples: Set[RelationTriple[Uml]] =>
                followReferencesUntilPackageScopeBoundary(acc, nextTriples ++ tr)
            }
          else
            followReferencesUntilPackageScopeBoundary(acc + th, tr)
        }
      }

    val triples0: Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]] = Set().right
    val triplesN: Set[java.lang.Throwable] \/ Set[RelationTriple[Uml]] = ( triples0 /: scope ) {
      ( ti, e ) =>

      for {
        _ti <- ti
        _triples <- e.forwardRelationTriples
        _more <- followReferencesUntilPackageScopeBoundary( _ti, _triples )
      } yield _more
    }

    triplesN
  }

  // End of user code
} //UMLPackageOps
