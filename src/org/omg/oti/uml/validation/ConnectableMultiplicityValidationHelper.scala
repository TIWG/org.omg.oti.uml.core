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

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.util._

/**
 * The different categories of validation for the lower or upper value of a multiplicity element
 * that is a kind of parameter or property.
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 * [32] The values of MultiplicityElement::lowerValue and upperValue must be
 * of kind LiteralInteger and LiteralUnlimitedNatural respectively.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 * [14] The values of MultiplicityElement::lowerValue and upperValue must
 * be of kind LiteralInteger and LiteralUnlimitedNatural respectively.
 */
object MultiplicityValueValidationStatus extends Enumeration {
  type MultiplicityValueValidationStatus = Value

  /**
   * Valid per EMOF [32] & CMOF [14]
   */
  val ValidValueStatus = Value

  /**
   * Invalid redundant default value '1'
   * (repair strategy: delete the value)
   */
  val RedundantValueStatus = Value

  /**
   * Invalid MultiplicityElement::lowerValue is a LiteralUnlimitedNatural
   * (repair strategy: convert the value to an equivalent LiteralInteger)
   * 
   * or
   * 
   * Invalid MultiplicityElement::upperValue is a LiteralUnlimitedNatural 
   * whose integer value is not a valid UnlimitedNatural
   * (no repair strategy)
   */
  val InvalidValueAsUnlimitedNaturalStatus = Value

  /**
   * Invalid MultiplicityElement::lowerValue is a LiteralInteger whose integer value is non positive
   * (no repair strategy)
   * 
   * or
   * 
   * Invalid MultiplicityElement::upperValue is a LiteralInteger
   * (repair strategy: convert the value to an equivalent LiteralUnlimitedNatural)
   */
  val InvalidValueAsIntegerStatus = Value

  /**
   * Invalid MultiplicityElement::lowerValue or MultiplicityElement::upperValue is a LiteralString
   * (repair strategy: if and only if the value can be converted to an equivalent, suitable value 
   *  for the role: a LiteralInteger for a lowerValue or a LiteralUnlimitedNatural for an upperValue)
   */
  val InvalidValueAsStringStatus = Value
  
  /**
   * Invalid MultiplicityElement::lowerValue or MultiplicityElement::upperValue 
   * is not a recognized ValueSpecification
   * (no repair strategy)
   */
  val InvalidValueKindStatus = Value
}

import MultiplicityValueValidationStatus._

/**
 * Multiplicity range validation result for a connectable element (parameter or property)
 *
 * @param parameter_or_property: A Parameter or Property
 * @param role: MultiplicityElement_lowerValue or MultiplicityElement_upperValue
 * @param status: valid, redundant or invalid
 * @param explanation: description of the validatio result
 * @param valueRepair: if invalid, an integer value to repair the model
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 * [32] The values of MultiplicityElement::lowerValue and upperValue must be
 * of kind LiteralInteger and LiteralUnlimitedNatural respectively.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 * [14] The values of MultiplicityElement::lowerValue and upperValue must
 * be of kind LiteralInteger and LiteralUnlimitedNatural respectively.
 */
case class ConnectableMultiplicityValidationInfo[Uml <: UML]
(val parameter_or_property: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml],
 val role: MetaPropertyReference[Uml, UMLMultiplicityElement[Uml], UMLValueSpecification[Uml]],
 val value: Option[UMLValueSpecification[Uml]],
 val status: MultiplicityValueValidationStatus,
 val explanation: Option[String] = None,
 val valueRepair: Option[Integer] = None) {

  import MultiplicityValueValidationStatus._

  val isInvalid: Boolean =
    status match {
      case _ @ ( InvalidValueAsUnlimitedNaturalStatus |
                 InvalidValueAsIntegerStatus |
                 InvalidValueAsStringStatus |
                 InvalidValueKindStatus ) =>
        true
      case _ =>
        false
    }

  val isRepairable: Boolean =
    RedundantValueStatus == status ||
    isInvalid && valueRepair.isDefined
}

/**
 * Multiplicity range validation support for parameter or property connectable elements
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 * [32] The values of MultiplicityElement::lowerValue and upperValue must be
 *      of kind LiteralInteger and LiteralUnlimitedNatural respectively.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 * [14] The values of MultiplicityElement::lowerValue and upperValue must
 *      be of kind LiteralInteger and LiteralUnlimitedNatural respectively.
 */
object ConnectableMultiplicityValidationHelper {

  val DELETE_REDUNDANT_DEFAULT_VALUE =
    Some("Delete redundant default value")

  val REPAIR_STRING_VALUE_TO_EQUIVALENT_INTEGER_VALUE =
    Some("Repair string value to equivalent integer value")

  val REPAIR_STRING_VALUE_TO_EQUIVALENT_UNLIMITED_NATURAL_VALUE =
    Some("Repair string value to equivalent unlimited natural value")

  val REPAIR_UNLIMITED_NATURAL_VALUE_TO_EQUIVALENT_INTEGER_VALUE =
    Some("Repair unlimited natural value to equivalent integer value")

  val REPAIR_INTEGER_VALUE_TO_EQUIVALENT_UNLIMITED_NATURAL_VALUE =
    Some("Repair integer value to equivalent unlimited natural value")

  val INVALID_UNLIMITED_NATURAL_VALUE =
    Some("Invalid negative unlimited natural value")

  val INVALID_INTEGER_VALUE =
    Some("Invalid negative integer value")

  val INVALID_STRING_VALUE =
    Some("Invalid string value")

  /**
   * Check the multiplicity range validity of all parameter or property
   * connectable elements found in the packages.
   *
   * @param pkgs: the scope of the packages to analyze
   * @return ConnectableMultiplicityValidationInfo for each connectable multiplicity element found in `pkgs`
   */
  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[ConnectableMultiplicityValidationInfo[Uml]] = {

    import umlOps._

    def checkLowerValue
    ( pop: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] )
    : ConnectableMultiplicityValidationInfo[Uml] =
      pop.lowerValue match {
        case None =>
          ConnectableMultiplicityValidationInfo[Uml](
            pop, MultiplicityElement_lowerValue,
            None, ValidValueStatus)

        case Some(l: UMLLiteralUnlimitedNatural[Uml]) =>
          if (1 == l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, RedundantValueStatus,
              DELETE_REDUNDANT_DEFAULT_VALUE)
          else if (-1 == l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, InvalidValueAsUnlimitedNaturalStatus,
              REPAIR_UNLIMITED_NATURAL_VALUE_TO_EQUIVALENT_INTEGER_VALUE, Some(0))
          else if (0 <= l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, InvalidValueAsUnlimitedNaturalStatus,
              REPAIR_UNLIMITED_NATURAL_VALUE_TO_EQUIVALENT_INTEGER_VALUE, Some(l.value))
          else
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, InvalidValueAsUnlimitedNaturalStatus,
              INVALID_UNLIMITED_NATURAL_VALUE)

        case Some(l: UMLLiteralInteger[Uml]) =>
          if (1 == l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, RedundantValueStatus,
              DELETE_REDUNDANT_DEFAULT_VALUE)
          else if (0 <= l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, ValidValueStatus)
          else
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_lowerValue,
              pop.lowerValue, InvalidValueAsIntegerStatus,
              INVALID_INTEGER_VALUE)

        case Some(l: UMLLiteralString[Uml]) =>
          l.value match {
            case None =>
              ConnectableMultiplicityValidationInfo[Uml](
                pop, MultiplicityElement_lowerValue,
                pop.lowerValue, InvalidValueAsStringStatus,
                INVALID_STRING_VALUE)
            case Some(s) =>
              if ("*" == s)
                ConnectableMultiplicityValidationInfo[Uml](
                  pop, MultiplicityElement_lowerValue,
                  pop.lowerValue, InvalidValueAsStringStatus,
                  REPAIR_STRING_VALUE_TO_EQUIVALENT_INTEGER_VALUE, Some(0))
              else
                Try(Integer.parseInt(s)) match {
                  case Success(x) =>
                    if (1 == x)
                      ConnectableMultiplicityValidationInfo[Uml](
                        pop, MultiplicityElement_lowerValue,
                        pop.lowerValue, RedundantValueStatus,
                        DELETE_REDUNDANT_DEFAULT_VALUE)
                    else if (0 <= x)
                      ConnectableMultiplicityValidationInfo[Uml](
                        pop, MultiplicityElement_lowerValue,
                        pop.lowerValue, InvalidValueAsStringStatus,
                        REPAIR_STRING_VALUE_TO_EQUIVALENT_INTEGER_VALUE, Some(x))
                    else
                      ConnectableMultiplicityValidationInfo[Uml](
                        pop, MultiplicityElement_lowerValue,
                        pop.lowerValue, InvalidValueAsStringStatus,
                        INVALID_STRING_VALUE)
                  case _: Failure[_] =>
                    ConnectableMultiplicityValidationInfo[Uml](
                      pop, MultiplicityElement_lowerValue,
                      pop.lowerValue, InvalidValueAsStringStatus,
                      INVALID_STRING_VALUE)
                }
          }

        case Some(v) =>
          ConnectableMultiplicityValidationInfo[Uml](
            pop, MultiplicityElement_lowerValue,
            pop.lowerValue, InvalidValueKindStatus,
            Some(s"${v.xmiType.head} is an invalid lower value"))
      }

    def checkUpperValue
    ( pop: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] )
    : ConnectableMultiplicityValidationInfo[Uml] =
      pop.upperValue match {
        case None =>
          ConnectableMultiplicityValidationInfo[Uml](
            pop, MultiplicityElement_upperValue,
            None, ValidValueStatus)

        case Some(l: UMLLiteralUnlimitedNatural[Uml]) =>
          if (1 == l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, RedundantValueStatus,
              DELETE_REDUNDANT_DEFAULT_VALUE)
          else if (-1 <= l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, ValidValueStatus)
          else
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, InvalidValueAsUnlimitedNaturalStatus,
              INVALID_UNLIMITED_NATURAL_VALUE)

        case Some(l: UMLLiteralInteger[Uml]) =>
          if (1 == l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, RedundantValueStatus,
              DELETE_REDUNDANT_DEFAULT_VALUE)
          else if (0 <= l.value)
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, InvalidValueAsIntegerStatus,
              REPAIR_INTEGER_VALUE_TO_EQUIVALENT_UNLIMITED_NATURAL_VALUE)
          else
            ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, InvalidValueAsIntegerStatus,
              INVALID_INTEGER_VALUE)

        case Some(l: UMLLiteralString[Uml]) =>
          l.value match {
            case None =>
              ConnectableMultiplicityValidationInfo[Uml](
                pop, MultiplicityElement_upperValue,
                pop.upperValue, InvalidValueAsStringStatus,
                INVALID_STRING_VALUE)
            case Some(s) =>
              if ("*" == s)
                ConnectableMultiplicityValidationInfo[Uml](
                  pop, MultiplicityElement_upperValue,
                  pop.upperValue, InvalidValueAsStringStatus,
                  REPAIR_STRING_VALUE_TO_EQUIVALENT_UNLIMITED_NATURAL_VALUE, Some(-1))
              else
                Try(Integer.parseInt(s)) match {
                  case Success(x) =>
                    if (1 == x)
                      ConnectableMultiplicityValidationInfo[Uml](
                        pop, MultiplicityElement_upperValue,
                        pop.upperValue, RedundantValueStatus,
                        DELETE_REDUNDANT_DEFAULT_VALUE)
                    else if (-1 <= x)
                      ConnectableMultiplicityValidationInfo[Uml](
                        pop, MultiplicityElement_upperValue,
                        pop.upperValue, InvalidValueAsStringStatus,
                        REPAIR_STRING_VALUE_TO_EQUIVALENT_INTEGER_VALUE, Some(x))
                    else
                      ConnectableMultiplicityValidationInfo[Uml](
                        pop, MultiplicityElement_upperValue,
                        pop.upperValue, InvalidValueAsStringStatus,
                        INVALID_STRING_VALUE)
                  case _: Failure[_] =>
                    ConnectableMultiplicityValidationInfo[Uml](
                      pop, MultiplicityElement_upperValue,
                      pop.upperValue, InvalidValueAsStringStatus,
                      INVALID_STRING_VALUE)
                }
          }

        case Some(v) =>
          ConnectableMultiplicityValidationInfo[Uml](
            pop, MultiplicityElement_upperValue,
            pop.upperValue, InvalidValueKindStatus,
            Some(s"${v.xmiType.head} is an invalid upper value"))
      }

    val validationResults = for {
      pkg <- pkgs
      nes: Set[UMLNamedElement[Uml]] = closure[UMLNamedElement[Uml], UMLNamedElement[Uml]](
        pkg,
        _.ownedElement selectByKindOf { case ne: UMLNamedElement[Uml] => ne })
      ne <- nes
      v <- ne match {
        case p: UMLParameter[Uml] =>
          checkLowerValue(p) :: checkUpperValue(p) :: Nil
        case p: UMLProperty[Uml] =>
          checkLowerValue(p) :: checkUpperValue(p) :: Nil
        case _ =>
          Nil
      }
    } yield v

    validationResults
  }

}