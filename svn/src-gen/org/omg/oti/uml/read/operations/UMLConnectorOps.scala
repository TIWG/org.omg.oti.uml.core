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
import scala.collection.immutable.::
import scala.collection.immutable.Nil
import scala.collection.immutable.Set
// End of user code

/**
  * A Connector specifies links that enables communication between two or more instances. In contrast to Associations, which specify links between any instance of the associated Classifiers, Connectors specify links between instances playing the connected parts only.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectorOps[Uml <: UML] { self: UMLConnector[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * Indicates the kind of Connector. This is derived: a Connector with one or more ends connected to a Port which is not on a Part and which is not a behavior port is a delegation; otherwise it is an assembly.
    *
    * <!-- Start of user code doc for kind -->
    * <!-- End of user code doc for kind -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * {{{
    * OCL Body result = (if end->exists(
    * 		role.oclIsKindOf(Port) 
    * 		and partWithPort->isEmpty()
    * 		and not role.oclAsType(Port).isBehavior)
    * then ConnectorKind::delegation 
    * else ConnectorKind::assembly 
    * endif)
    * }}}
    */
  def kind: Option[UMLConnectorKind.Value] = {
    // Start of user code for "kind"
    ???
    // End of user code
  }

  /**
    * A Connector may be redefined when its containing Classifier is specialized. The redefining Connector may have a type that specializes the type of the redefined Connector. The types of the ConnectorEnds of the redefining Connector may specialize the types of the ConnectorEnds of the redefined Connector. The properties of the ConnectorEnds of the redefining Connector may be replaced.
    *
    * <!-- Start of user code doc for redefinedConnector -->
    * <!-- End of user code doc for redefinedConnector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.redefinedConnector_connector
    */
  def redefinedConnector: Set[UMLConnector[Uml]] = redefinedElement.selectByKindOf { case x: UMLConnector[Uml] => x }

  /**
    * <!-- Start of user code doc for ownedConnector_structuredClassifier -->
    * <!-- End of user code doc for ownedConnector_structuredClassifier -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLStructuredClassifier.ownedConnector
    */
  def ownedConnector_structuredClassifier: Option[UMLStructuredClassifier[Uml]] = featuringClassifier.selectByKindOf { case x: UMLStructuredClassifier[Uml] => x }

  /**
    * <!-- Start of user code doc for redefinedConnector_connector -->
    * <!-- End of user code doc for redefinedConnector_connector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..*"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.redefinedConnector
    */
  def redefinedConnector_connector: Set[UMLConnector[Uml]] = redefinedElement_redefinableElement.selectByKindOf { case x: UMLConnector[Uml] => x }

  /**
    * The ConnectableElements attached as roles to each ConnectorEnd owned by a Connector must be owned or inherited roles of the Classifier that owned the Connector, or they must be Ports of such roles.
    *
    * <!-- Start of user code doc for validate_roles -->
    * <!-- End of user code doc for validate_roles -->
    *
    * {{{
    * OCL Body structuredClassifier <> null
    * and
    *   end->forAll( e | structuredClassifier.allRoles()->includes(e.role)
    * or
    *   e.role.oclIsKindOf(Port) and structuredClassifier.allRoles()->includes(e.partWithPort))
    * }}}
    */
  def validate_roles: Boolean = {
    // Start of user code for "roles"
    ???
    // End of user code
  }

  /**
    * The types of the ConnectableElements that the ends of a Connector are attached to must conform to the types of the ends of the Association that types the Connector, if any.
    *
    * <!-- Start of user code doc for validate_types -->
    * <!-- End of user code doc for validate_types -->
    *
    * {{{
    * OCL Body type<>null implies 
    *   let noOfEnds : Integer = end->size() in 
    *   (type.memberEnd->size() = noOfEnds) and Sequence{1..noOfEnds}->forAll(i | end->at(i).role.type.conformsTo(type.memberEnd->at(i).type))
    * }}}
    */
  def validate_types: Boolean = {
    // Start of user code for "types"
    ???
    // End of user code
  }

  // Start of user code for additional features
  
  /**
   * PSCS 2015-02-18, 8.5.1.2.4 CS_DefaultConstructStrategy
   * [13] public isArrayPattern(c:Connector) : Boolean
   *  // This is an array pattern if:
   *  // - c is typed by an association FIXME this may no longer be required in UML 2.5
   *  // - c is binary
   *  // - lower bound of the two connector ends is 1
   *  // - Cardinality of ends are equals
   *  if (c.end.size() == 2) {
   *    if (c.end.get(0).role.actualConnectableElement.multiplicityElement.lower == 1) {
   *      if (c.end.get(1).role.actualConnectableElement.multiplicityElement.lower == 1) {
   *        if (this.canInstantiate(c.end.get(0).role.actualConnectableElement) &&
   *            this.canInstantiate(c.end.get(1).role.actualConnectableElement)) {
   *            int cardinality1 = this.getCardinality(c.end.get(0)) ;
   *            int cardinality2 = this.getCardinality(c.end.get(1)) ;
   *            return cardinality1 == cardinality2 ;
   *        }
   *      }
   *    }
   *  }
   *  return false ;
   */
  def pscs_isArrayPattern: Boolean =
    end.toList match {
    case (r1: UMLProperty[Uml]) :: (r2: UMLProperty[Uml]) :: Nil =>
      1 == r1.lower && r1.pscs_canInstantiate &&
      1 == r2.lower && r2.pscs_canInstantiate &&
      r1.pscs_getCardinality == r2.pscs_getCardinality
    case _ =>
      false
  }
  
  /**
   * PSCS 2015-02-18, 8.5.1.2.4 CS_DefaultConstructStrategy
   * [14] public isStarPattern(c:Connector) : Boolean
   *  // This is a star pattern if:
   *  // - c is binary
   *  // - lower bound of end1 equals cardinality of end1
   *  // - lower bound of end2 equals cardinality of end2
   *  if (c.end.size() == 2) {
   *    if (this.canInstantiate(c.end.get(0).role.actualConnectableElement) &&
   *        this.canInstantiate(c.end.get(1).role.actualConnectableElement)) {
   *        int cardinalityOfEnd1 = this.getCardinality(c.end.get(0)) ;
   *        int lowerBoundofEnd1 = c.end.get(0).role.actualConnectableElement.multiplicityElement.lower ;
   *        if (cardinalityOfEnd1 == lowerBoundofEnd1) {
   *          int cardinalityOfEnd2 = this.getCardinality(c.end.get(1)) ;
   *          int lowerBoundofEnd2 = c.end.get(1).role.actualConnectableElement.multiplicityElement.lower ;
   *          return cardinalityOfEnd2 == lowerBoundofEnd2 ;
   *        }
   *    }
   *  }
   *  return false ;
   */
  def pscs_isStarPattern: Boolean =
    end.toList match {
    case (r1: UMLProperty[Uml]) :: (r2: UMLProperty[Uml]) :: Nil =>
      r1.pscs_canInstantiate &&
      r2.pscs_canInstantiate &&
      r1.pscs_getCardinality == Option.apply(r1.lower) &&
      r2.pscs_getCardinality == Option.apply(r2.lower)
    case _ =>
      false
  }    
  
  // End of user code
} //UMLConnectorOps
