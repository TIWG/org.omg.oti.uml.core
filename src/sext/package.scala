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
package sext

import util.Try
import scala.language.higherKinds
import reflect.runtime.universe._
import reflect.runtime.currentMirror
import collection.GenTraversableOnce

/**
 * @author Nikita Volkov (original development)
 * @see https://github.com/nikita-volkov/sext/blob/master/src/main/scala/sext/package.scala
 *
 * @author Nicolas Rouquette
 * Enhancements for customizing 'treeString' & 'valueTreeString' behavior
 * @see http://solitaire.omg.org/browse/TIWG-39
 */
object `package` {

  implicit class SextMap [ A, B ] ( val a : Map[ A, B ] ) extends AnyVal {
    def filterValues(predicate: B => Boolean)
    = a.filter(pair => predicate(pair._2))
    def withValuesFilter(predicate: B => Boolean)
    = a.withFilter(pair => predicate(pair._2))
    def mapKeys[Z](f: A => Z)
    = a.map(pair => f(pair._1) -> pair._2)
  }

  implicit class SextTraversable
  [ A, B[A] <: Traversable[A] ]
  ( val a : B[A] )
    extends AnyVal
  {
    def zipBy [ Z ] ( f : A => Z ) : B[(A, Z)]
    = a.map(x => x -> f(x)).asInstanceOf[B[(A, Z)]]
  }

