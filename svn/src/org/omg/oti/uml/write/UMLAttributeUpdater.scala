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
package org.omg.oti.uml.write

import java.lang.Integer

import org.omg.oti.uml.{MetaAttributeAbstractFunction, MetaAttributeEnumerationFunction, UMLError}
import org.omg.oti.uml.characteristics.OTICharacteristicsProvider
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.{Boolean,Double,Enumeration,Option,None,Some,StringContext,Unit}
import scala.Predef.String
import scala.collection.immutable._
import scala.collection.Iterable
import scala.reflect._
import scala.util.control.Exception._
import scalaz._

object UMLAttributeUpdater {
  
  import scala.Predef.augmentString
  
  sealed abstract trait ValueConverter[DT] {
    def convert(valueRepresentation: String)
    : Set[java.lang.Throwable] \/ DT
  }
  
  object BooleanValueConverter 
  extends ValueConverter[Boolean] {
    override def convert(valueRepresentation: String)
    : Set[java.lang.Throwable] \/ Boolean =
      nonFatalCatch[Set[java.lang.Throwable] \/ Boolean]
      .withApply{
      (cause: java.lang.Throwable) =>
        -\/(Set(
          UMLError
            .UMLAdaptationException(
            s"Error parsing a Boolean value: ${cause.getMessage}",
            cause)))
    }
    .apply(\/-(valueRepresentation.toBoolean))
  }
  
  object IntegerValueConverter 
  extends ValueConverter[Integer] {
    override def convert(valueRepresentation: String)
    : Set[java.lang.Throwable] \/ Integer =
      nonFatalCatch[Set[java.lang.Throwable] \/ Integer]
      .withApply{
      (cause: java.lang.Throwable) =>
        -\/(Set(
          UMLError
            .UMLAdaptationException(
            s"Error parsing an Integer value: ${cause.getMessage}",
            cause)))
    }
    .apply(\/-(new Integer(valueRepresentation.toInt)))
  }
  
  object UnlimitedNaturalValueConverter 
  extends ValueConverter[Integer] {
    override def convert(valueRepresentation: String)
    : Set[java.lang.Throwable] \/ Integer =
      nonFatalCatch[Set[java.lang.Throwable] \/ Integer]
      .withApply{
      (cause: java.lang.Throwable) =>
        -\/(Set(
          UMLError
            .UMLAdaptationException(
            s"Error parsing an Integer value: ${cause.getMessage}",
            cause)))
    }
    .apply(
        if ("*" == valueRepresentation)
          infinite
        else
          \/-(new Integer(valueRepresentation.toInt))
    )
    
    val infinite = \/-(new Integer(-1))
  }
  
  object DoubleValueConverter 
  extends ValueConverter[Double] {
    override def convert(valueRepresentation: String)
    : Set[java.lang.Throwable] \/ Double =
      nonFatalCatch[Set[java.lang.Throwable] \/ Double]
      .withApply{
      (cause: java.lang.Throwable) =>
        -\/(Set(
          UMLError
            .UMLAdaptationException(
            s"Error parsing a Double value: ${cause.getMessage}",
            cause)))
    }
    .apply(\/-(valueRepresentation.toDouble))
  }
  
  object StringValueConverter 
  extends ValueConverter[String] {
    override def convert(valueRepresentation: String)
    : Set[java.lang.Throwable] \/ String =
      \/-(valueRepresentation)
  }
  
}

/**
 * UMLAttributeUpdater supports setting/clearing the value of a DataType metaclass property
 */
trait UMLAttributeUpdater[Uml <: UML] {
  
  implicit def ops: UMLOps[Uml]
  
  
	sealed abstract trait MetaAttributeUpdate[U <: UMLElement[Uml]] {
	  
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
    : Set[java.lang.Throwable] \/ Unit
	  
	}
  
