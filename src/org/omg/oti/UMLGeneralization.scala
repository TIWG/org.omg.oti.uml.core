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

trait UMLGeneralization[Uml <: UML] extends UMLDirectedRelationship[Uml] {

  import ops._

  def isSubstitutable: Boolean = true

  def specific: Option[UMLClassifier[Uml]] = ( sources.selectByKindOf { case cls: UMLClassifier[Uml] => cls } ).toIterable.headOption
  def general: Option[UMLClassifier[Uml]] = ( targets.selectByKindOf { case cls: UMLClassifier[Uml] => cls } ).toIterable.headOption

  /**
   * Fig. 9.1 (incomplete)
   * - generalizationSet
   */
  override def metaAttributes: MetaAttributeFunctions =
    generalization_metaAttributes

  def generalization_metaAttributes: MetaAttributeFunctions =
    directedRelationship_metaAttributes ++
      Seq( MetaAttributeBooleanFunction[UMLGeneralization[Uml]]( "isSubstitutable", (g) => booleanToIterable(g.isSubstitutable, true ) ) )

  override def forwardReferencesFromMetamodelAssociations =
    directedRelationship_forwardReferencesFromMetamodelAssociations ++
      general

  override def compositeMetaProperties: MetaPropertyFunctions =
    directedRelationship_compositeMetaProperties

  override def referenceMetaProperties: MetaPropertyFunctions =
    directedRelationship_compositeMetaProperties ++
      Seq( MetaPropertyFunction[UMLGeneralization[Uml], UMLClassifier[Uml]]( "general", _.general ) )
}