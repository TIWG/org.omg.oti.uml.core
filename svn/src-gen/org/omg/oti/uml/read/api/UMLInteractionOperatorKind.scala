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

package org.omg.oti.uml.read.api

import scala.Enumeration

/**
  * InteractionOperatorKind is an enumeration designating the different kinds of operators of CombinedFragments. The InteractionOperand defines the type of operator of a CombinedFragment.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
object UMLInteractionOperatorKind extends Enumeration {
  
  /**
    * The enumeration type
    *
    * <!-- Start of user code doc for metaAttributes -->
    * <!-- End of user code doc for metaAttributes -->
    */
  type UMLInteractionOperatorKind = Value

  /**
    * The InteractionOperatorKind alt designates that the CombinedFragment represents a choice of behavior. At most one of the operands will be chosen. The chosen operand must have an explicit or implicit guard expression that evaluates to true at this point in the interaction. An implicit true guard is implied if the operand has no guard.
    *
    * <!-- Start of user code doc for alt -->
    * <!-- End of user code doc for alt -->
    */
  val alt = Value

  /**
    * The InteractionOperatorKind assert designates that the CombinedFragment represents an assertion. The sequences of the operand of the assertion are the only valid continuations. All other continuations result in an invalid trace.
    *
    * <!-- Start of user code doc for assert -->
    * <!-- End of user code doc for assert -->
    */
  val assert = Value

  /**
    * The InteractionOperatorKind break designates that the CombinedFragment represents a breaking scenario in the sense that the operand is a scenario that is performed instead of the remainder of the enclosing InteractionFragment. A break operator with a guard is chosen when the guard is true and the rest of the enclosing Interaction Fragment is ignored. When the guard of the break operand is false, the break operand is ignored and the rest of the enclosing InteractionFragment is chosen. The choice between a break operand without a guard and the rest of the enclosing InteractionFragment is done non-deterministically.
    *
    * <!-- Start of user code doc for break -->
    * <!-- End of user code doc for break -->
    */
  val break = Value

  /**
    * The InteractionOperatorKind consider designates which messages should be considered within this combined fragment. This is equivalent to defining every other message to be ignored.
    *
    * <!-- Start of user code doc for consider -->
    * <!-- End of user code doc for consider -->
    */
  val consider = Value

  /**
    * The InteractionOperatorKind critical designates that the CombinedFragment represents a critical region. A critical region means that the traces of the region cannot be interleaved by other OccurrenceSpecifications (on those Lifelines covered by the region). This means that the region is treated atomically by the enclosing fragment when determining the set of valid traces. Even though enclosing CombinedFragments may imply that some OccurrenceSpecifications may interleave into the region, such as with par-operator, this is prevented by defining a region.
    *
    * <!-- Start of user code doc for critical -->
    * <!-- End of user code doc for critical -->
    */
  val critical = Value

  /**
    * The InteractionOperatorKind ignore designates that there are some message types that are not shown within this combined fragment. These message types can be considered insignificant and are implicitly ignored if they appear in a corresponding execution. Alternatively, one can understand ignore to mean that the message types that are ignored can appear anywhere in the traces.
    *
    * <!-- Start of user code doc for ignore -->
    * <!-- End of user code doc for ignore -->
    */
  val ignore = Value

  /**
    * The InteractionOperatorKind loop designates that the CombinedFragment represents a loop. The loop operand will be repeated a number of times.
    *
    * <!-- Start of user code doc for loop -->
    * <!-- End of user code doc for loop -->
    */
  val loop = Value

  /**
    * The InteractionOperatorKind neg designates that the CombinedFragment represents traces that are defined to be invalid.
    *
    * <!-- Start of user code doc for neg -->
    * <!-- End of user code doc for neg -->
    */
  val neg = Value

  /**
    * The InteractionOperatorKind opt designates that the CombinedFragment represents a choice of behavior where either the (sole) operand happens or nothing happens. An option is semantically equivalent to an alternative CombinedFragment where there is one operand with non-empty content and the second operand is empty.
    *
    * <!-- Start of user code doc for opt -->
    * <!-- End of user code doc for opt -->
    */
  val opt = Value

  /**
    * The InteractionOperatorKind par designates that the CombinedFragment represents a parallel merge between the behaviors of the operands. The OccurrenceSpecifications of the different operands can be interleaved in any way as long as the ordering imposed by each operand as such is preserved.
    *
    * <!-- Start of user code doc for par -->
    * <!-- End of user code doc for par -->
    */
  val par = Value

  /**
    * The InteractionOperatorKind seq designates that the CombinedFragment represents a weak sequencing between the behaviors of the operands.
    *
    * <!-- Start of user code doc for seq -->
    * <!-- End of user code doc for seq -->
    */
  val seq = Value

  /**
    * The InteractionOperatorKind strict designates that the CombinedFragment represents a strict sequencing between the behaviors of the operands. The semantics of strict sequencing defines a strict ordering of the operands on the first level within the CombinedFragment with interactionOperator strict. Therefore OccurrenceSpecifications within contained CombinedFragment will not directly be compared with other OccurrenceSpecifications of the enclosing CombinedFragment.
    *
    * <!-- Start of user code doc for strict -->
    * <!-- End of user code doc for strict -->
    */
  val strict = Value
}
