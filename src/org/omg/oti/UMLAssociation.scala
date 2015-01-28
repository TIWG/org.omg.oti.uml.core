package org.omg.oti

trait UMLAssociation[Uml <: UML] extends UMLClassifier[Uml] with UMLRelationship[Uml] {

  implicit val ops: UMLOps[Uml]
  import ops._

  def isDerived: Boolean
  def ownedEnds: Iterator[UMLProperty[Uml]]
  def navigableOwnedEnds: Iterator[UMLProperty[Uml]]
  def memberEnds: Iterator[UMLProperty[Uml]]
  def endTypes: Iterator[UMLType[Uml]]

  def getDirectedAssociationEnds: Option[( UMLProperty[Uml], UMLProperty[Uml] )] = 
    memberEnds.toList match {
      case end1 :: end2 :: Nil =>
        ( end1.isLogicallyNavigable, end2.isLogicallyNavigable ) match {
          case ( true, false ) => Some( ( end2, end1 ) )
          case ( false, true ) => Some( ( end1, end2 ) )
          case ( _, _ ) =>
            ( end1.isSemanticallyNavigable, end2.isSemanticallyNavigable ) match {
              case ( true, false ) => Some( ( end2, end1 ) )
              case ( false, true ) => Some( ( end1, end2 ) )
              case ( _, _ ) => None
            }
        }
      case _ => None
    }
}