  implicit class SextAny [ A ] ( val a : A ) extends AnyVal {
    def tap [ Z ] ( f : A => Z ) = { f(a); a }

    /**
     * Is the value empty. Equivalent to monoid zero.
     */
    def isEmpty : Boolean
    = a match {
      case null => true
      case x: Boolean => !x
      case x: Byte => x == 0.toByte
      case x: Short => x == 0.toShort
      case x: Char => x == 0.toChar
      case x: Int => x == 0
      case x: Long => x == 0l
      case x: Float => x == 0f
      case x: Double => x == 0d
      case x: Product => x.productIterator.forall(_.isEmpty)
      case x: GenTraversableOnce[_] => x.isEmpty
      case _ => false
    }

    def notNull = Option(a)

    def notEmpty = if (a.isEmpty) None else Some(a)

    def satisfying(p: A => Boolean) : Option[A]
    = if (p(a)) Some(a) else None

    def trace [ Z ] ( f : A => Z = (x : A) => x.treeString )
    = { Console.println(f(a)); a }

    def trying [ Z ] ( f : A => Z ) = Try(f(a)).toOption

    def unfold
    [ Z ]
    ( f : A => Option[(Z, A)] )
    : Stream[Z]
    = f(a) map {case (b, a) => b #:: (a unfold f)} getOrElse Stream()

    def unfold1
    ( f : A => Option[A] )
    : Stream[A]
    = f(a) map (a => a #:: (a unfold1 f)) getOrElse Stream()

    def iterate
    ( f : A => A )
    : Stream[A]
    = a #:: (f(a) iterate f)

    def foldTo
    [ Z ]
    ( b : Traversable[Z] )
    ( f : (Z, A) => A)
    = (b foldRight a)(f)

    def foldFrom
    [ Z ]
    ( b : Traversable[Z] )
    ( f : (A, Z) => A)
    = (b foldLeft a)(f)

  }

  implicit class SextAnyToInstanceOf[ A : TypeTag ]( x : A ) {
    /**
     * Get an option of this value as of instance of type `T`
     * @tparam T A type to see this value as
     * @return `Some(a)` if `a` is an instance of `T` and `None` otherwise
     */
    def toInstanceOf[ T : TypeTag ] : Option[T]
    = {
      def test
      = currentMirror.runtimeClass(typeOf[T]) match {
        case c if c.isPrimitive => typeOf[A] <:< typeOf[T]
        case c => c.isAssignableFrom(x.getClass) || typeOf[A] <:< typeOf[T]
      }
      if( test ) Some( x.asInstanceOf[T] )
      else None
    }
  }

  /**
   * Trait for types that need to override treeString behavior
   *
   * @author Nicolas.F.Rouquette@jpl.nasa.gov
   */
  trait TreeString {
    def treeString: String
  }

  /**
   * Trait for types that need to override valueTreeString behavior
   *
   * @author Nicolas.F.Rouquette@jpl.nasa.gov
   */
  trait ValueTreeString {
    def valueTreeString: String
  }

  implicit class SextAnyTreeString [ A ] ( a : A ) {

    private def indent ( s : String )
    = s.lines.toStream match {
      case h +: t =>
        ( ("- " + h) +: t.map{"| " + _} ) mkString "\n"
      case _ => "- "
    }

    /**
     * @return A readable string representation of this value
     */
    def treeString
    : String
    = a match {
      case x : Traversable[_] =>
        x.stringPrefix + ":\n" +
          x.view
            .map{ _.treeString }
            .map{ indent }
            .mkString("\n")
      case x : TreeString =>
        // @TODO is there a way to do this without forcing inheritance from TreeString?
        x.treeString
      case x : Product if x.productArity == 0 =>
        x.productPrefix
      case x : Product =>
        x.productPrefix + ":\n" +
          x.productIterator
            .map{ _.treeString }
            .map{ indent }
            .mkString("\n")
      case null =>
        "null"
      case _ =>
        a.toString
    }

    /**
     * @return A readable string representation of this value of a different format to `treeString`
     */
    def valueTreeString
    : String
    = a match {
      case (k, v) =>
        k.valueTreeString + ":\n" +
          v.valueTreeString
      case a : TraversableOnce[_] =>
        a.toStream
          .map(_.valueTreeString)
          .map(indent)
          .mkString("\n")
      case x : ValueTreeString =>
        // @TODO is there a way to do this without forcing inheritance from ValueTreeString?
        x.valueTreeString
      case a : Product =>
        val b
        = currentMirror.reflect(a).symbol.typeSignature.members.toStream
          .collect{ case a : TermSymbol => a }
          .filterNot(_.isMethod)
          .filterNot(_.isModule)
          .filterNot(_.isClass)
          .map( currentMirror.reflect(a).reflectField )
          .map( f => f.symbol.name.toString.trim -> f.get )
          .reverse
        a.productPrefix + "\n" + collection.immutable.ListMap(b: _*).valueTreeString
      case null =>
        "null"
      case _ =>
        a.toString
    }

  }

  implicit class SextString
  ( val s : String )
    extends AnyVal
  {
    def notEmpty
    = if( s.isEmpty ) None else Some(s)
    def indent
    ( i : Int )
    = prependLines(" " * i)
    def prependLines
    ( p : String )
    = s.lines
      .reduceOption{ _ + "\n" + p + _ }
      .map{ p + _ }
      .getOrElse( p )
    def splitBy
    ( splitter : String )
    : (String, String)
    = s.indexOf(splitter) match {
      case -1 => (s, "")
      case i => s.splitAt(i) match { case (a, b) => (a, b.drop(splitter.size)) }
    }
  }

  implicit class SextBoolean ( val a : Boolean ) extends AnyVal {
    def option [ Z ] ( b : Z ) : Option[Z] = if( a ) Some(b) else None
  }

  implicit class SextTuple4
  [ A, B, C, D ]
  ( val t : (Iterable[A], Iterable[B], Iterable[C], Iterable[D]) )
    extends AnyVal
  {
    def zipped
    = t._1.toStream
      .zip(t._2).zip(t._3).zip(t._4)
      .map{ case (((a, b), c), d) => (a, b, c, d) }
  }

  implicit class SextIterable
  [ A, B, C, D ]
  ( val ts : Iterable[(A, B, C, D)] )
    extends AnyVal
  {
    def unzip4
    = ts.foldRight((List[A](), List[B](), List[C](), List[D]()))(
      (a, z) => (a._1 +: z._1, a._2 +: z._2, a._3 +: z._3, a._4 +: z._4)
    )
  }

  implicit class SextInt ( val a : Int ) {
    def times ( f : => Unit ) = (0 to a).foreach(_ => f)
  }

  /**
   * Useful for wrapping a function and passing as lambda when partially applied
   */
  def trying [ A, Z ] ( f : A => Z ) ( a : A ) = a trying f

  def memo [ A, Z ] ( f : A => Z ) = {
    // a WeakHashMap will release cache members if memory tightens
    val cache = new collection.mutable.WeakHashMap[A, Z]
    x : A => synchronized { cache.getOrElseUpdate( x, f(x) ) }
  }

}