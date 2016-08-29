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
// End of user code

/**
  * A Variable is a ConnectableElement that may store values during the execution of an Activity. Reading and writing the values of a Variable provides an alternative means for passing data than the use of ObjectFlows. A Variable may be owned directly by an Activity, in which case it is accessible from anywhere within that activity, or it may be owned by a StructuredActivityNode, in which case it is only accessible within that node.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLVariableOps[Uml <: UML] { self: UMLVariable[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * An Activity that owns the Variable.
    *
    * <!-- Start of user code doc for activityScope -->
    * <!-- End of user code doc for activityScope -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLActivity.variable
    */
  def activityScope: Option[UMLActivity[Uml]] = namespace.selectByKindOf { case x: UMLActivity[Uml] => x }

  /**
    * A StructuredActivityNode that owns the Variable.
    *
    * <!-- Start of user code doc for scope -->
    * <!-- End of user code doc for scope -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredActivityNode.variable
    */
  def scope: Option[UMLStructuredActivityNode[Uml]] = namespace.selectByKindOf { case x: UMLStructuredActivityNode[Uml] => x }

  /**
    * A Variable is accessible by Actions within its scope (the Activity or StructuredActivityNode that owns it).
    *
    * <!-- Start of user code doc for isAccessibleBy -->
    * <!-- End of user code doc for isAccessibleBy -->
    *
    * UML Operation ordered="false" unique="true" multiplicity="1..1"
    * {{{
    * OCL Body result = (if scope<>null then scope.allOwnedNodes()->includes(a)
    * else a.containingActivity()=activityScope
    * endif)
    * }}}
    */
  def isAccessibleBy(a: Option[UMLAction[Uml]]): Boolean = {
    // Start of user code for "isAccessibleBy"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLVariableOps
