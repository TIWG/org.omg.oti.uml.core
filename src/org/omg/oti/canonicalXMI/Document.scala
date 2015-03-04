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
package org.omg.oti.canonicalXMI

import org.omg.oti.api._
import org.omg.oti.operations._
import java.net.URI
import scala.language.postfixOps

sealed abstract trait Document[Uml <: UML] {
  implicit val ops: UMLOps[Uml]
  val uri: URI
  val nsPrefix: String
  val scope: UMLElement[Uml]
  
  lazy val extent: Set[UMLElement[Uml]] = 
     (Stream(scope) ++ scope.allOwnedElements).flatMap { e => Set(e) ++ e.compositeReferencesFromStereotypeTagPropertyValues } toSet
  
}

case class BuiltInDocument[Uml <: UML](
    val uri: URI,
    val nsPrefix: String,
    val scope: UMLElement[Uml],
    val builtInURI: URI,
    val builtInExtent: Set[UMLElement[Uml]])( implicit val ops: UMLOps[Uml] )
extends Document[Uml] {
  override lazy val extent = builtInExtent
  override def toString: String = s"BuiltInDocument(uri=${uri})"
}
    
case class SerializableDocument[Uml <: UML](
    val uri: URI,
    val nsPrefix: String,
    val scope: UMLElement[Uml])( implicit val ops: UMLOps[Uml] ) 
extends Document[Uml] {
  override def toString: String = s"SerializableDocument(uri=${uri})"  
}