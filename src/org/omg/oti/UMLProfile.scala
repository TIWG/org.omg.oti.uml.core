package org.omg.oti

trait UMLProfile[Uml <: UML] extends UMLPackage[Uml] {
  
  import ops._
  
  def appliedProfileOfProfileApplications: Set[UMLProfileApplication[Uml]] = targetOfDirectedRelationships.selectByKindOf { case pa: UMLProfileApplication[Uml] => pa }
  
  def metamodelReferences: Set[UMLPackageImport[Uml]]
  def metaclassReferences: Set[UMLElementImport[Uml]]
}