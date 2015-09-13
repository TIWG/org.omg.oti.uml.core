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

import org.omg.oti.uml.read.api.{UML, UMLAssociation, UMLType, UMLOperation}

import scala.language.postfixOps
// End of user code

/**
 * A Type constrains the values represented by a TypedElement.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLTypeOps[Uml <: UML] { self: UMLType[Uml] =>

	import self.ops._

	/**
	 * <!-- Start of user code doc for endType_association -->
   * <!-- End of user code doc for endType_association -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLAssociation.endType
	 */
	def endType_association: Set[UMLAssociation[Uml]] = relatedElement_relationship.selectByKindOf { case x: UMLAssociation[Uml] => x }

	/**
	 * <!-- Start of user code doc for raisedException_operation -->
   * <!-- End of user code doc for raisedException_operation -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLOperation.raisedException
	 */
	def raisedException_operation: Set[UMLOperation[Uml]] = raisedException_behavioralFeature.selectByKindOf { case x: UMLOperation[Uml] => x }

	/**
	 * The query conformsTo() gives true for a Type that conforms to another. By default, two Types do not conform to each other. This query is intended to be redefined for specific conformance situations.
	 *
	 * <!-- Start of user code doc for conformsTo -->
   * <!-- End of user code doc for conformsTo -->
	 *
	 * UML Operation ordered="false" unique="true" multiplicity="1..1"
	 * {{{
	 * OCL Body result = (false)
	 * }}}
	 */
	def conformsTo(other: Option[UMLType[Uml]]): Boolean = {
		// Start of user code for "conformsTo"
      ???
      // End of user code
	}

	// Start of user code for additional features

  def endType_associationExceptRedefinedOrDerived
  : Set[UMLAssociation[Uml]] = {
    val nonDerivedEndTypeAssociations = endType_association.filter(_.isConsistentlyNonDerived)
    nonDerivedEndTypeAssociations -- nonDerivedEndTypeAssociations.flatMap(_.getRedefinedOrSpecializedAssociations)
  }
  // End of user code
} //UMLTypeOps
