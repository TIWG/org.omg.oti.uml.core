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

package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._

import scala.{AnyVal,Option,Unit}
import scala.Predef.String
import scala.collection.immutable.{Seq,Set}
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ArtifactUpdater[Uml <: UML](val domain: UMLArtifact[Uml]) extends AnyVal {

  def links_Artifact_artifact_compose_manifestation_Manifestation
  (range: Set[UMLManifestation[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Artifact_artifact_compose_manifestation_Manifestation(domain, range)

  def links_Artifact_artifact_compose_nestedArtifact_Artifact
  (range: Set[UMLArtifact[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Artifact_artifact_compose_nestedArtifact_Artifact(domain, range)

  def links_Artifact_artifact_compose_ownedAttribute_Property
  (range: Seq[UMLProperty[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Artifact_artifact_compose_ownedAttribute_Property(domain, range)

  def links_Artifact_artifact_compose_ownedOperation_Operation
  (range: Seq[UMLOperation[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Artifact_artifact_compose_ownedOperation_Operation(domain, range)

  def setFileName
  (fileName: Option[String])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Artifact_fileName(domain, fileName)
}
