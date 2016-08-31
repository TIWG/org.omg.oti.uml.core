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
import org.omg.oti.uml.xmi.IDGenerator
import scala.Option
import scala.Predef.String
import scala.collection.immutable.Set
import scala.collection.immutable.Seq
import scalaz._, Scalaz._

// End of user code

/**
  * A Dependency is a Relationship that signifies that a single model Element or a set of model Elements requires other model Elements for their specification or implementation. This means that the complete semantics of the client Element(s) are either semantically or structurally dependent on the definition of the supplier Element(s).
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLDependencyOps[Uml <: UML] { self: UMLDependency[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The Element(s) dependent on the supplier Element(s). In some cases (such as a trace Abstraction) the assignment of direction (that is, the designation of the client Element) is at the discretion of the modeler and is a stipulation.
    *
    * <!-- Start of user code doc for client -->
    * <!-- End of user code doc for client -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.clientDependency
    */
  def client: Set[UMLNamedElement[Uml]] = source.selectByKindOf { case x: UMLNamedElement[Uml] => x }

  /**
    * The Element(s) on which the client Element(s) depend in some respect. The modeler may stipulate a sense of Dependency direction suitable for their domain.
    *
    * <!-- Start of user code doc for supplier -->
    * <!-- End of user code doc for supplier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLNamedElement.supplier_supplierDependency
    */
  def supplier: Set[UMLNamedElement[Uml]] = target.selectByKindOf { case x: UMLNamedElement[Uml] => x }

  /**
    * <!-- Start of user code doc for roleBinding_collaborationUse -->
    * <!-- End of user code doc for roleBinding_collaborationUse -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLCollaborationUse.roleBinding
    */
  def roleBinding_collaborationUse: Option[UMLCollaborationUse[Uml]] = owner.selectByKindOf { case x: UMLCollaborationUse[Uml] => x }

  // Start of user code for additional features

  /**
   * TIWG: see UMLUtil, Rule #3
   */
  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ String =
  for {
    key <- element_xmiOrderingKey
    cs <- {
            val cks0: Set[java.lang.Throwable] \/ Seq[String] = Seq().right
            val cksN = (cks0 /: client) { (ck, c) =>
              (ck |@| c.xmiOrderingKey()) { (_ck, _c) => _ck :+ _c }
            }
            cksN.map(_.mkString("_", "_", "-"))
          }
    ss <- {
            val sks0: Set[java.lang.Throwable] \/ Seq[String] = Seq().right
            val sksN = (sks0 /: supplier) { (sk, s) =>
              (sk |@| s.xmiOrderingKey()) { (_sk, _s) => _sk :+ _s }
            }
            sksN.map(_.mkString("_", "_", "-"))
          }
  } yield key + cs + ss

  // End of user code
} //UMLDependencyOps
