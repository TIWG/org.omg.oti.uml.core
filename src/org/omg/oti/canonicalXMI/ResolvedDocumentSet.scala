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

import scala.annotation.tailrec
import scala.language.higherKinds
import scala.language.implicitConversions
import scala.language.postfixOps
import org.omg.oti._
import org.omg.oti.api._
import scala.util.Try
import scala.util.Failure
import scala.util.Success
import scalax.collection.GraphPredef._
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.PrintWriter

import scalaz._, Scalaz._, Free._

case class ResolvedDocumentSet[Uml <: UML](
   ds: DocumentSet[Uml],
   g: DocumentSet[Uml]#MutableDocumentSetGraph,
   element2document: Map[UMLElement[Uml], Document[Uml]],
   unresolvedElementMapper: UMLElement[Uml] => Option[UMLElement[Uml]] ) {

  type ValueSpecificationTagConverter = Function1[UMLValueSpecification[Uml], Try[Option[String]]]

  def element2mappedDocument( e: UMLElement[Uml] ): Option[Document[Uml]] =
    element2document.get( e ) match {
      case Some( d ) => Some( d )
      case None => unresolvedElementMapper( e ) match {
        case Some( em ) => element2document.get( em )
        case None       => None
      }
    }

  def getStereotype_ID_UUID( s: UMLStereotype[Uml] ): ( String, String ) =
    element2mappedDocument( s ) match {
      case None =>
        throw new IllegalArgumentException( s"There should be a document for stereotype ${s.qualifiedName.get} (ID=${s.id})" )

      case Some( d: BuiltInDocument[Uml] ) =>
        val builtInURI = d.documentURL.resolve( "#"+s.id ).toString
        val mappedURI = ds.builtInURIMapper.resolve( builtInURI ).getOrElse( builtInURI )
        val fragmentIndex = mappedURI.lastIndexOf( '#' )
        require( fragmentIndex > 0 )
        val fragment = IDGenerator.xmlSafeID( /* d.nsPrefix+"."+*/ mappedURI.substring( fragmentIndex + 1 ) )
        ( fragment, IDGenerator.uuidFromId( fragment ) )

      case Some( d: SerializableDocument[Uml] ) =>
        ( s.xmiID.head, s.xmiUUID.head )
    }

  def lookupDocumentByScope( e: UMLElement[Uml] ): Option[Document[Uml]] =
    element2mappedDocument( e ) match {
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

  def serializePkg( pkg: UMLPackage[Uml] )( implicit valueSpecificationTagConverter: ValueSpecificationTagConverter ): Try[Unit] = {

    val doc = ds.serializableDocuments find { _.scope == pkg }

    doc match {
      case Some( d ) =>
        serialize( d ) match {
          case Failure( t ) => return Failure( t )
          case Success( _ ) => ()
        }

      case None =>
        Failure( new IllegalArgumentException( s"/!\ Serialization failed: no document found for ${pkg.qualifiedName.get}" ) )
    }
    Success( Unit )
  }

  import scala.xml._

  protected def foldTagValues(
    tagValues: Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]],
    xmiScopes: scala.xml.NamespaceBinding )(
      tagValueAttribute: Try[List[scala.xml.Elem]],
      property: UMLProperty[Uml] )( implicit valueSpecificationTagConverter: ValueSpecificationTagConverter ): Try[List[scala.xml.Elem]] =
    tagValueAttribute match {
      case Failure( t ) => Failure( t )
      case Success( attributes ) =>
        tagValues.get( property ) match {
          case None =>
            Success( attributes )
          case Some( values ) =>
            val valueTable: Seq[( Option[String], Boolean )] = for {
              v <- values
            } yield valueSpecificationTagConverter( v ) match {
              case Failure( t ) => return Failure( t )
              case Success( None ) => v.serializeAsRef match {
                case Success( s ) => ( s, true )
                case Failure( t ) => return Failure( t )
              }
              case Success( s ) => ( s, false )
            }

            Success( ( attributes /: valueTable ) {
              case ( xs, ( Some( strValue ), false ) ) =>
                scala.xml.Elem(
                  prefix = null,
                  label = property.name.get,
                  attributes = scala.xml.Null,
                  scope = xmiScopes,
                  minimizeEmpty = true,
                  scala.xml.Text( strValue ) ) ::
                  xs

              case ( xs, ( Some( idRef ), true ) ) =>
                val idrefAttrib: MetaData = new PrefixedAttribute( pre = "xmi", key = "idref", value = idRef, Null )
                scala.xml.Elem(
                  prefix = null,
                  label = property.name.get,
                  attributes = idrefAttrib,
                  scope = xmiScopes,
                  minimizeEmpty = true ) ::
                  xs

              case ( xs, ( None, _ ) ) =>
                xs
            } )
        }
    }

  protected def serialize( d: SerializableDocument[Uml] )( implicit valueSpecificationTagConverter: ValueSpecificationTagConverter ): Try[Unit] =
    ds.documentURIMapper.resolveURI( d.uri, ds.documentURIMapper.saveResolutionStrategy ) match {
      case Failure( t ) => Failure( t )
      case Success( ruri ) =>
        import scala.xml._
        import DocumentSet._

        val uri = ruri.getOrElse( d.uri )
        Try(new java.io.File( uri )) match {
          case Failure(f) => Failure(new IllegalArgumentException(s"Cannot serialize document ${d.uri} mapped for save to $ruri: ${f.getMessage}", f))
          case Success(furi) =>
            val dir = furi.getParentFile
            dir.mkdirs()

            val referencedProfiles = for {
              e <- d.extent
              ( s, p ) <- e.getAppliedStereotypes
              pf <- s.profile
              if element2document.contains( pf )
            } yield pf

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
              case Failure(t) =>
                Failure(t)

              case Success(top) =>

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
                                case Some(name) =>
                                  new UnprefixedAttribute(
                                    key = "name", value = "org.omg.xmi.nsPrefix",
                                    new UnprefixedAttribute(
                                      key = "value", value = name,
                                      new UnprefixedAttribute(
                                        key = "element", value = d.scope.xmiID.head,
                                        Null)))
                              }
                            case _ =>
                              Null
                          }))),
                  scope = xmiScopes,
                  minimizeEmpty = true)

                /**
                 *
                 */
                val stereotypeTagValues = elementOrdering.toList flatMap { e =>
                  val allTagValues = e.stereotypeTagValues
                  val appliedStereotypes = e.getAppliedStereotypesWithoutMetaclassProperties filter element2document.contains toList
                  val ordering = appliedStereotypes.sortBy(getStereotype_ID_UUID(_)._1)
                  val orderedTagValueElements = ordering map {
                    case s =>
                      val (sID, _) = getStereotype_ID_UUID(s)
                      val tagValueAttributes: List[Elem] =
                        allTagValues.get(s) match {
                          case None => Nil
                          case Some(tagValues) =>
                            val properties = tagValues.keys.toList.sortWith(_.xmiUUID.head > _.xmiUUID.head)
                            val tagValueAttribute0: Try[List[Elem]] = Success(Nil)
                            val tagValueAttributeN = (tagValueAttribute0 /: properties)(foldTagValues(tagValues, xmiScopes))
                            tagValueAttributeN match {
                              case Failure(t) => return Failure(t)
                              case Success(tagValueAttribute) => tagValueAttribute
                            }
                        }
                      val stAppID = IDGenerator.computeStereotypeApplicationID(e.xmiID.head, sID)
                      val stAppUUID = IDGenerator.uuidFromId(stAppID)
                      val xmiTagValueAttributes =
                        new PrefixedAttribute(
                          pre = "xmi", key = "id", value = stAppID,
                          new PrefixedAttribute(
                            pre = "xmi", key = "uuid", value = stAppUUID,
                            new PrefixedAttribute(
                              pre = "xmi", key = "type", value = s.profile.get.name.get + ":" + s.name.get,
                              Null)))
                      Elem(
                        prefix = s.profile.get.name.get,
                        label = s.name.get,
                        attributes = xmiTagValueAttributes,
                        scope = xmiScopes,
                        minimizeEmpty = true,
                        tagValueAttributes: _*)
                  }
                  orderedTagValueElements
                }

                val xmi = Elem(
                  prefix = "xmi",
                  label = "XMI",
                  attributes = Null,
                  scope = xmiScopes,
                  minimizeEmpty = true,
                  top :: mofTag :: stereotypeTagValues: _*)

                val filepath = uri.getPath + ".xmi"
                val xmlFile = new java.io.File(filepath)
                System.out.println(s"### File: $filepath")
                val xmlPrettyPrinter = new PrettyPrinter(width = 300, step = 2)
                val xmlOutput = xmlPrettyPrinter.format(xmi)

                //            val bw = new PrintWriter( new FileWriter( xmlFile ) )
                val bw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(xmlFile), "UTF-8"))
                bw.println("<?xml version='1.0' encoding='UTF-8'?>")
                bw.println(xmlOutput)
                bw.close()

                Success(Unit)
            }
        }
    }


  type MetaPropertyFunctionSet = Set[_ <: MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]]
  type UMLElementSet = Set[UMLElement[Uml]]
  import scala.xml.NodeSeq
  type SerializationState = ( UMLElementSet, NodeSeq, MetaPropertyFunctionSet )

  @tailrec final protected def append1Pair(
    sub: UMLElement[Uml],
    t: Trampoline[Try[scala.xml.Node]],
    subElements: Set[UMLElement[Uml]],
    nodes: Seq[scala.xml.Node],
                                            redefinitions: MetaPropertyFunctionSet): Trampoline[Try[SerializationState]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/( s ) => append1Pair( sub, s(), subElements, nodes, redefinitions )
      case \/-( r ) => r match {
        case Failure( f ) => return_ { Failure( f ) }
        case Success( n ) => return_ { Success( ( subElements + sub, nodes :+ n, redefinitions ) ) }
      }
    }
  }

  @tailrec final protected def append1Node(
    nodes: NodeSeq,
    t: Trampoline[Try[scala.xml.Node]] ): Trampoline[Try[NodeSeq]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/( s ) => append1Node( nodes, s() )
      case \/-( r ) => r match {
        case Failure( f ) => return_ { Failure( f ) }
        case Success( n ) => return_ { Success( nodes :+ n ) }
      }
    }
  }

  @tailrec final protected def appendNodes(
    t1: Trampoline[Try[NodeSeq]],
    t2: Trampoline[Try[scala.xml.Node]] ): Trampoline[Try[NodeSeq]] = {

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "appendNodes" ) == 1,
    //      "Verification that the trampolined recursive function 'appendNodes' runs stack-free" )

    t1.resume match {
      //case -\/( s )             => suspend { appendNodes( s(), t2 ) }
      case -\/( s )            => appendNodes( s(), t2 )
      case \/-( Failure( f ) ) => return_ { Failure( f ) }
      case \/-( Success( ns ) ) =>
        suspend {
          append1Node( ns, t2 )
        }
    }
  }

  @tailrec final protected def wrapNodes(
                                          xRefs: Try[NodeSeq],
    t: Trampoline[Try[SerializationState]],
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
        wrapNodes( xRefs, s(), prefix, label, xmlAttributesAndLocalReferences, xmiScopes )
      case \/-( Failure( f ) ) =>
        return_ { Failure( f ) }
      case \/-( Success( ( _, nodes, _ ) ) ) =>
        xRefs match {
          case Failure(f) =>
            return_ {
              Failure(f)
            }
          case Success(pre_nodes) =>
            import scala.xml._
            val node = Elem(
              prefix = prefix,
              label = label,
              attributes = xmlAttributesAndLocalReferences,
              scope = xmiScopes,
              minimizeEmpty = true,
              pre_nodes ++ nodes.reverse: _*)
            return_ { Success(node) }
        }
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

    def foldAttributeNode( nodes: Try[NodeSeq], f: e.MetaAttributeFunction ): Try[NodeSeq] =
      ( nodes, f.evaluate( e ) ) match {
        case ( Failure( t ), _ ) => Failure( t )
        case ( _, Failure( t ) ) => Failure( t )
        case ( Success( ns ), Success( values ) ) =>
          val valueNodes = for {
            value <- values
          } yield Elem( prefix = null, label = f.attributeName, attributes = Null, scope = xmiScopes, minimizeEmpty = true, Text( value ) )
          Success( ns ++ valueNodes )
      }

    /**
     * Add xmi:type for an href element reference -- this is an exception to Canonical XMI ptc13-08-28; B2, #6:
     * xmi:type is always present except where the element is a reference (using xmi:idref or href)
     * when it is never present [as of XMI 2.4 this is standard XMI].
     *
     */
    def foldReference( nodes: Try[NodeSeq], f: e.MetaPropertyEvaluator ): Try[NodeSeq] =
      nodes match {
        case Failure( t ) => Failure( t )
        case Success( ns ) =>
          f match {
            case rf: e.MetaReferenceEvaluator =>
              rf.evaluate( e ) match {
                case Failure( t )    => Failure( t )
                case Success( None ) => Success( ns )
                case Success( Some( eRef ) ) =>
                  element2mappedDocument( eRef ) match {
                    case None =>
                      System.out.println( s"*** foldReference: ref=${f.propertyName} -- no document for: ${eRef.id} (from ${e.xmiType.head} ${e.id})" )
                      Success( ns )
                    case Some( dRef ) =>
                      if ( d == dRef ) {
                        val idrefAttrib: MetaData = new PrefixedAttribute( pre = "xmi", key = "idref", value = eRef.id, Null )
                        val idrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = idrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                        Success( ns :+ idrefNode )
                      } else {
                        val href = dRef.documentURL+"#"+eRef.id
                        val externalHRef = dRef match {
                          case _: SerializableDocument[Uml] => href
                          case _: BuiltInDocument[Uml]      => ds.builtInURIMapper.resolve( href ).getOrElse( href )
                        }
                        val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = externalHRef, Null )
                        val typeAttrib: MetaData = new PrefixedAttribute( pre = "xmi", key = "type", value = eRef.xmiType.head, hrefAttrib )
                        val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = typeAttrib, scope = xmiScopes, minimizeEmpty = true )
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
                    require( eRef.id.isDefined )
                    element2mappedDocument( eRef ) match {
                      case None =>
                        System.out.println( s"*** foldReference: collection=${f.propertyName} -- no document for: ${eRef.id} (from ${e.xmiType.head} ${e.id})" )
                        None
                      case Some( dRef ) =>
                        if ( d == dRef ) {
                          val idrefAttrib: MetaData = new PrefixedAttribute( pre = "xmi", key = "idref", value = eRef.id, Null )
                          val idrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = idrefAttrib, scope = xmiScopes, minimizeEmpty = true )
                          idrefNode
                        } else {
                          val href = dRef.uri+"#"+eRef.id
                          val externalHRef = dRef match {
                            case _: SerializableDocument[Uml] => href
                            case _: BuiltInDocument[Uml]      => ds.builtInURIMapper.resolve( href ).getOrElse( href )
                          }
                          val hrefAttrib: MetaData = new UnprefixedAttribute( key = "href", value = externalHRef, Null )
                          val typeAttrib: MetaData = new PrefixedAttribute( pre = "xmi", key = "type", value = eRef.xmiType.head, hrefAttrib )
                          val hrefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = typeAttrib, scope = xmiScopes, minimizeEmpty = true )
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

    def callGenerateNodeReference(
      f: e.MetaPropertyEvaluator,
      sub: UMLElement[Uml] ): Trampoline[Try[scala.xml.Node]] = {
      val idRefAttrib: MetaData = new PrefixedAttribute( pre = "xmi", key = "idref", value = sub.id, Null )
      val idRefNode: Node = Elem( prefix = null, label = f.propertyName, attributes = idRefAttrib, scope = xmiScopes, minimizeEmpty = true )
      return_ { Success( idRefNode ) }
    }

    def applyGenerateNodeElementsOrReferences(
                                               f: e.MetaPropertyEvaluator,
                                               subs: List[UMLElement[Uml]],
                                               subElements: Set[UMLElement[Uml]],
                                               nodes: NodeSeq,
                                               redefined: MetaPropertyFunctionSet): Trampoline[Try[SerializationState]] =
      subs match {
        case Nil => return_ { Success( subElements, nodes, redefined ) }
        case x :: xs =>
          for {
            node <- if ( subElements.contains( x ) )
              append1Pair( x, callGenerateNodeReference( f, x ), subElements, nodes, redefined )
            else
              append1Pair( x, callGenerateNodeElement( f, x ), subElements, nodes, redefined )
            result <- node match {
              case Failure( t )          => return return_ { Failure( t ) }
              case Success( ( es, ns, rs ) ) => applyGenerateNodeElementsOrReferences( f, xs, es, ns, rs )
            }
          } yield result
      }


    def applyGenerateNodeElementsOrSkip(
                                         f: e.MetaPropertyEvaluator,
                                         subs: List[UMLElement[Uml]],
                                         subElements: Set[UMLElement[Uml]],
                                         nodes: NodeSeq,
                                         redefined: MetaPropertyFunctionSet ): Trampoline[Try[SerializationState]] =
      subs match {
        case Nil => return_ { Success( subElements, nodes, redefined ) }
        case x :: xs =>
          for {
            node <- if ( subElements.contains( x ) )
              return return_ { Success( subElements, nodes, redefined ) }
            else
              append1Pair( x, callGenerateNodeElement( f, x ), subElements, nodes, redefined )
            result <- node match {
              case Failure( t )          => return return_ { Failure( t ) }
              case Success( ( es, ns, rs ) ) => applyGenerateNodeElementsOrSkip( f, xs, es, ns, rs )
            }
          } yield result
      }

    /**
     * @see XMI2.5 ptc/14-09-21 9.4.1
     * Instance of Model Element:
     * A Property, type is not a PrimitiveType or Enumeration, isComposite = true
     *
     * XMI Representation:
     * Choice of:
     * 1. Nested XMIObjectElement
     * 2. Nested XMIReferenceElement
     * 2. Nested XMIReferenceAttribute
     * Normally, serialized properties with isComposite = true are serialized as nested XMIObjectElements.
     * In the case where the model is split across more than one file then
     * a nested XMIReferenceElement would be used.
     * Exceptionally, even within one file, it may be the case that
     * a containing object has more than one serialized class-typed property with isComposite = true that
     * contain the same object or include it among their collection of objects.
     * In such an exceptional case, because of MOF constraints,
     * only one of those properties can have an opposite with a non-empty slot.
     * Objects of the property with the non-empty opposite slot are serialized as nested XMIObjectElements,
     * and the other references to the same object are serialized either
     * as XMIReferenceAttributes or nested XMIReferenceElements.
     *
     * @see XMI2.5 ptc/14-09-21 9.4.2
     * No special serialization rules need to be defined for subsetted Properties.
     * Following EMOF rule 1, when one of the subsetted or subsetting Properties is derived,
     * it is not serialized by default. Properties that are not derived are serialized.
     */
    @tailrec def trampolineSubNode(
                                    nodes: Trampoline[Try[SerializationState]],
                                    f: e.MetaPropertyEvaluator ): Trampoline[Try[SerializationState]] = {

      nodes.resume match {
        //        case -\/( s ) =>
        //          suspend { trampolineSubNode( s(), f ) }
        case -\/( s ) =>
          trampolineSubNode( s(), f )

        case \/-( r ) =>
          r match {
            case Failure( t ) =>
              return_ { Failure( t ) }

            case Success( ( subElements, ns, redefined ) ) =>
              f match {
                case rf: e.MetaReferenceEvaluator =>
                  rf.evaluate( e ) match {
                    case Failure( t )    => return_ { Failure( t ) }
                    case Success( None ) => return_ { Success( ( subElements, ns, redefined ) ) }
                    case Success( Some( sub ) ) =>
                      if ( subElements.contains( sub ) )
                        return_ { Success( ( subElements, ns, f.redefinedMetaProperties ++ redefined ) ) }
                      else
                        suspend { append1Pair( sub, callGenerateNodeElement( f, sub ), subElements, ns, redefined ) }
                  }
                case cf: e.MetaCollectionEvaluator =>
                  cf.evaluate( e ) match {
                    case Failure( t )   => return_ { Failure( t ) }
                    case Success( Nil ) => return_ { Success( ( subElements, ns, redefined ) ) }
                    case Success( subs ) =>
                      suspend { applyGenerateNodeElementsOrReferences( f, subs, subElements, ns, redefined ) }
                  }
              }
          }
      }
    }

    val refEvaluators: Seq[e.MetaPropertyEvaluator] = e.referenceMetaProperties
    val subEvaluators: Seq[e.MetaPropertyEvaluator] = e.compositeMetaProperties
    val duplicates = refEvaluators.toSet.intersect( subEvaluators.toSet )
    require( duplicates.isEmpty, s"${e.xmiType} ${duplicates.size}: $duplicates" )

    val mofAttributes0: Try[MetaData] = Success( Null )
    ( mofAttributes0 /: e.mofXMI_metaAtttributes.reverse )( foldAttribute ) match {
      case Failure( t ) =>
        return_ { Failure( t ) }

      case Success( mofAttributesN ) =>
        suspend {
          val xRef0: Try[NodeSeq] = Success( Seq() )
          val xRefA = ( xRef0 /: e.metaAttributes )( foldAttributeNode )
          val xRefs = ( xRefA /: refEvaluators )( foldReference )

          // TODO TIWG-25
          // @see http://solitaire.omg.org/secure/EditComment!default.jspa?id=37483&commentId=12422
          // Per Canonical XMI B5.2 Property Elements
          // Issue 17261: clarify the ordering
          // Properties of an element are ordered by the class in which they are defined.
          // Properties defined by a superclass appear before those of its subclasses.
          // Where a class inherits from more than one direct superclass, properties
          // from the class with the alphabetically earlier class name appear
          // before those of an alphabetically later class name.
          // This means traverse the subEvaluators in reverse order (to ensure that the most-specific
          // composite meta-property is the 1st serialization of an object as a nested element)
          // but serialize the objects in order.

          val xSub0: Trampoline[Try[SerializationState]] = return_( Success( ( Set(), Seq(), Set() ) ) )
          val xRefsAndSubN = ( xSub0 /: subEvaluators.reverse )( trampolineSubNode )

          wrapNodes( xRefs, xRefsAndSubN, prefix, label, mofAttributesN, xmiScopes )
        }
    }
  }
}
