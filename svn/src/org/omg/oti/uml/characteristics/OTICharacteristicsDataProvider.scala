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

import org.omg.oti.json.common._
import org.omg.oti.json.common.{OTIDocumentSetConfiguration,OTISpecificationRootCharacteristics}
import org.omg.oti.json.common.OTIPrimitiveTypes._
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.collection.immutable.{Map,Set,Vector}
import scala.{Option,Some}
import scala.Predef.{Map => _, Set => _, _}
import scala.reflect.runtime.universe._
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