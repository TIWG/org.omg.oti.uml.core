/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
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
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a ConnectableElement.
 *
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
trait UMLConnectorEndOps[Uml <: UML] { self: UMLConnectorEnd[Uml] =>	

	import self.ops._

	/**
	 * A derived property referencing the corresponding end on the Association which types the Connector owing this ConnectorEnd, if any. It is derived by selecting the end at the same place in the ordering of Association ends as this ConnectorEnd.
	 *
	 * <!-- Start of user code doc for definingEnd -->
	 * <!-- End of user code doc for definingEnd -->
	 *
	 * @property derived="true" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLProperty.definingEnd_connectorEnd
	 * @body result = (if connector.type = null 
	 * then
	 *   null 
	 * else
	 *   let index : Integer = connector.end->indexOf(self) in
	 *     connector.type.memberEnd->at(index)
	 * endif)
	 */
	def definingEnd: Option[UMLProperty[Uml]] = {
		// Start of user code for "definingEnd"
    ???
    // End of user code
	}

	/**
	 * <!-- Start of user code doc for end_connector -->
	 * <!-- End of user code doc for end_connector -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="1..1"
	 * @opposite org.omg.oti.api.UMLConnector.end
	 */
	def end_connector: Option[UMLConnector[Uml]] = owner.selectByKindOf { case x: UMLConnector[Uml] => x }

	/**
	 * The multiplicity of the ConnectorEnd may not be more general than the multiplicity of the corresponding end of the Association typing the owning Connector, if any.
	 *
	 * <!-- Start of user code doc for validate_multiplicity -->
	 * <!-- End of user code doc for validate_multiplicity -->
	 *
	 * @body self.compatibleWith(definingEnd)
	 */
	def validate_multiplicity: Boolean = {
		// Start of user code for "multiplicity"
    ???
    // End of user code
	}

	/**
	 * If a ConnectorEnd is attached to a Port of the containing Classifier, partWithPort will be empty.
	 *
	 * <!-- Start of user code doc for validate_part_with_port_empty -->
	 * <!-- End of user code doc for validate_part_with_port_empty -->
	 *
	 * @body (role.oclIsKindOf(Port) and role.owner = connector.owner) implies partWithPort->isEmpty()
	 */
	def validate_part_with_port_empty: Boolean = {
		// Start of user code for "part_with_port_empty"
    ???
    // End of user code
	}

	/**
	 * If a ConnectorEnd references a partWithPort, then the role must be a Port that is defined or inherited by the type of the partWithPort.
	 *
	 * <!-- Start of user code doc for validate_role_and_part_with_port -->
	 * <!-- End of user code doc for validate_role_and_part_with_port -->
	 *
	 * @body partWithPort->notEmpty() implies 
	 *   (role.oclIsKindOf(Port) and partWithPort.type.oclAsType(Namespace).member->includes(role))
	 */
	def validate_role_and_part_with_port: Boolean = {
		// Start of user code for "role_and_part_with_port"
    ???
    // End of user code
	}

	/**
	 * The Property held in self.partWithPort must not be a Port.
	 *
	 * <!-- Start of user code doc for validate_self_part_with_port -->
	 * <!-- End of user code doc for validate_self_part_with_port -->
	 *
	 * @body partWithPort->notEmpty() implies not partWithPort.oclIsKindOf(Port)
	 */
	def validate_self_part_with_port: Boolean = {
		// Start of user code for "self_part_with_port"
    ???
    // End of user code
	}

	// Start of user code for additional features

  /**
   * PSCS, 2015-02-18, 8.5.1.2.4 CS_DefaultConstructStrategy
   *
   * [8] public getCardinality(end:ConnectorEnd) : Integer
   *  int lowerOfRole = end.role.actualConnectableElement.multiplicityElement.lower ;
   *  if (lowerOfRole == 0) {
   *    return 0 ;
   *  }
   *  else if (end.partWithPort == null) {
   *    return lowerOfRole ;
   *  }
   *  else {
   *    int lowerOfPart = end.partWithPort.multiplicityElement.lower ;
   *    return lowerOfRole * lowerOfPart ;
   *  }
   */
  def pscs_getCardinality: Option[Integer] =
    role match {
      case Some( r: UMLConnectableElement[Uml] with UMLMultiplicityElement[Uml] ) =>
        if ( 0 == r.lower ) Some( 0 )
        else partWithPort match {
          case None      => Some( r.lower )
          case Some( p ) => Some( r.lower * p.lower )
        }
      case _ => None
    }

  // End of user code
} //UMLConnectorEndOps
