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

trait UMLPropertyOps[Uml <: UML] { self: UMLProperty[Uml] =>

  import self.ops._

  def owningAssociation: Option[UMLAssociation[Uml]] = owner match {   
    case Some(a: UMLAssociation[Uml]) => Some(a)
    case _ => None
  }
  
  def _class: Option[UMLClass[Uml]] = owner match { 
    case Some(c: UMLClass[Uml]) => Some(c)
    case _ => None
  }
  
  def datatype: Option[UMLDataType[Uml]] = owner match { 
    case Some(dt: UMLDataType[Uml]) => Some(dt)
    case _ => None
  }
  
  def _interface: Option[UMLInterface[Uml]] = owner match { 
    case Some(i: UMLInterface[Uml]) => Some(i)
    case _ => None
  }
  
  def owningStereotype: Option[UMLStereotype[Uml]] = owner match { 
    case Some(s: UMLStereotype[Uml]) => Some(s)
    case _ => None
  }
  
  def isLogicallyNavigable: Boolean = 
    association match {
    case None => false
    case Some( a ) => 
      opposite match {
        case None => false
        case Some( that ) =>
          val thisAssociationOwned = owningAssociation.isDefined
          val thisComposite = isComposite
          val thisNavigableOwnedEnd = navigableOwnedEnd_association.isDefined
      
          val thatAssociationOwned = that.owningAssociation.isDefined
          val thatComposite = that.isComposite
          val thatNavigableOwnedEnd = that.navigableOwnedEnd_association.isDefined
      
          //System.out.println(s"p ${e.qualifiedName.get} opposite: ${opposite.qualifiedName.get}")
          System.out.println(s" thisAssociationOwned=${thisAssociationOwned}")
          System.out.println(s" thisComposite=${thisComposite}")
          System.out.println(s" thisNavigableOwnedEnd=${thisNavigableOwnedEnd}")
      
          System.out.println(s" thatAssociationOwned=${thatAssociationOwned}")
          System.out.println(s" thatComposite=${thatComposite}")
          System.out.println(s" thatNavigableOwnedEnd=${thatNavigableOwnedEnd}")
          val case1 = (! thisAssociationOwned && thatAssociationOwned )
          val case2 = ( thisAssociationOwned == thatAssociationOwned && thisComposite && ! thatComposite )
          val case3 = ( thisAssociationOwned && thatAssociationOwned && thisNavigableOwnedEnd && !thatNavigableOwnedEnd )
          System.out.println(s" case1=${case1} case2=${case2} case3=${case3}")
          case1 || case2 || case3
      }
  }
    
  def isSemanticallyNavigable: Boolean =
    isLogicallyNavigable || 
    closure( this, ( x: UMLProperty[Uml] ) => x.subsettedProperty ).exists( _.isLogicallyNavigable ) ||
    closure( this, ( x: UMLProperty[Uml] ) => x.redefinedProperty ).exists( _.isLogicallyNavigable )

}