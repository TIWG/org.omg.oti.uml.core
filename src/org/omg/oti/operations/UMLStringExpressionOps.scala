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

trait UMLStringExpressionOps[Uml <: UML] { self: UMLStringExpression[Uml] =>

  import self.ops._
  
	def owningExpression: Option[UMLStringExpression[Uml]] =    
    owner.selectByKindOf { case e: UMLStringExpression[Uml] => e }
  
  def nameExpression_namedElement: Option[UMLNamedElement[Uml]] =
    owner.selectByKindOf { case ne: UMLNamedElement[Uml] => ne }
  
  override def forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    stringExpression_forwardReferencesFromStereotypeTagValue
    
  /**
   * A string expression that is the value of a stereotype tag property is considered part of the forward references
   * from the element on which the stereotype is applied; other parts include the sub-expressions of the string expression
   * and the parts from the string expression as a kind of expression.
   */
  def stringExpression_forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    expression_forwardReferencesFromStereotypeTagValue ++ subExpression.toSet

}