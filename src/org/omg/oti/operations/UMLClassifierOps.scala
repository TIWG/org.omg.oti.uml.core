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
package org.omg.oti.operations

import scala.language.postfixOps

import org.omg.oti._

trait UMLClassifierOps[Uml <: UML] { self: UMLClassifier[Uml] =>

  import self.ops._

  def collaborationUse: Set[UMLCollaborationUse[Uml]] =
    ownedElement.selectByKindOf { case cu: UMLCollaborationUse[Uml] => cu }

  def feature: Set[UMLFeature[Uml]] = 
    member.selectByKindOf { case f: UMLFeature[Uml] => f }

  def general: Set[UMLClassifier[Uml]] = 
    generalization flatMap ( _.general )

  def generalization: Set[UMLGeneralization[Uml]] = 
    ownedElement.selectByKindOf { case g: UMLGeneralization[Uml] => g }

  override def ownedTemplateSignature = 
    classifier_ownedTemplateSignature
  
  def classifier_ownedTemplateSignature: Option[UMLRedefinableTemplateSignature[Uml]]
  
  def ownedUseCase: Set[UMLUseCase[Uml]] = 
    ownedMember.selectByKindOf { case uc: UMLUseCase[Uml] => uc } 
  
  def redefinedClassifier: Set[UMLClassifier[Uml]] = 
    redefinedElement.selectByKindOf { case cls: UMLClassifier[Uml] => cls }

  def substitution: Set[UMLSubstitution[Uml]] = 
    ownedElement.selectByKindOf { case s: UMLSubstitution[Uml] => s } 
    
  def redefinitionContext_state: Set[UMLState[Uml]] =
    redefinitionContext_redefinableElement.selectByKindOf { case s: UMLState[Uml] => s }
  
  def redefinitionContext_transition: Set[UMLTransition[Uml]] =
    redefinitionContext_redefinableElement.selectByKindOf { case t: UMLTransition[Uml] => t }
  
  def nestedClassifier_nestingClass: Option[UMLClass[Uml]] =
    namespace.selectByKindOf { case c: UMLClass[Uml] => c } 
  
  def general_classifier: Set[UMLClassifier[Uml]] =
    general_generalization flatMap (_.specific)
  
  def redefinitionContext_region: Set[UMLRegion[Uml]] =
    redefinitionContext_redefinableElement.selectByKindOf { case r: UMLRegion[Uml] => r }
  
  def redefinedClassifier_classifier: Set[UMLClassifier[Uml]] =
    redefinedElement_redefinableElement.selectByKindOf { case c: UMLClassifier[Uml] => c }

  def nestedClassifier_interface: Option[UMLInterface[Uml]] =
    namespace.selectByKindOf { case i: UMLInterface[Uml] => i }

}