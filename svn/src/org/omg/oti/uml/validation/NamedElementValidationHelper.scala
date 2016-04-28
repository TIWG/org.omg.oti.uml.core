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
import scala.Predef.String
import scala.collection.immutable._

/**
 * The different categories of validation for the name of [[org.omg.oti.uml.read.api.UMLNamedElement named elements]].
 *
 * @see MOF 2.5, Section 12.4 EMOF Constraints
 *
 * [3] Names are required for all [[org.omg.oti.uml.read.api.UMLNamedElement NamedElements]]
 *     except for [[org.omg.oti.uml.read.api.UMLValueSpecification ValueSpecifications]].
 *
 * @see MOF 2.5, Section 14.4 CMOF Constraints
 *
 * [6] Names are required for all [[org.omg.oti.uml.read.api.UMLNamedElement NamedElements]]
 *     except for [[org.omg.oti.uml.read.api.UMLValueSpecification ValueSpecifications]].
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

import org.omg.oti.uml.validation.NamedElementValidationStatus._

/**
 * NamedElement name validation result
 *
 * @param namedElement A [[org.omg.oti.uml.read.api.UMLNamedElement UML NamedElement]]
 * @param status validation status
 * @param explanation if invalid, an explanation for humans
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
case class NamedElementNameValidationInfo[Uml <: UML]
(namedElement: UMLNamedElement[Uml],
 status: NamedElementValidationStatus,
 explanation: Option[String] = None) {

  import org.omg.oti.uml.validation.NamedElementValidationStatus._

  val isInvalid: Boolean =
    status != ValidNamedElementNameStatus

  val isRepairable: Boolean =
    false

}

object NamedElementValidationHelper {

  val INVALID_UNNAMED_NAMED_ELEMENT =
    Some("A name is required for all kinds of NamedElements except for ValueSpecifications")


  /**
   * EMOF/CMOF [[org.omg.oti.uml.read.api.UMLNamedElement UML NamedElement]] validation
   * for the scope of a set of [[org.omg.oti.uml.read.api.UMLPackage UML Packages]]
   *
   * @param pkgs A set of UML Packages to analyze the contents for EMOF/CMOF NamedElement validation constraints
   * @param umlOps A tool-specific OTI UML operations adapter object
   * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
   * @tparam UmlOps The tool-specific OTI UML operations adapter type
   * @return Where applicable, [[NamedElementNameValidationInfo]] results
   */
  def analyzePackageContents[Uml <: UML, UmlOps <: UMLOps[Uml]]
  (pkgs: Iterable[UMLPackage[Uml]])
  (implicit umlOps: UmlOps): Iterable[NamedElementNameValidationInfo[Uml]] = {

    val scope = pkgs.toSet
    val validationHelper = NamedElementValidationHelper(scope)
    import umlOps._
    import validationHelper._

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

/**
 * Helper for EMOF/CMOF [[org.omg.oti.uml.read.api.UMLNamedElement UML NamedElement]] validation
 *
 * @param scope set of [[org.omg.oti.uml.read.api.UMLPackage UML Packages]] to analyze the contents for EMOF/CMOF
 *              [[org.omg.oti.uml.read.api.UMLNamedElement UML NamedElement]] validation constraints
 * @param umlOps A tool-specific OTI UML operations adapter object
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 * @tparam UmlOps The tool-specific OTI UML operations adapter type
 */
case class NamedElementValidationHelper[Uml <: UML, UmlOps <: UMLOps[Uml]]
(scope: Set[UMLPackage[Uml]])
(implicit umlOps: UmlOps) {

  import org.omg.oti.uml.validation.NamedElementValidationHelper._

  /**
   * EMOF/CMOF [[org.omg.oti.uml.read.api.UMLNamedElement UML NamedElement]] validation
   *
   * @param ne A [[org.omg.oti.uml.read.api.UMLNamedElement UML NamedElement]] to validate
   * @return If applicable, a [[NamedElementNameValidationInfo]] result
   */
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


}