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

import org.omg.oti.uml.read.api.{UMLConstraint, UMLExtend, UML, UMLUseCase}

import scala.language.postfixOps
// End of user code

/**
 * A relationship from an extending UseCase to an extended UseCase that specifies how and when the behavior defined in the extending UseCase can be inserted into the behavior defined in the extended UseCase.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLExtendOps[Uml <: UML] { self: UMLExtend[Uml] =>

	import self.ops._

	/**
	 * References the condition that must hold when the first ExtensionPoint is reached for the extension to take place. If no constraint is associated with the Extend relationship, the extension is unconditional.
	 *
	 * <!-- Start of user code doc for condition -->
   * <!-- End of user code doc for condition -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLConstraint.condition_extend
	 */
	def condition: Option[UMLConstraint[Uml]] = ownedElement.selectByKindOf { case x: UMLConstraint[Uml] => x } headOption

	/**
	 * The UseCase that is being extended.
	 *
	 * <!-- Start of user code doc for extendedCase -->
   * <!-- End of user code doc for extendedCase -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.extendedCase_extend
	 */
	def extendedCase: Option[UMLUseCase[Uml]] = target.selectByKindOf { case x: UMLUseCase[Uml] => x } headOption

	/**
	 * The UseCase that represents the extension and owns the Extend relationship.
	 *
	 * <!-- Start of user code doc for extension -->
   * <!-- End of user code doc for extension -->
	 *
	 * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * UML opposite Property: org.omg.oti.uml.read.api.UMLUseCase.extend
	 */
	def extension: Option[UMLUseCase[Uml]] = namespace.selectByKindOf { case x: UMLUseCase[Uml] => x }

	/**
	 * The ExtensionPoints referenced by the Extend relationship must belong to the UseCase that is being extended.
	 *
	 * <!-- Start of user code doc for validate_extension_points -->
   * <!-- End of user code doc for validate_extension_points -->
	 *
	 * {{{
	 * OCL Body extensionLocation->forAll (xp | extendedCase.extensionPoint->includes(xp))
	 * }}}
	 */
	def validate_extension_points: Boolean = {
		// Start of user code for "extension_points"
      ???
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLExtendOps
