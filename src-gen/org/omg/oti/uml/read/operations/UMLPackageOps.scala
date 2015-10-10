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

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.xmi.IDGenerator
import scala.language.postfixOps
import scala.annotation
import scala.Boolean
import scala.{Option, None, Some}
import scala.Predef.{Set => _, Map => _,_}
import scala.collection.immutable._
import scala.collection.Iterable
import scalaz._, Scalaz._

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
   * Find the unique OTI::SpecificationRootCharacterizedPackage-stereotype Comment that annotates this package
   *
   * @return If unique, the OTI::SpecificationRootCharacterizedPackage-stereotype Comment that annotates this package
   */
  def getSpecificationRootAnnotatingComment
  : ValidationNel[UMLError[Uml]#UException, Option[UMLComment[Uml]]] = {
    val c0: ValidationNel[UMLError[Uml]#UException, Seq[UMLComment[Uml]]] = Seq().success
    val cN = (c0 /: annotatedElement_comment) { (ci, c) =>
      ci.fold[ValidationNel[UMLError[Uml]#UException, Seq[UMLComment[Uml]]]](
        fail = Validation.failure(_),
        succ = (_ci) =>
          c.getSpecificationRootCharacterizedPackage.map { _p =>
            if (_p.contains(self))
              _ci :+ c
            else
              _ci
          })
      }
    cN.map { cs =>
      if (1 == cs.size)
        cs.headOption
      else
        None
    }
  }

  /**
   * Get the value of an OTI SpecificationRoot or SpecificationRootCharacterization
   * attribute property for this package
   *
   * An OTI SpecificationRoot attribute property can be specified as a tag value on
   * the OTI::SpecificationRoot stereotype applied to the package or as a tag value
   * on an OTI::SpecificationRootCharacterization stereotype applied to a comment
   * that annotates this package
   *
   * @param pf A function to retrieve the value of the OTI SpecificationRoot stereotype property
   *           when the OTI::SpecificationRoot stereotype is applied to the package
   * @param cf A function to retrieve the value of the OTI SpecificationRootCharacterization stereotype property
   *           when the OTI::SpecificationRootCharacterization stereotype is applied to a comment
   *           that uniquely annotates this package
   * @param otiCharacterizations If provided, a map of OTI::SpecificationRootCharacterization stereotyped
   *                             comment annotations for specific packages to bypass a global lookup
   *                             for unique comment annotations of the package
   * @tparam V The type of the OTI SpecificationRoot or SpecificationRootCharacterization attribute property
   * @return The value of the OTI SpecificationRoot or SpecificationRootCharacterization attribute property
   *         if available
   */
  def oti_attributeValue[V]
  (pf: UMLPackage[Uml] => ValidationNel[UMLError[Uml]#UException, Option[V]],
   cf: UMLComment[Uml] => ValidationNel[UMLError[Uml]#UException, Option[V]])
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[V]] =
  pf(self)
    .fold[ValidationNel[UMLError[Uml]#UException, Option[V]]](
    fail = Validation.failure(_),
    succ = (opf) =>
      opf
      .fold[ValidationNel[UMLError[Uml]#UException, Option[V]]](None.success){ _opf =>
        otiCharacterizations
        .fold[ValidationNel[UMLError[Uml]#UException, Option[V]]](
          self
          .getSpecificationRootAnnotatingComment
          .flatMap { c =>
            c.fold[ValidationNel[UMLError[Uml]#UException, Option[V]]](None.success){ _c =>
              cf(_c)
            }
          }
        ){ p2c =>
            p2c
            .get(self)
            .fold[ValidationNel[UMLError[Uml]#UException, Option[V]]](None.success){ _c =>
              cf(_c)
            }
          }
        })


  def oti_packageURI
  ()
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[String]] =
    for {
      oti_packageURI <- OTI_SPECIFICATION_ROOT_packageURI
      oti_ch_packageURI <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_packageURI
      result <- oti_attributeValue[String](
          pf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_packageURI) } yield vs.headOption,
          cf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_ch_packageURI) } yield vs.headOption
        )
    } yield result

  def oti_documentURL
  ()
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[String]] =
    for {
      oti_documentURL <- OTI_SPECIFICATION_ROOT_documentURL
      oti_ch_documentURL <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_documentURL
      result <- oti_attributeValue[String](
        pf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_documentURL) } yield vs.headOption,
        cf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_ch_documentURL) } yield vs.headOption
      )
    } yield result

  def oti_nsPrefix
  ()
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[String]] =
    for {
      oti_nsPrefix <- OTI_SPECIFICATION_ROOT_nsPrefix
      oti_ch_nsPrefix <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_nsPrefix
      result <- oti_attributeValue[String](
        pf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_nsPrefix) } yield vs.headOption,
        cf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_ch_nsPrefix) } yield vs.headOption
      )
    } yield result

  def oti_uuidPrefix
  ()
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[String]] =
    for {
      oti_uuidPrefix <- OTI_SPECIFICATION_ROOT_uuidPrefix
      oti_ch_uuidPrefix <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_uuidPrefix
      result <- oti_attributeValue[String](
        pf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_uuidPrefix) } yield vs.headOption,
        cf = (x) => for { vs <- x.getStereotypeTagPropertyStringValues(oti_ch_uuidPrefix) } yield vs.headOption
      )
    } yield result

  def oti_artifactKind
  ()
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[UMLEnumerationLiteral[Uml]]] =
    for {
      oti_artifactKind <- OTI_SPECIFICATION_ROOT_artifactKind
      oti_ch_artifactKind <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_artifactKind
      result <- oti_attributeValue[UMLEnumerationLiteral[Uml]](
        pf = (x) => for { vs <- x.getStereotypeTagPropertyEnumValues(oti_artifactKind) } yield vs.headOption,
        cf = (x) => for { vs <- x.getStereotypeTagPropertyEnumValues(oti_ch_artifactKind) } yield vs.headOption
      )
    } yield result


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
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[String]] =
    oti_documentURL.fold[ValidationNel[UMLError[Uml]#UException, Option[String]]](
      fail=Validation.failure(_),
      succ=_.fold[ValidationNel[UMLError[Uml]#UException, Option[String]]]{
        getEffectiveURI.fold[ValidationNel[UMLError[Uml]#UException, Option[String]]](
        fail = Validation.failure(_),
        succ = _.fold[ValidationNel[UMLError[Uml]#UException, Option[String]]](None.success){ uri =>
            if (uri.endsWith(".xmi"))
              Some(uri).success
            else
              Some(uri + ".xmi").success
              })
    }{ url =>
        Some(url).success
    })

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
  (implicit otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]])
  : ValidationNel[UMLError[Uml]#UException, Option[String]] =
    oti_packageURI
    .orElse {
      self.URI.success
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
  : ValidationNel[UMLError[Uml]#UException, UMLStereotypedElementsByAppliedProfile] = {

    type PF_S_P_E = (Option[UMLProfile[Uml]], UMLStereotype[Uml], UMLProperty[Uml], UMLElement[Uml])

    val pkgContents: Set[UMLElement[Uml]] = allOwnedElements + self
    val t0: ValidationNel[UMLError[Uml]#UException, Set[PF_S_P_E]] = Set().success
    val tn: ValidationNel[UMLError[Uml]#UException, Set[PF_S_P_E]] = ( t0 /: pkgContents ) { ( ti, e) =>
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
  : ValidationNel[UMLError[Uml]#UException, Set[UMLPackageableElement[Uml]]] = {
    val pkgContents: Set[UMLElement[Uml]] = allOwnedElements + self

    val a0: ValidationNel[UMLError[Uml]#UException, Set[UMLElement[Uml]]] = Set().success
    val aN: ValidationNel[UMLError[Uml]#UException, Set[UMLElement[Uml]]] = (a0 /: pkgContents) {
      (ai, e) =>
        (ai |@| e.allForwardReferencesFromStereotypeTagProperties) { (_ai, eRefs) =>
          _ai ++ Set(e) ++ eRefs
        }
      }

    val result =
      aN.flatMap { refs =>

      val b0: ValidationNel[UMLError[Uml]#UException, Set[UMLElement[Uml]]] = Set().success
      val bN: ValidationNel[UMLError[Uml]#UException, Set[UMLElement[Uml]]] = (b0 /: refs) {
        (bi, e) =>
          (bi |@| e.allForwardReferencesToElements) { (_bi, eRefs) =>
            _bi ++ Set(e) ++ eRefs
          }
      }

      bN.flatMap { refs =>

        val c0: ValidationNel[UMLError[Uml]#UException, Set[UMLPackageableElement[Uml]]] = Set().success
        val cN: ValidationNel[UMLError[Uml]#UException, Set[UMLPackageableElement[Uml]]] = (c0 /: refs) {
        (ci, e) =>
          (ci |@| e.allForwardReferencesToImportablePackageableElements) { (_ci, peRefs) =>
            _ci ++ peRefs.filter(!this.isAncestorOf(_))
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
  : ValidationNel[UMLError[Uml]#UException, Set[UMLPackage[Uml]]] =
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
  : ValidationNel[UMLError[Uml]#UException, Set[RelationTriple[Uml]]] = {

    val scope = self.allOwnedElementsWithinPackageScope

    val visited = scala.collection.mutable.HashSet[UMLElement[Uml]]( self )

    @annotation.tailrec def followReferencesUntilPackageScopeBoundary
    ( acc: Set[RelationTriple[Uml]],
      triples: Set[RelationTriple[Uml]])
    : ValidationNel[UMLError[Uml]#UException, Set[RelationTriple[Uml]]] =
      if (triples.isEmpty)
        acc.success
      else {
        val (th, tr: Set[RelationTriple[Uml]]) = (triples.head, triples.tail)
        if (visited.contains(th.obj))
          followReferencesUntilPackageScopeBoundary(acc, tr)
        else {
          visited += th.sub;
          ()
          if (scope.contains(th.obj))
            th.obj.forwardRelationTriples.flatMap {
              nextTriples: Set[RelationTriple[Uml]] =>
                followReferencesUntilPackageScopeBoundary(acc, nextTriples ++ tr)
            }
          else
            followReferencesUntilPackageScopeBoundary(acc + th, tr)
        }
      }

    val triples0: ValidationNel[UMLError[Uml]#UException, Set[RelationTriple[Uml]]] = Set().success
    val triplesN: ValidationNel[UMLError[Uml]#UException, Set[RelationTriple[Uml]]] = ( triples0 /: scope ) {
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
