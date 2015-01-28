package org.omg.oti

import scala.language.postfixOps

trait UMLPackageImport[Uml <: UML] extends UMLDirectedRelationship[Uml] {

  import ops._
  
  def importingNamespace: Option[UMLNamespace[Uml]] = (sources.selectByKindOf { case ns: UMLNamespace[Uml] => ns } toIterable).headOption
  def importedPackage: Option[UMLPackage[Uml]] = (targets.selectByKindOf { case p: UMLPackage[Uml] => p } toIterable).headOption
}