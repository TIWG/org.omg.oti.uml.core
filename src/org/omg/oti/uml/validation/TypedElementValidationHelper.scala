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
import org.omg.oti.uml.xmi.IDGenerator

import scala.language.postfixOps

/**
 * The different categories of validation on 'typing' rules.
 * Note: 'typing' rules for Properties & Parameters have higher precedence to default value rules.
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 *      [1] The type of Operation::raisedException is limited to be Class rather than Type.
 *      [22] A TypedElement cannot be typed by an Association.
 *      [23] A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type.
 *      [28] A Property typed by a kind of DataType must have aggregation = none.
 *      [29] A Property owned by a DataType can only be typed by a DataType.
 *      [30] Each Association memberEnd Property must be typed by a Class.
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 *      [2] The type of Operation::raisedException is limited to be Class rather than Type.
 *      [22] A TypedElement cannot be typed by an Association.
 *      [23] A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type.
 *      [28] A Property typed by a kind of DataType must have aggregation = none.
 *      [29] A Property owned by a DataType can only be typed by a DataType.
 *      [30] Each Association memberEnd Property must be typed by a Class.
 */
object TypedElementValidationStatus extends Enumeration {
  type TypedElementValidationStatus = Value

  /**
   * Valid per EMOF [1,22,23,28,29,30] & CMOF [2,22,23,28,29,30]
   */
  val ValidTypedElementStatus = Value

  /**
   * Invalid per EMOF [1] & CMOF [2]
   * (no repair strategy)
   */
  val InvalidOperationRaisedExceptionNonClassTypeStatus = Value

  /**
   * Invalid per EMOF [22] & CMOF [22]
   * (no repair strategy)
   */
  val InvalidTypedElementWithAssociationTypeStatus = Value

  /**
   * Invalid per EMOF [23] & CMOF [23]
   * (no repair strategy)
   */
  val InvalidUntypedTypedElementStatus = Value

  /**
   * Invalid per EMOF [28] & CMOF [28]
   * (repair strategy: set aggregation = none)
   */
  val InvalidDataTypePropertyAggregationStatus = Value

  /**
   * Invalid per EMOF [29] & CMOF [29]
   * (no repair strategy)
   */
  val InvalidDataTypePropertyWithNonDataTypeTypeStatus = Value

  /**
   * Invalid per EMOF [30] & CMOF [30]
   * (no repair strategy)
   */
  val InvalidAssociationMemberEndPropertyNonClassTypeStatus = Value
}

import org.omg.oti.uml.validation.TypedElementValidationStatus._

