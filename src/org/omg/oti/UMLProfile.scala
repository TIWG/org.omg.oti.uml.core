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

trait UMLProfile[Uml <: UML] extends UMLPackage[Uml] {
  
  import ops._
  
  def profileApplications_appliedProfile: Set[UMLProfileApplication[Uml]] = directedRelationships_target.selectByKindOf { case pa: UMLProfileApplication[Uml] => pa }
  
  def metamodelReferences: Set[UMLPackageImport[Uml]]
  def metaclassReferences: Set[UMLElementImport[Uml]]
   
  /**
   * Fig 12.12 (complete)
   */
  override def metaAttributes: MetaAttributeFunctions =
    profile_metaAttributes

  def profile_metaAttributes: MetaAttributeFunctions =
    package_metaAttributes
      
  override def forwardReferencesFromMetamodelAssociations =
    profile_forwardReferencesFromMetamodelAssociations

  def profile_forwardReferencesFromMetamodelAssociations =    
    package_forwardReferencesFromMetamodelAssociations
    
  override def compositeMetaProperties: MetaPropertyFunctions =
    profile_compositeMetaProperties
    
  def profile_compositeMetaProperties =
    package_compositeMetaProperties
  override def referenceMetaProperties: MetaPropertyFunctions =
    profile_referenceMetaProperties
    
  def profile_referenceMetaProperties =
    package_referenceMetaProperties ++
    Seq(
        MetaPropertyCollection[UMLProfile[Uml], UMLElementImport[Uml]]( "metaclassReference", _.metaclassReferences ),
        MetaPropertyCollection[UMLProfile[Uml], UMLPackageImport[Uml]]( "metamodelReference", _.metamodelReferences )
        )

}