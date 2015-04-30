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
package org.omg.oti.operations

// Start of user code for imports
import org.omg.oti.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
// End of user code

/**
 * <!-- begin-model-doc -->
 * An ActivityParameterNode is an ObjectNode for accepting values from the input Parameters or providing values to the output Parameters of an Activity.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLActivityParameterNodeOps[Uml <: UML] { self: UMLActivityParameterNode[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * The parameter of an ActivityParameterNode must be from the containing Activity.
	 * <!-- end-model-doc -->
	 *
	 * @body activity.ownedParameter->includes(parameter)
	 */
	def validate_has_parameters: Boolean  = {
		// Start of user code for "has_parameters"
    	activity match {
        case None => false
        case Some(act) => parameter match {
          case None => false
          case Some(p) => act.ownedParameter.contains(p)
        }
      }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An ActivityParameterNode may have all incoming ActivityEdges or all outgoing ActivityEdges, but it must not have both incoming and outgoing ActivityEdges.
	 * <!-- end-model-doc -->
	 *
	 * @body incoming->isEmpty() or outgoing->isEmpty()
	 */
	def validate_no_edges: Boolean  = {
		// Start of user code for "no_edges"
    	incoming.isEmpty || outgoing.isEmpty
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An ActivityParameterNode with no incoming ActivityEdges and one or more outgoing ActivityEdges must have a parameter with direction in or inout.
	 * <!-- end-model-doc -->
	 *
	 * @body (outgoing->notEmpty() and incoming->isEmpty()) implies 
	 * 	(parameter.direction = ParameterDirectionKind::_'in' or 
	 * 	 parameter.direction = ParameterDirectionKind::inout)
	 */
	def validate_no_incoming_edges: Boolean  = {
		// Start of user code for "no_incoming_edges"
    ??? // == okay?
    if (!outgoing.isEmpty && incoming.isEmpty) {
      parameter match {
        case None => true
        case Some(p) => 
          p.direction == UMLParameterDirectionKind.in || 
          p.direction == UMLParameterDirectionKind.inout
      }
    } else true
  	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * An ActivityParameterNode with no outgoing ActivityEdges and one or more incoming ActivityEdges must have a parameter with direction out, inout, or return.
	 * <!-- end-model-doc -->
	 *
	 * @body (incoming->notEmpty() and outgoing->isEmpty()) implies 
	 * 	(parameter.direction = ParameterDirectionKind::out or 
	 * 	 parameter.direction = ParameterDirectionKind::inout or 
	 * 	 parameter.direction = ParameterDirectionKind::return)
	 */
	def validate_no_outgoing_edges: Boolean  = {
		// Start of user code for "no_outgoing_edges"
    	if (!incoming.isEmpty && outgoing.isEmpty) {
        parameter match {
          case None => true
          case Some(p) => 
            p.direction == UMLParameterDirectionKind.out ||
            p.direction == UMLParameterDirectionKind.inout ||
            p.direction == UMLParameterDirectionKind._return
        }
      } else true
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type of an ActivityParameterNode is the same as the type of its parameter.
	 * <!-- end-model-doc -->
	 *
	 * @body type = parameter.type
	 */
	def validate_same_type: Boolean  = {
		// Start of user code for "same_type"
    parameter match {
      case None => false
      case Some(p) => _type == p._type
    }
  	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLActivityParameterNode
