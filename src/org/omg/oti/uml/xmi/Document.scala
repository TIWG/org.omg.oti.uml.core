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
package org.omg.oti.uml.xmi

import java.net.URI
import org.omg.oti.uml.read.api.{UML, UMLElement}
import org.omg.oti.uml.read.operations.UMLOps

import scala.language.postfixOps

sealed abstract trait Document[Uml <: UML] {
  implicit val ops: UMLOps[Uml]
  val uri: URI
  val nsPrefix: String
  val uuidPrefix: String

  /**
   * The official URI where this document is published as a resource that can be referenced by other documents
   * and whose contents can be referenced starting from this URI
   */
  val documentURL: URI

  /**
   * The root element defining the containment scope of this document
   */
  val scope: UMLElement[Uml]

  /**
   * The set of all elements directly or indirectly owned by `scope`, including `scope`
   *
   * @return The reflexive, transitive closure of containment from `scope`
   */
  def extent: Set[UMLElement[Uml]]
}

trait BuiltInDocument[Uml <: UML] extends Document[Uml] {
  /**
   * The extent of a built-in document, which is a tool-specific representation of a published document.
   * This extent may be a partial representation of the full extent of the published document.
   */
  val builtInExtent: Set[UMLElement[Uml]]

  override def extent = builtInExtent
}
    
trait SerializableDocument[Uml <: UML] extends Document[Uml] 