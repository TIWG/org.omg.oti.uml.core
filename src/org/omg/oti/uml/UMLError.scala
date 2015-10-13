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

import scala.{Option, None, Some, StringContext}
import scala.Predef.String
import scala.collection.Iterable

object UMLError {

  class UException
  ( val message: String,
    val cause: Option[java.lang.Throwable] = None )
  extends java.lang.Throwable(message) {

    cause.map(this.initCause(_))

  }

  class UElementException[Uml <: UML, E <: UMLElement[Uml]]
  ( val element: Iterable[E],
    override val message: String,
    override val cause: Option[java.lang.Throwable] = None)
  extends UException(message, cause) {
    type UmlE = E
  }

  class IllegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (override val element: Iterable[E],
   override val message: String,
   override val cause: Option[java.lang.Throwable] = None)
  extends UElementException[Uml, E](element, message, cause)

  abstract class UEvaluationException[Uml <: UML, E <: UMLElement[Uml]]
  ( val element: Iterable[E],
    override val message: String,
    override val cause: Option[java.lang.Throwable] = None)
  extends UException(message, cause) {
    type UmlE = E
  }

  class IllegalMetaPropertyEvaluation[Uml <: UML, E <: UMLElement[Uml], MPF <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  ( val e: E,
    metaPropertyFunction: MPF)
  extends UEvaluationException[Uml, E](Iterable(e), s"$metaPropertyFunction not applicable to ${e.xmiType.head}", None)

  class IllegalMetaAttributeEvaluation[Uml <: UML, E <: UMLElement[Uml], U <: UMLElement[Uml], DT]
  ( val e: E,
    metaAttributeFunction: MetaAttributeAbstractFunction[Uml, U, DT])
  extends UEvaluationException[Uml, E](Iterable(e), s"$metaAttributeFunction not applicable to ${e.xmiType.head}", None)

  class UMLUpdateException[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLUpdate[Uml],
   override val element: Iterable[E],
   override val message: String,
   override val cause: Option[java.lang.Throwable])
  extends UElementException[Uml, E](element, message, cause)

  def illegalElementError[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   element: Iterable[E])
  : UException =
    new IllegalElementException[Uml, E](element, message, None)

  def illegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   element: Iterable[E],
   cause: java.lang.Throwable)
  : UException =
    new IllegalElementException[Uml, E](element, message, Some(cause))

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

  def umlUpdateError[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLUpdate[Uml],
   element: Iterable[E],
   message: String)
  : UException =
    new UMLUpdateException[Uml, E](umlUpdate, element, message, None)

  def umlUpdateException[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLUpdate[Uml],
   element: Iterable[E],
   message: String,
   cause: java.lang.Throwable)
  : UException =
    new UMLUpdateException[Uml, E](umlUpdate, element, message, Some(cause))
}
