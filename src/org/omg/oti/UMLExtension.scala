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

trait UMLExtension[Uml <: UML] extends UMLAssociation[Uml] {
  
  import ops._
    
  def metaclass: Option[UMLClass[Uml]] = (for { p <- (memberEnds.toSet -- ownedEnds.toSet).headOption } yield p._type.selectByKindOf { case c: UMLClass[Uml] => c }).flatten
  
  override def ownedEnds: Iterable[UMLExtensionEnd[Uml]] = {
    val extensionOwnedEnds = this.asInstanceOf[UMLAssociation[Uml]].ownedEnds.selectByKindOf { case ee: UMLExtensionEnd[Uml] => ee }
    require( extensionOwnedEnds.size <= 1 )
    extensionOwnedEnds
  }
  
  /**
   * Fig 12.12 (complete)
   */
  override def forwardReferencesFromMetamodelAssociations =
    extension_forwardReferencesFromMetamodelAssociations
    
  def extension_forwardReferencesFromMetamodelAssociations =
    association_forwardReferencesFromMetamodelAssociations
    
  override def compositeMetaProperties: MetaPropertyFunctions =
    extension_compositeMetaProperties
    
  def extension_compositeMetaProperties: MetaPropertyFunctions =
    association_compositeMetaProperties
    
  override def referenceMetaProperties: MetaPropertyFunctions =
    extension_referenceMetaProperties
    
  def extension_referenceMetaProperties: MetaPropertyFunctions =
    association_referenceMetaProperties
}