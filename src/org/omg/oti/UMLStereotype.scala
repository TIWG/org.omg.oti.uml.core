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

import scala.annotation._
import scala.language.postfixOps

trait UMLStereotype[Uml <: UML] extends UMLClass[Uml] {
  
  import ops._
    
  def icons: Set[UMLImage[Uml]] = ownedElements.selectByKindOf { case i: UMLImage[Uml] => i } toSet
  
  def extensionEnds: Iterable[UMLExtensionEnd[Uml]] = typedElementsOfType.selectByKindOf { case ee: UMLExtensionEnd[Uml] => ee }
  
  /**
   * Fig 12.12 (complete)
   */
  override def forwardReferencesFromMetamodelAssociations =
    stereotype_forwardReferencesFromMetamodelAssociations
    
  def stereotype_forwardReferencesFromMetamodelAssociations =
    class_forwardReferencesFromMetamodelAssociations
    
  override def compositeMetaProperties: MetaPropertyFunctions =
    stereotype_compositeMetaProperties
   
  def stereotype_compositeMetaProperties =
    class_compositeMetaProperties ++
    Seq( MetaPropertyCollection[UMLStereotype[Uml], UMLImage[Uml]]( "icon", _.icons ) )
    
  override def referenceMetaProperties: MetaPropertyFunctions =
    stereotype_referenceMetaProperties
    
  def stereotype_referenceMetaProperties =
    class_referenceMetaProperties 
    
  // [protected ('TIWG')]

  def baseMetaProperties: Iterable[UMLProperty[Uml]] = for {
    ee <- extensionEnds
    base <- ee.opposite
  } yield base
  
  def baseMetaPropertiesExceptRedefined: Iterable[UMLProperty[Uml]] = {
    val allBaseMetaProperties = baseMetaProperties.toSet
    val redefinedBaseMetaProperties = allBaseMetaProperties flatMap (_.redefinedProperties)
    allBaseMetaProperties -- redefinedBaseMetaProperties    
  }
  
  def profile: Option[UMLProfile[Uml]] = {
    
    @tailrec
    def getOwningProfile( pkg: Option[UMLPackage[Uml]] ): Option[UMLProfile[Uml]] = pkg match {
      case None => None
      case Some( pf: UMLProfile[Uml] ) => Some( pf )
      case Some( p ) => getOwningProfile( p.owningPackage )
    }
    
    getOwningProfile( owningPackage )
  }
  
  // [/protected]
  
}