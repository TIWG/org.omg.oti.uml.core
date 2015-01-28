package org.omg.oti

import scala.annotation._

trait UMLStereotype[Uml <: UML] extends UMLClass[Uml] {
  
  import ops._
  
  def profile: Option[UMLProfile[Uml]] = {
    
    @tailrec
    def getOwningProfile( pe: UMLPackageableElement[Uml] ): Option[UMLProfile[Uml]] = 
      pe.owningPackage match {
      case None => None
      case Some( pf: UMLProfile[Uml] ) => Some( pf )
      case Some( p: UMLPackage[Uml] ) => getOwningProfile( p )
    }
    
    getOwningProfile( this )
  }
}