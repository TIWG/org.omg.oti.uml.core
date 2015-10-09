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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.UMLError
import org.omg.oti.uml.read.api._
import scala.Int
import scala.{Option,None,Some}
import scalaz._, Scalaz._

// End of user code

/**
 * A Comment is a textual annotation that can be attached to a set of Elements.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLCommentOps[Uml <: UML] { self: UMLComment[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


	/**
	 * <!-- Start of user code doc for ownedComment_owningElement -->
   * <!-- End of user code doc for ownedComment_owningElement -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLElement.ownedComment
	 */
	def ownedComment_owningElement: Option[UMLElement[Uml]] = owner

	// Start of user code for additional features

  def getCommentOwnerIndex: Int

  /**
   * is this comment representing the characteristics for a single annotated package
   * as the root of a specification publishable artifact?
   *
   * @return True iff the <<OTI::SpecificationRootCharacterization>> stereotype is applied and
   *         the set of annotated elements is a singleton kind of Package
   */
  def getSpecificationRootCharacterizedPackage
	: ValidationNel[UMLError[Uml]#UException, Option[UMLPackage[Uml]]] =
    OTI_SPECIFICATION_ROOT_CHARACTERIZATION_S
    .fold[ValidationNel[UMLError[Uml]#UException, Option[UMLPackage[Uml]]]](
    fail = Validation.failure(_),
    succ = (s) =>
    if (!hasStereotype(s) || 1 != annotatedElement.size)
      None.success
    else
     annotatedElement
     .headOption
     .fold[ValidationNel[UMLError[Uml]#UException, Option[UMLPackage[Uml]]]](None.success) {
      case annotatedP: UMLPackage[Uml] =>
        Some(annotatedP).success
      case _ =>
        None.success
    })

  // End of user code
} //UMLCommentOps
