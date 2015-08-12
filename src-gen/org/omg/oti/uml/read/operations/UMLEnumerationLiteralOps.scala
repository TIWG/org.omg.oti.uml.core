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

import org.omg.oti.uml.read.api.{UML, UMLEnumerationLiteral, UMLEnumeration}

import scala.language.postfixOps
// End of user code

/**
 * An EnumerationLiteral is a user-defined data value for an Enumeration.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLEnumerationLiteralOps[Uml <: UML] { self: UMLEnumerationLiteral[Uml] =>

  import self.ops._

  /**
   * The classifier of this EnumerationLiteral derived to be equal to its Enumeration.
   *
   * <!-- Start of user code doc for classifier -->
   * <!-- End of user code doc for classifier -->
   *
   * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   * @opposite org.omg.oti.api.UMLEnumeration.classifier_enumerationLiteral
   * @body result = (enumeration)
   */
  override def classifier: Iterable[UMLEnumeration[Uml]] = {
    // Start of user code for "classifier"
    enumeration
    // End of user code
  }

  /**
   * The Enumeration that this EnumerationLiteral is a member of.
   *
   * <!-- Start of user code doc for enumeration -->
   * <!-- End of user code doc for enumeration -->
   *
   * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
   * @opposite org.omg.oti.api.UMLEnumeration.ownedLiteral
   */
  def enumeration: Option[UMLEnumeration[Uml]] =
    namespace
    .selectByKindOf { case x: UMLEnumeration[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLEnumerationLiteralOps
