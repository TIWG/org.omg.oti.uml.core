/*
 *
 * License Terms
 *
 * Copyright (c) 2014-2016, California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * *   Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *   Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * *   Neither the name of Caltech nor its operating division, the Jet
 *    Propulsion Laboratory, nor the names of its contributors may be
 *    used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.uml

import org.omg.oti.uml.read.api.{UML, UMLElement}
import org.omg.oti.uml.read.operations.UMLOps
import org.omg.oti.uml.write.UMLAttributeUpdater
import org.omg.oti.uml.xmi.IDGenerator

import scala.collection.immutable.Set
import scala.{Option, None, StringContext}
import scala.Predef.String
import scala.collection.Iterable

import scalaz._, Scalaz._

object UMLError {

  type ThrowableNel = Set[java.lang.Throwable]
  type OptionThrowableNel = Option[ThrowableNel]
  val emptyThrowableNel = Option.empty[Set[java.lang.Throwable]]

  class UException
  ( val message: String,
    val cause: OptionThrowableNel = None )
  extends java.lang.Throwable(message) {

    cause.map { nels =>
      this.initCause(nels.head)
    }

  }

  class UMLAdaptationError
  ( override val message: String)
    extends UException(message, emptyThrowableNel )

  class UMLAdaptationException
  ( override val message: String,
    override val cause: OptionThrowableNel)
    extends UException(message, cause)

  class UMLOpsError[Uml <: UML]
  ( val ops: UMLOps[Uml],
    override val message: String)
    extends UException(message, emptyThrowableNel )

  class UMLOpsException[Uml <: UML]
  ( val ops: UMLOps[Uml],
    override val message: String,
    override val cause: OptionThrowableNel )
    extends UException(message, cause)

  class UElementException[Uml <: UML, E <: UMLElement[Uml]]
  ( val element: Iterable[E],
    override val message: String,
    override val cause: OptionThrowableNel = emptyThrowableNel)
  extends UException(message, cause) {
    type UmlE = E
  }

  class IllegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (override val element: Iterable[E],
   override val message: String,
   override val cause: OptionThrowableNel = emptyThrowableNel)
  extends UElementException[Uml, E](element, message, cause)

  abstract class UEvaluationException[Uml <: UML, E <: UMLElement[Uml]]
  ( val element: Iterable[E],
    override val message: String,
    override val cause: OptionThrowableNel = emptyThrowableNel)
  extends UException(message, cause) {
    type UmlE = E
  }

  class IllegalMetaPropertyEvaluation[
  Uml <: UML, 
  E <: UMLElement[Uml], 
  MPF <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  ( val e: E,
    metaPropertyFunction: MPF)
  extends UEvaluationException[Uml, E](Iterable(e), s"$metaPropertyFunction not applicable to ${e.xmiType.head}")

  class IllegalMetaAttributeEvaluation[Uml <: UML, E <: UMLElement[Uml], U <: UMLElement[Uml], DT]
  ( val e: E,
    metaAttributeFunction: MetaAttributeAbstractFunction[Uml, U, DT])
  extends UEvaluationException[Uml, E](Iterable(e), s"$metaAttributeFunction not applicable to ${e.xmiType.head}")

  class UMLUpdateException[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLAttributeUpdater[Uml],
   override val element: Iterable[E],
   override val message: String,
   override val cause: OptionThrowableNel)
  extends UElementException[Uml, E](element, message, cause)
  
  class IDGeneratorException[Uml <: UML]
  ( idGenerator: IDGenerator[Uml],
    override val element: Iterable[UMLElement[Uml]],
    override val message: String,
    override val cause: UMLError.OptionThrowableNel = UMLError.emptyThrowableNel)
  extends UMLError.UElementException[Uml, UMLElement[Uml]](element, message, cause)

  class UUIDGeneratorException[Uml <: UML]
  ( idGenerator: IDGenerator[Uml],
    override val element: Iterable[UMLElement[Uml]],
    override val message: String,
    override val cause: UMLError.OptionThrowableNel = UMLError.emptyThrowableNel)
    extends UMLError.UElementException[Uml, UMLElement[Uml]](element, message, cause)

  def umlAdaptationError
  (message: String)
  : java.lang.Throwable =
    new UMLAdaptationError(message)

  def UMLAdaptationException
  ( message: String,
    cause: ThrowableNel)
  : java.lang.Throwable =
    new UMLAdaptationException(message, cause.some)

  def UMLAdaptationException
  ( message: String,
    cause: java.lang.Throwable)
  : java.lang.Throwable =
    new UMLAdaptationException(message, Set(cause).some)

  def illegalElementError[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   element: Iterable[E])
  : java.lang.Throwable =
    new IllegalElementException[Uml, E](element, message, None)

  def illegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   element: Iterable[E],
   cause: ThrowableNel)
  : java.lang.Throwable =
    new IllegalElementException[Uml, E](element, message, cause.some)

  def illegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (message: String,
   element: Iterable[E],
   cause: java.lang.Throwable)
  : java.lang.Throwable =
    new IllegalElementException[Uml, E](element, message, Set(cause).some)

  def illegalMetaPropertyEvaluation[
  Uml <: UML, 
  E <: UMLElement[Uml], 
  MPF <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  (element: E,
   metaPropertyFunction: MPF)
  : java.lang.Throwable =
    new IllegalMetaPropertyEvaluation[Uml, E, MPF](element, metaPropertyFunction)

  def illegalMetaAttributeEvaluation[Uml <: UML, E <: UMLElement[Uml], U <: UMLElement[Uml], DT]
  (element: E,
   metaAttributeFunction: MetaAttributeAbstractFunction[Uml, U, DT])
  : java.lang.Throwable =
    new IllegalMetaAttributeEvaluation[Uml, E, U, DT](element, metaAttributeFunction)

  def umlOpsError[Uml <: UML]
  ( ops: UMLOps[Uml],
    message: String)
  : java.lang.Throwable =
    new UMLOpsError(ops, message)

  def umlOpsException[Uml <: UML]
  ( ops: UMLOps[Uml],
    message: String,
    cause: ThrowableNel)
  : java.lang.Throwable =
    new UMLOpsException(ops, message, cause.some)

  def umlOpsException[Uml <: UML]
  ( ops: UMLOps[Uml],
    message: String,
    cause: java.lang.Throwable)
  : java.lang.Throwable =
    new UMLOpsException(ops, message, Set(cause).some)

  def umlUpdateError[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLAttributeUpdater[Uml],
   element: Iterable[E],
   message: String)
  : java.lang.Throwable =
    new UMLUpdateException[Uml, E](umlUpdate, element, message, None)

  def umlUpdateException[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLAttributeUpdater[Uml],
   element: Iterable[E],
   message: String,
   cause: ThrowableNel)
  : java.lang.Throwable =
    new UMLUpdateException[Uml, E](umlUpdate, element, message, cause.some)

  def umlUpdateException[Uml <: UML, E <: UMLElement[Uml]]
  (umlUpdate: UMLAttributeUpdater[Uml],
   element: Iterable[E],
   message: String,
   cause: java.lang.Throwable)
  : java.lang.Throwable =
    new UMLUpdateException[Uml, E](umlUpdate, element, message, Set(cause).some)

}