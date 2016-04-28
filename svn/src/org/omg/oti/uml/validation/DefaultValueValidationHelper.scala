/*
 *
 * License Terms
 *
 * Copyright (c) 2014-2016, California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * *   Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *   Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * *   Neither the name of Caltech nor its operating division, the Jet
 *    Propulsion Laboratory, nor the names of its contributors may be
 *    used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml.validation

import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{Boolean,Enumeration,Option,None,Some}
import scala.Predef.{Integer2int,String,_}
import scala.collection.Iterable
import scala.collection.immutable.Set

/** The different categories of validation for default values
  *
  * @see MOF 2.5, Section 12.4 EMOF Constraints
  *
  *      [24] A [[org.omg.oti.uml.read.api.UMLTypedElement TypedElement]] that is a kind of
  *      [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or [[org.omg.oti.uml.read.api.UMLProperty Property]]
  *      typed by a [[org.omg.oti.uml.read.api.UMLClass Class]] cannot have a default value.
  *
  *      [25] For a [[org.omg.oti.uml.read.api.UMLTypedElement TypedElement]] that is a kind of
  *      [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or [[org.omg.oti.uml.read.api.UMLProperty Property]]
  *      typed by an [[org.omg.oti.uml.read.api.UMLEnumeration Enumeration]], the defaultValue,
  *      if any, must be a kind of [[org.omg.oti.uml.read.api.UMLInstanceValue InstanceValue]].
  *
  *      [26] A [[org.omg.oti.uml.read.api.UMLTypedElement TypedElement]] that is a kind of
  *      [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or [[org.omg.oti.uml.read.api.UMLProperty Property]]
  *      typed by a [[org.omg.oti.uml.read.api.UMLPrimitiveType PrimitiveType]], the defaultValue,
  *      if any, must be a kind of [[org.omg.oti.uml.read.api.UMLLiteralSpecification LiteralSpecification]].
  *
  *      [31] A multi-valued [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] cannot have a default value.
  *
  * @see MOF 2.5, Section 14.4 CMOF Constraints
  *
  *      [13] A multi-valued [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] cannot have a default value.
  *
  *        - The default value of a [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] typed by a
  *      [[org.omg.oti.uml.read.api.UMLPrimitiveType PrimitiveType]] must be a kind of
  *      [[org.omg.oti.uml.read.api.UMLLiteralSpecification LiteralSpecification]].
  *
  *        - The default value of a [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] typed by an
  *      [[org.omg.oti.uml.read.api.UMLEnumeration Enumeration]] must be a kind of
  *      [[org.omg.oti.uml.read.api.UMLInstanceValue InstanceValue]].
  *
  *        - A [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] typed by a
  *      [[org.omg.oti.uml.read.api.UMLClass Class]] cannot have a default value.
  *
  *      [24] A TypedElement that is a kind of [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] typed by a
  *      [[org.omg.oti.uml.read.api.UMLClass Class]]  cannot have a default value.
  *
  *      [25] For a TypedElement that is a kind of [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] typed by an
  *      [[org.omg.oti.uml.read.api.UMLEnumeration Enumeration]], the defaultValue, if any,
  *      must be a kind of [[org.omg.oti.uml.read.api.UMLInstanceValue InstanceValue]].
  *
  *      [26] For a TypedElement that is a kind of [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
  *      or [[org.omg.oti.uml.read.api.UMLProperty Property]] typed by an
  *      [[org.omg.oti.uml.read.api.UMLPrimitiveType PrimitiveType]], the defaultValue, if any,
  *      must be a kind of [[org.omg.oti.uml.read.api.UMLLiteralSpecification LiteralSpecification]].
  */
object DefaultValueValidationStatus extends Enumeration {
  type DefaultValueValidationStatus = Value

  /**
   * Valid per EMOF [24,25,26,31] & CMOF [13,24,25,26]
   */
  val ValidDefaultValueStatus = Value

  /**
   * Invalid per EMOF [24] & CMOF [24]
   * (no repair strategy because deleting the default value would loose potentially important information)
   */
  val InvalidDefaultValueForClassTypedParameterOrPropertyStatus = Value

  /**
   * Invalid per EMOF [25] & CMOF [13,25]
   * (no repair strategy because deleting the default value would loose potentially important information)
   */
  val InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus = Value

  /**
   * Invalid per EMOF [26] & CMOF [13,26]
   * (no repair strategy because deleting the default value would loose potentially important information)
   */
  val InvalidDefaultValueForPrimitiveTypeTypedParameterOrPropertyStatus = Value

  /**
   * Invalid per EMOF [31] & CMOF [13]
   * (no repair strategy because deleting the default value would loose potentially important information)
   */
  val InvalidDefaultValueForMultiValuedParameterOrPropertyStatus = Value

}

import org.omg.oti.uml.validation.DefaultValueValidationStatus._

/**
 * The common superclass of the different categories of DefaultValue validation results.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
sealed abstract class AbstractDefaultValueValidationInfo[Uml <: UML] {
  val e: UMLElement[Uml]
  val status: DefaultValueValidationStatus
  val explanation: Option[String] = None

  import org.omg.oti.uml.validation.DefaultValueValidationStatus._

  def isInvalid: Boolean =
    status != ValidDefaultValueStatus

  /**
   * If invalid, is there a repair strategy? Unfortunately no.
   *
   * All violations involve a [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   * [[org.omg.oti.uml.read.api.UMLProperty Property]]  that either have a default value
   * when it there should be none or that have a default value of the wrong kind.
   * There is no generic way to fix these problems without
   * potentially loosing important information.
   *
   * @return false
   */
  def isRepairable: Boolean =
    false
}

/**
 * Validation result for the DefaultValue of a [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
 *
 * @param e a [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class ParameterDefaultValueValidationInfo[Uml <: UML]
(override val e: UMLParameter[Uml],
 override val status: DefaultValueValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractDefaultValueValidationInfo[Uml]

/**
 * Validation result for the DefaultValue of a kind of [[org.omg.oti.uml.read.api.UMLProperty Property]]
 *
 * @param e a kind of [[org.omg.oti.uml.read.api.UMLProperty Property]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class PropertyDefaultValueValidationInfo[Uml <: UML]
(override val e: UMLProperty[Uml],
 override val status: DefaultValueValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractDefaultValueValidationInfo[Uml]

/**
 * Validation result for a ValueSpecification as a DefaultValue for a
 * [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
 * [[org.omg.oti.uml.read.api.UMLProperty Property]]
 *
 * @param e a kind of [[org.omg.oti.uml.read.api.UMLValueSpecification ValueSpecification]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class ValueSpecificationAsDefaultValueValidationInfo[Uml <: UML]
(override val e: UMLValueSpecification[Uml],
 override val status: DefaultValueValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractDefaultValueValidationInfo[Uml]

object DefaultValueValidationHelper {

  val INVALID_DEFAULT_VALUE_FOR_CLASS_TYPED_PARAMETER =
    Some("A Parameter typed by a Class cannot have a default value")

  val INVALID_DEFAULT_VALUE_FOR_CLASS_TYPED_PROPERTY =
    Some("A Property typed by a Class cannot have a default value")

  val INVALID_DEFAULT_VALUE_FOR_ENUMERATION_TYPED_PARAMETER =
    Some("For a Parameter typed by an Enumeration, the default value must be a kind of InstanceValue")

  val INVALID_DEFAULT_VALUE_FOR_ENUMERATION_TYPED_PROPERTY =
    Some("For a kind of Property typed by an Enumeration, the default value must be a kind of InstanceValue")

  val INVALID_DEFAULT_VALUE_FOR_PRIMITIVETYPE_TYPED_PARAMETER =
    Some("For a Parameter typed by a PrimitiveType, the default value must be a kind of LiteralSpecification")

  val INVALID_DEFAULT_VALUE_FOR_PRIMITIVETYPE_TYPED_PROPERTY =
    Some("For a kind of Property typed by a PrimitiveType, the default value must be a kind of LiteralSpecification")

  val INVALID_DEFAULT_VALUE_FOR_MULTI_VALUED_PARAMETER =
    Some("A multi-valued Parameter cannot have a default value")

  val INVALID_DEFAULT_VALUE_FOR_MULTI_VALUED_PROPERTY =
    Some("A multi-valued kind of Property cannot have a default value")

  /**
   * EMOF/CMOF default value validation for all
   * [[org.omg.oti.uml.read.api.UMLParameter Parameters]] and
   * [[org.omg.oti.uml.read.api.UMLProperty Properties]] in the scope of a set of
   *  [[org.omg.oti.uml.read.api.UMLPackage UML Packages]]
   *
   * @param pkgs A set of UML Packages to analyze the contents for EMOF/CMOF default value validation constraints
   * @param umlOps A tool-specific OTI UML operations adapter object
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam UmlOps The tool-specific OTI UML operations adapter type
   * @return Where applicable, [[AbstractDefaultValueValidationInfo]] results
   */
  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[AbstractDefaultValueValidationInfo[Uml]] = {

    val scope = pkgs.toSet
    val validationHelper = DefaultValueValidationHelper(scope)
    import umlOps._
    import validationHelper._

    val validationResults = for {
      pkg <- pkgs
      tes: Set[UMLTypedElement[Uml]] =
      closure[UMLNamedElement[Uml], UMLNamedElement[Uml]](
        pkg, _.ownedElement selectByKindOf { case ne: UMLNamedElement[Uml] => ne }) selectByKindOf {
        case te: UMLTypedElement[Uml] => te
      }
      te <- tes
      v <- te match {
        case p: UMLParameter[Uml] =>
          checkDefaultValue(
            isMultiValued = p.upper > 1 || p.upper == -1,
            validParameterOrPropertyFunction = makeValidDefaultValueStatusForParameter(p),
            invalidDefaultValueForMultiValuedTypedElementFunction = makeInvalidDefaultValueForMultiValuedParameter(p),
            invalidDefaultValueForTypedElementMessage = INVALID_DEFAULT_VALUE_FOR_CLASS_TYPED_PARAMETER,
            invalidDefaultValueForEnumerationTypeMessage = INVALID_DEFAULT_VALUE_FOR_ENUMERATION_TYPED_PARAMETER,
            invalidDefaultValueForPrimitiveTypeMessage = INVALID_DEFAULT_VALUE_FOR_PRIMITIVETYPE_TYPED_PARAMETER,
            t = p._type,
            defaultValue = p.defaultValue)
        case p: UMLProperty[Uml] =>
          checkDefaultValue(
            isMultiValued = p.upper > 1 || p.upper == -1,
            validParameterOrPropertyFunction = makeValidDefaultValueStatusForProperty(p),
            invalidDefaultValueForMultiValuedTypedElementFunction = makeInvalidDefaultValueForMultiValuedProperty(p),
            invalidDefaultValueForTypedElementMessage = INVALID_DEFAULT_VALUE_FOR_CLASS_TYPED_PROPERTY,
            invalidDefaultValueForEnumerationTypeMessage = INVALID_DEFAULT_VALUE_FOR_ENUMERATION_TYPED_PROPERTY,
            invalidDefaultValueForPrimitiveTypeMessage = INVALID_DEFAULT_VALUE_FOR_PRIMITIVETYPE_TYPED_PROPERTY,
            t = p._type,
            defaultValue = p.defaultValue)
        case _ =>
          None
      }
    } yield v

    validationResults
  }
}

/**
 * Helper for EMOF/CMOF default value validation
 *
 * @param scope set of UML Packages to analyze the contents for EMOF/CMOF default value validation constraints
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class DefaultValueValidationHelper[Uml <: UML]
(scope: Set[UMLPackage[Uml]]) {

  import org.omg.oti.uml.validation.DefaultValueValidationHelper._

  /**
   * Produce a valid result for a UML Parameter default value per EMOF/CMOF rules
   * @param p the valid UML Parameter
   * @return A valid [[AbstractDefaultValueValidationInfo]] result
   */
  def makeValidDefaultValueStatusForParameter
  (p: UMLParameter[Uml])
  ()
  : Option[AbstractDefaultValueValidationInfo[Uml]] =
    Some(ParameterDefaultValueValidationInfo(
      p, ValidDefaultValueStatus))

  /**
   * Produce a valid result for a [[org.omg.oti.uml.read.api.UMLProperty Property]] default value per EMOF/CMOF rules
   * @param p the valid [[org.omg.oti.uml.read.api.UMLProperty Property]]
   * @return A valid [[AbstractDefaultValueValidationInfo]] result
   */
  def makeValidDefaultValueStatusForProperty
  (p: UMLProperty[Uml])
  ()
  : Option[AbstractDefaultValueValidationInfo[Uml]] =
    Some(PropertyDefaultValueValidationInfo(
      p, ValidDefaultValueStatus))

  /**
   * Produce an invalid result for a multi-valued UML Parameter default value per EMOF/CMOF rules
   * @param p the invalid UML Parameter
   * @return An invalid [[AbstractDefaultValueValidationInfo]] result
   */
  def makeInvalidDefaultValueForMultiValuedParameter
  (p: UMLParameter[Uml])
  ()
  : Option[AbstractDefaultValueValidationInfo[Uml]] =
    Some(ParameterDefaultValueValidationInfo(
      p, InvalidDefaultValueForMultiValuedParameterOrPropertyStatus,
      INVALID_DEFAULT_VALUE_FOR_MULTI_VALUED_PARAMETER))

  /**
   * Produce an invalid result for a multi-valued [[org.omg.oti.uml.read.api.UMLProperty Property]]
   * default value per EMOF/CMOF rules
   * @param p the invalid [[org.omg.oti.uml.read.api.UMLProperty Property]]
   * @return An invalid [[AbstractDefaultValueValidationInfo]] result
   */
  def makeInvalidDefaultValueForMultiValuedProperty
  (p: UMLProperty[Uml])
  ()
  : Option[AbstractDefaultValueValidationInfo[Uml]] =
    Some(PropertyDefaultValueValidationInfo(
      p, InvalidDefaultValueForMultiValuedParameterOrPropertyStatus,
      INVALID_DEFAULT_VALUE_FOR_MULTI_VALUED_PROPERTY))

  /**
   * Produce an invalid result for a [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   * [[org.omg.oti.uml.read.api.UMLProperty Property]] with an invalid
   * default value per EMOF/CMOF rules
   * @param v the UML ValueSpecification that is the invalid default value
   *          for its owning [[org.omg.oti.uml.read.api.UMLParameter Parameter]]
   *          or [[org.omg.oti.uml.read.api.UMLProperty Property]]
   * @param status Indication of which EMOF/CMOF default validation rule are violated
   * @param message Human explanation about the invalid status
   * @return An invalid [[AbstractDefaultValueValidationInfo]] result
   */
  def makeInvalidDefaultValueForParameterOrProperty
  (v: UMLValueSpecification[Uml], status: DefaultValueValidationStatus, message: Option[String])
  : Option[AbstractDefaultValueValidationInfo[Uml]] =
    Some(ValueSpecificationAsDefaultValueValidationInfo(v, status, message))

  /**
   * Analyze a [[org.omg.oti.uml.read.api.UMLParameter UML Parameter]] or
   * [[org.omg.oti.uml.read.api.UMLProperty UML Property]] for EMOF/CMOF default validation rules
   *
   * Since UML does not have an abstract metaclass for the common characteristics
   * of [[org.omg.oti.uml.read.api.UMLParameter Parameters]] and
   * [[org.omg.oti.uml.read.api.UMLProperty Properties]] as
   * kinds of [[org.omg.oti.uml.read.api.UMLConnectableElement UML ConnectableEements]] and
   * [[org.omg.oti.uml.read.api.UMLMultiplicityElement UML MultiplicityElements]],
   * the common characteristics are abstracted through variables: `isMultiValued`, and
   * validation message constructor functions: `validParameterOrPropertyFunction`,
   * `invalidDefaultValueForMultiValuedTypedElementFunction`, `invalidDefaultValueForTypedElementMessage`,
   * `invalidDefaultValueForEnumerationTypeMessage`, `invalidDefaultValueForPrimitiveTypeMessage`
   *
   * The validation of [[org.omg.oti.uml.read.api.UMLParameter UML Parameters]] and
   * of [[org.omg.oti.uml.read.api.UMLProperty UML Properties]] is very similar;
   * the differences are abstracted through validation constructor functions.
   *
   * @param isMultiValued Whether the parameter or property is a collection of multiple values
   * @param validParameterOrPropertyFunction Valid result constructor
   * @param invalidDefaultValueForMultiValuedTypedElementFunction Invalid result constructor
   *                                                              for a multi-valued
   *                                                              [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   *                                                              [[org.omg.oti.uml.read.api.UMLProperty Property]]
   * @param invalidDefaultValueForTypedElementMessage Invalid result constructor for a
   *                                                  [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   *                                                  [[org.omg.oti.uml.read.api.UMLProperty Property]] typed
   *                                                  by a kind of [[org.omg.oti.uml.read.api.UMLClass Class]]
   * @param invalidDefaultValueForEnumerationTypeMessage Invalid result constructor for a
   *                                                     [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   *                                                     [[org.omg.oti.uml.read.api.UMLProperty Property]] typed
   *                                                     by a kind of
   *                                                     [[org.omg.oti.uml.read.api.UMLEnumeration Enumeration]]
   * @param invalidDefaultValueForPrimitiveTypeMessage Invalid result constructor for a
   *                                                   [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   *                                                   [[org.omg.oti.uml.read.api.UMLProperty Property]] typed
   *                                                   by a kind of
   *                                                   [[org.omg.oti.uml.read.api.UMLPrimitiveType PrimitiveType]]
   * @param t The type, if any, of the validated [[org.omg.oti.uml.read.api.UMLParameter Parameter]] or
   *          [[org.omg.oti.uml.read.api.UMLProperty Property]]
   * @param defaultValue The default value, if any
   * @return If applicable, a [[AbstractDefaultValueValidationInfo]] result
   */
  def checkDefaultValue
  (isMultiValued: Boolean,
   validParameterOrPropertyFunction: () => Option[AbstractDefaultValueValidationInfo[Uml]],
   invalidDefaultValueForMultiValuedTypedElementFunction: () => Option[AbstractDefaultValueValidationInfo[Uml]],
   invalidDefaultValueForTypedElementMessage: Option[String],
   invalidDefaultValueForEnumerationTypeMessage: Option[String],
   invalidDefaultValueForPrimitiveTypeMessage: Option[String],
   t: Option[UMLType[Uml]],
   defaultValue: Option[UMLValueSpecification[Uml]])
  : Option[AbstractDefaultValueValidationInfo[Uml]] =
    if (isMultiValued)
      defaultValue
      .fold[Option[AbstractDefaultValueValidationInfo[Uml]]](ifEmpty = validParameterOrPropertyFunction()) {
        _ => invalidDefaultValueForMultiValuedTypedElementFunction()
      }
    else
      t.fold[Option[AbstractDefaultValueValidationInfo[Uml]]](None) {
          case _: UMLClass[Uml] =>
            defaultValue
            .fold[Option[AbstractDefaultValueValidationInfo[Uml]]](ifEmpty = validParameterOrPropertyFunction()) {
              v =>
                Some(ValueSpecificationAsDefaultValueValidationInfo(
                  v, InvalidDefaultValueForClassTypedParameterOrPropertyStatus,
                  invalidDefaultValueForTypedElementMessage))
            }
          case t_enum: UMLEnumeration[Uml] =>
            defaultValue
            .fold[Option[AbstractDefaultValueValidationInfo[Uml]]](ifEmpty = validParameterOrPropertyFunction()) {
              case v: UMLInstanceValue[Uml] =>
                v
                .instance
                .fold[Option[AbstractDefaultValueValidationInfo[Uml]]](
                  ifEmpty = Some(ValueSpecificationAsDefaultValueValidationInfo(
                      v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                      invalidDefaultValueForEnumerationTypeMessage))
                ) {
                    case lit: UMLEnumerationLiteral[Uml] =>
                      lit
                      .enumeration
                      .fold[Option[AbstractDefaultValueValidationInfo[Uml]]](
                        ifEmpty = Some(ValueSpecificationAsDefaultValueValidationInfo(
                              v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                              invalidDefaultValueForEnumerationTypeMessage))
                      ){
                        case lit_enum if t_enum == lit_enum =>
                          Some(ValueSpecificationAsDefaultValueValidationInfo(
                            v, ValidDefaultValueStatus))
                        case _ =>
                          Some(ValueSpecificationAsDefaultValueValidationInfo(
                              v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                              invalidDefaultValueForEnumerationTypeMessage))
                      }
                    case _ =>
                      Some(ValueSpecificationAsDefaultValueValidationInfo(
                        v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                        invalidDefaultValueForEnumerationTypeMessage))
                  }
              case v =>
                Some(ValueSpecificationAsDefaultValueValidationInfo(
                  v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                  invalidDefaultValueForEnumerationTypeMessage))
            }
          case _: UMLPrimitiveType[Uml] =>
            defaultValue
            .fold[Option[AbstractDefaultValueValidationInfo[Uml]]](ifEmpty = validParameterOrPropertyFunction()) {
              case v: UMLLiteralSpecification[Uml] =>
                Some(ValueSpecificationAsDefaultValueValidationInfo(
                  v, ValidDefaultValueStatus))
              case v =>
                Some(ValueSpecificationAsDefaultValueValidationInfo(
                  v, InvalidDefaultValueForPrimitiveTypeTypedParameterOrPropertyStatus,
                  invalidDefaultValueForPrimitiveTypeMessage))
            }
          case _ =>
            None
        }

}