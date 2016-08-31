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
import scala.Predef.{Set => _, _}
// End of user code

/**
  * A model element that has both Association and Class properties. An AssociationClass can be seen as an Association that also has Class properties, or as a Class that also has Association properties. It not only connects a set of Classifiers but also defines a set of Features that belong to the Association itself and not to any of the associated Classifiers.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLAssociationClassOps[Uml <: UML] { self: UMLAssociationClass[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * An AssociationClass cannot be defined between itself and something else.
    *
    * <!-- Start of user code doc for validate_cannot_be_defined -->
    * <!-- End of user code doc for validate_cannot_be_defined -->
    *
    * {{{
    * OCL Body self.endType()->excludes(self) and self.endType()->collect(et|et.oclAsType(Classifier).allParents())->flatten()->excludes(self)
    * }}}
    */
  def validate_cannot_be_defined: Boolean = {
    // Start of user code for "cannot_be_defined"
    !self.endType.contains(self) &&
    !self.endType.collect{ case c: UMLClassifier[Uml] => c.allParents }.flatten.contains(self)
    // End of user code
  }

  /**
    * The owned attributes and owned ends of an AssociationClass are disjoint.
    *
    * <!-- Start of user code doc for validate_disjoint_attributes_ends -->
    * <!-- End of user code doc for validate_disjoint_attributes_ends -->
    *
    * {{{
    * OCL Body ownedAttribute->intersection(ownedEnd)->isEmpty()
    * }}}
    */
  def validate_disjoint_attributes_ends: Boolean = {
    // Start of user code for "disjoint_attributes_ends"
    ownedAttribute.intersect(ownedEnd.toSeq).isEmpty
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLAssociationClassOps
