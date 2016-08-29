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
import scala.Boolean
import scala.Predef.???
import scala.collection.immutable.Set
// End of user code

/**
  * A Class classifies a set of objects and specifies the features that characterize the structure and behavior of those objects.  A Class may have an internal structure and Ports.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLClassOps[Uml <: UML] { self: UMLClass[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * This property is used when the Class is acting as a metaclass. It references the Extensions that specify additional properties of the metaclass. The property is derived from the Extensions whose memberEnds are typed by the Class.
    *
    * <!-- Start of user code doc for extension -->
    * <!-- End of user code doc for extension -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLExtension.metaclass
    * {{{
    * OCL Body result = (Extension.allInstances()->select(ext | 
    *   let endTypes : Sequence(Classifier) = ext.memberEnd->collect(type.oclAsType(Classifier)) in
    *   endTypes->includes(self) or endTypes.allParents()->includes(self) ))
    * }}}
    */
  def extension: Set[UMLExtension[Uml]] = {
    // Start of user code for "extension"
    ???
    // End of user code
  }

  /**
    * The Receptions owned by the Class.
    *
    * <!-- Start of user code doc for ownedReception -->
    * <!-- End of user code doc for ownedReception -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLReception.ownedReception_class
    */
  def ownedReception: Set[UMLReception[Uml]] = feature.selectByKindOf { case x: UMLReception[Uml] => x }

  /**
    * The superclasses of a Class, derived from its Generalizations.
    *
    * <!-- Start of user code doc for superClass -->
    * <!-- End of user code doc for superClass -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.superClass_class
    * {{{
    * OCL Body result = (self.general()->select(oclIsKindOf(Class))->collect(oclAsType(Class))->asSet())
    * }}}
    */
  def superClass: Set[UMLClass[Uml]] = general.selectByKindOf { case x: UMLClass[Uml] => x }

  /**
    * <!-- Start of user code doc for superClass_class -->
    * <!-- End of user code doc for superClass_class -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLClass.superClass
    */
  def superClass_class: Set[UMLClass[Uml]] = general_classifier.selectByKindOf { case x: UMLClass[Uml] => x }

  /**
    * Only an active Class may own Receptions and have a classifierBehavior.
    *
    * <!-- Start of user code doc for validate_passive_class -->
    * <!-- End of user code doc for validate_passive_class -->
    *
    * {{{
    * OCL Body not isActive implies (ownedReception->isEmpty() and classifierBehavior = null)
    * }}}
    */
  def validate_passive_class: Boolean = {
    // Start of user code for "passive_class"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLClassOps
