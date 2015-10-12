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
package org.omg.oti.uml

import org.omg.oti.uml.read.api.{UML, UMLElement}
import org.omg.oti.uml.write.api.UMLUpdate

import scala.{Option, None, StringContext}
import scala.Predef.String
import scala.collection.Iterable

object UMLError {

  trait UException {

    /**
     * Information about the error that occured
     */
    val error: Option[java.lang.Throwable]

    val message: String
  }

  trait UElementException[Uml <: UML, E <: UMLElement[Uml]] extends UException {

    type UmlE = E

    /**
     * Information about particular UML elements whose metaclass is a kind of `E`
     */
    val element: Iterable[UmlE]
  }

  case class IllegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   override val element: Iterable[E],
   override val error: Option[java.lang.Throwable])
  extends UElementException[Uml, E]

  trait UEvaluationException[Uml <: UML, E <: UMLElement[Uml]] extends UException {

    type UmlE = E

    /**
     * Information about the subject of evaluating a UML meta property/attribute function
     * on a particular UML element whose metaclass is a kind of `E`
     */
    val element: UmlE

    val message: String
  }

  case class IllegalMetaPropertyEvaluation[Uml <: UML, E <: UMLElement[Uml], MPF <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  (override val element: E,
   metaPropertyFunction: MPF)
  extends UEvaluationException[Uml, E] {

    override val error: Option[java.lang.Throwable] = None
    override val message: String = s"$metaPropertyFunction not applicable to ${element.xmiType.head}"

  }

  case class IllegalMetaAttributeEvaluation[Uml <: UML, E <: UMLElement[Uml], U <: UMLElement[Uml], DT]
  (override val element: E,
   metaAttributeFunction: MetaAttributeAbstractFunction[Uml, U, DT])
  extends UEvaluationException[Uml, E] {

    override val error: Option[java.lang.Throwable] = None
    override val message: String = s"$metaAttributeFunction not applicable to ${element.xmiType.head}"
  }

  case class UMLUpdateError[Uml <: UML]
  (umlUpdate: UMLUpdate[Uml],
   override val message: String,
   override val error: Option[java.lang.Throwable])
  extends UException

  def illegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   element: Iterable[E],
   error: Option[java.lang.Throwable])
  : UException =
    new IllegalElementException[Uml, E](message, element, error)

  def illegalMetaPropertyEvaluation[Uml <: UML, E <: UMLElement[Uml], MPF <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  (element: E,
   metaPropertyFunction: MPF)
  : UException =
    new IllegalMetaPropertyEvaluation[Uml, E, MPF](element, metaPropertyFunction)

  def illegalMetaAttributeEvaluation[Uml <: UML, E <: UMLElement[Uml], U <: UMLElement[Uml], DT]
  (element: E,
   metaAttributeFunction: MetaAttributeAbstractFunction[Uml, U, DT])
  : UException =
    new IllegalMetaAttributeEvaluation[Uml, E, U, DT](element, metaAttributeFunction)


}