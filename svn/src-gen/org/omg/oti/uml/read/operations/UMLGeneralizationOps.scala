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
import scala.language.postfixOps
import scala.Option
// End of user code

/**
  * A Generalization is a taxonomic relationship between a more general Classifier and a more specific Classifier. Each instance of the specific Classifier is also an instance of the general Classifier. The specific Classifier inherits the features of the more general Classifier. A Generalization is owned by the specific Classifier.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLGeneralizationOps[Uml <: UML] { self: UMLGeneralization[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The general classifier in the Generalization relationship.
    *
    * <!-- Start of user code doc for general -->
    * <!-- End of user code doc for general -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.general_generalization
    */
  def general: Option[UMLClassifier[Uml]] = target.selectByKindOf { case x: UMLClassifier[Uml] => x } headOption

  /**
    * The specializing Classifier in the Generalization relationship.
    *
    * <!-- Start of user code doc for specific -->
    * <!-- End of user code doc for specific -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClassifier.generalization
    */
  def specific: Option[UMLClassifier[Uml]] = owner.selectByKindOf { case x: UMLClassifier[Uml] => x }

  // Start of user code for additional features
  // End of user code
} //UMLGeneralizationOps
