package org.omg.oti.uml.validation

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.util._

/**
 * The different categories of validation for the name of named elements.
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 * [3] Names are required for all NamedElements except for ValueSpecifications.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 * [6] Names are required for all NamedElements except for ValueSpecifications.
 */
object NamedElementValidationStatus extends Enumeration {
  type NamedElementValidationStatus = Value

  /**
   * Valid per EMOF [3] & CMOF [6]
   */
  val ValidNamedElementNameStatus = Value

  /**
   * Invalid per EMOF [3] & CMOF [6]
   * (no repair strategy)
   */
  val InvalidUnnamedNamedElementStatus = Value

}

import NamedElementValidationStatus._

/**
 * NamedElement name validation result
 *
 * @param namedElement A NamedElement
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml A tool-specific implementation of OMG UML
 */
case class NamedElementNameValidationInfo[Uml <: UML]
(val namedElement: UMLNamedElement[Uml],
 val status: NamedElementValidationStatus,
 val explanation: Option[String] = None) {

  import NamedElementValidationStatus._

  val isInvalid: Boolean =
    status != ValidNamedElementNameStatus

  val isRepairable: Boolean =
    false

}

object NamedElementValidationHelper {

  val INVALID_UNNAMED_NAMED_ELEMENT =
    Some("A name is required for all kinds of NamedElements except for ValueSpecifications")


  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[NamedElementNameValidationInfo[Uml]] = {

    import umlOps._

    def checkNamedElementName(ne: UMLNamedElement[Uml]): Option[NamedElementNameValidationInfo[Uml]] =
      ne match {
        case _: UMLValueSpecification[Uml] =>
          None
        case _ =>
          if (ne.name.nonEmpty)
            Some(NamedElementNameValidationInfo(ne, ValidNamedElementNameStatus))
          else
            Some(NamedElementNameValidationInfo(ne, InvalidUnnamedNamedElementStatus, INVALID_UNNAMED_NAMED_ELEMENT))
      }

    val validationResults = for {
      pkg <- pkgs
      nes: Set[UMLNamedElement[Uml]] =
      closure[UMLNamedElement[Uml], UMLNamedElement[Uml]](
        pkg, _.ownedElement selectByKindOf { case ne: UMLNamedElement[Uml] => ne })
      ne <- nes
      v <- checkNamedElementName(ne)
    } yield v

    validationResults
  }
}
