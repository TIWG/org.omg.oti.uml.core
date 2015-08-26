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
package org.omg.oti.uml.canonicalXMI

import java.io.{FileOutputStream, OutputStreamWriter, PrintWriter}

import org.omg.oti.uml._
import org.omg.oti.uml.read.UMLStereotypeTagValue
import org.omg.oti.uml.read.api._

import scala.annotation.tailrec
import scala.collection.immutable.SortedMap
import scala.language.{higherKinds, implicitConversions, postfixOps}
import scala.util.{Failure, Success, Try}
import scalaz.Free._
import scalaz.Scalaz._
import scalaz._

case class ResolvedDocumentSet[Uml <: UML](
                                            ds: DocumentSet[Uml],
                                            g: DocumentSet[Uml]#MutableDocumentSetGraph,
                                            element2document: Map[UMLElement[Uml], Document[Uml]],
                                            unresolvedElementMapper: UMLElement[Uml] => Option[UMLElement[Uml]]) {

  def element2mappedDocument(e: UMLElement[Uml]): Option[Document[Uml]] =
    element2document.get(e) match {
      case Some(d) => Some(d)
      case None => unresolvedElementMapper(e) match {
        case Some(em) => element2document.get(em)
        case None => None
      }
    }

  def getStereotype_ID_UUID(s: UMLStereotype[Uml]): (String, String) =
    element2mappedDocument(s) match {
      case None =>
        throw new IllegalArgumentException(
          s"There should be a document for stereotype ${s.qualifiedName.get} (ID=${s.xmiID.head})")

      case Some(d: BuiltInDocument[Uml]) =>
        val builtInURI = d.documentURL.resolve("#" + s.xmiID.head).toString
        val mappedURI = ds.builtInURIMapper.resolve(builtInURI).getOrElse(builtInURI)
        val fragmentIndex = mappedURI.lastIndexOf('#')
        require(fragmentIndex > 0)
        val fragment = IDGenerator.xmlSafeID(mappedURI.substring(fragmentIndex + 1))
        Tuple2(fragment, "omg.org." + d.nsPrefix.toLowerCase(java.util.Locale.ROOT) + fragment)

      case Some(d: SerializableDocument[Uml]) =>
        Tuple2(s.xmiID.head, s.xmiUUID.head)
    }

  def lookupDocumentByScope(e: UMLElement[Uml]): Option[Document[Uml]] =
    element2mappedDocument(e) match {
      case None => None
      case Some(d) => if (d.scope == e) Some(d) else None
    }

  def serialize: Try[Unit] = {

    g.nodes foreach {
      _.value match {
        case _: BuiltInDocument[Uml] => ()
        case d: SerializableDocument[Uml] =>
          serialize(d) match {
            case Failure(t) => return Failure(t)
            case Success(_) => ()
          }
      }
    }

    Success(Unit)
  }

  def serializePkg
  (pkg: UMLPackage[Uml])
  : Try[Unit] = {

    val doc = ds.serializableDocuments find {
      _.scope == pkg
    }

    doc match {
      case Some(d) =>
        serialize(d) match {
          case Failure(t) => return Failure(t)
          case Success(_) => ()
        }

      case None =>
        Failure(new IllegalArgumentException(
          s"Serialization failed: no document found for ${pkg.qualifiedName.get}"))
    }
    Success(Unit)
  }

  protected def foldTagValues
  (xmiScopes: scala.xml.NamespaceBinding)
  (tagValueNodes: Try[List[scala.xml.Elem]],
   stereotypeTagValue: UMLStereotypeTagValue[Uml])
  : Try[List[scala.xml.Elem]] =
    stereotypeTagValue.serialize(xmiScopes) match {
      case Failure(f) =>
        Failure(f)
      case Success(values) =>
        (tagValueNodes /: values) {
          case (Failure(f), _) =>
            Failure(f)
          case (Success(nodes), value) =>
            Success(nodes ++ values)
        }
    }

  protected def serialize
  (d: SerializableDocument[Uml])
  : Try[Unit] =
    ds.documentURIMapper.resolveURI(d.uri, ds.documentURIMapper.saveResolutionStrategy) match {
      case Failure(t) => Failure(t)
      case Success(ruri) =>
        import DocumentSet._

        import scala.xml._

        val uri = ruri.getOrElse(d.uri)
        Try(new java.io.File(uri)) match {
          case Failure(f) => Failure(new IllegalArgumentException(
            s"Cannot serialize document ${d.uri} mapped for save to $ruri: ${f.getMessage}", f))
          case Success(furi) =>
            val dir = furi.getParentFile
            dir.mkdirs()

            val referencedProfiles = for {
              e <- d.extent
              tagValue <- e.tagValues
              pf <- tagValue.appliedStereotype.profile
              if element2document.contains(pf)
            } yield pf

            val emptyScope: NamespaceBinding = null

            val profileScopes = (emptyScope /: referencedProfiles.toList.sortBy(_.qualifiedName.get)) {
              case (scopes, referencedProfile) =>
                (referencedProfile.name, referencedProfile.getEffectiveURI) match {
                  case (None, _) =>
                    scopes
                  case (_, None) =>
                    scopes
                  case (Some(name), Some(ns_uri)) =>
                    NamespaceBinding(name, ns_uri, scopes)
                }
            }

            val xmiScopes =
              NamespaceBinding("xmi", XMI_ns,
                NamespaceBinding("xsi", XSI_ns,
                  NamespaceBinding("uml", UML_ns,
                    NamespaceBinding("mofext", MOFEXT_ns, profileScopes))))

            val elementOrdering = scala.collection.mutable.ArrayBuffer[UMLElement[Uml]]()

            val free: Free[Function0, Try[scala.xml.Node]] =
              generateNodeElement(
                elementOrdering,
                d, "uml", d.scope.xmiElementLabel,
                d.scope, xmiScopes)

            val result: Try[scala.xml.Node] =
              free.go(f => Comonad[Function0].copoint(f))(Applicative[Function0])

            // alternatively:
            // val result = free.run

            result match {
              case Failure(t) =>
                Failure(t)

              case Success(top) =>
                val mofTagRef: MetaData =
                  new PrefixedAttribute(pre = "xmi", key = "idref", value = d.scope.xmiID.head, Null)
                val mofTagElement: Node =
                  Elem(
                    prefix = null, label = "element", attributes = mofTagRef,
                    scope = xmiScopes, minimizeEmpty = true)
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
                                      Null))
                              }
                            case _ =>
                              Null
                          }))),
                  scope = xmiScopes,
                  minimizeEmpty = true,
                  mofTagElement)

                val stereotypeTagValues: List[Node] = elementOrdering.toList flatMap { e =>

                  val allTagValuesByStereotype: Map[UMLStereotype[Uml], Seq[UMLStereotypeTagValue[Uml]]] =
                    e.tagValues.groupBy(_.appliedStereotype)

                  val appliedStereotypes: Set[UMLStereotype[Uml]] =
                    e.tagValues.map(_.appliedStereotype).toSet filter element2document.contains

                  val ordering: List[UMLStereotype[Uml]] =
                    appliedStereotypes.toList.sortBy(getStereotype_ID_UUID(_)._1)

                  val orderedTagValueElements: List[Node] = ordering map {
                    case s =>
                      val (sID, _) = getStereotype_ID_UUID(s)
                      val tagValueAttributes: List[Elem] =
                        allTagValuesByStereotype.get(s) match {
                          case None => Nil
                          case Some(vs) =>
                            val tagValueAttribute0: Try[List[Elem]] = Success(Nil)
                            val tagValueAttributeN = (tagValueAttribute0 /: vs)(foldTagValues(xmiScopes))
                            tagValueAttributeN match {
                              case Failure(t) =>
                                return Failure(t)
                              case Success(tagValueAttribute) =>
                                tagValueAttribute
                            }
                        }
                      val stAppID = IDGenerator.computeStereotypeApplicationID(e.xmiID.head, sID)
                      val stAppUUID = IDGenerator.computeStereotypeApplicationID(e.xmiUUID.head, sID)
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

  type SerializationState = (UMLElementSet, NodeSeq, MetaPropertyFunctionSet)

  @tailrec final protected def append1Pair
  (sub: UMLElement[Uml],
   t: Trampoline[Try[scala.xml.Node]],
   subElements: Set[UMLElement[Uml]],
   nodes: Seq[scala.xml.Node],
   redefinitions: MetaPropertyFunctionSet)
  : Trampoline[Try[SerializationState]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/(s) => append1Pair(sub, s(), subElements, nodes, redefinitions)
      case \/-(r) => r match {
        case Failure(f) => return_ {
          Failure(f)
        }
        case Success(n) => return_ {
          Success((subElements + sub, nodes :+ n, redefinitions))
        }
      }
    }
  }

  @tailrec final protected def prependNestedElement
  (sub: UMLElement[Uml],
   t: Trampoline[Try[scala.xml.Node]],
   subElements: Set[UMLElement[Uml]],
   nodes: Seq[scala.xml.Node],
   redefinitions: MetaPropertyFunctionSet)
  : Trampoline[Try[SerializationState]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/(s) => prependNestedElement(sub, s(), subElements, nodes, redefinitions)
      case \/-(r) => r match {
        case Failure(f) => return_ {
          Failure(f)
        }
        case Success(n) => return_ {
          Success((subElements + sub, n +: nodes, redefinitions))
        }
      }
    }
  }


  @tailrec final protected def append1Node(
                                            nodes: NodeSeq,
                                            t: Trampoline[Try[scala.xml.Node]]): Trampoline[Try[NodeSeq]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "append1Node" ) == 1,
    //      "Verification that the trampolined recursive function 'append1Node' runs stack-free" )

    t.resume match {
      //case -\/( s ) => suspend { append1Node( nodes, s() ) }
      case -\/(s) => append1Node(nodes, s())
      case \/-(r) => r match {
        case Failure(f) => return_ {
          Failure(f)
        }
        case Success(n) => return_ {
          Success(nodes :+ n)
        }
      }
    }
  }

  @tailrec final protected def appendNodes(
                                            t1: Trampoline[Try[NodeSeq]],
                                            t2: Trampoline[Try[scala.xml.Node]]): Trampoline[Try[NodeSeq]] = {

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "appendNodes" ) == 1,
    //      "Verification that the trampolined recursive function 'appendNodes' runs stack-free" )

    t1.resume match {
      //case -\/( s )             => suspend { appendNodes( s(), t2 ) }
      case -\/(s) => appendNodes(s(), t2)
      case \/-(Failure(f)) => return_ {
        Failure(f)
      }
      case \/-(Success(ns)) =>
        suspend {
          append1Node(ns, t2)
        }
    }
  }

  @tailrec final protected def wrapNodes
  (xRefAttrs: Try[NodeSeq],
   t: Trampoline[Try[SerializationState]],
   xRefRefs: Try[NodeSeq],
   prefix: String,
   label: String,
   xmlAttributesAndLocalReferences: scala.xml.MetaData,
   xmiScopes: scala.xml.NamespaceBinding)
  : Trampoline[Try[scala.xml.Node]] = {

    //    assert( Thread.currentThread().getStackTrace.count( _.getMethodName == "wrapNodes" ) == 1,
    //      "Verification that the trampolined function 'wrapNodes' runs recursively stack-free" )

    t.resume match {
      //      case -\/( s ) =>
      //        suspend { wrapNodes( s(), prefix, label, xmlAttributesAndLocalReferences, xmiScopes ) }
      case -\/(s) =>
        wrapNodes(xRefAttrs, s(), xRefRefs, prefix, label, xmlAttributesAndLocalReferences, xmiScopes)
      case \/-(Failure(f)) =>
        return_ {
          Failure(f)
        }
      case \/-(Success((_, sNodes, _))) =>
        (xRefAttrs, xRefRefs) match {
          case (Failure(f), _) =>
            return_ {
              Failure(f)
            }
          case (_, Failure(f)) =>
            return_ {
              Failure(f)
            }
          case (Success(aNodes), Success(rNodes)) =>
            import scala.xml._
            val node = Elem(
              prefix = prefix,
              label = label,
              attributes = xmlAttributesAndLocalReferences,
              scope = xmiScopes,
              minimizeEmpty = true,
              aNodes ++ sNodes ++ rNodes: _*)
            return_ {
              Success(node)
            }
        }
    }
  }

  protected def generateNodeElement(
                                     elementOrdering: scala.collection.mutable.ArrayBuffer[UMLElement[Uml]],
                                     d: SerializableDocument[Uml],
                                     prefix: String,
                                     label: String,
                                     e: UMLElement[Uml],
                                     xmiScopes: scala.xml.NamespaceBinding): Trampoline[Try[scala.xml.Node]] = {

    elementOrdering += e

    import scala.xml._

    //    assert(
    //      Thread.currentThread().getStackTrace.count( _.getMethodName == "generateNodeElement" ) == 1,
    //      s"Verification that the trampolined function 'wrapNodes' runs recursively stack-free for label=${label}, e=${e.xmiID}" )

    def foldAttribute(next: Try[MetaData], f: e.MetaAttributeFunction): Try[MetaData] =
      (next, f.evaluate(e)) match {
        case (Failure(t), _) =>
          Failure(t)
        case (_, Failure(t)) =>
          Failure(t)
        case (Success(n), Success(values)) =>
          Success(
            (n /: values) {
              case (_n, _value) =>
                f.attributePrefix match {
                  case None =>
                    new UnprefixedAttribute(key = f.attributeName, value = _value, _n)
                  case Some(aPrefix) =>
                    new PrefixedAttribute(pre = aPrefix, key = f.attributeName, value = _value, _n)
                }
            })
      }

    def foldAttributeNode(nodes: Try[NodeSeq], f: e.MetaAttributeFunction): Try[NodeSeq] =
      (nodes, f.evaluate(e)) match {
        case (Failure(t), _) => Failure(t)
        case (_, Failure(t)) => Failure(t)
        case (Success(ns), Success(values)) =>
          val valueNodes = for {
            value <- values
          } yield Elem(
              prefix = null, label = f.attributeName,
              attributes = Null, scope = xmiScopes, minimizeEmpty = true, Text(value))
          Success(ns ++ valueNodes)
      }

    def foldReference(nodes: Try[NodeSeq], f: e.MetaPropertyEvaluator): Try[NodeSeq] =
      nodes match {
        case Failure(t) => Failure(t)
        case Success(ns) =>
          f match {
            case rf: e.MetaReferenceEvaluator =>
              rf.evaluate(e) match {
                case Failure(t) => Failure(t)
                case Success(None) => Success(ns)
                case Success(Some(eRef)) =>
                  eRef.xmiID.headOption match {
                    case None =>
                      return Failure(new IllegalArgumentException("Every Element must have an ID or an OTI xmi:ID"))
                    case Some(eRefID) =>
                      element2mappedDocument(eRef) match {
                        case None =>
                          Success(ns)
                        case Some(dRef) =>
                          if (d == dRef) {
                            val idrefAttrib: MetaData =
                              new PrefixedAttribute(pre = "xmi", key = "idref", value = eRefID, Null)
                            val idrefNode: Node =
                              Elem(
                                prefix = null, label = f.propertyName,
                                attributes = idrefAttrib, scope = xmiScopes, minimizeEmpty = true)
                            Success(ns :+ idrefNode)
                          } else {
                            val href = dRef.documentURL + "#" + eRefID
                            val externalHRef = dRef match {
                              case _: SerializableDocument[Uml] => href
                              case _: BuiltInDocument[Uml] => ds.builtInURIMapper.resolve(href).getOrElse(href)
                            }

                            val hrefAttrib: MetaData =
                              new UnprefixedAttribute(key = "href", value = externalHRef, Null)
                            val hrefNode: Node =
                              Elem(
                                prefix = null, label = f.propertyName, attributes = hrefAttrib,
                                scope = xmiScopes, minimizeEmpty = true)
                            Success(ns :+ hrefNode)
                          }
                      }
                  }
              }

            case cf: e.MetaCollectionEvaluator =>
              cf.evaluate(e) match {
                case Failure(t) => Failure(t)
                case Success(Nil) => Success(ns)
                case Success(eRefs) =>
                  val hRefs = eRefs flatMap { eRef =>
                    eRef.xmiID.headOption match {
                      case None =>
                        return Failure(new IllegalArgumentException("Every Element must have an ID or an OTI xmi:ID"))
                      case Some(eRefID) =>
                        element2mappedDocument(eRef) match {
                          case None =>
                            None
                          case Some(dRef) =>
                            if (d == dRef) {
                              val idrefAttrib: MetaData =
                                new PrefixedAttribute(pre = "xmi", key = "idref", value = eRefID, Null)
                              val idrefNode: Node =
                                Elem(
                                  prefix = null, label = f.propertyName,
                                  attributes = idrefAttrib, scope = xmiScopes, minimizeEmpty = true)
                              idrefNode
                            } else {
                              val href = dRef.documentURL + "#" + eRefID
                              val externalHRef = dRef match {
                                case _: SerializableDocument[Uml] => href
                                case _: BuiltInDocument[Uml] => ds.builtInURIMapper.resolve(href).getOrElse(href)
                              }
                              val hrefAttrib: MetaData =
                                new UnprefixedAttribute(key = "href", value = externalHRef, Null)
                              val hrefNode: Node =
                                Elem(
                                  prefix = null, label = f.propertyName, attributes = hrefAttrib,
                                  scope = xmiScopes, minimizeEmpty = true)
                              hrefNode
                            }
                        }
                    }
                  }
                  Success(ns ++ hRefs)
              }
          }
      }

    def waitGenerateNodeElement
    (f: e.MetaPropertyEvaluator,
     sub: UMLElement[Uml])
    : Try[scala.xml.Node] =
      callGenerateNodeElement(f, sub).run

    def callGenerateNodeElement
    (f: e.MetaPropertyEvaluator,
     sub: UMLElement[Uml])
    : Trampoline[Try[scala.xml.Node]] =
      generateNodeElement(elementOrdering, d, null, f.propertyName, sub, xmiScopes)

    def waitGenerateNodeReference
    (f: e.MetaPropertyEvaluator,
     sub: UMLElement[Uml])
    : Try[scala.xml.Node] = {
      val idRefAttrib: MetaData =
        new PrefixedAttribute(pre = "xmi", key = "idref", value = sub.xmiID.head, Null)

      val idRefNode: Node = Elem(
        prefix = null,
        label = f.propertyName,
        attributes = idRefAttrib,
        scope = xmiScopes,
        minimizeEmpty = true)

      Success(idRefNode)
    }

    def callGenerateNodeReference
    (f: e.MetaPropertyEvaluator,
     sub: UMLElement[Uml])
    : Trampoline[Try[scala.xml.Node]] = {
      return_ {
        waitGenerateNodeReference(f, sub)
      }
    }

    def prependNestedElementsOrIdReferences
    (f: e.MetaPropertyEvaluator,
     subs: List[UMLElement[Uml]],
     subElements: Set[UMLElement[Uml]],
     nodes: NodeSeq,
     redefined: MetaPropertyFunctionSet)
    : Try[SerializationState] = {
      val (
        resultingSubElements: Set[UMLElement[Uml]],
        nested: SortedMap[String, Node],
        idrefs: SortedMap[String, Node]) =
        (Tuple3(subElements, SortedMap.empty[String, Node], SortedMap.empty[String, Node]) /: subs) {
          case ((visitedElements, sub_nested, sub_idrefs), subElement) =>
            if (visitedElements.contains(subElement))
              waitGenerateNodeReference(f, subElement) match {
                case Failure(f) => return Failure(f)
                case Success(subNode) =>
                  Tuple3(visitedElements + subElement, sub_nested, sub_idrefs + (subElement.xmiID.head -> subNode))
              }
            else
              callGenerateNodeElement(f, subElement).run match {
                case Failure(f) => return Failure(f)
                case Success(subNode) =>
                  Tuple3(visitedElements + subElement, sub_nested + (subElement.xmiUUID.head -> subNode), sub_idrefs)
              }
        }

      val nestedNodes = for {k <- nested.keySet.toSeq} yield nested(k)
      val idrefNodes = for {k <- idrefs.keySet.toSeq} yield idrefs(k)
      val resultNodes = nestedNodes ++ idrefNodes ++ nodes
      Success(resultingSubElements, resultNodes, redefined)
    }

    def applyGenerateNodeElementsOrSkip
    (f: e.MetaPropertyEvaluator,
     subs: List[UMLElement[Uml]],
     subElements: Set[UMLElement[Uml]],
     nodes: NodeSeq,
     redefined: MetaPropertyFunctionSet)
    : Trampoline[Try[SerializationState]] =
      subs match {
        case Nil => return_ {
          Success(subElements, nodes, redefined)
        }
        case x :: xs =>
          for {
            node <- if (subElements.contains(x))
              return return_ {
                Success(subElements, nodes, redefined)
              }
            else
              append1Pair(x, callGenerateNodeElement(f, x), subElements, nodes, redefined)
            result <- node match {
              case Failure(t) => return return_ {
                Failure(t)
              }
              case Success((es, ns, rs)) => applyGenerateNodeElementsOrSkip(f, xs, es, ns, rs)
            }
          } yield result
      }

    /**
     * @see XMI2.5 ptc/14-09-21 9.4.1
     *      Instance of Model Element:
     *      A Property, type is not a PrimitiveType or Enumeration, isComposite = true
     *
     *      XMI Representation:
     *      Choice of:
     *      1. Nested XMIObjectElement
     *      2. Nested XMIReferenceElement
     *      2. Nested XMIReferenceAttribute
     *      Normally, serialized properties with isComposite = true are serialized as nested XMIObjectElements.
     *      In the case where the model is split across more than one file then
     *      a nested XMIReferenceElement would be used.
     *      Exceptionally, even within one file, it may be the case that
     *      a containing object has more than one serialized class-typed property with isComposite = true that
     *      contain the same object or include it among their collection of objects.
     *      In such an exceptional case, because of MOF constraints,
     *      only one of those properties can have an opposite with a non-empty slot.
     *      Objects of the property with the non-empty opposite slot are serialized as nested XMIObjectElements,
     *      and the other references to the same object are serialized either
     *      as XMIReferenceAttributes or nested XMIReferenceElements.
     *
     * @see XMI2.5 ptc/14-09-21 9.4.2
     *      No special serialization rules need to be defined for subsetted Properties.
     *      Following EMOF rule 1, when one of the subsetted or subsetting Properties is derived,
     *      it is not serialized by default. Properties that are not derived are serialized.
     */
    @tailrec def trampolineSubNode
    (nodes: Trampoline[Try[SerializationState]],
     f: e.MetaPropertyEvaluator)
    : Trampoline[Try[SerializationState]] = {

      nodes.resume match {
        //        case -\/( s ) =>
        //          suspend { trampolineSubNode( s(), f ) }
        case -\/(s) =>
          trampolineSubNode(s(), f)

        case \/-(r) =>
          r match {
            case Failure(t) =>
              return_ {
                Failure(t)
              }

            case Success((subElements, ns, redefined)) =>
              f match {
                case rf: e.MetaReferenceEvaluator =>
                  rf.evaluate(e) match {
                    case Failure(t) => return_ {
                      Failure(t)
                    }
                    case Success(None) => return_ {
                      Success((subElements, ns, redefined))
                    }
                    case Success(Some(sub)) =>
                      if (subElements.contains(sub))

                      /**
                       * The element is already serialized by a composite meta property.
                       */
                        return_ {
                          Success((subElements, ns, f.redefinedMetaProperties ++ redefined))
                        }
                      else

                      /**
                       * The element has not yet been serialized; this is the 1st composite meta property to do so.
                       */
                        suspend {
                          prependNestedElement(
                            sub,
                            callGenerateNodeElement(f, sub),
                            subElements,
                            ns,
                            f.redefinedMetaProperties ++ redefined)
                        }
                  }
                case cf: e.MetaCollectionEvaluator =>
                  cf.evaluate(e) match {
                    case Failure(t) => return_ {
                      Failure(t)
                    }
                    case Success(Nil) => return_ {
                      Success((subElements, ns, redefined))
                    }
                    case Success(subs) =>
                      return_ {
                        prependNestedElementsOrIdReferences(f, subs, subElements, ns, redefined)
                      }
                  }
              }
          }
      }
    }

    val refEvaluators: Seq[e.MetaPropertyEvaluator] = e.referenceMetaProperties
    val subEvaluators: Seq[e.MetaPropertyEvaluator] = e.compositeMetaProperties
    val duplicates = refEvaluators.toSet.intersect(subEvaluators.toSet)
    require(duplicates.isEmpty, s"${e.xmiType} ${duplicates.size}: $duplicates")

    val mofAttributes0: Try[MetaData] = Success(Null)
    (mofAttributes0 /: e.mofXMI_metaAttributes.reverse)(foldAttribute) match {
      case Failure(t) =>
        return_ {
          Failure(t)
        }

      case Success(mofAttributesN) =>
        suspend {
          val xRefA0: Try[NodeSeq] = Success(NodeSeq.Empty)
          val xRefAs = (xRefA0 /: e.metaAttributes)(foldAttributeNode)

          val xRefR0: Try[NodeSeq] = Success(NodeSeq.Empty)
          val xRefRs = (xRefR0 /: refEvaluators)(foldReference)

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
          // However, trampolineSubNode prepends additions so that the result is in the correct order
          // (I.e., sub-nodes for superclass properties are before sub-nodes for specialized class properties)

          val xSub0: Trampoline[Try[SerializationState]] = return_(Success((Set(), Seq(), Set())))
          val xSubs = (xSub0 /: subEvaluators.reverse)(trampolineSubNode)

          wrapNodes(xRefAs, xSubs, xRefRs, prefix, label, mofAttributesN, xmiScopes)
        }
    }
  }
}
