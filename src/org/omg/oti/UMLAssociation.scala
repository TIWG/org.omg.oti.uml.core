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

trait UMLAssociation[Uml <: UML] extends UMLClassifier[Uml] with UMLRelationship[Uml] {

  import ops._

  def isDerived: Boolean = false
  
  def ownedEnds: Iterable[UMLProperty[Uml]]
  def navigableOwnedEnds: Iterable[UMLProperty[Uml]]
  def memberEnds: Iterable[UMLProperty[Uml]]
  def endTypes: Iterable[UMLType[Uml]]

  /**
   * Fig 11.25 (complete)
   */  
  override def metaAttributes: MetaAttributeFunctions =
    association_metaAttributes
    
  def association_metaAttributes: MetaAttributeFunctions =
    classifier_metaAttributes ++
    relationship_metaAttributes ++
    Seq( MetaAttributeBooleanFunction[UMLAssociation[Uml]]( None, "isDerived", (p) => booleanToIterable(p.isDerived, false) ) )
        
  override def forwardReferencesFromMetamodelAssociations =
    association_forwardReferencesFromMetamodelAssociations
    
  def association_forwardReferencesFromMetamodelAssociations =    
    relationship_forwardReferencesFromMetamodelAssociations ++
      classifier_forwardReferencesFromMetamodelAssociations ++
      memberEnds

  override def compositeMetaProperties: MetaPropertyFunctions =
    association_compositeMetaProperties
    
  def association_compositeMetaProperties: MetaPropertyFunctions =
    classifier_compositeMetaProperties ++
      relationship_compositeMetaProperties ++
      Seq( MetaPropertyCollection[UMLAssociation[Uml], UMLProperty[Uml]]( "ownedEnd", _.ownedEnds ) )

  override def referenceMetaProperties: MetaPropertyFunctions =
    association_referenceMetaProperties
    
  def association_referenceMetaProperties: MetaPropertyFunctions =
    classifier_referenceMetaProperties ++
      relationship_referenceMetaProperties ++
      Seq(
        MetaPropertyCollection[UMLAssociation[Uml], UMLProperty[Uml]]( "memberEnd", _.memberEnds ),
        MetaPropertyCollection[UMLAssociation[Uml], UMLProperty[Uml]]( "navigableOwnedEnd", _.navigableOwnedEnds ) )

  def getDirectedAssociationEnds: Option[( UMLProperty[Uml], UMLProperty[Uml] )] =
    memberEnds.toList match {
      case end1 :: end2 :: Nil =>
        ( end1.isLogicallyNavigable, end2.isLogicallyNavigable ) match {
          case ( true, false ) => Some( ( end2, end1 ) )
          case ( false, true ) => Some( ( end1, end2 ) )
          case ( _, _ ) =>
            ( end1.isSemanticallyNavigable, end2.isSemanticallyNavigable ) match {
              case ( true, false ) => Some( ( end2, end1 ) )
              case ( false, true ) => Some( ( end1, end2 ) )
              case ( _, _ )        => None
            }
        }
      case _ => None
    }
}