/**
 * TypedElement validation result
 *
 * @param typedElement A TypedElement
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class TypedElementValidationInfo[Uml <: UML]
(val typedElement: UMLTypedElement[Uml],
 val status: TypedElementValidationStatus,
 val explanation: Option[String] = None) {

  import TypedElementValidationStatus._

  val isInvalid: Boolean =
    status != ValidTypedElementStatus

  val isRepairable: Boolean =
    status == InvalidDataTypePropertyAggregationStatus

}

object TypedElementValidationHelper {

  val INVALID_OPERATION_RAISED_EXCEPTION_NON_CLASS_TYPE =
    "Operation::raisedException must be a kind of Class."

  val INVALID_TYPED_ELEMENT_WITH_ASSOCIATION_TYPE =
    "A TypedElement cannot be typed by an Association"

  val INVALID_UNTYPED_TYPED_ELEMENT =
    "A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type"

  val INVALID_DATATYPE_PROPERTY_AGGREGATION =
    "A Property typed by a kind of DataType must have aggregation = none instead of: "

  val INVALID_DATATYPE_PROPERTY_WITH_NON_DATATYPE_TYPE =
    "A Property owned by a DataType can only be typed by a DataType instead of a "

  val INVALID_ASSOCIATION_MEMBER_END_PROPERTY_NON_CLASS_TYPE =
    "Each Association memberEnd Property must be typed by a Class instead of a "

  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps, idg: IDGenerator[Uml])
  : Iterable[TypedElementValidationInfo[Uml]] = {

    import umlOps._

    /**
     * @see MOF 2.5, Section 12.4 EMOF Constraints
     *      [1] The type of Operation::raisedException is limited to be Class rather than Type.
     *
     * @see MOF 2.5, Section 14.4 CMOF Constraints
     *      [2] The type of Operation::raisedException is limited to be Class rather than Type.
     */
    def checkOperationRaisedException(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
      te match {
        case o: UMLOperation[Uml] =>
          val nonClassTypes = (o.raisedException selectByKindOf {
            case t: UMLType[Uml] if !oclIsTypeOfClass(t) => t
          }).toList.sortBy(_.xmiOrderingKey)
          if (nonClassTypes.isEmpty)
            None
          else
            Some(
              TypedElementValidationInfo(
                o, InvalidOperationRaisedExceptionNonClassTypeStatus,
                Some(
                  INVALID_OPERATION_RAISED_EXCEPTION_NON_CLASS_TYPE +
                    nonClassTypes.map(_.xmiOrderingKey).mkString("\nNon-class Exception types:", "\n", ""))))
        case _ =>
          None
      }

    /**
     * @see MOF 2.5, Section 12.4 EMOF Constraints
     *      [22] A TypedElement cannot be typed by an Association.
     *
     * @see MOF 2.5, Section 14.4 CMOF Constraints
     *      [22] A TypedElement cannot be typed by an Association.
     */
    def checkTypedElementWithAssociationType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
      for {
        t <- te._type
        v <- t match {
          case a: UMLAssociation[Uml] =>
            Some(TypedElementValidationInfo(
              te, InvalidTypedElementWithAssociationTypeStatus,
              Some(INVALID_TYPED_ELEMENT_WITH_ASSOCIATION_TYPE)))
          case _ =>
            None
        }
      } yield v

    /**
     * @see MOF 2.5, Section 12.4 EMOF Constraints
     *      [23] A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type.
     *
     * @see MOF 2.5, Section 14.4 CMOF Constraints
     *      [23] A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type.
     */
    def checkTypedElementIsTyped(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
      te match {
        case _@(_: UMLLiteralSpecification[Uml] | _: UMLOpaqueExpression[Uml]) =>
          None
        case _ =>
          te._type match {
            case Some(_) =>
              None
            case None =>
              Some(
                TypedElementValidationInfo(
                  te, InvalidUntypedTypedElementStatus,
                  Some(INVALID_UNTYPED_TYPED_ELEMENT)))
          }
      }

    /**
     * @see MOF 2.5, Section 12.4 EMOF Constraints
     *      [28] A Property typed by a kind of DataType must have aggregation = none.
     *
     * @see MOF 2.5, Section 14.4 CMOF Constraints
     *      [28] A Property typed by a kind of DataType must have aggregation = none.
     */
    def checkAggregationForPropertyTypeByDataType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
      te match {
        case p: UMLProperty[Uml] =>
          p._type match {
            case Some(_: UMLDataType[Uml]) =>
              p.aggregation match {
                case UMLAggregationKind.none =>
                  None
                case k =>
                  Some(
                    TypedElementValidationInfo(
                      te, InvalidDataTypePropertyAggregationStatus,
                      Some(INVALID_DATATYPE_PROPERTY_AGGREGATION + k.toString)))
              }
            case _ =>
              None
          }
        case _ =>
          None
      }

    /**
     * @see MOF 2.5, Section 12.4 EMOF Constraints
     *      [29] A Property owned by a DataType can only be typed by a DataType.
     *
     * @see MOF 2.5, Section 14.4 CMOF Constraints
     *      [29] A Property owned by a DataType can only be typed by a DataType.
     */
    def checkDataTypePropertyHasDataTypeType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
      (te.owner, te) match {
        case (Some(_: UMLDataType[Uml]), p: UMLProperty[Uml]) =>
          p._type match {
            case Some(_: UMLDataType[Uml]) =>
              None
            case Some(t) =>
              Some(
                TypedElementValidationInfo(
                  te, InvalidDataTypePropertyWithNonDataTypeTypeStatus,
                  Some(INVALID_DATATYPE_PROPERTY_WITH_NON_DATATYPE_TYPE + t.metaclass_name)))
            case None =>
              None
          }
        case _ =>
          None
      }

    /**
     * @see MOF 2.5, Section 12.4 EMOF Constraints
     *      [30] Each Association memberEnd Property must be typed by a Class.
     *
     * @see MOF 2.5, Section 14.4 CMOF Constraints
     *      [30] Each Association memberEnd Property must be typed by a Class.
     */
    def checkAssociationMemberEndHasClassType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
      te match {
        case p: UMLProperty[Uml] =>
          (p.association, p._type) match {
            case (Some(_), Some(t)) if !oclIsTypeOfClass(t) =>
              Some(
                TypedElementValidationInfo(
                  te, InvalidAssociationMemberEndPropertyNonClassTypeStatus,
                  Some(INVALID_ASSOCIATION_MEMBER_END_PROPERTY_NON_CLASS_TYPE + t.metaclass_name)))
            case _ =>
              None
          }
        case _ =>
          None
      }

    val validationResults = for {
      pkg <- pkgs
      tes: Set[UMLTypedElement[Uml]] =
      closure[UMLNamedElement[Uml], UMLNamedElement[Uml]](
        pkg, _.ownedElement selectByKindOf { case ne: UMLNamedElement[Uml] => ne }) selectByKindOf {
        case te: UMLTypedElement[Uml] => te
      }
      te <- tes
      vs = checkOperationRaisedException(te) ++
        checkTypedElementWithAssociationType(te) ++
        checkTypedElementIsTyped(te) ++
        checkAggregationForPropertyTypeByDataType(te) ++
        checkDataTypePropertyHasDataTypeType(te) ++
        checkAssociationMemberEndHasClassType(te)
      v <- if (vs.nonEmpty) vs else Iterable(TypedElementValidationInfo(te, ValidTypedElementStatus))
    } yield v

    validationResults

  }
}