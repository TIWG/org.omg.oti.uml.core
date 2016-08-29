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
// End of user code

/**
  * InformationItems represent many kinds of information that can flow from sources to targets in very abstract ways.? They represent the kinds of information that may move within a system, but do not elaborate details of the transferred information.? Details of transferred information are the province of other Classifiers that may ultimately define InformationItems.? Consequently, InformationItems cannot be instantiated and do not themselves have features, generalizations, or associations.?An important use of InformationItems is to represent information during early design stages, possibly before the detailed modeling decisions that will ultimately define them have been made. Another purpose of InformationItems is to abstract portions of complex models in less precise, but perhaps more general and communicable, ways. 
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLInformationItemOps[Uml <: UML] { self: UMLInformationItem[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * An informationItem has no feature, no generalization, and no associations.
    *
    * <!-- Start of user code doc for validate_has_no -->
    * <!-- End of user code doc for validate_has_no -->
    *
    * {{{
    * OCL Body self.generalization->isEmpty() and self.feature->isEmpty()
    * }}}
    */
  def validate_has_no: Boolean = {
    // Start of user code for "has_no"
    ???
    // End of user code
  }

  /**
    * It is not instantiable.
    *
    * <!-- Start of user code doc for validate_not_instantiable -->
    * <!-- End of user code doc for validate_not_instantiable -->
    *
    * {{{
    * OCL Body isAbstract
    * }}}
    */
  def validate_not_instantiable: Boolean = {
    // Start of user code for "not_instantiable"
    ???
    // End of user code
  }

  /**
    * The sources and targets of an information item (its related information flows) must designate subsets of the sources and targets of the representation information item, if any. The Classifiers that can realize an information item can only be of the following kind: Class, Interface, InformationItem, Signal, Component.
    *
    * <!-- Start of user code doc for validate_sources_and_targets -->
    * <!-- End of user code doc for validate_sources_and_targets -->
    *
    * {{{
    * OCL Body (self.represented->select(oclIsKindOf(InformationItem))->forAll(p |
    *   p.conveyingFlow.source->forAll(q | self.conveyingFlow.source->includes(q)) and
    *     p.conveyingFlow.target->forAll(q | self.conveyingFlow.target->includes(q)))) and
    *       (self.represented->forAll(oclIsKindOf(Class) or oclIsKindOf(Interface) or
    *         oclIsKindOf(InformationItem) or oclIsKindOf(Signal) or oclIsKindOf(Component)))
    * }}}
    */
  def validate_sources_and_targets: Boolean = {
    // Start of user code for "sources_and_targets"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLInformationItemOps
