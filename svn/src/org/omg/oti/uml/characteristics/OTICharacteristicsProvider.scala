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
package org.omg.oti.uml.characteristics

import org.omg.oti.uml.OTIPrimitiveTypes._
import org.omg.oti.uml.read.api._

import scala.collection.immutable.{Map,Set}
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

/**
  * A UML Package can be the root of an OTI artifact of some kind.
  * OTI artifact kinds impose well-formedness constraints on
  * UML Package inter-relationships. 
  */
sealed trait OTIArtifactKind

/**
  * The kind for a UML Package that is processed as part of an importing/loading an OTI Document
  */
object OTILoadingArtifactKind
 extends OTIArtifactKind

/**
  * The kind for a UML Package representing a metamodel (built-in or serializable)
  */
sealed trait OTIMetamodelArtifactKind extends OTIArtifactKind

/**
  * The kind for a UML Package representing a profile (built-in or serializable)
  */
sealed trait OTIProfileArtifactKind extends OTIArtifactKind

/**
  * The kind for a UML Package representing a model-library (built-in or serializable)
  */
sealed trait OTIModelLibraryArtifactKind extends OTIArtifactKind


/**
  * A UML Package that is the root of an OTI artifact of some kind
  * that can be serialized to or deserialized from an external representation.
  */
sealed trait OTISerializableArtifactKind extends OTIArtifactKind

/**
  * The kind for a UML Package representing a metamodel that can be serialized.
  * A metamodel package can acyclically import metamodel or model library packages
  */
object OTISerializableMetamodelArtifactKind
  extends OTIArtifactKind
  with OTISerializableArtifactKind
  with OTIMetamodelArtifactKind

/**
  * The kind for a UML Package representing a profile that can be serialized.
  * A profile package must acyclically extend at least one metamodel package
  * and can acyclically import model library packages.
  */
object OTISerializableProfileArtifactKind
  extends OTIArtifactKind
  with OTISerializableArtifactKind
  with OTIProfileArtifactKind

/**
  * The kind for a UML Package representing a model library that can be serialized.
  * A model library package can acyclically import model library packages
  * and can acyclically apply profile packages.
  */
object OTISerializableModelLibraryArtifactKind
  extends OTIArtifactKind
  with OTISerializableArtifactKind
  with OTIModelLibraryArtifactKind

/**
  * A UML Package that is the root of an OTI artifact of some kind
  * that is built-in an OTI-compatible tool. Such an artifact is neither
  * serialized to nor deserialized from an external representation.
  */
sealed trait OTIBuiltInArtifactKind extends OTIArtifactKind

/**
  * The kind for a UML Package representing a metamodel that is built-in an OTI compatible tool.
  * A built-in metamodel package can acyclically import built-in metamodel or built-in model library packages
  */
object OTIBuiltInMetamodelArtifactKind
  extends OTIArtifactKind
  with OTIBuiltInArtifactKind
  with OTIMetamodelArtifactKind

/**
  * The kind for a UML Package representing a profile that is built-in an OTI compatible tool.
  * A built-in profile package must acyclically extend at least one built-in metamodel package
  * and can acyclically import built-in model library packages.
  */
object OTIBuiltInProfileArtifactKind
  extends OTIArtifactKind
  with OTIBuiltInArtifactKind
  with OTIProfileArtifactKind

/**
  * The kind for a UML Package representing a model library that is built-in an OTI compatible tool.
  * A built-in model library package can acyclically import built-in model library packages
  * and can acyclically apply built-in profile packages.
  */
object OTIBuiltInModelLibraryArtifactKind
  extends OTIArtifactKind
  with OTIBuiltInArtifactKind
  with OTIModelLibraryArtifactKind