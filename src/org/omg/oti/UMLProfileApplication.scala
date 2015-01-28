package org.omg.oti

import scala.language.postfixOps

trait UMLProfileApplication[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  
  import ops._
  
  def applyingPackage: Option[UMLPackage[Uml]] = (sources.selectByKindOf { case p: UMLPackage[Uml] => p } toIterable).headOption
  def appliedProfile: Option[UMLProfile[Uml]] = (targets.selectByKindOf { case p: UMLProfile[Uml] => p } toIterable).headOption

}