  case class MetaScalarAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, DT) => \/[Set[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT],
    valueConverter: String => Set[java.lang.Throwable] \/ DT)
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT])
  extends MetaAttributeUpdate[U] {
        
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
    : Set[java.lang.Throwable] \/ Unit =
	    u match {
	    case aU: U =>
	      valueConverter(v) match {
	        case -\/(nels) =>
	          -\/(nels)
	        case \/-(aV) =>
	          attributeUpdate(aU, aV)
	      }
	    
      case _ =>
        -\/(Set(
          UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"MetaOptionAttributeUpdater: error type mismatch",
            Iterable(u))))
	  }
	  
  }

  type MetaScalarAttributeUpdate =
  MetaScalarAttributeUpdater[_ <: UMLElement[Uml], _]

  case class MetaEnumerationAttributeUpdater[U <: UMLElement[Uml], DT <: Enumeration#Value, DTSet <: Enumeration#ValueSet]
  ( attributeUpdate: (U, Option[DT]) => \/[Set[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeEnumerationFunction[Uml, U, DT, DTSet],
    enumerationValues: Iterable[DT] )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U] {
        
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
	  : Set[java.lang.Throwable] \/ Unit =
	    u match {
	    case aU: U =>
	      enumerationValues.find { eValue: DT =>
	        eValue.toString == v
	      } match {
	        case None =>
	          -\/(Set(
	              UMLError
	              .illegalElementError[Uml, UMLElement[Uml]](
	                  s"MetaOptionAttributeUpdater: unrecognized enumeration value "+
	                  s"'$v' for $enumerationValues",
	                  Iterable(u))))
	        case Some(enumValue) =>
	          attributeUpdate(aU, Some(enumValue))
	      }
	    
      case _ =>
        -\/(Set(
          UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"MetaOptionAttributeUpdater: error type mismatch",
            Iterable(u))))
	  }
  }

  type MetaEnumerationAttributeUpdate =
  MetaEnumerationAttributeUpdater[_ <: UMLElement[Uml], _, _]

  case class MetaOptionAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Option[DT]) => \/[Set[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT],
    valueConverter: String => Set[java.lang.Throwable] \/ DT )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U] {
        
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
	  : Set[java.lang.Throwable] \/ Unit =
	    u match {
	    case aU: U =>
	      for {
	        dValue <- valueConverter(v)
	        _ <- attributeUpdate(aU, Some(dValue))
	      } yield ()
	    
      case _ =>
        -\/(Set(
          UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"MetaOptionAttributeUpdater: error type mismatch",
            Iterable(u))))
	  }
  }

  type MetaOptionAttributeUpdate =
  MetaOptionAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaIterableAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Iterable[DT]) => \/[Set[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT],
    valueConverter: String => Set[java.lang.Throwable] \/ DT )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U] {
        
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
	  : Set[java.lang.Throwable] \/ Unit =
	    u match {
	    case aU: U =>
	      valueConverter(v) match {
	        case -\/(nels) =>
	          -\/(nels)
	        case \/-(aV) =>
	          (attributeQuery.f, attributeQuery.df) match {
	             case (Some(_f), _) =>
	               _f(aU).flatMap { ds => 
	                 attributeUpdate(aU, ds ++ Iterable(aV))
	               }
	             case (None, Some(_df)) =>
	               _df(aU, otiCharacteristicsProvider).flatMap { ds =>
	                 attributeUpdate(aU, ds ++ Iterable(aV))
                 }
               case _ =>
                 -\/(
                     Set(
                         UMLError
                         .illegalMetaAttributeEvaluation[Uml, U, U, DT](aU, attributeQuery)))
            }
	      }
	    
      case _ =>
        -\/(Set(
          UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"MetaOptionAttributeUpdater: error type mismatch",
            Iterable(u))))
	  }
  }

  type MetaIterableAttributeUpdate =
  MetaIterableAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaSetAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Set[DT]) => \/[Set[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT],
    valueConverter: String => Set[java.lang.Throwable] \/ DT )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U] {
        
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
	  : Set[java.lang.Throwable] \/ Unit =
	    u match {
	    case aU: U =>
	      valueConverter(v) match {
	        case -\/(nels) =>
	          -\/(nels)
	        case \/-(aV) =>
	          (attributeQuery.f, attributeQuery.df) match {
	             case (Some(_f), _) =>
	               _f(aU).flatMap { ds => 
	                 attributeUpdate(aU, ds.toSet ++ Set(aV))
	               }
	             case (None, Some(_df)) =>
	               _df(aU, otiCharacteristicsProvider).flatMap { ds =>
	                 attributeUpdate(aU, ds.toSet ++ Set(aV))
                 }
               case _ =>
                 -\/(
                     Set(
                         UMLError
                         .illegalMetaAttributeEvaluation[Uml, U, U, DT](aU, attributeQuery)))
            }
	      }
	    
      case _ =>
        -\/(Set(
          UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"MetaOptionAttributeUpdater: error type mismatch",
            Iterable(u))))
	  }
  }

  type MetaSetAttributeUpdate =
  MetaSetAttributeUpdater[_ <: UMLElement[Uml], _]
  
  case class MetaSeqAttributeUpdater[U <: UMLElement[Uml], DT]
  ( attributeUpdate: (U, Seq[DT]) => \/[Set[java.lang.Throwable], Unit],
    attributeQuery: MetaAttributeAbstractFunction[Uml, U, DT],
    valueConverter: String => Set[java.lang.Throwable] \/ DT )
  ( implicit utag: ClassTag[U], dtag: ClassTag[DT] )
  extends MetaAttributeUpdate[U] {
        
	  def update
	  (u: UMLElement[Uml], v: String)
    ( implicit 
      otiCharacteristicsProvider: OTICharacteristicsProvider[Uml] )
	  : Set[java.lang.Throwable] \/ Unit =
	    u match {
	    case aU: U =>
	      valueConverter(v) match {
	        case -\/(nels) =>
	          -\/(nels)
	        case \/-(aV) =>
	          (attributeQuery.f, attributeQuery.df) match {
	             case (Some(_f), _) =>
	               _f(aU).flatMap { ds => 
	                 attributeUpdate(aU, ds.to[Seq] ++ Seq(aV))
	               }
	             case (None, Some(_df)) =>
	               _df(aU, otiCharacteristicsProvider).flatMap { ds =>
	                 attributeUpdate(aU, ds.to[Seq] ++ Seq(aV))
                 }
               case _ =>
                 -\/(
                     Set(
                         UMLError
                         .illegalMetaAttributeEvaluation[Uml, U, U, DT](aU, attributeQuery)))
            }
	      }
	    
      case _ =>
        -\/(Set(
          UMLError
          .illegalElementError[Uml, UMLElement[Uml]](
            s"MetaOptionAttributeUpdater: error type mismatch",
            Iterable(u))))
	  }
  }

  type MetaSeqAttributeUpdate =
  MetaSeqAttributeUpdater[_ <: UMLElement[Uml], _]
  
}