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

import org.omg.oti.uml.read.api.{UML, UMLActor}

import scala.language.postfixOps
// End of user code

/**
 * An Actor specifies a role played by a user or any other system that interacts with the subject.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActorOps[Uml <: UML] { self: UMLActor[Uml] =>

	import self.ops._

	/**
	 * An Actor can only have Associations to UseCases, Components, and Classes. Furthermore these Associations must be binary.
	 *
	 * <!-- Start of user code doc for validate_associations -->
   * <!-- End of user code doc for validate_associations -->
	 *
	 * @body Association.allInstances()->forAll( a |
	 *   a.memberEnd->collect(type)->includes(self) implies
	 *   (
	 *     a.memberEnd->size() = 2 and
	 *     let actorEnd : Property = a.memberEnd->any(type = self) in
	 *       actorEnd.opposite.class.oclIsKindOf(UseCase) or
	 *       ( actorEnd.opposite.class.oclIsKindOf(Class) and not
	 *          actorEnd.opposite.class.oclIsKindOf(Behavior))
	 *       )
	 *   )
	 */
	def validate_associations: Boolean = {
		// Start of user code for "associations"
      ??? //need Association translation
      // End of user code
	}

	/**
	 * An Actor must have a name.
	 *
	 * <!-- Start of user code doc for validate_must_have_name -->
   * <!-- End of user code doc for validate_must_have_name -->
	 *
	 * @body name->notEmpty()
	 */
	def validate_must_have_name: Boolean = {
		// Start of user code for "must_have_name"
      name.nonEmpty
      // End of user code
	}

	// Start of user code for additional features
  // End of user code
} //UMLActorOps
