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

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * A UseCase specifies a set of actions performed by its subjects, which yields an observable result that is of value for one or more Actors or other stakeholders of each subject.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLUseCaseOps[Uml <: UML] { self: UMLUseCase[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The Extend relationships owned by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtend.extension
	 */
	def extend: Set[UMLExtend[Uml]] = ownedMember.selectByKindOf { case x: UMLExtend[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The ExtensionPoints owned by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtensionPoint.useCase
	 */
	def extensionPoint: Set[UMLExtensionPoint[Uml]] = ownedMember.selectByKindOf { case x: UMLExtensionPoint[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The Include relationships owned by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInclude.includingCase
	 */
	def include: Set[UMLInclude[Uml]] = ownedMember.selectByKindOf { case x: UMLInclude[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLInclude.addition
	 */
	def addition_include: Set[UMLInclude[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLInclude[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLExtend.extendedCase
	 */
	def extendedCase_extend: Set[UMLExtend[Uml]] = target_directedRelationship.selectByKindOf { case x: UMLExtend[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The query allIncludedUseCases() returns the transitive closure of all UseCases (directly or indirectly) included by this UseCase.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (self.include.addition->union(self.include.addition->collect(uc | uc.allIncludedUseCases()))->asSet())
	 */
	def allIncludedUseCases: Set[UMLUseCase[Uml]]  = {
		// Start of user code for "allIncludedUseCases"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * UseCases can only be involved in binary Associations.
	 * <!-- end-model-doc -->
	 *
	 * @body Association.allInstances()->forAll(a | a.memberEnd.type->includes(self) implies a.memberEnd->size() = 2)
	 */
	def validate_binary_associations: Boolean  = {
		// Start of user code for "binary_associations"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A UseCase cannot include UseCases that directly or indirectly include it.
	 * <!-- end-model-doc -->
	 *
	 * @body not allIncludedUseCases()->includes(self)
	 */
	def validate_cannot_include_self: Boolean  = {
		// Start of user code for "cannot_include_self"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * A UseCase must have a name.
	 * <!-- end-model-doc -->
	 *
	 * @body name -> notEmpty ()
	 */
	def validate_must_have_name: Boolean  = {
		// Start of user code for "must_have_name"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * UseCases cannot have Associations to UseCases specifying the same subject.
	 * <!-- end-model-doc -->
	 *
	 * @body Association.allInstances()->forAll(a | a.memberEnd.type->includes(self) implies 
	 *    (
	 *    let usecases: Set(UseCase) = a.memberEnd.type->select(oclIsKindOf(UseCase))->collect(oclAsType(UseCase))->asSet() in
	 *    usecases->size() > 1 implies usecases->collect(subject)->size() > 1
	 *    )
	 * )
	 */
	def validate_no_association_to_use_case: Boolean  = {
		// Start of user code for "no_association_to_use_case"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLUseCase
