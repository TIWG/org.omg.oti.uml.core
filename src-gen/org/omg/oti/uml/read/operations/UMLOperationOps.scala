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
package org.omg.oti.uml.read.operations

// Start of user code for imports

import org.omg.oti.uml.read.api._

import scala.language.postfixOps
// End of user code

/**
 * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLOperationOps[Uml <: UML] { self: UMLOperation[Uml] =>

	import self.ops._

	/**
	 * The Class that owns this operation, if any.
	 *
	 * <!-- Start of user code doc for _class -->
   * <!-- End of user code doc for _class -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.ownedOperation
	 */
	def _class: Option[UMLClass[Uml]] = featuringClassifier.selectByKindOf { case x: UMLClass[Uml] => x }

	/**
	 * The return type of the operation, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for _type -->
   * <!-- End of user code doc for _type -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLType.type_operation
	 * {{{
	 * OCL Body result = (if returnResult()->notEmpty() then returnResult()->any(true).type else null endif)
	 * }}}
	 */
	def _type: Option[UMLType[Uml]] = {
		// Start of user code for "type"
      ???
      // End of user code
	}

	/**
	 * The DataType that owns this Operation, if any.
	 *
	 * <!-- Start of user code doc for datatype -->
   * <!-- End of user code doc for datatype -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLDataType.ownedOperation
	 */
	def datatype: Option[UMLDataType[Uml]] = featuringClassifier.selectByKindOf { case x: UMLDataType[Uml] => x }

	/**
	 * The Interface that owns this Operation, if any.
	 *
	 * <!-- Start of user code doc for interface -->
   * <!-- End of user code doc for interface -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLInterface.ownedOperation
	 */
	def interface: Option[UMLInterface[Uml]] = featuringClassifier.selectByKindOf { case x: UMLInterface[Uml] => x }

	/**
	 * Specifies whether the return parameter is ordered or not, if present.  This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for isOrdered -->
   * <!-- End of user code doc for isOrdered -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (if returnResult()->notEmpty() then returnResult()-> exists(isOrdered) else false endif)
	 * }}}
	 */
	def isOrdered: Boolean = {
		// Start of user code for "isOrdered"
      ???
      // End of user code
	}

	/**
	 * Specifies whether the return parameter is unique or not, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for isUnique -->
   * <!-- End of user code doc for isUnique -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (if returnResult()->notEmpty() then returnResult()->exists(isUnique) else true endif)
	 * }}}
	 */
	def isUnique: Boolean = {
		// Start of user code for "isUnique"
      ???
      // End of user code
	}

	/**
	 * Specifies the lower multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for lower -->
   * <!-- End of user code doc for lower -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * {{{
	 * OCL Body result = (if returnResult()->notEmpty() then returnResult()->any(true).lower else null endif)
	 * }}}
	 */
	def lower: Option[Integer] = {
		// Start of user code for "lower"
      ???
      // End of user code
	}

	/**
	 * The Operations that are redefined by this Operation.
	 *
	 * <!-- Start of user code doc for redefinedOperation -->
   * <!-- End of user code doc for redefinedOperation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.redefinedOperation_operation
	 */
	def redefinedOperation: Set[UMLOperation[Uml]] = redefinedElement.selectByKindOf { case x: UMLOperation[Uml] => x }

	/**
	 * The upper multiplicity of the return parameter, if present. This information is derived from the return result for this Operation.
	 *
	 * <!-- Start of user code doc for upper -->
   * <!-- End of user code doc for upper -->
	 *
	 * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * {{{
	 * OCL Body result = (if returnResult()->notEmpty() then returnResult()->any(true).upper else null endif)
	 * }}}
	 */
	def upper: Option[Integer] = {
		// Start of user code for "upper"
      ???
      // End of user code
	}

	/**
	 * <!-- Start of user code doc for ownedOperation_artifact -->
   * <!-- End of user code doc for ownedOperation_artifact -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLArtifact.ownedOperation
	 */
	def ownedOperation_artifact: Option[UMLArtifact[Uml]] = featuringClassifier.selectByKindOf { case x: UMLArtifact[Uml] => x }

	/**
	 * <!-- Start of user code doc for redefinedOperation_operation -->
   * <!-- End of user code doc for redefinedOperation_operation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.redefinedOperation
	 */
	def redefinedOperation_operation: Set[UMLOperation[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLOperation[Uml] => x }

	/**
	 * The query isConsistentWith() specifies, for any two Operations in a context in which redefinition is possible, whether redefinition would be consistent. A redefining operation is consistent with a redefined operation if
	 * it has the same number of owned parameters, and for each parameter the following holds:
	 * - Direction, ordering and uniqueness are the same.
	 * - The corresponding types are covariant, contravariant or invariant.
	 * - The multiplicities are compatible, depending on the parameter direction.
	 *
	 * <!-- Start of user code doc for isConsistentWith -->
   * <!-- End of user code doc for isConsistentWith -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (redefiningElement.oclIsKindOf(Operation) and
	 * let op : Operation = redefiningElement.oclAsType(Operation) in
	 * 	self.ownedParameter->size() = op.ownedParameter->size() and
	 * 	Sequence{1..self.ownedParameter->size()}->
	 * 		forAll(i |  
	 * 		  let redefiningParam : Parameter = op.ownedParameter->at(i),
	 *                redefinedParam : Parameter = self.ownedParameter->at(i) in
	 *                  (redefiningParam.isUnique = redefinedParam.isUnique) and
	 *                  (redefiningParam.isOrdered = redefinedParam. isOrdered) and
	 *                  (redefiningParam.direction = redefinedParam.direction) and
	 *                  (redefiningParam.type.conformsTo(redefinedParam.type) or
	 *                      redefinedParam.type.conformsTo(redefiningParam.type)) and
	 *                  (redefiningParam.direction = ParameterDirectionKind::inout implies
	 *                          (redefinedParam.compatibleWith(redefiningParam) and
	 *                          redefiningParam.compatibleWith(redefinedParam))) and
	 *                  (redefiningParam.direction = ParameterDirectionKind::_'in' implies
	 *                          redefinedParam.compatibleWith(redefiningParam)) and
	 *                  ((redefiningParam.direction = ParameterDirectionKind::out or
	 *                       redefiningParam.direction = ParameterDirectionKind::return) implies
	 *                          redefiningParam.compatibleWith(redefinedParam))
	 * 		))
	 * }}}
	 */
	override def isConsistentWith(redefiningElement: Option[UMLRedefinableElement[Uml]]): Boolean = {
		// Start of user code for "isConsistentWith"
      ???
      // End of user code
	}

	/**
	 * The query returnResult() returns the set containing the return parameter of the Operation if one exists, otherwise, it returns an empty set
	 *
	 * <!-- Start of user code doc for returnResult -->
   * <!-- End of user code doc for returnResult -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="0..*"
	 * {{{
	 * OCL Body result = (ownedParameter->select (direction = ParameterDirectionKind::return))
	 * }}}
	 */
	def returnResult: Set[UMLParameter[Uml]] = {
		// Start of user code for "returnResult"
      ???
      // End of user code
	}

	/**
	 * An Operation can have at most one return parameter; i.e., an owned parameter with the direction set to 'return.'
	 *
	 * <!-- Start of user code doc for validate_at_most_one_return -->
   * <!-- End of user code doc for validate_at_most_one_return -->
	 *
	 * {{{
	 * OCL Body self.ownedParameter->select(direction = ParameterDirectionKind::return)->size() <= 1
	 * }}}
	 */
	def validate_at_most_one_return: Boolean = {
		// Start of user code for "at_most_one_return"
      ???
      // End of user code
	}

	/**
	 * A bodyCondition can only be specified for a query Operation.
	 *
	 * <!-- Start of user code doc for validate_only_body_for_query -->
   * <!-- End of user code doc for validate_only_body_for_query -->
	 *
	 * {{{
	 * OCL Body bodyCondition <> null implies isQuery
	 * }}}
	 */
	def validate_only_body_for_query: Boolean = {
		// Start of user code for "only_body_for_query"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLOperationOps
