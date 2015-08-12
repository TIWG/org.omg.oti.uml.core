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

import org.omg.oti.uml.read.api.{UML, UMLOperationTemplateParameter}

import scala.language.postfixOps
// End of user code

/**
 * An OperationTemplateParameter exposes an Operation as a formal parameter for a template.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLOperationTemplateParameterOps[Uml <: UML] { self: UMLOperationTemplateParameter[Uml] =>

  import self.ops._

  /**
   * <!-- Start of user code doc for validate_match_default_signature -->
   * <!-- End of user code doc for validate_match_default_signature -->
   *
   * @body default->notEmpty() implies (default.oclIsKindOf(Operation) and (let defaultOp : Operation = default.oclAsType(Operation) in
   *     defaultOp.ownedParameter->size() = parameteredElement.ownedParameter->size() and
   *     Sequence{1.. defaultOp.ownedParameter->size()}->forAll( ix |
   *         let p1: Parameter = defaultOp.ownedParameter->at(ix), p2 : Parameter = parameteredElement.ownedParameter->at(ix) in
   *           p1.type = p2.type and p1.upper = p2.upper and p1.lower = p2.lower and p1.direction = p2.direction and p1.isOrdered = p2.isOrdered and p1.isUnique = p2.isUnique)))
   */
  def validate_match_default_signature: Boolean = {
    // Start of user code for "match_default_signature"
      ???
      // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLOperationTemplateParameterOps
