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
package org.omg.oti.uml.write

import org.omg.oti.uml._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{Enumeration,Option,Unit}
import scala.Predef.{???,String}
import scala.collection.immutable._
import scala.collection.Iterable
import scala.reflect._
import scalaz._

/**
 * UMLAttributeUpdater supports setting/clearing the value of a DataType metaclass property
 */
trait UMLAttributeUpdater[Uml <: UML] {
  
  implicit def ops: UMLOps[Uml]
  
	sealed abstract trait MetaAttributeUpdate[U <: UMLElement[Uml], DT] {
	  
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit
	  
	}
  
  case class MetaScalarAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, DT) => \/[NonEmptyList[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U, DT] {
        
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit = {
	    ???
	  }
  }

  type MetaScalarAttributeUpdate =
  MetaScalarAttributeUpdater[_ <: UMLElement[Uml], _]

  case class MetaEnumerationAttributeUpdater[U <: UMLElement[Uml], DT <: Enumeration#Value, DTSet <: Enumeration#ValueSet]
  ( attributeUpdate: (U, Option[DT]) => \/[NonEmptyList[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeEnumerationFunction[Uml, U, DT, DTSet] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U, DT] {
        
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit = {
	    ???
	  }
  }

  type MetaEnumerationAttributeUpdate =
  MetaEnumerationAttributeUpdater[_ <: UMLElement[Uml], _, _]

  case class MetaOptionAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Option[DT]) => \/[NonEmptyList[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U, DT] {
        
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit = {
	    ???
	  }
  }

  type MetaOptionAttributeUpdate =
  MetaOptionAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaIterableAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Iterable[DT]) => \/[NonEmptyList[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U, DT] {
        
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit = {
	    ???
	  }
  }

  type MetaIterableAttributeUpdate =
  MetaIterableAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaSetAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Set[DT]) => \/[NonEmptyList[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U, DT] {
        
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit = {
	    ???
	  }
  }

  type MetaSetAttributeUpdate =
  MetaSetAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaSeqAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Seq[DT]) => \/[NonEmptyList[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U, DT] {
        
	  def update(u: U, v: String): NonEmptyList[java.lang.Throwable] \/ Unit = {
	    ???
	  }
  }

  type MetaSeqAttributeUpdate =
  MetaSeqAttributeUpdater[_ <: UMLElement[Uml], _]
  
}