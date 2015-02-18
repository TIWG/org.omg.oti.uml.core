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

trait UMLExpression[Uml <: UML] extends UMLValueSpecification[Uml] {

  import ops._

  def symbol: Option[String]
  def operands: Seq[UMLValueSpecification[Uml]]

  /**
   * Fig. 8.2 (complete)
   */
  override def metaAttributes: MetaAttributeFunctions =
    expression_metaAttributes
    
  def expression_metaAttributes: MetaAttributeFunctions =
    valueSpecification_metaAttributes ++
      Seq( MetaAttributeStringFunction[UMLExpression[Uml]]( None, "symbol", _.symbol ) )

  override def forwardReferencesFromMetamodelAssociations =
    valueSpecification_forwardReferencesFromMetamodelAssociations

  override def compositeMetaProperties: MetaPropertyFunctions =
    valueSpecification_compositeMetaProperties ++
      Seq( MetaPropertyCollection[UMLExpression[Uml], UMLValueSpecification[Uml]]( "operand", _.operands ) )

  override def referenceMetaProperties: MetaPropertyFunctions =
    valueSpecification_referenceMetaProperties
    
  override def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    expression_asForwardReferencesToImportableOuterPackageableElements

  def expression_asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    Set(this) ++ operands.toSet

  override def forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    expression_forwardReferencesFromStereotypeTagValue
    
  /**
   * An expression that is the value of a stereotype tag property is considered part of the forward references
   * from the element on which the stereotype is applied; other parts include the operands of the expression, if any.
   */
  def expression_forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    Set(this) ++ operands.toSet
}