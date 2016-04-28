/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  Copyright (c) 2015, Airbus Operations S.A.S.
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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.{Set => _, _}
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
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