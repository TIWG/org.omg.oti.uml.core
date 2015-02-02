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

trait UMLOperation[Uml <: UML] extends UMLBehavioralFeature[Uml] {

  import ops._

  def datatype: Option[UMLDataType[Uml]] = owner.asInstanceOf[Option[UMLDataType[Uml]]]
  def _class: Option[UMLClass[Uml]] = owner.asInstanceOf[Option[UMLClass[Uml]]]

  def isQuery: Boolean = false

  def preCondition: Iterable[UMLConstraint[Uml]]
  def postCondition: Iterable[UMLConstraint[Uml]]
  def bodyCondition: Option[UMLConstraint[Uml]]

  def redefinedOperations: Iterable[UMLOperation[Uml]] = redefinedElements.selectByKindOf { case o: UMLOperation[Uml] => o }

  /**
   * Fig 9.13 (incomplete)
   * - TemplateableElement
   * - ParameterableElement
   * - templateParameter
   * - raisedException
   */
  override def metaAttributes: MetaAttributeFunctions =
    operation_metaAttributes

  def operation_metaAttributes: MetaAttributeFunctions =
    behavioralFeature_metaAttributes ++
      Seq( MetaAttributeBooleanFunction[UMLOperation[Uml]]( None, "isQuery", ( o ) => booleanToIterable( o.isQuery, false ) ) )

  override def forwardReferencesFromMetamodelAssociations =
    operation_forwardReferencesFromMetamodelAssociations

  def operation_forwardReferencesFromMetamodelAssociations =
    behavioralFeature_forwardReferencesFromMetamodelAssociations ++
      redefinedOperations

  override def compositeMetaProperties: MetaPropertyFunctions =
    operation_compositeMetaProperties

  def operation_compositeMetaProperties =
    behavioralFeature_compositeMetaProperties ++
      Seq(
        MetaPropertyCollection[UMLOperation[Uml], UMLConstraint[Uml]]( "bodyCondition", _.bodyCondition ),
        MetaPropertyCollection[UMLOperation[Uml], UMLConstraint[Uml]]( "postCondition", _.postCondition ),
        MetaPropertyCollection[UMLOperation[Uml], UMLConstraint[Uml]]( "preCondition", _.preCondition ) )

  override def referenceMetaProperties: MetaPropertyFunctions =
    operation_referenceMetaProperties

  def operation_referenceMetaProperties =
    behavioralFeature_referenceMetaProperties ++
      Seq( MetaPropertyCollection[UMLOperation[Uml], UMLOperation[Uml]]( "redefinedOperation", _.redefinedOperations ) )

}