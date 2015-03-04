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
 * A BehavioralFeature is a feature of a Classifier that specifies an aspect of the behavior of its instances.  A BehavioralFeature is implemented (realized) by a Behavior. A BehavioralFeature specifies that a Classifier will respond to a designated request by invoking its implementing method.
 * <!-- end-model-doc --> 
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLBehavioralFeatureOps[Uml <: UML] { self: UMLBehavioralFeature[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The ParameterSets owned by this BehavioralFeature.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLParameterSet.ownedParameterSet_behavioralFeature
	 */
	def ownedParameterSet: Set[UMLParameterSet[Uml]] = ownedMember.selectByKindOf { case x: UMLParameterSet[Uml] => x }

	/**
	 * <!-- begin-model-doc -->
	 * The ownedParameters with direction in and inout.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (ownedParameter->select(direction=ParameterDirectionKind::_'in' or direction=ParameterDirectionKind::inout))
	 */
	def inputParameters: Seq[UMLParameter[Uml]]  = {
    	// Start of user code for "inputParameters"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The query isDistinguishableFrom() determines whether two BehavioralFeatures may coexist in the same Namespace. It specifies that they must have different signatures.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = ((n.oclIsKindOf(BehavioralFeature) and ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->notEmpty()) implies
	 *   Set{self}->including(n.oclAsType(BehavioralFeature))->isUnique(ownedParameter->collect(p|
	 *   Tuple { name=p.name, type=p.type,effect=p.effect,direction=p.direction,isException=p.isException,
	 *               isStream=p.isStream,isOrdered=p.isOrdered,isUnique=p.isUnique,lower=p.lower, upper=p.upper }))
	 *   )
	 */
	override def isDistinguishableFrom(n: Option[UMLNamedElement[Uml]], ns: Option[UMLNamespace[Uml]]): Boolean  = {
    	// Start of user code for "isDistinguishableFrom"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The ownedParameters with direction out, inout, or return.
	 * <!-- end-model-doc -->
	 *
	 * @operation ordered="true" unique="true" multiplicity="0..*"
	 * @body result = (ownedParameter->select(direction=ParameterDirectionKind::out or direction=ParameterDirectionKind::inout or direction=ParameterDirectionKind::return))
	 */
	def outputParameters: Seq[UMLParameter[Uml]]  = {
    	// Start of user code for "outputParameters"
    	???
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * When isAbstract is true there are no methods.
	 * <!-- end-model-doc -->
	 *
	 * @body isAbstract implies method->isEmpty()
	 */
	def validate_abstract_no_method: Boolean  = {
    	// Start of user code for "abstract_no_method"
    	???
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLBehavioralFeature
