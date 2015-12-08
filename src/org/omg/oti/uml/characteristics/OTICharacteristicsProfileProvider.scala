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
package org.omg.oti.uml.characteristics

import org.omg.oti.uml.OTIPrimitiveTypes._
import org.omg.oti.uml.UMLError
import org.omg.oti.uml.read.api._

import scala.collection.immutable._
import scala.{Boolean,Option,StringContext}
import scala.Predef.String
import scalaz._, Scalaz._

trait OTICharacteristicsProfileProvider[Uml <: UML]
  extends OTICharacteristicsProvider[Uml] {

  implicit val otiCharacterizations: Option[Map[UMLPackage[Uml], UMLComment[Uml]]]

  /**
    * For a package, get the value of an attribute property of 
    * a SpecificationRootCharacterization-stereotype Comment annotating this package, if any,
    * or that of the SpecificationRoot stereotype applied to this package, if any.
    *
    * An OTI SpecificationRoot attribute property can be specified as 
    * 1) a tag value on an OTI::SpecificationRootCharacterization stereotype applied 
    *    to a comment that annotates this package
    * 2) a tag value on the OTI::SpecificationRoot stereotype applied to the package or 
    * Note that (1) has higher priority than (2).
    *
    * @param self a UML Package
    * @param pf A function to retrieve the value of the OTI SpecificationRoot stereotype property
    *           when the OTI::SpecificationRoot stereotype is applied to the package
    * @param cf A function to retrieve the value of the OTI SpecificationRootCharacterization stereotype property
    *           when the OTI::SpecificationRootCharacterization stereotype is applied to a comment
    *           that uniquely annotates this package
    * @tparam V The type of the OTI SpecificationRoot or SpecificationRootCharacterization attribute property
    * @return In decreasing priority order:
    *         - the value of the OTI SpecificationRootCharacterization attribute property, if available
    *         - the value of the OTI SpecificationRoot if available
    *         - no value
    */
  def oti_attributeValue[V]
  (self: UMLPackage[Uml],
   pf: UMLPackage[Uml] => \/[NonEmptyList[java.lang.Throwable], Option[V]],
   cf: UMLComment[Uml] => \/[NonEmptyList[java.lang.Throwable], Option[V]])
  : NonEmptyList[java.lang.Throwable] \/ Option[V] =
    otiCharacterizations.getOrElse(Map.empty[UMLPackage[Uml], UMLComment[Uml]])
    .get(self)
    .fold[NonEmptyList[java.lang.Throwable] \/ Option[V]](
      getSpecificationRootAnnotatingComment(self)
      .flatMap { oc =>
        oc.fold[NonEmptyList[java.lang.Throwable] \/ Option[V]]({       
          // (1) no value because no SpecificationRoot-stereotyped Comment annotates the package
          // try (2)
          pf(self)
        }){ c =>
          cf(c).flatMap { ov =>
            ov.fold[NonEmptyList[java.lang.Throwable] \/ Option[V]]({
              // (1) no value because the SpecificationRoot-stereotype Comment annotating 
              //     the package does not have a value for the property
              // try (2)
              pf(self)
            }){ v:V =>
              // (1) yields a value
              v.some.right
            }
          }
        }
      }
    ){ c =>
      cf(c).flatMap { ov =>
        ov.fold[NonEmptyList[java.lang.Throwable] \/ Option[V]]({
          // (1) no value because SpecificationRoot-stereotype Comment annotating 
          //     the package does not have a value for the property
          // try (2)
          pf(self)
        }){ v: V =>
          // (1) yields a value
          v.some.right
        }
      }
    }

  /**
    * is this comment representing the characteristics for a single annotated package
    * as the root of a specification publishable artifact?
    *
    * @return True iff the <<OTI::SpecificationRootCharacterization>> stereotype is applied and
    *         the set of annotated elements is a singleton kind of Package
    */
  def getSpecificationRootCharacterizedPackage
  ( self: UMLComment[Uml] )
  : NonEmptyList[java.lang.Throwable] \/ Option[UMLPackage[Uml]] =
    OTI_SPECIFICATION_ROOT_CHARACTERIZATION_S
      .flatMap { s =>
        self.hasStereotype(s)
          .flatMap { isOTICharacterization =>

            if (!isOTICharacterization || 1 != self.annotatedElement.size)
              Option.empty[UMLPackage[Uml]].right
            else
              self.annotatedElement
                .headOption
                .fold[NonEmptyList[java.lang.Throwable] \/  Option[UMLPackage[Uml]]](
                Option.empty[UMLPackage[Uml]].right
              ) {
                case annotatedP: UMLPackage[Uml] =>
                  annotatedP.some.right
                case _ =>
                  Option.empty[UMLPackage[Uml]].right
              }
          }
      }

  /**
    * Find the unique OTI::SpecificationRootCharacterizedPackage-stereotype Comment that annotates this package
    *
    * @return If unique, the OTI::SpecificationRootCharacterizedPackage-stereotype Comment that annotates this package
    */
  def getSpecificationRootAnnotatingComment
  ( self: UMLPackage[Uml] )
  : NonEmptyList[java.lang.Throwable] \/ Option[UMLComment[Uml]] = {
    val c0: NonEmptyList[java.lang.Throwable] \/ Seq[UMLComment[Uml]] =
      Seq().right
    val cN: NonEmptyList[java.lang.Throwable] \/ Seq[UMLComment[Uml]] =
      (c0 /: self.annotatedElement_comment) { (ci, c) =>
      ci.flatMap { _ci: Seq[UMLComment[Uml]] =>
        getSpecificationRootCharacterizedPackage(c).map { _p =>
          if (_p.contains(self))
            _ci :+ c
          else
            _ci
        }
      }
    }
    cN.flatMap { cs: Seq[UMLComment[Uml]] =>
      if (1 == cs.size)
        cs.headOption.right
      else
        Option.empty[UMLComment[Uml]].right
    }
  }

  override def packageURI
  (self: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_URI] =
    for {
      oti_packageURI <- OTI_SPECIFICATION_ROOT_packageURI
      oti_ch_packageURI <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_packageURI
      result <- oti_attributeValue[String](
        self,
        pf = (x: UMLPackage[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_packageURI)
          } yield
            vs.headOption,
        cf = (x: UMLComment[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_ch_packageURI)
          } yield
            vs.headOption
      )
    } yield result.orElse(self.URI).map(_.trim).map(OTI_URI.apply)

  override def documentURL
  (self: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_URL] =
    for {
      oti_documentURL <- OTI_SPECIFICATION_ROOT_documentURL
      oti_ch_documentURL <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_documentURL
      result <- oti_attributeValue[String](
        self,
        pf = (x: UMLPackage[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_documentURL)
          } yield
            vs.headOption,
        cf = (x: UMLComment[Uml]) => for {
          vs <- x.getStereotypeTagPropertyStringValues(oti_ch_documentURL)
        } yield
          vs.headOption
      )
    } yield result.map(_.trim).map(OTI_URL.apply)

  override def nsPrefix
  (self: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_NS_PREFIX] =
    for {
      oti_nsPrefix <- OTI_SPECIFICATION_ROOT_nsPrefix
      oti_ch_nsPrefix <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_nsPrefix
      result <- oti_attributeValue[String](
        self,
        pf = (x: UMLPackage[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_nsPrefix)
          } yield
            vs.headOption,
        cf = (x: UMLComment[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_ch_nsPrefix)
          } yield
            vs.headOption
      )
    } yield result.map(_.trim).map(OTI_NS_PREFIX.apply)

  override def uuidPrefix
  (self: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_UUID_PREFIX] =
    for {
      oti_uuidPrefix <- OTI_SPECIFICATION_ROOT_uuidPrefix
      oti_ch_uuidPrefix <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_uuidPrefix
      result <- oti_attributeValue[String](
        self,
        pf = (x: UMLPackage[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_uuidPrefix)
          } yield
            vs.headOption,
        cf = (x: UMLComment[Uml]) =>
          for {
            vs <- x.getStereotypeTagPropertyStringValues(oti_ch_uuidPrefix)
          } yield
            vs.headOption
      )
    } yield result.map(_.trim).map(OTI_UUID_PREFIX.apply)

  override def artifactKind
  (self: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[OTIArtifactKind] = {
    val kind: NonEmptyList[java.lang.Throwable] \/ Option[UMLEnumerationLiteral[Uml]] =
      for {
        oti_artifactKind <- OTI_SPECIFICATION_ROOT_artifactKind
        oti_ch_artifactKind <- OTI_SPECIFICATION_ROOT_CHARACTERIZATION_artifactKind
        result <- oti_attributeValue[UMLEnumerationLiteral[Uml]](
          self,
          pf = (x: UMLPackage[Uml]) =>
            for {
              vs <- x.getStereotypeTagPropertyEnumValues(oti_artifactKind)
            } yield
              vs.headOption,
          cf = (x: UMLComment[Uml]) =>
            for {
              vs <- x.getStereotypeTagPropertyEnumValues(oti_ch_artifactKind)
            } yield
              vs.headOption
        )
      } yield result

    kind.flatMap( _.fold[NonEmptyList[java.lang.Throwable] \/ Option[OTIArtifactKind]](
      Option.empty[OTIArtifactKind].right
    ) { kind: UMLEnumerationLiteral[Uml] =>
      if (OTI_ARTIFACT_KIND_SPECIFIED_METAMODEL.exists(_ == kind))
        OTISerializableMetamodelArtifactKind().some.right
      else if (OTI_ARTIFACT_KIND_SPECIFIED_PROFILE.exists(_ == kind))
        OTISerializableProfileArtifactKind().some.right
      else if (OTI_ARTIFACT_KIND_SPECIFIED_MODEL_LIBRARY.exists(_ == kind))
        OTISerializableModelLibraryArtifactKind().some.right
      else if (OTI_ARTIFACT_KIND_IMPLEMENTED_METAMODEL.exists(_ == kind))
        OTIBuiltInMetamodelArtifactKind().some.right
      else if (OTI_ARTIFACT_KIND_IMPLEMENTED_PROFILE.exists(_ == kind))
        OTIBuiltInProfileArtifactKind().some.right
      else if (OTI_ARTIFACT_KIND_IMPLEMENTED_MODEL_LIBRARY.exists(_ == kind))
        OTIBuiltInModelLibraryArtifactKind().some.right
      else
        NonEmptyList(
          UMLError.illegalElementError[Uml, UMLElement[Uml]](
            s"Unrecognized OTI ArtifactKind: $kind",
            Iterable(self)
          )
        ).left

    })
  }

  override def getSpecificationRootCharacteristics
  (self: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[OTISpecificationRootCharacteristics] = {
    for {
      ouri <- packageURI(self)
      ourl <- documentURL(self)
      okind <- artifactKind(self)
      ons <- nsPrefix(self)
      ouuid <- uuidPrefix(self)
    } yield {
      val characteristics =
        (ouri |@| ourl |@| okind |@| ons |@| ouuid) { OTISpecificationRootCharacteristics }
      characteristics
    }
  }

  override def xmiID
  (self: UMLElement[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_ID] =
    OTI_IDENTITY_xmiID
      .flatMap{ p: UMLProperty[Uml] =>
        self.getStereotypeTagPropertyStringValues(p).map(_.headOption.map(_.trim).map(OTI_ID.apply))
      }

  override def xmiUUID
  (self: UMLElement[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_UUID] =
    OTI_IDENTITY_xmiUUID
      .flatMap{ p: UMLProperty[Uml] =>
        self.getStereotypeTagPropertyStringValues(p).map(_.headOption.map(_.trim).map(OTI_UUID.apply))
      }

  /**
    * The OMG Tool-neutral Interchange API for OMG UML 2.5 compliant modeling tools.
    * The tool-specific OTI adapter must provide the corresponding tool-specific OTI profile.
    */
  val OTI_PROFILE
  : NonEmptyList[java.lang.Throwable] \/ UMLProfile[Uml]

  /**
    * OTI::SpecificationRoot stereotype
    *
    * An OTI::SpecificationRoot-stereotyped package indicates that
    * the package corresponds to a published artifact from a specification.
    * The kind of artifact is specified via the `artifactKind` tag property.
    */
  val OTI_SPECIFICATION_ROOT_S
  : NonEmptyList[java.lang.Throwable] \/ UMLStereotype[Uml]

  /**
    * OTI::SpecificationRoot::packageURI property
    *
    * If specified, overrides the Package::URI on the package.
    * When serializing an OTI::SpecificationRoot-stereotyped package,
    * the Package::URI of the serialized package will be the value
    * of the OTI::SpecificationRoot::packageURI, if specified,
    * or that of Package::URI. It is an error if both are unspecified.
    */
  val OTI_SPECIFICATION_ROOT_packageURI
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRoot::documentURL property
    *
    * When serializing an OTI::SpecificationRoot-stereotyped package,
    * the package will be serialized as a document at the
    * OTI::SpecificationRoot::documentURL
    */
  val OTI_SPECIFICATION_ROOT_documentURL
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRoot::nsPrefix property
    *
    * The namespace prefix used for the serialization of an OTI::SpecificationRoot-stereotyped
    * package
    */
  val OTI_SPECIFICATION_ROOT_nsPrefix
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRoot::uuidPrefix property
    *
    * The prefix added to the xmi:id to produce the xmi:uuid
    * of every element in an OTI::SpecificationRoot-stereotyped
    * package
    */
  val OTI_SPECIFICATION_ROOT_uuidPrefix
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRoot::artifactKind property
    * a 2x2 matrix describing what an OTI::SpecificationRoot-stereotyped
    * package is a model of:
    * - Specified vs. Implemented
    * - Metamodel, Profile, Model Library
    */
  val OTI_SPECIFICATION_ROOT_artifactKind
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRootCharacterization stereotype
    *
    * An OTI::SpecificationRootCharacterization-stereotyped comment annotating a single package
    * indicates that the annotated package corresponds to a published artifact from a specification.
    * The kind of artifact is specified via the `artifactKind` tag property.
    */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_S
  : NonEmptyList[java.lang.Throwable] \/ UMLStereotype[Uml]

  /**
    * OTI::SpecificationRootCharacterization::packageURI property
    *
    * If specified, overrides the Package::URI on the annotated package.
    * When serializing an the annotated package by an OTI::SpecificationRootCharacterization-stereotyped comment,
    * the Package::URI of the serialized annotated package will be the value
    * of the OTI::SpecificationRootCharacterization::packageURI, if specified,
    * or that of Package::URI. It is an error if both are unspecified.
    */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_packageURI
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRootCharacterization::documentURL property
    *
    * When serializing a package annotated by an OTI::SpecificationRootCharacterization-stereotyped comment,
    * the annotated package will be serialized as a document at the
    * OTI::SpecificationRootCharacterization::documentURL
    */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_documentURL
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRootCharacterization::nsPrefix property
    *
    * The namespace prefix used for the serialization of a package annotated
    * by an OTI::SpecificationRootCharacterization-stereotyped comment
    */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_nsPrefix
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRootCharacterization::uuidPrefix property
    *
    * The prefix added to the xmi:id to produce the xmi:uuid
    * of every element in the scope of a package annotated
    * by an OTI::SpecificationRootCharacterization-stereotyped comment
    */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_uuidPrefix
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::SpecificationRootCharacterization::artifactKind property
    * a 2x2 matrix describing what the annotated package of an
    * OTI::SpecificationRootCharacterization-stereotyped comment is a model of:
    * - Specified vs. Implemented
    * - Metamodel, Profile, Model Library
    */
  val OTI_SPECIFICATION_ROOT_CHARACTERIZATION_artifactKind
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    *
    */
  val OTI_ARTIFACT_KIND
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumeration[Uml]

  val OTI_ARTIFACT_KIND_SPECIFIED_METAMODEL
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_SPECIFIED_PROFILE
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_SPECIFIED_MODEL_LIBRARY
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_IMPLEMENTED_METAMODEL
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_IMPLEMENTED_PROFILE
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumerationLiteral[Uml]

  val OTI_ARTIFACT_KIND_IMPLEMENTED_MODEL_LIBRARY
  : NonEmptyList[java.lang.Throwable] \/ UMLEnumerationLiteral[Uml]

  /**
    * OTI::Identity stereotype
    *
    * If applied to an element within an OTI::SpecificationRoot-stereotyped
    * containing package, allows overriding xmi:ID generation,
    * xmi:UUID generation or both
    */
  val OTI_IDENTITY_S
  : NonEmptyList[java.lang.Throwable] \/ UMLStereotype[Uml]

  /**
    * OTI::Identity::xmiID property
    *
    * If specified on an element, use the value as xmi:ID
    * Instead of generating one
    */
  val OTI_IDENTITY_xmiID
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]

  /**
    * OTI::Identity::xmiUUID property
    *
    * If specified on an element, use the value as xmi:UUID
    * Instead of generating one based on the uuid prefix
    * of the OTI::SpecificationRoot-stereotyped
    * containing package and the element's xmi:ID
    */
  val OTI_IDENTITY_xmiUUID
  : NonEmptyList[java.lang.Throwable] \/ UMLProperty[Uml]
}