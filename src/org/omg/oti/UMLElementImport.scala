package org.omg.oti

import scala.language.postfixOps

trait UMLElementImport[Uml <: UML] extends UMLDirectedRelationship[Uml] {
  
  import ops._
  
  def importingNamespace: Option[UMLNamespace[Uml]] = (sources.selectByKindOf { case ns: UMLNamespace[Uml] => ns } toIterable).headOption
  def importedElement: Option[UMLPackageableElement[Uml]] = (targets.selectByKindOf { case p: UMLPackageableElement[Uml] => p } toIterable).headOption
}