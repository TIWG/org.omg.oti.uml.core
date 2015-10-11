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

import scala.{Boolean, Enumeration, Option, None, Some}
import scala.Predef.String
import scala.collection.immutable._
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
(typedElement: UMLTypedElement[Uml],
 status: TypedElementValidationStatus,
 explanation: Option[String] = None) {

  import org.omg.oti.uml.validation.TypedElementValidationStatus._

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

  /**
   * EMOF/CMOF TypedElement validation for all TypedElements in the scope of a set of UML Packages
   *
   * @param pkgs A set of UML Packages to analyze the contents for EMOF/CMOF TypedElement validation constraints
   * @param umlOps A tool-specific OTI UML operations adapter object
   * @param idg A tool-specific OTI IDGenerator
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam UmlOps The tool-specific OTI UML operations adapter type
   * @return Where applicable, [[TypedElementValidationInfo]] results
   */
  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps, idg: IDGenerator[Uml])
  : Iterable[TypedElementValidationInfo[Uml]] = {

    val scope = pkgs.toSet
    val validationHelper = TypedElementValidationHelper(scope)
    import umlOps._
    import validationHelper._

    val validationResults = for {
      pkg <- scope
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

/**
 * Helper for EMOF/CMOF TypedElement validation
 *
 * @param scope A set of UML Packages to analyze the contents for EMOF/CMOF NamedElement validation constraints
 * @param umlOps A tool-specific OTI UML operations adapter object
 * @param idg A tool-specific OTI IDGenerator
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam UmlOps The tool-specific OTI UML operations adapter type
 */
case class TypedElementValidationHelper[Uml <: UML, UmlOps <: UMLOps[Uml]]
(scope: Set[UMLPackage[Uml]])
(implicit umlOps: UmlOps, idg: IDGenerator[Uml]) {

  import umlOps._
  import org.omg.oti.uml.validation.TypedElementValidationHelper._

  /**
   * EMOF/CMOF validation for Operation::raisedException
   *
   * @todo propagate errors.
   *
   * @see MOF 2.5, Section 12.4 EMOF Constraints
   *      [1] The type of Operation::raisedException is limited to be Class rather than Type.
   *
   * @see MOF 2.5, Section 14.4 CMOF Constraints
   *      [2] The type of Operation::raisedException is limited to be Class rather than Type.
   *
   * @param te A UML TypedElement to validate if it is a kind of UML Operation
   * @return If applicable, a [[TypedElementValidationInfo]] result
   */
  def checkOperationRaisedException(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
    te match {
      case o: UMLOperation[Uml] =>
        val nonClassTypes = (o.raisedException selectByKindOf {
          case t: UMLType[Uml] if !oclIsTypeOfClass(t) => t
        }).toList.sortBy(_.xmiOrderingKey.toOption.getOrElse("")) // @todo propagate errors
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
   * EMOF/CMOF validation for an Association as the type of a TypedElement
   *
   * Note that this rule is interpreted with respect to the scope of EMOF/CMOF incl. Profiles.
   * That is, the rule applies if and only if the type is exactly a UML Association or UML Extension.
   * The rule is not applied if the type is another kind of metaclass outside the scope of EMOF/CMOF
   * (e.g., AssociationClass or CommunicationPath)
   *
   * @see MOF 2.5, Section 12.4 EMOF Constraints
   *      [22] A TypedElement cannot be typed by an Association.
   *
   * @see MOF 2.5, Section 14.4 CMOF Constraints
   *      [22] A TypedElement cannot be typed by an Association.
   *
   * @param te A UML TypedElement to validate w.r.t. its type being a kind of UML Association
   * @return If applicable, a [[TypedElementValidationInfo]] result
   */
  def checkTypedElementWithAssociationType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
    for {
      t <- te._type
      v <- t match {
        case _: UMLAssociationClass[Uml] =>
          None
        case a: UMLAssociation[Uml] =>
          Some(TypedElementValidationInfo(
            te, InvalidTypedElementWithAssociationTypeStatus,
            Some(INVALID_TYPED_ELEMENT_WITH_ASSOCIATION_TYPE)))
        case _ =>
          None
      }
    } yield v

  /**
   * EMOF/CMOF validation for a TypedElement that must be explicitly typed
   *
   * @see MOF 2.5, Section 12.4 EMOF Constraints
   *      [23] A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type.
   *
   * @see MOF 2.5, Section 14.4 CMOF Constraints
   *      [23] A TypedElement other than a LiteralSpecification or an OpaqueExpression must have a Type.
   *
   * @param te A UML TypedElement to validate w.r.t. having a type
   * @return If applicable, a [[TypedElementValidationInfo]] result
   */
  def checkTypedElementIsTyped(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
    te match {
      case _@(_: UMLLiteralSpecification[Uml] | _: UMLOpaqueExpression[Uml]) =>
        None
      case _ =>
        te._type.fold[Option[TypedElementValidationInfo[Uml]]] {
              Some(
                TypedElementValidationInfo(
                  te, InvalidUntypedTypedElementStatus,
                  Some(INVALID_UNTYPED_TYPED_ELEMENT)))
          }{ _ =>
            None
          }
    }

  /**
   * EMOF/CMOF validation for TypedElements typed by a kind of DataType
   *
   * @see MOF 2.5, Section 12.4 EMOF Constraints
   *      [28] A Property typed by a kind of DataType must have aggregation = none.
   *
   * @see MOF 2.5, Section 14.4 CMOF Constraints
   *      [28] A Property typed by a kind of DataType must have aggregation = none.
   *
   * @param te A UML TypedElement to validate w.r.t. DataType constraints
   * @return If applicable, a [[TypedElementValidationInfo]] result
   */
  def checkAggregationForPropertyTypeByDataType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
    te match {
      case p: UMLProperty[Uml] =>
        p._type.fold[Option[TypedElementValidationInfo[Uml]]](None) {
            case _: UMLDataType[Uml] =>
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
   * EMOF/CMOF validation for TypedElements that are DataType properties
   *
   * @see MOF 2.5, Section 12.4 EMOF Constraints
   *      [29] A Property owned by a DataType can only be typed by a DataType.
   *
   * @see MOF 2.5, Section 14.4 CMOF Constraints
   *      [29] A Property owned by a DataType can only be typed by a DataType.
   *
   * @param te A UML TypedELement to validate w.r.t. DataType property constraints
   * @return If applicable, a [[TypedElementValidationInfo]] result
   */
  def checkDataTypePropertyHasDataTypeType(te: UMLTypedElement[Uml]): Option[TypedElementValidationInfo[Uml]] =
    te match {
      case p: UMLProperty[Uml] =>
        te.owner.fold[Option[TypedElementValidationInfo[Uml]]](None) {
            case _: UMLDataType[Uml] =>
              None
            case t =>
              Some(
                TypedElementValidationInfo(
                  te, InvalidDataTypePropertyWithNonDataTypeTypeStatus,
                  Some(INVALID_DATATYPE_PROPERTY_WITH_NON_DATATYPE_TYPE + t.metaclass_name)))
           }
      case _ =>
        None
    }

  /**
   * EMOF/CMOF validation for TypedElements that are Association memberEnds
   *
   * @see MOF 2.5, Section 12.4 EMOF Constraints
   *      [30] Each Association memberEnd Property must be typed by a Class.
   *
   * @see MOF 2.5, Section 14.4 CMOF Constraints
   *      [30] Each Association memberEnd Property must be typed by a Class.
   *
   * @param te A UML TypedElement to validate w.r.t. Association memberEnd constraints
   * @return If applicable, a [[TypedElementValidationInfo]] result
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


}