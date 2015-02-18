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

// [protected ('imports')]
import org.eclipse.emf.ecore.EStructuralFeature
import scala.language.existentials
import scala.language.higherKinds
import scala.language.postfixOps
import scala.reflect.runtime.universe._
import scala.reflect._
import scala.util.Try
import scala.util.Success
import scala.util.Failure
// [/protected]

trait UMLElement[Uml <: UML] extends UMLElementOps[Uml] { 

  // [protected ('common framework for all metaclasses')]

  implicit val ops: UMLOps[Uml]
  import ops._
  
  // [/protected]

  /**
   * Fig 7.1 (complete)
   */

  def element_metaAttributes: MetaAttributeFunctions = Seq()
    
  def element_forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]] = Set()
  def element_compositeMetaProperties: MetaPropertyFunctions = Seq( MetaPropertyCollection[UMLElement[Uml], UMLElement[Uml]]( "ownedComment", _.ownedComments.toIterable ) )
  def element_referenceMetaProperties: MetaPropertyFunctions = Seq()

  def ownedComments: Seq[UMLComment[Uml]]
  def annotatedElementOfComments: Seq[UMLComment[Uml]]

  def owner: Option[UMLElement[Uml]]
  def ownedElements: Set[UMLElement[Uml]]

  def relationships: Set[UMLRelationship[Uml]]

  def directedRelationships_source: Set[UMLDirectedRelationship[Uml]]
  def directedRelationships_target: Set[UMLDirectedRelationship[Uml]]

}