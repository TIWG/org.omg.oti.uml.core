/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Boolean
import scala.Predef.???
// End of user code

/**
  * An OperationTemplateParameter exposes an Operation as a formal parameter for a template.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLOperationTemplateParameterOps[Uml <: UML] { self: UMLOperationTemplateParameter[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * <!-- Start of user code doc for validate_match_default_signature -->
    * <!-- End of user code doc for validate_match_default_signature -->
    *
    * {{{
    * OCL Body default->notEmpty() implies (default.oclIsKindOf(Operation) and (let defaultOp : Operation = default.oclAsType(Operation) in 
    *     defaultOp.ownedParameter->size() = parameteredElement.ownedParameter->size() and
    *     Sequence{1.. defaultOp.ownedParameter->size()}->forAll( ix | 
    *         let p1: Parameter = defaultOp.ownedParameter->at(ix), p2 : Parameter = parameteredElement.ownedParameter->at(ix) in
    *           p1.type = p2.type and p1.upper = p2.upper and p1.lower = p2.lower and p1.direction = p2.direction and p1.isOrdered = p2.isOrdered and p1.isUnique = p2.isUnique)))
    * }}}
    */
  def validate_match_default_signature: Boolean = {
    // Start of user code for "match_default_signature"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLOperationTemplateParameterOps
