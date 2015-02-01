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
package org.omg.oti

import scala.language.implicitConversions
import scala.reflect.ClassTag

trait UMLProperty[Uml <: UML] extends UMLConnectableElement[Uml] with UMLStructuralFeature[Uml] {
  
  import ops._
  
  // [protected ('aggregation')]
  /**
   * OMG UML 2.5 defines Property::aggregation : AggregationKind { none, shared, composite }
   * Here, we only distinguish: none, composite (that is, shared is equivalent to none)
   */
  def isComposite: Boolean = false
  // [/protected]
  
  def isDerived: Boolean = false
  def isUnion: Boolean = false
  def isID: Boolean = false
  
  def defaultValue: Option[UMLValueSpecification[Uml]]
  
  def opposite: Option[UMLProperty[Uml]] 
  
  def association_navigableOwnedEnd: Option[UMLAssociation[Uml]]
  
  def association_memberEnd: Option[UMLAssociation[Uml]]
  
  def subsettedProperties: Iterable[UMLProperty[Uml]]
  def redefinedProperties: Iterable[UMLProperty[Uml]] = redefinedElements.selectByKindOf { case p: UMLProperty[Uml] => p }
  
  /**
   * Fig 9.10 (incomplete)
   * - DeploymentTarget
   */
  override def forwardReferencesFromMetamodelAssociations =
    property_forwardReferencesFromMetamodelAssociations
    
  def property_forwardReferencesFromMetamodelAssociations =
    connectableElement_forwardReferencesFromMetamodelAssociations ++
    structuralFeature_forwardReferencesFromMetamodelAssociations ++
    association_memberEnd ++
    redefinedProperties ++
    subsettedProperties
    
  override def compositeMetaProperties: MetaPropertyFunctions =
    property_compositeMetaProperties
    
  def property_compositeMetaProperties: MetaPropertyFunctions =
    connectableElement_compositeMetaProperties ++
    structuralFeature_compositeMetaProperties ++
    Seq(
        MetaPropertyFunction[UMLProperty[Uml], UMLValueSpecification[Uml]]( "defaultValue", _.defaultValue )
        )
    
  override def referenceMetaProperties: MetaPropertyFunctions =
    property_referenceMetaProperties
    
  def property_referenceMetaProperties: MetaPropertyFunctions =
    connectableElement_referenceMetaProperties ++
    structuralFeature_referenceMetaProperties ++
    Seq(
        MetaPropertyFunction[UMLProperty[Uml], UMLAssociation[Uml]]( "association", _.association_memberEnd ),
        MetaPropertyFunction[UMLProperty[Uml], UMLProperty[Uml]]( "redefinedProperty", _.redefinedProperties ),
        MetaPropertyFunction[UMLProperty[Uml], UMLProperty[Uml]]( "subsettedProperty", _.subsettedProperties )
        )
    
  def owningAssociation: Option[UMLAssociation[Uml]] = owner match {   
    case Some(a: UMLAssociation[Uml]) => Some(a)
    case _ => None
  }
  
  def owningClass: Option[UMLClass[Uml]] = owner match { 
    case Some(c: UMLClass[Uml]) => Some(c)
    case _ => None
  }
  
  def isLogicallyNavigable: Boolean = 
    association_memberEnd match {
    case None => false
    case Some( a ) => 
      opposite match {
        case None => false
        case Some( that ) =>
          val thisAssociationOwned = owningAssociation.isDefined
          val thisComposite = isComposite
          val thisNavigableOwnedEnd = association_navigableOwnedEnd.isDefined
      
          val thatAssociationOwned = that.owningAssociation.isDefined
          val thatComposite = that.isComposite
          val thatNavigableOwnedEnd = that.association_navigableOwnedEnd.isDefined
      
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
    closure( this, ( x: UMLProperty[Uml] ) => x.subsettedProperties ).exists( _.isLogicallyNavigable ) ||
    closure( this, ( x: UMLProperty[Uml] ) => x.redefinedProperties ).exists( _.isLogicallyNavigable )

}