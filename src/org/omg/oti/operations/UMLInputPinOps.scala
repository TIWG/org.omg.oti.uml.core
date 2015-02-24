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

import org.omg.oti._

trait UMLInputPinOps[Uml <: UML] { self: UMLInputPin[Uml] =>

  import self.ops._

  def removeAt_removeVariableValueAction: Option[UMLRemoveVariableValueAction[Uml]] =
    owner.selectByKindOf { case e: UMLRemoveVariableValueAction[Uml] => e }
    
  def structuredNodeInput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]] =
    owner.selectByKindOf { case e: UMLStructuredActivityNode[Uml] => e }
        
  def returnInformation_replyAction: Option[UMLReplyAction[Uml]] =
    owner.selectByKindOf { case e: UMLReplyAction[Uml] => e }
    
  def second_testIdentityAction: Option[UMLTestIdentityAction[Uml]] =
    owner.selectByKindOf { case e: UMLTestIdentityAction[Uml] => e }
    
  def object_reclassifyObjectAction: Option[UMLReclassifyObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLReclassifyObjectAction[Uml] => e }
    
  def request_sendObjectAction: Option[UMLSendObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLSendObjectAction[Uml] => e }

	def insertAt_addStructuralFeatureValueAction: Option[UMLAddStructuralFeatureValueAction[Uml]] =
    owner.selectByKindOf { case e: UMLAddStructuralFeatureValueAction[Uml] => e }

	def object_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadLinkObjectEndQualifierAction[Uml] => e }

	def destroyAt_linkEndDestructionData: Option[UMLLinkEndDestructionData[Uml]] =
    owner.selectByKindOf { case e: UMLLinkEndDestructionData[Uml] => e }
  
	def object_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadLinkObjectEndAction[Uml] => e }
  
	def insertAt_linkEndCreationData: Option[UMLLinkEndCreationData[Uml]] =
    owner.selectByKindOf { case e: UMLLinkEndCreationData[Uml] => e }
    
	def target_sendObjectAction: Option[UMLSendObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLSendObjectAction[Uml] => e }
  
	def object_clearAssociationAction: Option[UMLClearAssociationAction[Uml]] =
    owner.selectByKindOf { case e: UMLClearAssociationAction[Uml] => e }
    
	def value_writeVariableAction: Option[UMLWriteVariableAction[Uml]] =
    owner.selectByKindOf { case e: UMLWriteVariableAction[Uml] => e }
  
	def object_structuralFeatureAction: Option[UMLStructuralFeatureAction[Uml]] =
    owner.selectByKindOf { case e: UMLStructuralFeatureAction[Uml] => e }
  
	def value_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]] =
    owner.selectByKindOf { case e: UMLWriteStructuralFeatureAction[Uml] => e }
    
	def replyValue_replyAction: Option[UMLReplyAction[Uml]] =
    owner.selectByKindOf { case e: UMLReplyAction[Uml] => e }
  
	def insertAt_addVariableValueAction: Option[UMLAddVariableValueAction[Uml]] =
    owner.selectByKindOf { case e: UMLAddVariableValueAction[Uml] => e }
  
	def object_startClassifierBehaviorAction: Option[UMLStartClassifierBehaviorAction[Uml]] =
    owner.selectByKindOf { case e: UMLStartClassifierBehaviorAction[Uml] => e }
    
	def removeAt_removeStructuralFeatureValueAction: Option[UMLRemoveStructuralFeatureValueAction[Uml]] =
    owner.selectByKindOf { case e: UMLRemoveStructuralFeatureValueAction[Uml] => e }
  
	def first_testIdentityAction: Option[UMLTestIdentityAction[Uml]] =
    owner.selectByKindOf { case e: UMLTestIdentityAction[Uml] => e }
  
	def loopVariableInput_loopNode: Option[UMLLoopNode[Uml]] =
    owner.selectByKindOf { case e: UMLLoopNode[Uml] => e }
  
	def target_callOperationAction: Option[UMLCallOperationAction[Uml]] =
    owner.selectByKindOf { case e: UMLCallOperationAction[Uml] => e }
    
	def input_action: Option[UMLAction[Uml]] =
    owner.selectByKindOf { case e: UMLAction[Uml] => e }
  
	def target_destroyObjectAction: Option[UMLDestroyObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLDestroyObjectAction[Uml] => e }
    
	def inputValue_opaqueAction: Option[UMLOpaqueAction[Uml]] =
    owner.selectByKindOf { case e: UMLOpaqueAction[Uml] => e }
    
	def collection_reduceAction: Option[UMLReduceAction[Uml]] =
    owner.selectByKindOf { case e: UMLReduceAction[Uml] => e }
  
	def argument_invocationAction: Option[UMLInvocationAction[Uml]] =
    owner.selectByKindOf { case e: UMLInvocationAction[Uml] => e }
  
	def object_startObjectBehaviorAction: Option[UMLStartObjectBehaviorAction[Uml]] =
    owner.selectByKindOf { case e: UMLStartObjectBehaviorAction[Uml] => e }
  
	def object_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadIsClassifiedObjectAction[Uml] => e }
  
	def target_sendSignalAction: Option[UMLSendSignalAction[Uml]] =
    owner.selectByKindOf { case e: UMLSendSignalAction[Uml] => e }
  
	def exception_raiseExceptionAction: Option[UMLRaiseExceptionAction[Uml]] =
    owner.selectByKindOf { case e: UMLRaiseExceptionAction[Uml] => e }

	def object_unmarshallAction: Option[UMLUnmarshallAction[Uml]] =
    owner.selectByKindOf { case e: UMLUnmarshallAction[Uml] => e }  
  
	def inputValue_linkAction: Option[UMLLinkAction[Uml]] =
    owner.selectByKindOf { case e: UMLLinkAction[Uml] => e }  
  
}