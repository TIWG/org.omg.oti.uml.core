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

import org.omg.oti.operations._
import scala.annotation.tailrec
import scala.language.higherKinds
import scala.language.implicitConversions
import scala.language.postfixOps
import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._
import org.omg.oti.api._
import scala.util.Try
import scala.util.Failure
import scala.util.Success
import scalax.collection.config.CoreConfig
import scalax.collection.mutable.ArraySet.Hints
import scalax.collection.GraphEdge._
import scalax.collection.GraphPredef._
import scalax.collection.constrained._
import scalax.collection.constrained.constraints.NoneConstraint
import scalax.collection.constrained.generic.GraphConstrainedCompanion
import scalax.collection.edge.CBase._
import scalax.collection.io.edge.CEdgeParameters
import scalax.collection.io.json.Descriptor
import scalax.collection.io.json.descriptor.CEdgeDescriptor
import scalax.collection.io.json.descriptor.NodeDescriptor
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.PrintWriter

import scalaz._, Scalaz._, Free._

case class ResolvedDocumentSet[Uml <: UML](
  val ds: DocumentSet[Uml],
  val g: DocumentSet[Uml]#MutableDocumentSetGraph,
  val element2document: Map[UMLElement[Uml], Document[Uml]] ) {

  type ValueSpecificationTagConverter = Function1[UMLValueSpecification[Uml], Try[Option[String]]]

  def getStereptype_ID_UUID( s: UMLStereotype[Uml] ): ( String, String ) =
    element2document.get( s ) match {
      case None =>
        throw new IllegalArgumentException( s"There should be a document for stereotype ${s.qualifiedName.get} (ID=${s.id})" )

      case Some( d: BuiltInDocument[Uml] ) =>
        val builtInURI = d.builtInURI.resolve( "#" + s.id ).toString
        val mappedURI = ds.builtInURIMapper.resolve( builtInURI ).getOrElse( builtInURI )
        val fragmentIndex = mappedURI.lastIndexOf( '#' )
        require( fragmentIndex > 0 )
        val fragment = IDGenerator.xmlSafeID( d.nsPrefix + "." + mappedURI.substring( fragmentIndex + 1 ) )
        ( fragment, "org.omg." + fragment )

      case Some( d: SerializableDocument[Uml] ) =>
        ( s.xmiID.head, s.xmiUUID.head )
    }

  def lookupDocumentByScope( e: UMLElement[Uml] ): Option[Document[Uml]] =
    element2document.get( e ) match {
      case None      => None
      case Some( d ) => if ( d.scope == e ) Some( d ) else None
    }

  /**
   * @param valueSpecificationTagConverter By default, use: DocumentSet.serializeValueSpecificationAsTagValue[Uml] _
   */
  def serialize( implicit valueSpecificationTagConverter: ValueSpecificationTagConverter ): Try[Unit] = {

    g.nodes foreach {
      _.value match {
        case _: BuiltInDocument[Uml] => ()
        case d: SerializableDocument[Uml] =>
          serialize( d ) match {
            case Failure( t ) => return Failure( t )
            case Success( _ ) => ()
          }
      }
    }

    Success( Unit )
  }

  protected def foldTagValues(
    tagValues: Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]] )(
      tagValueAttribute: Try[scala.xml.MetaData],
      property: UMLProperty[Uml] )( implicit valueSpecificationTagConverter: ValueSpecificationTagConverter ): Try[scala.xml.MetaData] =
    tagValueAttribute match {
      case Failure( t ) => Failure( t )
      case Success( attribute ) =>
        tagValues.get( property ) match {
          case None =>
            Success( attribute )
          case Some( values ) =>
            val stringValues = values flatMap { v =>
              valueSpecificationTagConverter( v ) match {
                case Failure( t ) => return Failure( t )
                case Success( s ) => s
              }
            }

            if ( stringValues.isEmpty )
              Success( attribute )
            else
              Success(
                new scala.xml.UnprefixedAttribute(
                  key = property.name.get,
                  value = stringValues.mkString( " " ),
                  attribute ) )
        }
    }

  protected def serialize( d: SerializableDocument[Uml] )( implicit valueSpecificationTagConverter: ValueSpecificationTagConverter ): Try[Unit] =
    ds.documentURIMapper.resolveURI( d.uri, ds.documentURIMapper.saveResolutionStrategy ) match {
      case Failure( t ) => Failure( t )
      case Success( ruri ) =>
        import scala.xml._
        import DocumentSet._

        val uri = ruri.getOrElse(d.uri)
        val referencedProfiles = ( for {
          e <- d.extent
          ( s, p ) <- e.getAppliedStereotypes
          pf <- s.profile
          if ( element2document.contains( pf ) )
        } yield pf ) toSet

        val emptyScope: NamespaceBinding = null

        val profileScopes = ( emptyScope /: referencedProfiles ) {
          case ( scopes, referencedProfile ) =>
            ( referencedProfile.name, referencedProfile.getEffectiveURI ) match {
              case ( None, _ )                      => scopes
              case ( _, None )                      => scopes
              case ( Some( name ), Some( ns_uri ) ) => NamespaceBinding( name, ns_uri, scopes )
            }
        }

        val xmiScopes =
          NamespaceBinding( "xmi", XMI_ns,
            NamespaceBinding( "xsi", XSI_ns,
              NamespaceBinding( "uml", UML_ns,
                NamespaceBinding( "mofext", MOFEXT_ns, profileScopes ) ) ) )

        val elementOrdering = scala.collection.mutable.ArrayBuffer[UMLElement[Uml]]()

        val free: Free[Function0, Try[scala.xml.Node]] =
          generateNodeElement(
            elementOrdering,
            d, "uml", d.scope.xmiElementLabel,
            d.scope, xmiScopes )

        val result: Try[scala.xml.Node] =
          free.go( f => Comonad[Function0].copoint( f ) )( Applicative[Function0] )

        // alternatively:
        // val result = free.run

        result match {
          case Failure( t ) => return Failure( t )
          case Success( top ) =>

            /**
             * @issue: Canonical XMI B4 mofext:Tag
             */
            val mofTag = Elem(
              prefix = "mofext",
              label = "Tag",
              attributes =
                new PrefixedAttribute(
                  pre = "xmi", key = "id", value = d.scope.xmiID.head + "_mofext.Tag",
                  new PrefixedAttribute(
                    pre = "xmi", key = "uuid", value = d.scope.xmiUUID.head + "_mofext.Tag",
                    new PrefixedAttribute(
                      pre = "xmi", key = "type", value = "mofext:Tag",
                      d.scope match {
                        case ne: UMLNamedElement[Uml] =>
                          ne.name match {
                            case None =>
                              Null
                            case Some( name ) =>
                              new UnprefixedAttribute(
                                key = "name", value = "org.omg.xmi.nsPrefix",
                                new UnprefixedAttribute(
                                  key = "value", value = name,
                                  new UnprefixedAttribute(
                                    key = "element", value = d.scope.xmiID.head,
                                    Null ) ) )
                          }
                        case _ =>
                          Null
                      } ) ) ),
              scope = xmiScopes,
              minimizeEmpty = true )

            /**
             *
             */
            val stereotypeTagValues = elementOrdering.toList flatMap { e =>
              val allTagValues = e.stereotypeTagValues
              val appliedStereotypes = e.getAppliedStereotypes filter { case ( s, p ) => element2document.contains( s ) }
              val ordering = appliedStereotypes.toList.sortBy { case ( s, p ) => getStereptype_ID_UUID( s )._1 }
              val orderedTagValueElements = ordering map {
                case ( s, p ) =>
                  val ( sID, sUUID ) = getStereptype_ID_UUID( s )
                  val tagValueAttributes: scala.xml.MetaData = allTagValues.get( s ) match {
                    case None => Null
                    case Some( tagValues ) =>
                      val properties = tagValues.keys.toList.sortBy( _.xmiUUID.head )
                      val tagValueAttribute0: Try[MetaData] = Success( Null )
                      val tagValueAttributeN = ( tagValueAttribute0 /: properties.reverse )( foldTagValues( tagValues ) _ )
                      tagValueAttributeN match {
                        case Failure( t )                 => return Failure( t )
                        case Success( tagValueAttribute ) => tagValueAttribute
                      }
                  }
                  val xmiTagValueAttributes =
                    new PrefixedAttribute(
                      pre = "xmi", key = "id", value = e.xmiID.head + "-" + sID,
                      new PrefixedAttribute(
                        pre = "xmi", key = "uuid", value = e.xmiUUID.head + "-" + sUUID,
                        new UnprefixedAttribute(
                          key = p.name.get, value = e.xmiID.head,
                          tagValueAttributes ) ) )
                  Elem(
                    prefix = s.profile.get.name.get,
                    label = s.name.get,
                    attributes = xmiTagValueAttributes,
                    scope = xmiScopes,
                    minimizeEmpty = true )
              }
              orderedTagValueElements
            }

            val xmi = Elem(
              prefix = "xmi",
              label = "XMI",
              attributes = Null,
              scope = xmiScopes,
              minimizeEmpty = true,
              ( top :: mofTag :: stereotypeTagValues ): _* )
            val dir = ( new java.io.File( uri ) ).getParentFile
            dir.mkdirs()

            val filepath = uri.getPath + ".xmi"
            val xmlFile = new java.io.File( filepath )

            val xmlPrettyPrinter = new PrettyPrinter( width = 200, step = 2 )
            val xmlOutput = xmlPrettyPrinter.format( xmi )

            val bw = new PrintWriter( new FileWriter( xmlFile ) )
            bw.println( "<?xml version='1.0' encoding='UTF-8'?>" )
            bw.println( xmlOutput )
            bw.close()

            Success( Unit )
        }
    }

  @tailrec final protected def append1Node(
    nodes: Seq[scala.xml.Node],
    t: Trampoline[Try[scala.xml.Node]] ): Trampoline[Try[Seq[scala.xml.Node]]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/( s ) => append1Node( nodes, s() )
      case \/-( r ) => r match {
        case Failure( t ) => return_ { Failure( t ) }
        case Success( n ) => return_ { Success( nodes :+ n ) }
      }
    }
  }

  @tailrec final protected def appendNodes(
    t1: Trampoline[Try[Seq[scala.xml.Node]]],
    t2: Trampoline[Try[scala.xml.Node]] ): Trampoline[Try[Seq[scala.xml.Node]]] = {

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "appendNodes" ) == 1,
    //      "Verification that the trampolined recursive function 'appendNodes' runs stack-free" )

    t1.resume match {
      //case -\/( s )             => suspend { appendNodes( s(), t2 ) }
      case -\/( s )            => appendNodes( s(), t2 )
      case \/-( Failure( t ) ) => return_ { Failure( t ) }
      case \/-( Success( ns ) ) =>
        suspend {
          append1Node( ns, t2 )
        }
    }
  }

  @tailrec final protected def wrapNodes(
    t: Trampoline[Try[Seq[scala.xml.Node]]],
    prefix: String,
    label: String,
    xmlAttributesAndLocalReferences: scala.xml.MetaData,
    xmiScopes: scala.xml.NamespaceBinding ): Trampoline[Try[scala.xml.Node]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "wrapNodes" ) == 1,
    //      "Verification that the trampolined function 'wrapNodes' runs recursively stack-free" )

    t.resume match {
      //      case -\/( s ) =>
      //        suspend { wrapNodes( s(), prefix, label, xmlAttributesAndLocalReferences, xmiScopes ) }
      case -\/( s ) =>
        wrapNodes( s(), prefix, label, xmlAttributesAndLocalReferences, xmiScopes )
      case \/-( Failure( t ) ) =>
        return_ { Failure( t ) }
      case \/-( Success( nodes ) ) =>
        import scala.xml._
        val node = Elem(
          prefix = prefix,
          label = label,
          attributes = xmlAttributesAndLocalReferences,
          scope = xmiScopes,
          minimizeEmpty = true,
          nodes: _* )
        return_ { Success( node ) }
    }
  }

  protected def generateNodeElement(
    elementOrdering: scala.collection.mutable.ArrayBuffer[UMLElement[Uml]],
    d: SerializableDocument[Uml],
    prefix: String,
    label: String,
    e: UMLElement[Uml],
    xmiScopes: scala.xml.NamespaceBinding ): Trampoline[Try[scala.xml.Node]] = {

    elementOrdering += e

    import scala.xml._

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "generateNodeElement" ) == 1,
    //      s"Verification that the trampolined function 'wrapNodes' runs recursively stack-free for label=${label}, e=${e.xmiID}" )

    def foldAttribute( next: Try[MetaData], f: e.MetaAttributeFunction ): Try[MetaData] =
      ( next, f.evaluate( e ) ) match {
        case ( Failure( t ), _ ) =>
          Failure( t )
        case ( _, Failure( t ) ) =>
          Failure( t )
        case ( Success( n ), Success( values ) ) =>
          Success(
            ( n /: values ) {
              case ( _n, _value ) =>
                f.attributePrefix match {
                  case None =>
                    new UnprefixedAttribute( key = f.attributeName, value = _value, _n )
                  case Some( aPrefix ) =>
                    new PrefixedAttribute( pre = aPrefix, key = f.attributeName, value = _value, _n )
                }
            } )
      }

    def foldAttributeNode( nodes: Try[Seq[Node]], f: e.MetaAttributeFunction ): Try[Seq[Node]] =
      ( nodes, f.evaluate( e ) ) match {
        case ( Failure( t ), _ ) => Failure( t )
        case ( _, Failure( t ) ) => Failure( t )
        case ( Success( ns ), Success( values ) ) =>
          val valueNodes = for {
            value <- values
          } yield Elem( prefix = null, label = f.attributeName, attributes = Null, scope = xmiScopes, minimizeEmpty = true, Text( value ) )
          Success( ns ++ valueNodes )
      }

    def foldReference( nodes: Try[Seq[Node]], f: e.MetaPropertyEvaluator ): Try[Seq[Node]] =
      nodes match {
        case Failure( t ) => Failure( t )
        case Success( ns ) =>
          f match {
            case rf: e.MetaReferenceEvaluator =>
              rf.evaluate( e ) match {
                case Failure( t )    => Failure( t )
                case Success( None ) => Success( ns )
                case Success( Some( eRef ) ) =>
                  element2document.get( eRef ) match {
                    case None =>
                      System.out.println( s"*** foldReference: ref=${f.propertyName} -- no document for: ${eRef.id} (from ${e.xmiType.head} ${e.id})" )
                      Success( ns )
                    case Some( dRef ) =>
                      if ( d == dRef ) {
                        val idrefAttrib: MetaData = new PrefixedAttribute( pre="xmi", key = "idref", value = eRef.id, Null )
                        val idrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = idrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                        Success( ns :+ idrefNode )
                      }
                      else {
                        val href = dRef.uri + "#" + eRef.id
                        val externalHRef = dRef match {
                          case _: SerializableDocument[Uml] => href
                          case _: BuiltInDocument[Uml]      => ds.builtInURIMapper.resolve( href ).getOrElse( href )
                        }
                        val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = externalHRef, Null )
                        val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = hrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                        Success( ns :+ hrefNode )
                      }
                  }
              }

            case cf: e.MetaCollectionEvaluator =>
              cf.evaluate( e ) match {
                case Failure( t )   => Failure( t )
                case Success( Nil ) => Success( ns )
                case Success( eRefs ) =>
                  val hRefs = eRefs flatMap { eRef =>
                    element2document.get( eRef ) match {
                      case None =>
                        System.out.println( s"*** foldReference: collection=${f.propertyName} -- no document for: ${eRef.id} (from ${e.xmiType.head} ${e.id})" )
                        None
                      case Some( dRef ) =>
                        if ( d == dRef ) {
                          val idrefAttrib: MetaData = new PrefixedAttribute( pre="xmi", key = "idref", value = eRef.id, Null )
                          val idrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = idrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                          idrefNode
                        }
                        else {
                          val href = dRef.uri + "#" + eRef.id
                          val externalHRef = dRef match {
                            case _: SerializableDocument[Uml] => href
                            case _: BuiltInDocument[Uml]      => ds.builtInURIMapper.resolve( href ).getOrElse( href )
                          }
                          val typeAttrib: MetaData = new PrefixedAttribute( pre="xmi", key = "type", value = e.xmiType.head, Null )
                          val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = externalHRef, typeAttrib )
                          val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = hrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                          hrefNode
                        }
                    }
                  }
                  Success( ns ++ hRefs )
              }
          }
      }

    def callGenerateNodeElement(
      f: e.MetaPropertyEvaluator,
      sub: UMLElement[Uml] ): Trampoline[Try[scala.xml.Node]] =
      generateNodeElement( elementOrdering, d, null, f.propertyName, sub, xmiScopes )

    @tailrec def trampolineSubNode(
      nodes: Trampoline[Try[Seq[Node]]],
      f: e.MetaPropertyEvaluator ): Trampoline[Try[Seq[scala.xml.Node]]] = {

      nodes.resume match {
        //        case -\/( s ) =>
        //          suspend { trampolineSubNode( s(), f ) }
        case -\/( s ) =>
          trampolineSubNode( s(), f )

        case \/-( r ) =>
          r match {
            case Failure( t ) =>
              return_ { Failure( t ) }

            case Success( ns ) =>
              f match {
                case rf: e.MetaReferenceEvaluator =>
                  rf.evaluate( e ) match {
                    case Failure( t )    => return_ { Failure( t ) }
                    case Success( None ) => return_ { Success( ns ) }
                    case Success( Some( sub ) ) =>
                      suspend {
                        append1Node( ns, callGenerateNodeElement( f, sub ) )
                      }
                  }
                case cf: e.MetaCollectionEvaluator =>
                  cf.evaluate( e ) match {
                    case Failure( t )   => return_ { Failure( t ) }
                    case Success( Nil ) => return_ { Success( ns ) }
                    case Success( subs ) =>
                      suspend {
                        val sortedSubs: List[UMLElement[Uml]] = subs.sortBy( _.xmiOrderingKey )
                        val subNodes = for { sub <- sortedSubs }
                          yield callGenerateNodeElement( f, sub )

                        val result0: Trampoline[Try[Seq[scala.xml.Node]]] = return_ { Success( ns ) }
                        val resultN = ( result0 /: subNodes )( appendNodes _ )
                        resultN
                      }
                  }
              }
          }
      }
    }

    val refEvaluators: Seq[e.MetaPropertyEvaluator] = e.referenceMetaProperties
    val subEvaluators: Seq[e.MetaPropertyEvaluator] = e.compositeMetaProperties
    val duplicates = refEvaluators.toSet.intersect( subEvaluators.toSet )
    require( duplicates.isEmpty, s"${e.xmiType} ${duplicates.size}: ${duplicates}" )

    val mofAttributes0: Try[MetaData] = Success( Null )
    ( mofAttributes0 /: e.mofXMI_metaAtttributes.reverse )( foldAttribute _ ) match {
      case Failure( t ) =>
        return_ { Failure( t ) }

      case Success( mofAttributesN ) =>
        suspend {
          val xRef0: Try[Seq[Node]] = Success( Seq() )
          val xRefA = ( xRef0 /: e.metaAttributes )( foldAttributeNode _ )
          val xRefs = ( xRefA /: refEvaluators )( foldReference _ )
          val xRefsAndSub0: Trampoline[Try[Seq[Node]]] = return_ { xRefs }
          val xRefsAndSubN = ( xRefsAndSub0 /: subEvaluators )( trampolineSubNode _ )
          wrapNodes( xRefsAndSubN, prefix, label, mofAttributesN, xmiScopes )
        }
    }
  }
}
