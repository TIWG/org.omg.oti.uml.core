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

  def expr_duration: Option[UMLDuration[Uml]] =
    owner.selectByKindOf { case d: UMLDuration[Uml] => d }    
  
  def guard_activityEdge: Option[UMLActivityEdge[Uml]] =
    owner.selectByKindOf { case e: UMLActivityEdge[Uml] => e }    
  
  def operand_expression: Option[UMLExpression[Uml]] =
    owner.selectByKindOf { case e: UMLExpression[Uml] => e } 
  
  def value_owningSlot: Option[UMLSlot[Uml]] = 
    owner.selectByKindOf { case s: UMLSlot[Uml] => s }   
  
  def changeExpression_changeEvent: Option[UMLChangeEvent[Uml]] =
    owner.selectByKindOf { case e: UMLChangeEvent[Uml] => e } 
  
  def returnValue_interactionUse: Option[UMLInteractionUse[Uml]] =
    owner.selectByKindOf { case iu: UMLInteractionUse[Uml] => iu } 
  
  def lowerValue_owningLower: Option[UMLMultiplicityElement[Uml]] =
    owner.selectByKindOf { case e: UMLMultiplicityElement[Uml] => e } 
  
  def value_valuePin: Option[UMLValuePin[Uml]] =
    owner.selectByKindOf { case vp: UMLValuePin[Uml] => vp } 
  
	def maxint_interactionConstraint: Option[UMLInteractionConstraint[Uml]] =
    owner.selectByKindOf { case ic: UMLInteractionConstraint[Uml] => ic }
  
  def upperValue_owningUpper: Option[UMLMultiplicityElement[Uml]] =
    owner.selectByKindOf { case e: UMLMultiplicityElement[Uml] => e } 
  
  def argument_message: Option[UMLMessage[Uml]] =
    owner.selectByKindOf { case m: UMLMessage[Uml] => m } 
  
  def argument_interactionUse: Option[UMLInteractionUse[Uml]] =
    owner.selectByKindOf { case iu: UMLInteractionUse[Uml] => iu } 
  
  def joinSpec_joinNode: Option[UMLJoinNode[Uml]] =
    owner.selectByKindOf { case jn: UMLJoinNode[Uml] => jn } 
  
  def value_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]] =
    owner.selectByKindOf { case vsa: UMLValueSpecificationAction[Uml] => vsa } 
  
  def upperBound_objectNode: Option[UMLObjectNode[Uml]] =
    owner.selectByKindOf { case on: UMLObjectNode[Uml] => on } 
  
  def specification_owningConstraint: Option[UMLConstraint[Uml]] =
    owner.selectByKindOf { case c: UMLConstraint[Uml] => c } 
    
  def specification_owningInstanceSpec: Option[UMLInstanceSpecification[Uml]] =
    owner.selectByKindOf { case is: UMLInstanceSpecification[Uml] => is } 
  
  def expr_timeExpression: Option[UMLTimeExpression[Uml]] =
    owner.selectByKindOf { case e: UMLTimeExpression[Uml] => e } 
  
  def defaultValue_owningProperty: Option[UMLProperty[Uml]] =
    owner.selectByKindOf { case p: UMLProperty[Uml] => p } 
  
  def selector_lifeline: Option[UMLLifeline[Uml]] =
    owner.selectByKindOf { case e: UMLLifeline[Uml] => e } 
  
  def weight_activityEdge: Option[UMLActivityEdge[Uml]] =
    owner.selectByKindOf { case e: UMLActivityEdge[Uml] => e } 
  
  def defaultValue_owningParameter: Option[UMLParameter[Uml]] =
    owner.selectByKindOf { case p: UMLParameter[Uml] => p } 
  
  def minint_interactionConstraint: Option[UMLInteractionConstraint[Uml]] =
    owner.selectByKindOf { case ic: UMLInteractionConstraint[Uml] => ic } 

  /**
   * A ValueSpecification that is the value of a stereotype tag property may constitute
   * a forward reference to another element.
   */
  def forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = Set()
  
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