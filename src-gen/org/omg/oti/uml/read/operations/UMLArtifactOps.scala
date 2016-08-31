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

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.Option
import scala.collection.immutable.Set
// End of user code

/**
  * An artifact is the specification of a physical piece of information that is used or produced by a software development process, or by deployment and operation of a system. Examples of artifacts include model files, source files, scripts, and binary executable files, a table in a database system, a development deliverable, or a word-processing document, a mail message.An artifact is the source of a deployment to a node.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLArtifactOps[Uml <: UML] { self: UMLArtifact[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The set of model elements that are manifested in the Artifact. That is, these model elements are utilized in the construction (or generation) of the artifact.
    *
    * <!-- Start of user code doc for manifestation -->
    * <!-- End of user code doc for manifestation -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLManifestation.manifestation_artifact
    */
  def manifestation: Set[UMLManifestation[Uml]] = ownedElement.selectByKindOf { case x: UMLManifestation[Uml] => x }

  /**
    * The Artifacts that are defined (nested) within the Artifact. The association is a specialization of the ownedMember association from Namespace to NamedElement.
    *
    * <!-- Start of user code doc for nestedArtifact -->
    * <!-- End of user code doc for nestedArtifact -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLArtifact.nestedArtifact_artifact
    */
  def nestedArtifact: Set[UMLArtifact[Uml]] = ownedMember.selectByKindOf { case x: UMLArtifact[Uml] => x }

  /**
    * <!-- Start of user code doc for nestedArtifact_artifact -->
    * <!-- End of user code doc for nestedArtifact_artifact -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLArtifact.nestedArtifact
    */
  def nestedArtifact_artifact: Option[UMLArtifact[Uml]] = namespace.selectByKindOf { case x: UMLArtifact[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLArtifactOps
