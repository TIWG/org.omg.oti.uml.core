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
import scala.Option
import scala.Predef.???
import scala.collection.immutable.Seq
// End of user code

/**
  * A StartObjectBehaviorAction is an InvocationAction that starts the execution either of a directly instantiated Behavior or of the classifierBehavior of an object. Argument values may be supplied for the input Parameters of the Behavior. If the Behavior is invoked synchronously, then output values may be obtained for output Parameters.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStartObjectBehaviorActionOps[Uml <: UML] { self: UMLStartObjectBehaviorAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * If the type of the object InputPin is a Behavior, then that Behavior. Otherwise, if the type of the object InputPin is a BehavioredClassifier, then the classifierBehavior of that BehavioredClassifier.
    *
    * <!-- Start of user code doc for behavior -->
    * <!-- End of user code doc for behavior -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="0..1"
    * {{{
    * OCL Body result = (if object.type.oclIsKindOf(Behavior) then
    *   object.type.oclAsType(Behavior)
    * else if object.type.oclIsKindOf(BehavioredClassifier) then
    *   object.type.oclAsType(BehavioredClassifier).classifierBehavior
    * else
    *   null
    * endif
    * endif)
    * }}}
    */
  def behavior: Option[UMLBehavior[Uml]] = {
    // Start of user code for "behavior"
    ???
    // End of user code
  }

  /**
    * Return the in and inout ownedParameters of the Behavior being called.
    *
    * <!-- Start of user code doc for inputParameters -->
    * <!-- End of user code doc for inputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self.behavior().inputParameters())
    * }}}
    */
  override def inputParameters: Seq[UMLParameter[Uml]] = {
    // Start of user code for "inputParameters"
    ???
    // End of user code
  }

  /**
    * Return the inout, out and return ownedParameters of the Behavior being called.
    *
    * <!-- Start of user code doc for outputParameters -->
    * <!-- End of user code doc for outputParameters -->
    *
    * UML Operation ordered="true" unique="true" multiplicity="0..*"
    * {{{
    * OCL Body result = (self.behavior().outputParameters())
    * }}}
    */
  override def outputParameters: Seq[UMLParameter[Uml]] = {
    // Start of user code for "outputParameters"
    ???
    // End of user code
  }

  /**
    * The multiplicity of the object InputPin must be 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity_of_object -->
    * <!-- End of user code doc for validate_multiplicity_of_object -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity_of_object: Boolean = {
    // Start of user code for "multiplicity_of_object"
    ???
    // End of user code
  }

  /**
    * A StartObjectBehaviorAction may not specify onPort.
    *
    * <!-- Start of user code doc for validate_no_onport -->
    * <!-- End of user code doc for validate_no_onport -->
    *
    * {{{
    * OCL Body onPort->isEmpty()
    * }}}
    */
  def validate_no_onport: Boolean = {
    // Start of user code for "no_onport"
    ???
    // End of user code
  }

  /**
    * The type of the object InputPin must be either a Behavior or a BehavioredClassifier with a classifierBehavior.
    *
    * <!-- Start of user code doc for validate_type_of_object -->
    * <!-- End of user code doc for validate_type_of_object -->
    *
    * {{{
    * OCL Body self.behavior()<>null
    * }}}
    */
  def validate_type_of_object: Boolean = {
    // Start of user code for "type_of_object"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStartObjectBehaviorActionOps
