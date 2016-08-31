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

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{Boolean,Enumeration,Option,None,Some,StringContext}
import scala.Predef._
import scala.collection.Iterable
import scala.collection.immutable.Nil
import scala.util.control.Exception._

import java.lang.Integer

/**
 * The different categories of validation for the lower or upper value of a
 * [[org.omg.oti.uml.read.api.UMLMultiplicityElement multiplicity element]]
 * that is a kind of
 * [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
 * [[org.omg.oti.uml.read.api.UMLProperty Property]]
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 *
 * [32] The values of [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::lowerValue
 * and upperValue must be of kind
 * [[org.omg.oti.uml.read.api.UMLLiteralInteger LiteralInteger]] and
 * [[org.omg.oti.uml.read.api.UMLLiteralUnlimitedNatural LiteralUnlimitedNatural]] respectively.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 *
 * [14] The values of [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::lowerValue
 * and upperValue must be of kind
 * [[org.omg.oti.uml.read.api.UMLLiteralInteger LiteralInteger]] and
 * [[org.omg.oti.uml.read.api.UMLLiteralUnlimitedNatural LiteralUnlimitedNatural]] respectively.
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
   * Invalid [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::lowerValue
   * is a [[org.omg.oti.uml.read.api.UMLLiteralUnlimitedNatural LiteralUnlimitedNatural]]
   * (repair strategy: convert the value to an equivalent [[org.omg.oti.uml.read.api.UMLLiteralInteger LiteralInteger]])
   * 
   * or
   * 
   * Invalid [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::upperValue
   * is a [[org.omg.oti.uml.read.api.UMLLiteralUnlimitedNatural LiteralUnlimitedNatural]]
   * whose integer value is not a valid UnlimitedNatural
   * (no repair strategy)
   */
  val InvalidValueAsUnlimitedNaturalStatus = Value

  /**
   * Invalid [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::lowerValue
   * is a [[org.omg.oti.uml.read.api.UMLLiteralInteger LiteralInteger]] whose integer value is non positive
   * (no repair strategy)
   * 
   * or
   * 
   * Invalid [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::upperValue is a
   * [[org.omg.oti.uml.read.api.UMLLiteralInteger LiteralInteger]]
   * (repair strategy: convert the value to an equivalent
   * [[org.omg.oti.uml.read.api.UMLLiteralUnlimitedNatural LiteralUnlimitedNatural]])
   */
  val InvalidValueAsIntegerStatus = Value

  /**
   * Invalid [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::lowerValue
   * or [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::upperValue is a
   * [[org.omg.oti.uml.read.api.UMLLiteralString LiteralString]]
   * (repair strategy: if and only if the value can be converted to an equivalent, suitable value 
   *  for the role: a [[org.omg.oti.uml.read.api.UMLLiteralInteger LiteralInteger]]
   *  for a lowerValue or a
   *  [[org.omg.oti.uml.read.api.UMLLiteralUnlimitedNatural LiteralUnlimitedNatural]] for an upperValue)
   */
  val InvalidValueAsStringStatus = Value
  
  /**
   * Invalid [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::lowerValue or
   * [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]::upperValue
   * is not a recognized [[org.omg.oti.uml.read.api.UMLValueSpecification ValueSpecification]]
   * (no repair strategy)
   */
  val InvalidValueKindStatus = Value
}

import org.omg.oti.uml.validation.MultiplicityValueValidationStatus._

/**
 * Multiplicity range validation result for a [[org.omg.oti.uml.read.api.UMLConnectableElement connectable element]]
 * ([[org.omg.oti.uml.read.api.UMLParameter parameter]] or
 * [[org.omg.oti.uml.read.api.UMLProperty property]])
 *
 * @param parameter_or_property A [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
 * [[org.omg.oti.uml.read.api.UMLProperty Property]]
 * @param role [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]_lowerValue or
 *             [[org.omg.oti.uml.read.api.UMLMultiplicityElement MultiplicityElement]]_upperValue
 * @param status valid, redundant or invalid
 * @param explanation description of the validation result
 * @param valueRepair if invalid, an integer value to repair the model
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class ConnectableMultiplicityValidationInfo[Uml <: UML]
(parameter_or_property: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml],
 role: MetaPropertyReference[Uml, UMLMultiplicityElement[Uml], UMLValueSpecification[Uml]],
 value: Option[UMLValueSpecification[Uml]],
 status: MultiplicityValueValidationStatus,
 explanation: Option[String] = None,
 valueRepair: Option[Integer] = None) {

  import org.omg.oti.uml.validation.MultiplicityValueValidationStatus._

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
 * Multiplicity range validation support for [[org.omg.oti.uml.read.api.UMLParameter parameter]] or
 * [[org.omg.oti.uml.read.api.UMLProperty property]] connectable elements
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
   * Check the multiplicity range validity of all [[org.omg.oti.uml.read.api.UMLParameter parameter]] or
   * [[org.omg.oti.uml.read.api.UMLProperty property]]
   * connectable elements found in the scope of [[org.omg.oti.uml.read.api.UMLPackage packages]].
   *
   * @param pkgs the scope of the [[org.omg.oti.uml.read.api.UMLPackage packages]] to analyze
   * @return ConnectableMultiplicityValidationInfo for each connectable multiplicity element found in `pkgs`
   */
  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[ConnectableMultiplicityValidationInfo[Uml]] = {

    val scope = pkgs.toSet
    val validationHelper = ConnectableMultiplicityValidationHelper(scope)
    import validationHelper._
    import umlOps._

    val validationResults = for {
      pkg <- scope
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

/**
 * Helper for EMOF/CMOF Multiplicity range validation for
 * [[org.omg.oti.uml.read.api.UMLConnectableElement connectable elements]]
 * ([[org.omg.oti.uml.read.api.UMLParameter parameters]] or
 * [[org.omg.oti.uml.read.api.UMLProperty properties]])
 *
 * @param pkgs set of [[org.omg.oti.uml.read.api.UMLPackage UML Packages]] to analyze the contents for EMOF/CMOF
 *             multiplicity rance validation
 * @param umlOps A tool-specific OTI UML operations adapter object
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam UmlOps The tool-specific OTI UML operations adapter type
 */
case class ConnectableMultiplicityValidationHelper[Uml <: UML, UmlOps <: UMLOps[Uml]]
(pkgs: Set[UMLPackage[Uml]])
(implicit umlOps: UmlOps) {

  import org.omg.oti.uml.validation.ConnectableMultiplicityValidationHelper._

  import umlOps._

  /**
   * EMOF/CMOF lower value validation
   *
   * @param pop a [[org.omg.oti.uml.read.api.UMLParameter parameter]] or
   * [[org.omg.oti.uml.read.api.UMLProperty property]]
   * @return A [[ConnectableMultiplicityValidationInfo]] result
   */
  def checkLowerValue
  ( pop: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] )
  : ConnectableMultiplicityValidationInfo[Uml] =
    pop
    .lowerValue
    .fold[ConnectableMultiplicityValidationInfo[Uml]](
        ifEmpty = ConnectableMultiplicityValidationInfo[Uml](
                    pop, MultiplicityElement_lowerValue,
                    None, ValidValueStatus)
    ) {
        case l: UMLLiteralUnlimitedNatural[Uml] =>
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

        case l: UMLLiteralInteger[Uml] =>
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

        case l: UMLLiteralString[Uml] =>
          l
          .value
          .fold[ConnectableMultiplicityValidationInfo[Uml]](
            ifEmpty =
              ConnectableMultiplicityValidationInfo[Uml](
                pop, MultiplicityElement_lowerValue,
                pop.lowerValue, InvalidValueAsStringStatus,
                INVALID_STRING_VALUE)
          ) { s =>
              if ("*" == s)
                ConnectableMultiplicityValidationInfo[Uml](
                  pop, MultiplicityElement_lowerValue,
                  pop.lowerValue, InvalidValueAsStringStatus,
                  REPAIR_STRING_VALUE_TO_EQUIVALENT_INTEGER_VALUE, Some(0))
              else
                catching(classOf[java.lang.NumberFormatException])
                .withApply { _ =>
                  ConnectableMultiplicityValidationInfo[Uml](
                    pop, MultiplicityElement_lowerValue,
                    pop.lowerValue, InvalidValueAsStringStatus,
                    INVALID_STRING_VALUE)
                }
                .apply({
                  val x = Integer.parseInt(s)
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
                })
          }

        case v =>
          ConnectableMultiplicityValidationInfo[Uml](
            pop, MultiplicityElement_lowerValue,
            pop.lowerValue, InvalidValueKindStatus,
            Some(s"${v.xmiType.head} is an invalid lower value"))
      }

  /**
   * EMOF/CMOF upper value validation
   *
   * @param pop a [[org.omg.oti.uml.read.api.UMLParameter parameter]] or
   * [[org.omg.oti.uml.read.api.UMLProperty property]]
   * @return A [[ConnectableMultiplicityValidationInfo]] result
   */
  def checkUpperValue
  ( pop: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] )
  : ConnectableMultiplicityValidationInfo[Uml] =
    pop
    .upperValue
    .fold[ConnectableMultiplicityValidationInfo[Uml]](
        ifEmpty = ConnectableMultiplicityValidationInfo[Uml](
                    pop, MultiplicityElement_upperValue,
                    None, ValidValueStatus)
    ) {
        case l: UMLLiteralUnlimitedNatural[Uml] =>
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

        case l: UMLLiteralInteger[Uml] =>
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

        case l: UMLLiteralString[Uml] =>
          l
          .value
          .fold[ConnectableMultiplicityValidationInfo[Uml]](
            ifEmpty =
              ConnectableMultiplicityValidationInfo[Uml](
                pop, MultiplicityElement_upperValue,
                pop.upperValue, InvalidValueAsStringStatus,
                INVALID_STRING_VALUE)
          ) { s =>
              if ("*" == s)
                ConnectableMultiplicityValidationInfo[Uml](
                    pop, MultiplicityElement_upperValue,
                    pop.upperValue, InvalidValueAsStringStatus,
                    REPAIR_STRING_VALUE_TO_EQUIVALENT_UNLIMITED_NATURAL_VALUE, Some(-1))
              else
                catching(classOf[java.lang.NumberFormatException])
                .withApply { _ =>
                  ConnectableMultiplicityValidationInfo[Uml](
                    pop, MultiplicityElement_upperValue,
                    pop.upperValue, InvalidValueAsStringStatus,
                    INVALID_STRING_VALUE)
                }
                .apply({
                  val x = Integer.parseInt(s)
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
                })
          }

        case v =>
          ConnectableMultiplicityValidationInfo[Uml](
              pop, MultiplicityElement_upperValue,
              pop.upperValue, InvalidValueKindStatus,
              Some(s"${v.xmiType.head} is an invalid upper value"))
    }
}