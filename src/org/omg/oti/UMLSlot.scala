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

trait UMLSlot[Uml <: UML] extends UMLElement[Uml] {
  
  import ops._
  
  def owningInstance: Option[UMLInstanceSpecification[Uml]] = owner.asInstanceOf[Option[UMLInstanceSpecification[Uml]]]
  
  def values: Iterable[UMLValueSpecification[Uml]]
  def definingFeature: Option[UMLStructuralFeature[Uml]]
    
  /**
   * Fig 9.27 (complete)
   */
  override def metaAttributes: MetaAttributeFunctions =
    slot_metaAttributes

  def slot_metaAttributes: MetaAttributeFunctions =
    element_metaAttributes
    
  override def forwardReferencesFromMetamodelAssociations =
    element_forwardReferencesFromMetamodelAssociations ++
    definingFeature

  override def compositeMetaProperties: MetaPropertyFunctions =
    element_compositeMetaProperties ++
    Seq( MetaPropertyCollection[UMLSlot[Uml], UMLValueSpecification[Uml]]( "value", _.values ) )
        
  override def referenceMetaProperties: MetaPropertyFunctions =
    element_referenceMetaProperties ++
    Seq( MetaPropertyReference[UMLSlot[Uml], UMLStructuralFeature[Uml]]( "definingFeature", _.definingFeature ) )    

  // [protected ('TIWG')]

  /**
   * TIWG: see UMLUtil, Rule #4
   */
  override def xmiOrderingKey: String = super.xmiOrderingKey + (definingFeature match {
    case None => "_"
    case Some( sf ) => "_" + sf.xmiOrderingKey
  })
  
  // [/protected]  
}