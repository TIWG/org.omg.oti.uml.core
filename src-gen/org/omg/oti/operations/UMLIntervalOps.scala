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
 * An Interval defines the range between two ValueSpecifications.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLIntervalOps[Uml <: UML] { self: UMLInterval[Uml] =>	

	import self.ops._

	/**
	 * <!-- Start of user code doc for specification_intervalConstraint -->
	 * <!-- End of user code doc for specification_intervalConstraint -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLIntervalConstraint.specification
	 */
	def specification_intervalConstraint: Option[UMLIntervalConstraint[Uml]] = specification_owningConstraint.selectByKindOf { case x: UMLIntervalConstraint[Uml] => x }

	// Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    interval_asForwardReferencesToImportableOuterPackageableElements

  def interval_asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] = 
    Set(this) ++ min.toSet ++ max.toSet

  override def forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    interval_forwardReferencesFromStereotypeTagValue
     
  /**
   * An interval that is the value of a stereotype tag property is considered part of the forward references
   * from the element on which the stereotype is applied; other parts include the min and max, if any.
   */
  def interval_forwardReferencesFromStereotypeTagValue: Set[UMLElement[Uml]] = 
    Set(this) ++ min.toSet ++ max.toSet

	// End of user code
} //UMLIntervalOps
