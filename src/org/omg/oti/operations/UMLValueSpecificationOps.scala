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
package org.omg.oti.operations

import org.omg.oti._

import scala.language.postfixOps

trait UMLValueSpecificationOps[Uml <: UML] { self: UMLValueSpecification[Uml] =>

  import self.ops._

  // [protected (TIWG)]

  def owningSlot: Option[UMLSlot[Uml]] = owner.asInstanceOf[Option[UMLSlot[Uml]]]
  def owningInstanceSpec: Option[UMLInstanceSpecification[Uml]] = owner.asInstanceOf[Option[UMLInstanceSpecification[Uml]]]

  /**
   * A ValueSpecification that is the value of a stereotype tag property may constitute
   * a forward reference to another element.
   */
  def forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]]
  
  /**
   * A ValueSpecification VS that is the value of a stereotype tag property S::P for a
   * stereotype S applied to an element E induces a set of elements, 
   * VS.compositeReferencesFromStereotypeTagValue, each of which
   * is considered to be exclusively and compositionally referenced from E.
   * 
   * @invariant For any VS, VS.compositeReferencesFromStereotypeTagValue includes VS. 
   */
  final def compositeReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] =
    Set(self) ++ self.allOwnedElements.flatMap(_.compositeReferencesFromStereotypeTagPropertyValues)
  
  // [/protected]
}