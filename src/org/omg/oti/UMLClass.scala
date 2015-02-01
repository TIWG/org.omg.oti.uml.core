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

trait UMLClass[Uml <: UML] extends UMLBehavioredClassifier[Uml] with UMLEncapsulatedClassifier[Uml] {
 
  import ops._
  
  def isAbstract: Boolean = false
  
  def nestedClassifiers: Seq[UMLClassifier[Uml]]
  def ownedAttributes: Seq[UMLProperty[Uml]]
  def ownedOperations: Seq[UMLOperation[Uml]]
  
  def superClasses: Set[UMLClass[Uml]] = general.selectByKindOf { case c: UMLClass[Uml] => c }
  
  /**
   * Fig 11.15 (complete)
   */
  override def forwardReferencesFromMetamodelAssociations =
    class_forwardReferencesFromMetamodelAssociations
    
  def class_forwardReferencesFromMetamodelAssociations =    
    behavioredClassifier_forwardReferencesFromMetamodelAssociations ++
    encapsulatedClassifier_forwardReferencesFromMetamodelAssociations    
  
  override def compositeMetaProperties: MetaPropertyFunctions =
    class_compositeMetaProperties
    
  def class_compositeMetaProperties: MetaPropertyFunctions =
    behavioredClassifier_compositeMetaProperties ++
    Seq(
        MetaPropertyFunction[UMLClass[Uml], UMLClassifier[Uml]]( "nestedClassifier", _.nestedClassifiers ),
        MetaPropertyFunction[UMLClass[Uml], UMLProperty[Uml]]( "ownedAttribute", _.ownedAttributes ),
        MetaPropertyFunction[UMLClass[Uml], UMLOperation[Uml]]( "ownedOperation", _.ownedOperations )
        )
        
   override def referenceMetaProperties: MetaPropertyFunctions =
     class_referenceMetaProperties
     
   def class_referenceMetaProperties: MetaPropertyFunctions =
     behavioredClassifier_referenceMetaProperties 
     
}