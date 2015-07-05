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

/** The different categories of validation for default values
  *
  * @see MOF 2.5, Section 12.4 EMOF Constraints
  *      [24] A TypedElement that is a kind of Parameter or Property typed by a Class cannot have a default value.
  *      [25] For a TypedElement that is a kind of Parameter or Property typed by an Enumeration, the defaultValue,
  *           if any, must be a kind of InstanceValue.
  *      [26] For a TypedElement that is a kind of Parameter or Property typed by a PrimitiveType, the defaultValue,
  *           if any, must be a kind of LiteralSpecification.
  *      [31] A multi-valued Property or Parameter cannot have a default value.
  *
  * @see MOF 2.5, Section 14.4 CMOF Constraints
  *      [13] A multi-valued Property or Parameter cannot have a default value.
  *           The default value of a Property or Parameter typed by a PrimitiveType must be a kind of LiteralSpecification.
  *           The default value of a Property or Parameter typed by an Enumeration must be a kind of InstanceValue.
  *           A Property or Parameter typed by a Class cannot have a default value.
  *      [24] A TypedElement that is a kind of Parameter or Property typed by a Class cannot have a default value.
  *      [25] For a TypedElement that is a kind of Parameter or Property typed by an Enumeration,
  *           the defaultValue, if any, must be a kind of InstanceValue.
  *      [26] For a TypedElement that is a kind of Parameter or Property typed by an PrimitiveType,
  *           the defaultValue, if any, must be a kind of LiteralSpecification.
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
 * @tparam Uml A tool-specific implementation of OMG UML
 */
sealed abstract class AbstractDefaultValueValidationInfo[Uml <: UML] {
  val status: DefaultValueValidationStatus
  val explanation: Option[String] = None

  import DefaultValueValidationStatus._

  def isInvalid: Boolean =
    status != ValidDefaultValueStatus

  /**
   * If invalid, is there a repair strategy? Unfortunately no.
   *
   * All violations involve a Parameter or Property that either have a default value when it there should be none
   * or that have a default value of the wrong kind. There is no generic way to fix these problems without
   * potentially loosing important information.
   *
   * @return false
   */
  def isRepairable: Boolean =
    false
}

/**
 * Validation result for the DefaultValue of a Parameter
 *
 * @param p a Parameter
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml A tool-specific implementation of OMG UML
 */
case class ParameterDefaultValueValidationInfo[Uml <: UML]
(val p: UMLParameter[Uml],
 override val status: DefaultValueValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractDefaultValueValidationInfo[Uml]

/**
 * Validation result for the DefaultValue of a kind of Property
 *
 * @param p a kind of Property
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml A tool-specific implementation of OMG UML
 */
case class PropertyDefaultValueValidationInfo[Uml <: UML]
(val p: UMLProperty[Uml],
 override val status: DefaultValueValidationStatus,
 override val explanation: Option[String] = None)
  extends AbstractDefaultValueValidationInfo[Uml]

/**
 * Validation result for a ValueSpecification as a DefaultValue for a Parameter or a kind of Property
 *
 * @param v a kind of ValueSpecification
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml A tool-specific implementation of OMG UML
 */
case class ValueSpecificationAsDefaultValueValidationInfo[Uml <: UML]
(val v: UMLValueSpecification[Uml],
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


  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[AbstractDefaultValueValidationInfo[Uml]] = {

    import umlOps._

    def makeValidDefaultValueStatusForParameter
    (p: UMLParameter[Uml])
    ()
    : Option[AbstractDefaultValueValidationInfo[Uml]] =
      Some(ParameterDefaultValueValidationInfo(
        p, ValidDefaultValueStatus))

    def makeValidDefaultValueStatusForProperty
    (p: UMLProperty[Uml])
    ()
    : Option[AbstractDefaultValueValidationInfo[Uml]] =
      Some(PropertyDefaultValueValidationInfo(
        p, ValidDefaultValueStatus))

    def makeInvalidDefaultValueForMultiValuedParameter
    (p: UMLParameter[Uml])
    ()
    : Option[AbstractDefaultValueValidationInfo[Uml]] =
      Some(ParameterDefaultValueValidationInfo(
        p, InvalidDefaultValueForMultiValuedParameterOrPropertyStatus,
        INVALID_DEFAULT_VALUE_FOR_MULTI_VALUED_PARAMETER))

    def makeInvalidDefaultValueForMultiValuedProperty
    (p: UMLProperty[Uml])
    ()
    : Option[AbstractDefaultValueValidationInfo[Uml]] =
      Some(PropertyDefaultValueValidationInfo(
        p, InvalidDefaultValueForMultiValuedParameterOrPropertyStatus,
        INVALID_DEFAULT_VALUE_FOR_MULTI_VALUED_PROPERTY))

    def makeInvalidDefaultValueForParameterOrProperty
    (v: UMLValueSpecification[Uml], status: DefaultValueValidationStatus, message: Option[String])
    : Option[AbstractDefaultValueValidationInfo[Uml]] =
      Some(ValueSpecificationAsDefaultValueValidationInfo(v, status, message))

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
        invalidDefaultValueForMultiValuedTypedElementFunction()
      else t match {
        case None =>
          None
        case Some(t) =>
          t match {
            case _: UMLClass[Uml] =>
              defaultValue match {
                case None =>
                  validParameterOrPropertyFunction()
                case Some(v) =>
                  Some(ValueSpecificationAsDefaultValueValidationInfo(
                    v, InvalidDefaultValueForClassTypedParameterOrPropertyStatus,
                    invalidDefaultValueForTypedElementMessage))
              }
            case t_enum: UMLEnumeration[Uml] =>
              defaultValue match {
                case None =>
                  validParameterOrPropertyFunction()
                case Some(v) =>
                  v match {
                    case iv: UMLInstanceValue[Uml] =>
                      iv.instance match {
                        case None =>
                          Some(ValueSpecificationAsDefaultValueValidationInfo(
                            v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                            invalidDefaultValueForEnumerationTypeMessage))
                        case Some(is) =>
                          is match {
                            case lit: UMLEnumerationLiteral[Uml] =>
                              lit.enumeration match {
                                case Some(lit_enum) if t_enum == lit_enum =>
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
                      }
                    case _ =>
                      Some(ValueSpecificationAsDefaultValueValidationInfo(
                        v, InvalidDefaultValueForEnumerationTypedParameterOrPropertyStatus,
                        invalidDefaultValueForEnumerationTypeMessage))
                  }
              }
            case _: UMLPrimitiveType[Uml] =>
              defaultValue match {
                case None =>
                  validParameterOrPropertyFunction()
                case Some(v) =>
                  v match {
                    case _: UMLLiteralSpecification[Uml] =>
                      Some(ValueSpecificationAsDefaultValueValidationInfo(
                        v, ValidDefaultValueStatus))
                    case _ =>
                      Some(ValueSpecificationAsDefaultValueValidationInfo(
                        v, InvalidDefaultValueForPrimitiveTypeTypedParameterOrPropertyStatus,
                        invalidDefaultValueForPrimitiveTypeMessage))
                  }
              }
            case _ =>
              None
          }
      }

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