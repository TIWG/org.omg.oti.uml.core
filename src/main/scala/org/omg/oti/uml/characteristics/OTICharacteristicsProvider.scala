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

package org.omg.oti.uml.characteristics

import org.omg.oti.json.common.OTIPrimitiveTypes._
import org.omg.oti.json.common.{OTIArtifactKind, OTISpecificationRootCharacteristics}
import org.omg.oti.uml.read.api._

import scala.collection.immutable.{Map, Set}
import scala.Option
import scala.Predef.String
import scalaz.{@@, \&/, \/}

/**
  * Tool-neutral interface to provide OTI Characteristics about UML Packages
  * and XMI ID/UUID about UML Elements.
  *
  * This interface allows providing OTI characteristics via other channels than
  * using a UML-based representation like the OTICharacteristicsProfileProvider does.
  *
  * @tparam Uml The type signature for a tool-specific adaptation of the OTI UML API.
  */
trait OTICharacteristicsProvider[Uml <: UML] {

  /**
    * Optionally provide a URI to override the Package::URI on a UML Package
    * 
    * @param e a UML Package
    * @return A whitespace-trimmed URI which the characteristics' URI (if available) or the package's URI (if available)
    */
  def packageURI
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URI]

  /**
    * Optionally provide a URL corresponding to the external resource published for a UML Package
    * 
    * @param e a UML Package
    * @return If available, a URL specifying the external resource corresponding to `e`
    */
  def documentURL
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URL]

  /**
    * Optionally provide an OTI artifact kind categorizing the external resource published for a UML Package
    * 
    * @param e a UML Package
    * @return If available, an OTI artifact kind categorizing the external resource corresponding to `e`
    */
  def artifactKind
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[OTIArtifactKind]

  /**
    * Optionally provide an XML namespace prefix for the serialization of a UML Package as an external resource
    * 
    * @param e a UML Package
    * @return If available, an XML namespace prefix for the serialization of `e` as an external resource
    */
  def nsPrefix
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_NS_PREFIX]

  /**
    * Optionally provide an XMI UUID prefix for the serialization of a UML Package as an external resource
    *
    * @param e a UML Package
    * @return If available, an XMI UUID prefix for the serialization of `e` as an external resource
    */
  def uuidPrefix
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_UUID_PREFIX]

  /**
    * If applicable, provide the characteristics of the OTI document artifact corresponding to a given UML Package.
    *
    * @param e a UML Package
    * @return If applicable, the characteristics of the OTI artifact specified by the element
    */
  def getSpecificationRootCharacteristics
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[OTISpecificationRootCharacteristics]

  def getAllOTIBuiltInDocumentPackages
  : Set[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]

  def getAllOTISerializableDocumentPackages
  : Set[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]

  /**
    * Optionally provide an xmi:ID overriding the xmi:ID of a UML Element for serialization purposes
    * 
    * @param e a UML Element
    * @return If available, an xmi:ID overriding the xmi:ID of `e` when `e` is serialized
    */
  def xmiID
  (e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_ID]

  /**
    * Optionally provide an xmi:UUID overriding the xmi:UUID of a UML Element for serialization purposes
    *
    * @param e a UML Element
    * @return If available, an xmi:ID overriding the xmi:ID of `e` when `e` is serialized
    */
  def xmiUUID
  (e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_UUID]
}