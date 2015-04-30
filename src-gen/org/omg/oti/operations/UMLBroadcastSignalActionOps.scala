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
 * A BroadcastSignalAction is an InvocationAction that transmits a Signal instance to all the potential target objects in the system. Values from the argument InputPins are used to provide values for the attributes of the Signal. The requestor continues execution immediately after the Signal instances are sent out and cannot receive reply values.
 * <!-- end-model-doc -->
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLBroadcastSignalActionOps[Uml <: UML] { self: UMLBroadcastSignalAction[Uml] =>	

	import self.ops._

	/**
	 * <!-- begin-model-doc -->
	 * A BroadcaseSignalAction may not specify onPort.
	 * <!-- end-model-doc -->
	 *
	 * @body onPort=null
	 */
	def validate_no_onport: Boolean  = {
		// Start of user code for "no_onport"
    	onPort match {
        case Some(_) => false
        case None => true
      }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The number of argument InputPins must be the same as the number of attributes in the signal.
	 * <!-- end-model-doc -->
	 *
	 * @body argument->size() = signal.allAttributes()->size()
	 */
	def validate_number_of_arguments: Boolean  = {
		// Start of user code for "number_of_arguments"
    signal match {
      case Some(sig) => sig.allAttributes.size == argument.size
      case None => false
    }
    	// End of user code
	}

	/**
	 * <!-- begin-model-doc -->
	 * The type, ordering, and multiplicity of an argument InputPin must be the same as the corresponding attribute of the signal.
	 * <!-- end-model-doc -->
	 *
	 * @body let attribute: OrderedSet(Property) = signal.allAttributes() in
	 * Sequence{1..argument->size()}->forAll(i | 
	 * 	argument->at(i).type.conformsTo(attribute->at(i).type) and 
	 * 	argument->at(i).isOrdered = attribute->at(i).isOrdered and
	 * 	argument->at(i).compatibleWith(attribute->at(i)))
	 */
	def validate_type_ordering_multiplicity: Boolean  = { ??? //seq start and end as well as conforms to
		// Start of user code for "type_ordering_multiplicity"
    	val attribute: Seq[UMLProperty[Uml]] = signal.get.allAttributes.distinct
      (0 until argument.size).forall { i => 
        argument(i)._type == attribute(i)._type &&
        argument(i).isOrdered == attribute(i).isOrdered &&
        argument(i).compatibleWith(Some(attribute(i))) }
    	// End of user code
	}

	// Start of user code for additional features
	// End of user code

} //UMLBroadcastSignalAction
