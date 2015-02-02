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

trait UMLDependency[Uml <: UML] extends UMLPackageableElement[Uml] with UMLDirectedRelationship[Uml] {

  import ops._
  
  def clients: Iterable[UMLNamedElement[Uml]] = sources.selectByKindOf { case ne: UMLNamedElement[Uml] => ne }
  def suppliers: Iterable[UMLNamedElement[Uml]] = targets.selectByKindOf { case ne: UMLNamedElement[Uml] => ne }
    
  /**
   * Fig 7.17 (complete)
   */
  override def metaAttributes: MetaAttributeFunctions =
    dependency_metaAttributes
  
  def dependency_metaAttributes: MetaAttributeFunctions =
    packageableElement_metaAttributes  
    
  override def forwardReferencesFromMetamodelAssociations =     
    packageableElement_forwardReferencesFromMetamodelAssociations ++
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
    clients ++
    suppliers

  override def compositeMetaProperties: MetaPropertyFunctions = 
    packageableElement_compositeMetaProperties
    
  override def referenceMetaProperties: MetaPropertyFunctions = 
    packageableElement_compositeMetaProperties ++
    Seq( 
        MetaPropertyCollection[UMLDependency[Uml], UMLNamedElement[Uml]]( "client", _.clients ),
        MetaPropertyCollection[UMLDependency[Uml], UMLNamedElement[Uml]]( "supplier", _.suppliers ))
}