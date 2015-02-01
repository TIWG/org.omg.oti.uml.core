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

trait UMLBehavioralFeature[Uml <: UML] extends UMLFeature[Uml] with UMLNamespace[Uml] {

  import ops._

  def isAbstract: Boolean = false

  /**
   * If this was not ordered, it could be computed:
   * ownedMembers.selectByKindOf { case p: UMLParameter[Uml] => p }
   * However, because it is ordered, the ordering information is tool-specific.
   */
  def ownedParameters: Seq[UMLParameter[Uml]]

  /**
   * Fig 9.9 (incomplete)
   * - concurrency
   * - method
   * - raisedException
   */

  def behavioralFeature_metaAttributes: MetaAttributeFunctions =
    feature_metaAttributes ++
      namespace_metaAttributes ++
      Seq( MetaAttributeBooleanFunction[UMLBehavioralFeature[Uml]]( "isAbstract", (bf) => booleanToIterable(bf.isAbstract, false) ) )

  def behavioralFeature_forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]] =
    feature_forwardReferencesFromMetamodelAssociations ++
      namespace_forwardReferencesFromMetamodelAssociations

  /**
   * incomplete:
   * - ownedParameterSet
   */
  def behavioralFeature_compositeMetaProperties: MetaPropertyFunctions =
    feature_compositeMetaProperties ++
      namespace_compositeMetaProperties ++
      Seq( MetaPropertyFunction[UMLBehavioralFeature[Uml], UMLParameter[Uml]]( "ownedParameter", _.ownedParameters ) )

  /**
   * incomplete:
   * - method
   * - raisedException
   */
  def behavioralFeature_referenceMetaProperties: MetaPropertyFunctions =
    feature_referenceMetaProperties ++
      namespace_referenceMetaProperties
}