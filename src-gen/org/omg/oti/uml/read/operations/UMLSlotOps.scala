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
import scala.Predef.String
import scala.Option
import scala.collection.immutable.Set
import scalaz._, Scalaz._

// End of user code

/**
  * A Slot designates that an entity modeled by an InstanceSpecification has a value or values for a specific StructuralFeature.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLSlotOps[Uml <: UML] { self: UMLSlot[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * The InstanceSpecification that owns this Slot.
    *
    * <!-- Start of user code doc for owningInstance -->
    * <!-- End of user code doc for owningInstance -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInstanceSpecification.slot
    */
  def owningInstance: Option[UMLInstanceSpecification[Uml]] = owner.selectByKindOf { case x: UMLInstanceSpecification[Uml] => x }

  // Start of user code for additional features
  /**
   * TIWG: see UMLUtil, Rule #4
   */
  override def xmiOrderingKey()(implicit idg: IDGenerator[Uml])
  : Set[java.lang.Throwable] \/ String =
    for {
      key <- element_xmiOrderingKey
      f <- definingFeature.fold[Set[java.lang.Throwable] \/ String](
             "_".right
           ){ sf =>
             sf.xmiOrderingKey.map("_" + _)
           }
    } yield key + f
  // End of user code
} //UMLSlotOps
