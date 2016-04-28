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

import scala.Predef.String
import scalaz.{@@,\&/,Tag}

/**
  * Use Scalaz' Tagged type technique, `A @@ T`, enables partitioning the use of a reference type,
  * `A` into disjoint types according to the tag type `T` without adding a runtime overhead in the
  * representation of partitioned values of `A`.
  *
  * In an object-oriented perspective, it is as if `A @@ T` were defined as a subclass of
  * the class type `A` such that `A @@ T1` and `A @@ T2` would be disjoint subclasses of `A`
  *
  * In OTI, this is used for partitioning the use of the type `String` as the representation
  * for disjoint types in OTI: URI, URL ID, UUID, NS Prefix, UUID Prefix
  */
object OTIPrimitiveTypes {

  /**
    * The type `String @@ OTI_URI` is the partition of strings representing `OTI_URI` values.
    */
  sealed trait OTI_URI
  val OTI_URI = Tag.of[OTI_URI]

  /**
    * The type `String @@ OTI_URL` is the partition of strings representing `OTI_URL` values.
    */
  sealed trait OTI_URL
  val OTI_URL = Tag.of[OTI_URL]

  /**
    * The type `String @@ OTI_ID` is the partition of strings representing `OTI_ID` values.
    * An `OTI_ID` string value represents either an OTI tool-specific ID or an OTI `xmi:ID`
    */
  sealed trait OTI_ID
  val OTI_ID = Tag.of[OTI_ID]

  /**
    * The type `String @@ OTI_UUID` is the partition of strings representing `OTI_UUID` values.
    * An `OTI_ID` string value represents either an OTI tool-specific UUID or an OTI `xmi:UUID`
    */
  sealed trait OTI_UUID
  val OTI_UUID = Tag.of[OTI_UUID]

  /**
    * The type `String @@ OTI_NS_PREFIX` is the partition of strings representing `OTI_NS_PREFIX` values.
    */
  sealed trait OTI_NS_PREFIX
  val OTI_NS_PREFIX = Tag.of[OTI_NS_PREFIX]

  /**
    * The type `String @@ OTI_UUID_PREFIX` is the partition of strings representing `OTI_UUID_PREFIX` values.
    */
  sealed trait OTI_UUID_PREFIX
  val OTI_UUID_PREFIX = Tag.of[OTI_UUID_PREFIX]

  /**
    * A 2-tuple of an optional OTI_ID String and an optional OTI_UUID String, at least one must be specified.
    * Given its definition as a [[scalaz.TheseInstances]], the possible values for a variable `x: OTI_ID_UUID` are:
    * - `x.isThis`: The OTI_ID String is defined, it can be retrieved as the option `x.a`; the OTI_UUID String is empty.
    * - `x.isThat`: The OTI_ID String is empty; the OTI_UUID String is defined, it can be retrieved as the option `x.b`.
    * - `x.isBoth`: Both the OTI_ID String and OTI_UUID String are defined, they can be retried as the options `x.pad`.
    *
    * @see [[scalaz.\&/]] (the link is broken, replace the fragment with `#scalaz.\$bslash\$amp\$div`)
    * @see [[http://eed3si9n.com/learning-scalaz/Tagged+type.html]] (this article reflects scalaz 7.1, 7.2 is a bit different)
    */
  type OTI_ID_UUID = \&/[String @@ OTI_ID, String @@ OTI_UUID]
}