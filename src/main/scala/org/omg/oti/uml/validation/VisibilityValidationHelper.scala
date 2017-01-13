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

package org.omg.oti.uml.validation

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{Boolean, Enumeration, Option, None, Some}
import scala.Predef.String
import scala.collection.immutable._
import scala.collection.Iterable

/**
 * The different categories of validation for the visibility & aliasing (where applicable)
 * of a [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]],
 * [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] or
 * [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]].
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 *
 *      [4] Core::Basic and EMOF does not support visibilities.
 *      All property visibilities must be explicitly set to public where applicable,
 *      that is for all [[org.omg.oti.uml.read.api.UMLNamedElement NamedElements]],
 *      [[org.omg.oti.uml.read.api.UMLElementImport ElementImports]] and
 *      [[org.omg.oti.uml.read.api.UMLPackageImport PackageImports]].
 *      Furthermore, no alias is allowed for any
 *      [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]].
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 *
 *      [7] CMOF does not support visibilities.
 *      All property visibilities must be explicitly set to public where applicable,
 *      that is for all [[org.omg.oti.uml.read.api.UMLNamedElement NamedElements]],
 *      [[org.omg.oti.uml.read.api.UMLElementImport ElementImports]] and
 *      [[org.omg.oti.uml.read.api.UMLPackageImport PackageImports]].
 *      Furthermore, no alias is allowed for any
 *      [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]].
 */
object VisibilityValidationStatus extends Enumeration {
  type VisibilityValidationStatus = Value

  /**
   * Valid per EMOF [4] and CMOF [7]
   */
  val ValidVisibilityStatus = Value

  /**
   * Invalid per EMOF [4] and CMOF [7]
   * A [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]],
   * [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] or
   * [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]] with non-public visibility
   * (repair strategy: set the visibility to public)
   */
  val MissingPublicVisibilityStatus = Value

  /**
   * Invalid per EMOF [4] and CMOF [7]
   * A [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]],
   * [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] or
   * [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]] with non-public visibility
   * (repair strategy: set the visibility to public)
   */
  val InvalidNonPublicVisibilityStatus = Value

  /**
   * Invalid per EMOF [4] and CMOF [7]
   * An [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] with an alias
   * (no repair strategy because deleting the alias would loose potentially important information)
   */
  val InvalidAliasedElementImportStatus = Value
}

import org.omg.oti.uml.validation.VisibilityValidationStatus._

/**
 * The common superclass of the different categories of visibility validation results.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
sealed abstract class AbstractVisibilityValidationInfo[Uml <: UML] {
  val e: UMLElement[Uml]
  val status: VisibilityValidationStatus
  val explanation: Option[String] = None

  import org.omg.oti.uml.validation.VisibilityValidationStatus._

  def isInvalid: Boolean =
    status != ValidVisibilityStatus

  /**
   * If invalid, is there a repair strategy?
   *
   * InvalidNonPublicVisibilityStatus is the only repairable violation (i.e., change visibilty to public)
   *
   * InvalidAliasedElementImportStatus is not repairable because deleting the alias could potentially
   * loose important information
   *
   * @return true only for MissingPublicVisibilityStatus or InvalidNonPublicVisibilityStatus
   */
  def isRepairable: Boolean =
    status == MissingPublicVisibilityStatus ||
    status == InvalidNonPublicVisibilityStatus
}

/**
 * Visibility validation result for a kind of [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]]
 *
 * @param e [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class NamedElementVisibilityValidationInfo[Uml <: UML]
(override val e: UMLNamedElement[Uml],
 override val status: VisibilityValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractVisibilityValidationInfo[Uml]

/**
 * Visibility validation result for an [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]]
 *
 * @param e [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class ElementImportVisibilityValidationInfo[Uml <: UML]
(override val e: UMLElementImport[Uml],
 override val status: VisibilityValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractVisibilityValidationInfo[Uml]

/**
 * Visibility validation result for a [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]]
 *
 * @param e [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class PackageImportVisibilityValidationInfo[Uml <: UML]
(override val e: UMLPackageImport[Uml],
 override val status: VisibilityValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractVisibilityValidationInfo[Uml]

/**
 * The different categories of validation for the visibility & aliasing (where applicable)
 * of a [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]],
 * [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] or
 * [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]].
 */
