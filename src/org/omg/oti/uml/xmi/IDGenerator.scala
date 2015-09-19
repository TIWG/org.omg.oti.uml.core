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
package org.omg.oti.uml.xmi

import java.net.URL
import java.net.MalformedURLException
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.Predef.String
import scala.Array
import scala.Byte
import scala.Boolean
import scala.Char
import scala.Int
import scala.Option
import scala.Unit
import scala.Predef.{Map => _,_}
import scala.collection.immutable._
import scala.language.postfixOps
import scala.util.Failure
import scala.util.Success
import scala.util.Try

import java.lang.StringBuffer

/**
 * A generic API corresponding to OMG XMI 2.5.1, Section B.4 Identification
 *
 * Although the Identification algorithms are defined in a tool-neutral way,
 * this generic API provides the flexibility for tool-specific adaptation.
 *
 * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API
 */
trait IDGenerator[Uml <: UML] { 
  
  implicit val umlOps: UMLOps[Uml]

  /**
   * Get the current element/xmi:ID map state of this ID Generator
   *
   * @return The current mapping of elements to their xmi:ID
   */
  def getElement2IDMap: Map[UMLElement[Uml], Try[String]]

  /**
   * Lookup the current element/xmi:ID map state
   *
   * @param e The element to lookup
   * @return The xmi:ID of `e`, if available
   */
  def lookupElementXMI_ID( e: UMLElement[Uml] ): Try[Option[String]]

  /**
   * Lookup the current element/document map state
   *
   * @param e The element to lookup
   * @return The document that contains `e`, if any
   */
  def element2mappedDocument(e: UMLElement[Uml]): Option[Document[Uml]]
  
  /**
   * Computes the xmi:ID for each element in the domain of the element2document map of the ResolvedDocumentSet
   *
   * @param pkg The scope of the elements and their applied stereotype instances to compute their xmi:ID
   */
  def computePackageExtentXMI_ID( pkg: UMLPackage[Uml] ): Try[Unit]

  /**
   * Map an element to itself or to the tool-specific element it stands for
   *
   * @param ref A referenced element.
   * @return ref or the result of mapping ref according to a particular UML tool.
   *
   * Example: for OMG SysML 1.4, the MD model of OMG SysML 1.4 defines
   * the SYsML profile with a metamodel reference import to a fake OMG UML 2.5 metamodel.
   * This is necessary to make the diagrams for the OMG SysML 1.4 spec.
   * However, for exporting the OMG SysML 1.4 canonical XMI from the MD model,
   * it is necessary to map the fake MD OMG UML 2.5 metamodel to
   * the genuine OMG UML 2.5 metamodel.
   *
   * The default implementation is to return ref (i.e., no mapping).
   */
  def getMappedOrReferencedElement( ref: UMLElement[Uml] ): UMLElement[Uml] = ref

  /**
   * Get the xmi:ID of an element or compute it if necessary
   *
   * 1) it may have been computed already, `getElement2IDMap`\
   * 2) otherwise, check for the document scope of the element:
   * - for a BuiltInDocument, use the element's toolSpecific_id
   * - for a SerializableDocument, use the element's oti_xmiID, if any or calculate it, see `computeID`
   *
   * @param self A UML Element
   * @return id, the xmi:ID of `self` such that getELement2IDMap(`self`) == Success(id)
   */
  def getXMI_ID( self: UMLElement[Uml] ): Try[String]

  /**
   * Compute the canonical xmi:ID for a UML Element according to the OTI canonical XMI:ID generation rules
   *
   * @param self a UML Element that is in scope of a SerializableDocument
   * @return the xmi:ID computed according to the OTI canonical XMI:ID generation rules
   */
  def computeID( self: UMLElement[Uml] ): Try[String]

  /**
   * Compute the legal fragment for an xmi:ID of a UML Image based on its location string interpreted as a URL
   *
   * @param i A UML Image with a location
   * @return A legal fragment for an xmi:ID corresponding to the image's location interpreted as a URL
   */
  def getImageLocationURL( i: UMLImage[Uml] ): Try[String]
}

object IDGenerator {
  
  def xmlSafeID( self: String ): String = self match {
    case null =>
      ""
    case s =>
      getValidNCName( s )
  }

  /** NCName start character mask. */
  val MASK_NCNAME_START: Byte = 0x40.toByte

  /** NCName character mask. */
  val MASK_NCNAME: Byte = 0x80.toByte

  val CHARS: Array[Byte] = new Array[Byte](1 << 16)

  def ArrayFill[T](array: Array[T], n1: Int, n2: Int, value: T): Unit = for (i <- n1 until n2) array.update(i, value)
  
