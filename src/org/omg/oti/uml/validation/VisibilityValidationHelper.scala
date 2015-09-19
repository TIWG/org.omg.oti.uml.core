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
package org.omg.oti.uml.validation

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{Boolean,Enumeration,Option,None,Some}
import scala.Predef.String
import scala.collection.immutable._
import scala.collection.Iterable

/**
 * The different categories of validation for the visibility & aliasing (where applicable)
 * of a NamedElement, ELementImport or PackageImport.
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 *      [4] Core::Basic and EMOF does not support visibilities.
 *      All property visibilities must be explicitly set to public where applicable,
 *      that is for all NamedElements, ElementImports and PackageImports.
 *      Furthermore, no alias is allowed for any ElementImport.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 *      [7] CMOF does not support visibilities.
 *      All property visibilities must be explicitly set to public where applicable,
 *      that is for all NamedElements, ElementImports, and PackageImports.
 *      Furthermore, no alias is allowed for any ElementImport.
 */
object VisibilityValidationStatus extends Enumeration {
  type VisibilityValidationStatus = Value

  /**
   * Valid per EMOF [4] and CMOF [7]
   */
  val ValidVisibilityStatus = Value

  /**
   * Invalid per EMOF [4] and CMOF [7]
   * A NamedElement, ElementImport or PackageImport with non-public visibility
   * (repair strategy: set the visibility to public)
   */
  val MissingPublicVisibilityStatus = Value

  /**
   * Invalid per EMOF [4] and CMOF [7]
   * A NamedElement, ElementImport or PackageImport with non-public visibility
   * (repair strategy: set the visibility to public)
   */
  val InvalidNonPublicVisibilityStatus = Value

  /**
   * Invalid per EMOF [4] and CMOF [7]
   * An ElementImport with an alias
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

  import VisibilityValidationStatus._

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
 * Visibility validation result for a kind of NamedElement
 *
 * @param e NamedElement
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
 * Visibility validation result for an ElementImport
 *
 * @param e ElementImport
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
 * Visibility validation result for a PackageImport
 *
 * @param e PackageImport
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
 * of a NamedElement, ELementImport or PackageImport.
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 *      [4] Core::Basic and EMOF does not support visibilities.
 *      All property visibilities must be explicitly set to public where applicable,
 *      that is for all NamedElements, ElementImports and PackageImports.
 *      Furthermore, no alias is allowed for any ElementImport.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 *      [7] CMOF does not support visibilities.
 *      All property visibilities must be explicitly set to public where applicable,
 *      that is for all NamedElements, ElementImports, and PackageImports.
 *      Furthermore, no alias is allowed for any ElementImport.
 */
object VisibilityValidationHelper {

  val MISSING_PUBLIC_VISIBILITY =
    "A NamedElement that is not a kind of PackageableElement must have visibility explicitly set to 'public'"

  val INVALID_NON_PUBLIC_VISIBILITY =
    "A NamedElement, ElementImport or PackageImport must have public visibility, not: "

  val INVALID_ALIASED_ELEMENT_IMPORT =
    "An ElementImport must have no alias, not: "

  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[AbstractVisibilityValidationInfo[Uml]] = {

    import umlOps._

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
      } { v =>
          v match {
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
      }

    def checkElementImportVisibilityAndAlias
    (ei: UMLElementImport[Uml])
    : Iterable[AbstractVisibilityValidationInfo[Uml]] = {
      val v1: Iterable[AbstractVisibilityValidationInfo[Uml]] =
        ei.visibility match {
        case UMLVisibilityKind.public =>
          Iterable()
        case UMLVisibilityKind._package =>
          Iterable(
            ElementImportVisibilityValidationInfo(
              ei, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'package'")))
        case UMLVisibilityKind._private =>
          Iterable(
            ElementImportVisibilityValidationInfo(
              ei, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'private'")))
        case UMLVisibilityKind._protected =>
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

    def checkPackageImportVisibility
    (pi: UMLPackageImport[Uml])
    : Iterable[AbstractVisibilityValidationInfo[Uml]] =
      pi.visibility match {
        case UMLVisibilityKind.public =>
          Iterable(PackageImportVisibilityValidationInfo(pi, ValidVisibilityStatus))
        case UMLVisibilityKind._package =>
          Iterable(
            PackageImportVisibilityValidationInfo(
              pi, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'package'")))
        case UMLVisibilityKind._private =>
          Iterable(
            PackageImportVisibilityValidationInfo(
              pi, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'private'")))
        case UMLVisibilityKind._protected =>
          Iterable(
            PackageImportVisibilityValidationInfo(
              pi, InvalidNonPublicVisibilityStatus,
              Some(INVALID_NON_PUBLIC_VISIBILITY + "'protected'")))
        case _ =>
          Iterable()
      }

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

    val validationResults = for {
      pkg <- pkgs
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