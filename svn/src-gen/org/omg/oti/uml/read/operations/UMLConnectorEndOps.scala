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
import scala.Predef.Integer2int
import scala.{Option,None,Some}
import scala.Predef._
import java.lang.Integer
// End of user code

/**
  * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLConnectorEndOps[Uml <: UML] { self: UMLConnectorEnd[Uml] =>

// Start of user code for class imports
  import self.ops._
// End of user code


  /**
    * A derived property referencing the corresponding end on the Association which types the Connector owing this ConnectorEnd, if any. It is derived by selecting the end at the same place in the ordering of Association ends as this ConnectorEnd.
    *
    * <!-- Start of user code doc for definingEnd -->
    * <!-- End of user code doc for definingEnd -->
    *
    * UML Property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLProperty.definingEnd_connectorEnd
    * {{{
    * OCL Body result = (if connector.type = null 
    * then
    *   null 
    * else
    *   let index : Integer = connector.end->indexOf(self) in
    *     connector.type.memberEnd->at(index)
    * endif)
    * }}}
    */
  def definingEnd: Option[UMLProperty[Uml]] = {
    // Start of user code for "definingEnd"
    end_connector match {
      case Some(c) =>
        c._type match {
          case Some(a: UMLAssociation[Uml]) =>
            c.end.indexOf(self) match {
              case -1 =>
                None
              case i  =>
                require(i < a.memberEnd.size)
                Some(a.memberEnd(i))
            }
          case _                            =>
            None
        }
      case None    =>
        None
    }
    // End of user code
  }

  /**
    * <!-- Start of user code doc for end_connector -->
    * <!-- End of user code doc for end_connector -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLConnector.end
    */
  def end_connector: Option[UMLConnector[Uml]] = owner.selectByKindOf { case x: UMLConnector[Uml] => x }

  /**
    * The multiplicity of the ConnectorEnd may not be more general than the multiplicity of the corresponding end of the Association typing the owning Connector, if any.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body self.compatibleWith(definingEnd)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    self.compatibleWith(definingEnd)
    // End of user code
  }

  /**
    * If a ConnectorEnd is attached to a Port of the containing Classifier, partWithPort will be empty.
    *
    * <!-- Start of user code doc for validate_part_with_port_empty -->
    * <!-- End of user code doc for validate_part_with_port_empty -->
    *
    * {{{
    * OCL Body (role.oclIsKindOf(Port) and role.owner = connector.owner) implies partWithPort->isEmpty()
    * }}}
    */
  def validate_part_with_port_empty: Boolean = {
    // Start of user code for "part_with_port_empty"
    (role, end_connector) match {
      case (Some(r: UMLPort[Uml]), Some(c)) =>
        r.owner != c.owner || partWithPort.isEmpty
      case _                                =>
        true
    }
    // End of user code
  }

  /**
    * If a ConnectorEnd references a partWithPort, then the role must be a Port that is defined or inherited by the type of the partWithPort.
    *
    * <!-- Start of user code doc for validate_role_and_part_with_port -->
    * <!-- End of user code doc for validate_role_and_part_with_port -->
    *
    * {{{
    * OCL Body partWithPort->notEmpty() implies 
    *   (role.oclIsKindOf(Port) and partWithPort.type.oclAsType(Namespace).member->includes(role))
    * }}}
    */
  def validate_role_and_part_with_port: Boolean = {
    // Start of user code for "role_and_part_with_port"
    partWithPort match {
      case Some(p) =>
        role match {
          case Some(r: UMLPort[Uml]) =>
            p._type match {
              case Some(pc: UMLClassifier[Uml]) =>
                pc.member.contains(r)
              case _                            =>
                true
            }
          case _                     =>
            true
        }
      case None    => true
    }
    // End of user code
  }

  /**
    * The Property held in self.partWithPort must not be a Port.
    *
    * <!-- Start of user code doc for validate_self_part_with_port -->
    * <!-- End of user code doc for validate_self_part_with_port -->
    *
    * {{{
    * OCL Body partWithPort->notEmpty() implies not partWithPort.oclIsKindOf(Port)
    * }}}
    */
  def validate_self_part_with_port: Boolean = {
    // Start of user code for "self_part_with_port"
    partWithPort match {
      case Some(p: UMLPort[Uml]) => true
      case Some(_)               => false
      case None                  => true
    }
    // End of user code
  }

  // Start of user code for additional features

  /**
   * PSCS, 2015-02-18, 8.5.1.2.4 CS_DefaultConstructStrategy
   *
   * [8] public getCardinality(end:ConnectorEnd) : Integer
   * int lowerOfRole = end.role.actualConnectableElement.multiplicityElement.lower ;
   * if (lowerOfRole == 0) {
   * return 0 ;
   * }
   * else if (end.partWithPort == null) {
   * return lowerOfRole ;
   * }
   * else {
   * int lowerOfPart = end.partWithPort.multiplicityElement.lower ;
   * return lowerOfRole * lowerOfPart ;
   * }
   */
  def pscs_getCardinality: Option[Integer] =
    role match {
      case Some(r: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml]) =>
        if (0 == r.lower) Some(0)
        else partWithPort match {
          case None    => Some(r.lower)
          case Some(p) => Some(r.lower * p.lower)
        }
      case _                                                                    => None
    }

  // End of user code
} //UMLConnectorEndOps
