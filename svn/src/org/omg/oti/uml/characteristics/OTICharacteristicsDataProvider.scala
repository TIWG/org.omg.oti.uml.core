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

import org.omg.oti.json.common._
import org.omg.oti.json.common.{OTIDocumentSetConfiguration,OTISpecificationRootCharacteristics}
import org.omg.oti.json.common.OTIPrimitiveTypes._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.collection.immutable.{Map,Set,Vector}
import scala.{Option,Some}
import scala.Predef.{Map => _, Set => _, _}
import scala.reflect.runtime.universe._
import scala.reflect.classTag
import scalaz.{@@, \/, \/-, \&/, Semigroup}

trait OTICharacteristicsDataProvider[Uml <: UML]
extends OTICharacteristicsProvider[Uml] {

  implicit val umlOps: UMLOps[Uml]
  implicit val umlTag: TypeTag[Uml]
  implicit val umlPackageTag: TypeTag[UMLPackage[Uml]]
  implicit val opsTag: TypeTag[UMLOps[Uml]]

  val data: Vector[OTIDocumentSetConfiguration]

  protected implicit def Package2SpecificationRootCharacteristicsSemigroup
  : Semigroup[Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]]
  = Semigroup.instance { (m1, m2) =>
    require((m1.keySet & m2.keySet).isEmpty)
    m1 ++ m2
  }

  override def getAllOTIBuiltInDocumentPackages
  : Set[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]
  = {
    val allPackages = umlOps.allInstances[UMLPackage[Uml]]("Package", Option.empty[UMLElement[Uml]]).getOrElse(Set())

    val builtIns
    : Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]
    = allPackages
      .flatMap { pkg =>
        data
          .flatMap(_.documents)
          .find(_.toolSpecificPackageID == pkg.toolSpecific_id)
          .fold[Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]](
          Map()
        ) { documentConfig =>
          documentConfig.otiCharacteristics.artifactKind match {
            case _: OTIBuiltInArtifactKind =>
              Map(pkg -> documentConfig.otiCharacteristics)
            case _ =>
              Map()
          }
        }
      }
      .toMap

    \&/.That(builtIns)
  }

  override def getAllOTISerializableDocumentPackages
  : Set[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]
  = {
    val allPackages = umlOps.allInstances[UMLPackage[Uml]]("Package", Option.empty[UMLElement[Uml]]).getOrElse(Set())

    val serializables
    : Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]
    = allPackages
      .flatMap { pkg =>
        data
          .flatMap(_.documents)
          .find(_.toolSpecificPackageID == pkg.toolSpecific_id)
          .fold[Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]](
          Map()
        ) { documentConfig =>
          documentConfig.otiCharacteristics.artifactKind match {
            case _: OTISerializableArtifactKind =>
              Map(pkg -> documentConfig.otiCharacteristics)
            case _ =>
              Map()
          }
        }
      }
      .toMap

    \&/.That(serializables)
  }

  override def getSpecificationRootCharacteristics
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[OTISpecificationRootCharacteristics]
  = \/-(data.flatMap(_.documents).find(_.toolSpecificPackageID == e.toolSpecific_id).map(_.otiCharacteristics))

  override def packageURI
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URI]
  = getSpecificationRootCharacteristics(e)
      .map(_.fold[Option[String @@ OTI_URI]]( e.URI.map(_.trim).map(OTI_URI.apply) ){
      ch => Some(ch.packageURI)
    })

  override
  def documentURL
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_URL]
  = getSpecificationRootCharacteristics(e).map(_.map(_.documentURL))

  override def artifactKind
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[OTIArtifactKind]
  = getSpecificationRootCharacteristics(e).map(_.map(_.artifactKind))

  override def nsPrefix
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_NS_PREFIX]
  = getSpecificationRootCharacteristics(e).map(_.map(_.nsPrefix))

  override def uuidPrefix
  (e: UMLPackage[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_UUID_PREFIX]
  = getSpecificationRootCharacteristics(e).map(_.map(_.uuidPrefix))

  override def xmiID
  (e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_ID]
  = {
    val pkgIDs = e.owningPackages.map(_.toolSpecific_id)
    \/-(
      data
      .flatMap(_.documents)
      .find { d => pkgIDs.contains(d.toolSpecificPackageID) }
      .flatMap { d =>
        d.overrideID
          .find(_.toolSpecificID == e.toolSpecific_id)
          .map(_.oti_id)
      })
  }

  override def xmiUUID
  (e: UMLElement[Uml])
  : Set[java.lang.Throwable] \/ Option[String @@ OTI_UUID]
  = {
    val pkgIDs = e.owningPackages.map(_.toolSpecific_id)
    \/-(
      data
      .flatMap(_.documents)
      .find { d => pkgIDs.contains(d.toolSpecificPackageID) }
      .flatMap { d =>
        d.overrideUUID
          .find(_.toolSpecificID == e.toolSpecific_id)
          .map(_.oti_uuid)
      })
  }

}