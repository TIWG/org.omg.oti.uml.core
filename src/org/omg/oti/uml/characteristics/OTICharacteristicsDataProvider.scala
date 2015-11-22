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
import org.omg.oti.uml.read.api._
import org.omg.oti.uml.read.operations.UMLOps

import scala.collection.immutable.{Map,Set}
import scala.Option
import scala.Predef.{Map => _, Set => _, _}
import scala.reflect.runtime.universe._
import scala.reflect.classTag
import scalaz.{@@, \/, \&/, NonEmptyList, Semigroup}

trait OTICharacteristicsDataProvider[Uml <: UML]
extends OTICharacteristicsProvider[Uml] {

  implicit val umlOps: UMLOps[Uml]
  implicit val umlTag: TypeTag[Uml]
  implicit val umlPackageTag: TypeTag[UMLPackage[Uml]]
  implicit val opsTag: TypeTag[UMLOps[Uml]]

  /**
    * Provides the OTI Specification Root Characteristics for UML Packages identified by their OTI tool-specific ID/UUID
    *
    * Key: The OTI tool-specific ID/UUID pair identifying a UML Package
    * Value: The OTI Specification Root Characteristics for the identified UML Package
    */
  val otiCharacteristicsData: Map[OTI_ID_UUID, OTISpecificationRootCharacteristics]

  /**
    * Specifies a mapping from OTI tool-specific ID/UUID to OTI xmi ID/UUID
    */
  val toolSpecific2xmi_id_uuid: Map[OTI_ID_UUID, OTI_ID_UUID]

  protected implicit def Package2SpecificationRootCharacteristicsSemigroup
  : Semigroup[Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]] =
  Semigroup.instance { (m1, m2) =>
    require((m1.keySet & m2.keySet).isEmpty)
    m1 ++ m2
  }

  override def getAllOTIBuiltInDocumentPackages
  : NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] = {
    val allPackages = umlOps.allInstances[UMLPackage[Uml]]("Package", Option.empty[UMLElement[Uml]]).getOrElse(Set())

    val b0: NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] =
      \&/.That(Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]())

    val bN: NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] =
      (b0 /: allPackages) { (bi, pkg) =>
        val inc: NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] =
        pkg.toolSpecific_id_uuid.toThese.map { oti_id_uuid =>
          otiCharacteristicsData.get(oti_id_uuid).fold[Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]](
            Map()
          ) { characteristics =>
            characteristics.artifactKind match {
              case _: OTIBuiltInArtifactKind =>
                Map(pkg -> characteristics)
              case _ =>
                Map()
            }
          }
        }

        bi append inc
      }
    bN
  }

  override def getAllOTISerializableDocumentPackages
  : NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] ={
    val allPackages = umlOps.allInstances[UMLPackage[Uml]]("Package", Option.empty[UMLElement[Uml]]).getOrElse(Set())

    val b0: NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] =
      \&/.That(Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]())

    val bN: NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] =
      (b0 /: allPackages) { (bi, pkg) =>
        val inc: NonEmptyList[java.lang.Throwable] \&/ Map[UMLPackage[Uml], OTISpecificationRootCharacteristics] =
          pkg.toolSpecific_id_uuid.toThese.map { oti_id_uuid =>
            otiCharacteristicsData.get(oti_id_uuid).fold[Map[UMLPackage[Uml], OTISpecificationRootCharacteristics]](
              Map()
            ) { characteristics =>
              characteristics.artifactKind match {
                case _: OTISerializableArtifactKind =>
                  Map(pkg -> characteristics)
                case _ =>
                  Map()
              }
            }
          }

        bi append inc
      }
    bN
  }

  override def getSpecificationRootCharacteristics
  (e: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[OTISpecificationRootCharacteristics] =
    e.toolSpecific_id_uuid.map(otiCharacteristicsData.get)

  override def packageURI
  (e: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_URI] =
    getSpecificationRootCharacteristics(e)
      .map(_.fold[Option[String @@ OTI_URI]]( e.URI.map(_.trim).map(OTI_URI.apply) ){
      ch => Some(ch.packageURI)
    })

  override
  def documentURL
  (e: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_URL] =
    getSpecificationRootCharacteristics(e).map(_.map(_.documentURL))

  override def artifactKind
  (e: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[OTIArtifactKind] =
    getSpecificationRootCharacteristics(e).map(_.map(_.artifactKind))

  override def nsPrefix
  (e: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_NS_PREFIX] =
    getSpecificationRootCharacteristics(e).map(_.map(_.nsPrefix))

  override def uuidPrefix
  (e: UMLPackage[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_UUID_PREFIX] =
    getSpecificationRootCharacteristics(e).map(_.map(_.uuidPrefix))

  override def xmiID
  (e: UMLElement[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_ID] =
    e.toolSpecific_id_uuid.map(toolSpecific2xmi_id_uuid.get).map(_.flatMap(_.a))

  override def xmiUUID
  (e: UMLElement[Uml])
  : NonEmptyList[java.lang.Throwable] \/ Option[String @@ OTI_UUID] =
    e.toolSpecific_id_uuid.map(toolSpecific2xmi_id_uuid.get).map(_.flatMap(_.b))

}