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
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
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