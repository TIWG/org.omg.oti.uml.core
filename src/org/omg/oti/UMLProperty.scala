package org.omg.oti

import scala.language.implicitConversions
import scala.reflect.ClassTag

trait UMLProperty[Uml <: UML] extends UMLStructuralFeature[Uml] with UMLConnectableElement[Uml] {
  
  implicit val ops: UMLOps[Uml]
  import ops._
  
  def isComposite: Boolean
  
  def opposite: Option[UMLProperty[Uml]] 
  
  def navigableOwnedEndOfAssociation: Option[UMLAssociation[Uml]]
  
  def memberEndOfAssociation: Option[UMLAssociation[Uml]]
  
  def subsettedProperties: Iterator[UMLProperty[Uml]]
  def redefinedProperties: Iterator[UMLProperty[Uml]]
  
  def owningAssociation: Option[UMLAssociation[Uml]] = owner match {   
    case Some(a: UMLAssociation[Uml]) => Some(a)
    case _ => None
  }
  
  def owningClass: Option[UMLClass[Uml]] = owner match { 
    case Some(c: UMLClass[Uml]) => Some(c)
    case _ => None
  }
  
  def isLogicallyNavigable: Boolean = 
    memberEndOfAssociation match {
    case None => false
    case Some( a ) => 
      opposite match {
        case None => false
        case Some( that ) =>
          val thisAssociationOwned = owningAssociation.isDefined
          val thisComposite = isComposite
          val thisNavigableOwnedEnd = navigableOwnedEndOfAssociation.isDefined
      
          val thatAssociationOwned = that.owningAssociation.isDefined
          val thatComposite = that.isComposite
          val thatNavigableOwnedEnd = that.navigableOwnedEndOfAssociation.isDefined
      
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