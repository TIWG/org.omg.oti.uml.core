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

trait UMLOutputPinOps[Uml <: UML] { self: UMLOutputPin[Uml] =>

  import self.ops._

	def structuredNodeOutput_structuredActivityNode: Option[UMLStructuredActivityNode[Uml]] =
    owner.selectByKindOf { case e: UMLStructuredActivityNode[Uml] => e }
  
	def result_readLinkObjectEndQualifierAction: Option[UMLReadLinkObjectEndQualifierAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadLinkObjectEndQualifierAction[Uml] => e }
  
	def result_readSelfAction: Option[UMLReadSelfAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadSelfAction[Uml] => e }
  
	def result_readLinkObjectEndAction: Option[UMLReadLinkObjectEndAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadLinkObjectEndAction[Uml] => e }

	def result_reduceAction: Option[UMLReduceAction[Uml]] =
    owner.selectByKindOf { case e: UMLReduceAction[Uml] => e }
  
	def result_testIdentityAction: Option[UMLTestIdentityAction[Uml]] =
    owner.selectByKindOf { case e: UMLTestIdentityAction[Uml] => e }

	def result_valueSpecificationAction: Option[UMLValueSpecificationAction[Uml]] =
    owner.selectByKindOf { case e: UMLValueSpecificationAction[Uml] => e }

	def returnInformation_acceptCallAction: Option[UMLAcceptCallAction[Uml]] =
    owner.selectByKindOf { case e: UMLAcceptCallAction[Uml] => e }

	def result_conditionalNode: Option[UMLConditionalNode[Uml]] =
    owner.selectByKindOf { case e: UMLConditionalNode[Uml] => e }

	def output_action: Option[UMLAction[Uml]] =
    owner.selectByKindOf { case e: UMLAction[Uml] => e }

	def result_readExtentAction: Option[UMLReadExtentAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadExtentAction[Uml] => e }

	def result_createLinkObjectAction: Option[UMLCreateLinkObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLCreateLinkObjectAction[Uml] => e }

	def result_readVariableAction: Option[UMLReadVariableAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadVariableAction[Uml] => e }

	def result_readLinkAction: Option[UMLReadLinkAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadLinkAction[Uml] => e }

	def result_readIsClassifiedObjectAction: Option[UMLReadIsClassifiedObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadIsClassifiedObjectAction[Uml] => e }

	def result_unmarshallAction: Option[UMLUnmarshallAction[Uml]] =
    owner.selectByKindOf { case e: UMLUnmarshallAction[Uml] => e }

	def result_readStructuralFeatureAction: Option[UMLReadStructuralFeatureAction[Uml]] =
    owner.selectByKindOf { case e: UMLReadStructuralFeatureAction[Uml] => e }

	def result_acceptEventAction: Option[UMLAcceptEventAction[Uml]] =
    owner.selectByKindOf { case e: UMLAcceptEventAction[Uml] => e }

	def result_loopNode: Option[UMLLoopNode[Uml]] =
    owner.selectByKindOf { case e: UMLLoopNode[Uml] => e }

	def result_callAction: Option[UMLCallAction[Uml]] =
    owner.selectByKindOf { case e: UMLCallAction[Uml] => e }

	def result_createObjectAction: Option[UMLCreateObjectAction[Uml]] =
    owner.selectByKindOf { case e: UMLCreateObjectAction[Uml] => e }

	def outputValue_opaqueAction: Option[UMLOpaqueAction[Uml]] =
    owner.selectByKindOf { case e: UMLOpaqueAction[Uml] => e }

	def loopVariable_loopNode: Option[UMLLoopNode[Uml]] =
    owner.selectByKindOf { case e: UMLLoopNode[Uml] => e }

	def result_clearStructuralFeatureAction: Option[UMLClearStructuralFeatureAction[Uml]] =
    owner.selectByKindOf { case e: UMLClearStructuralFeatureAction[Uml] => e }

	def result_writeStructuralFeatureAction: Option[UMLWriteStructuralFeatureAction[Uml]] =
    owner.selectByKindOf { case e: UMLWriteStructuralFeatureAction[Uml] => e }

}