object VisibilityValidationHelper {

  val MISSING_PUBLIC_VISIBILITY =
    "A NamedElement that is not a kind of PackageableElement must have visibility explicitly set to 'public'"

  val INVALID_NON_PUBLIC_VISIBILITY =
    "A NamedElement, ElementImport or PackageImport must have public visibility, not: "

  val INVALID_ALIASED_ELEMENT_IMPORT =
    "An ElementImport must have no alias, not: "

  /**
   * Check the EMOF/CMOF rules for visibility & aliasing (where applicable) of
   * every [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]],
   * [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] or
   * [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]] in the scope of a set of
   * [[org.omg.oti.uml.read.api.UMLPackage packages]]
   *
   * @param pkgs the scope of the [[org.omg.oti.uml.read.api.UMLPackage packages]] to analyze
   * @param umlOps A tool-specific OTI UML operations adapter object
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam UmlOps The tool-specific OTI UML operations adapter type
   * @return Where applicable, [[AbstractVisibilityValidationInfo]] reults
   */
  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[AbstractVisibilityValidationInfo[Uml]] = {

    val scope = pkgs.toSet
    val validationHelper = VisibilityValidationHelper(scope)
    import validationHelper._
    import umlOps._

    val validationResults = for {
      pkg <- scope
      nes: Set[UMLNamedElement[Uml]] = closure[UMLNamedElement[Uml], UMLNamedElement[Uml]](
        pkg,
        _.ownedElement selectByKindOf { case ne: UMLNamedElement[Uml] => ne })
      ne <- nes
      v <- ne match {
        case ns: UMLNamespace[Uml] => checkNamespace(ns)
        case _ => checkNamedElementVisibility(ne)
      }
    } yield v

    validationResults
  }
}

/**
 * Helper for EMOF/CMOF visibilty & alias validation
 *
 * @param scope set of [[org.omg.oti.uml.read.api.UMLPackage UML Packages]] to analyze
 * @param umlOps A tool-specific OTI UML operations adapter object
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam UmlOps The tool-specific OTI UML operations adapter type
 */
case class VisibilityValidationHelper[Uml <: UML, UmlOps <: UMLOps[Uml]]
(scope: Set[UMLPackage[Uml]])
(implicit umlOps: UmlOps) {

  import org.omg.oti.uml.validation.VisibilityValidationHelper._

  /**
   * EMOF/CMOF validation for [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]]
   *
   * @param ne a [[org.omg.oti.uml.read.api.UMLNamedElement NamedElement]] to validate
   * @return If applicable, [[AbstractVisibilityValidationInfo]] reults
   */
  def checkNamedElementVisibility
  (ne: UMLNamedElement[Uml])
  : Iterable[AbstractVisibilityValidationInfo[Uml]] =
    ne.visibility.fold[Iterable[AbstractVisibilityValidationInfo[Uml]]] {
      ne match {
          case _: UMLPackageableElement[Uml] =>
            Iterable(NamedElementVisibilityValidationInfo(
              ne, ValidVisibilityStatus))
          case _ =>
            Iterable(NamedElementVisibilityValidationInfo(
              ne, MissingPublicVisibilityStatus,
              Some(MISSING_PUBLIC_VISIBILITY)))
        }
    }{
      case UMLVisibilityKind.public =>
        Iterable(NamedElementVisibilityValidationInfo(
          ne, ValidVisibilityStatus))
      case UMLVisibilityKind._package =>
        Iterable(
          NamedElementVisibilityValidationInfo(
            ne, InvalidNonPublicVisibilityStatus,
            Some(INVALID_NON_PUBLIC_VISIBILITY + "'package'")))
      case UMLVisibilityKind._private =>
        Iterable(
          NamedElementVisibilityValidationInfo(
            ne, InvalidNonPublicVisibilityStatus,
            Some(INVALID_NON_PUBLIC_VISIBILITY + "'private'")))
      case UMLVisibilityKind._protected =>
        Iterable(
          NamedElementVisibilityValidationInfo(
            ne, InvalidNonPublicVisibilityStatus,
            Some(INVALID_NON_PUBLIC_VISIBILITY + "'protected'")))
      case _ =>
        Iterable()
    }

  /**
   * EMOF/CMOF validation for [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]]
   *
   * @param ei a [[org.omg.oti.uml.read.api.UMLElementImport ElementImport]] to validate
   * @return If applicable, [[AbstractVisibilityValidationInfo]] reults
   */
  def checkElementImportVisibilityAndAlias
  (ei: UMLElementImport[Uml])
  : Iterable[AbstractVisibilityValidationInfo[Uml]] = {
    val v1: Iterable[AbstractVisibilityValidationInfo[Uml]] =
      ei.visibility match {
        case Some(UMLVisibilityKind.public) =>
          Iterable()
        case Some(UMLVisibilityKind._package) =>
          Iterable(
            ElementImportVisibilityValidationInfo(
              ei, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'package'")))
        case Some(UMLVisibilityKind._private) =>
          Iterable(
            ElementImportVisibilityValidationInfo(
              ei, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'private'")))
        case Some(UMLVisibilityKind._protected) =>
          Iterable(
            ElementImportVisibilityValidationInfo(
              ei, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'protected'")))
        case _ =>
          Iterable()
      }
    val v2: Iterable[AbstractVisibilityValidationInfo[Uml]] =
      ei.alias.fold[Iterable[AbstractVisibilityValidationInfo[Uml]]](Iterable()) {
        a =>
        Iterable(
          ElementImportVisibilityValidationInfo(
            ei, InvalidAliasedElementImportStatus,
            Some(INVALID_ALIASED_ELEMENT_IMPORT + "'" + a + "'")))
    }
    val v12: Iterable[AbstractVisibilityValidationInfo[Uml]] = v1 ++ v2
    if (v12.nonEmpty) v12
    else Iterable(ElementImportVisibilityValidationInfo(ei, ValidVisibilityStatus))
  }

  /**
   * EMOF/CMOF validation for [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]]
   *
   * @param pi a [[org.omg.oti.uml.read.api.UMLPackageImport PackageImport]] to validate
   * @return If applicable, [[AbstractVisibilityValidationInfo]] reults
   */
  def checkPackageImportVisibility
  (pi: UMLPackageImport[Uml])
  : Iterable[AbstractVisibilityValidationInfo[Uml]] =
    pi.visibility match {
      case Some(UMLVisibilityKind.public) =>
        Iterable(PackageImportVisibilityValidationInfo(pi, ValidVisibilityStatus))
      case Some(UMLVisibilityKind._package) =>
        Iterable(
          PackageImportVisibilityValidationInfo(
            pi, InvalidNonPublicVisibilityStatus,
            Some(INVALID_NON_PUBLIC_VISIBILITY + "'package'")))
      case Some(UMLVisibilityKind._private) =>
        Iterable(
          PackageImportVisibilityValidationInfo(
            pi, InvalidNonPublicVisibilityStatus,
            Some(INVALID_NON_PUBLIC_VISIBILITY + "'private'")))
      case Some(UMLVisibilityKind._protected) =>
        Iterable(
          PackageImportVisibilityValidationInfo(
            pi, InvalidNonPublicVisibilityStatus,
            Some(INVALID_NON_PUBLIC_VISIBILITY + "'protected'")))
      case _ =>
        Iterable()
    }

  /**
   * EMOF/CMOF validation for [[org.omg.oti.uml.read.api.UMLNamespace Namespace]]
   *
   * @param ns a [[[org.omg.oti.uml.read.api.UMLNamespace Namespace]] to validate
   * @return If applicable, [[AbstractVisibilityValidationInfo]] reults
   */
  def checkNamespace
  (ns: UMLNamespace[Uml])
  : Iterable[AbstractVisibilityValidationInfo[Uml]] = {
    val v1 = checkNamedElementVisibility(ns)
    val v2 = for {
      ei <- ns.elementImport
      vi <- checkElementImportVisibilityAndAlias(ei)
    } yield vi
    val v3 = for {
      pi <- ns.packageImport
      vi <- checkPackageImportVisibility(pi)
    } yield vi
    v1 ++ v2 ++ v3
  }

}