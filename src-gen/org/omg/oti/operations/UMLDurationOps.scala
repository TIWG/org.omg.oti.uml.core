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
 * A Duration is a ValueSpecification that specifies the temporal distance between two time instants.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLDurationOps[Uml <: UML] { self: UMLDuration[Uml] =>	

	import self.ops._

	/**
	 * <!-- Start of user code doc for max_durationInterval -->
	 * <!-- End of user code doc for max_durationInterval -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDurationInterval.max
	 */
	def max_durationInterval: Set[UMLDurationInterval[Uml]] = max_interval.selectByKindOf { case x: UMLDurationInterval[Uml] => x }

	/**
	 * <!-- Start of user code doc for min_durationInterval -->
	 * <!-- End of user code doc for min_durationInterval -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLDurationInterval.min
	 */
	def min_durationInterval: Set[UMLDurationInterval[Uml]] = min_interval.selectByKindOf { case x: UMLDurationInterval[Uml] => x }

	/**
	 * If a Duration has no expr, then it must have a single observation that is a DurationObservation.
	 *
	 * <!-- Start of user code doc for validate_no_expr_requires_observation -->
	 * <!-- End of user code doc for validate_no_expr_requires_observation -->
	 *
	 * @body expr = null implies (observation->size() = 1 and observation->forAll(oclIsKindOf(DurationObservation)))
	 */
	def validate_no_expr_requires_observation: Boolean = {
		// Start of user code for "no_expr_requires_observation"
    	???
    	// End of user code
	}

	// Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    expression_asForwardReferencesToImportableOuterPackageableElements

  def expression_asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    Set(this) ++ expr.toSet

  override def forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    expression_forwardReferencesFromStereotypeTagValue
    
  /**
   * An expression that is the value of a stereotype tag property is considered part of the forward references
   * from the element on which the stereotype is applied; other parts include the operands of the expression, if any.
   */
  def expression_forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    Set(this) ++ expr.toSet

	// End of user code
} //UMLDurationOps