  CHARS.update(9, 35)
  CHARS.update(10, 19)
  CHARS.update(13, 19)
  CHARS.update(32, 51)
  CHARS.update(33, 49)
  CHARS.update(34, 33)
  ArrayFill[Byte](CHARS, 35, 38, 49 ) // Fill 3 of value (byte) 49
  CHARS.update(38, 1)
  ArrayFill[Byte](CHARS, 39, 45, 49) // Fill 6 of value (byte) 49
  ArrayFill[Byte](CHARS, 45, 47, -71) // Fill 2 of value (byte) -71
  CHARS.update(47, 49)
  ArrayFill[Byte](CHARS, 48, 58, -71) // Fill 10 of value (byte) -71
  CHARS.update(58, 61)
  CHARS.update(59, 49)
  CHARS.update(60, 1)
  CHARS.update(61, 49)
  CHARS.update(62, 33)
  ArrayFill[Byte](CHARS, 63, 65, 49) // Fill 2 of value (byte) 49
  ArrayFill[Byte](CHARS, 65, 91, -3) // Fill 26 of value (byte) -3
  ArrayFill[Byte](CHARS, 91, 93, 33) // Fill 2 of value (byte) 33
  CHARS.update(93, 1)
  CHARS.update(94, 33)
  CHARS.update(95, -3)
  CHARS.update(96, 33)
  ArrayFill[Byte](CHARS, 97, 123, -3) // Fill 26 of value (byte) -3
  ArrayFill[Byte](CHARS, 123, 183, 33) // Fill 60 of value (byte) 33
  CHARS.update(183, -87)
  ArrayFill[Byte](CHARS, 184, 192, 33) // Fill 8 of value (byte) 33
  ArrayFill[Byte](CHARS, 192, 215, -19) // Fill 23 of value (byte) -19
  CHARS.update(215, 33)
  ArrayFill[Byte](CHARS, 216, 247, -19) // Fill 31 of value (byte) -19
  CHARS.update(247, 33)
  ArrayFill[Byte](CHARS, 248, 306, -19) // Fill 58 of value (byte) -19
  ArrayFill[Byte](CHARS, 306, 308, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 308, 319, -19) // Fill 11 of value (byte) -19
  ArrayFill[Byte](CHARS, 319, 321, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 321, 329, -19) // Fill 8 of value (byte) -19
  CHARS.update(329, 33)
  ArrayFill[Byte](CHARS, 330, 383, -19) // Fill 53 of value (byte) -19
  CHARS.update(383, 33)
  ArrayFill[Byte](CHARS, 384, 452, -19) // Fill 68 of value (byte) -19
  ArrayFill[Byte](CHARS, 452, 461, 33) // Fill 9 of value (byte) 33
  ArrayFill[Byte](CHARS, 461, 497, -19) // Fill 36 of value (byte) -19
  ArrayFill[Byte](CHARS, 497, 500, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 500, 502, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 502, 506, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 506, 536, -19) // Fill 30 of value (byte) -19
  ArrayFill[Byte](CHARS, 536, 592, 33) // Fill 56 of value (byte) 33
  ArrayFill[Byte](CHARS, 592, 681, -19) // Fill 89 of value (byte) -19
  ArrayFill[Byte](CHARS, 681, 699, 33) // Fill 18 of value (byte) 33
  ArrayFill[Byte](CHARS, 699, 706, -19) // Fill 7 of value (byte) -19
  ArrayFill[Byte](CHARS, 706, 720, 33) // Fill 14 of value (byte) 33
  ArrayFill[Byte](CHARS, 720, 722, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 722, 768, 33) // Fill 46 of value (byte) 33
  ArrayFill[Byte](CHARS, 768, 838, -87) // Fill 70 of value (byte) -87
  ArrayFill[Byte](CHARS, 838, 864, 33) // Fill 26 of value (byte) 33
  ArrayFill[Byte](CHARS, 864, 866, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 866, 902, 33) // Fill 36 of value (byte) 33
  CHARS.update(902, -19)
  CHARS.update(903, -87)
  ArrayFill[Byte](CHARS, 904, 907, -19) // Fill 3 of value (byte) -19
  CHARS.update(907, 33)
  CHARS.update(908, -19)
  CHARS.update(909, 33)
  ArrayFill[Byte](CHARS, 910, 930, -19) // Fill 20 of value (byte) -19
  CHARS.update(930, 33)
  ArrayFill[Byte](CHARS, 931, 975, -19) // Fill 44 of value (byte) -19
  CHARS.update(975, 33)
  ArrayFill[Byte](CHARS, 976, 983, -19) // Fill 7 of value (byte) -19
  ArrayFill[Byte](CHARS, 983, 986, 33) // Fill 3 of value (byte) 33
  CHARS.update(986, -19)
  CHARS.update(987, 33)
  CHARS.update(988, -19)
  CHARS.update(989, 33)
  CHARS.update(990, -19)
  CHARS.update(991, 33)
  CHARS.update(992, -19)
  CHARS.update(993, 33)
  ArrayFill[Byte](CHARS, 994, 1012, -19) // Fill 18 of value (byte) -19
  ArrayFill[Byte](CHARS, 1012, 1025, 33) // Fill 13 of value (byte) 33
  ArrayFill[Byte](CHARS, 1025, 1037, -19) // Fill 12 of value (byte) -19
  CHARS.update(1037, 33)
  ArrayFill[Byte](CHARS, 1038, 1104, -19) // Fill 66 of value (byte) -19
  CHARS.update(1104, 33)
  ArrayFill[Byte](CHARS, 1105, 1117, -19) // Fill 12 of value (byte) -19
  CHARS.update(1117, 33)
  ArrayFill[Byte](CHARS, 1118, 1154, -19) // Fill 36 of value (byte) -19
  CHARS.update(1154, 33)
  ArrayFill[Byte](CHARS, 1155, 1159, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 1159, 1168, 33) // Fill 9 of value (byte) 33
  ArrayFill[Byte](CHARS, 1168, 1221, -19) // Fill 53 of value (byte) -19
  ArrayFill[Byte](CHARS, 1221, 1223, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 1223, 1225, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 1225, 1227, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 1227, 1229, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 1229, 1232, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 1232, 1260, -19) // Fill 28 of value (byte) -19
  ArrayFill[Byte](CHARS, 1260, 1262, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 1262, 1270, -19) // Fill 8 of value (byte) -19
  ArrayFill[Byte](CHARS, 1270, 1272, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 1272, 1274, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 1274, 1329, 33) // Fill 55 of value (byte) 33
  ArrayFill[Byte](CHARS, 1329, 1367, -19) // Fill 38 of value (byte) -19
  ArrayFill[Byte](CHARS, 1367, 1369, 33) // Fill 2 of value (byte) 33
  CHARS.update(1369, -19)
  ArrayFill[Byte](CHARS, 1370, 1377, 33) // Fill 7 of value (byte) 33
  ArrayFill[Byte](CHARS, 1377, 1415, -19) // Fill 38 of value (byte) -19
  ArrayFill[Byte](CHARS, 1415, 1425, 33) // Fill 10 of value (byte) 33
  ArrayFill[Byte](CHARS, 1425, 1442, -87) // Fill 17 of value (byte) -87
  CHARS.update(1442, 33)
  ArrayFill[Byte](CHARS, 1443, 1466, -87) // Fill 23 of value (byte) -87
  CHARS.update(1466, 33)
  ArrayFill[Byte](CHARS, 1467, 1470, -87) // Fill 3 of value (byte) -87
  CHARS.update(1470, 33)
  CHARS.update(1471, -87)
  CHARS.update(1472, 33)
  ArrayFill[Byte](CHARS, 1473, 1475, -87) // Fill 2 of value (byte) -87
  CHARS.update(1475, 33)
  CHARS.update(1476, -87)
  ArrayFill[Byte](CHARS, 1477, 1488, 33) // Fill 11 of value (byte) 33
  ArrayFill[Byte](CHARS, 1488, 1515, -19) // Fill 27 of value (byte) -19
  ArrayFill[Byte](CHARS, 1515, 1520, 33) // Fill 5 of value (byte) 33
  ArrayFill[Byte](CHARS, 1520, 1523, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 1523, 1569, 33) // Fill 46 of value (byte) 33
  ArrayFill[Byte](CHARS, 1569, 1595, -19) // Fill 26 of value (byte) -19
  ArrayFill[Byte](CHARS, 1595, 1600, 33) // Fill 5 of value (byte) 33
  CHARS.update(1600, -87)
  ArrayFill[Byte](CHARS, 1601, 1611, -19) // Fill 10 of value (byte) -19
  ArrayFill[Byte](CHARS, 1611, 1619, -87) // Fill 8 of value (byte) -87
  ArrayFill[Byte](CHARS, 1619, 1632, 33) // Fill 13 of value (byte) 33
  ArrayFill[Byte](CHARS, 1632, 1642, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 1642, 1648, 33) // Fill 6 of value (byte) 33
  CHARS.update(1648, -87)
  ArrayFill[Byte](CHARS, 1649, 1720, -19) // Fill 71 of value (byte) -19
  ArrayFill[Byte](CHARS, 1720, 1722, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 1722, 1727, -19) // Fill 5 of value (byte) -19
  CHARS.update(1727, 33)
  ArrayFill[Byte](CHARS, 1728, 1743, -19) // Fill 15 of value (byte) -19
  CHARS.update(1743, 33)
  ArrayFill[Byte](CHARS, 1744, 1748, -19) // Fill 4 of value (byte) -19
  CHARS.update(1748, 33)
  CHARS.update(1749, -19)
  ArrayFill[Byte](CHARS, 1750, 1765, -87) // Fill 15 of value (byte) -87
  ArrayFill[Byte](CHARS, 1765, 1767, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 1767, 1769, -87) // Fill 2 of value (byte) -87
  CHARS.update(1769, 33)
  ArrayFill[Byte](CHARS, 1770, 1774, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 1774, 1776, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 1776, 1786, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 1786, 2305, 33) // Fill 519 of value (byte) 33
  ArrayFill[Byte](CHARS, 2305, 2308, -87) // Fill 3 of value (byte) -87
  CHARS.update(2308, 33)
  ArrayFill[Byte](CHARS, 2309, 2362, -19) // Fill 53 of value (byte) -19
  ArrayFill[Byte](CHARS, 2362, 2364, 33) // Fill 2 of value (byte) 33
  CHARS.update(2364, -87)
  CHARS.update(2365, -19)
  ArrayFill[Byte](CHARS, 2366, 2382, -87) // Fill 16 of value (byte) -87
  ArrayFill[Byte](CHARS, 2382, 2385, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2385, 2389, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 2389, 2392, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2392, 2402, -19) // Fill 10 of value (byte) -19
  ArrayFill[Byte](CHARS, 2402, 2404, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 2404, 2406, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2406, 2416, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 2416, 2433, 33) // Fill 17 of value (byte) 33
  ArrayFill[Byte](CHARS, 2433, 2436, -87) // Fill 3 of value (byte) -87
  CHARS.update(2436, 33)
  ArrayFill[Byte](CHARS, 2437, 2445, -19) // Fill 8 of value (byte) -19
  ArrayFill[Byte](CHARS, 2445, 2447, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2447, 2449, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2449, 2451, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2451, 2473, -19) // Fill 22 of value (byte) -19
  CHARS.update(2473, 33)
  ArrayFill[Byte](CHARS, 2474, 2481, -19) // Fill 7 of value (byte) -19
  CHARS.update(2481, 33)
  CHARS.update(2482, -19)
  ArrayFill[Byte](CHARS, 2483, 2486, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2486, 2490, -19) // Fill 4 of value (byte) -19
  ArrayFill[Byte](CHARS, 2490, 2492, 33) // Fill 2 of value (byte) 33
  CHARS.update(2492, -87)
  CHARS.update(2493, 33)
  ArrayFill[Byte](CHARS, 2494, 2501, -87) // Fill 7 of value (byte) -87
  ArrayFill[Byte](CHARS, 2501, 2503, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2503, 2505, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 2505, 2507, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2507, 2510, -87) // Fill 3 of value (byte) -87
  ArrayFill[Byte](CHARS, 2510, 2519, 33) // Fill 9 of value (byte) 33
  CHARS.update(2519, -87)
  ArrayFill[Byte](CHARS, 2520, 2524, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 2524, 2526, -19) // Fill 2 of value (byte) -19
  CHARS.update(2526, 33)
  ArrayFill[Byte](CHARS, 2527, 2530, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 2530, 2532, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 2532, 2534, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2534, 2544, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 2544, 2546, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2546, 2562, 33) // Fill 16 of value (byte) 33
  CHARS.update(2562, -87)
  ArrayFill[Byte](CHARS, 2563, 2565, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2565, 2571, -19) // Fill 6 of value (byte) -19
  ArrayFill[Byte](CHARS, 2571, 2575, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 2575, 2577, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2577, 2579, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2579, 2601, -19) // Fill 22 of value (byte) -19
  CHARS.update(2601, 33)
  ArrayFill[Byte](CHARS, 2602, 2609, -19) // Fill 7 of value (byte) -19
  CHARS.update(2609, 33)
  ArrayFill[Byte](CHARS, 2610, 2612, -19) // Fill 2 of value (byte) -19
  CHARS.update(2612, 33)
  ArrayFill[Byte](CHARS, 2613, 2615, -19) // Fill 2 of value (byte) -19
  CHARS.update(2615, 33)
  ArrayFill[Byte](CHARS, 2616, 2618, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2618, 2620, 33) // Fill 2 of value (byte) 33
  CHARS.update(2620, -87)
  CHARS.update(2621, 33)
  ArrayFill[Byte](CHARS, 2622, 2627, -87) // Fill 5 of value (byte) -87
  ArrayFill[Byte](CHARS, 2627, 2631, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 2631, 2633, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 2633, 2635, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2635, 2638, -87) // Fill 3 of value (byte) -87
  ArrayFill[Byte](CHARS, 2638, 2649, 33) // Fill 11 of value (byte) 33
  ArrayFill[Byte](CHARS, 2649, 2653, -19) // Fill 4 of value (byte) -19
  CHARS.update(2653, 33)
  CHARS.update(2654, -19)
  ArrayFill[Byte](CHARS, 2655, 2662, 33) // Fill 7 of value (byte) 33
  ArrayFill[Byte](CHARS, 2662, 2674, -87) // Fill 12 of value (byte) -87
  ArrayFill[Byte](CHARS, 2674, 2677, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 2677, 2689, 33) // Fill 12 of value (byte) 33
  ArrayFill[Byte](CHARS, 2689, 2692, -87) // Fill 3 of value (byte) -87
  CHARS.update(2692, 33)
  ArrayFill[Byte](CHARS, 2693, 2700, -19) // Fill 7 of value (byte) -19
  CHARS.update(2700, 33)
  CHARS.update(2701, -19)
  CHARS.update(2702, 33)
  ArrayFill[Byte](CHARS, 2703, 2706, -19) // Fill 3 of value (byte) -19
  CHARS.update(2706, 33)
  ArrayFill[Byte](CHARS, 2707, 2729, -19) // Fill 22 of value (byte) -19
  CHARS.update(2729, 33)
  ArrayFill[Byte](CHARS, 2730, 2737, -19) // Fill 7 of value (byte) -19
  CHARS.update(2737, 33)
  ArrayFill[Byte](CHARS, 2738, 2740, -19) // Fill 2 of value (byte) -19
  CHARS.update(2740, 33)
  ArrayFill[Byte](CHARS, 2741, 2746, -19) // Fill 5 of value (byte) -19
  ArrayFill[Byte](CHARS, 2746, 2748, 33) // Fill 2 of value (byte) 33
  CHARS.update(2748, -87)
  CHARS.update(2749, -19)
  ArrayFill[Byte](CHARS, 2750, 2758, -87) // Fill 8 of value (byte) -87
  CHARS.update(2758, 33)
  ArrayFill[Byte](CHARS, 2759, 2762, -87) // Fill 3 of value (byte) -87
  CHARS.update(2762, 33)
  ArrayFill[Byte](CHARS, 2763, 2766, -87) // Fill 3 of value (byte) -87
  ArrayFill[Byte](CHARS, 2766, 2784, 33) // Fill 18 of value (byte) 33
  CHARS.update(2784, -19)
  ArrayFill[Byte](CHARS, 2785, 2790, 33) // Fill 5 of value (byte) 33
  ArrayFill[Byte](CHARS, 2790, 2800, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 2800, 2817, 33) // Fill 17 of value (byte) 33
  ArrayFill[Byte](CHARS, 2817, 2820, -87) // Fill 3 of value (byte) -87
  CHARS.update(2820, 33)
  ArrayFill[Byte](CHARS, 2821, 2829, -19) // Fill 8 of value (byte) -19
  ArrayFill[Byte](CHARS, 2829, 2831, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2831, 2833, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2833, 2835, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2835, 2857, -19) // Fill 22 of value (byte) -19
  CHARS.update(2857, 33)
  ArrayFill[Byte](CHARS, 2858, 2865, -19) // Fill 7 of value (byte) -19
  CHARS.update(2865, 33)
  ArrayFill[Byte](CHARS, 2866, 2868, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2868, 2870, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2870, 2874, -19) // Fill 4 of value (byte) -19
  ArrayFill[Byte](CHARS, 2874, 2876, 33) // Fill 2 of value (byte) 33
  CHARS.update(2876, -87)
  CHARS.update(2877, -19)
  ArrayFill[Byte](CHARS, 2878, 2884, -87) // Fill 6 of value (byte) -87
  ArrayFill[Byte](CHARS, 2884, 2887, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2887, 2889, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 2889, 2891, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 2891, 2894, -87) // Fill 3 of value (byte) -87
  ArrayFill[Byte](CHARS, 2894, 2902, 33) // Fill 8 of value (byte) 33
  ArrayFill[Byte](CHARS, 2902, 2904, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 2904, 2908, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 2908, 2910, -19) // Fill 2 of value (byte) -19
  CHARS.update(2910, 33)
  ArrayFill[Byte](CHARS, 2911, 2914, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 2914, 2918, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 2918, 2928, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 2928, 2946, 33) // Fill 18 of value (byte) 33
  ArrayFill[Byte](CHARS, 2946, 2948, -87) // Fill 2 of value (byte) -87
  CHARS.update(2948, 33)
  ArrayFill[Byte](CHARS, 2949, 2955, -19) // Fill 6 of value (byte) -19
  ArrayFill[Byte](CHARS, 2955, 2958, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2958, 2961, -19) // Fill 3 of value (byte) -19
  CHARS.update(2961, 33)
  ArrayFill[Byte](CHARS, 2962, 2966, -19) // Fill 4 of value (byte) -19
  ArrayFill[Byte](CHARS, 2966, 2969, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2969, 2971, -19) // Fill 2 of value (byte) -19
  CHARS.update(2971, 33)
  CHARS.update(2972, -19)
  CHARS.update(2973, 33)
  ArrayFill[Byte](CHARS, 2974, 2976, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2976, 2979, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2979, 2981, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 2981, 2984, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2984, 2987, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 2987, 2990, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 2990, 2998, -19) // Fill 8 of value (byte) -19
  CHARS.update(2998, 33)
  ArrayFill[Byte](CHARS, 2999, 3002, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 3002, 3006, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3006, 3011, -87) // Fill 5 of value (byte) -87
  ArrayFill[Byte](CHARS, 3011, 3014, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 3014, 3017, -87) // Fill 3 of value (byte) -87
  CHARS.update(3017, 33)
  ArrayFill[Byte](CHARS, 3018, 3022, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 3022, 3031, 33) // Fill 9 of value (byte) 33
  CHARS.update(3031, -87)
  ArrayFill[Byte](CHARS, 3032, 3047, 33) // Fill 15 of value (byte) 33
  ArrayFill[Byte](CHARS, 3047, 3056, -87) // Fill 9 of value (byte) -87
  ArrayFill[Byte](CHARS, 3056, 3073, 33) // Fill 17 of value (byte) 33
  ArrayFill[Byte](CHARS, 3073, 3076, -87) // Fill 3 of value (byte) -87
  CHARS.update(3076, 33)
  ArrayFill[Byte](CHARS, 3077, 3085, -19) // Fill 8 of value (byte) -19
  CHARS.update(3085, 33)
  ArrayFill[Byte](CHARS, 3086, 3089, -19) // Fill 3 of value (byte) -19
  CHARS.update(3089, 33)
  ArrayFill[Byte](CHARS, 3090, 3113, -19) // Fill 23 of value (byte) -19
  CHARS.update(3113, 33)
  ArrayFill[Byte](CHARS, 3114, 3124, -19) // Fill 10 of value (byte) -19
  CHARS.update(3124, 33)
  ArrayFill[Byte](CHARS, 3125, 3130, -19) // Fill 5 of value (byte) -19
  ArrayFill[Byte](CHARS, 3130, 3134, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3134, 3141, -87) // Fill 7 of value (byte) -87
  CHARS.update(3141, 33)
  ArrayFill[Byte](CHARS, 3142, 3145, -87) // Fill 3 of value (byte) -87
  CHARS.update(3145, 33)
  ArrayFill[Byte](CHARS, 3146, 3150, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 3150, 3157, 33) // Fill 7 of value (byte) 33
  ArrayFill[Byte](CHARS, 3157, 3159, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 3159, 3168, 33) // Fill 9 of value (byte) 33
  ArrayFill[Byte](CHARS, 3168, 3170, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 3170, 3174, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3174, 3184, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 3184, 3202, 33) // Fill 18 of value (byte) 33
  ArrayFill[Byte](CHARS, 3202, 3204, -87) // Fill 2 of value (byte) -87
  CHARS.update(3204, 33)
  ArrayFill[Byte](CHARS, 3205, 3213, -19) // Fill 8 of value (byte) -19
  CHARS.update(3213, 33)
  ArrayFill[Byte](CHARS, 3214, 3217, -19) // Fill 3 of value (byte) -19
  CHARS.update(3217, 33)
  ArrayFill[Byte](CHARS, 3218, 3241, -19) // Fill 23 of value (byte) -19
  CHARS.update(3241, 33)
  ArrayFill[Byte](CHARS, 3242, 3252, -19) // Fill 10 of value (byte) -19
  CHARS.update(3252, 33)
  ArrayFill[Byte](CHARS, 3253, 3258, -19) // Fill 5 of value (byte) -19
  ArrayFill[Byte](CHARS, 3258, 3262, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3262, 3269, -87) // Fill 7 of value (byte) -87
  CHARS.update(3269, 33)
  ArrayFill[Byte](CHARS, 3270, 3273, -87) // Fill 3 of value (byte) -87
  CHARS.update(3273, 33)
  ArrayFill[Byte](CHARS, 3274, 3278, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 3278, 3285, 33) // Fill 7 of value (byte) 33
  ArrayFill[Byte](CHARS, 3285, 3287, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 3287, 3294, 33) // Fill 7 of value (byte) 33
  CHARS.update(3294, -19)
  CHARS.update(3295, 33)
  ArrayFill[Byte](CHARS, 3296, 3298, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 3298, 3302, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3302, 3312, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 3312, 3330, 33) // Fill 18 of value (byte) 33
  ArrayFill[Byte](CHARS, 3330, 3332, -87) // Fill 2 of value (byte) -87
  CHARS.update(3332, 33)
  ArrayFill[Byte](CHARS, 3333, 3341, -19) // Fill 8 of value (byte) -19
  CHARS.update(3341, 33)
  ArrayFill[Byte](CHARS, 3342, 3345, -19) // Fill 3 of value (byte) -19
  CHARS.update(3345, 33)
  ArrayFill[Byte](CHARS, 3346, 3369, -19) // Fill 23 of value (byte) -19
  CHARS.update(3369, 33)
  ArrayFill[Byte](CHARS, 3370, 3386, -19) // Fill 16 of value (byte) -19
  ArrayFill[Byte](CHARS, 3386, 3390, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3390, 3396, -87) // Fill 6 of value (byte) -87
  ArrayFill[Byte](CHARS, 3396, 3398, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 3398, 3401, -87) // Fill 3 of value (byte) -87
  CHARS.update(3401, 33)
  ArrayFill[Byte](CHARS, 3402, 3406, -87) // Fill 4 of value (byte) -87
  ArrayFill[Byte](CHARS, 3406, 3415, 33) // Fill 9 of value (byte) 33
  CHARS.update(3415, -87)
  ArrayFill[Byte](CHARS, 3416, 3424, 33) // Fill 8 of value (byte) 33
  ArrayFill[Byte](CHARS, 3424, 3426, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 3426, 3430, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3430, 3440, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 3440, 3585, 33) // Fill 145 of value (byte) 33
  ArrayFill[Byte](CHARS, 3585, 3631, -19) // Fill 46 of value (byte) -19
  CHARS.update(3631, 33)
  CHARS.update(3632, -19)
  CHARS.update(3633, -87)
  ArrayFill[Byte](CHARS, 3634, 3636, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 3636, 3643, -87) // Fill 7 of value (byte) -87
  ArrayFill[Byte](CHARS, 3643, 3648, 33) // Fill 5 of value (byte) 33
  ArrayFill[Byte](CHARS, 3648, 3654, -19) // Fill 6 of value (byte) -19
  ArrayFill[Byte](CHARS, 3654, 3663, -87) // Fill 9 of value (byte) -87
  CHARS.update(3663, 33)
  ArrayFill[Byte](CHARS, 3664, 3674, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 3674, 3713, 33) // Fill 39 of value (byte) 33
  ArrayFill[Byte](CHARS, 3713, 3715, -19) // Fill 2 of value (byte) -19
  CHARS.update(3715, 33)
  CHARS.update(3716, -19)
  ArrayFill[Byte](CHARS, 3717, 3719, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 3719, 3721, -19) // Fill 2 of value (byte) -19
  CHARS.update(3721, 33)
  CHARS.update(3722, -19)
  ArrayFill[Byte](CHARS, 3723, 3725, 33) // Fill 2 of value (byte) 33
  CHARS.update(3725, -19)
  ArrayFill[Byte](CHARS, 3726, 3732, 33) // Fill 6 of value (byte) 33
  ArrayFill[Byte](CHARS, 3732, 3736, -19) // Fill 4 of value (byte) -19
  CHARS.update(3736, 33)
  ArrayFill[Byte](CHARS, 3737, 3744, -19) // Fill 7 of value (byte) -19
  CHARS.update(3744, 33)
  ArrayFill[Byte](CHARS, 3745, 3748, -19) // Fill 3 of value (byte) -19
  CHARS.update(3748, 33)
  CHARS.update(3749, -19)
  CHARS.update(3750, 33)
  CHARS.update(3751, -19)
  ArrayFill[Byte](CHARS, 3752, 3754, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 3754, 3756, -19) // Fill 2 of value (byte) -19
  CHARS.update(3756, 33)
  ArrayFill[Byte](CHARS, 3757, 3759, -19) // Fill 2 of value (byte) -19
  CHARS.update(3759, 33)
  CHARS.update(3760, -19)
  CHARS.update(3761, -87)
  ArrayFill[Byte](CHARS, 3762, 3764, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 3764, 3770, -87) // Fill 6 of value (byte) -87
  CHARS.update(3770, 33)
  ArrayFill[Byte](CHARS, 3771, 3773, -87) // Fill 2 of value (byte) -87
  CHARS.update(3773, -19)
  ArrayFill[Byte](CHARS, 3774, 3776, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 3776, 3781, -19) // Fill 5 of value (byte) -19
  CHARS.update(3781, 33)
  CHARS.update(3782, -87)
  CHARS.update(3783, 33)
  ArrayFill[Byte](CHARS, 3784, 3790, -87) // Fill 6 of value (byte) -87
  ArrayFill[Byte](CHARS, 3790, 3792, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 3792, 3802, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 3802, 3864, 33) // Fill 62 of value (byte) 33
  ArrayFill[Byte](CHARS, 3864, 3866, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 3866, 3872, 33) // Fill 6 of value (byte) 33
  ArrayFill[Byte](CHARS, 3872, 3882, -87) // Fill 10 of value (byte) -87
  ArrayFill[Byte](CHARS, 3882, 3893, 33) // Fill 11 of value (byte) 33
  CHARS.update(3893, -87)
  CHARS.update(3894, 33)
  CHARS.update(3895, -87)
  CHARS.update(3896, 33)
  CHARS.update(3897, -87)
  ArrayFill[Byte](CHARS, 3898, 3902, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3902, 3904, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 3904, 3912, -19) // Fill 8 of value (byte) -19
  CHARS.update(3912, 33)
  ArrayFill[Byte](CHARS, 3913, 3946, -19) // Fill 33 of value (byte) -19
  ArrayFill[Byte](CHARS, 3946, 3953, 33) // Fill 7 of value (byte) 33
  ArrayFill[Byte](CHARS, 3953, 3973, -87) // Fill 20 of value (byte) -87
  CHARS.update(3973, 33)
  ArrayFill[Byte](CHARS, 3974, 3980, -87) // Fill 6 of value (byte) -87
  ArrayFill[Byte](CHARS, 3980, 3984, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 3984, 3990, -87) // Fill 6 of value (byte) -87
  CHARS.update(3990, 33)
  CHARS.update(3991, -87)
  CHARS.update(3992, 33)
  ArrayFill[Byte](CHARS, 3993, 4014, -87) // Fill 21 of value (byte) -87
  ArrayFill[Byte](CHARS, 4014, 4017, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 4017, 4024, -87) // Fill 7 of value (byte) -87
  CHARS.update(4024, 33)
  CHARS.update(4025, -87)
  ArrayFill[Byte](CHARS, 4026, 4256, 33) // Fill 230 of value (byte) 33
  ArrayFill[Byte](CHARS, 4256, 4294, -19) // Fill 38 of value (byte) -19
  ArrayFill[Byte](CHARS, 4294, 4304, 33) // Fill 10 of value (byte) 33
  ArrayFill[Byte](CHARS, 4304, 4343, -19) // Fill 39 of value (byte) -19
  ArrayFill[Byte](CHARS, 4343, 4352, 33) // Fill 9 of value (byte) 33
  CHARS.update(4352, -19)
  CHARS.update(4353, 33)
  ArrayFill[Byte](CHARS, 4354, 4356, -19) // Fill 2 of value (byte) -19
  CHARS.update(4356, 33)
  ArrayFill[Byte](CHARS, 4357, 4360, -19) // Fill 3 of value (byte) -19
  CHARS.update(4360, 33)
  CHARS.update(4361, -19)
  CHARS.update(4362, 33)
  ArrayFill[Byte](CHARS, 4363, 4365, -19) // Fill 2 of value (byte) -19
  CHARS.update(4365, 33)
  ArrayFill[Byte](CHARS, 4366, 4371, -19) // Fill 5 of value (byte) -19
  ArrayFill[Byte](CHARS, 4371, 4412, 33) // Fill 41 of value (byte) 33
  CHARS.update(4412, -19)
  CHARS.update(4413, 33)
  CHARS.update(4414, -19)
  CHARS.update(4415, 33)
  CHARS.update(4416, -19)
  ArrayFill[Byte](CHARS, 4417, 4428, 33) // Fill 11 of value (byte) 33
  CHARS.update(4428, -19)
  CHARS.update(4429, 33)
  CHARS.update(4430, -19)
  CHARS.update(4431, 33)
  CHARS.update(4432, -19)
  ArrayFill[Byte](CHARS, 4433, 4436, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 4436, 4438, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 4438, 4441, 33) // Fill 3 of value (byte) 33
  CHARS.update(4441, -19)
  ArrayFill[Byte](CHARS, 4442, 4447, 33) // Fill 5 of value (byte) 33
  ArrayFill[Byte](CHARS, 4447, 4450, -19) // Fill 3 of value (byte) -19
  CHARS.update(4450, 33)
  CHARS.update(4451, -19)
  CHARS.update(4452, 33)
  CHARS.update(4453, -19)
  CHARS.update(4454, 33)
  CHARS.update(4455, -19)
  CHARS.update(4456, 33)
  CHARS.update(4457, -19)
  ArrayFill[Byte](CHARS, 4458, 4461, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 4461, 4463, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 4463, 4466, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 4466, 4468, -19) // Fill 2 of value (byte) -19
  CHARS.update(4468, 33)
  CHARS.update(4469, -19)
  ArrayFill[Byte](CHARS, 4470, 4510, 33) // Fill 40 of value (byte) 33
  CHARS.update(4510, -19)
  ArrayFill[Byte](CHARS, 4511, 4520, 33) // Fill 9 of value (byte) 33
  CHARS.update(4520, -19)
  ArrayFill[Byte](CHARS, 4521, 4523, 33) // Fill 2 of value (byte) 33
  CHARS.update(4523, -19)
  ArrayFill[Byte](CHARS, 4524, 4526, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 4526, 4528, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 4528, 4535, 33) // Fill 7 of value (byte) 33
  ArrayFill[Byte](CHARS, 4535, 4537, -19) // Fill 2 of value (byte) -19
  CHARS.update(4537, 33)
  CHARS.update(4538, -19)
  CHARS.update(4539, 33)
  ArrayFill[Byte](CHARS, 4540, 4547, -19) // Fill 7 of value (byte) -19
  ArrayFill[Byte](CHARS, 4547, 4587, 33) // Fill 40 of value (byte) 33
  CHARS.update(4587, -19)
  ArrayFill[Byte](CHARS, 4588, 4592, 33) // Fill 4 of value (byte) 33
  CHARS.update(4592, -19)
  ArrayFill[Byte](CHARS, 4593, 4601, 33) // Fill 8 of value (byte) 33
  CHARS.update(4601, -19)
  ArrayFill[Byte](CHARS, 4602, 7680, 33) // Fill 3078 of value (byte) 33
  ArrayFill[Byte](CHARS, 7680, 7836, -19) // Fill 156 of value (byte) -19
  ArrayFill[Byte](CHARS, 7836, 7840, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 7840, 7930, -19) // Fill 90 of value (byte) -19
  ArrayFill[Byte](CHARS, 7930, 7936, 33) // Fill 6 of value (byte) 33
  ArrayFill[Byte](CHARS, 7936, 7958, -19) // Fill 22 of value (byte) -19
  ArrayFill[Byte](CHARS, 7958, 7960, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 7960, 7966, -19) // Fill 6 of value (byte) -19
  ArrayFill[Byte](CHARS, 7966, 7968, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 7968, 8006, -19) // Fill 38 of value (byte) -19
  ArrayFill[Byte](CHARS, 8006, 8008, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 8008, 8014, -19) // Fill 6 of value (byte) -19
  ArrayFill[Byte](CHARS, 8014, 8016, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 8016, 8024, -19) // Fill 8 of value (byte) -19
  CHARS.update(8024, 33)
  CHARS.update(8025, -19)
  CHARS.update(8026, 33)
  CHARS.update(8027, -19)
  CHARS.update(8028, 33)
  CHARS.update(8029, -19)
  CHARS.update(8030, 33)
  ArrayFill[Byte](CHARS, 8031, 8062, -19) // Fill 31 of value (byte) -19
  ArrayFill[Byte](CHARS, 8062, 8064, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 8064, 8117, -19) // Fill 53 of value (byte) -19
  CHARS.update(8117, 33)
  ArrayFill[Byte](CHARS, 8118, 8125, -19) // Fill 7 of value (byte) -19
  CHARS.update(8125, 33)
  CHARS.update(8126, -19)
  ArrayFill[Byte](CHARS, 8127, 8130, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 8130, 8133, -19) // Fill 3 of value (byte) -19
  CHARS.update(8133, 33)
  ArrayFill[Byte](CHARS, 8134, 8141, -19) // Fill 7 of value (byte) -19
  ArrayFill[Byte](CHARS, 8141, 8144, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 8144, 8148, -19) // Fill 4 of value (byte) -19
  ArrayFill[Byte](CHARS, 8148, 8150, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 8150, 8156, -19) // Fill 6 of value (byte) -19
  ArrayFill[Byte](CHARS, 8156, 8160, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 8160, 8173, -19) // Fill 13 of value (byte) -19
  ArrayFill[Byte](CHARS, 8173, 8178, 33) // Fill 5 of value (byte) 33
  ArrayFill[Byte](CHARS, 8178, 8181, -19) // Fill 3 of value (byte) -19
  CHARS.update(8181, 33)
  ArrayFill[Byte](CHARS, 8182, 8189, -19) // Fill 7 of value (byte) -19
  ArrayFill[Byte](CHARS, 8189, 8400, 33) // Fill 211 of value (byte) 33
  ArrayFill[Byte](CHARS, 8400, 8413, -87) // Fill 13 of value (byte) -87
  ArrayFill[Byte](CHARS, 8413, 8417, 33) // Fill 4 of value (byte) 33
  CHARS.update(8417, -87)
  ArrayFill[Byte](CHARS, 8418, 8486, 33) // Fill 68 of value (byte) 33
  CHARS.update(8486, -19)
  ArrayFill[Byte](CHARS, 8487, 8490, 33) // Fill 3 of value (byte) 33
  ArrayFill[Byte](CHARS, 8490, 8492, -19) // Fill 2 of value (byte) -19
  ArrayFill[Byte](CHARS, 8492, 8494, 33) // Fill 2 of value (byte) 33
  CHARS.update(8494, -19)
  ArrayFill[Byte](CHARS, 8495, 8576, 33) // Fill 81 of value (byte) 33
  ArrayFill[Byte](CHARS, 8576, 8579, -19) // Fill 3 of value (byte) -19
  ArrayFill[Byte](CHARS, 8579, 12293, 33) // Fill 3714 of value (byte) 33
  CHARS.update(12293, -87)
  CHARS.update(12294, 33)
  CHARS.update(12295, -19)
  ArrayFill[Byte](CHARS, 12296, 12321, 33) // Fill 25 of value (byte) 33
  ArrayFill[Byte](CHARS, 12321, 12330, -19) // Fill 9 of value (byte) -19
  ArrayFill[Byte](CHARS, 12330, 12336, -87) // Fill 6 of value (byte) -87
  CHARS.update(12336, 33)
  ArrayFill[Byte](CHARS, 12337, 12342, -87) // Fill 5 of value (byte) -87
  ArrayFill[Byte](CHARS, 12342, 12353, 33) // Fill 11 of value (byte) 33
  ArrayFill[Byte](CHARS, 12353, 12437, -19) // Fill 84 of value (byte) -19
  ArrayFill[Byte](CHARS, 12437, 12441, 33) // Fill 4 of value (byte) 33
  ArrayFill[Byte](CHARS, 12441, 12443, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 12443, 12445, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 12445, 12447, -87) // Fill 2 of value (byte) -87
  ArrayFill[Byte](CHARS, 12447, 12449, 33) // Fill 2 of value (byte) 33
  ArrayFill[Byte](CHARS, 12449, 12539, -19) // Fill 90 of value (byte) -19
  CHARS.update(12539, 33)
  ArrayFill[Byte](CHARS, 12540, 12543, -87) // Fill 3 of value (byte) -87
  ArrayFill[Byte](CHARS, 12543, 12549, 33) // Fill 6 of value (byte) 33
  ArrayFill[Byte](CHARS, 12549, 12589, -19) // Fill 40 of value (byte) -19
  ArrayFill[Byte](CHARS, 12589, 19968, 33) // Fill 7379 of value (byte) 33
  ArrayFill[Byte](CHARS, 19968, 40870, -19) // Fill 20902 of value (byte) -19
  ArrayFill[Byte](CHARS, 40870, 44032, 33) // Fill 3162 of value (byte) 33
  ArrayFill[Byte](CHARS, 44032, 55204, -19) // Fill 11172 of value (byte) -19
  ArrayFill[Byte](CHARS, 55204, 55296, 33) // Fill 92 of value (byte) 33
  ArrayFill[Byte](CHARS, 57344, 65534, 33) // Fill 8190 of value (byte) 33

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.isNCNamePart(char)
   * Returns true if the specified character is a valid NCName start
   * character as defined by production [4] in Namespaces in XML
   * recommendation.
   */
  def isNCNameStart( c: Char ): Boolean =
    c.toInt < 0x10000 &&
    (CHARS(c.toInt) & MASK_NCNAME_START) != 0.toByte

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.isNCNamePart(char)
   * Returns true if the specified character is a valid NCName
   * character as defined by production [5] in Namespaces in XML
   * recommendation.
   */
  def isNCNamePart( c: Char ): Boolean =
    c.toInt < 0x10000 &&
    (CHARS(c.toInt) & MASK_NCNAME) != 0.toByte

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.getValidNCName(String)
   */
  def getValidNCName( name: String ): String = {
    val buff = new StringBuffer()
    getValidNCName( name, buff )
    buff.toString
  }

  /**
   * @see org.eclipse.uml2.common.util.UML2Util.getValidNCName(String, StringBuffer)
   * @see org.eclipse.uml2.uml.util.UMLUtil.Ecore2UMLConverter.escapeString(String, String)
   */
  def getValidNCName( name: String, validNCName: StringBuffer ): Unit = {

    def escapeChar( char: Char ) = {
      val charCode = char.toInt.toHexString.toUpperCase
      val charCodeLength = charCode.length
      if ( charCodeLength == 1 )
        "_u000" + charCode
      else if ( charCodeLength == 2 )
        "_u00" + charCode
      else if ( charCodeLength == 3 )
        "_u0" + charCode
      else
        "_u" + charCode
    }

    if ( null == name || "" == name ) {
      validNCName.insert(0, '_'); ()
    } else {
      for {
        i <- name.length - 1 until 0 by -1
        char_i = name.charAt(i)
      } {
        if (char_i == ' ')
          validNCName.insert(0, '_')
        else if (isNCNamePart(char_i))
          validNCName.insert(0, char_i)
        else
          validNCName.insert(0, escapeChar(char_i))
      }
      val char_0 = name.charAt(0)
      if (isNCNameStart(char_0)) {
        validNCName.insert(0, char_0); ()
      } else {
        if (isNCNamePart(char_0)) {
          validNCName.insert(0, char_0); ()
        } else {
          validNCName.insert(0, escapeChar(char_0)); ()
        }
        validNCName.insert(0, '_'); ()
      }
    }
  }
  
  def computeStereotypeApplicationID (eID: String, stID: String) =
    eID+".stereotypeApplication_"+stID

}