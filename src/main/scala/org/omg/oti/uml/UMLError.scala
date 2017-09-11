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

package org.omg.oti.uml

import org.omg.oti.uml.read.api.{UML, UMLElement}
import org.omg.oti.uml.read.operations.UMLOps
import org.omg.oti.uml.write.UMLAttributeUpdater
import org.omg.oti.uml.xmi.IDGenerator

import scala.collection.immutable.Set
import scala.{Any,Boolean,Int,Option,None,StringContext}
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

    override val hashCode: Int = (message, cause).##

    def canEqual(other: Any): Boolean = other match {
      case _: UException => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UException =>
        (that canEqual this) &&
          (this.message == that.message) &&
          (this.cause == that.cause)
      case _ =>
        false
    }

  }

  class UMLAdaptationError
  ( override val message: String)
    extends UException(message, emptyThrowableNel ) {

    override val hashCode: Int = message.##

    override def canEqual(other: Any): Boolean = other match {
      case _: UMLAdaptationError => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UMLAdaptationError =>
        (that canEqual this) &&
          (this.message == that.message)
      case _ =>
        false
    }

  }

  class UMLAdaptationException
  ( override val message: String,
    override val cause: OptionThrowableNel)
    extends UException(message, cause) {

    override val hashCode: Int = (message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UMLAdaptationException => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UMLAdaptationException =>
        (that canEqual this) &&
          (this.message == that.message) &&
          (this.cause == that.cause)
      case _ =>
        false
    }

  }

  class UMLOpsError[Uml <: UML]
  ( val ops: UMLOps[Uml],
    override val message: String)
    extends UException(message, emptyThrowableNel ) {

    override val hashCode: Int = (ops, message).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UMLOpsError[_] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UMLOpsError[Uml] =>
        (that canEqual this) &&
          (this.message == that.message) &&
          (this.ops == that.ops)
      case _ =>
        false
    }

  }

  class UMLOpsException[Uml <: UML]
  ( val ops: UMLOps[Uml],
    override val message: String,
    override val cause: OptionThrowableNel )
    extends UException(message, cause) {

    override val hashCode: Int = (ops, message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UMLOpsException[_] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UMLOpsException[Uml] =>
        (that canEqual this) &&
          (this.message == that.message) &&
          (this.cause == that.cause) &&
          (this.ops == that.ops)
      case _ =>
        false
    }
  }

  class UElementException[Uml <: UML, E <: UMLElement[Uml]]
  ( val element: Iterable[E],
    override val message: String,
    override val cause: OptionThrowableNel = emptyThrowableNel)
  extends UException(message, cause) {
    type UmlE = E

    override val hashCode: Int = (element, message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UElementException[_, _] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UElementException[Uml, E] =>
        (that canEqual this) &&
          (this.element == that.element) &&
          (this.message == that.message) &&
          (this.cause == that.cause)
      case _ =>
        false
    }
  }

  class IllegalElementException[Uml <: UML, E <: UMLElement[Uml]]
  (override val element: Iterable[E],
   override val message: String,
   override val cause: OptionThrowableNel = emptyThrowableNel)
  extends UElementException[Uml, E](element, message, cause) {

    override val hashCode: Int = (element, message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: IllegalElementException[_, _] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: IllegalElementException[Uml, E] =>
        (that canEqual this) &&
          (this.element == that.element) &&
          (this.message == that.message) &&
          (this.cause == that.cause)
      case _ =>
        false
    }
  }

  abstract class UEvaluationException[Uml <: UML, E <: UMLElement[Uml]]
  ( val element: Iterable[E],
    override val message: String,
    override val cause: OptionThrowableNel = emptyThrowableNel)
  extends UException(message, cause) {
    type UmlE = E

    override val hashCode: Int = (element, message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UEvaluationException[_, _] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UEvaluationException[Uml, E] =>
        (that canEqual this) &&
          (this.element == that.element) &&
          (this.message == that.message) &&
          (this.cause == that.cause)
      case _ =>
        false
    }
  }

  class IllegalMetaPropertyEvaluation[
  Uml <: UML, 
  E <: UMLElement[Uml], 
  MPF <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  ( val e: E,
    val metaPropertyFunction: MPF)
  extends UEvaluationException[Uml, E](Iterable(e), s"$metaPropertyFunction not applicable to ${e.xmiType.head}") {

    override val hashCode: Int = (e, metaPropertyFunction).##

    override def canEqual(other: Any): Boolean = other match {
      case _: IllegalMetaPropertyEvaluation[_, _, _] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: IllegalMetaPropertyEvaluation[Uml, E, MPF] =>
        (that canEqual this) &&
          (this.e == that.e) &&
          (this.metaPropertyFunction == that.metaPropertyFunction)
      case _ =>
        false
    }
  }

  class IllegalMetaAttributeEvaluation[Uml <: UML, E <: UMLElement[Uml], U <: UMLElement[Uml], DT]
  ( val e: E,
    val metaAttributeFunction: MetaAttributeAbstractFunction[Uml, U, DT])
  extends UEvaluationException[Uml, E](Iterable(e), s"$metaAttributeFunction not applicable to ${e.xmiType.head}") {

    override val hashCode: Int = (e, metaAttributeFunction).##

    override def canEqual(other: Any): Boolean = other match {
      case _: IllegalMetaAttributeEvaluation[_, _, _, _] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: IllegalMetaAttributeEvaluation[Uml, E, U, DT] =>
        (that canEqual this) &&
          (this.e == that.e) &&
          (this.metaAttributeFunction == that.metaAttributeFunction)
      case _ =>
        false
    }
  }

  class UMLUpdateException[Uml <: UML, E <: UMLElement[Uml]]
  (val umlUpdate: UMLAttributeUpdater[Uml],
   override val element: Iterable[E],
   override val message: String,
   override val cause: OptionThrowableNel)
  extends UElementException[Uml, E](element, message, cause) {

    override val hashCode: Int = (umlUpdate, element, message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UMLUpdateException[_, _] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UMLUpdateException[Uml, E] =>
        (that canEqual this) &&
          (this.element == that.element) &&
          (this.message == that.message) &&
          (this.cause == that.cause) &&
          (this.umlUpdate == that.umlUpdate)
      case _ =>
        false
    }
  }
  
  class IDGeneratorException[Uml <: UML]
  ( val idGenerator: IDGenerator[Uml],
    override val element: Iterable[UMLElement[Uml]],
    override val message: String,
    override val cause: UMLError.OptionThrowableNel = UMLError.emptyThrowableNel)
  extends UMLError.UElementException[Uml, UMLElement[Uml]](element, message, cause) {

      override val hashCode: Int = (idGenerator, element, message, cause).##

      override def canEqual(other: Any): Boolean = other match {
        case _: IDGeneratorException[_] => true
        case _ => false
      }

      override def equals(other: Any): Boolean = other match {
      case that: IDGeneratorException[Uml] =>
        (that canEqual this) &&
          (this.element == that.element) &&
          (this.message == that.message) &&
          (this.cause == that.cause) &&
          (this.idGenerator == that.idGenerator)
      case _ =>
        false
    }

  }

  class UUIDGeneratorException[Uml <: UML]
  ( val idGenerator: IDGenerator[Uml],
    override val element: Iterable[UMLElement[Uml]],
    override val message: String,
    override val cause: UMLError.OptionThrowableNel = UMLError.emptyThrowableNel)
    extends UMLError.UElementException[Uml, UMLElement[Uml]](element, message, cause) {

    override val hashCode: Int = (idGenerator, element, message, cause).##

    override def canEqual(other: Any): Boolean = other match {
      case _: UUIDGeneratorException[_] => true
      case _ => false
    }

    override def equals(other: Any): Boolean = other match {
      case that: UUIDGeneratorException[Uml] =>
        (that canEqual this) &&
          (this.element == that.element) &&
          (this.message == that.message) &&
          (this.cause == that.cause) &&
          (this.idGenerator == that.idGenerator)
      case _ =>
        false
    }

  }

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